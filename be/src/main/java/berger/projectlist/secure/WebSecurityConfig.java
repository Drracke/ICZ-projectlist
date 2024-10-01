package berger.projectlist.secure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import static org.springframework.security.config.Customizer.withDefaults;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.http.HttpMethod;



@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    // @Bean
	// public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		// http
			// .authorizeHttpRequests((requests) -> requests
				// .requestMatchers("/", "/explorer","/explorer/index.html").permitAll()
				// .anyRequest().authenticated()
			// );
			// .formLogin((form) -> form
				// .loginPage("/login")
				// .permitAll()
			// )
			// .logout((logout) -> logout.permitAll());

		// return http.build();
	// }


@Bean
	public UserDetailsService userDetailsService() {
		InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
		manager.createUser(User.withDefaultPasswordEncoder().username("user").password("password").roles("USER").build());
		manager.createUser(User.withDefaultPasswordEncoder().username("admin").password("password").roles("USER","ADMIN").build());
		return manager;
	}

	@Bean
public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
	http
		.csrf( csrf -> csrf.disable())
		.authorizeHttpRequests(authorize -> authorize
			.anyRequest().authenticated()
		)
		// .formLogin(withDefaults())
		.httpBasic(withDefaults());
	return http.build();
}


	@Bean
	@Order(1)                                                        
	public SecurityFilterChain apiFilterChain(HttpSecurity http) throws Exception {
		http
			.csrf( csrf -> csrf.disable())
			.securityMatcher("/api/**")                              
			.authorizeHttpRequests(authorize -> authorize
				.anyRequest().hasRole("ADMIN")
			)
			.httpBasic(withDefaults());
		return http.build();
	}

	// @Bean
	// @Order(2)                                                        
	// public SecurityFilterChain allowPostForAdmin(HttpSecurity http) throws Exception {
	// 	http
    // 		.authorizeHttpRequests((authorize) -> authorize
    //     		.requestMatchers(HttpMethod.POST).hasRole("ADMIN")
    //     		.anyRequest().denyAll()
    // 		);
	// 	return http.build();
	// }
	// @Bean
	// public UserDetailsService userDetailsService() {
		// UserDetails user =
			//  User.withDefaultPasswordEncoder()
				// .username("user")
				// .password("password")
				// .roles("USER")
				// .build();
// 
		// return new InMemoryUserDetailsManager(user);
	// }
}