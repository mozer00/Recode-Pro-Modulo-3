package br.com.crud.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Viagem {
    private int id;
    private double valorDiaria;
    private Date dataIda;
    private Date dataVolta;
    private Destino destino;
    private Cliente cliente;
    public Viagem() {
	}
	public Viagem(int id, double valorDiaria, Date dataIda, Date dataVolta, Destino destino, Cliente cliente) {
		this.id = id;
		this.valorDiaria = valorDiaria;
		this.dataIda = dataIda;
		this.dataVolta = dataVolta;
		this.destino = destino;
		this.cliente = cliente;
	}
	public Viagem(double valorDiaria, Date dataIda, Date dataVolta, Destino destino, Cliente cliente) {
		this.valorDiaria = valorDiaria;
		this.dataIda = dataIda;
		this.dataVolta = dataVolta;
		this.destino = destino;
		this.cliente = cliente;
	}
		
	public Viagem(double valorDiaria, Date dataIda, Date dataVolta) {
		this.valorDiaria = valorDiaria;
		this.dataIda = dataIda;
		this.dataVolta = dataVolta;
	}
	
	public Viagem(int id, double valorDiaria, Date dataIda, Date dataVolta) {
		this.id = id;
		this.valorDiaria = valorDiaria;
		this.dataIda = dataIda;
		this.dataVolta = dataVolta;
	}
	

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getValorDiaria() {
		return valorDiaria;
	}
	public void setValorDiaria(double valorDiaria) {
		this.valorDiaria = valorDiaria;
	}
	public Date getDataIda() {
		return dataIda;
	}
	public void setDataIda(Date dataIda) {
		this.dataIda = dataIda;
	}
	public Date getDataVolta() {
		return dataVolta;
	}
	public void setDataVolta(Date dataVolta) {
		this.dataVolta = dataVolta;
	}
	public Destino getDestino() {
		return destino;
	}
	public void setDestino(Destino destino) {
		this.destino = destino;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	private String formatMoeda(double value) { 
		return "R$ " + String.format("%.2f", value);
		
	}
	
	@Override
	public String toString() {
		
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		
		return "Viagem [ Id da Viagem = " + id + ", Valor da Diaria = " + formatMoeda(valorDiaria) + ", Data da Ida = " + format.format(dataIda) + ", Data da Volta = " + format.format(dataVolta)
				+ ", Destino = " + destino.getCidade() + " - "+ destino.getPais() + ", Nome = " + cliente.getNome() + ", CPF = " + cliente.getCpf()+ ", Telefone = " + cliente.getTelefone() + " ]";
	}
    
    
}
