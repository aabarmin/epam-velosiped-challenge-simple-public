package dev.abarmin.velosiped.helper;

/**
 * @author Aleksandr Barmin
 */
public class VelosipedHelper {
  public static <T> T getInstance(Class<T> interfaceClass) {
    try {
      final String implementationClassName = interfaceClass.getName() + "Impl";
      final Class<?> implementationClass = Class.forName(implementationClassName);
      return (T) implementationClass.getDeclaredConstructor().newInstance();
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}
