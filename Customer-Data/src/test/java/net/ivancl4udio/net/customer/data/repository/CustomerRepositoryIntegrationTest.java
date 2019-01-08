package net.ivancl4udio.net.customer.data.repository;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import net.ivancl4udio.customer.data.domain.Customer;
import net.ivancl4udio.customer.data.repository.CustomerRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CustomerRepositoryIntegrationTest {

	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Test
	public void whenFindByName_thenReturnCustomer() {
		// given
		Customer alex = new Customer("alex", "Alex","Silva");
		entityManager.persist(alex);
		entityManager.flush();
		
		// when
		Customer found = customerRepository.findByUsername(alex.getUsername());
		
		//then
		assertThat(found.getUsername()).isEqualTo(alex.getUsername());
	}
}
