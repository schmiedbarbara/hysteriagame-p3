import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class VentanaInicio extends JFrame {
	private JButton iniciarJuegoBTN;
	
	//Constructor
	public VentanaInicio() {
		setTitle("HysteriaGame");
		setSize(600,600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		//Obtenemos imagen
		String workingDir = System.getProperty("user.dir");
		String imagePath = workingDir + File.separator + "domain" + File.separator + "ventanaInicio.jpg";
        	ImageIcon icon = new ImageIcon(imagePath);
        
        
        //Posicionamiento de la imagen en el JLabel
        	JLabel backgroundLabel = new JLabel(icon);
       	 	backgroundLabel.setLayout(new GridBagLayout());
        	JPanel contentPanel = new JPanel(new GridBagLayout());
        	contentPanel.setOpaque(false);
        
        //Alineacion de los elementos
        	GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(10, 10, 10, 10);
        	gbc.gridx = 0;
        	gbc.anchor = GridBagConstraints.CENTER;
        
        
       
        //Configuracion Texto
        	JLabel titulo = new JLabel("HYSTERIA GAME");
       	 	titulo.setFont(new Font("Arial", Font.BOLD, 24)); // Ajusta el tamaño de la fuente
        	titulo.setForeground(Color.WHITE); // Color de la letra para contraste
        	titulo.setPreferredSize(new Dimension(480, 60));
        	titulo.setHorizontalAlignment(SwingConstants.CENTER);
        	titulo.setVerticalAlignment(SwingConstants.CENTER);
        	titulo.setOpaque(true);
        	titulo.setBackground(new Color(0, 0, 0, 150)); // Fondo semi-transparente para mejor visibilidad

        gbc.gridy = 0; //posicion 0
        contentPanel.add(titulo, gbc);
        
     // Botón Iniciar Juego
        JButton iniciarJuegoBoton = new JButton("Iniciar Juego");
        iniciarJuegoBoton.setPreferredSize(new Dimension(200, 50));
        iniciarJuegoBoton.setRolloverEnabled(true); //Cursor ilumina boton
        iniciarJuegoBoton.addActionListener((ActionListener) new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                iniciarJuego();
            }
        });
        
        gbc.gridy = 1; //elemento colocado en segunda fila de la cuadricula
        //contentPanel.add(iniciarJuegoBTN, gbc);
        contentPanel.add(iniciarJuegoBoton,gbc);

        // Agregar el panel de contenido al frame
        backgroundLabel.add(contentPanel);
        setContentPane(backgroundLabel);
        
        
        setVisible(true);
    }

	
private void iniciarJuego() {
    //Cierra ventana de inicio
    this.setVisible(false);
    MainForm juego = new MainForm();
    
}


}


