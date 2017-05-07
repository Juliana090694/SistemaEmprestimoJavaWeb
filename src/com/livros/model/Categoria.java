package com.livros.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/*
 * Aqui estão os models de cada coisa no programa
 * 
 * Os objetos "Set" são responsáveis por guardar as instâncias do one-for-all
 * de cada uma das relaçõeas de chaves estrangeiras, não sei bem porque o hibernate
 * faz isso mas né
 * 
 * NÃO ALTERE ESSA MERDA QUE O BANCO VAI RECLAMAR
 * 
 * NÃO TEM COMO ALTERAR AS TABELAS DEPOIS DE CRIADAS
 * POR ALGUMA RAZÃO O AZURE BLOQUEIA A ALTERAÇÃO DAS COLUNAS
 * ENTÃO NEM ADIANTA MEXER AQUI QUE SÓ VAI DAR CAGADA
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
