package dev.abarmin.velosiped.task5;

public interface DIContainer {

    /**
     * Task 5 - Naïve DI.
     *
     * <p>
     *   In this task you should implement simple manual DI container. This container will be used in all further tests.
     *   This container should have init method and return instance of class by <pre>getBean</pre> request.
     *   All the controllers and services should be added to DI container. You could use CustomHttpServer from task 4.
     *
     * </p>
     *
     *
     * @author Aleksandr Barmin
     */
    void init();

    <T> T getBean(Class<T> beanClass);
}
