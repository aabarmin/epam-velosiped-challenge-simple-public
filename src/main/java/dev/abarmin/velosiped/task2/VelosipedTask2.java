package dev.abarmin.velosiped.task2;

/**
 * Task 2 - Newborn POST.
 *
 * <p>
 *   Implement a simple <pre>/sum</pre> endpoint which should receive requests via POST.
 *   The request is represented in JSON format
 *   {"arg1": 1, "arg2":2 }
 *   contains object Request with two parameters.
 *   The result of the sum should be returned back to the user in a next JSON object.
 *   {"result":3}
 *   External JSON library dependencies could be used.
 * </p>
 *
 * <p>
 *   The interface has two methods - <pre>startServer</pre> which starts a web server on a given
 *   port and the <pre>stopServer</pre> method which stops the server.
 * </p>
 *
 * @author Aleksandr Barmin
 */
public interface VelosipedTask2 {
  void startServer(int port);
  void stopServer();
}
