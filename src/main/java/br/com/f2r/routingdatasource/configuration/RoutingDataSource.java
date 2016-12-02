package br.com.f2r.routingdatasource.configuration;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import br.com.f2r.routingdatasource.model.CustomUserDetails;

public class RoutingDataSource extends AbstractRoutingDataSource{

	@Override
	protected Object determineCurrentLookupKey() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if(authentication!=null && authentication.isAuthenticated()){
			CustomUserDetails detail = (CustomUserDetails) authentication.getPrincipal();
			return detail.getConnection();
		}else{
			return 0;
		}
	}

}
