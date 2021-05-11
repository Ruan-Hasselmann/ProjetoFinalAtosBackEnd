package com.ruan.zzProjetoFinalAtos.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ruan.zzProjetoFinalAtos.Models.Vendedor;

@Repository
public interface VendedorRepository extends JpaRepository<Vendedor, Long>
{
	List<Vendedor> findByNome(String nome);
}
