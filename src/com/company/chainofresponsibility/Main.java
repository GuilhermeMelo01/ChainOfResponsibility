package com.company.chainofresponsibility;

import com.company.chainofresponsibility.middlewares.CheckPermissionMiddleware;
import com.company.chainofresponsibility.middlewares.CheckUserMiddleware;
import com.company.chainofresponsibility.middlewares.Middleware;
import com.company.chainofresponsibility.server.Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static Server server;

    public static void init(){
        server = new Server();
        server.registerUser("zequinh4@gmail.com", "273496uhfa##g78");
        server.registerUser("userCrazy@gmail.com", "123456789");

        Middleware middleware = new CheckUserMiddleware(server);
        middleware.linkWith(new CheckPermissionMiddleware());

        server.setMiddleware(middleware);
    }
    public static void main(String[] args) throws IOException {
        init();

        boolean done = false;

        if (!done) {
            System.out.println("Digite o email: ");
            String email = reader.readLine();
            System.out.println("Digite sua senha: ");
            String password = reader.readLine();
            server.logIn(email, password);
        }
    }
}
