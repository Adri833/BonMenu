package es.thatapps.bonmenu.model;

public class Supermercado {
    // Atributos
    private String nombre;
    private String imagenUrl;

    // Constructor
    public Supermercado(String nombre, String imagenUrl) {
        this.nombre = nombre;
        this.imagenUrl = imagenUrl;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public String getImagenUrl() {
        return imagenUrl;
    }
}
