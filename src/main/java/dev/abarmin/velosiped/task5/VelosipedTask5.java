package dev.abarmin.velosiped.task5;

/**
 * @author Aleksandr Barmin
 */
public interface VelosipedTask5 {
  /**
   * This method is called before the first use of DI.
   */
  void init();

  <T> T getBean(Class<T> beanClass);
}
