package br.com.tech4me.garagem.shared;

public class GaragemCompletoDto {
    
    private String id;
    private String nome;
    private String setup;
    private String cor;
    private String km;
    private double valor;


    public double getValor() {
        return valor;
    }
    public void setValor(double valor) {
        this.valor = valor;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getSetup() {
        return setup;
    }
    public void setSetup(String setup) {
        this.setup = setup;
    }
    public String getCor() {
        return cor;
    }
    public void setCor(String cor) {
        this.cor = cor;
    }
    public String getKm() {
        return km;
    }
    public void setKm(String km) {
        this.km = km;
    } 
}


