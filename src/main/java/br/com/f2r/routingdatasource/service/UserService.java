package br.com.f2r.routingdatasource.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.f2r.routingdatasource.model.User;

@Service
public interface UserService {

	User find(Object pk);

	void persist(User u);

	void update(User u);

	void remove(Object pk);

	List<User> list();
}
