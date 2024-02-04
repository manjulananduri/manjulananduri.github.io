---
layout: post
title: "Simple HTTP Server in Java with single and multiple clients - Socket programming"
author: Pramod
categories: [Java, Programming]
image: assets/images/golang.jpg
beforetoc: "Build your own HTTP server in Java, mastering client requests, multi-threading, and more. Dive into a hands-on journey to demystify the web from the server side!"
featured: true
toc: true
tableofcontents: true
---

## Introduction

Hello, curious developers!
Ever wondered how websites magically appear on your screen? Behind the scenes,
HTTP servers and clients play crucial roles in delivering the content you enjoy,
working in harmonious coordination. Today, we'll embark on an exciting journey
to build our very own HTTP web server using the power of Java's socket programming.
Buckle up, as we're about to demystify the inner workings of the web and gain
valuable insights into its core technologies.

In case you missed it check out our other programming articles here

[Java read file to string - 5 simple ways](/how-to-read-file-as-string-in-java/)

[How to read or convert an inputstream into a string in java](/how-to-read-file-as-string-in-java/)

[Golang read file line by line - 3 Simple ways](/how-to-read-file-line-by-line-golang/)

[Golang get last element of slice / array / list - Simple and fast](/how-to-get-last-element-of-slice-golang/)

[Golang get map keys - 3 Simple ways](/how-to-get-keys-in-map-golang/)

[Golang enums implementation with examples](/golang-enums/)

## Understanding HTTP

Before we delve into the code, let's gain a basic understanding of the Hypertext Transfer Protocol (HTTP). It's the language servers and clients use to converse. Here's a simplified breakdown:

- **Requests:** Clients initiate communication by sending requests to the server, specifying the desired resource (e.g., an HTML page) using a URL and potentially including additional data.
- **Responses:** Servers respond with their interpretation of the request, sending back data (e.g., the HTML page) wrapped in an HTTP response message.

## Code Walkthrough

Now, let's dive into the code for simple http server code.

### 1. Server Socket Setup

The foundation of our HTTP server lies in its ability to listen for and accept
client connections. In this section, we'll explore the Java code responsible for
establishing this communication channel. Imagine a bustling marketplace where
shops wait for customers to arrive. Similarly, our HTTP server needs a mechanism
to connect with web browsers (clients) who request information. This section
delves into the Java code responsible for establishing this crucial
communication channel, the cornerstone of our server's functionality.

```java
import java.io.*;
import java.net.*;

public class SimpleHTTPServer {

    public static final int PORT = 8080; // Arbitrary port number (use one not in use)

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server started on port " + PORT);

        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected: " + clientSocket.getInetAddress());
            handleClient(clientSocket);
        }
    }

    private static void handleClient(Socket clientSocket) throws IOException {
        // ... more code to handle client requests
    }
}
```

- **`ServerSocket`**: Creates a socket on the specified `PORT`, ready to accept client connections.
- **`PORT`**: This can be any available port (avoid the well-known ones like 80).
- **`serverSocket.accept()`**: Waits for a client connection and returns a `Socket` object representing the active connection.
- **`while` loop**: Keeps the server running, accepting new connections indefinitely.
- **`handleClient`**: A helper method we'll define later to handle each client's request-response cycle.

### 2. Processing Client Requests

Now that our server is listening for connections, let's delve into how it handles incoming client requests. Here's a breakdown of the code responsible for this interaction:

```java
private static void handleClient(Socket clientSocket) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
    PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true); // Auto-flush

    String requestLine = reader.readLine(); // Read the first line (request line)
    System.out.println("Request line: " + requestLine);

    // ... more code to parse headers and handle the request
}
```

- **`BufferedReader` and `PrintWriter`**: Represent input and output streams for reading the client's request and sending the server's response.
- **`reader.readLine()`**: Reads the first line of the request, typically containing the HTTP method (e.g., GET), URL, and HTTP version.
- **`System.out.println()`**: Logs the request line for debugging/monitoring.

### 3. Parsing Headers and Building Response

Now that our server has established a connection with the client, it's time to
understand what they're requesting. Similar to how we need to interpret
different languages to communicate effectively, our server needs to parse the
client's message, which comes in the form of HTTP headers and a request line. In
this section, we'll explore the code responsible for translating this "language"
and crafting a tailored response.

**Unpacking the Request:**

Imagine the client's message as a letter containing
important information like what resource they want (e.g., a specific webpage)
and any additional instructions. We'll see how the code carefully extracts this
information from the request line and headers.

**Building Blocks of a Response:**

