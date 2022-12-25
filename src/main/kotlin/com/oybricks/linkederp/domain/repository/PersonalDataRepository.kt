package com.oybricks.linkederp.domain.repository

import com.oybricks.linkederp.domain.model.PersonalData
import mu.KotlinLogging
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.stereotype.Repository

private val logger = KotlinLogging.logger {}

@Repository
class PersonalDataRepository {

    @Autowired
    lateinit var namedParameterJdbcTemplate: NamedParameterJdbcTemplate

    fun save(personalData: PersonalData, addressId: Long): PersonalData {
        logger.debug { "[Repository] - Saving personal Data..." }

        val sql = """
            
            INSERT INTO personal_data (
                first_name,
                sur_name,
                date_of_birth,
                email_address,
                phone_number,
                address_id,
                created_at,
                updated_at)
            VALUES (
                :firstName,
                :surName,
                :dateOfBirth,
                :emailAddress,
                :phoneNumber,
                :addressId,
                current_timestamp,
                current_timestamp
            )           
        """.trimIndent()

        val personalDataId = this.namedParameterJdbcTemplate.update(
            sql,
            MapSqlParameterSource()
                .addValue("firstName", personalData.name)
                .addValue("surName", personalData.surName)
                .addValue("dateOfBirth", personalData.dateOfBirth)
                .addValue("emailAddress", personalData.emailAddress)
                .addValue("phoneNumber", personalData.phoneNumber)
                .addValue("addressId", addressId)
        )
        personalData.id = personalDataId.toLong()
        logger.debug { "[Repository] - Personal Data saved with success..." }
        return personalData
    }

    // TODO update
    // TODO get personal data by id
    // TODO get personal data by name
    // TODO delete
}
