import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

public class Exemple {
  static class ExempleHandler implements HttpHandler {
    public void handle(HttpExchange exchange) throws IOException {
      var response = "Hello World from java\n";
      exchange.sendResponseHeaders(200, response.length());
      OutputStream os = exchange.getResponseBody();
      os.write(response.getBytes());
      os.flush();
      os.close();
      exchange.close();
    }
  }

  public static void main(String[] args) throws IOException {
    HttpServer server = HttpServer.create(new InetSocketAddress(8081), 0);

    server.createContext("/", new ExempleHandler());

    server.start();
    System.out.println("Server started on 8081");
  }
}
