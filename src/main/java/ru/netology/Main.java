package ru.netology;

import java.io.*;
import java.net.ServerSocket;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.List;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

public class Main {
  public static void main(String[] args) throws IOException {
    final Server server = new Server(9999, 64);
    // код инициализации сервера (из вашего предыдущего ДЗ)
    server.start();

  }
}


