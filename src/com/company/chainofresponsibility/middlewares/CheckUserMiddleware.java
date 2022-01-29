package com.company.chainofresponsibility.middlewares;

import com.company.chainofresponsibility.server.Server;

public class CheckUserMiddleware extends Middleware{

    private Server server;

    public CheckUserMiddleware(Server server){
        this.server = server;
    }

    @Override
    public boolean check(String email, String password) {
        if (!server.hasEmail(email)){
            System.out.println("Email invalido!");
            return false;
        }

        if (!server.isValidPassword(email, password)){
            System.out.println("Email ou Senha invalidos!");
            return false;
        }

        return checkNext(email, password);
    }
}
