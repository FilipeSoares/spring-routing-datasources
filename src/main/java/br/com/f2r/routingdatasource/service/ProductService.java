package br.com.f2r.routingdatasource.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.f2r.routingdatasource.model.Product;

@Service
public interface ProductService {

	Product find(Object pk);

	void persist(Product p);

	void update(Product p);

	void remove(Object pk);

	List<Product> list();
}
