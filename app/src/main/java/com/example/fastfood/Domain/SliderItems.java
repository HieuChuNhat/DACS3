package com.example.fastfood.Domain;

public class SliderItems {
    private String image;

    // Constructor không tham số
    public SliderItems() {
    }

    // Constructor có tham số (nếu cần)
    public SliderItems(String image) {
        this.image = image;
    }

    // Getter và Setter
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
