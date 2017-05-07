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
