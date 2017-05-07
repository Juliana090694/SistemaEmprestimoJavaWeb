package com.livros.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.livros.dal.EmprestimoDAO;
import com.livros.dal.LivroDAO;
import com.livros.model.Cliente;
import com.livros.model.Emprestimo;
import com.livros.model.Livro;

@ManagedBean(name="mEmprestimoBean")
@SessionScoped
public class MEmprestimoBean {
	//Usada pelos métodos e pelo cliente para guardar suas infos
	private Emprestimo emprestimo = new Emprestimo();
	//guarda id do cliente do menu seletor para incluir depois no emprestimo
	private int idCliente;	
	//guarda id do livro do menu seletor para incluir depois no livro
	private int idLivro;
	
	private List<Livro> livros = new ArrayList<Livro>();
	
	public List<Livro> getLivros() {
		return livros;
	}
	
	public void setLivros(List<Livro> livros) {
		this.livros = livros;
	}
	
	@PostConstruct
	public void init() {
		atualizarListaLivro();
	}
	
	//retorna id do cliente
	public int getIdCliente() {
		return idCliente;
	}
	//seta id do cliente na variável idCliente e também no objeto cliente dentro de emprestimo
	//se não houver cliente em emprestimo ele cria um
	public void setIdCliente(int idCliente) {
		if (emprestimo.getCliente() == null){
			emprestimo.setCliente(new Cliente());
		}
		emprestimo.getCliente().setId(idCliente);
		this.idCliente = idCliente;
	}
	//retorna id do livro
	public int getIdLivro() {
		return idLivro;
	}
	//seta id do livro na variável idLivro e também no objeto livro dentro de emprestimo
	//se não houver livro em emprestimo ele cria um 
	public void setIdLivro(int idLivro) {
		if (emprestimo.getLivro() == null){
			emprestimo.setLivro(new Livro());
		}
		emprestimo.getLivro().setId(idLivro);
		this.idLivro = idLivro;
	}
	//retorna o emprestimo
	public Emprestimo getEmprestimo() {
		return emprestimo;
	}
	//seta o emprestimo
	public void setEmprestimo(Emprestimo emprestimo) {
		this.emprestimo = emprestimo;
	}
	//retorna lista de emprestimos do banco de dados
	public List<Emprestimo> getEmprestimos() {
		
		return EmprestimoDAO.retornarEmprestimo();
	}
	//adiciona emprestimo no banco de dados
	public String adicionarEmprestimo(Emprestimo c){
		Livro livro = LivroDAO.buscar(c.getLivro().getId());
		livro.setEmprestado(true);
		LivroDAO.alterar(livro);
		EmprestimoDAO.adicionar(c);
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "OkDoEmprestimo.xhtml?faces-redirect=true";
	}
	
	//remove emprestimo do banco de dados (fikadik para um futuro CRUD de empréstimo)
	public String removerEmprestimo(Emprestimo e){
		Livro livro = LivroDAO.buscar(e.getLivro().getId());
		livro.setEmprestado(false);
		LivroDAO.alterar(livro);
		atualizarListaLivro();
		EmprestimoDAO.remover(e);
		return "TodosOsEmprestimo.xhtml?faces-redirect=true";
	}
	
	//passa emprestimo para alteração (fikadik para um futuro CRUD de empréstimo)
	public String enviarDadosEmprestimoAlterar(Emprestimo e){
		this.emprestimo=e;
		return "AlterarEmprestimo.xhtml?faces-redirect=true";
	}
	
	//altera o emprestimo no banco (fikadik para um futuro CRUD de empréstimo)
	public String alterarEmprestimo(Emprestimo e){
		EmprestimoDAO.alterar(e);
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return"TodosOsEmprestimo.xhtml?faces-redirect=true";
	}
	
	//Vai a lista de emprestimos 
	public String irLista(){
		return "TodosOsEmprestimo.xhtml?faces-redirect=true";
	}
	
	public String detalhamentoDeEmprestimo(Emprestimo emprestimo){
		this.emprestimo = emprestimo;
		return "DetalharEmprestimo.xhtml?faces-redirect=true";
	}
	
	private void atualizarListaLivro(){
		List<Livro> livrosTemp = LivroDAO.listar();
		for(Livro l:livrosTemp){
			if (!l.isEmprestado()){
				livros.add(l);
			}
		}
	}
}
