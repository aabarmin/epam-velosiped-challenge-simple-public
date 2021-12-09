package dev.abarmin.velosiped.helper;

/**
 * This class is responsible for creating instances of classes which are used for testing.
 * The general rule is that it checks for the class with the name equals to the name of
 * the interface adding Impl at the end.
 *
 * Example: if the interface is called Some, this class will look for the implementation
 * called SomeImpl. If the implementation is not found or does not have a default constructor,
 * an exception will be thrown.
 *
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
