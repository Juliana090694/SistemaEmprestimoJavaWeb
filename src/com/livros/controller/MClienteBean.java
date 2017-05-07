package com.livros.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.livros.dal.ClienteDAO;
import com.livros.model.Cliente;

@ManagedBean(name="mClienteBean")
@SessionScoped
public class MClienteBean {
	//Usada pelos métodos e pelo cliente para guardar suas infos
	private Cliente cliente = new Cliente();
	//pega o cliente
	public Cliente getCliente() {
		return cliente;
	}
	//seta o cliente
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	//pega lista de clientes no banco de dados
	public List<Cliente> getClientes() {
		return	ClienteDAO.retornarCliente();
	}
	//adiciona cliente no banco de dados
	public String adicionarCliente(Cliente c){
		ClienteDAO.adicionar(c);
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "CadastroCliente.xhtml?faces-redirect=true";
	}
	//remove cliente do banco de dados
	public String removerCliente(Cliente c){
		ClienteDAO.remover(c);
		return "ListarCliente.xhtml?faces-redirect=true";
	}
	//passa cliente para alteração
	public String enviarDadosClienteAlterar(Cliente c){
		this.cliente=c;
		return"AlterarCliente.xhtml?faces-redirect=true";
	}
	//altera cliente no banco de dados
	public String alterarCliente(Cliente c){
		ClienteDAO.alterar(c);
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return"ListarCliente.xhtml?faces-redirect=true";
	}
	//vai a página da lista
	public String irLista(){
		return "ListarCliente.xhtml";
	}
	//vai a página de cadastro
	public String irCadastro(){
		return "CadastroCliente.xhtml";
	}
}
