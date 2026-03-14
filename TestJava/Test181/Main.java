package TestJava.Test181;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// 1. Defining the @Entity Annotation
// RetentionPolicy.RUNTIME means it's available during program execution via Reflection!
// Target(ElementType.TYPE) means it can ONLY be applied to Classes/Interfaces.
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface Entity {
    // Allows us to specify a custom table name. Default is empty.
    String tableName() default "";
}

// 2. Defining the @Id Annotation
// Applied to Fields (Variables) only to mark the Primary Key.
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface Id {
    boolean autoIncrement() default true;
}

// 3. Using them in a Model Class
@Entity(tableName = "system_users")
class User {
    @Id
    public int userId;
    
    public String username;
}

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Test 181: Designing @Entity and @Id Annotations ===\n");

        System.out.println("Annotations like @Entity (JPA/Hibernate) are just metadata markers!");
        System.out.println("They don't DO anything on their own. We have to write Reflection code to read them.\n");

        Class<User> userClass = User.class;

        // Checking for @Entity
        if (userClass.isAnnotationPresent(Entity.class)) {
            Entity entityMeta = userClass.getAnnotation(Entity.class);
            String table = entityMeta.tableName().isEmpty() ? 
                           userClass.getSimpleName().toLowerCase() : 
                           entityMeta.tableName();
                           
            System.out.println("Class '" + userClass.getSimpleName() + "' maps to Table: " + table);
        } else {
            System.out.println("Not an Entity!");
        }
    }
}
