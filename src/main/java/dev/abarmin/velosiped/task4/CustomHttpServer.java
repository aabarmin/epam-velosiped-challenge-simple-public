package dev.abarmin.velosiped.task4;

import dev.abarmin.velosiped.task2.Request;


/**
 * Task 4 - Socket Hell.
 *
 * <p>
 *   The HTTP server should be created from the scratch.
 *   All the same but manual parsing and packing of the pure http request.
 *   Sockets should be used.
 *
 * </p>
 *
 * <p>
 *   The interface has four methods - <pre>startServer</pre> which starts a web server on a given
 *   port, the <pre>stopServer</pre> method which stops the server, <pre>parseRequestParameters</pre>
 *   that could read input parameters from the pure http request
 *   and <pre>createhttpResponse</pre> that creating the pure http response
 * </p>
 *
 * @author Aleksandr Barmin
 */
public interface CustomHttpServer {
    Request parseRequestParameters(String httpRequest);
    String createhttpResponse(String responseBody);
    void startServer(int port);
    void stopServer();
}
