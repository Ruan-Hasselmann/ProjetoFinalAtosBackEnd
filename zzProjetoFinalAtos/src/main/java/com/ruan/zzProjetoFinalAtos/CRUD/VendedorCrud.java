package com.ruan.zzProjetoFinalAtos.CRUD;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.ruan.zzProjetoFinalAtos.Models.Vendedor;

public class VendedorCrud {
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

	public void create(Vendedor vendedor) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		session.save(vendedor);

		session.getTransaction().commit();
		session.close();
	}

	public Vendedor read(Long id) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		Vendedor vendedor = session.get(Vendedor.class, id);

		session.close();
		return vendedor;
	}

	public void update(Vendedor vendedor) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		session.update(vendedor);

		session.getTransaction().commit();
		session.close();
	}

	public void delete(Long id) {
		Vendedor vendedor = new Vendedor();
		vendedor.setId(id);

		Session session = sessionFactory.openSession();
		session.beginTransaction();

		session.delete(vendedor);

		session.getTransaction().commit();
		session.close();
	}

	public List<Vendedor> listAll() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		// leitura via Hibernate Query Language (HQL).
		List<Vendedor> listaVendedor = session.createQuery("from Vendedor", Vendedor.class).getResultList();

		session.getTransaction().commit();
		session.close();

		return listaVendedor;
	}

	public Vendedor queryWhere(String nome) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		Vendedor vendedor = session.createQuery("from Vendedor where nome='" + nome +"'", Vendedor.class).getSingleResult();

		session.close();
		return vendedor;
	}
}
