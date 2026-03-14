package com.example.cassandra;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Table("sensor_readings")
class SensorReading {
    @PrimaryKey
    private UUID id = UUID.randomUUID();
    private String sensorId;
    private double temperature;
    private long timestamp;

    public SensorReading(String sensorId, double temperature) {
        this.sensorId = sensorId;
        this.temperature = temperature;
        this.timestamp = System.currentTimeMillis();
    }
    public UUID getId() { return id; }
    public String getSensorId() { return sensorId; }
    public double getTemperature() { return temperature; }
}

@Repository
public interface SensorRepository extends CassandraRepository<SensorReading, UUID> {}
