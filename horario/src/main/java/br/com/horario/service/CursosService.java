package br.com.horario.service;

import java.util.List;

import br.com.horario.entity.CursosEntity;

public interface CursosService {

	String save(CursosEntity cursosEntity) throws Exception;
	List<CursosEntity> findAll();
	CursosEntity getOneByIdCursos (Long idCursos) throws Exception; 
	String deleteById(Long idCursos) throws Exception;
	
	
}
