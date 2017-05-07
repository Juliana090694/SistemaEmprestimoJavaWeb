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
 */
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Funcionario")
public class Funcionario extends Pessoa{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String endereco;
	private String funcao;
	private String contratacao;
	private String login;
	private String senha;
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public int getId() {
		return id;
	}
	public void setId(int cod_func) {
		this.id = cod_func;
	}
	public String getFuncao() {
		return funcao;
	}
	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}
	public String getContratacao() {
		return contratacao;
	}
	public void setContratacao(String contratacao) {
		this.contratacao = contratacao;
	}
	
	
}
