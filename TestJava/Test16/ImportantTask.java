package TestJava.Test16;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Creating a Custom Annotation!
 * 
 * @Retention(RetentionPolicy.RUNTIME) means this annotation is available 
 * to the JVM at runtime (so we can read it using Reflection!).
 * 
 * @Target(ElementType.METHOD) means this annotation can ONLY be placed 
 * above methods (not classes or variables).
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface ImportantTask {
    
    // We can define properties for our annotation
    // They act like methods but we provide values when using the annotation
    int priority() default 1;
    String description() default "No description provided";
}
