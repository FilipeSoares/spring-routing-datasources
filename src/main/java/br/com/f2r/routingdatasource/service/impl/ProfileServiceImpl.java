package br.com.f2r.routingdatasource.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import br.com.f2r.routingdatasource.model.Profile;
import br.com.f2r.routingdatasource.repository.ProfileRepository;
import br.com.f2r.routingdatasource.service.ProfileService;

@Service
public class ProfileServiceImpl implements ProfileService{
	
	@Autowired
	@Qualifier("profileRepositryImpl")
	ProfileRepository dao;
	
	@Override
	public Profile find(Object pk) {
		return dao.find(pk);
	}

	@Override
	public void persist(Profile p) {
		dao.persist(p);
	}

	@Override
	public void update(Profile p) {
		dao.update(p);	
	}

	@Override
	public void remove(Object pk) {
		dao.remove(pk);
	}

	@Override
	public List<Profile> list() {
		return dao.list();
	}

}
