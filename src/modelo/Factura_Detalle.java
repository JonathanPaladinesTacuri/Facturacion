package modelo;

public class Factura_Detalle {
    
    
    
    
    private int idDetalle;
    private int idArticulo;
    private String descripcion;
    private double precio_venta;
    private int cantidad;
    private double descuento;
    private int IVA;
    private double subtotal;
    private double total;

    public Factura_Detalle() {
    }

    public Factura_Detalle(int idDetalle, int idArticulo, String descripcion, double precio_venta,int cantidad,  double descuento, int IVA, double subtotal, double total) {
        this.idDetalle = idDetalle;
        this.idArticulo = idArticulo;
        this.descripcion = descripcion;
        this.precio_venta = precio_venta;
        this.cantidad = cantidad;
        this.descuento = descuento;
        this.IVA = IVA;
        this.subtotal = subtotal;
        this.total = total;
    }

    public int getIdDetalle() {
        return idDetalle;
    }

    public void setIdDetalle(int idDetalle) {
        this.idDetalle = idDetalle;
    }

    public int getIdArticulo() {
        return idArticulo;
    }

    public void setIdArticulo(int idArticulo) {
        this.idArticulo = idArticulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio_venta() {
        return precio_venta;
    }

    public void setPrecio_venta(double precio_venta) {
        this.precio_venta = precio_venta;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public int getIVA() {
        return IVA;
    }

    public void setIVA(int IVA) {
        this.IVA = IVA;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Factura_Detalle{" + "idDetalle=" + idDetalle + ", idArticulo=" + idArticulo + ", descripcion=" + descripcion + ", cantidad=" + cantidad + ", precio_venta=" + precio_venta + ", descuento=" + descuento + ", IVA=" + IVA + ", subtotal=" + subtotal + ", total=" + total + '}';
    }
   
    
    
 
    
    
    
    
}