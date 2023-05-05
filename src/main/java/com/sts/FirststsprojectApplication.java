package com.sts;


import java.util.Optional;
import java.util.function.Consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.sts.model.User;
import com.sts.userrepo.UserRepository;

@SpringBootApplication
public class FirststsprojectApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(FirststsprojectApplication.class, args);
//		UserRepository userRepository = context.getBean(UserRepository.class);
//		User user = new User();
//		Adding values : We can also use saveall method 
//		by making an array of users
//		user.setName(null);
//		user.setEmail(null);
//		user.setPassword(null);
//		user.setPhonenumber(null);
//		user.setUsername(null);
//		User user1 = userRepository.save(user);
		
		
//		Updating 
//		Optional<User> op = userRepository.findById(1);
//		User user = op.get(); 
//		user.setName("Kamran Ali");
//		User res = userRepository.save(user);
//		System.out.print(res);
		
//		Get the data from db
//		Iterable<User> itr = userRepository.findAll();
//		itr.forEach(user->{System.out.print(user);});
//		itr.forEach(new Consumer<User>(){
//			@Override
//			public void accept(User t) {
//				System.out.println(t);
//			}
//			
//		});
		
		
//		Deleting the user
//		other methods are also the for deleting 
//		userRepository.deleteById(1);
		
		
	}

}
