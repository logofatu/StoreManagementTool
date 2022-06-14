package com.example.StoreManagementTool;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.fasterxml.jackson.databind.ObjectMapper;

import app.model.Product;
import app.repository.ProductRepository;

@ContextConfiguration(classes={ProductRepository.class})
@SpringBootTest(classes = Product.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@TestMethodOrder(OrderAnnotation.class)
class StoreManagementToolApplicationTests {

	@Autowired
	ProductRepository repository;
	
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private ObjectMapper objectMapper;
	
    @BeforeEach
    void setup(){
    	repository.deleteAll();
    }
	  
    
    @Test
    public void givenEmployeeObject_whenCreateEmployee_thenReturnSavedEmployee() throws Exception{

        Product product = new Product("c1", "description for c1", 10d);

        ResultActions response = mockMvc.perform(post("/api/products")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(product)));

        verify(repository, times(1)).save(any());
    }
    
	@Test
	@Order(1)
	public void testCreate () {
		Product product = new Product();
		product.setId(1L);
		product.setCode("c1");
		product.setDescription("description for product c1");
		product.setPrice(1000.00);
		repository.save(product);
		assertNotNull(repository.findById(1L).get());
	}
		
	@Test
	@Order(2)
	public void testReadAll () {
		List<Product> list = repository.findAll();
		assertThat(list).size().isGreaterThan(0);
	}
		
	@Test
	@Order(3)
	public void testRead () {
		Product product = repository.findById(1L).get();
		assertEquals("c1", product.getCode());
	}
		
	@Test
	@Order(4)
	public void testUpdate () {
		Product p = repository.findById(1L).get();
		p.setPrice(800.00);
		repository.save(p);
		assertNotEquals(700.00, repository.findById(1L).get().getPrice());
	}
		
	@Test
	@Order(5)
	public void testDelete () {
		repository.deleteById(1L);
		assertThat(repository.existsById(1L)).isFalse();
	}
}