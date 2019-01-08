package net.ivancl4udio.customer.data;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;

import net.ivancl4udio.customer.data.domain.Customer;
import net.ivancl4udio.customer.data.repository.CustomerRepository;

@EnableEncryptableProperties
@SpringBootApplication
public class CustomerDataApplication {

	private static final Logger log = LoggerFactory.getLogger(CustomerDataApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(CustomerDataApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(CustomerRepository repository) {
		return (args) -> {
			
			/**
			log.info("Criando registros de exemplo");
			repository.save(new Customer("jbauer", "Jack", "Bauer"));
			repository.save(new Customer("cobrian", "Chloe", "O'Brian"));
			repository.save(new Customer("kbauer", "Kim", "Bauer"));
			repository.save(new Customer("dpalmer", "David", "Palmer"));
			repository.save(new Customer("mdessler", "Michelle", "Dessler"));
			*/
			
			log.info("Realiza busca com findAll");
			log.info("-------------------------");
			
			for(Customer customer : repository.findAll()) {
				log.info(customer.toString());
			}
			
			log.info("Realiza busca com findById");
			log.info("--------------------------");
			
			repository.findById(1L)
				.ifPresent(customer -> {
					log.info("Customer found with findById(1L):");
					log.info("--------------------------------");
					log.info(customer.toString());
					log.info("");
			});
			
			log.info("Realiza busca com findByLastName");
			log.info("--------------------------------");
			
			log.info("Customer found with findByLastName('Bauer'):");
			log.info("--------------------------------------------");
			
			repository.findByLastName("Bauer").forEach(bauer -> {
				log.info(bauer.toString());
			});		
		};
	}
}

