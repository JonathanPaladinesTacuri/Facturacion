package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.TextField;

import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controlador.Controlador_Articulo;
import modelo.Articulo;
import modelo.Cliente;

import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

public class ventana_articulo extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private DefaultTableModel modalTableArticulo;
      Controlador_Articulo C = new Controlador_Articulo();
      private JTable table;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ventana_articulo frame = new ventana_articulo();
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
	public ventana_articulo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 708, 527);
		
				
				
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblArticulo = new JLabel("Articulo");
		lblArticulo.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblArticulo.setBounds(269, 41, 93, 19);
		contentPane.add(lblArticulo);
		
		JLabel lblId = new JLabel("Id");
		lblId.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblId.setBounds(39, 101, 56, 16);
		contentPane.add(lblId);
		
		JLabel lblNewLabel = new JLabel("Descripcion");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(39, 144, 102, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPrecio.setBounds(39, 184, 56, 16);
		contentPane.add(lblPrecio);
		
		JLabel lblStock = new JLabel("Stock");
		lblStock.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblStock.setBounds(39, 221, 56, 16);
		contentPane.add(lblStock);
		
		textField = new JTextField();
		textField.setBounds(74, 99, 116, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(153, 142, 116, 22);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(107, 182, 116, 22);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(107, 219, 116, 22);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		Button button = new Button("Insertar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		
		Articulo A = new Articulo ();	
		
		A.setId_articulo(Integer.parseInt(textField.getText()));
		A.setDescripcion(textField_1.getText());
		A.setPrecio(Double.parseDouble(textField_2.getText()));
		A.setStock(Integer.parseInt(textField_3.getText()));
		C.ingresarArticulo(A);
		limpiar();
				
			}
		});
		button.setBounds(341, 93, 79, 24);
		contentPane.add(button);
		
		Button button_1 = new Button("Eliminar");
		button_1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				Articulo A = new Articulo ();
				
				A.setId_articulo(Integer.parseInt(textField.getText()));
				C.eliminar_Articulo(Integer.parseInt(textField.getText()));
				
			}
		});
		button_1.setBounds(341, 144, 79, 24);
		contentPane.add(button_1);
	
		
		
		Button button_2 = new Button("Actualizar");
		button_2.addActionListener(new ActionListener() {
			
		
			public void actionPerformed(ActionEvent e) {
				
				Articulo A = new Articulo ();
				
			A.setId_articulo(Integer.parseInt(textField.getText()));
			A.setDescripcion(textField_1.getText());
			A.setPrecio(Double.parseDouble(textField_2.getText()));
			A.setStock(Integer.parseInt(textField_3.getText()));
			
			C.actualizar_Articulo(A, (Integer.parseInt(textField.getText())));
				
			}
		});
		button_2.setBounds(341, 201, 79, 24);
		contentPane.add(button_2);
		
		
		
		Button button_4 = new Button("Listar");
		button_4.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				modalTableArticulo.setRowCount(0);
				for (Articulo ar: C.listar_Articulo()) {
					System.out.println("dddd");
					modalTableArticulo.addRow(new String[] {
							
							Integer.toString(ar.getId_articulo()),
							ar.getDescripcion(),
							Double.toString(ar.getPrecio()),
							Integer.toString(ar.getStock())
						
							
					});
				
				}
				
			}

		});
		button_4.setBounds(578, 306, 79, 24);
		contentPane.add(button_4);
		
		Button Buscar = new Button("Buscar");
		
		Buscar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
               Articulo A = C.buscar_Articulo(Integer.parseInt(textField.getText()));
				
				textField_1.setText(A.getDescripcion());
				textField_2.setText((Double.toString(A.getPrecio())));
				textField_3.setText(Integer.toString(A.getStock()));
				
				
			}
			
		});
		Buscar.setBounds(341, 255, 79, 24);
		contentPane.add(Buscar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 306, 517, 176);
		contentPane.add(scrollPane);
		
		table = new JTable();
		modalTableArticulo = new DefaultTableModel(
				
			new Object[][] {
			},
			new String[] {
				"Id", "Descripcion", "Precio", "Stock"
			}
		);
		table.setModel(modalTableArticulo);
		scrollPane.setViewportView(table);
	}
	public void limpiar() {
		textField.setText("");
		textField_1.setText("");
		textField_2.setText("");
		textField_3.setText("");
		
		 
	}
}

