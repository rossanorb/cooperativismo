package com.cooperativismo.ApiRest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cooperativismo.ApiRest.models.Associado;

@Repository
public interface AssociadoRepository extends JpaRepository<Associado, Long >{
	public Associado findByCpf(String cpf);
}
