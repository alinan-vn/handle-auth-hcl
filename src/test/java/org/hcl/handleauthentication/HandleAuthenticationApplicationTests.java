//package org.hcl.handleauthentication;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.boot.test.context.SpringBootTest;
//
//@SpringBootTest
//class HandlingUserAuthenticationApplicationTests {
//
//	@Test
//	void contextLoads() {
//	}
//
//}
//------------------------------------------------------------------------------------
//------------------------------------------------------------------------------------

package org.hcl.handleauthentication;

import static org.assertj.core.api.Assertions.assertThat;

import org.hcl.handleauthentication.crudRepository.UserCrudRepo;
import org.hcl.handleauthentication.entity.UserEntity;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

@DataJpaTest
class HandlingUserAuthenticationApplicationTests {
	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired 
	private UserCrudRepo userCrudRepo;
	
	@Test
	void testCreateUser() {
		UserEntity newExampleUser = new UserEntity();
		newExampleUser.setName("John");
		newExampleUser.setPassword("guest");
		entityManager.persist(newExampleUser);
		
		Iterable<UserEntity> allUsers = userCrudRepo.findAll();
		UserEntity exampleUser = new UserEntity();
		for( UserEntity u : allUsers) {
			if (u.getName().equals("John")) {
				exampleUser = u;
			}
		}
		
		assertThat(exampleUser.getName()).isEqualTo("John");
	}
	
	// EXAMPLE START
//	@Autowired
//	private TestEntityManager entityManager;
//	
//	@Autowired
//	private ProductRepository productRepository;
//	
//	@Test
//	void testSaveNewProduct() {
//		entityManager.persist(new Product("iPhone 10", 1099));
//		
//		Product product = repository.findByName("iPhone 10");
//		
//		assertThat(product.getName()).isEqualTo("iPhone 10");
//	}
	// EXAMPLE END

}