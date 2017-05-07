package com.livros.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/*
 * Aqui est�o os models de cada coisa no programa
 * 
 * Os objetos "Set" s�o respons�veis por guardar as inst�ncias do one-for-all
 * de cada uma das rela��eas de chaves estrangeiras, n�o sei bem porque o hibernate
 * faz isso mas n�
 * 
 * N�O ALTERE ESSA MERDA QUE O BANCO VAI RECLAMAR
 * 
 * N�O TEM COMO ALTERAR AS TABELAS DEPOIS DE CRIADAS
 * POR ALGUMA RAZ�O O AZURE BLOQUEIA A ALTERA��O DAS COLUNAS
 * ENT�O NEM ADIANTA MEXER AQUI QUE S� VAI DAR CAGADA
 * Obrigada.
 */

@Entity
@Table(name="Categoria")
public class Categoria {

	private String nome;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String descricao;
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	private Set<Livro> livros =
			new HashSet<Livro>(0);
	
	public Set<Livro> getLivros() {
		return livros;
	}
	public void setLivros(Set<Livro> livros) {
		this.livros = livros;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
}
