package com.testarmy.demos;

import java.io.IOException;
import java.io.OutputStream;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

@SuppressWarnings("restriction")
public class SimpleController implements HttpHandler {

    private static final int HTTP_OK_STATUS = 200;

    public void handle(HttpExchange httpExchange) throws IOException {
        String response = createResponse();
        httpExchange.sendResponseHeaders(HTTP_OK_STATUS, response.getBytes().length);
        httpExchange.getResponseHeaders().set("Content-Type", "application/json; charset=UTF-8");
        OutputStream os = httpExchange.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }

    private String createResponse() {
        return "{\"hello\": \"harry\"}";
    }
}