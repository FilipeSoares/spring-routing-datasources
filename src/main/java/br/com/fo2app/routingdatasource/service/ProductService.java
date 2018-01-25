package br.com.fo2app.routingdatasource.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.fo2app.routingdatasource.model.Product;

@Service
public interface ProductService {

	Product find(Object pk);

	void persist(Product p);

	void update(Product p);

	void remove(Object pk);

	List<Product> list();
}
