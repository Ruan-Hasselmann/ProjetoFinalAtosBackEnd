package com.ruan.zzProjetoFinalAtos.Controllers;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.ruan.zzProjetoFinalAtos.Models.Vendedor;

public class VendedorCrud {
	/*protected SessionFactory sessionFactory;

	protected void setup() {
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

	protected void exit() {
		// code to close Hibernate Session factory
	}

	protected void create(Vendedor vendedor) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		session.save(vendedor);

		session.getTransaction().commit();
		session.close();
	}

	protected Vendedor read(int id) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		Vendedor vendedor = session.get(Vendedor.class, id);

		session.close();
		return vendedor;
	}

	protected void update(Vendedor vendedor) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		session.update(vendedor);

		session.getTransaction().commit();
		session.close();
	}

	protected void delete(int id) {
		Vendedor vendedor = new Vendedor();
		vendedor.setId((long) id);

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
		List<Vendedor> vendedor = session.createQuery("from vendedor", Vendedor.class).getResultList();

		session.getTransaction().commit();
		session.close();

		return vendedor;
	}

	public Vendedor queryWhere(String nome) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		Vendedor vendedor = session.createQuery("from vendedor where nome='" + nome +"'", Vendedor.class).getSingleResult();

		session.close();
		return vendedor;
	}*/
}
