package com.pleshchenko.sbb.web.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.authentication.AuthenticationTrustResolverImpl;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.rememberme.PersistentTokenBasedRememberMeServices;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	@Qualifier("customUserDetailsService")
    UserDetailsService userDetailsService;

	@Autowired
    PersistentTokenRepository tokenRepository;

	@Autowired
	public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);
		auth.authenticationProvider(authenticationProvider());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
//		http.authorizeRequests()
//				.antMatchers("/", "/list").access("hasRole('USER') or hasRole('ADMIN') or hasRole('DBA')")
//				.antMatchers("/newuser/**", "/delete-user-*").access("hasRole('ADMIN')")
//				.antMatchers("/edit-user-*").access("hasRole('ADMIN') or hasRole('DBA')").and().formLogin().loginPage("/login")
//				.loginProcessingUrl("/login").usernameParameter("ssoId").passwordParameter("password").and()
////				.rememberMe().rememberMeParameter("remember-me").tokenRepository(tokenRepository)
////				.tokenValiditySeconds(86400).and()
//				.csrf().and().exceptionHandling().accessDeniedPage("/Access_Denied");


//		http.authorizeRequests()
//				.antMatchers("/", "/list").permitAll()
////				.antMatchers("/","/login/**","/home/**").permitAll()
//				.antMatchers("/newuser/**").permitAll()
//				.antMatchers("/tickets/**", "/trains/**", "/stations/**").hasRole("USER")
//				.antMatchers("/edit-user-*").access("hasRole('ADMIN') or hasRole('DBA')")
//				.antMatchers("/schedule/**").hasRole("ADMIN")
//				.anyRequest().authenticated()
//				.and()
//				.formLogin().loginPage("/login").permitAll()
//				.loginProcessingUrl("/login").usernameParameter("ssoId").passwordParameter("password")
//				.and()
//				.logout().permitAll()
//				.and()
//				.exceptionHandling().accessDeniedPage("/Access_Denied")
//				.and()
//				.csrf();
//
//		http.sessionManagement()
//                .maximumSessions(1)
//                .expiredUrl("/login")
//                .and()
//                .invalidSessionUrl("/login");

		http.authorizeRequests()
				.antMatchers("/", "/list","/login").permitAll()
				.antMatchers("/tickets/**", "/trains/**", "/stations/**","/schedule","/searchTicket").hasRole("USER")
				.antMatchers("/newuser/**", "/delete-user-*","/edit-user-*").hasRole("ADMIN")
				.and().formLogin().loginPage("/login")
				.loginProcessingUrl("/login").usernameParameter("ssoId").passwordParameter("password")

				.and()
				.rememberMe().rememberMeServices(getPersistentTokenBasedRememberMeServices()).key("remember-me").tokenValiditySeconds(86400).and().csrf().and().exceptionHandling().accessDeniedPage("/Access_Denied");


	}



	@Bean
	public PasswordEncoder passwordEncoder() {
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder;
	}

	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
		authenticationProvider.setUserDetailsService(userDetailsService);
		authenticationProvider.setPasswordEncoder(passwordEncoder());
		return authenticationProvider;
	}

	@Bean
	public PersistentTokenBasedRememberMeServices getPersistentTokenBasedRememberMeServices() {
		PersistentTokenBasedRememberMeServices tokenBasedservice = new PersistentTokenBasedRememberMeServices(
				"remember-me", userDetailsService, tokenRepository);
		return tokenBasedservice;
	}

	@Bean
	public AuthenticationTrustResolver getAuthenticationTrustResolver() {
		return new AuthenticationTrustResolverImpl();
	}

}
