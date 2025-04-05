import javax.swing.*;
import java.awt.*;
import java.io.File;

public class VentanaFinal extends JFrame {
	JButton[] botones;
	JFrame frame;

    public VentanaFinal(String mensaje) {
    	JLabel mensajeGanador = new JLabel(mensaje);
    	mensajeGanador.setFont(new Font("Arial", Font.BOLD, 21)); 
    	mensajeGanador.setForeground(Color.BLUE);
    	mensajeGanador.setHorizontalAlignment(SwingConstants.CENTER);
    	
    	
    	//Generar imagen y ubicarla en los elementos
    	String workingDir = System.getProperty("user.dir");
		String imagePath = workingDir + File.separator + "domain" + File.separator + "ventanaFinal.jpg";
        ImageIcon icon = new ImageIcon(imagePath);
        
        //JLabel para ubicar elementos
        JLabel backgroundLabel = new JLabel(icon);
        backgroundLabel.setLayout(new GridBagLayout());
        JPanel contentPanel = new JPanel(new GridBagLayout());
        contentPanel.setOpaque(false);
        
        
        //Ubicacion Boton Partida Nueva
		GridBagConstraints gbcPartidaNueva = new GridBagConstraints();
		gbcPartidaNueva.insets = new Insets(10, 10, 10, 10);
		gbcPartidaNueva.gridx = 0;
		gbcPartidaNueva.anchor = GridBagConstraints.CENTER;
		
		//Ubicacion Boton Cierre de Juego
		GridBagConstraints gbcCerrarJuego = new GridBagConstraints();
		gbcCerrarJuego.insets = new Insets(20, 20, 20, 20);
		gbcCerrarJuego.gridx = 0;
		gbcCerrarJuego.anchor = GridBagConstraints.CENTER;
    	
    	
     
        
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        
        //OJO
        JLabel tituloGanaste = new JLabel(mensaje);
        tituloGanaste.setFont(new Font("Arial", Font.BOLD, 24)); // Ajusta el tamaño de la fuente
        tituloGanaste.setForeground(Color.WHITE); // Color de la letra para contraste
        tituloGanaste.setPreferredSize(new Dimension(480, 60));
        tituloGanaste.setHorizontalAlignment(SwingConstants.CENTER);
        tituloGanaste.setVerticalAlignment(SwingConstants.CENTER);
        tituloGanaste.setOpaque(true);
        tituloGanaste.setBackground(new Color(0, 0, 0, 150)); // Fondo semi-transparente para mejor visibilidad

        //gbc.gridy = 0;
        contentPanel.add(tituloGanaste);
        
       

        JLabel mensajeLabel = new JLabel(mensaje, SwingConstants.CENTER);
        panel.add(mensajeLabel, BorderLayout.CENTER);

        JButton cerrarJuego = new JButton("Cerrar Juego");
        cerrarJuego.addActionListener(e -> System.exit(0)); // Cerrar el juego
        panel.add(cerrarJuego, BorderLayout.SOUTH);
        
        JButton iniciarNuevaPartida = new JButton ("Iniciar partida nueva");
        iniciarNuevaPartida.addActionListener(e -> reiniciarJuego());
        panel.add(iniciarNuevaPartida, BorderLayout.NORTH);
        
        
        
        //gbc.gridy = 1;
        contentPanel.add(iniciarNuevaPartida, gbcPartidaNueva);
        contentPanel.add(cerrarJuego, gbcCerrarJuego);
        
        backgroundLabel.setBounds(0, 0, 600, 600);
        
		
        

        add(panel);
        panel.add(mensajeGanador);
        backgroundLabel.add(contentPanel);
        setContentPane(backgroundLabel);
        
        
        
        setVisible(true);
       
    }
    
public void reiniciarJuego() {
	VentanaInicio ventanaInicio = new VentanaInicio();
    ventanaInicio.setVisible(true);
    this.setVisible(false);
    
	
    	for (int i = 0; i < botones.length; i++) {
            botones[i].setBackground(Color.DARK_GRAY);
        }
    }
}

