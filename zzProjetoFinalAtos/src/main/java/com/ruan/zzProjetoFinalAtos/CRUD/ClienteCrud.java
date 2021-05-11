package com.ruan.zzProjetoFinalAtos.CRUD;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.ruan.zzProjetoFinalAtos.Models.Cliente;

public class ClienteCrud {
	public SessionFactory sessionFactory;

	public void setup() {
		// code to load Hibernate Session factory
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
		// .configure() // configures settings from hibernate.cfg.xml
		// .build();
		try {
			sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
			// sessionFactory = configuration.buildSessionFactory();
		} catch (Exception ex) {
			StandardServiceRegistryBuilder.destroy(registry);

		}
	}
	
	public void exit() {
		// code to close Hibernate Session factory
	}
	
	public void create(Cliente cliente) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		session.save(cliente);

		session.getTransaction().commit();
		session.close();
	}
	
	public Cliente read(Long id) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		Cliente cliente = session.get(Cliente.class, id);

		session.close();
		return cliente;
	}
	
	public void update(Cliente cliente) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		session.update(cliente);

		session.getTransaction().commit();
		session.close();
	}
	
	public void delete(Long id) {
		Cliente cliente = new Cliente();
		cliente.setId(id);

		Session session = sessionFactory.openSession();
		session.beginTransaction();

		session.delete(cliente);

		session.getTransaction().commit();
		session.close();
	}
	
	public List<Cliente> listAll() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		// leitura via Hibernate Query Language (HQL).
		List<Cliente> listaCliente = session.createQuery("from Cliente", Cliente.class).getResultList();

		session.getTransaction().commit();
		session.close();

		return listaCliente;
	}
	
	public Cliente queryWhere(String nome) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		Cliente cliente = session.createQuery("from Cliente where nome='" + nome +"'", Cliente.class).getSingleResult();

		session.close();
		return cliente;
	}
}
