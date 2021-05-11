package com.ruan.zzProjetoFinalAtos.Repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ruan.zzProjetoFinalAtos.Models.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{
	List<Cliente> findByNome(String nome);
	List<Cliente> findByDataCobranca(String dataCobranca);
}
