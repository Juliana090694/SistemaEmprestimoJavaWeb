package com.livros.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.livros.dal.LivroDAO;
import com.livros.model.Categoria;
import com.livros.model.Livro;

@ManagedBean(name = "mLivroBean")
@SessionScoped
public class MLivroBean {
	//Usada pelos métodos e pelo cliente para guardar suas infos
	private Livro livro = new Livro();
	//guarda id da categoria para guardar em livro
	private int idCategoria;

	//pega id da categoria do livro
	public int getIdCategoria() {
		return idCategoria;
	}
	
	//seta id da categoria na variavel e no livro
	public void setIdCategoria(int idCategoria) {
		if (livro.getCategoria() == null){
			livro.setCategoria(new Categoria());
		}
		livro.getCategoria().setId(idCategoria);
		this.idCategoria = idCategoria;
	}
	
	//retorna o livro
	public Livro getLivro() {
		return livro;
	}
	
	//seta o livro
	public void setLivro(Livro livro) {
		this.livro = livro;
	}
	
	//retorna a lista de livros no banco de dados
	public List<Livro> getLivros() {
		return LivroDAO.retornarLivro();
	}
	
	//adiciona livro no banco de dados
	public String adicionarLivro(Livro l){
		l.setEmprestado(false);
		LivroDAO.adicionar(l);
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "CadastroLivro.xhtml?faces-redirect=true";
	}
	
	//remove livro do banco de dados
	public String removerLivro(Livro l){
		LivroDAO.remover(l);
		return "ListarLivro.xhtml?faces-redirect=true";
	}
	
	//vai a pagina de alterar livro
	public String enviarLivroParaAlterar(Livro l){
		this.livro = l;
		return "AlterarLivro.xhtml?faces-redirect=true";
	}
	
	//envia alterações de livro ao banco de dados
	public String alterarLivro(Livro l){
		LivroDAO.alterar(l);
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "ListarLivro.xhtml?faces-redirect=true";
	}
	
	//vai a pagina de cadastro do livro
	public String irCadastro(){
		return "CadastroLivro.xhtml";
	}
	
	//vai a lista de livros
	public String irLista(){
		return "ListarLivro.xhtml";
	}
	
	//vai ao menu de livros(?)
	public String irMenu(){
		return "MenuLivro.xhtml";
	}
	
}
