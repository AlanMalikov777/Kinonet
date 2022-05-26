
package com.app.kinonet.food_category.model;

public class FoodCategoryModel {


    private String category_name;
    private int image;

    public FoodCategoryModel(String category_name, int image) {
        this.category_name = category_name;
        this.image = image;
    }


    public String getCategoryName() {
        return category_name;
    }

    public void setCategoryName(String category_name) {
        this.category_name = category_name;
    }


    public int getCategoryImage() {
        return image;
    }
}