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

import com.ruan.zzProjetoFinalAtos.Models.Vendedor;
import com.ruan.zzProjetoFinalAtos.Repositories.VendedorRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@Api(value = "Swagger2RestController",
description = "REST APIs relacionada ao cadastro de Vendedor")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/vendedorAPI")
public class VendedorController {
	
	//static VendedorCrud vendedorCrud = new VendedorCrud();
	
	@Autowired
	private VendedorRepository vendedorRepository;
	
	@ApiOperation(value = "Retorna todos os vendedores", response = Iterable.class, tags = "Vendedor")
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping
	public List<Vendedor> listarVendedores(){
		//vendedorCrud.setup();
		//vendedorCrud.listAll();
		
		return vendedorRepository.findAll();
	}
	
	@ApiOperation(value = "Adicionar", response = Iterable.class, tags = "Vendedor")
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Vendedor adicionar(@RequestBody Vendedor vendedor) {	
		if(vendedor.getTelefone().equals("null")) {
			vendedor.setTelefone("(00) 0000-0000");
		}
		
		//vendedorCrud.setup();
		//vendedorCrud.create(vendedor);
		
		return vendedorRepository.save(vendedor);
	}
	
	@ApiOperation(value = "Busca Vendedor", response = Iterable.class, tags = "Vendedor")
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping("/getNome/{nome}")
	public List<Vendedor> buscaVendedor(@PathVariable String nome){
		//vendedorCrud.setup();
		//vendedorCrud.queryWhere(nome);
		
		return vendedorRepository.findByNome(nome);
	}
	
	@ApiOperation(value = "Busca Vendedor ID", response = Iterable.class, tags = "Vendedor")
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping("/get/{id}")
	public Optional<Vendedor> buscaVendedor(@PathVariable Long id){
		//vendedorCrud.setup();
		//vendedorCrud.read(Integer.parseInt(id+""));
		
		return vendedorRepository.findById(id);
	}
	
	@ApiOperation(value = "Deletar Vendedor", response = Iterable.class, tags = "Vendedor")
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@DeleteMapping("/delete/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletarVendedor(@PathVariable Long id) {
		//vendedorCrud.setup();
		//vendedorCrud.delete(Integer.parseInt(id+""));
		
		vendedorRepository.deleteById(id);
	}
	
	@ApiOperation(value = "Atualizar", response = Iterable.class, tags = "Vendedor")
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@PutMapping("/atualizar/{id}")
	public Vendedor atualizarVendedor(@org.springframework.web.bind.annotation.RequestBody Vendedor vendedor, @PathVariable Long id) {
		Vendedor v = vendedorRepository.getOne(id);
		if (v == null) {
			return null;
		}

		v.setNome(vendedor.getNome());
		v.setCpf(vendedor.getCpf());
		v.setRg(vendedor.getRg());
		v.setCelular(vendedor.getCelular());
		v.setTelefone(vendedor.getTelefone());
		v.setCep(vendedor.getCep());
		v.setRua(vendedor.getRua());
		v.setBairro(vendedor.getBairro());
		v.setCidade(vendedor.getCidade());
		v.setUf(vendedor.getUf());
		v.setNumeroCasa(vendedor.getNumeroCasa());
		
		//vendedorCrud.setup();
		//vendedorCrud.update(v);

		return vendedorRepository.save(v);
	}
	
}




