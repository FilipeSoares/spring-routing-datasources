package br.com.f2r.routingdatasource.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.f2r.routingdatasource.model.User;

@Repository
public interface UserRepository {

	User find(Object pk);

	void persist(User u);

	void update(User u);

	void remove(Object pk);

	List<User> list();
	
	User findByLogin(String login);

}
