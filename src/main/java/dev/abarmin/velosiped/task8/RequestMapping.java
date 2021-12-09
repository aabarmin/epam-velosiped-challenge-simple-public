package dev.abarmin.velosiped.task8;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * This annotation connects methods of the controllers annotated with {@link dev.abarmin.velosiped.task9.Controller}
 * and requests.
 *
 * @author Aleksandr Barmin
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface RequestMapping {
  /**
   * Path of the request.
   *
   * @return
   */
  String path();

  /**
   * Method of the request.
   * @return
   */
  HttpMethod method();
}
