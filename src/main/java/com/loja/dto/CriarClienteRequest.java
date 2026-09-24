package main.java.com.loja.dto;

public class CriarClienteRequest {
    private final String nome;
    private final String email;

    public CriarClienteRequest(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    public String getNome() {return nome;}
    public String getEmail() {return email;}
}
