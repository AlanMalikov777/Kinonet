package com.app.kinonet.home.model;

public class FoodNearByModel {


    String name,review,delivery_type,deliveryTime, id;
    int image;

    public FoodNearByModel(String name, String review, String time, String delivery_type, int image, String id) {
        this.name = name;
        this.review=review;
        deliveryTime = time;
        this.delivery_type = delivery_type;
        this.image = image;
        this.id = id;
    }



    public String getDeliveryType() {
        return delivery_type;
    }


    public String getReview() {
        return review;
    }

    public int getImage() {
        return image;
    }

    public String getTime() {
        return deliveryTime;
    }


    public String getName() {
        return name;
    }
    public String getId() {return  id;}






}