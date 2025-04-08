import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class VentanaInicio extends JFrame {
	
	public VentanaInicio() {

        //Inicialización VentanaInicio
		setTitle("Hysteria Game");
		setSize(600,600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		ImageIcon icon = new ImageIcon(getClass().getResource("/domain/ventanaInicio.gif"));

        
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
        
        
       
        //Configuracion del Titulo
        JLabel titulo = new JLabel("HYSTERIA GAME");
        titulo.setFont(new Font("Arial", Font.BOLD, 60)); 
        titulo.setForeground(Color.white); 
        titulo.setPreferredSize(new Dimension(500, 70));
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        titulo.setVerticalAlignment(SwingConstants.CENTER);
        titulo.setOpaque(true);
        titulo.setBackground(new Color(0, 0, 0, 0)); 
        gbc.gridy = 0; 
        contentPanel.add(titulo, gbc);
        
        // Inicialización de Boton
        JButton iniciarJuegoBoton = new JButton("Iniciar Juego");
        iniciarJuegoBoton.setPreferredSize(new Dimension(190, 50));
        iniciarJuegoBoton.setRolloverEnabled(true); //Cursor ilumina boton
        iniciarJuegoBoton.addActionListener((ActionListener) new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                iniciarJuego();
            }
        });
        
        //Coloca el título en la segunda fila de la Cuadrícula
        gbc.gridy = 1; 
        contentPanel.add(iniciarJuegoBoton,gbc);

        // Agrega el Panel de Contenido para ser visualizado en el Frame
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


