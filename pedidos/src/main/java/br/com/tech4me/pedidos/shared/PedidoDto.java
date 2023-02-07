package br.com.tech4me.pedidos.shared;

import br.com.tech4me.pedidos.model.Carro;

public class PedidoDto {
    private String nomeCliente;
    private String idCarro;
    private Carro dadosCarro;
    private Double valor;
    
    public String getNomeCliente() {
        return nomeCliente;
    }
    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }
    public String getIdCarro() {
        return idCarro;
    }
    public void setIdCarro(String idCarro) {
        this.idCarro = idCarro;
    }
    public Double getValor() {
        return valor;
    }
    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Carro getDadosCarro() {
        return dadosCarro;
    }
    public void setDadosCarro(Carro dadosCarro) {
        this.dadosCarro = dadosCarro;
    }
}
