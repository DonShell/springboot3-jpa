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
import com.donshell.testes.course.entities.OrderItem;
import com.donshell.testes.course.entities.Payment;
import com.donshell.testes.course.entities.Product;
import com.donshell.testes.course.entities.User;
import com.donshell.testes.course.entities.enums.OrderStatus;
import com.donshell.testes.course.repositories.CategoryRepository;
import com.donshell.testes.course.repositories.OrderItemRepository;
import com.donshell.testes.course.repositories.OrderRepository;
import com.donshell.testes.course.repositories.ProductRepository;
import com.donshell.testes.course.repositories.UserRepository;

@Configuration
@Profile("test")
public class testConfig implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private OrderItemRepository orderItemRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
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
		
		//Salvando pagamento
		Payment pay1 = new Payment(null, Instant.parse("2019-06-20T19:40:07Z"),orderList.get(0));
		//vinculando o pagamento
		orderList.get(0).setPayment(pay1);
		//o peyment sera salvo no banco no proximo orderRepository.saveAll(); que chame ele
		
		
		categoryRepository.saveAll(Arrays.asList(cat1,cat2,cat3));
		
		userRepository.saveAll(usersList);
		orderRepository.saveAll(orderList);
		
		Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
		Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
		Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
		Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
		Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, ""); 

		p1.getCategories().add(cat2);
		p2.getCategories().add(cat1);
		p2.getCategories().add(cat3);
		p3.getCategories().add(cat3);
		p4.getCategories().add(cat3);
		p5.getCategories().add(cat2);
		
		
		
		productRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));
		
		OrderItem oi1 = new OrderItem(orderList.get(0), p1, 2, p1.getPrice());
		OrderItem oi2 = new OrderItem(orderList.get(0), p3, 1, p3.getPrice());
		OrderItem oi3 = new OrderItem(orderList.get(1), p3, 2, p3.getPrice());
		OrderItem oi4 = new OrderItem(orderList.get(2), p5, 2, p5.getPrice()); 

		orderItemRepository.saveAll(Arrays.asList(oi1,oi2,oi3,oi4));
	}
}
