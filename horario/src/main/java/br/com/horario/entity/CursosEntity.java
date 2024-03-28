package br.com.horario.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "cursos", schema = "horario")
public class CursosEntity implements Serializable{

private static final long serialVersionUID = 1L;

     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     @Column(name = "id_cursos")
     private Long  idCursos;

     @Column(name = "nome")
     private String nome;

	public Long getIdCursos() {
		return idCursos;
	}

	public void setIdCursos(Long idCursos) {
		this.idCursos = idCursos;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}


 
}
