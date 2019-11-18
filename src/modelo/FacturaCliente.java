package modelo;

import java.sql.Date;

public class FacturaCliente {
    
    private int idCabecera;
    private Date fecha;
    private String cedula;
    private String nombre;
    private String apellido;
    private String direccion;
    private String telefono;

  

    public FacturaCliente() {
        
    
    }

    public FacturaCliente(int idCabecera, Date fecha, String cedula, String nombres, String apellidos, String direccion, String telefono) {
        this.idCabecera = idCabecera;
        this.fecha = fecha;
        this.cedula = cedula;
        this.nombre = nombres;
        this.apellido = apellidos;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public int getIdCabecera() {
        return idCabecera;
    }

    public void setIdCabecera(int idCabecera) {
        this.idCabecera = idCabecera;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "FacturaCliente{" + "idCabecera=" + idCabecera + ", fecha=" + fecha + ", cedula=" + cedula + ", nombre=" + nombre + ", apellido=" + apellido + ", direccion=" + direccion + ", telefono=" + telefono + '}';
    }

    
    
    
    
    
    
  
      
}