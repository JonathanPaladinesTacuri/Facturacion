
package modelo;


public class Articulo {
    
    private int id_articulo;
    private String descripcion;
    private double precio;
    private int stock;
  
    

    public Articulo() {
    }

    public Articulo(int id_articulo, String descripcion, double precio, int stock) {
        this.id_articulo = id_articulo;
        this.descripcion = descripcion;
        this.precio = precio;
        this.stock = stock;
    }

    public int getId_articulo() {
        return id_articulo;
    }

    public void setId_articulo(int id_articulo) {
        this.id_articulo = id_articulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Articulo{" + "id_articulo=" + id_articulo + ", descripcion=" + descripcion + ", precio=" + precio + ", stock=" + stock + '}';
    }

  
    
    
    
    
}
