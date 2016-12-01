package br.com.f2r.routingdatasource.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.f2r.routingdatasource.model.Profile;

@Repository
public interface ProfileRepository {

	Profile find(Object pk);

	void persist(Profile p);

	void update(Profile p);

	void remove(Object pk);

	List<Profile> list();

}
