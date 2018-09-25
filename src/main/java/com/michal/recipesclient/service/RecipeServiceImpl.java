package com.michal.recipesclient.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.michal.recipesclient.dto.RecipeDTO;

@Service
public class RecipeServiceImpl implements RecipeService {

	@Value("${resource.recipes}")
	private String resource;
	
	@Value("${resource.recipes}/{id}")
	private String idResource;
	
	@Autowired
	private RestTemplate restTemplate;
	
	/*private final RestTemplate restTemplate;
	
	public RecipeServiceImpl(RestTemplateBuilder restTemplateBuilder) {
		restTemplate = restTemplateBuilder.build();
	}*/

	@Override
	public List<RecipeDTO> findAll() {
		return Arrays.stream(restTemplate.getForObject(resource, RecipeDTO[].class))
				.collect(Collectors.toList());
	}

	@Override
	public RecipeDTO createRecipe(RecipeDTO recipeDTO) {
		return restTemplate.postForObject(resource, recipeDTO, RecipeDTO.class);
	}

	@Override
	public RecipeDTO getById(int id) {
		return restTemplate.getForObject(idResource, RecipeDTO.class, id);
	}

	@Override
	public RecipeDTO updateRecipe(RecipeDTO recipeDTO, int id) {
		return restTemplate.exchange(idResource, HttpMethod.PUT, new HttpEntity<>(recipeDTO), RecipeDTO.class, id).getBody();
		
	}

	@Override
	public void deleteRecipe(int id) {
		restTemplate.delete(idResource, id);
	}

	
	
	
	
}
