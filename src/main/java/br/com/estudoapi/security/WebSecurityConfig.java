package br.com.estudoapi.security;

import javax.inject.Inject;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Inject
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
		.withUser("admin").password("s3nh4").roles("ADMIN");
	}
	  
	protected void configure(HttpSecurity http) throws Exception {
		http.headers().cacheControl().disable();
		http.csrf().disable();
		http.authorizeRequests()
		.anyRequest().authenticated()
		.and()
		.formLogin()
		.and()
		.httpBasic();
	}
}
