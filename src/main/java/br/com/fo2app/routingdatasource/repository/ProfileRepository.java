package br.com.fo2app.routingdatasource.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.fo2app.routingdatasource.model.Profile;

@Repository
public interface ProfileRepository {

	Profile find(Object pk);

	void persist(Profile p);

	void update(Profile p);

	void remove(Object pk);

	List<Profile> list();

}
