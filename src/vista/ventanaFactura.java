package vista;

import java.awt.BorderLayout;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.util.Date;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import controlador.Contol_Factura_Cabecera_Detalle;
import controlador.Controlador_Articulo;
import controlador.Controlador_Cliente;
import modelo.Articulo;
import modelo.Cliente;
import modelo.FacturaCliente;


import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
//import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.ScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.Scrollbar;
import java.awt.List;
import javax.swing.JSpinner;
import java.awt.Panel;
import java.awt.Label;
import javax.swing.JTextPane;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ventanaFactura extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	
	Contol_Factura_Cabecera_Detalle cc = new Contol_Factura_Cabecera_Detalle();
	Controlador_Cliente coc = new Controlador_Cliente();
	public static JTable table;
	private JTextField textField_6;
	private JTextField textField_7;
	public static JTextField subtotalT;
	public static JTextField ivaT;
	public static JTextField descuentoT;
	public static JTextField totalT;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ventanaFactura frame = new ventanaFactura();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ventanaFactura() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 840, 609);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblFactura = new JLabel("FACTURA");
		lblFactura.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblFactura.setBounds(305, 31, 100, 32);
		contentPane.add(lblFactura);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(30, 125, 56, 16);
		contentPane.add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(305, 125, 56, 16);
		contentPane.add(lblApellido);
		
		JLabel lblCedula = new JLabel("Cedula");
		lblCedula.setBounds(30, 86, 56, 16);
		contentPane.add(lblCedula);
		
		JLabel lblDireccion = new JLabel("Direccion");
		lblDireccion.setBounds(30, 167, 56, 16);
		contentPane.add(lblDireccion);
		
		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setBounds(305, 167, 56, 16);
		contentPane.add(lblTelefono);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				 if(e.getKeyCode()==KeyEvent.VK_ENTER){
					 Controlador_Cliente c = new Controlador_Cliente();
					 c.validadorDeCedula(textField.getText());
					 
	                    JOptionPane.showMessageDialog(contentPane, "Has pulsado Enter");
	                }
			}
		});
		textField.setBounds(87, 83, 116, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(87, 122, 116, 22);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(373, 122, 116, 22);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(87, 164, 116, 22);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(373, 164, 116, 22);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setBounds(305, 76, 56, 16);
		contentPane.add(lblFecha);
		
		textField_5 = new JTextField();
		textField_5.setBounds(373, 76, 116, 22);
		textField_5.setText(fechaActual());
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 315, 639, 161);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Id", "Articulo", "PrecioUnitario", "Cantidad", "PrecioVenta", "Stock"
			}
		));
		table.getColumnModel().getColumn(3).setResizable(false);
		scrollPane.setViewportView(table);
		
		textField_6 = new JTextField();
		textField_6.setBounds(87, 221, 213, 22);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		JLabel lblBuscar = new JLabel("Buscar");
		lblBuscar.setBounds(30, 224, 56, 16);
		contentPane.add(lblBuscar);
		
		JLabel lblCantidad = new JLabel("Cantidad");
		lblCantidad.setBounds(402, 224, 56, 16);
		contentPane.add(lblCantidad);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				cargarArticulos();
			}

		private void cargarArticulos() {
				// TODO Auto-generated method stub
				
				Controlador_Articulo s = new Controlador_Articulo();
			
				int nom= Integer.parseInt(textField_6.getText());
				int art2 = Integer.parseInt(textField_7.getText());
			    ArrayList<Articulo> recibir = (ArrayList<Articulo>) s.buscar_Articulo(nom);
				for (int i = 0; i < recibir.size(); i++) {

					DefaultTableModel modelo = (DefaultTableModel) table.getModel();
					Object[] fila = new Object[6];
					
					String  d = recibir.get(i).getPrecio()+"";
					double dd = Double.parseDouble(d)*art2;
					String  f= "hola";
					//System.out.println("lllllllll"+dd);

					fila[0] = recibir.get(i).getId_articulo();
					fila[1] = recibir.get(i).getDescripcion();
					fila[2] = recibir.get(i).getPrecio();
					fila[3] = art2;
					fila[4] =dd;
					fila[5] = recibir.get(i).getStock();
					
					modelo.addRow(fila);
					table.setModel(modelo);
					
				}
				
			}
		});
		
		btnAgregar.setBounds(575, 220, 97, 25);
		contentPane.add(btnAgregar);
		
		JButton btnGenerarfactura = new JButton("GenerarFactura");
		btnGenerarfactura.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Controlador_Articulo f = new Controlador_Articulo();
				totalizar();
				for (int i = 0; i < table.getRowCount(); i++) {
					System.out.println(table.getValueAt(i, 0));
					String canti = table.getValueAt(i, 3)+"";
					String idAr= table.getValueAt(i, 0)+"";
					int cantidad = Integer.parseInt(canti);
					int idArticulo = Integer.parseInt(idAr);
					f.actualizar_stock(cantidad, idArticulo);
				}
				
			}
		});
		btnGenerarfactura.setBounds(543, 527, 129, 22);
		contentPane.add(btnGenerarfactura);
		
		JButton btnInsertar = new JButton("Insertar");
		btnInsertar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                    Cliente C = new Cliente ();
				
				C.setCedula(textField.getText());
				C.setNombre(textField_1.getText());
				C.setApellido(textField_2.getText());
				C.setDireccion(textField_3.getText());
				C.setTelefono(textField_4.getText());
				coc.ingresarCliente(C);
				limpiar();
			}
			
		});
		btnInsertar.setBounds(575, 38, 97, 25);
		contentPane.add(btnInsertar);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Cliente C =  coc.buscar_Cliente(textField.getText()); 
				textField_1.setText(C.getNombre());
				textField_2.setText(C.getApellido());
				textField_3.setText(C.getDireccion());
				textField_4.setText(C.getTelefono());
				
				
				
				
				
				
			}
			
		});
		btnBuscar.setBounds(575, 82, 97, 25);
		contentPane.add(btnBuscar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cliente C = new Cliente ();
				C.setCedula(textField.getText());
				coc.eliminar_cliente(textField.getText());
			}
		});
		btnEliminar.setBounds(575, 134, 97, 25);
		contentPane.add(btnEliminar);
		
		textField_7 = new JTextField();
		textField_7.setBounds(471, 221, 49, 22);
		contentPane.add(textField_7);
		textField_7.setColumns(10);
		
		subtotalT = new JTextField();
		subtotalT.setBounds(681, 419, 116, 22);
		contentPane.add(subtotalT);
		subtotalT.setColumns(10);
		
		ivaT = new JTextField();
		ivaT.setBounds(681, 454, 116, 22);
		contentPane.add(ivaT);
		ivaT.setColumns(10);
		
		descuentoT = new JTextField();
		descuentoT.setBounds(681, 489, 116, 22);
		contentPane.add(descuentoT);
		descuentoT.setColumns(10);
		
		totalT = new JTextField();
		totalT.setBounds(681, 527, 116, 22);
		contentPane.add(totalT);
		totalT.setColumns(10);
		
		JLabel lblPonElDescuento = new JLabel("pon el descuento");
		lblPonElDescuento.setBounds(567, 498, 116, 16);
		contentPane.add(lblPonElDescuento);
	}
	public void limpiar() {
		textField.setText("");
		textField_1.setText("");
		textField_2.setText("");
		textField_3.setText("");
		
		 
	}
	public static String fechaActual() {
		Date fecha = new Date();
		SimpleDateFormat formatoFecha = new SimpleDateFormat("YYYY-MM-dd");

		return formatoFecha.format(fecha);
	}
	public static void totalizar (){
		String s;
		int sto;
		double subtotal = 0;
		double p = 0;
		double descuento = 0;
		double subtotalDescuento = 0;
		double iva = 0;
		double total = 0;
		DecimalFormat decimales = new DecimalFormat("#.00");

		if (table.getRowCount() > 0) {
			for (int i = 0; i < table.getRowCount(); i++) {
				p = Double.parseDouble(table.getValueAt(i, 4).toString());

				// Double preFinal = ((p * 12) / 100);
				subtotal += p;
				subtotalT.setText(decimales.format(subtotal));

				double descontar = (subtotal * Double.parseDouble(descuentoT.getText())) / 100;
				double predescontado = subtotal - descontar;

				iva = (predescontado * 12) / 100;
				total = predescontado + iva;

				ivaT.setText(decimales.format(iva));
				totalT.setText(decimales.format(total));

			}
		}
	}
	
	
	
}