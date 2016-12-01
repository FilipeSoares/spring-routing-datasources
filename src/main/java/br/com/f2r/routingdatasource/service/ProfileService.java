package br.com.f2r.routingdatasource.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.f2r.routingdatasource.model.Profile;

@Service
public interface ProfileService {

	Profile find(Object pk);

	void persist(Profile p);

	void update(Profile p);

	void remove(Object pk);

	List<Profile> list();
}