Just like crafting a response in our own language, our server needs to assemble
its reply using specific components. We'll delve into how the code constructs a
well-structured HTTP response, including status codes and content type
information.

```java
// ... continue from handleClient

    String headerLine;
    Map<String, String> headers = new HashMap<>(); // Store headers for later use
    while ((headerLine = reader.readLine()) != null && !headerLine.isEmpty()) {
        String[] parts = headerLine.split(":");
        headers.put(parts[0].trim(), parts[1].trim());
    }

    // Extract resource path from request line
    String resourcePath = requestLine.split(" ")[1]; // Assuming a standard request format

    // Create a simple response based on the request path
    String response = "HTTP/1.1 200 OK\r\n" +
                "Content-Type: text/html\r\n" +
                "\r\n" +
                "<h1>Hello, World!</h1>";

    byte[] responseBytes = response.getBytes(); // Convert response to byte array
    writer.write(responseBytes); // Send the response

    clientSocket.close(); // Close the client socket
    }
```

- **Headers parsing:**
  - `while` loop reads each header line until an empty line is encountered.
  - `split` method extracts the header name and value.
  - `HashMap` stores headers for potential future use.
- **Resource path extraction:**
  - Uses `split` on the request line to extract the requested resource path.
- **Simple response creation:**
  - Hardcoded response includes HTTP status code (200 OK), content type (text/html), and a simple "Hello, World!" message.
  - `getBytes()` converts the response to a byte array for network transmission.
- **Response sending:**
  - `writer.write()` sends the response bytes to the client.
- **Socket closing:**
  - `clientSocket.close()` gracefully closes the connection with the client.

### 4. Serve static files with socket programming

We can enhance the server to serve static files (e.g., HTML, CSS, images) from a specific directory:

```java
private static byte[] readFile(String filename) throws IOException {
    File file = new File(filename);
    if (!file.exists()) {
        throw new FileNotFoundException("File not found: " + filename);
    }
    FileInputStream fis = new FileInputStream(file);
    byte[] data = new byte[(int) file.length()];
    fis.read(data);
    fis.close();
    return data;
}

private static void handleClient(Socket clientSocket) throws IOException {
    // ... existing code ...

    // Map resource path to file path
    String filePath = "public_html" + resourcePath; // Assuming files are in public_html

    // Serve the file if it exists
    if (new File(filePath).exists()) {
        byte[] fileBytes = readFile(filePath);
        String contentType = getContentType(resourcePath); // Determine content type based on file extension
        String response = "HTTP/1.1 200 OK\r\n" +
                "Content-Type: " + contentType + "\r\n" +
                "\r\n";
        byte[] responseBytes = response.getBytes();
        writer.write(responseBytes);
        writer.write(fileBytes);
    } else {
        String response = "HTTP/1.1 404 Not Found\r\n" +
                    "Content-Type: text/plain\r\n" +
                    "\r\n" +
                    "File not found";
        writer.write(response.getBytes());
    }

    // ... and so on
}
```

- **`readFile` method:** Reads the contents of a specified file into a byte array.
- **`handleClient` modification:**
  - Maps the requested resource path to a file path assuming files are in a `public_html` directory.
  - Checks if the file exists.
  - If found, reads the file content and determines the content type based on the extension.
  - Constructs a response with the appropriate content type and file data.
  - Sends the response to the client.
  - Handles cases where the file is not found (e.g., sending a 404 Not Found response).

### 5. Error Handling and Enhancements

- Implement additional error handling for various scenarios (e.g., invalid requests, socket exceptions).
- Consider supporting more HTTP methods (e.g., POST).
- Explore advanced features like serving dynamic content using servlets or frameworks.

## Full code for Simple HTTP Web Server in Java with socket programming:

**Here's the full integrated code, incorporating the optional section for serving static files:**

