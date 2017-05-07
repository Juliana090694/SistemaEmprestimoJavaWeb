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
@Table(name="Livro")
public class Livro {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String nome;
	private String autor;
	private String tipo;
	private String colecao;
	private int n_pag;
	private String tipo_capa;
	private String editora;
	private String publicacao;
	private String situacao;
	private boolean emprestado;
	private String localizacao;
	private Categoria categoria = new Categoria();
	
	private Set<Emprestimo> emprestimos =
			new HashSet<Emprestimo>(0);
	
	public Set<Emprestimo> getEmprestimos() {
		return emprestimos;
	}
	public void setEmprestimos(Set<Emprestimo> emprestimos) {
		this.emprestimos = emprestimos;
	}
	public int getId() {
		return id;
	}
	public void setId(int cod_li) {
		this.id = cod_li;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getColecao() {
		return colecao;
	}
	public void setColecao(String colecao) {
		this.colecao = colecao;
	}
	public int getN_pag() {
		return n_pag;
	}
	public void setN_pag(int n_pag) {
		this.n_pag = n_pag;
	}
	public String getTipo_capa() {
		return tipo_capa;
	}
	public void setTipo_capa(String tipo_capa) {
		this.tipo_capa = tipo_capa;
	}
	public String getEditora() {
		return editora;
	}
	public void setEditora(String editora) {
		this.editora = editora;
	}
	public String getPublicacao() {
		return publicacao;
	}
	public void setPublicacao(String publicacao) {
		this.publicacao = publicacao;
	}
	public String getSituacao() {
		return situacao;
	}
	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}
	public boolean isEmprestado() {
		return emprestado;
	}
	public void setEmprestado(boolean emprestado) {
		this.emprestado = emprestado;
	}
	public String getLocalizacao() {
		return localizacao;
	}
	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
}
