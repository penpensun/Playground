package org.peng.spring.ldap;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.encoding.LdapShaPasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http.authorizeRequests().anyRequest().fullyAuthenticated()
			.and()
			.formLogin();
	}
	
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception{
		auth
			.ldapAuthentication()
				.userDnPatterns("uid={0},ou=people,o=bayer")
				.groupSearchBase("ou=people,o=bayer")
				.contextSource()
					.url("ldaps://ldaps.bayer-ag.com:636/")
					.and()
				.passwordCompare()
					.passwordEncoder(new LdapShaPasswordEncoder())
					.passwordAttribute("userPassword");
	}
}
