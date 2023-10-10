package br.com.crud.model;

import java.util.Set;


public class Destino {
    private int id;
    private double valorPassagem;
	private String cidade;
    private String pais;
    private Set<Viagem> viagens;
	public Destino() {
	}
	public Destino(int id, double valorPassagem, String cidade, String pais, Set<Viagem> viagens) {
		this.id = id;
		this.valorPassagem = valorPassagem;
		this.cidade = cidade;
		this.pais = pais;
		this.viagens = viagens;
	}
	public Destino(double valorPassagem, String cidade, String pais, Set<Viagem> viagens) {
		this.valorPassagem = valorPassagem;
		this.cidade = cidade;
		this.pais = pais;
		this.viagens = viagens;
	}
	
	public Destino(double valorPassagem, String cidade, String pais) {
		this.valorPassagem = valorPassagem;
		this.cidade = cidade;
		this.pais = pais;
	}
	
	public Destino(int id, double valorPassagem, String cidade, String pais) {
		this.id = id;
		this.valorPassagem = valorPassagem;
		this.cidade = cidade;
		this.pais = pais;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getValorPassagem() {
		return valorPassagem;
	}
	public void setValorPassagem(double valorPassagem) {
		this.valorPassagem = valorPassagem;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public Set<Viagem> getViagens() {
		return viagens;
	}
	public void setViagens(Set<Viagem> viagens) {
		this.viagens = viagens;
	}
	
	private String formatMoeda(double value) {
		return "R$ " + String.format("%.2f", value);
	}
		
	@Override
	public String toString() {
		
			
		return "Destino [ id = " + id + ", Valor da Passagem = " + formatMoeda(valorPassagem ) + ", Cidade Destino = " + cidade
				+ ", País Destino = " + pais + " ]";
		 

	}
    
    
}
