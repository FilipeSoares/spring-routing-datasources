package br.com.fo2app.routingdatasource.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.fo2app.routingdatasource.model.User;
import br.com.fo2app.routingdatasource.repository.UserRepository;

@Repository
public class UserRepositoryImpl implements UserRepository{
	
	@PersistenceContext
	EntityManager em;

	@Override
	public User find(Object pk) {
		return em.find(User.class, pk);
	}

	@Override
	@Transactional
	public void persist(User u) {
		em.persist(u);
	}

	@Override
	@Transactional
	public void update(User u) {
		em.merge(u);
	}

	@Override
	@Transactional
	public void remove(Object pk) {
		em.remove(find(pk));
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> list() {
		return em.createQuery("FROM User").getResultList();
	}

	@Override
	public User findByLogin(String login) {
		return (User) em.createQuery("FROM User WHERE login=:login")
				.setParameter("login", login)
				.getSingleResult();
	}

}
