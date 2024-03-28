package br.com.horario.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.horario.entity.CursosEntity;
import br.com.horario.repository.CursosRepository;

@Service
public class CursosServiceImpl implements CursosService {
	
	@Autowired
	private CursosRepository cursosRepository;
	
	private String mensagem;

	@Override
	public String save(CursosEntity cursosEntity) throws Exception {
		
		if (cursosEntity.getNome() == null) {
			this.mensagem = "Digite o nome do curso.";
			throw new Exception("Preencha o nome curso.");	
		} else {
			cursosRepository.saveAndFlush(cursosEntity);
			this.mensagem = "Curso cadastrado com sucesso";
		}
		return mensagem;
	}

	@Override
	public List<CursosEntity> findAll() {
		
		return cursosRepository.findAll();
	}

	@Override
	public CursosEntity getOneByIdCursos(Long idCursos) throws Exception {
		
		return cursosRepository.getOneByIdCursos(idCursos);
	}
	
	@Override
	public String deleteById(Long idCursos) throws Exception {
		try
		{
			cursosRepository.deleteById(idCursos);
			this.mensagem = "Curso Excluido com sucesso";
			
		} catch(Exception e) {
			throw new Exception(e.getMessage());
		}
		return mensagem;
	}


}
