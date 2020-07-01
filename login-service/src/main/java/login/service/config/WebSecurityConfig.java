package login.service.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import login.service.services.UserAuthService;

@Configuration
//@EnableGlobalMethodSecurity(prePostEnabled = true) 
@EnableWebSecurity(debug = false)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	UserAuthService userDetailService;

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public DaoAuthenticationProvider authenticationProvider() {

		DaoAuthenticationProvider daoAuthProvider = new DaoAuthenticationProvider();
		daoAuthProvider.setUserDetailsService(userDetailService);
		daoAuthProvider.setPasswordEncoder(getPasswordEncoder());
		return daoAuthProvider;
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		try {
			http.csrf().disable()
					.authorizeRequests()
					.antMatchers("/rest/**","/" ) // "/home", "resources/**","/css/**","/images/**","/js/**","/register/"
					.permitAll()
					.antMatchers("/loginSuccess")
					.hasAnyRole("USER")
					.anyRequest()
					.authenticated()
				.and()
						.formLogin()
						.loginPage("/userlogin")
						.loginProcessingUrl("/doLogin")
						.successForwardUrl("/postLogin")
						.failureUrl("/loginFail")
						.permitAll()
					.and()
						.logout()
						.permitAll()
				  .and().oauth2Login() .permitAll();

		} catch (Exception e) {
			System.out.println("exception in security Config" + e);
		}
	}

	@Override
	protected void configure(AuthenticationManagerBuilder authBuilder) throws Exception {
		authBuilder.authenticationProvider(authenticationProvider());
		// .passwordEncoder(getPasswordEncoder());
		
	}

	private PasswordEncoder getPasswordEncoder() {
		return new PasswordEncoder() {
			@Override
			public String encode(CharSequence charSequence) {
				return charSequence.toString();
			}

			@Override
			public boolean matches(CharSequence charSequence, String s) {
				return true;
			}
		};
	}

}
