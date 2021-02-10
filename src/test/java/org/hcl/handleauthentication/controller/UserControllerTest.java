package org.hcl.handleauthentication.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.hcl.handleauthentication.crudRepository.UserCrudRepo;
import org.hcl.handleauthentication.entity.UserEntity;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

	@Autowired
	private MockMvc mvc;
	
	@Autowired
	private UserCrudRepo userCrudRepo;
	
	@Test
	void loginUser() throws Exception {
		UserEntity dummy = new UserEntity();
		dummy.setName("pedro");
		dummy.setPassword("guest");
		userCrudRepo.save(dummy);
		
		RequestBuilder request = MockMvcRequestBuilders.get("/login?name=pedro&password=guest");
		MvcResult result = mvc.perform(request).andReturn();
		System.out.println("REPONSE: ---");
		System.out.println(result.getResponse().getContentAsString());
		assertEquals("true", result.getResponse().getContentAsString());
	}
	
	@Test
	void mockMethod() throws Exception {
		RequestBuilder request = MockMvcRequestBuilders.get("/mock");
		MvcResult result = mvc.perform(request).andReturn();
		assertEquals("Hello", result.getResponse().getContentAsString());
	}
}
