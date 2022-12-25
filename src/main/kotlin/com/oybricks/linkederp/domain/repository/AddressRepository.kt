package com.oybricks.linkederp.domain.repository

import com.oybricks.linkederp.domain.model.Address
import mu.KotlinLogging
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.stereotype.Repository

private val logger = KotlinLogging.logger {}

@Repository
class AddressRepository {

    @Autowired
    lateinit var namedParameterJdbcTemplate: NamedParameterJdbcTemplate
    fun save(address: Address): Address {
        logger.debug { "[Repository] - Saving address..." }
        val sql = """
            INSERT INTO
              address (
                street_name,
                complement,
                neighborhood,
                city,
                state,
                country,
                zip_code,
                main_address,
                created_at,
                updated_at
              )
            values
              (
                :streetName,
                :complement,
                :neighborhood,
                :city,
                :state,
                :country,
                :zipCode,
                :mainAddress,
                current_timestamp,
                current_timestamp
              )

        """.trimIndent()
        val addressId = this.namedParameterJdbcTemplate.update(
            sql,
            MapSqlParameterSource()
                .addValue("streetName", address.street)
                .addValue("complement", address.complement)
                .addValue("neighborhood", address.neighborhood)
                .addValue("city", address.city)
                .addValue("state", address.state)
                .addValue("country", address.country)
                .addValue("zipCode", address.zipCode)
                .addValue("mainAddress", address.mainAddress)
        )

        address.id = addressId.toLong()
        logger.debug { "[Repository] - Address saved with success!" }
        return address
    }

    fun update(id: Long, address: Address): Address {
        logger.debug { "[Repository] - Updating address..." }
        val sql = """
            UPDATE address SET
            street_name,
                complement = :complement,
                neighborhood = :neighborhood,
                city = :city,
                state = :state,
                country = :country,
                zip_code = :zipCode,
                main_address = :mainAddress
            where id = :id         
        """.trimIndent()

        this.namedParameterJdbcTemplate.update(
            sql,
            MapSqlParameterSource()
                .addValue("streetName", address.street)
                .addValue("complement", address.complement)
                .addValue("neighborhood", address.neighborhood)
                .addValue("city", address.city)
                .addValue("state", address.state)
                .addValue("country", address.country)
                .addValue("zipCode", address.zipCode)
                .addValue("mainAddress", address.mainAddress)
                .addValue("id", id)
        )

        logger.debug { "[Repository] - Address updated with success..." }
        return address
    }

    // TODO -> get by id
    // TODO -> delete
}
