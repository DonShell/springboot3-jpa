package com.donshell.testes.course.config;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.donshell.testes.course.entities.Category;
import com.donshell.testes.course.entities.Order;
import com.donshell.testes.course.entities.User;
import com.donshell.testes.course.entities.enums.OrderStatus;
import com.donshell.testes.course.repositories.CategoryRepository;
import com.donshell.testes.course.repositories.OrderRepository;
import com.donshell.testes.course.repositories.UserRepository;

@Configuration
@Profile("test")
public class testConfig implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public void run(String... args) throws Exception {
		System.out.println("testeee");

		List<User> usersList = new ArrayList<>();
		usersList.add( new User(null,"Maria","maria@gmail.com","992349140","12345"));
		usersList.add( new User(null,"Alex","alexa@gmail.com","995643540","1256365"));
		usersList.add( new User(null,"Sabrina","sabsabrina@gmail.com","9414121240","senha"));
		usersList.add( new User(null,"Leandro","leaxexandro@goooglemail.com","94124124540","54321"));
		usersList.add( new User(null,"Gustavo","gugu@peru.com","995643540","12512412415"));
		

		List<Order> orderList = new ArrayList<>();
		orderList.add( new Order(null, Instant.parse("2019-06-20T19:53:07Z"), usersList.get(1),OrderStatus.PAID));
		orderList.add( new Order(null, Instant.parse("2019-07-21T03:42:10Z"), usersList.get(2),OrderStatus.CANCELED));
		orderList.add( new Order(null, Instant.parse("2019-07-22T15:21:22Z"), usersList.get(0),OrderStatus.SHIPPED));
		orderList.add( new Order(null, Instant.parse("2019-08-07T14:21:20Z"), usersList.get(1),OrderStatus.WAITING_PAYMENT));
		orderList.add( new Order(null, Instant.parse("2019-08-07T14:25:22Z"), usersList.get(1),OrderStatus.DELIVERED));
		orderList.add( new Order(null, Instant.parse("2019-09-07T15:04:20Z"), usersList.get(3),OrderStatus.CANCELED)); 

		Category cat1 = new Category(null, "Electronics");
		Category cat2 = new Category(null, "Books");
		Category cat3 = new Category(null, "Computers");
		
		categoryRepository.saveAll(Arrays.asList(cat1,cat2,cat3));
		
		userRepository.saveAll(usersList);
		orderRepository.saveAll(orderList);
	}
}
