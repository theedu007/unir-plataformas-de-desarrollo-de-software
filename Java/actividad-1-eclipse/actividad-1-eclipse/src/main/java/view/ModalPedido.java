package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entity.PedidoBean;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ModalPedido extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JLabel infoMed;
	private JLabel infoDireccion;
	
	public ModalPedido(java.awt.Frame parent, boolean modal, PedidoBean pedido) {
		super(parent, modal);
		setBounds(100, 100, 359, 185);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		infoMed = new JLabel("New label");
		infoMed.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		infoMed.setBounds(10, 23, 266, 13);
		contentPanel.add(infoMed);
		
		infoDireccion = new JLabel("New label");
		infoDireccion.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		infoDireccion.setBounds(10, 46, 266, 49);
		contentPanel.add(infoDireccion);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cerrar();
			}
		});
		btnCancelar.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		btnCancelar.setBounds(20, 105, 133, 21);
		contentPanel.add(btnCancelar);
		
		JButton btnEnviar = new JButton("Enviar Pedido");
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				enviar();
			}
		});
		btnEnviar.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		btnEnviar.setBounds(176, 105, 133, 21);
		contentPanel.add(btnEnviar);
        
        setTitle("Pedido al distribuidor " + pedido.getDistribuidor());
        
        infoMed.setText(pedido.getCantidadMedicamento() + " unidades del " 
                + pedido.getTipoMedicamento() + " " 
                + pedido.getNombreMedicamento());
        
        StringBuilder mensajeSucursales = new StringBuilder("<html>");
        List<String> sucursales = pedido.getSucursalesADistribuir();
        for (int i = 0; i < sucursales.size(); i++) {
            if (i > 0) {
                mensajeSucursales.append(" <br> y para la situada en ").append(sucursales.get(i));
            } else {
                mensajeSucursales.append("Para la farmacia situada en ").append(sucursales.get(i));
            }
        }
        mensajeSucursales.append("</html>");
        infoDireccion.setText(mensajeSucursales.toString());
    }

	private void cerrar() {
		this.dispose();
	}
	
	private void enviar() {
		System.out.println("Pedido enviado");
        this.dispose();
	}
}
