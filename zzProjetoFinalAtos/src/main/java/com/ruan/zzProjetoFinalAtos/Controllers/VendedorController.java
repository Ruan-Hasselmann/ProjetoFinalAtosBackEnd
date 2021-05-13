package com.ruan.zzProjetoFinalAtos.Controllers;

import java.util.List;
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

import com.ruan.zzProjetoFinalAtos.CRUD.VendedorCrud;
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
	
	static VendedorCrud vendedorCrud = new VendedorCrud();
	
	@Autowired
	private VendedorRepository vendedorRepository;
	
	@ApiOperation(value = "Retorna todos os vendedores", response = Iterable.class, tags = "Vendedor")
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping
	public List<Vendedor> listarVendedores(){
		vendedorCrud.setup();
		//vendedorCrud.listAll();
		//vendedorRepository.findAll();

		return vendedorCrud.listAll();
	}
	
	@ApiOperation(value = "Adicionar", response = Iterable.class, tags = "Vendedor")
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Vendedor adicionar(@RequestBody Vendedor vendedor) {	
		if(vendedor.getTelefone().equals("null")) {
			vendedor.setTelefone("(00) 0000-0000");
		}
		
		vendedorCrud.setup();
		vendedorCrud.create(vendedor);
		
	
		return vendedorRepository.save(vendedor);
	}
	
	@ApiOperation(value = "Busca Vendedor ID", response = Iterable.class, tags = "Vendedor")
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping("/get/{id}")
	public Vendedor buscaVendedor(@PathVariable Long id){
		vendedorCrud.setup();
		//vendedorCrud.read(id);
		//vendedorRepository.findById(id);
		
		return vendedorCrud.read(id);
	}
	
	@ApiOperation(value = "Deletar Vendedor", response = Iterable.class, tags = "Vendedor")
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@DeleteMapping("/delete/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletarVendedor(@PathVariable Long id) {
		vendedorCrud.setup();
		vendedorCrud.delete(id);
		//vendedorRepository.deleteById(id);
	}
	
	@ApiOperation(value = "Atualizar", response = Iterable.class, tags = "Vendedor")
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@PutMapping("/atualizar/{id}")
	public Vendedor atualizarVendedor(@org.springframework.web.bind.annotation.RequestBody Vendedor vendedor, @PathVariable Long id) {
		vendedorCrud.setup();
		Vendedor v = vendedorCrud.read(id);
		if (v == null) {
			return null;
		}

		v.setNome(vendedor.getNome());
		v.setCpf(vendedor.getCpf());
		v.setRg(vendedor.getRg());
		v.setCelular(vendedor.getCelular());
		v.setTelefone(vendedor.getTelefone());
		v.setCep(vendedor.getCep());
		v.setLogradouro(vendedor.getLogradouro());
		v.setBairro(vendedor.getBairro());
		v.setLocalidade(vendedor.getLocalidade());
		v.setUf(vendedor.getUf());
		v.setNumeroCasa(vendedor.getNumeroCasa());
		
		
		vendedorCrud.update(v);

		return vendedorRepository.save(v);
	}
	
}




