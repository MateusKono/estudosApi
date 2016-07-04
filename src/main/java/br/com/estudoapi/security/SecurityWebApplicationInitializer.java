package br.com.estudoapi.security;

import org.springframework.security.web.context.*;

public class SecurityWebApplicationInitializer extends AbstractSecurityWebApplicationInitializer{
	
    public SecurityWebApplicationInitializer() {
      super(WebSecurityConfig.class);
   }
}
