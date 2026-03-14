import org.apache.kafka.clients.producer.ProducerConfig;
import java.util.Properties;
public class Config {
    public Properties props() {
        Properties p = new Properties();
        p.put(ProducerConfig.ACKS_CONFIG, "all");
        p.put(ProducerConfig.RETRIES_CONFIG, 3);
        return p;
    }
}
