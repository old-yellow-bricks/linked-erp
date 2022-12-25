package com.oybricks.linkederp.config

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import mu.KotlinLogging
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.jdbc.datasource.DataSourceTransactionManager
import javax.sql.DataSource

private val logger = KotlinLogging.logger {}

@Configuration
class DataBaseConfig {

    @Value("\${spring.profiles.active}")
    lateinit var profile: String

    @Value("\${spring.datasource.username}")
    lateinit var username: String

    @Value("\${spring.datasource.password}")
    lateinit var password: String

    @Value("\${spring.datasource.url}")
    lateinit var url: String

    @Value("\${spring.datasource.classname}")
    lateinit var className: String

    var connectionTimeOut: Long = 120000L

    /**
     * Will control all the JDBC Connections
     */
    @Bean(name = ["dataBase"])
    fun hikariConfig(): HikariConfig {
        val hikariConfig = HikariConfig()
        logger.info { "Starting DB Connection..." }
        logger.debug { "Database..: $url " }
        logger.debug { "User......: $username " }

        hikariConfig.username = username
        hikariConfig.password = password
        hikariConfig.jdbcUrl = url
        hikariConfig.driverClassName = className
        hikariConfig.connectionTimeout = connectionTimeOut
        return hikariConfig
    }

    @Bean(name = ["dataSource"])
    fun dataSource(@Qualifier("dataBase") hikariConfig: HikariConfig): DataSource {
        return HikariDataSource(hikariConfig)
    }

    @Bean(name = ["jdbcTemplate"])
    fun jdbcTemplate(@Qualifier("dataSource") dataSource: DataSource): JdbcTemplate {
        return JdbcTemplate(dataSource)
    }

    @Bean(name = ["namedParameterJdbcTemplate"])
    fun namedParameterJdbcTemplate(@Qualifier("dataSource") dataSource: DataSource): NamedParameterJdbcTemplate {
        return NamedParameterJdbcTemplate(dataSource)
    }

    @Bean(name = ["transactional"])
    fun dataSourceTransactionalManager(@Qualifier("dataSource") dataSource: DataSource): DataSourceTransactionManager {
        return DataSourceTransactionManager(dataSource)
    }
}
