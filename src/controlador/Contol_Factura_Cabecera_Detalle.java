package controlador;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import modelo.Cliente;
import modelo.FacturaCliente;
import modelo.Factura_Detalle;

public class Contol_Factura_Cabecera_Detalle {
    
    
    
    ConexionBD conexion=new ConexionBD();
   
   
    public void ingresarFactura(FacturaCliente fctCliente) {
        try {
            
            
            
            PreparedStatement p = null;

            String sql = " INSERT INTO fact_cabecera "
                    + "(idCabecera,fecha,cedula,nombre,apellido,direccion,telefono)"
                    + " VALUES ("
                    + "" + fctCliente.getIdCabecera() + ","
                    + "'" + fctCliente.getFecha() + "', "
                    + "\"" + fctCliente.getCedula() + "\","
                    + "\"" + fctCliente.getNombre() + "\","
                    + "\"" + fctCliente.getApellido() + "\","
                    + "\"" + fctCliente.getDireccion() + "\","
                    + "\"" + fctCliente.getTelefono() + "\");";
                  
               

           System.out.println(sql);

          Statement sta = (Statement) conexion.conectarBD().createStatement();
           
           sta.execute(sql);

           System.out.println("Ingresado Factura....");
          //JOptionPane.showMessageDialog(null, "Factura Ingresanda!!!");
          
          

         conexion.desconectarBD();

       } catch (Exception e) {
           System.out.println("!!!ERROR:" + e);
           //JOptionPane.showMessageDialog(null, "ERROR!!!!"+e);
       }

   }
   
   
   
      public void eliminar_factura_cliente(int id_factura) {

       Statement sta = null;
       try {
    
           String sql = "DELETE FROM `fact_cabecera` WHERE idCabecera= " + id_factura+" ";
           
           sta = (Statement) conexion.conectarBD().createStatement();
           System.out.println(sql);
           int n = sta.executeUpdate(sql);
           //JOptionPane.showMessageDialog(null, "Cliente Eliminado!!!!");
           System.out.println("eliinando factura.....");
         
          
           conexion.desconectarBD();

       } catch (Exception e) {
           
           System.out.println("!!!ERROR:" + e);
           // JOptionPane.showMessageDialog(null, "ERROR!!!!"+e);
       }

   }
   
     public void ingresarDetalle(Factura_Detalle fctDetalle) {
       try {
           
           
           
           PreparedStatement p = null;

           String sql = " INSERT INTO fact_detalle "
                   + "(idDetalle,idArticulo,descripcion,cantidad,precio_venta,descuento,iva,subtotal,total)"
                   + " VALUES ("
                   + "" + fctDetalle.getIdDetalle() + ","
                    + "" + fctDetalle.getIdArticulo() + ","
                   + "\"" + fctDetalle.getDescripcion() + "\","
                   + "" + fctDetalle.getCantidad() + ","
                 + "" + fctDetalle.getPrecio_venta() + ","
                   + "" + fctDetalle.getDescuento() + ","
                   + "" + fctDetalle.getIVA() + ","
                   + "" + fctDetalle.getSubtotal() + ","
                   + "" + fctDetalle.getTotal() + ");";
                  
               

           System.out.println(sql);

          Statement sta = (Statement) conexion.conectarBD().createStatement();
           
           sta.execute(sql);

           System.out.println("Ingresado Detalle de Factura....");
          //JOptionPane.showMessageDialog(null, "Factura Ingresanda!!!");
          
          

         conexion.desconectarBD();

       } catch (Exception e) {
           System.out.println("!!!ERROR:" + e);
           //JOptionPane.showMessageDialog(null, "ERROR!!!!"+e);
       }

   }
   
     
     
        public ResultSet calula_Total_Factura(int id_factura) {

       ResultSet rs = null;
       Statement sta = null;

       try {

           sta = (Statement) conexion.conectarBD().createStatement();

           String sql1 = "SELECT fct_cli.cedula,fct_cli.nombres,fct_cli.apellidos,fct_cli.telefono ,fct_det.id_articulo, fct_det.descripcion, fct_det.cantidad, "
                   + "   fct_det.precio_venta, fct_det.descuento, fct_det.subtotal FROM factura_cliente fct_cli ,factura_detalle fct_det "
                   + "where fct_cli.id_factura_cabecera =2 and fct_det.id_factura_detalle = 2";

           rs = sta.executeQuery("SELECT SUM(subtotal) FROM factura_detalle where id_factura_detalle= " + id_factura + " ");

       } catch (SQLException ex) {

           System.out.println("!!!ERROR: " + ex);
       }
       return rs;
   }
   
   
   
   
   
}
