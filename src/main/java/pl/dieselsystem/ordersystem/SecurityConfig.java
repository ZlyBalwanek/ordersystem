package pl.dieselsystem.ordersystem;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("MasterOfOrders").password("{noop}5465FE94B0A2766E73B4DE87A306DD64").roles("UBERADMIN");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/**").permitAll();
//                .antMatchers("/basic").authenticated()
//                .antMatchers("/hello").hasRole("ADMIN")
//                .and().formLogin()
//                .loginPage("/login");
    }
}
