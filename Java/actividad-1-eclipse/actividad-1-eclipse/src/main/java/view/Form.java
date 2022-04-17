package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import entity.PedidoBean;
import main.Utils;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;

public class Form extends JPanel {
	private JTextField txtNombreMedicamento;
	private JComboBox cmbBoxTipoMedicamento;
	private JTextField txtCantidadProducto;
	private final ButtonGroup groupDistribuidor = new ButtonGroup();
	private JCheckBox chckPrincipal;
	private JCheckBox chckSecundaria;

	/**
	 * Create the panel.
	 */
	public Form() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre del medicamento:");
		lblNewLabel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblNewLabel.setBounds(20, 22, 193, 13);
		add(lblNewLabel);
		
		txtNombreMedicamento = new JTextField();
		txtNombreMedicamento.setBounds(20, 45, 300, 19);
		add(txtNombreMedicamento);
		txtNombreMedicamento.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Tipo de medicamento:");
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(20, 74, 155, 13);
		add(lblNewLabel_1);
		
		cmbBoxTipoMedicamento = new JComboBox();
		cmbBoxTipoMedicamento.setModel(new DefaultComboBoxModel(new String[] {"Seleccione uno", "Analgésico", "Analéptico", "Anestésico", "Antiácido", "Antidepresivo", "Antibióticos"}));
		cmbBoxTipoMedicamento.setSelectedIndex(0);
		cmbBoxTipoMedicamento.setBounds(20, 97, 300, 21);
		add(cmbBoxTipoMedicamento);
		
		JLabel lblNewLabel_2 = new JLabel("Cantidad de producto:");
		lblNewLabel_2.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(20, 135, 300, 13);
		add(lblNewLabel_2);
		
		txtCantidadProducto = new JTextField();
		txtCantidadProducto.setBounds(20, 158, 300, 19);
		add(txtCantidadProducto);
		txtCantidadProducto.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Distribuidor a pedir:");
		lblNewLabel_3.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(20, 187, 300, 13);
		add(lblNewLabel_3);
		
		JRadioButton radioBtnCofarma = new JRadioButton("Cofarma");
		radioBtnCofarma.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		groupDistribuidor.add(radioBtnCofarma);
		radioBtnCofarma.setBounds(20, 206, 181, 21);
		add(radioBtnCofarma);
		
		JRadioButton radioBtnEmpsephar = new JRadioButton("Empsephar");
		radioBtnEmpsephar.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		groupDistribuidor.add(radioBtnEmpsephar);
		radioBtnEmpsephar.setBounds(20, 229, 155, 21);
		add(radioBtnEmpsephar);
		
		JRadioButton radioBtnCemefar = new JRadioButton("Cemefar");
		radioBtnCemefar.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		groupDistribuidor.add(radioBtnCemefar);
		radioBtnCemefar.setBounds(20, 252, 155, 21);
		add(radioBtnCemefar);
		
		JLabel lblNewLabel_3_1 = new JLabel("Sucursal que requiere el medicamento:");
		lblNewLabel_3_1.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblNewLabel_3_1.setBounds(20, 279, 300, 13);
		add(lblNewLabel_3_1);
		
		chckPrincipal = new JCheckBox("Principal");
		chckPrincipal.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		chckPrincipal.setBounds(20, 298, 300, 21);
		add(chckPrincipal);
		
		chckSecundaria = new JCheckBox("Secundaria");
		chckSecundaria.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		chckSecundaria.setBounds(20, 321, 300, 21);
		add(chckSecundaria);
		
		JButton btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtNombreMedicamento.setText("");
		        cmbBoxTipoMedicamento.setSelectedIndex(0);
		        groupDistribuidor.clearSelection();
		        txtCantidadProducto.setText("");
		        chckPrincipal.setSelected(false);
		        chckSecundaria.setSelected(false);
			}
		});
		btnBorrar.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		btnBorrar.setBounds(20, 363, 124, 21);
		add(btnBorrar);
		
		JButton btnAceptar = new JButton("Confirmar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				confirmarPedido(e);
			}
		});
		btnAceptar.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		btnAceptar.setBounds(196, 364, 124, 21);
		add(btnAceptar);

	}
	
	private List<String> validarInput() {
        List<String> mensajesError = new ArrayList<>();
        
        if (txtNombreMedicamento.getText().equals("")) {
            mensajesError.add("El nombre del medicamento esta vacio");
        }
        
        Pattern patron = Pattern.compile("^[a-zA-Z0-9 ]*$");
        Matcher verificar = patron.matcher(txtNombreMedicamento.getText());
        
        if (!verificar.matches()) {
            mensajesError.add("El nombre del medicamento solo debe contener caracteres alfanumericos");
        }
        
        if (cmbBoxTipoMedicamento.getSelectedIndex() == 0) {
            mensajesError.add("El tipo de medicamento no ha sido selecionado");
        }
        
        int cantidadPedido = Utils.tryParseInt(txtCantidadProducto.getText());
        if (cantidadPedido == -1) {
            mensajesError.add("La cantidad de medicamento no es un numero valido");
        }
        
        boolean noProveedorSeleccionado = true;
        for (Enumeration<AbstractButton> buttons = groupDistribuidor.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();
            
            if (button.isSelected()) {
                noProveedorSeleccionado = false;
            }
        }
        
        if (noProveedorSeleccionado) {
            mensajesError.add("No se ha seleccionado un proveedor");
        }
        
        if (!chckPrincipal.isSelected() && !chckSecundaria.isSelected()) {
            mensajesError.add("No se ha seleccionado una succursal");
        }
        
        return mensajesError;
    }
    
    private PedidoBean getPedido() {
        
        PedidoBean pedido = new PedidoBean();
        pedido.setNombreMedicamento(txtNombreMedicamento.getText());
        pedido.setTipoMedicamento(cmbBoxTipoMedicamento.getSelectedItem().toString());
        
        int cantidadMedNum = Integer.parseInt(txtCantidadProducto.getText());
        pedido.setCantidadMedicamento(cantidadMedNum);
        
        for (Enumeration<AbstractButton> buttons = groupDistribuidor.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();
            
            if (button.isSelected()) {
                pedido.setDistribuidor(button.getText());
            }
        }
        
        List<String> sucursalesSelecionadas = new ArrayList<>();
        if (chckPrincipal.isSelected())
            sucursalesSelecionadas.add("Calle de la Rosa n. 28");
        
        if (chckSecundaria.isSelected())
            sucursalesSelecionadas.add("Calle Alcazabilla n. 3");
        
        pedido.setSucursalesADistribuir(sucursalesSelecionadas);
        return pedido;
    }

    private void confirmarPedido(java.awt.event.ActionEvent evt) {
    	JFrame parentFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
        List<String> errores = validarInput();
        
        if (errores.isEmpty()) {
            JDialog modal = new ModalPedido(parentFrame, true, getPedido());
            modal.setVisible(true);
        } else {
            JDialog modalError = new ModalError(parentFrame, true, errores);
            modalError.setVisible(true);
        }
    }
}
