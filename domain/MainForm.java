import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToolBar;

public class MainForm {
    private JFrame frame;
    private HysteriaGame game;
    private JButton[] botones;
    private JLabel turnosLabel;
    private JLabel recordLabel;
    
    
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                	VentanaInicio ventanaInicio = new VentanaInicio();
                    ventanaInicio.setVisible(true);
                    
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public MainForm() {
        game = new HysteriaGame();
        inicializar();
    }

    public void inicializar() {

        //Inicialización de Ventana Principal
        frame = new JFrame();
        frame.setTitle("Hysteria Game");
        frame.setBounds(100, 100, 600, 600);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new BorderLayout());

        //Inicialización de Barra 
        JToolBar barra = new JToolBar();
        turnosLabel = new JLabel("Turnos: 0");
        recordLabel = new JLabel("Récord: -");
        barra.add(turnosLabel);
        barra.add(recordLabel);
        frame.getContentPane().add(barra, BorderLayout.NORTH);


        //Inicialización de Panel
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 5, 1, 1));
        frame.getContentPane().add(panel, BorderLayout.CENTER);
        
        
        //Inicialización de botones de la Grilla
        botones = new JButton[25];
        for (int i = 0; i < 25; i++) {
            JButton boton = new JButton();
            boton.setBackground(Color.DARK_GRAY);
            boton.setOpaque(true);
            boton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
            boton.setFocusPainted(false);
            final int nodo = i;

            //Capta cuando un botón es presionado
            boton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    game.cambiarColor(nodo);
                    actualizarBoton(boton, nodo);
                    frame.revalidate();
                    frame.repaint();

                    Set<Integer> vecinos = game.obtenerVecinos(nodo);
                    for (int vecino : vecinos) {
                        actualizarBoton(botones[vecino], vecino);
                    }
                    actualizarTurnos();
                    
                    frame.revalidate();
                    frame.repaint();
         
                    //Verifica que ganes y dirige a la Ventana Final
                    if (game.ganaste(game.obtenerColores(), 5)) {
                        game.actualizarRecord();
                        VentanaFinal ventanaFinal = new VentanaFinal(
                        "<html><div style='text-align: center;'>★ GANASTE<br>HYSTERIA GAME ★</div></html>",
                        "¡Has utilizado " + (game.getTurnos()) + " movimientos para lograrlo!"
                        );
                        ventanaFinal.setVisible(true);
                        frame.setVisible(false); 
                        ventanaFinal.setVisible(true);
                    } 
                }
            });
            botones[i] = boton;
            panel.add(boton);   
        }
        frame.setVisible(true);
    }

    private void actualizarTurnos() {
        turnosLabel.setText("Turnos: " + game.getTurnos());
        recordLabel.setText("Récord: " + (game.getRecord() == Integer.MAX_VALUE ? "-" : game.getRecord()));
    }

    public void reiniciarJuego() {
        game = new HysteriaGame();
        for (int i = 0; i < botones.length; i++) {
            botones[i].setBackground(Color.DARK_GRAY);
        }
        actualizarTurnos();
    }
    
    
    private void actualizarBoton(JButton boton, int nodo) {
        int colorId = game.darColor(nodo);
        Color color;

        switch (colorId) {
            case 1:
                color = Color.RED;
                break;
            case 2:
                color = Color.GREEN;
                break;
            case 3:
                color = Color.BLUE;
                break;
            case 4:
                color = Color.YELLOW;
                break;
            case 5:
                color = Color.WHITE;
                break;
            case 6:
                color = Color.MAGENTA;
                break;
            default:
                color = Color.DARK_GRAY;
        }

        boton.setBackground(color);
    } }
