package com.ordem_servico.model;

public class Empresa extends GenericModel {

    private String nomeFantasia;
    private String cnpj;
    private String slogan;
    private int idEndereco;

    public Empresa (String nomeFantasia, String cnpj, Integer idEndereco) {
        this.nomeFantasia = nomeFantasia;
        this.cnpj = cnpj;
        this.idEndereco = idEndereco;
    }

    public Empresa (String nomeFantasia, String cnpj, String slogan, Integer idEndereco) {
        this.nomeFantasia = nomeFantasia;
        this.cnpj = cnpj;
        this.slogan = slogan;
        this.idEndereco = idEndereco;
    }

    public Empresa (Integer id, String nomeFantasia, String cnpj, String slogan, Integer idEndereco) {
        this.nomeFantasia = nomeFantasia;
        this.cnpj = cnpj;
        this.slogan = slogan;
        this.idEndereco = idEndereco;
        super.setId(id);
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getSlogan() {
        return slogan;
    }

    public void setSlogan(String slogan) {
        this.slogan = slogan;
    }

    public int getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(int idEndereco) {
        this.idEndereco = idEndereco;
    }

    @Override
    public String toString() {
        return "Empresa {" +
                "id=" + getId() +
                "nomeFantasia=" + nomeFantasia + '\'' +
                "cnpj=" + cnpj + '\'' +
                "slogan=" + slogan + '\'' +
                "idEndereco=" + idEndereco +
                '}';
    }
}

