package com.fsd.sbauser.filters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.fsd.sbauser.entity.Userinfolist;
import com.fsd.sbauser.service.UsersService;

@Service
public class FsdUserDetailsService implements UserDetailsService {

  @Autowired
  UsersService usersService;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	Userinfolist userinfolist = usersService.getUserByUsername(username);
    if (userinfolist == null) {
      throw new UsernameNotFoundException("USERNAME NOT FOUND");
    }
    String password = userinfolist.getPassword();
    String role = userinfolist.getUsertype();
    Boolean userDisabled = false;
    if (!userinfolist.getConfirmed().equalsIgnoreCase("1")) {
      userDisabled = true;
    }
    return User.withUsername(username).password(new BCryptPasswordEncoder().encode(password)).disabled(userDisabled).roles(role).build();
  }

}
