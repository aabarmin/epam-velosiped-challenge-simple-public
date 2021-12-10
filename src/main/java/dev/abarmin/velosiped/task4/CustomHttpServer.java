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
    /**
     * This method receives a request as a string and should convert it to the {@link Request}
     * object accordingly.
     *
     * @param httpRequest to parse.
     * @return a {@link Request} object.
     */
    Request parseRequestParameters(String httpRequest);

    /**
     * This method receives a response <b>body</b> and should convert it to the HTTP response.
     *
     * @param responseBody to include into the HTTP response.
     * @return a content of HTTP response.
     */
    String createHttpResponse(String responseBody);

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
