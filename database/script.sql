CREATE TABLE `address` (
               `id` BIGINT NOT NULL AUTO_INCREMENT,
               `street_name` CHAR(100) NOT NULL,
               `complement` CHAR(30),
               `neighborhood` CHAR(20) NOT NULL,
               `city` CHAR(20) NOT NULL,
               `state` CHAR(20),
               `country` CHAR(20) NOT NULL,
               `zip_code` CHAR(10) NOT NULL,
               `main_address` BOOLEAN NOT NULL,
               `created_at` TIMESTAMP NOT NULL,
               `updated_at` TIMESTAMP ON UPDATE CURRENT_TIMESTAMP NOT NULL,
               PRIMARY KEY (`id`)
);

CREATE TABLE `personal_data` (
             `id` BIGINT NOT NULL AUTO_INCREMENT,
             `first_name` CHAR(20) NOT NULL,
             `sur_name` CHAR(20) NOT NULL,
             `date_of_birth` DATE NOT NULL,
             `email_address` CHAR(30) NOT NULL,
             `phone_number` CHAR(20) NOT NULL,
             `address_id` BIGINT NOT NULL,
             `created_at` TIMESTAMP NOT NULL,
             `updated_at` TIMESTAMP ON UPDATE CURRENT_TIMESTAMP NOT NULL,
             PRIMARY KEY (`id`),
             CONSTRAINT fk_personal_address FOREIGN KEY (address_id) REFERENCES address(id)
);

CREATE TABLE `users` (
            `id` BIGINT NOT NULL AUTO_INCREMENT,
            `uuid` VARCHAR(36) NOT NULL,
            `username` CHAR(20) NOT NULL,
            `password` CHAR(50) NOT NULL,
            `personal_data_id` BIGINT NOT NULL,
            `role` CHAR(10) NOT NULL,
            `is_active` BOOLEAN NOT NULL,
            `created_at` TIMESTAMP NOT NULL,
            `updated_at` TIMESTAMP ON UPDATE CURRENT_TIMESTAMP NOT NULL,
            PRIMARY KEY (`id`),
            CONSTRAINT fk_user_personal_data FOREIGN KEY (personal_data_id) REFERENCES personal_data(id)
);
