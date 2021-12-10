package dev.abarmin.velosiped.task3;

/**
 * This is the interface you need to implement for dealing with Json.
 *
 * @author Aleksandr Barmin
 */
public interface VelosipedJsonAdapter {
  /**
   * Read a json from the given string and map it to the object of a given type.
   *
   * @param json string to parse.
   * @param targetClass to create and map the given json to.
   * @param <T> is a type of the class.
   * @return an instance of T with values taken from json.
   */
  <T> T parse(String json, Class<T> targetClass);

  /**
   * Convert an object to json string.
   *
   * @param instance of the object to marshall.
   * @return a json string with values from the object.
   */
  String writeAsJson(Object instance);
}
