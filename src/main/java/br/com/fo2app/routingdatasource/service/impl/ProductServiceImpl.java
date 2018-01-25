package br.com.fo2app.routingdatasource.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import br.com.fo2app.routingdatasource.model.Product;
import br.com.fo2app.routingdatasource.repository.ProductRepository;
import br.com.fo2app.routingdatasource.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	@Qualifier("productRepositryImpl")
	ProductRepository dao;
	
	@Override
	public Product find(Object pk) {
		return dao.find(pk);
	}

	@Override
	public void persist(Product p) {
		dao.persist(p);
	}

	@Override
	public void update(Product p) {
		dao.update(p);	
	}

	@Override
	public void remove(Object pk) {
		dao.remove(pk);
	}

	@Override
	public List<Product> list() {
		return dao.list();
	}

}
