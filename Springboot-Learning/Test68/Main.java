package Test68;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.cassandra.repository.CassandraRepository;

/**
 * Spring Boot with Apache Cassandra:
 * An open source, distributed, NoSQL database. 
 * Designed for high scalability and high availability.
 */
@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}

/**
 * Why Cassandra?
 * It's all about "Write Speed". It can handle massive write volume 
 * because it has no master "Single Point of Failure".
 */
interface SensorRepository extends CassandraRepository<SensorData, String> {
}

class SensorData {
    private String sensorId;
    private double reading;
}
