package com.mengangx.test.problems;

/*
 * Copyright (c) 2013, Oracle and/or its affiliates. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *
 *   - Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 *
 *   - Neither the name of Oracle or the names of its
 *     contributors may be used to endorse or promote products derived
 *     from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 * IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 * 
 * 
 * Adapted from http://docs.oracle.com/javase/tutorial/networking/sockets/examples/EchoServer.java
 * Server class that downloads stock information from Yahoo finance 
 * and pass it to client.
 * 
 * @Author: Mengang Xu
 */ 

import java.net.*;
import java.io.*;

public class StockServer {
    public static class ConnectionHandler implements Runnable {
        private Socket clientSocket;
        
        ConnectionHandler(Socket clientSocket) {
            this.clientSocket = clientSocket;
        }
        @Override
        public void run() {
            BufferedReader remote = null;
            try (      
                PrintWriter out =
                    new PrintWriter(clientSocket.getOutputStream(), true);                   
                BufferedReader in = new BufferedReader(
                    new InputStreamReader(clientSocket.getInputStream()));
                    
            ) {
                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    StringBuilder builder = new StringBuilder(
                            "http://download.finance.yahoo.com/d/quotes.csv?s=");
                    builder.append(inputLine.trim());
                    builder.append("&f=sl1p2");
                    URL url = new URL(builder.toString());
                    HttpURLConnection httpcon = (HttpURLConnection) url
                            .openConnection();
                    httpcon.addRequestProperty("User-Agent", "Mozilla/4.0");
                    remote = new BufferedReader(new InputStreamReader(
                            httpcon.getInputStream()));
                    out.println(remote.readLine());
                    remote.close();
                }
            } catch (IOException e) {
                System.out
                        .println("Exception caught when trying to listen for a connection");
                System.out.println(e.getMessage());
            } finally {
                if (remote != null) {
                    try {
                        remote.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            
        }
        
    }
    
    public static void main(String[] args) throws IOException {
        
        if (args.length != 1) {
            System.err.println("Usage: java EchoServer <port number>");
            System.exit(1);
        }
        
        int portNumber = Integer.parseInt(args[0]);
        
        ServerSocket serverSocket =
                new ServerSocket(portNumber);
        try{
            for (;;) {
                Socket clientSocket = serverSocket.accept();
                ConnectionHandler connectionHandler = new ConnectionHandler(
                        clientSocket);
                new Thread(connectionHandler).start();
            }
        } catch (Exception e){
            System.err.println(e.getMessage());
            System.exit(1);
        } finally {
            serverSocket.close();
        }
    }
}
