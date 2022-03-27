
package fr.lernejo.navy_battle;

import com.sun.net.httpserver.HttpServer;
import fr.lernejo.navy_battle.handler.PingHandler;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

public class Serveur {

    public HttpServer launch(int port) throws IOException {
        final HttpServer httpServer = HttpServer.create(new InetSocketAddress(port), 0);
        httpServer.createContext("/ping", new PingHandler());
        httpServer.setExecutor(Executors.newFixedThreadPool(1));

        return httpServer;
    }
}
