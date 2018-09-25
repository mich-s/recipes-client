package com.michal.recipesclient.dto;

public class RecipeDTO {

	private int id;
	private String name;
	private String method;
	private String ingredients;
	
	public RecipeDTO() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getIngredients() {
		return ingredients;
	}

	public void setIngredients(String ingredients) {
		this.ingredients = ingredients;
	}

	@Override
	public String toString() {
		return "Recipe [id=" + id + ", name=" + name + ", method=" + method + ", ingredients=" + ingredients + "]";
	}
	
	
	
}
