package br.com.fo2app.routingdatasource.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.fo2app.routingdatasource.model.User;

@Repository
public interface UserRepository {

	User find(Object pk);

	void persist(User u);

	void update(User u);

	void remove(Object pk);

	List<User> list();
	
	User findByLogin(String login);

}
