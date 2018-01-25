package br.com.fo2app.routingdatasource.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.fo2app.routingdatasource.model.Product;
import br.com.fo2app.routingdatasource.repository.ProductRepository;

@Repository
public class ProductRepositryImpl implements ProductRepository{
	
	@PersistenceContext
	EntityManager em;

	@Override
	public Product find(Object pk) {
		return em.find(Product.class, pk);
	}

	@Override
	@Transactional
	public void persist(Product p) {
		em.persist(p);
	}

	@Override
	@Transactional
	public void update(Product p) {
		em.merge(p);
	}

	@Override
	public void remove(Object pk) {
		em.remove(find(pk));
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> list() {
		return em.createQuery("FROM Product").getResultList();
	}

}
