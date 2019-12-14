package com.fsd.sbauser;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.fsd.sbauser.entity.Userinfolist;
import com.fsd.sbauser.service.UsersService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SbauserApplicationTests {

//	@Test
//	void contextLoads() {
//	}
	
	private static Logger logger = LoggerFactory.getLogger(SbauserApplicationTests.class);
	
	@Autowired
	private UsersService usersService;
	
	@Test
	public void userLogin(){
		try {
			String username = "Amy";
			String password = "111111";
			System.out.println("***********login successed");
			Userinfolist userinfolist = usersService.getUserByUsernameAndPassword(username, password);
	    	System.out.println("***********login successed");
		  	System.out.println("1*****1******" + userinfolist.getEmail());
		    System.out.println("2*****2******" + userinfolist.getPassword());
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("***********login failed");
			logger.info("***********login error");
		}
	}

	// @Autowired
	// private UserRepository userRepository;
	// @Test
	// public void testBaseQuery() throws Exception {
	// 	int id = 1;
	//     Users users=new Users();
	//     userRepository.findAll();
	//     userRepository.findById(id);
	//     userRepository.save(users);
	//     userRepository.delete(users);
	//     userRepository.count();
	//     userRepository.existsById(id);
	//     // ...
	// }

}
