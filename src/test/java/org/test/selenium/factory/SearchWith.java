package org.test.selenium.factory; /**
 * Created by hemanthsridhar on 1/6/19.
 */
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention (RetentionPolicy.RUNTIME)
@Target (ElementType.FIELD)
public @interface SearchWith {
    String inPage() default "";

    String locatorsFile() default "";

    String nameOfTheLocator() default "";
}