package com.cooperativismo.ApiRest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cooperativismo.ApiRest.models.Pauta;

@Repository
public interface PautaRepository extends JpaRepository<Pauta, Long>{

}
