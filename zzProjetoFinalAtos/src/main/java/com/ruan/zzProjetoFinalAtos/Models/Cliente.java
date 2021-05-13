package com.ruan.zzProjetoFinalAtos.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "Cliente")
public class Cliente {
	
	@ApiModelProperty(notes = "Id Cliente", name = "id", required = false)
	@Id
	@Column(name = "id")
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
	
	@ApiModelProperty(notes = "Cep", name="cep", required=true)
	@Column(nullable = false)
    private String cep;
	
	@ApiModelProperty(notes = "Logradouro", name="logradouro", required=true)
	@Column(nullable = false)
    private String logradouro;
	
	@ApiModelProperty(notes = "Bairro", name="bairro", required=true)
	@Column(nullable = false)
    private String bairro;
	
	@ApiModelProperty(notes = "Localidade", name="localidade", required=true)
	@Column(nullable = false)
    private String localidade;
	
	@ApiModelProperty(notes = "Uf", name="uf", required=true)
	@Column(nullable = false)
    private String uf;
	
	@ApiModelProperty(notes = "NumeroCasa", name="numeroCasa", required=true)
	@Column(nullable = false)
    private String numeroCasa;
	
	@ApiModelProperty(notes = "DatCobrança", name="dataCobranca", required=true)
	@Column(nullable = false)
    private String dataCobranca;
	
	@ApiModelProperty(notes = "Total", name="total", required=true)
	@Column(nullable = false)
    private float total;
	
	@ApiModelProperty(notes = "Celular", name="celular", required=true)
	@Column(nullable = false)
    private String celular;
	
	@ApiModelProperty(notes = "Telefone", name="telefone", required=false)
	@Column(nullable = true)
    private String telefone;
	
	@ApiModelProperty(notes = "Pago", name="pago", required=false)
	@Column(nullable = true)
    private float pago;
	
	@ApiModelProperty(notes = "Restante", name="restante", required=false)
	@Column(nullable = true)
    private float restante;
	
	public Cliente() {
		
	}
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

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getLogradouro() {
		return logradouro;
	}
	
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	
	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getLocalidade() {
		return localidade;
	}
	
	public void setLocalidade(String localidade) {
		this.localidade = localidade;
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

	public String getDataCobranca() {
		return dataCobranca;
	}

	public void setDataCobranca(String dataCobranca) {
		this.dataCobranca = dataCobranca;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
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

	public float getPago() {
		return pago;
	}

	public void setPago(float pago) {
		this.pago = pago;
	}

	public float getRestante() {
		return restante;
	}

	public void setRestante(float restante) {
		this.restante = restante;
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
		Cliente other = (Cliente) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
