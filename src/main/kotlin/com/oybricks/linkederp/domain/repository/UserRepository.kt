package com.oybricks.linkederp.domain.repository

import com.oybricks.linkederp.domain.model.User
import mu.KotlinLogging
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.stereotype.Repository

private val logger = KotlinLogging.logger {}

@Repository
class UserRepository {

    @Autowired
    lateinit var namedParameterJdbcTemplate: NamedParameterJdbcTemplate
    fun save(user: User): User {
        logger.debug { "[Repository] - Saving user..." }
        val sql = """
            
            INSERT INTO users (
                uuid,
                username,
                password,
                personal_data_id,
                role,
                is_active,
                created_at,
                updated_at)
            VALUES (
                uuid(),
                :username,
                :password,
                :personal_data_id,
                :role,
                :is_active,
                current_timestamp,
                current_timestamp
            )
            
        """.trimIndent()
        val userId = this.namedParameterJdbcTemplate.update(
            sql,
            MapSqlParameterSource()
                .addValue("username", user.userName)
                .addValue("password", user.password)
                .addValue("personal_data_id", user.personalData.id)
                .addValue("role", user.role.name)
                .addValue("is_active", user.isActive)
        )
        user.id = userId.toLong()
        logger.debug { "[Repository] - User saved with success!" }
        return user
    }

    // TODO update
    // TODO get personal data by id
    // TODO get personal data by name
    // TODO delete
}
