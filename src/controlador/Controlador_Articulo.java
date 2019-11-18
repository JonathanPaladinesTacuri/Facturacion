package controlador;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import modelo.Articulo;
import modelo.Cliente;


public class Controlador_Articulo {
    
      ConexionBD conexion = new ConexionBD();
      
    
     public void ingresarArticulo(Articulo articulo) {
        try {
            
            conexion.conectarBD();
            PreparedStatement p = null;

            String sql = " INSERT INTO articulo "
                    + "(id_articulo,descripcion,precio,stock)"
                    + " VALUES ("
                    + "" + articulo.getId_articulo() + ","
                    + "\"" + articulo.getDescripcion() + "\", "
                    + "\"" + articulo.getPrecio() + "\", "
                    + "" + articulo.getStock() + ");";
                    

            System.out.println(sql);
            Statement sta = conexion.conectarBD().createStatement();
            sta.execute(sql);

            JOptionPane.showMessageDialog(null, "Articulo Ingresado..");
            System.out.println("ingresando articulo....");

            conexion.desconectarBD();

        } catch (Exception e) {
            System.out.println("!!!ERROR:" + e);
            JOptionPane.showMessageDialog(null, "Error!!!:"+e);
        }
     }

   
    public List<Articulo>  listar_Articulo() {
    	
    	List<Articulo> listaArticulo = new ArrayList<>();

        ResultSet rs = null;
        Statement sta = null;
        try {
            
            sta = conexion.conectarBD().createStatement();
            rs = sta.executeQuery("SELECT * FROM articulo");
            
            while (rs.next() ){
            	Articulo A= new Articulo();
            	A.setId_articulo(rs.getInt(1));
            	A.setDescripcion(rs.getString(2));
            	A.setPrecio(rs.getDouble(3));
            	A.setStock(rs.getInt(4));
            	listaArticulo.add(A);
            }
            conexion.desconectarBD();

        } catch (SQLException ex) {

            System.out.println("!!!ERROR: " + ex);
        }
        return listaArticulo;
    }
        
    public void eliminar_Articulo(int id_articulo) {

        Statement sta = null;
        try {
     
            String sql = "DELETE FROM `articulo` WHERE id_articulo= \"" + id_articulo+"\" ";
            sta = conexion.conectarBD().createStatement();
            System.out.println(sql);
            int n = sta.executeUpdate(sql);
            
            System.out.println("eliminando articulo.....");
            JOptionPane.showMessageDialog(null, "Articulo Eliminado....");
            conexion.desconectarBD();

        } catch (Exception e) {
            System.out.println("!!!ERROR:" + e);
             JOptionPane.showMessageDialog(null, "ERROR!!! "+e);
        }

    }
        
        
     public Articulo buscar_Articulo(int id) {

        try {
            PreparedStatement pps = null;
            ResultSet rs = null;
           // System.out.println(string);
            String sql="Select *  FROM articulo WHERE id_articulo="+ id +" ";
            
            conexion.conectarBD();
          
            pps = conexion.conectarBD().prepareStatement(sql);               
            rs = pps.executeQuery();
            System.out.println(sql);
        
            if (rs.next()) {

                Articulo articulo=new Articulo();
                
                articulo.setId_articulo(rs.getInt(1));
                articulo.setDescripcion(rs.getString(2));
                articulo.setPrecio(rs.getDouble(3));
                articulo.setStock(rs.getInt(4));
                
               
                 System.out.println(articulo);
                 return (articulo);
                 
          //    double precio=articulo.getPrecio();
            //  int stock=articulo.getStock();
                
                
               // Ventana_Articulos.txt_descripcion_articulo.setText(articulo.getDescripcion());
               // Ventana_Articulos.txt_precio_venta_articulo.setText(Double.toString(precio));
                //Ventana_Articulos.txt_stock_articulo.setText(Integer.toString(stock));
                
                
               
                
               
                
               
            } else {
              System.out.println("No existe el registro");
                JOptionPane.showMessageDialog(null, "No existe el registro");
            }
            conexion.desconectarBD();

        } catch (SQLException ex) {

            System.out.println("ERROR!!!! ," + ex);

        }
		return null;
        
          } 
        
        
     
     
     
     public void actualizar_Articulo(Articulo articulo, int id) {

        String sql = "UPDATE articulo  SET "
                + "descripcion=\"" + articulo.getDescripcion() + "\" "
                + ",precio=" + articulo.getPrecio() + ""
                + ",stock=\"" + articulo.getStock() + "\""
                + " WHERE id_articulo=\"" + id + "\"";
        try {

            System.out.println(sql);

            PreparedStatement pps = conexion.conectarBD().prepareStatement(sql);

            pps.executeUpdate();

              JOptionPane.showMessageDialog(null, "Articulo Modificado....");
            System.out.println("actualizando articulo......");

        } catch (SQLException ex) {
            System.out.println(" !!!Error: " + ex);
            JOptionPane.showMessageDialog(null, "ERROR!!! "+ex);

        }

    }
     
     
     
     
     
      public ResultSet obtener_codigo() {
        Statement sta = null;
        ResultSet rs = null;
        try {

            sta = conexion.conectarBD().createStatement();
            
            //SELECT MAX(id_articulo)+1  FROM articulo
            
            rs = sta.executeQuery("SELECT MAX(id_articulo)+1 FROM articulo ");
        } catch (SQLException ex) {
            System.out.println("EEROR!!! " + ex);

        }

        return rs;

    }
      
      
      
      
      
      
      
   
     
     
        
        public void actualizar_stock(int cantidad, int id_articulo) {

        String sql = "update articulo set stock=stock- " + cantidad + " where id_articulo=" + id_articulo;

        try {

            System.out.println(sql);

            PreparedStatement pps = conexion.conectarBD().prepareStatement(sql);

            pps.executeUpdate();

            // JOptionPane.showMessageDialog(null, "Stock Modificado....");
            System.out.println("stock actualizado articulo......");

        } catch (SQLException ex) {
            System.out.println(" !!!Error: " + ex);
            JOptionPane.showMessageDialog(null, "ERROR!!! " + ex);

        }

    }
     
     
 
       public ResultSet controlarStock() {

        ResultSet rs = null;
        Statement sta = null;
        try {
             
            sta = conexion.conectarBD().createStatement();
            rs = sta.executeQuery("SELECT id_articulo,descripcion,stock FROM articulo");

        } catch (SQLException ex) {

            System.out.println("!!!ERROR: " + ex);
        }
        return rs;
    }
}
     