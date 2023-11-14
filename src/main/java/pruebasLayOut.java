
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import org.itson.engine.ControllerFactory;
import org.itson.token.Token;
import org.itson.token.Token.Face;
import org.itson.token.TokenController;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author luis-
 */
public class pruebasLayOut extends JFrame {

    public pruebasLayOut() throws IOException {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLayout(new GridLayout(4, 5, 10, 10));

        // Crear una lista de tokens con valores aleatorios
        List<Token> tokens = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 20; i++) { 
            int value1 = random.nextInt(7);
            int value2 = random.nextInt(7);

            Token token = new Token(value1, value2);
            token.setFaceValues(value1, value2);
            tokens.add(token);
            System.out.println(token);
        }

        // Mostrar los tokens en una cuadrícula
        for (Token token : tokens) {
            add(createTokenPanel(token));
        }

        setVisible(true);
    }

    private JPanel createTokenPanel(Token token) {
        JPanel tokenPanel = new JPanel();

        Token.Face[] faces = token.getFaces();
        for (Token.Face face : faces) {
            JLabel label = new JLabel(new ImageIcon(face.getImage()));
            tokenPanel.add(label);
        }

        return tokenPanel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                new pruebasLayOut();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

}
