package br.com.horario.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.horario.entity.DocenteEntity;
import br.com.horario.repository.DocenteRepository;

@Service
public class DocenteServiceImpl implements DocenteService {
	
	@Autowired
	private DocenteRepository docenteRepository;
	
	private String mensagem;

	@Override
	public String save(DocenteEntity docenteEntity) throws Exception {
		
		if (docenteEntity.getNome() == null) {
			this.mensagem = "Digite o nome do docente.";
			throw new Exception("Preencha o nome docente.");
			
		} else if (docenteEntity.getSobrenome() == null){
			this.mensagem = "Digite o sobrenome do docente.";
			throw new Exception("Preencha o sobrenome docente.");

		} else if (docenteEntity.getEmail() == null) {
			this.mensagem = "Digite o nome do docente.";
			throw new Exception("Preencha o nome docente.");
		} else {
			docenteRepository.incluirDocente(docenteEntity.getNome(), docenteEntity.getSobrenome(), docenteEntity.getCpf(), docenteEntity.getEmail(), docenteEntity.getSetor().getIdSetor());
			this.mensagem = "Docente cadastrado com sucesso";
		}
		return mensagem;
	}
	
	@Override
	public String update(DocenteEntity docenteEntity) throws Exception {
		
		if (docenteEntity.getNome() == null) {
			this.mensagem = "Digite o nome do docente.";
			throw new Exception("Preencha o nome docente.");
			
		} else if (docenteEntity.getSobrenome() == null){
			this.mensagem = "Digite o sobrenome do docente.";
			throw new Exception("Preencha o sobrenome docente.");

		} else if (docenteEntity.getEmail() == null) {
			this.mensagem = "Digite o nome do docente.";
			throw new Exception("Preencha o nome docente.");
		} else {
			docenteRepository.alterarDocente(docenteEntity.getNome(), docenteEntity.getSobrenome(), docenteEntity.getCpf(), docenteEntity.getEmail(), docenteEntity.getSetor().getIdSetor(), docenteEntity.getIdDocente());
			this.mensagem = "Docente cadastrado com sucesso";
		}
		return mensagem;
	}

	@Override
	public List<DocenteEntity> findAll() {
		
		return docenteRepository.listarDocentes();
	}

	@Override
	public DocenteEntity getOneByIdDocente(Long idDocente) throws Exception {
		
		return docenteRepository.getOneByIdDocente(idDocente);
	}
	
	@Override
	public String deleteById(Long idDocente) throws Exception {
		try
		{
			docenteRepository.excluirDocente(idDocente);
			this.mensagem = "Docente Excluido com sucesso";
			
		} catch(Exception e) {
			throw new Exception(e.getMessage());
		}
		return mensagem;
	}

		
		
		
		
		
		
		
		
		
		
}
