package dev.abarmin.velosiped.task2;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class VelosipedTask2Impl implements VelosipedTask2 {

    private HttpServer server;
    private final String rootContext;
    private final HttpHandler httpHandler;
    private final ObjectMapper om = new ObjectMapper();

    public VelosipedTask2Impl() {
        this.rootContext = "/sum-post";
        this.httpHandler = this::handle;
    }

    @Override
    public void startServer(int port) {
        try {
            if (server != null)
                stopServer();

            server = HttpServer.create(new InetSocketAddress(port), 0);
            server.createContext(rootContext,  httpHandler);
            server.setExecutor(null);
            server.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void stopServer() {
        if (server != null){
            server.stop(1);
            server = null;
        }

    }

    private void handle(HttpExchange httpExchange) throws IOException {
        InputStream is = httpExchange.getRequestBody();
        Request req = om.readerFor(Request.class).readValue(is);

        Response response = new Response(req.getArg1() + req.getArg2());
        int code = 200;

        respond(httpExchange, response, code);
    }

    private void respond(HttpExchange httpExchange, Response response, int code) throws IOException {
        ObjectWriter objectWriter = om.writerFor(Response.class);
        byte[] bytes = objectWriter.writeValueAsBytes(response);

        httpExchange.getResponseHeaders().add("Content-Type", "application/json");
        httpExchange.sendResponseHeaders(code, bytes.length);

        OutputStream os = httpExchange.getResponseBody();
        os.write(bytes);
        os.flush();
        os.close();
    }
}
