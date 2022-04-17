package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.List;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;

public class ModalError extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JLabel lblNewLabel;

	public ModalError(java.awt.Frame parent, boolean modal, List<String> mensajesError) {
        super(parent, modal);
        setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		lblNewLabel = new JLabel("New label");
		lblNewLabel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblNewLabel.setBounds(10, 10, 416, 191);
		contentPanel.add(lblNewLabel);
        
        setTitle("Error en el formulario");
        setMensaje(mensajesError);
    }
	
	 public void setMensaje(List<String> mensajes) {
	        StringBuilder mensajeFinal = new StringBuilder("<html>");
	        mensajeFinal.append("<p>Por favor corrija los siguientes errores:</p>");
	        
	        if (!mensajes.isEmpty()) {
	            mensajeFinal.append("<ul>");
	            for (String mensaje: mensajes) {
	                mensajeFinal.append("<li>").append(mensaje).append("</li>");
	            }
	            mensajeFinal.append("</ul>");
	        }
	        
	        mensajeFinal.append("</html>");
	        
	        lblNewLabel.setText(mensajeFinal.toString());
	    }

}