```java
import java.io.*;
import java.net.*;
import java.util.HashMap;

public class SimpleHTTPServer {

    public static final int PORT = 8080;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server started on port " + PORT);

        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected: " + clientSocket.getInetAddress());
            handleClient(clientSocket);
        }
    }

    private static void handleClient(Socket clientSocket) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);

        String requestLine = reader.readLine();
        System.out.println("Request line: " + requestLine);

        String headerLine;
        Map<String, String> headers = new HashMap<>();
        while ((headerLine = reader.readLine()) != null && !headerLine.isEmpty()) {
            String[] parts = headerLine.split(":");
            headers.put(parts[0].trim(), parts[1].trim());
        }

        String resourcePath = requestLine.split(" ")[1];

        // Serve static files if requested
        String filePath = "public_html" + resourcePath; // Assuming files are in public_html
        if (new File(filePath).exists()) {
            byte[] fileBytes = readFile(filePath);
            String contentType = getContentType(resourcePath);
            String response = "HTTP/1.1 200 OK\r\n" +
                    "Content-Type: " + contentType + "\r\n" +
                    "\r\n";
            byte[] responseBytes = response.getBytes();
            writer.write(responseBytes);
            writer.write(fileBytes);
        } else {
            String response = "HTTP/1.1 404 Not Found\r\n" +
                    "Content-Type: text/plain\r\n" +
                    "\r\n" +
                    "File not found";
            writer.write(response.getBytes());
        }

        clientSocket.close();
    }

    private static byte[] readFile(String filename) throws IOException {
        File file = new File(filename);
        if (!file.exists()) {
            throw new FileNotFoundException("File not found: " + filename);
        }
        FileInputStream fis = new FileInputStream(file);
        byte[] data = new byte[(int) file.length()];
        fis.read(data);
        fis.close();
        return data;
    }

    private String getContentType(String resourcePath) {
        if (fileName.endsWith("html")) {
            return ("text/html");
        } else if (fileName.endsWith("jpg")) {
            return ("image/jpg");
        } else if (fileName.endsWith("jpeg")) {
            return ("image/jpeg");
        } else if (fileName.endsWith("gif")) {
            return ("image/gif");
        } else {
            return ("application/octet-stream");
        }
    }
}
```

## Simple Http server with multiple clients in Java socket programming

The main difference between the single-client and multi-client versions of the HTTP server code lies in how they handle incoming client connections and process requests:

### Single-Client:

- The server listens for connections on a specific port.
- When a client connects, the server accepts the connection and establishes a communication channel.
- The server reads the client's request, processes it, and sends a response.
- After sending the response, the server closes the connection and waits for the next client.

### Multi-Client (with threads):

- The server still listens for connections on a specific port.
- When a client connects, the server accepts the connection and establishes a communication channel.
- Instead of directly processing the request itself, the server creates a new thread dedicated to handling that specific client.
- This thread reads the client's request, processes it, and sends a response.
- After sending the response, the thread closes the connection associated with that client.
- Meanwhile, the main server loop continues listening for new client connections and creating new threads to handle them concurrently.

Here is the full working code:

```java
import java.io.*;
import java.net.*;
import java.util.HashMap;

public class MultiClientHTTPServer {

    public static final int PORT = 8080;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server started on port " + PORT);

        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected: " + clientSocket.getInetAddress());

            // Handle client in a separate thread to allow for multiple connections
            // THIS IS THE MAIN DIFFERENCE BETWEN SINGLE CLIENT AND MULTIPLE CLIENTS
            new Thread(() -> {
                try {
                    handleClient(clientSocket);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }

    private static void handleClient(Socket clientSocket) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);

        String requestLine = reader.readLine();
        System.out.println("Request line: " + requestLine);

        String headerLine;
        Map<String, String> headers = new HashMap<>();
        while ((headerLine = reader.readLine()) != null && !headerLine.isEmpty()) {
            String[] parts = headerLine.split(":");
            headers.put(parts[0].trim(), parts[1].trim());
        }

        String resourcePath = requestLine.split(" ")[1];

        // Serve static files if requested
        String filePath = "public_html" + resourcePath; // Assuming files are in public_html
        if (new File(filePath).exists()) {
            byte[] fileBytes = readFile(filePath);
            String contentType = getContentType(resourcePath);
            String response = "HTTP/1.1 200 OK\r\n" +
                    "Content-Type: " + contentType + "\r\n" +
                    "\r\n";
            byte[] responseBytes = response.getBytes();
            writer.write(responseBytes);
            writer.write(fileBytes);
        } else {
            // Handle file not found case (e.g., 404 Not Found response)
            String response = "HTTP/1.1 404 Not Found\r\n" +
                    "Content-Type: text/plain\r\n" +
                    "\r\n" +
                    "File not found";
            writer.write(response.getBytes());
        }

        clientSocket.close();
    }

    private static byte[] readFile(String filename) throws IOException {
        File file = new File(filename);
        if (!file.exists()) {
            throw new FileNotFoundException("File not found: " + filename);
        }
        FileInputStream fis = new FileInputStream(file);
        byte[] data = new byte[(int) file.length()];
        fis.read(data);
        fis.close();
        return data;
    }

    private String getContentType(String resourcePath) {
        if (fileName.endsWith("html")) {
            return ("text/html");
        } else if (fileName.endsWith("jpg")) {
            return ("image/jpg");
        } else if (fileName.endsWith("jpeg")) {
            return ("image/jpeg");
        } else if (fileName.endsWith("gif")) {
            return ("image/gif");
        } else {
            return ("application/octet-stream");
        }
    }
}

```

