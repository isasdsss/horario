package br.com.horario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.horario.entity.CursosEntity;

@Repository
public interface CursosRepository extends JpaRepository<CursosEntity, Long>{

	CursosEntity getOneByIdCursos(Long idCursos);
} 

