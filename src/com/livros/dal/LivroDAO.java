package com.livros.dal;

import java.util.List;
import org.hibernate.*;
import org.hibernate.cfg.*;

import javax.persistence.Query;
import com.livros.model.Livro;
/*
 * TODOS OS ARQUIVOS DAO CONECTAM A SUA TABELA DO BANCO DE DADOS CORRESPONDENTE E FAZ AS 
 * OPERAÇÕES NECESSÁRIAS
 * 
 * NÃO MEXA NISSO AQUI A NÃO SER QUE SAIBA O QUE ESTÁ FAZENDO MESMO
 * SERIO, TIPO, SE VOCE ACHA QUE MANJA DISSO PROVAVELMENTE VOCÊ NÃO SABE MEXER NISSO ENTÃO
 * NEM ARRISQUE A SORTE.
 * 
 * O objeto Configuration cfg contém as configurações settadas no arquivo "hibernate.cfg.xml"
 * nele contém as infos sobre o banco (SQL Server hospedado no azure de Juliana[eu])
 * 
 * As configs do hibernate levam a todos os "<nome-da-classe>.cfg.xml" que são onde ligam 
 * as colunas e tabelas as variáveis desse programa
 * 
 * NÃO MEXA NESSAS MERDAS DE XML QUE EU TIVE UM TRABALHO FILHO DA MÃE PARA CONFIGURAR
 * PRINCIPALMENTE AS RELAÇÕES ONE-FOR-MANY DAS CHAVES ESTRANGEIRAS
 * 
 * "SessionFactory factory" cria uma sessão do banco de dados para acesso e o 
 * "Session session" contém essa sessão
 * A partir da abertura dela no ".openSession" é possível preparar seu comando (CRUD) 
 * para o banco.
 * 
 * Durante a execução ele usa um Try-catch-finally que tenta algo até dar certo, se 
 * preparando em caso de mandar algo que o banco não entenda ou inválido ou mesmo 
 * por falta de conexão a internet.
 * 
 * em try ele Abre a conexão com o banco e manda sua informação correspondente
 * em Cactch ele pega exceptions em geral
 * em finally ele fecha o programa.
 * 
 * Quando termina, fecha a conexão e pronto.
 */
public class LivroDAO {
	public static void adicionar(Livro livro){
		/*
		EntityManager em = Conexao.getEntityManager();
		em.getTransaction().begin();
		em.persist(livro);
		em.getTransaction().commit();
		em.close();
		*/
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml"); 
 
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		
		Transaction tx = null;
		try {
		   tx = session.beginTransaction();
		   session.persist(livro);
		   tx.commit();
		}
		catch (Exception e) {
		   if (tx!=null) tx.rollback();
		   e.printStackTrace(); 
		}finally {
		   session.close();
		}
		
	}
	
	public static List<Livro> listar(){
		/*
		EntityManager em = Conexao.getEntityManager();
		em.getTransaction().begin();
		Query q = em.createQuery("SELECT c FROM Livro c");
		List<Livro> lista = q.getResultList();
		em.close();
		*/
		
		List<Livro> lista = null;
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml"); 
 
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		
		Transaction tx = null;
		try {
		   tx = session.beginTransaction();
		   Query q = session.createQuery("SELECT c FROM Livro c");
		   lista = q.getResultList();
		   tx.commit();
		}
		catch (Exception e) {
		   if (tx!=null) tx.rollback();
		   e.printStackTrace(); 
		}finally {
		   session.close();
		}
		
		return lista;
	}
	
	public static void remover(Livro livro){
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml"); 
 
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		
		Transaction tx = null;
		try {
		   tx = session.beginTransaction();
		   session.delete(livro);
		   tx.commit();
		}
		catch (Exception e) {
		   if (tx!=null) tx.rollback();
		   e.printStackTrace(); 
		}finally {
		   session.close();
		}
	}
	
	public static Livro buscar(int id){
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml"); 
		Livro livro = null;
 
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		
		Transaction tx = null;
		try {
		   tx = session.beginTransaction();
		   livro = (Livro)session.get(Livro.class, id); 
		   tx.commit();
		}
		catch (Exception e) {
		   if (tx!=null) tx.rollback();
		   e.printStackTrace(); 
		}finally {
		   session.close();
		}
		return livro;
	}
	
	public static void alterar(Livro livro){
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml"); 
 
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		
		Transaction tx = null;
		try {
		   tx = session.beginTransaction();
		   session.update(livro);
		   tx.commit();
		}
		catch (Exception e) {
		   if (tx!=null) tx.rollback();
		   e.printStackTrace(); 
		}finally {
		   session.close();
		}
	}
	
	public static List<Livro> retornarLivro(){
		List<Livro> lista = null;
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml"); 
 
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		
		Transaction tx = null;
		try {
		   tx = session.beginTransaction();
		   Query q = session.createQuery("SELECT c FROM Livro c");
		   lista = q.getResultList();
		   tx.commit();
		}
		catch (Exception e) {
		   if (tx!=null) tx.rollback();
		   e.printStackTrace(); 
		}finally {
		   session.close();
		}
		return lista;
	}
}
