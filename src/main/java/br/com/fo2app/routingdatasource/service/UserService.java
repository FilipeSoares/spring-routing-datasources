package br.com.fo2app.routingdatasource.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.fo2app.routingdatasource.model.User;

@Service
public interface UserService {

	User find(Object pk);

	void persist(User u);

	void update(User u);

	void remove(Object pk);

	List<User> list();
}
