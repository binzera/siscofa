package br.gms.siscofa2018.conf;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

//	@Autowired
//	private UsuarioDAO usuarioDao;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().csrfTokenRepository(csrfTokenRepository());
		http.csrf().disable();
		http.authorizeRequests()
//			.antMatchers("/produtos/form").hasRole("ADMIN")
//			.antMatchers("/carrinho/**").permitAll()
//			.antMatchers("/pagamento/**").permitAll()
//			.antMatchers(HttpMethod.POST, "/produtos").hasRole("ADMIN")
//			.antMatchers(HttpMethod.GET, "/produtos").hasRole("ADMIN")
//			.antMatchers("/produtos/**").permitAll()
//			.antMatchers("/resources/**").permitAll()
			.antMatchers("/").permitAll()
			.antMatchers("/url-magica-maluca-oajksfbvad6584i57j54f9684nvi658efnoewfmnvowefnoeijn").permitAll()
			//.anyRequest().authenticated()
			.and().formLogin().loginPage("/login").permitAll()
			.and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
		
	}
	
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.userDetailsService(usuarioDao)
//			.passwordEncoder(new BCryptPasswordEncoder());
//	}
	
	
	private CsrfTokenRepository csrfTokenRepository(){ 
	    HttpSessionCsrfTokenRepository repository = new HttpSessionCsrfTokenRepository(); 
	    repository.setSessionAttributeName("_csrf");
	    repository.setHeaderName("X-XSRF-TOKEN");
	    return repository; 
	}
}













