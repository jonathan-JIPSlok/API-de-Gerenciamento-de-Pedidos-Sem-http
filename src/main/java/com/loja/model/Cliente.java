package main.java.com.loja.model;

import java.util.Random;

public class Cliente {
    private final Long id;
    private String nome;
    private String email;

    public Cliente(String nome, String email) {
        this.id = new Random().nextLong();
        setNome(nome);
        setEmail(email);
    }

    public void setNome(String nome) {
        if (nome == null || nome.isEmpty()) {
            throw new IllegalArgumentException("Nome deve ser informado");
        }
        this.nome = nome;
    }

    public void setEmail(String email) {
        if (email == null || email.isEmpty()) {
            throw new IllegalArgumentException("Email deve ser informado");
        }
        this.email = email;
    }

    public Long getId() {
        return id;
    }
    public String getNome() {return nome;}
    public String getEmail() {return email;}
}
