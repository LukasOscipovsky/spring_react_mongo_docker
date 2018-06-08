package oscipovsky.lukas.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import oscipovsky.lukas.service.UserService;
import oscipovsky.lukas.web.filter.JWTAuthenticationFilter;
import oscipovsky.lukas.web.filter.JWTAuthorizationFilter;

import javax.annotation.PostConstruct;

import static oscipovsky.lukas.web.constants.SecurityConstants.HEALTH_STATUS;
import static oscipovsky.lukas.web.constants.SecurityConstants.SIGNUP;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Configuration
public class WebSecurity extends WebSecurityConfigurerAdapter {

    @Autowired
    private PasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private UserService userService;

    private JWTAuthenticationFilter jwtAuthenticationFilter;
    private JWTAuthorizationFilter jwtAuthorizationFilter;

    @PostConstruct
    public void init() throws Exception {
        this.jwtAuthenticationFilter = new JWTAuthenticationFilter(authenticationManager());
        this.jwtAuthorizationFilter = new JWTAuthorizationFilter(authenticationManager(), userService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable().authorizeRequests()
                .antMatchers(HttpMethod.POST, SIGNUP, HEALTH_STATUS)
                .permitAll()
                .anyRequest().authenticated()
                .and()
                .addFilter(jwtAuthenticationFilter)
                .addFilter(jwtAuthorizationFilter)
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(bCryptPasswordEncoder);
   }

    @Bean
    public AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        final var source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());
        return source;
    }
}
