package com.example.data.local

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(tableName = "projects")
data class ProjectEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val title: String,
    val challengeCode: String,
    val description: String,
    val areaCode: String,
    val createdAt: Long = System.currentTimeMillis(),
    val updatedAt: Long = System.currentTimeMillis(),
    val status: String = "IN_PROGRESS",
    val totalXp: Int = 0,
    val privacyLevel: String = "PRIVATE" // PRIVATE, PUBLIC, SHARED
)

@Entity(
    tableName = "project_card_entries",
    foreignKeys = [
        ForeignKey(
            entity = ProjectEntity::class,
            parentColumns = ["id"],
            childColumns = ["projectId"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [Index("projectId"), Index(value = ["projectId", "cardCode"], unique = true)]
)
data class ProjectCardEntryEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val projectId: Long,
    val cardCode: String,
    val isCompleted: Boolean = false,
    val fieldDataJson: String = "{}", // Map of fieldLabel -> value
    val updatedAt: Long = System.currentTimeMillis()
)

@Entity(tableName = "diario_de_bordo")
data class DiarioDeBordoEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val projectId: Long,
    val eventType: String,
    val description: String,
    val timestamp: Long = System.currentTimeMillis()
)

@Entity(tableName = "user_profile")
data class UserProfileEntity(
    @PrimaryKey val id: Int = 1,
    val name: String = "Explorador Questbox",
    val roleCode: String = "P5",
    val areaCode: String = "AR5",
    val totalXp: Int = 0,
    val level: Int = 1,
    val attrSentir: Int = 3,
    val attrPensar: Int = 3,
    val attrAgir: Int = 2,
    val attrVisaoInterna: Int = 3,
    val attrVisaoExterna: Int = 2,
    val attrVisaoIntegral: Int = 2
)
