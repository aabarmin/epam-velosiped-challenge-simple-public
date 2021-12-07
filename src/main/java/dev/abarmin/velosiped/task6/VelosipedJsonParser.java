package dev.abarmin.velosiped.task6;

/**
 * @author Aleksandr Barmin
 */
public interface VelosipedJsonParser {
  <T> T parse(String json, Class<T> targetClass);
}
