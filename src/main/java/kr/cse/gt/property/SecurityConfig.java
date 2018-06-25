package kr.cse.gt.property;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	UserDetailsService userDetailsService;
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/resources/**");
		web.ignoring().antMatchers("/api/**");		
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
		        .antMatchers("/login","/register").permitAll()
		        .antMatchers("/**").authenticated()
		        .and()
	        .csrf()
	        	.disable()
        	.formLogin()
		        .loginPage("/")
		        .loginPage("/login")
		        .usernameParameter("username")
		        .passwordParameter("password")
		        .loginProcessingUrl("/login")
		        .failureUrl("/login?error=true")
		        .defaultSuccessUrl("/home", true)
		        .and()
	        .logout()
		        .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
		        .logoutSuccessUrl("/")
		        .invalidateHttpSession(true)
		        .and()
	        .httpBasic();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
			.userDetailsService(userDetailsService)
				.passwordEncoder(passwordEncoder())
				.and();
	}
	
	
	@Bean
	PasswordEncoder passwordEncoder()
	{
		// 인증에 기본 스프링 해시를 사용하겠습니다.
		return new BCryptPasswordEncoder();
	}
}
