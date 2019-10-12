package com.example.singhnicershop.model;

public class ShoppingItems {
    //variables for every textview in content
    String title;
    String description;
    String price;
    int image;
    String quantity;
    String subtotal;

    //constructor
    public ShoppingItems(String title,String description,String price,int image,String quantity,String subtotal){
        this.title = title;
        this.description = description;
        this.price = price;
        this.image = image;
        this.quantity = quantity;
        this.subtotal = subtotal;
    }

    //get set
    public String getTitle() {
        return title;
    }

    public String getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(String subtotal) {
        this.subtotal = subtotal;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
}
