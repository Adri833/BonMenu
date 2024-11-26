package es.thatapps.bonmenu.model;

public class Plato {
    private String nombre;
    private String descripcion;
    private int imagenResource;

    public Plato(String nombre, String descripcion, int imagenResource) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.imagenResource = imagenResource;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getImagenResource() {
        return imagenResource;
    }
}
