package com.michal.recipesclient.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.michal.recipesclient.dto.RecipeDTO;
import com.michal.recipesclient.service.RecipeService;

@Controller
public class RecipeController {

	private RecipeService recipeService;

	@Autowired
	public RecipeController(RecipeService recipeService) {
		this.recipeService = recipeService;
	}
	
	@GetMapping("/recipes")
	public String showRecipe(Model model) {
		List<RecipeDTO> recipeDTOs = recipeService.findAll();
		model.addAttribute("recipes", recipeDTOs);
		RecipeDTO recipeDTO = new RecipeDTO();
		model.addAttribute("recipe", recipeDTO);
		return "home";
	}
	
	@PostMapping("/processRecipeForm")
	public String addRecipe(@ModelAttribute("recipe") RecipeDTO recipeDTO) {
		recipeService.createRecipe(recipeDTO);
		
		return "redirect:/recipes";
	}
	
	@GetMapping("/showRecipeForm/{id}")
	public String updateRecipeForm(@PathVariable int id, Model model) {
		RecipeDTO recipeDTO = recipeService.getById(id);
		model.addAttribute("recipe", recipeDTO);
		return "recipe-form";
	}
	
	@PutMapping("/updateRecipe")
	public String updateRecipe(@ModelAttribute RecipeDTO recipeDTO, @RequestParam int id) {
		recipeService.updateRecipe(recipeDTO, id);
		return "redirect:/recipes";
	}
	
	@DeleteMapping("/deleteRecipe")
	public String deleteRecipe(@RequestParam int id) {
		recipeService.deleteRecipe(id);
		return "redirect:/recipes";
	}
	
	@GetMapping("/showRecipe/{id}")
	public String showRecipe(@PathVariable int id, Model model) {
		RecipeDTO recipeDTO = recipeService.getById(id);
		model.addAttribute("recipe", recipeDTO);
		return "recipe";
	}
	
	
	
	
	
	
	
	
}
