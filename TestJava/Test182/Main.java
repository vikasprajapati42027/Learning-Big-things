package TestJava.Test182;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;

// The @Column annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface Column {
    String name() default "";
    boolean nullable() default true;
    int length() default 255;
}

class Product {
    public int id;
    
    @Column(name = "product_title", length = 100, nullable = false)
    public String title;
    
    @Column // Will use defaults!
    public double price;
}

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Test 182: Designing @Column Annotation ===\n");

        System.out.println("Let's read the fields of a class and see how they map to Database Columns!\n");

        Class<Product> prodClass = Product.class;
        
        System.out.println("Inspecting fields of: " + prodClass.getSimpleName());

        for (Field field : prodClass.getDeclaredFields()) {
            
            String columnName = field.getName(); // Default to variable name
            String constraints = "";

            // Check if @Column applies
            if (field.isAnnotationPresent(Column.class)) {
                Column colMeta = field.getAnnotation(Column.class);
                
                // Override name if provided
                if (!colMeta.name().isEmpty()) {
                    columnName = colMeta.name();
                }
                
                // Read constraints
                constraints += "VARCHAR(" + colMeta.length() + ") ";
                constraints += colMeta.nullable() ? "NULL" : "NOT NULL";
            } else {
                constraints = "DEFAULT_TYPE";
            }
            
            System.out.println("- Field '" + field.getName() + "' -> DB Column: " + columnName + " | Constraints: " + constraints);
        }
    }
}
