package br.com.f2r.routingdatasource.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.f2r.routingdatasource.model.Product;

@Repository
public interface ProductRepository {
	
	Product find(Object pk);

	void persist(Product p);

	void update(Product p);

	void remove(Object pk);

	List<Product> list();

}
