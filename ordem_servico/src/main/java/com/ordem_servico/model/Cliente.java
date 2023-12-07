package com.ordem_servico.model;
import java.sql.Date;

public class Cliente extends GenericModel {
    
    private String nome;
    private Date dtNascimento;
    private String cpf;
    private String email;
    private Integer idEndereco;

    public Cliente (String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public Cliente (String nome, Date dtNascimento, String cpf) {
        this.nome = nome;
        this.dtNascimento = dtNascimento;
        this.cpf = cpf;
    }

    public Cliente (String nome, String cpf, String email) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
    }

    public Cliente (String nome, String cpf, Integer idEndereço) {
        this.nome = nome;
        this.cpf = cpf;
        this.idEndereco = idEndereço;
    }

    public Cliente (String nome, Date dtNascimento, String cpf, Integer idEndereço) {
        this.nome = nome;
        this.dtNascimento = dtNascimento;
        this.cpf = cpf;
        this.idEndereco = idEndereço;
    }

    public Cliente (String nome, String cpf, String email, Integer idEndereço) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.idEndereco = idEndereço;
    }

    public Cliente (String nome, Date dtNascimento, String cpf, String email) {
        this.nome = nome;
        this.dtNascimento = dtNascimento;
        this.cpf = cpf;
        this.email = email;
    }

    public Cliente (String nome, Date dtNascimento, String cpf, String email, Integer idEndereço) {
        this.nome = nome;
        this.dtNascimento = dtNascimento;
        this.cpf = cpf;
        this.email = email;
        this.idEndereco = idEndereço;
    }

    public Cliente (Integer id, String nome, Date dtNascimento, String cpf, String email, Integer idEndereço) {
        this.nome = nome;
        this.dtNascimento = dtNascimento;
        this.cpf = cpf;
        this.email = email;
        this.idEndereco = idEndereço;
        super.setId(id);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDtNascimento() {
        return dtNascimento;
    }

    public void setDtNascimento(Date dtNascimento) {
        this.dtNascimento = dtNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(int idEndereco) {
        this.idEndereco = idEndereco;
    }

    @Override
    public String toString() {
        return "Cliente {" +
                "id=" + getId() +
                "nome=" + nome + '\'' +
                "dtNascimento=" + dtNascimento +
                "cpf=" + cpf + '\'' +
                "email=" + email + '\'' +
                "idEndereco=" + idEndereco +
                '}';
    }


}

