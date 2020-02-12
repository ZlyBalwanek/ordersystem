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
                .withUser("MasterOfOrders").password("{noop}5465FE94B0A2766E73B4DE87A306DD64").roles("UBERADMIN")
                .and()
                .withUser("Emp").password("{noop}pass").roles("EMPLOYEE")
                .and()
                .withUser("User").password("{noop}pass").roles("ADMIN");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/**").authenticated()
                .antMatchers("/").permitAll()
                .antMatchers("/login").permitAll()
                .antMatchers("/employees/**").hasRole("EMPLOYEE")
                .antMatchers("/user/**").hasRole("ADMIN")
                .antMatchers("/master/**").hasRole("UBERADMIN")
                .and().formLogin()
                .and().logout()
                .logoutSuccessUrl("/");
//                .loginPage("/login");
    }
}
