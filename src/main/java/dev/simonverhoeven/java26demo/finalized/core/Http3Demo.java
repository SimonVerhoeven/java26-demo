package dev.simonverhoeven.java26demo.finalized.core;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;

public class Http3Demo {
    static void main() {
        final var client = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_3)
                .build();

        HttpRequest request = HttpRequest.newBuilder(URI.create("https://github.com/SimonVerhoeven/java26-demo"))
                .version(HttpClient.Version.HTTP_3)
                .GET().build();
    }
}
