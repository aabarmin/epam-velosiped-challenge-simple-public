package dev.abarmin.velosiped.task10;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * This annotation shows that the value for the given parameter should be taken from
 * the request string.
 *
 * @author Aleksandr Barmin
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface QueryParameter {
  /**
   * Name of the parameter to extract.
   *
   * @return
   */
  String value();
}