### Key Differences in Code:

- **`while (true)` loop:** Both versions have this loop to continuously listen for connections.
- **`clientSocket.accept()`:** Both versions use this line to accept incoming connections.
- **Handling:** In the single-client version, the code directly processes the request within the `while (true)` loop. In the multi-client version, it creates a new thread using `new Thread(() -> {...}).start()`, where the actual request handling happens.
- **Closing connection:** Both versions close the connection after sending the response, but in the multi-client version, this happens within the dedicated thread for each client.

## Here's a guide on running the code and connecting a client

### 1. Compile the Code:

- Ensure you have Java Development Kit (JDK) installed on your system.
- Open a terminal or command prompt in the directory where you've saved the Java code file (e.g., `MultiClientHTTPServer.java`).
- Use the `javac` command to compile the code:

```bash
javac MultiClientHTTPServer.java
```

### 2. Run the Server:

- After successful compilation, use the `java` command to run the compiled class file:

```bash
java MultiClientHTTPServer
```

- You should see a message in the terminal indicating the server has started and is listening on the specified port (usually 8080).

### 3. Connect a Client:

#### Option 1: Connect with web browser:

- Open a web browser on your machine or any other device on the same network as the server.
- In the address bar, enter the following URL:

```
http://localhost:8080
```

- Replace `localhost` with the server's IP address if accessing from a different device.
- If the server is running correctly and able to serve static files, you should see the contents of the `public_html` directory displayed in your browser.

**Additional Notes:**

- **Serving Files:** Ensure you have a directory named `public_html` in the same location as your Java class file to serve static files. Place any HTML, CSS, images, or other files you want to access within this directory.
- **Custom Port:** If you want to use a different port, change the `PORT` variable in the code to your desired port number.
- **Accessing from Other Devices:** To access the server from devices on the same network, use the server's IP address instead of `localhost` in the URL.
- **Troubleshooting:** If you encounter issues, double-check for any typos in the code, ensure the server is running on the correct port, and verify that your firewall isn't blocking incoming connections.

#### Option 2: Connect with Simple HTTP Java Client

**Here's a simple Java client code that can connect to the HTTP server and retrieve content:**

```java
import java.io.*;
import java.net.Socket;

public class HTTPClient {

    public static void main(String[] args) throws IOException {
        String host = "localhost"; // Change to server's IP if needed
        int port = 8080; // Change to server's port if needed
        String resource = "/"; // Resource to request (e.g., "/index.html")

        try (Socket clientSocket = new Socket(host, port)) {
            PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            // Send HTTP GET request
            writer.println("GET " + resource + " HTTP/1.1");
            writer.println("Host: " + host);
            writer.println("Connection: close");
            writer.println();

            // Read response from server
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        }
    }
}
```

**To run this client code:**

1. Save it as a Java file (e.g., `HTTPClient.java`).
2. Compile it using `javac HTTPClient.java`.
3. Run it using `java HTTPClient`.

**Key Points:**

- It establishes a connection with the server using the specified host and port.
- It sends an HTTP GET request for the desired resource.
- It receives the server's response and prints it to the console.
- You can modify the `host`, `port`, and `resource` variables to connect to different servers and request different resources.

### Benefits of Multi-Client:

- **Scalability:** The multi-client version can handle multiple requests simultaneously, improving its ability to serve more clients efficiently.
- **Responsiveness:** By using threads, the server can remain responsive to new clients even while handling existing requests.
- **Efficiency:** Threads allow the server to utilize system resources more effectively compared to a single-threaded approach.

### Things to Remember:

- Implementing multi-threading introduces its own complexities and requires careful handling to avoid concurrency issues.
- The single-client version is simpler to understand and implement but may not be suitable for real-world scenarios with high traffic.

## Conclusion

Congratulations! You've built a basic HTTP server with single and multiple
clients in Java, venturing into the realm of network programming. Remember, this
is just the beginning. The internet awaits your further explorations!

- This is a simplified example for educational purposes. A production-ready
  server would have robust error handling, security measures, and more features.
- Always follow responsible development practices and avoid using your server
  for malicious purposes.
- Explore real-world HTTP servers and frameworks to gain deeper insights into
  web development.

I hope this comprehensive blog post empowers you to embark on your own adventures in socket programming and web development!
If you enjoyed this post, we encourage you to share it with your friends and
followers on social media and following us on twitter [@thetipseason](https://twitter.com/thetipseason)
