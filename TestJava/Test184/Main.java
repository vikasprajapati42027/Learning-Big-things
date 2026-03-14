package TestJava.Test184;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Field;

@Retention(RetentionPolicy.RUNTIME) @interface Table { String name(); }
@Retention(RetentionPolicy.RUNTIME) @interface Id {}
@Retention(RetentionPolicy.RUNTIME) @interface Column {}

@Table(name = "employees")
class Employee {
    @Id public int empId;
    @Column public String fullName;
    @Column public double salary;
}

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Test 184: Dynamic SQL Generator (CREATE TABLE) ===\n");

        System.out.println("This is how Hibernate's 'hbm2ddl.auto = update' works!");
        System.out.println("It reads the annotations and outputs a raw SQL CREATE statement.\n");

        Class<?> clazz = Employee.class;
        
        if (!clazz.isAnnotationPresent(Table.class)) {
            System.out.println("Not a table!");
            return;
        }
        
        String tableName = clazz.getAnnotation(Table.class).name();
        StringBuilder sql = new StringBuilder("CREATE TABLE " + tableName + " (\n");
        
        Field[] fields = clazz.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            sql.append("    ").append(field.getName()).append(" ");
            
            // Map Java types to SQL Types dynamically
            if (field.getType() == int.class) sql.append("INTEGER");
            else if (field.getType() == String.class) sql.append("VARCHAR(255)");
            else if (field.getType() == double.class) sql.append("DECIMAL(10,2)");
            
            // Append constraints
            if (field.isAnnotationPresent(Id.class)) {
                sql.append(" PRIMARY KEY AUTO_INCREMENT");
            }
            
            if (i < fields.length - 1) sql.append(",\n");
            else sql.append("\n");
        }
        sql.append(");");

        System.out.println("Generated SQL Query:");
        System.out.println("----------------------------------");
        System.out.println(sql.toString());
        System.out.println("----------------------------------");
    }
}
