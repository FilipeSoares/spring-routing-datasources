package br.com.f2r.routingdatasource.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.f2r.routingdatasource.model.Profile;
import br.com.f2r.routingdatasource.model.User;
import br.com.f2r.routingdatasource.repository.UserRepository;
import br.com.f2r.routingdatasource.service.UserService;

@Service
public class UserServiceImpl implements UserService, UserDetailsService{
	
	@Autowired
	@Qualifier("userRepositoryImpl")
	UserRepository dao;

	@Override
	public User find(Object pk) {
		return dao.find(pk);
	}

	@Override
	public void persist(User u) {
		dao.persist(u);
	}

	@Override
	public void update(User u) {
		dao.update(u);
	}

	@Override
	public void remove(Object pk) {
		dao.remove(pk);
	}

	@Override
	public List<User> list() {
		return dao.list();
	}

	@Transactional(readOnly=true)
    public UserDetails loadUserByUsername(String login)
            throws UsernameNotFoundException {
        User user = dao.findByLogin(login);
        if(user==null){
            throw new UsernameNotFoundException("Username not found");
        }
            return new org.springframework.security.core.userdetails.User(user.getLogin(), user.getPassword(), 
                 true, true, true, true, getGrantedAuthorities(user));
    }
 
     
    private List<GrantedAuthority> getGrantedAuthorities(User user){
    	List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        
        for(Profile profile : user.getProfiles()){
            authorities.add(new SimpleGrantedAuthority("ROLE_"+profile.getType()));
        }
        return authorities;
    }

}
