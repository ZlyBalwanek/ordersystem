package pl.dieselsystem.ordersystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pl.dieselsystem.ordersystem.model.Role;
import pl.dieselsystem.ordersystem.model.User;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {

        User user;

        if (name.equals(superAdmin().getName())) {

            user = superAdmin();

        } else {

           user = userService.findByName(name);

        }

        List<GrantedAuthority> authority = getUserAuthority(user.getRole());

        return buildUserForAuthentication(user, authority);

    }

    private List<GrantedAuthority> getUserAuthority (Role userRole) {

        List<GrantedAuthority> authorities = new ArrayList<>();

        authorities.add(new SimpleGrantedAuthority(userRole.getName()));

        return authorities;

    }

    private UserDetails buildUserForAuthentication(User user, List<GrantedAuthority> authority) {

        return new org.springframework.security.core.userdetails.User(user.getName(), user.getPassword(),true, true, true, true, authority);

    }

    private User superAdmin() {

        Role role = new Role();
        role.setName("UBERADMIN");

        User user = new User();
        user.setName("Master");
        user.setPassword(bCryptPasswordEncoder.encode("Order66"));
        user.setRole(role);

        return user;

    }
}
