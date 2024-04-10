package br.com.horario.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authorization.AuthenticatedAuthorizationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecSecurityConfig {
	
	@Autowired
	private UserDetailServiceImpl userDetailServiceImpl;
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(
				auth -> auth
				.requestMatchers("/singin", "/singup").permitAll()
				.requestMatchers("/preferencia").hasAnyAuthority("professor", "coordenador_curso")
				.requestMatchers("/disponibilidade").hasAnyAuthority("professor", "coordenador_curso")
				.requestMatchers("/docente").hasAnyAuthority("administrador")
				.anyRequest().authenticated()
				)
		        .formLogin(formLogin -> formLogin
		        		.defaultSuccessUrl("/principal", true)
		        		.permitAll()	
		        		)
		        .rememberMe(rememberMe -> rememberMe.key("Abcdefghijkn..."))
		        .logout(logout -> logout.logoutUrl("/signout").permitAll());
		return http.build();	
	}
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth)
	   throws Exception {
		BCryptPasswordEncoder b = new BCryptPasswordEncoder();
		System.out.println(b.encode("123456"));
		auth.userDetailsService(userDetailServiceImpl).passwordEncoder(new BCryptPasswordEncoder());
	}
	

}
