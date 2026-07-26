package com.example.data.repository

import com.example.data.local.DiarioDeBordoEntity
import com.example.data.local.ProjectCardEntryEntity
import com.example.data.local.ProjectDao
import com.example.data.local.ProjectEntity
import com.example.data.local.UserProfileEntity
import com.example.data.model.QuestboxData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.firstOrNull
import org.json.JSONObject

class ProjectRepository(private val projectDao: ProjectDao) {

    fun getAllProjects(): Flow<List<ProjectEntity>> = projectDao.getAllProjects()

    fun getProjectById(projectId: Long): Flow<ProjectEntity?> = projectDao.getProjectById(projectId)

    fun getCardEntriesForProject(projectId: Long): Flow<List<ProjectCardEntryEntity>> =
        projectDao.getCardEntriesForProject(projectId)

    fun getDiarioEntriesForProject(projectId: Long): Flow<List<DiarioDeBordoEntity>> =
        projectDao.getDiarioEntriesForProject(projectId)

    suspend fun createProject(
        title: String,
        challengeCode: String,
        description: String,
        areaCode: String,
        initialCardCodes: List<String>,
        drafts: Map<String, String> = emptyMap()
    ): Long {
        val newProject = ProjectEntity(
            title = title,
            challengeCode = challengeCode,
            description = description,
            areaCode = areaCode,
            totalXp = 0
        )

        val projectId = projectDao.insertProject(newProject)

        // Seed initial project card entries based on challenge required cards or custom list
        val cardList = if (initialCardCodes.isNotEmpty()) {
            initialCardCodes
        } else {
            QuestboxData.CHALLENGES.find { it.code == challengeCode }?.requiredCardCodes
                ?: listOf("F1", "F2", "F3", "F19", "F20", "F24", "F43")
        }

        cardList.forEach { cardCode ->
            val draft = drafts[cardCode]
            val initialJson = if (!draft.isNullOrBlank()) {
                val obj = JSONObject()
                obj.put("Campo Principal", draft)
                obj.toString()
            } else {
                "{}"
            }

            val entry = ProjectCardEntryEntity(
                projectId = projectId,
                cardCode = cardCode,
                isCompleted = false,
                fieldDataJson = initialJson
            )
            projectDao.insertOrUpdateCardEntry(entry)
        }

        return projectId
    }

    suspend fun saveCardEntry(
        projectId: Long,
        cardCode: String,
        isCompleted: Boolean,
        fieldData: Map<String, String>
    ) {
        val jsonObj = JSONObject()
        fieldData.forEach { (key, value) ->
            jsonObj.put(key, value)
        }

        val existing = projectDao.getCardEntry(projectId, cardCode)
        val entry = existing?.copy(
            isCompleted = isCompleted,
            fieldDataJson = jsonObj.toString(),
            updatedAt = System.currentTimeMillis()
        ) ?: ProjectCardEntryEntity(
            projectId = projectId,
            cardCode = cardCode,
            isCompleted = isCompleted,
            fieldDataJson = jsonObj.toString()
        )

        projectDao.insertOrUpdateCardEntry(entry)

        // Recalculate project total XP and award user profile XP
        recalculateProjectXp(projectId)

        // Log to Diario de Bordo
        val eventType = if (isCompleted) "CONCLUSÃO" else "ATUALIZAÇÃO"
        val desc = "Card $cardCode foi ${if (isCompleted) "concluído" else "atualizado"}."
        logDiarioEvent(projectId, eventType, desc)
    }

    suspend fun logDiarioEvent(projectId: Long, eventType: String, description: String) {
        val entry = DiarioDeBordoEntity(
            projectId = projectId,
            eventType = eventType,
            description = description
        )
        projectDao.insertDiarioEntry(entry)
    }

    private suspend fun recalculateProjectXp(projectId: Long) {
        val entries = projectDao.getCardEntriesForProject(projectId).firstOrNull() ?: emptyList()
        val completedCodes = entries.filter { it.isCompleted }.map { it.cardCode }

        val gainedXp = completedCodes.sumOf { code ->
            QuestboxData.TOOL_CARDS.find { it.code == code }?.xpPoints ?: 5
        }

        val currentProj = projectDao.getProjectById(projectId).firstOrNull()
        if (currentProj != null) {
            val updatedProj = currentProj.copy(
                totalXp = gainedXp,
                updatedAt = System.currentTimeMillis()
            )
            projectDao.updateProject(updatedProj)
        }

        // Award XP to user profile
        addXpPoints(5)
    }

    suspend fun addCardToProject(projectId: Long, cardCode: String) {
        val existing = projectDao.getCardEntry(projectId, cardCode)
        if (existing == null) {
            projectDao.insertOrUpdateCardEntry(
                ProjectCardEntryEntity(
                    projectId = projectId,
                    cardCode = cardCode,
                    isCompleted = false,
                    fieldDataJson = "{}"
                )
            )
        }
    }

    suspend fun deleteProject(projectId: Long) {
        projectDao.deleteProjectById(projectId)
    }

    fun getUserProfile(): Flow<UserProfileEntity?> = projectDao.getUserProfile()

    suspend fun ensureProfileExists(): UserProfileEntity {
        val profile = projectDao.getUserProfile().firstOrNull()
        return if (profile == null) {
            val defaultProfile = UserProfileEntity()
            projectDao.insertOrUpdateProfile(defaultProfile)
            defaultProfile
        } else {
            profile
        }
    }

    suspend fun updateUserProfile(profile: UserProfileEntity) {
        projectDao.insertOrUpdateProfile(profile)
    }

    suspend fun addXpPoints(pointsGained: Int) {
        val profile = ensureProfileExists()
        val newXp = profile.totalXp + pointsGained
        // Level up every 100 XP
        val newLevel = (newXp / 100) + 1
        projectDao.insertOrUpdateProfile(
            profile.copy(
                totalXp = newXp,
                level = newLevel
            )
        )
    }
}
