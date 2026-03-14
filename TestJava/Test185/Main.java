package TestJava.Test185;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Field;

@Retention(RetentionPolicy.RUNTIME) @interface Table { String name(); }
@Retention(RetentionPolicy.RUNTIME) @interface Id {}
@Retention(RetentionPolicy.RUNTIME) @interface Column {}

@Table(name = "tasks")
class Task {
    @Id public int id;
    @Column public String title;
    @Column public boolean isDone;

    public Task(int id, String title, boolean isDone) {
        this.id = id; this.title = title; this.isDone = isDone;
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("=== Test 185: Dynamic SQL Generator (INSERT & UPDATE) ===\n");

        Task myTask = new Task(101, "Learn Reflection", true);

        System.out.println("--- Generated INSERT Statement ---");
        System.out.println(generateInsert(myTask));

        System.out.println("\n--- Generated UPDATE Statement ---");
        System.out.println(generateUpdate(myTask));
    }

    private static String generateInsert(Object obj) throws IllegalAccessException {
        Class<?> clazz = obj.getClass();
        String table = clazz.getAnnotation(Table.class).name();
        
        StringBuilder columns = new StringBuilder();
        StringBuilder values = new StringBuilder();
        
        Field[] fields = clazz.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            field.setAccessible(true);
            
            columns.append(field.getName());
            
            // Extract the actual value from the INSTANCE!
            Object value = field.get(obj);
            if (value instanceof String) {
                values.append("'").append(value).append("'");
            } else {
                values.append(value);
            }
            
            if (i < fields.length - 1) {
                columns.append(", ");
                values.append(", ");
            }
        }
        
        return "INSERT INTO " + table + " (" + columns.toString() + ") VALUES (" + values.toString() + ");";
    }

    private static String generateUpdate(Object obj) throws IllegalAccessException {
        Class<?> clazz = obj.getClass();
        String table = clazz.getAnnotation(Table.class).name();
        
        StringBuilder setVars = new StringBuilder();
        String idCondition = "";
        
        Field[] fields = clazz.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            field.setAccessible(true);
            
            Object value = field.get(obj);
            String formattedValue = (value instanceof String) ? "'" + value + "'" : value.toString();

            if (field.isAnnotationPresent(Id.class)) {
                idCondition = field.getName() + " = " + formattedValue;
            } else {
                setVars.append(field.getName()).append(" = ").append(formattedValue);
                if (i < fields.length - 1) setVars.append(", ");
            }
        }
        
        return "UPDATE " + table + " SET " + setVars.toString() + " WHERE " + idCondition + ";";
    }
}
