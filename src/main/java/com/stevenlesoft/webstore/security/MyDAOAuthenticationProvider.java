package com.stevenlesoft.webstore.security;
import java.util.ArrayList;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCrypt;

import com.stevenlesoft.webstore.domain.Customer;
import com.stevenlesoft.webstore.service.CustomerService;

/**
 * custom DAO Authentication provider
 * authenticate against user details in database
 */
public class MyDAOAuthenticationProvider implements AuthenticationProvider {
	
	@Autowired
	CustomerService customerService;
	
	public Authentication authenticate(Authentication auth) throws AuthenticationException {
		
		String userName = auth.getName();
		String password = auth.getCredentials().toString();

		Customer customer = customerService.getCustomerByUsername(userName);
		
		if(customer == null)
			throw new BadCredentialsException("Wrong password or user name");
		else if (BCrypt.checkpw(password , customer.getCustomerPassword()))
		{
			UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(auth.getPrincipal(),
					auth.getCredentials(), new ArrayList<SimpleGrantedAuthority>());

			return token;
		}
		else
			throw new BadCredentialsException("Wrong password or user name");
	}

	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

}
