package com.michal.recipesclient.tests;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.AutoConfigureWebClient;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.MockRestServiceServer;

import com.michal.recipesclient.dto.RecipeDTO;
import com.michal.recipesclient.service.RecipeService;

@RunWith(SpringRunner.class)
@RestClientTest(RecipeService.class)
@AutoConfigureWebClient(registerRestTemplate=true)
public class RecipeClientTests {
	
	@Autowired
	private RecipeService recipeService;
	
	@Autowired
	private MockRestServiceServer mockServer;

	
	@Test
	public void getByIdWhenResultIsSuccesShouldReturnRecipe() throws Exception{

		this.mockServer.expect(requestTo("http://localhost:8080/recipes-app/recipes/1"))
						.andExpect(method(HttpMethod.GET))
						.andRespond(withSuccess(getClassPathResource("recipe.json"), MediaType.APPLICATION_JSON));
		
		
		RecipeDTO recipeDTOTest = recipeService.getById(1);
		
		assertEquals(1, recipeDTOTest.getId());
		assertEquals("spaghetti", recipeDTOTest.getName());
		assertEquals("buy a spaghetti in a local store", recipeDTOTest.getMethod());
		assertEquals("random ingredients", recipeDTOTest.getIngredients());
		
		mockServer.verify();
	}
	
	
	private ClassPathResource getClassPathResource(String path) {
		
		return new ClassPathResource(path);
	}
	
	
}
