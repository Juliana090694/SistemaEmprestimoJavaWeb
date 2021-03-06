package com.livros.dal;

import java.util.List;
import org.hibernate.*;
import org.hibernate.cfg.*;

import javax.persistence.Query;

import com.livros.model.Categoria;
/*
 * TODOS OS ARQUIVOS DAO CONECTAM A SUA TABELA DO BANCO DE DADOS CORRESPONDENTE E FAZ AS 
 * OPERA��ES NECESS�RIAS
 * 
 * N�O MEXA NISSO AQUI A N�O SER QUE SAIBA O QUE EST� FAZENDO MESMO
 * SERIO, TIPO, SE VOCE ACHA QUE MANJA DISSO PROVAVELMENTE VOC� N�O SABE MEXER NISSO ENT�O
 * NEM ARRISQUE A SORTE.
 * 
 * O objeto Configuration cfg cont�m as configura��es settadas no arquivo "hibernate.cfg.xml"
 * nele cont�m as infos sobre o banco (SQL Server hospedado no azure de Juliana[eu])
 * 
 * As configs do hibernate levam a todos os "<nome-da-classe>.cfg.xml" que s�o onde ligam 
 * as colunas e tabelas as vari�veis desse programa
 * 
 * N�O MEXA NESSAS MERDAS DE XML QUE EU TIVE UM TRABALHO FILHO DA M�E PARA CONFIGURAR
 * PRINCIPALMENTE AS RELA��ES ONE-FOR-MANY DAS CHAVES ESTRANGEIRAS
 * 
 * "SessionFactory factory" cria uma sess�o do banco de dados para acesso e o 
 * "Session session" cont�m essa sess�o
 * A partir da abertura dela no ".openSession" � poss�vel preparar seu comando (CRUD) 
 * para o banco.
 * 
 * Durante a execu��o ele usa um Try-catch-finally que tenta algo at� dar certo, se 
 * preparando em caso de mandar algo que o banco n�o entenda ou inv�lido ou mesmo 
 * por falta de conex�o a internet.
 * 
 * em try ele Abre a conex�o com o banco e manda sua informa��o correspondente
 * em Cactch ele pega exceptions em geral
 * em finally ele fecha o programa.
 * 
 * Quando termina, fecha a conex�o e pronto.
 */

public class CategoriaDAO {
	public static void adicionar(Categoria categoria){

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml"); 
 
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		
		Transaction tx = null;
		try {
		   tx = session.beginTransaction();
		   session.persist(categoria);
		   tx.commit();
		}
		catch (Exception e) {
		   if (tx!=null) tx.rollback();
		   e.printStackTrace(); 
		}finally {
		   session.close();
		}
		
	}
	
	public static List<Categoria> listar(){
		
		List<Categoria> lista = null;
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml"); 
 
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		
		Transaction tx = null;
		try {
		   tx = session.beginTransaction();
		   Query q = session.createQuery("SELECT c FROM Categoria c");
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
	
	public static void remover(Categoria categoria){
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml"); 
 
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		
		Transaction tx = null;
		try {
		   tx = session.beginTransaction();
		   session.delete(categoria);
		   tx.commit();
		}
		catch (Exception e) {
		   if (tx!=null) tx.rollback();
		   e.printStackTrace(); 
		}finally {
		   session.close();
		}
	}
	
	public static Categoria buscar(int id){
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml"); 
		Categoria categoria = null;
 
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		
		Transaction tx = null;
		try {
		   tx = session.beginTransaction();
		   categoria = (Categoria)session.get(Categoria.class, id); 
		   tx.commit();
		}
		catch (Exception e) {
		   if (tx!=null) tx.rollback();
		   e.printStackTrace(); 
		}finally {
		   session.close();
		}
		return categoria;
	}
	
	public static void alterar(Categoria categoria){
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml"); 
 
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		
		Transaction tx = null;
		try {
		   tx = session.beginTransaction();
		   session.update(categoria);
		   tx.commit();
		}
		catch (Exception e) {
		   if (tx!=null) tx.rollback();
		   e.printStackTrace(); 
		}finally {
		   session.close();
		}
	}
	
	public static List<Categoria> retornarCategoria(){
		List<Categoria> lista = null;
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml"); 
 
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		
		Transaction tx = null;
		try {
		   tx = session.beginTransaction();
		   Query q = session.createQuery("SELECT c FROM Categoria c");
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
