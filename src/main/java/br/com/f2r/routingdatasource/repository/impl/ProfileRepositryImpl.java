package br.com.f2r.routingdatasource.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.f2r.routingdatasource.model.Profile;
import br.com.f2r.routingdatasource.repository.ProfileRepository;

@Repository
public class ProfileRepositryImpl implements ProfileRepository{
	
	@PersistenceContext
	EntityManager em;

	@Override
	public Profile find(Object pk) {
		return em.find(Profile.class, pk);
	}

	@Override
	@Transactional
	public void persist(Profile p) {
		em.persist(p);
	}

	@Override
	@Transactional
	public void update(Profile p) {
		em.merge(p);
	}

	@Override
	public void remove(Object pk) {
		em.remove(find(pk));
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Profile> list() {
		return em.createQuery("FROM Profile").getResultList();
	}

}
