package com.ruan.zzProjetoFinalAtos.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ruan.zzProjetoFinalAtos.Models.Cliente;
import com.ruan.zzProjetoFinalAtos.Repositories.ClienteRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@Api(value = "Swagger2RestController",
description = "REST APIs relacionada ao cadastro de Clientes")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/clienteAPI")
public class ClienteController {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@ApiOperation(value = "Retorna todos os clientes", response = Iterable.class, tags = "Cliente")
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping
	public List<Cliente> listarClientes(){
		return clienteRepository.findAll();
	}
	
	@ApiOperation(value = "Adicionar", response = Iterable.class, tags = "Cliente")
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente adicionar(@RequestBody Cliente cliente) {
		if(cliente.getTelefone().equals("null")) {
			cliente.setTelefone("(00) 0000-0000");
		}
		cliente.setPago(0);
		cliente.setRestante(cliente.getTotal());
		return clienteRepository.save(cliente);
	}
	
	@ApiOperation(value = "Busca Cliente Nome", response = Iterable.class, tags = "Cliente")
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping("/getNome/{nome}")
	public List<Cliente> buscaClienteNome(@PathVariable String nome){
		return clienteRepository.findByNome(nome);
	}
	
	@ApiOperation(value = "Busca Cliente ID", response = Iterable.class, tags = "Cliente")
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping("/get/{id}")
	public Optional<Cliente> buscaClienteId(@PathVariable Long id){
		return clienteRepository.findById(id);
	}
	
	@ApiOperation(value = "Deletar Cliente", response = Iterable.class, tags = "Cliente")
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@DeleteMapping("/deletar/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletarCliente(@PathVariable Long id) {
		clienteRepository.deleteById(id);
	}
	
	@ApiOperation(value = "Atualizar", response = Iterable.class, tags = "Cliente")
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@PutMapping("/atualizar/{id}")
	public Cliente atualizaCliente(@org.springframework.web.bind.annotation.RequestBody Cliente cliente, @PathVariable Long id) {
		Cliente c = clienteRepository.getOne(id);
		if (c == null) {
			return null;
		}
		
		c.setNome(cliente.getNome());
		c.setCpf(cliente.getCpf());
		c.setRg(cliente.getRg());
		c.setCep(cliente.getCep());
		c.setRua(cliente.getRua());
		c.setBairro(cliente.getBairro());
		c.setCidade(cliente.getCidade());
		c.setUf(cliente.getUf());
		c.setNumeroCasa(cliente.getNumeroCasa());
		c.setDataCobranca(cliente.getDataCobranca());
		c.setTotal(cliente.getTotal());
		c.setCelular(cliente.getCelular());
		c.setTelefone(cliente.getCelular());
		c.setPago(cliente.getPago());
		if(cliente.getRestante()==0) {
			c.setRestante(cliente.getTotal());
		} else {
			c.setRestante(cliente.getRestante()+cliente.getTotal());
		}

		return clienteRepository.save(c);
	}
	
	@ApiOperation(value = "Busca Cliente Data", response = Iterable.class, tags = "Cliente")
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping("/dataCobranca/{dataCobranca}")
	public List<Cliente> buscaClienteData(@PathVariable String dataCobranca){
		return clienteRepository.findByDataCobranca(dataCobranca);
	}
	
	@ApiOperation(value = "Pagamento", response = Iterable.class, tags = "Cliente")
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@PutMapping("/pagamento/{id}")
	public Cliente pagamentoCliente(String dataCobranca, float pago, @PathVariable Long id) {
		Cliente c = clienteRepository.getOne(id);
		if (c == null) {
			return null;
		}
		
		System.out.println(dataCobranca + " " + pago);

		c.setNome(c.getNome());
		c.setCpf(c.getCpf());
		c.setRg(c.getRg());
		c.setCep(c.getCep());
		c.setRua(c.getRua());
		c.setBairro(c.getBairro());
		c.setCidade(c.getCidade());
		c.setUf(c.getUf());
		c.setNumeroCasa(c.getNumeroCasa());
		c.setDataCobranca(dataCobranca);
		c.setTotal(c.getTotal());
		c.setCelular(c.getCelular());
		c.setTelefone(c.getCelular());
		c.setPago(c.getPago()+pago);
		c.setRestante(c.getRestante()-pago);

		return clienteRepository.save(c);
	}
}