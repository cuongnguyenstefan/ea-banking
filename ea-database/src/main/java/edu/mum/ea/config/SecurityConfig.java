package edu.mum.ea.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import edu.mum.ea.entity.enumtype.Role;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private DataSource dataSource;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
				.antMatchers("/css/**", "/index").permitAll()		
				.antMatchers("/customer/**").access("hasRole('" + Role.ROLE_USER.getValue() + "')")
				.antMatchers("/account/**").access("hasRole('" + Role.ROLE_USER.getValue() + "')")	
				.antMatchers("/staff/**").access("hasRole('" + Role.ROLE_ADMIN.getValue() + "')")
				.antMatchers("/request/**").access("hasRole('" + Role.ROLE_ADMIN.getValue() + "')")
				.antMatchers("/login").anonymous()
			.and()
				.formLogin()
				.loginPage("/login").failureUrl("/login?error")
				.usernameParameter("username").passwordParameter("password")
			.and()
				.logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/")
			.and()
				.exceptionHandling().accessDeniedPage("/403")
			.and()
				.csrf();
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(dataSource)
		.usersByUsernameQuery("select username, password, enabled from user where username=?")
		.authoritiesByUsernameQuery("select username, role from user_roles where username=?");
	}
}