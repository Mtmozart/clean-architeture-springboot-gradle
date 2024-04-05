package br.com.curso.application.gateway;

public interface UserAuthenticateGeteway {
    Boolean authenticate(String username, String password);
}
