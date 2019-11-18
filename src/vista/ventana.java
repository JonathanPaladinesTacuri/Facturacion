package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Label;
import java.awt.Font;
import java.awt.TextField;
import java.awt.Button;
import java.awt.TextArea;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.sun.xml.internal.txw2.output.ResultFactory;

import controlador.Controlador_Cliente;
import modelo.Cliente;

import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.ResultSet;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JDesktopPane;


public class ventana extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel modalTableCliente;
	
	private TextField textField_1;
	
	private TextField textField ;
	
	private TextField textField_2 ;
	
	private TextField textField_3;
	
	private TextField textField_4;
	
	Controlador_Cliente cc = new Controlador_Cliente ();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ventana frame = new ventana();
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
	public ventana() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 847, 641);
		
		this.modalTableCliente = new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Cedula", "Nombre", "Apellido", "Direccion ", "Telefono"
					
					
					
				}
	);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		Label label = new Label("CLIENTE");
		label.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		
		Label label_1 = new Label("Apellido");
		
		Label label_2 = new Label("Nombre");
		
		Label label_3 = new Label("Cedula");
		
		Label label_4 = new Label("Direccion");
		
		Label label_5 = new Label("Telefono");
		
		this.textField_1 = new TextField();
		
		
		this.textField = new TextField();
		
		this.textField_2 = new TextField();
		
		this.textField_3 = new TextField();
		
		this.textField_4 = new TextField();
		
		this.textField_1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent event){
				if(event.getKeyCode() == 10 ){
					System.out.println("BUSCAR CLIENTE");
					
			//		Cliente cli = cc.buscar_Cliente(textField_1.getText());
					
					
					
				}
			}
		});
		
		Button button = new Button("Insertar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Cliente C = new Cliente ();
				
				C.setCedula(textField_1.getText());
				C.setNombre(textField.getText());
				C.setApellido(textField_2.getText());
				C.setDireccion(textField_3.getText());
				C.setTelefono(textField_4.getText());
				cc.ingresarCliente(C);
				limpiar();
			}
		});
		
		Button button_1 = new Button("Eliminar");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Cliente C = new Cliente ();
				C.setCedula(textField_1.getText());
				cc.eliminar_cliente(textField_1.getText());
			}
		});
		
		
		Button button_2 = new Button("Actualizar");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Cliente C = new Cliente ();
				
				C.setNombre(textField.getText());
				C.setApellido(textField_2.getText());
				C.setDireccion(textField_3.getText());
				C.setTelefono(textField_4.getText());
				
				cc.actualizar_Cliente(C,textField.getText());
			}
		});
		
		
		
		Button button_3 = new Button("Buscar");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Cliente C =  cc.buscar_Cliente(textField_1.getText()); 
				textField.setText(C.getNombre());
				textField_2.setText(C.getApellido());
				textField_3.setText(C.getDireccion());
				textField_4.setText(C.getTelefono());
				
				
				
				
				
				
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		
		JButton btnListar = new JButton("Listar");
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modalTableCliente.setRowCount(0);
				for (Cliente cli: cc.listar_Cliente()) {
					modalTableCliente.addRow(new String[] {
							cli.getCedula(), cli.getNombre(), cli.getApellido(), cli.getDireccion(), cli.getTelefono()
					 });
				}
				
				
				
				
			}
		});
		
		JDesktopPane desktopPane = new JDesktopPane();
		
		
		
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(711, Short.MAX_VALUE)
					.addComponent(btnListar)
					.addGap(45))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(349)
							.addComponent(label, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(33)
							.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
							.addGap(39)
							.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)
							.addGap(120)
							.addComponent(button, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(33)
							.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
							.addGap(36)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE)
							.addGap(120)
							.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(33)
							.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
							.addGap(36)
							.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(33)
							.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
							.addGap(36)
							.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)
							.addGap(123)
							.addComponent(button_2, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(33)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 517, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(label_5, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
									.addGap(36)
									.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)
									.addGap(123)
									.addComponent(button_3, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(desktopPane, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)))))
					.addContainerGap(269, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(42)
					.addComponent(label, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
					.addGap(44)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(label_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(button, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(16)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(label_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(19)
							.addComponent(button_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(2)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(label_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(12)
							.addComponent(label_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(12)
							.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(button_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(16)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(label_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(button_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(29)
							.addComponent(desktopPane, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(40)
							.addComponent(btnListar))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(21)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(66, Short.MAX_VALUE))
		);
		
		table = new JTable();
		table.setModel(this.modalTableCliente
				
		);
		scrollPane.setViewportView(table);
		contentPane.setLayout(gl_contentPane);
	}
	public void limpiar() {
		this.textField.setText("");
		this.textField_1.setText("");
		this.textField_2.setText("");
		this.textField_3.setText("");
		this.textField_4.setText("");
		 
	}
}
