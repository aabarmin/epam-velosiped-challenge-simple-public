package dev.abarmin.velosiped;

/**
 * @author Aleksandr Barmin
 */
public interface VelosipedJsonParser {
  <T> T parse(String json, Class<T> targetClass);
}
