package com.testarmy.demos;

import java.io.IOException;
import java.net.InetSocketAddress;

import com.sun.net.httpserver.HttpServer;
import org.junit.rules.ExternalResource;

public class App extends ExternalResource {

    HttpServer server = null;

    public App(int port) {
        try {
            server = HttpServer.create(new InetSocketAddress(port), 0);
            server.createContext("/client/simple", new SimpleController());
            server.setExecutor(null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void before() throws Throwable {
        server.start();
    }

    @Override
    protected void after() {
        server.stop(0);
    }

}
