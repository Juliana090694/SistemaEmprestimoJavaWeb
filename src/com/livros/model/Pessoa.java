package com.livros.model;

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
 * 
 * Esse aqui é especial então vou dar mais uma reforçada
 * Aqui é a classe Pessoa que é herdada pelo Cliente e Funcionário
 * Isso se chama boas práticas de programação e todo código decente tem que ter eu acho,
 * Para o banco de dados é como se Nome, Nascimento e Telefone fossem variáveis 
 * do Cliente/Funcionário então não faz diferença alguma para ele, isso é só para poupar
 * código, tempo e paciência.
 */

public class Pessoa {
	protected String nome;
	protected String nascimento;
	protected String telefone;
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getNascimento() {
		return nascimento;
	}
	public void setNascimento(String nascimento) {
		this.nascimento = nascimento;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	
}
