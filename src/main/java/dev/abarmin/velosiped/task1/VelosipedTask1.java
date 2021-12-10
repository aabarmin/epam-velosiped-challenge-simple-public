package dev.abarmin.velosiped.task1;

/**
 * Task 1 - GET some.
 *
 * <p>
 *   Implement a simple <pre>/sum</pre> endpoint which should receive requests via GET. The request
 *   contains parameters <pre>a</pre> and <pre>b</pre> which are two numbers which should be sum.
 *   The result of the sum should be returned back to the user.
 * </p>
 *
 * <p>
 *   The interface has two methods - <pre>startServer</pre> which starts a web server on a given
 *   port and the <pre>stopServer</pre> method which stops the server.
 * </p>
 *
 * @author Aleksandr Barmin
 */
public interface VelosipedTask1 {
  /**
   * Start a server on a given port.
   *
   * @param port number
   */
  void startServer(int port);

  /**
   * Stop a started server.
   */
  void stopServer();
}
