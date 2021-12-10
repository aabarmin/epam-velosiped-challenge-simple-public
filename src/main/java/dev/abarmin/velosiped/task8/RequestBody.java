package dev.abarmin.velosiped.task8;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * This annotation shows that the value for the given parameter should be taken from
 * the request's body.
 *
 * @author Aleksandr Barmin
 */
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
public @interface RequestBody {
}
