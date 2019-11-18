
package vista;


import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.spi.DirStateFactory;

import controlador.ConexionBD;
import controlador.Contol_Factura_Cabecera_Detalle;
import controlador.Controlador_Articulo;
import controlador.Controlador_Cliente;

import modelo.Articulo;
import modelo.Cliente;
import modelo.FacturaCliente;
import modelo.FacturaCliente;
import oracle.jrockit.jfr.tools.ConCatRepository;


public class Main {
    
    
    
    
    public static void main(String[] args) throws SQLException {
        
    ConexionBD conecxion=new ConexionBD();

        
     /**   System.out.println("Prueba metodo insertar.....");
        Cliente c1=new Cliente("0706394335","Jonathan","Paladines","Pasaje","0960157570");
        Controlador_Cliente controlador=new Controlador_Cliente();
        controlador.ingresarCliente(c1);
 */
      
          
          
    /**      System.out.println("Prueba del medoto listar");
          Controlador_Cliente control_cli=new Controlador_Cliente();
          
          ResultSet rs = null;
          String cadena = "";
          
          conecxion.conectarBD();
          rs=control_cli.listar_Cliente();
          
          while (rs.next()) {     
              
              System.out.println("Cedula:"+rs.getString(1) + "  Nombre:"+rs.getString(2) + "  Apellido:" +rs.getString(3) + " Direccion:" +rs.getString(4) + 
                                  " Telefono: "  +rs.getString(5));
             
              
        }
      
  
*/  
    
   /**   System.out.println("Prueba metdo eliminar cliente:");
        Controlador_Cliente ctrl_cli=new Controlador_Cliente();
        
        String cedula="0706394335";
        ctrl_cli.eliminar_cliente(cedula);
         
    
    */
    
    
        
 /**
            System.out.println("Prueba del Metdoo buscar");
            conecxion.conectarBD();
            ControladorCliente ctrl_cli=new ControladorCliente();
            ctrl_cli.buscar_Cliente("01021394904");
    
   */       
      

 
  /**      System.out.println("Prueba del Metodo para actualizar:"); 
        Controlador_Cliente ctrl_cli=new Controlador_Cliente();
        Cliente c=new Cliente("0706394335","Jonathan", "Paladines", "Cuenca", "0960157570");
       ctrl_cli.actualizar_Cliente(c, "0706394335");
    */     
            
            
 //--------------------------------------------------------------------------------------------------------------------------------------------
 
  /**
        System.out.println("Prueba Ingresar Proveedor");
        Controlador_Proveedor ctrl_proveedor = new Controlador_Proveedor();

        Proveedor proveedor = new Proveedor(2, "0106540214", "Proeveedor 2 ", "2222", "Av gil ramirez", "2830270", "Cuenca", "Ferreteria 1 ");

        ctrl_proveedor.ingresarProveedor(proveedor);
    
*/
    
    /**
         System.out.println("Prueba del medoto listar");
        Controlador_Proveedor ctrl_pro=new Controlador_Proveedor();

        ResultSet rs = null;
        String cadena = "";

        conecxion.conectarBD();
        rs = ctrl_pro.listar_Proveedor();

        while (rs.next()) {

            System.out.println("id_proveedor:" + rs.getInt(1) + " Cedula: "+rs.getString(1) +" Nombre:"+ rs.getString(3) + " Apellido:"+rs.getString(4) + " Direccion:" +rs.getString(5) 
                    + " Telefono:"+rs.getString(6) + " Ciudad:"+rs.getString(7) + " Nombre del Comerial:"+rs.getString(8));

    }   
     */   
        
        
    
        /**
        System.out.println("Prueba metdo eliminar proveedor:");
        Controlador_Proveedor ctrl_pro=new Controlador_Proveedor();
        
        String cedula="0106540214";
        ctrl_pro.eliminar_proveedor(cedula);
       */
    
    
        /**
        System.out.println("Prueba buscar proveedor:");
        Controlador_Proveedor ctrl_pro=new Controlador_Proveedor();
        String cedula="1234567891";
        ctrl_pro.buscar_Proveedor(cedula);
        */
    
        /**
        System.out.println("Prueba del Metodo para actualizar:");
        Controlador_Proveedor ctrl_pro=new Controlador_Proveedor();
        
        String cedula="1234567891";
        Proveedor p=new Proveedor(1, "", "  Ana", "Garcia", "Av de las Amricas y Remigio Crespo", "2816237", "Cuenca", "Quifatex1");
        
        ctrl_pro.actualizar_Proveedor(p, cedula);
        */
        
 //-------------------------------------------------------------------------------------------------------------------------------------------
   
 
  /**  System.out.println("Prueba Ingresar Articulo");
        
        Controlador_Articulo ca=new Controlador_Articulo();
 
        Articulo articulo= new Articulo (3,"clavos",0.05, 900);
        ca.ingresarArticulo(articulo);
     
    
    */
 
  /**    System.out.println("Prueba del medoto listar");
        Controlador_Articulo ca = new Controlador_Articulo();

        ResultSet rs = null;
        String cadena = "";

        conecxion.conectarBD();
        rs = ca.listar_Articulo();

        while (rs.next()) {

            System.out.println("id_articulo:" + rs.getInt(1) + " Descripcion: " + rs.getString(2) + " Precio :" + rs.getDouble(3) + " Stock:" + rs.getInt(4));

    }   
  */
      
  
 /** System.out.println("Prueba metdo eliminar articulo:");
        Controlador_Articulo ca=new Controlador_Articulo();
          ca.eliminar_Articulo(3);
    */    
        
        conecxion.conectarBD();
      
       System.out.println("Prueba buscar articulo:");
        Controlador_Articulo ca=new Controlador_Articulo();
        int a=1;
        
       ca.buscar_Articulo(a);
      // System.out.println("Articulo"+ca.buscar_Articulo("Cemento"));
      
      
   
       
   /**  System.out.println("Prueba actualizar articulo");
        Controlador_Articulo ca=new Controlador_Articulo();
        Articulo articulo=new Articulo(1, "Martillo", 3, 25);
        
        ca.actualizar_Articulo(articulo, 1);
      */ 
        
        
        
        
   
 //       Conexion_4free.getConnection();
        
        
        
        
        
        
  //   new Menu().setVisible(true);
    
           //     
 
 //--------------------------------------------------------------------------------------------------------------------------------------------------------------

       
   /** Contol_Factura_Cabecera_Detalle cf = new Contol_Factura_Cabecera_Detalle();
        
        Date fecha=new Date(2019, 10, 15);
        
        FacturaCliente fct=new FacturaCliente (2,fecha,"0706394335","Jonathan","Paladines","Pasaje","0960157570");
        
        cf.ingresarFactura(fct);
      
       */  
         
       /** 
            System.out.println("Prueba del medoto listar");
            Contol_Factura_Cabecera_Detalle cf = new Contol_Factura_Cabecera_Detalle();
            

        ResultSet rs = null;
        String cadena = "";

        conecxion.conectarBD();
        rs = cf.listar_Factura_Cliente();

        while (rs.next()) {

            System.out.println("id_factura_cliente:" + rs.getInt(1) + " Fecha: " + rs.getDate(2)
                    + " Cedula:" + rs.getString(3) + " Nombres :" + rs.getString(4) + " Apellidos:" + rs.getString(5)
                    + " Direccion:" + rs.getString(6) + " Telefono:" + rs.getString(7)
                    + " ID Articulo:" + rs.getInt(8) + " Descripcion:" + rs.getString(9) + " Cantidad:" + rs.getInt(10)
                    + " Precio Venta:" + rs.getDouble(11) + " Descuento:" + rs.getInt(12) + " IVA:" + rs.getInt(13)
                    + " Subtotal:" + rs.getDouble(14) + " Total:" + rs.getDouble(15));

        }
*/
         
         /**
         Controlador_Factura_Cliente cf=new Controlador_Factura_Cliente();
         cf.eliminar_factura_cliente("1");
         
         */
//         
//         ControladorCliente c=new ControladorCliente();
//         System.out.println("Estado"+c.validadorDeCedula("2222222222"));
  
     /**    
       Controlador_Fac_Cabecera controlador_cabecera = new Controlador_Fac_Cabecera ();
       Factura_Cabecera fac_cabecera = new Factura_Cabecera (1,"0706394335","Jonathan","Paladines","Cuenca","0960157570");
       controlador_cabecera.ingresarFacturaCabecera(fac_cabecera);
       */
         
         // System.out.println("Prueba del medoto listar");
          //Controlador_Fac_Cabecera control_fac_cabe=new Controlador_Fac_Cabecera();
      /** 
       ResultSet rs = null;
       String cadena = "";
       
       //conecxion.conectarBD();
       rs=control_fac_cabe.listar_FacturaCabecera();
       
       while (rs.next()) {     
           
           System.out.println("Id_Cabecera:"+rs.getInt(1) +"Cedula:"+rs.getString(2) + "  Nombre:"+rs.getString(3) + "  Apellido:" +rs.getString(4) + " Direccion:" +rs.getString(5) + 
                               " Telefono: "  +rs.getString(6));
          
           
     }
         */
         
         
         
         
         
         
         
         
         
           
           
}
}
