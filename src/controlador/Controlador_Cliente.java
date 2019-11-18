package controlador;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import modelo.Cliente;


public class Controlador_Cliente {

    ConexionBD conexion=new ConexionBD();
    
    /**
     * Metodo para ingresar un cliente a la BD
     * @param cliente tipo Cliente
     */
    
    public void ingresarCliente(Cliente cliente) {
        try {
            
            
            
            PreparedStatement p = null;

            String sql = " INSERT INTO cliente "
                    + "(cedula,nombre,apellido,direccion,telefono)"
                    + " VALUES ("
                    + "\"" + cliente.getCedula() + "\","
                    + "\"" + cliente.getNombre() + "\", "
                    + "\"" + cliente.getApellido() + "\","
                    + "\"" + cliente.getDireccion() + "\","
                    + "\"" + cliente.getTelefono() + "\")";
                   

            System.out.println(sql);

           Statement sta = conexion.conectarBD().createStatement();
          
            sta.execute(sql);

            //System.out.println("Ingresado....");
           JOptionPane.showMessageDialog(null, "Cliente Ingresando!!!");
           
           

          conexion.desconectarBD();

        } catch (Exception e) {
            System.out.println("!!!ERROR:" + e);
            JOptionPane.showMessageDialog(null, "ERROR!!!!"+e);
        }

    }
    
    
    /**
     * Metodo listar Cliente
     * @return  Resultset con una lista de clientes 
     */
    
     public List<Cliente> listar_Cliente() {
    	
    	List<Cliente> listaClientes = new ArrayList<>();
        ResultSet rs = null;
        Statement sta = null;
        try {
            
        	sta = conexion.conectarBD().createStatement();
            rs = sta.executeQuery("SELECT * FROM `cliente` ");
            
            
            while (rs.next() ){
				 Cliente c=new Cliente();
	               c.setCedula(rs.getString(1));
	               c.setNombre(rs.getString(2));
	               c.setApellido(rs.getString(3));
	               c.setDireccion(rs.getString(4));
	               c.setTelefono(rs.getString(5));
	               listaClientes.add(c);
			}
         
            conexion.desconectarBD();
        } catch (SQLException ex) {

            System.out.println("!!!ERROR: " + ex);
        }
        return listaClientes;
    }

        public void eliminar_cliente(String cedula) {

        Statement sta = null;
        try {
     
            String sql = "DELETE FROM `cliente` WHERE cedula= \"" + cedula+"\" ";
            
            sta = conexion.conectarBD().createStatement();
            System.out.println(sql);
            int n = sta.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Cliente Eliminado!!!!");
            System.out.println("eliinando cliente.....");
          
           
            conexion.desconectarBD();

        } catch (Exception e) {
            
            System.out.println("!!!ERROR:" + e);
             JOptionPane.showMessageDialog(null, "ERROR!!!!"+e);
        }

    }
        
       
          public Cliente buscar_Cliente(String cedula) {

        try {
            PreparedStatement pps = null;
            ResultSet rs = null;

            String sql="Select *  FROM `cliente` WHERE cedula= \"" + cedula+"\" ";
            
            conexion.conectarBD();
            
          
            pps = conexion.conectarBD().prepareStatement(sql);               
            rs = pps.executeQuery();
            System.out.println(sql);

            if (rs.next()) {

                
                Cliente c=new Cliente();
               c.setCedula(rs.getString(1));
               c.setNombre(rs.getString(2));
               c.setApellido(rs.getString(3));
               c.setDireccion(rs.getString(4));
               c.setTelefono(rs.getString(5));
                      
                
   
                System.out.println(c);
                return c;
               //VentanaClientes.txt_nombres.setText(c.getNombre());
              // VentanaClientes.txt_apellidos.setText(c.getApellido());
             //  VentanaClientes.txt_direccion.setText(c.getDireccion());
           //    VentanaClientes.txt_telefono.setText(c.getTelefono());
         //      VentanaClientes.txt_ciudad.setText(c.getCiudad());
                
               
            } else {
                JOptionPane.showMessageDialog(null, "No existe el registro ");
            }
            
           
            conexion.desconectarBD();

        } catch (SQLException ex) {

            System.out.println("ERROR!!!! ," + ex);
             JOptionPane.showMessageDialog(null, "ERROR!!!"+ex);

        }
		return null;
        
          }  
          
         
          
          
         public void actualizar_Cliente(Cliente cliente, String cedula) {

             
             String sql="UPDATE cliente  SET "
                    + "nombre=\"" + cliente.getNombre() + "\" "
                    + ",apellido=\"" + cliente.getApellido() + "\""
                    + ",direccion=\"" + cliente.getDireccion() + "\""
                    + ",telefono=\"" + cliente.getTelefono() + "\""
                    + " WHERE cedula=\"" + cedula + "\"";
        try {
            
              
            PreparedStatement pps = conexion.conectarBD().prepareStatement(sql);
            
               pps.executeUpdate();
                System.out.println(sql);
                JOptionPane.showMessageDialog(null, "Cliente Modificado.....");
                System.out.println("actualizando cliente......");
                
                
        } catch (SQLException ex) {
            System.out.println(" !!!Error: "+ex);
             JOptionPane.showMessageDialog(null, "ERROR!!!"+ex);

        }

    }
        
    
         
         
    public boolean validadorDeCedula(String cedula) {
        boolean cedulaCorrecta = false;

        try {

            if (cedula.length() == 10) // ConstantesApp.LongitudCedula
            {
                int tercerDigito = Integer.parseInt(cedula.substring(2, 3));
                if (tercerDigito < 6) {
// Coeficientes de validación cédula
// El decimo digito se lo considera dígito verificador
                    int[] coefValCedula = {2, 1, 2, 1, 2, 1, 2, 1, 2};
                    int verificador = Integer.parseInt(cedula.substring(9, 10));
                    int suma = 0;
                    int digito = 0;
                    for (int i = 0; i < (cedula.length() - 1); i++) {
                        digito = Integer.parseInt(cedula.substring(i, i + 1)) * coefValCedula[i];
                        suma += ((digito % 10) + (digito / 10));
                    }

                    if ((suma % 10 == 0) && (suma % 10 == verificador)) {
                        cedulaCorrecta = true;
                    } else if ((10 - (suma % 10)) == verificador) {
                        cedulaCorrecta = true;
                        JOptionPane.showMessageDialog(null, "Cedula Correcta");
                    } else {
                        cedulaCorrecta = false;
                    }
                } else {
                    cedulaCorrecta = false;
                }
            } else {
                cedulaCorrecta = false;
            }
        } catch (NumberFormatException nfe) {
            cedulaCorrecta = false;
        } catch (Exception err) {
            System.out.println("Una excepcion ocurrio en el proceso de validadcion");
            cedulaCorrecta = false;
        }

        if (!cedulaCorrecta) {
            JOptionPane.showMessageDialog(null, "Cedula Ingresada es Incorrecta");
            System.out.println("La Cédula ingresada es Incorrecta");
        }
        
        return cedulaCorrecta;
    }

  
         
         
         
         
  
    }