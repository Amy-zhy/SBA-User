package com.fsd.sbauser.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fsd.sbauser.entity.Userinfolist;
import com.fsd.sbauser.repository.UsersRepository;

@Service
public class UsersService {
	
	@Autowired
	private UsersRepository usersRepository;
	
	public Userinfolist getUserByUsername(String username) {
		return usersRepository.findByUsername(username);
	}
	
	// public Users getUserByEmail(String email) {
	//   return usersRepository.findByEmail(email);
	// }
	
	//    #########################################################################################
	
	public int setConfirmedByUsername(String username, String confirmed) {
		return usersRepository.saveUsersByUsernameAndConfirmed(username, "1");
	};
	
	public Userinfolist saveUsersInfo(Userinfolist userinfolist) {
		return usersRepository.save(userinfolist);
	};

	public int setLastupdateByUsername(String username, Date lastupdate) {
		return usersRepository.saveUsersByUsernameAndLastupdate(username, lastupdate);
	};

	public Userinfolist getUserByUsernameAndPassword(String username, String password) {
		return usersRepository.findByUsername(username);
	}
    
}