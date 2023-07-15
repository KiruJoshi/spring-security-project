package com.example.springsecurity.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
public class MySpringSecurityConfiguration {
	
	
	
	@Value("${spring.datasource.url}")
    private String databaseUrl;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;
	

    @Bean
	public  SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http

				.authorizeHttpRequests(auth -> {
					auth.requestMatchers("/", "/public").permitAll();
					auth.requestMatchers("/secretpoint").hasAuthority("Admin");
					auth.requestMatchers("/userRequest/**").hasAuthority("Super Admin");
					auth.anyRequest().authenticated();

				})
				.csrf(AbstractHttpConfigurer::disable).cors(AbstractHttpConfigurer::disable)
				// .httpBasic(Customizer.withDefaults())
				.formLogin(Customizer.withDefaults());

		return http.build();
	}

//"/getAllUserAndAuthority","/getOnlyUsers","/getSingleUsersAndAuthority/**",
//	"/saveUsersAndAuthorities","/delete/**","/deleteUserAndAuthority/**"
	/*
	 * @Bean public UserDetailsService userDetailsService() {
	 * 
	 * UserDetails normalUser1 =
	 * User.withUsername("kiran").password(passwordEncoder().encode("123456"))
	 * .roles("Normal_User").build(); UserDetails normalUser2 =
	 * User.withUsername("sam").password(passwordEncoder().encode("12345"))
	 * .roles("Normal_User").build(); UserDetails adminUser =
	 * User.withUsername("ahmed").password(passwordEncoder().encode("123")).roles(
	 * "Admin") .build(); UserDetails superAdminUser =
	 * User.withUsername("karim").password(passwordEncoder().encode("123"))
	 * .roles("Super_ADMIN").build();
	 * 
	 * return new InMemoryUserDetailsManager(normalUser1, normalUser2, adminUser,
	 * superAdminUser);
	 * 
	 * }
	 */
	@Bean
	public PasswordEncoder passwordEncoder() {

		return new BCryptPasswordEncoder();
	}

	@Bean
	public JdbcUserDetailsManager detailsManager(DataSource dataSource) {
		return new JdbcUserDetailsManager(dataSource);
	}
	
	@Bean
    DataSource dataSource() {
       DriverManagerDataSource dataSource = new DriverManagerDataSource();
       dataSource.setUrl(databaseUrl);
       dataSource.setUsername(username);
       dataSource.setPassword(password);
       return dataSource;
   }
}





