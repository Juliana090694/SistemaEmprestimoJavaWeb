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
@Table(name="Cliente")
public class Cliente extends Pessoa {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String email;
	private String cpf;
	
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
	public void setId(int cod_cli) {
		this.id = cod_cli;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
}
