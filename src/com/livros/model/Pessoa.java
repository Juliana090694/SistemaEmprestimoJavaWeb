package com.livros.model;

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
 * 
 * Esse aqui � especial ent�o vou dar mais uma refor�ada
 * Aqui � a classe Pessoa que � herdada pelo Cliente e Funcion�rio
 * Isso se chama boas pr�ticas de programa��o e todo c�digo decente tem que ter eu acho,
 * Para o banco de dados � como se Nome, Nascimento e Telefone fossem vari�veis 
 * do Cliente/Funcion�rio ent�o n�o faz diferen�a alguma para ele, isso � s� para poupar
 * c�digo, tempo e paci�ncia.
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
