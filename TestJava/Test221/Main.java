package TestJava.Test221;

import javax.management.MBeanServer;
import javax.management.ObjectName;
import java.lang.management.ManagementFactory;

// 1. The MBean Interface (MUST end with "MBean")
interface SystemConfigMBean {
    int getThreadCount();
    void setThreadCount(int threadCount);
    String getSchemaName();
    void setSchemaName(String schemaName);
    
    // An operation
    String triggerGarbageCollection();
}

// 2. The Implementation
class SystemConfig implements SystemConfigMBean {
    private int threadCount = 10;
    private String schemaName = "default_schema";

    @Override
    public int getThreadCount() { return threadCount; }

    @Override
    public void setThreadCount(int threadCount) { 
        System.out.println("Config changed! Thread count is now: " + threadCount);
        this.threadCount = threadCount; 
    }

    @Override
    public String getSchemaName() { return schemaName; }

    @Override
    public void setSchemaName(String schemaName) { 
        System.out.println("Config changed! Schema is now: " + schemaName);
        this.schemaName = schemaName; 
    }

    @Override
    public String triggerGarbageCollection() {
        System.gc();
        return "Manual GC triggered successfully from JMX!";
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("=== Test 221: JMX MBeans (Remote Management) ===\n");

        System.out.println("JMX (Java Management Extensions) allows you to monitor and configure");
        System.out.println("a Java application WHILE IT IS RUNNING without restarting it!");
        System.out.println("Normally, you'd connect to this with 'jconsole' or 'VisualVM'.\n");

        // 1. Get the MBean Server (Built into the JVM)
        MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();

        // 2. Create the MBean Name
        ObjectName name = new ObjectName("com.vikasp.app:type=SystemConfig");

        // 3. Register our config object
        SystemConfig mbean = new SystemConfig();
        
        try {
            mbs.registerMBean(mbean, name);
            System.out.println("SystemConfig MBean successfully registered!");
            
            System.out.println("Current Schema: " + mbean.getSchemaName());
            
            System.out.println("\n[Simulating Admin action via JConsole...]");
            // Simulating an external admin changing the configuration via JMX:
            mbs.setAttribute(name, new javax.management.Attribute("SchemaName", "production_db"));
            
            System.out.println("\n[Simulating Admin triggering operation via JConsole...]");
            String result = (String) mbs.invoke(name, "triggerGarbageCollection", null, null);
            System.out.println("Result: " + result);

        } catch (Exception e) {}
    }
}
