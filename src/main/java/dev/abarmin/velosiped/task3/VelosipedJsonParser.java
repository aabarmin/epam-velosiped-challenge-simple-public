package dev.abarmin.velosiped.task3;

/**
 * @author Aleksandr Barmin
 */
public interface VelosipedJsonParser {
  <T> T parse(String json, Class<T> targetClass);
  String writeAsJson(Object instance);
}
