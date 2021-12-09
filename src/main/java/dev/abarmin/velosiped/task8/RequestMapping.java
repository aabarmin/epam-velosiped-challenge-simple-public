package dev.abarmin.velosiped.task8;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author Aleksandr Barmin
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface RequestMapping {
  String path();

  HttpMethod method();
}
