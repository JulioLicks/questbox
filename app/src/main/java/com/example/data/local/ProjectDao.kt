package com.example.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface ProjectDao {

    @Query("SELECT * FROM projects ORDER BY updatedAt DESC")
    fun getAllProjects(): Flow<List<ProjectEntity>>

    @Query("SELECT * FROM projects WHERE id = :id")
    fun getProjectById(id: Long): Flow<ProjectEntity?>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProject(project: ProjectEntity): Long

    @Update
    suspend fun updateProject(project: ProjectEntity)

    @Query("DELETE FROM projects WHERE id = :id")
    suspend fun deleteProjectById(id: Long)

    @Query("SELECT * FROM project_card_entries WHERE projectId = :projectId")
    fun getCardEntriesForProject(projectId: Long): Flow<List<ProjectCardEntryEntity>>

    @Query("SELECT * FROM project_card_entries WHERE projectId = :projectId AND cardCode = :cardCode LIMIT 1")
    suspend fun getCardEntry(projectId: Long, cardCode: String): ProjectCardEntryEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrUpdateCardEntry(entry: ProjectCardEntryEntity)

    @Query("SELECT * FROM user_profile WHERE id = 1 LIMIT 1")
    fun getUserProfile(): Flow<UserProfileEntity?>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrUpdateProfile(profile: UserProfileEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDiarioEntry(entry: DiarioDeBordoEntity)

    @Query("SELECT * FROM diario_de_bordo WHERE projectId = :projectId ORDER BY timestamp DESC")
    fun getDiarioEntriesForProject(projectId: Long): Flow<List<DiarioDeBordoEntity>>
}
