package dev.abarmin.velosiped.task10;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author Aleksandr Barmin
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface QueryParameter {
  String value();
}
