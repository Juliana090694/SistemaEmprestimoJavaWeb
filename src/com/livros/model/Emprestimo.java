package com.livros.model;

import java.util.Date;

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
@Table(name="Emprestimo")
public class Emprestimo {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private int quantidade;
	private Date data_retirada;
	private Date data_devolucao;
	private Livro livro = new Livro();
	private Cliente cliente = new Cliente();
	private String descricao;
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public int getId() {
		return id;
	}
	public void setId(int cod_emp) {
		this.id = cod_emp;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public Date getData_retirada() {
		return data_retirada;
	}
	public void setData_retirada(Date data_retirada) {
		this.data_retirada = data_retirada;
	}
	public Date getData_devolucao() {
		return data_devolucao;
	}
	public void setData_devolucao(Date data_devolucao) {
		this.data_devolucao = data_devolucao;
	}
	public Livro getLivro() {
		return livro;
	}
	public void setLivro(Livro livro) {
		this.livro = livro;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
}
