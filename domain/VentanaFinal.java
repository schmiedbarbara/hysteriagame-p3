import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.io.File;

public class VentanaFinal extends JFrame {
	JButton[] botones;
	JFrame frame;
    


    public VentanaFinal(String titulo, String mensajeDeMovimientos) {
    	setTitle("Hysteria Game");
        JLabel mensajeGanador = new JLabel(mensajeDeMovimientos);
    	mensajeGanador.setFont(new Font("Arial", Font.BOLD, 24)); 
    	mensajeGanador.setForeground(Color.BLUE);
    	mensajeGanador.setHorizontalAlignment(SwingConstants.CENTER);
        ImageIcon icon = new ImageIcon(getClass().getResource("/domain/ventanaInicio.gif"));
        
        

        //JLabel para ubicar elementos
        JLabel backgroundLabel = new JLabel(icon);
        backgroundLabel.setLayout(new GridBagLayout());
        JPanel contentPanel = new JPanel(new GridBagLayout());
        contentPanel.setOpaque(false);
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        //Panel para mostrar los JLabel
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        
        //Inicialización del Título
        JLabel tituloGanaste = new JLabel(titulo);
        tituloGanaste.setFont(new Font("Arial", Font.BOLD, 50)); // Ajusta el tamaño de la fuente
        tituloGanaste.setForeground(Color.white); // Color de la letra para contraste
        tituloGanaste.setHorizontalAlignment(SwingConstants.CENTER);
        tituloGanaste.setVerticalAlignment(SwingConstants.CENTER);
        tituloGanaste.setOpaque(true);
        tituloGanaste.setBackground(new Color(0, 0, 0, 50));
        tituloGanaste.setPreferredSize(new Dimension(500, 110));
        
        //Grid para Ubicar los elementos en la Ventana
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(15, 15, 15, 15);
        gbc.gridx = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridy = 0;
        contentPanel.add(tituloGanaste,gbc);
        
        //Inicialización de Mensaje para los Movimientos utilizados
        JLabel mensajeLabel = new JLabel(mensajeDeMovimientos);
        mensajeLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        mensajeLabel.setForeground(Color.white);
        mensajeLabel.setOpaque(true);
        mensajeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        mensajeLabel.setBackground(new Color(0, 0, 0, 20));
        mensajeLabel.setPreferredSize(new Dimension(400, 45));
        gbc.gridy = 1;
        panel.add(mensajeLabel);
        contentPanel.add(mensajeLabel, gbc);

        

        //Ubicacion del Boton de Partida Nueva
		GridBagConstraints gbcPartidaNueva = new GridBagConstraints();
		gbcPartidaNueva.insets = new Insets(10, 10, 10, 10);
		gbcPartidaNueva.gridx = 0;
		gbcPartidaNueva.anchor = GridBagConstraints.CENTER;
		

		//Ubicacion del Boton de Cierre de Juego
		GridBagConstraints gbcCerrarJuego = new GridBagConstraints();
		gbcCerrarJuego.insets = new Insets(20, 20, 20, 20);
		gbcCerrarJuego.gridx = 0;
		gbcCerrarJuego.anchor = GridBagConstraints.CENTER;

        //Creación de Botón para Cerrar Juego
        JButton cerrarJuego = new JButton("Cerrar Juego");
        cerrarJuego.setFont(new Font("Arial", Font.BOLD,16));
        cerrarJuego.setPreferredSize(new Dimension(190, 40));
        cerrarJuego.addActionListener(e -> System.exit(0)); // Cerrar el juego
        panel.add(cerrarJuego, BorderLayout.SOUTH);

        //Creación de Botón para Iniciar nueva partida
        JButton iniciarNuevaPartida = new JButton ("Iniciar partida nueva");
        iniciarNuevaPartida.setFont(new Font("Arial", Font.BOLD, 16));
        iniciarNuevaPartida.setPreferredSize(new Dimension(190, 40));
        iniciarNuevaPartida.addActionListener(e -> reiniciarJuego());
        panel.add(iniciarNuevaPartida, BorderLayout.NORTH);
        
        
        
        //Agregamos los botones al Panel para que se visualicen 
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


