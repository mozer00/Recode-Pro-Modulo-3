package br.com.crud.model;

import java.util.Set;

public class Cliente {
	
	private int id;
    private String nome;
    private String cpf;
    private String telefone;
    private Set<Viagem> viagens;

    public Cliente() {
    }

    
	public Cliente(int id, String nome, String cpf, String telefone) {
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.telefone = telefone;
	}

	public Cliente(int id, String nome, String cpf, String telefone, Set<Viagem> viagens) {
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.telefone = telefone;
		this.viagens = viagens;
	}

	public Cliente(String nome, String cpf, String telefone, Set<Viagem> viagens) {
		this.nome = nome;
		this.cpf = cpf;
		this.telefone = telefone;
		this.viagens = viagens;
	}
	

	public Cliente(String nome, String cpf, String telefone) {
		this.nome = nome;
		this.cpf = cpf;
		this.telefone = telefone;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Set<Viagem> getViagens() {
		return viagens;
	}

	public void setViagens(Set<Viagem> viagens) {
		this.viagens = viagens;
	}

	@Override
	public String toString() {
		return "Cliente [ id = " + id + ", Nome = " + nome + ", CPF = " + cpf + ", Telefone = " + telefone + " ]";
	}
    
	
    
	
}
