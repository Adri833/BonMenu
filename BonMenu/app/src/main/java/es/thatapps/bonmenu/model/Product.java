package es.thatapps.bonmenu.model;

public class Product {
    private String name;
    private String imageUrl; // Ahora usamos una URL para la imagen

    public Product(String name, String imageUrl) {
        this.name = name;
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}
