package com.livros.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.livros.dal.CategoriaDAO;
import com.livros.model.Categoria;

@ManagedBean(name="mCategoriaBean")
@SessionScoped
public class MCategoriaBean {
	//Usada pelos métodos e pelo cliente para guardar suas infos
	private Categoria categoria = new Categoria();
	
	//retorna categoria para quem chamou
	public Categoria getCategoria() {
		return categoria;
	}
	//Seta a categoria para o passado
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	//Pega a lista de categorias do banco de dados
	public List<Categoria> getCategorias() {
		return CategoriaDAO.retornarCategoria();
	}
	//adiciona categoria no banco de dados
	public String adicionarCategoria(Categoria c){
		CategoriaDAO.adicionar(c);
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "CadastrarCategoria.xhtml?faces-redirect=true";
	}
	//remove categoria do banco de dados
	public String removerCategoria(Categoria c){
		CategoriaDAO.remover(c);
		return "ListarCategoria.xhtml?faces-redirect=true";
	}
	//busca categoria no banco de dados e seta para a atual
	public String enviarDadosCategoriaAlterar(Categoria c){
		this.categoria=CategoriaDAO.buscar(c.getId());
		return"AlterarCategoria.xhtml?faces-redirect=true";
	}
	//altera a categoria no banco de dados (substitui a presente)
	public String alterarCategoria(Categoria c){
		CategoriaDAO.alterar(c);
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return"ListarCategoria.xhtml?faces-redirect=true";
	}
	//Vai para página de cadastro
	public String irCadastro(){
		return "CadastrarCategoria.xhtml?faces-redirect=true";
	}
	//Vai para a lista de categorias
	public String irLista(){
		return "ListarCategoria.xhtml?faces-redirect=true";
	}
	//busca no banco de dados uma categoria(por id)
	public Categoria buscar(int id){
		return CategoriaDAO.buscar(id);
	}
	

}
