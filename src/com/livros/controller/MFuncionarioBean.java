package com.livros.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.livros.dal.FuncionarioDAO;
import com.livros.model.Funcionario;

@ManagedBean(name="mFuncionarioBean")
@SessionScoped
public class MFuncionarioBean {
	//Usada pelos métodos e pelo cliente para guardar suas infos
	private Funcionario funcionario = new Funcionario();
	//variavel que guarda id do funcionario do menu na pagina para inclusão futura
	private int idLogin = 0;
	
	//retorna id do login armazenado
	public int getIdLogin() {
		return idLogin;
	}
	
	//setava o id de login do funcionario para o funcionario e seta tambem para idLogin
	public void setIdLogin(int idLogin) {
		//funcionario.setId(idLogin);
		this.idLogin = idLogin;
	}

	//retorna funcionario
	public Funcionario getFuncionario() {
		return funcionario;
	}
	
	//seta funcionario
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	
	//pega lista de funcionarios do banco de dados
	public List<Funcionario> getFuncionarios() {
		return	FuncionarioDAO.retornarFuncionario();
	}
	
	//adiciona funcionario ao banco de dados
	public String adicionarFuncionario(Funcionario f){
		f.setLogin("NotUsed");
		FuncionarioDAO.adicionar(f);
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "CadastrarLoginFuncionario.xhtml?faces-redirect=true";
	}
	
	//remove funcionario do banco de dados
	public String removerFuncionario(Funcionario f){
		FuncionarioDAO.remover(f);
		return "ListarFuncionario.xhtml?faces-redirect=true";
	}
	
	//redireciona funcionario para a pagina que altera funcionario existente
	public String enviarDadosFuncionarioAlterar(Funcionario f){
		this.funcionario=f;
		return"AlterarFuncionario.xhtml?faces-redirect=true";
	}
	
	//manda alteração de funcionario para o banco de dados
	public String alterarFuncionario(Funcionario f){
		FuncionarioDAO.alterar(f);
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return"ListarFuncionario.xhtml?faces-redirect=true";
	}
	
	//vai a lista de funcionarios
	public String irLista(){
		return "ListarFuncionario.xhtml";
	}
	
	
	//pega id e senha digitados, verifica se existe no banco o id e confirma a senha para ver se bate
	//se sim, vai a Index, se não, volta ao login
	public String login(Funcionario f){
		Funcionario funcionario = FuncionarioDAO.buscar(f.getId());
		if (funcionario != null){
			if (funcionario.getSenha().equals(f.getSenha())){
				return "Index.xhtml?faces-redirect=true";
			}
		}
		return "logar.xhtml?faces-redirect=true";
	}
}
