package ru.netology;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Handler;

public class Server {
    private final ServerSocket serverSocket;
    private final ExecutorService pool;

    private List<String> validPaths = new ArrayList<>();
    private File srcDir = new File("public");

    public Server(int port, int poolSize)
            throws IOException {
        serverSocket = new ServerSocket(port);
        pool = Executors.newFixedThreadPool(poolSize);
        File[] files = srcDir.listFiles();
        for (File f : files) {
            validPaths.add("/" + f.getName());
        }
    }

    public void start() {
        try {
            while(true) {
                final Socket socket = serverSocket.accept();
                serverSocket.setReuseAddress(true);
                pool.execute(new Request(socket, validPaths));
            }

        } catch (
                IOException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }



    public void addHandler(String get, String s, Handler handler) {

    }
}
