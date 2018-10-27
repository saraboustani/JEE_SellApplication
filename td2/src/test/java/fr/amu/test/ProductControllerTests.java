package fr.amu.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import fr.amu.controllers.ProductController;
import fr.amu.services.ProductService;

@RunWith(SpringRunner.class)
@WebMvcTest(ProductController.class)

public class ProductControllerTests {
	@Autowired
	private ProductController controller;
	
	@Autowired
	MockMvc mvc;
	
	@MockBean
	ProductService ps;
	
	@Test
	public void add() throws Exception {
	mvc.perform(post("/add").contentType(MediaType.APPLICATION_FORM_URLENCODED_VALUE).param("title", "value")
	.param("description", "value").param("category","value"))
	.andExpect(view().name("homepage"));
	}
	
	
 
}