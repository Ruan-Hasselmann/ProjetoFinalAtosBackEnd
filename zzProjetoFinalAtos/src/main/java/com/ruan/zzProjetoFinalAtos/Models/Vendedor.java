package com.ruan.zzProjetoFinalAtos.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "vendedor")
public class Vendedor {
	
	@ApiModelProperty(notes = "Id do Vendedor", name = "id", required = false)
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ApiModelProperty(notes = "Nome", name="nome", required=true)
	@Column(nullable = false)
	private String nome;
	
	@ApiModelProperty(notes = "Cpf", name="cpf", required=true)
	@Column(nullable = false)
	private String cpf;
	
	@ApiModelProperty(notes = "Rg", name="rg", required=true)
	@Column(nullable = false)
	private String rg;
	
	@ApiModelProperty(notes = "Celular", name="celular", required=true)
	@Column(nullable = false)
	private String celular;
	
	@ApiModelProperty(notes = "Telefone", name="telefone", required=false)
	@Column(nullable = true)
	private String telefone;
	
	@ApiModelProperty(notes = "Cep", name="cep", required=true)
	@Column(nullable = false)
	private String cep;
	
	@ApiModelProperty(notes = "Rua", name="rua", required=true)
	@Column(nullable = false)
	private String rua;
	
	@ApiModelProperty(notes = "Bairro", name="bairro", required=true)
	@Column(nullable = false)
	private String bairro;
	
	@ApiModelProperty(notes = "Cidade", name="cidade", required=true)
	@Column(nullable = false)
	private String cidade;
	
	@ApiModelProperty(notes = "Uf", name="uf", required=true)
	@Column(nullable = false)
	private String uf;
	
	@ApiModelProperty(notes = "NumeroCasa", name="numeroCasa", required=true)
	@Column(nullable = false)
	private String numeroCasa;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
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
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	public String getNumeroCasa() {
		return numeroCasa;
	}
	public void setNumeroCasa(String numeroCasa) {
		this.numeroCasa = numeroCasa;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vendedor other = (Vendedor) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
