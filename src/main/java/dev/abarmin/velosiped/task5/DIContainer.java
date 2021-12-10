package dev.abarmin.velosiped.task5;

/**
 * Task 5 - Naïve DI.
 *
 * <p>
 *   In this task you should implement simple manual DI container. This container will be used
 *   in all further tests. This container should have init method and return instance of class by
 *   <pre>getBean</pre> request. All the controllers and services should be added to DI container.
 *   You could use CustomHttpServer from task 4.
 * </p>
 *
 * @author Aleksandr Barmin
 */
public interface DIContainer {
    /**
     * This method should be invoked before the first use of {@link DIContainer}.
     */
    void init();

    /**
     * Get bean from the container by its type, for example, by an interface.
     *
     * @param beanClass to look for in the context.
     * @param <T>
     * @return a configured instance of the class.
     */
    <T> T getBean(Class<T> beanClass);
}
