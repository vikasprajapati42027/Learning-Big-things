package Test38;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Database Migrations (Flyway/Liquibase):
 * Managing database schema changes over time.
 * Never share SQL "hand-written" scripts. Use Version Control.
 */
@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}

/**
 * Flyway Naming Convention for scripts:
 * V1__Create_User_Table.sql
 * V2__Add_Email_Column.sql
 * V3__Change_Age_To_Nullable.sql
 */
