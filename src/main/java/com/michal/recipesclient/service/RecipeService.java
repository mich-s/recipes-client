package com.michal.recipesclient.service;

import java.util.List;

import com.michal.recipesclient.dto.RecipeDTO;

public interface RecipeService {

	public List<RecipeDTO> findAll();
	
	public RecipeDTO createRecipe(RecipeDTO recipeDTO);
	
	public RecipeDTO getById(int id);

	public RecipeDTO updateRecipe(RecipeDTO recipeDTO, int id);

	public void deleteRecipe(int id);
	
}
