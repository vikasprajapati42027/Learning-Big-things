/**
 * INTERVIEWER: SOLID Principle Scenario 7.
 * CANDIDATE: Professional implementation of SOLID principle 7.
 */
import java.util.HashMap;
import java.util.Map;
class Configuration {
    private final Map<String, String> values = new HashMap<>();

    void set(String key, String value) {
        values.put(key, value);
    }

    String get(String key) {
        return values.get(key);
    }
}

class ConfigurationLoader {
    private final Configuration configuration;

    ConfigurationLoader(Configuration configuration) {
        this.configuration = configuration;
    }

    void load() {
        configuration.set("timeout", "30");
        configuration.set("mode", "PRODUCTION");
        System.out.println("Configuration loaded: " + configuration.get("mode"));
    }
}

public class Q7_SOLID {
    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        ConfigurationLoader loader = new ConfigurationLoader(configuration);
        loader.load();
    }
}
