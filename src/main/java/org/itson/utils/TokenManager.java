/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.utils;

import java.awt.MediaTracker;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import javax.swing.ImageIcon;
import org.itson.model.domain.MuleToken;
import org.itson.model.domain.NormalToken;
import org.itson.model.domain.Token;
import org.itson.view.Sprite;

public class TokenManager {

    private final Sprite sprite;
    private final Set<String> usedTokenNames;
    private Thread generationThread; // Hilo para la generación de tokens
    private boolean generationFinished; // Bandera para controlar si la generación ha terminado

    public TokenManager(Sprite sprite) {
        this.sprite = sprite;
        this.usedTokenNames = new HashSet<>();
        this.generationThread = null;
        this.generationFinished = false;
    }

    public void startTokenGeneration() {
        if (generationThread == null) {
            generationThread = new Thread(() -> {
                generateTokens();
            });
            generationThread.start();
        }
    }

    public void stopTokenGeneration() {
        if (generationThread != null) {
            generationThread.interrupt(); // Interrumpir el hilo de generación
            generationThread = null;
        }
    }

    private void generateTokens() {
        while (!generationFinished) {
            Token token = generateRandomToken();
            if (token == null) {
                // Todos los tokens posibles han sido generados
                generationFinished = true;
                break;
            }
        }
    }

    public Token generateRandomToken() {
    Random random = new Random();

    // Genera tokens hasta que todos los valores posibles se hayan utilizado
    while (usedTokenNames.size() < 7 * 7) { // 7 posibles valores en cada lado
        int side2 = random.nextInt(7); // Valores posibles: 0 a 6
        int side1 = random.nextInt(side2 + 1); // Genera side1 menor o igual que side2

        // Verifica si el token ya ha sido utilizado
        String tokenKey = side1 + "-" + side2;
        if (!usedTokenNames.contains(tokenKey)) {
            Token token;
            if (side1 == side2) {
                // Crea un MuleToken con el sprite generado
                token = new MuleToken(side1, generateTokenSprite(side1, side2));
            } else {
                // Crea un NormalToken con el sprite generado
                token = new NormalToken(side1, side2, generateTokenSprite(side1, side2));
            }

            usedTokenNames.add(tokenKey);
            System.out.println("Token generado - Lado 1: " + side1 + ", Lado 2: " + side2);

            return token; // Devuelve el token generado
        }
    }
    return null; // Si no se generó ningún token (todos los valores utilizados)
}

private Sprite generateTokenSprite(int side1, int side2) {
    // Construye el nombre del archivo de imagen en función de los valores de los lados
    String spriteFilePath = "src/main/java/imagenes/" + side1 + "-" + side2 + ".png";

    // Crea un nuevo ImageIcon para obtener las dimensiones de la imagen
    ImageIcon imageIcon = new ImageIcon(spriteFilePath);

    // Verifica si la imagen se carga correctamente
    if (imageIcon.getImageLoadStatus() == MediaTracker.COMPLETE) {
        System.out.println("Imagen cargada correctamente: " + spriteFilePath);
    } else {
        System.err.println("Error al cargar la imagen: " + spriteFilePath);
    }

    // Obtiene el ancho y el alto de la imagen real
    int imageWidth = imageIcon.getIconWidth();
    int imageHeight = imageIcon.getIconHeight();

    // Crea un nuevo Sprite con el ancho y el alto según las dimensiones de la imagen real
    return new Sprite(spriteFilePath, imageWidth, imageHeight);
}

public void loadTokenImage(Token token) {
    int side1 = token.getSide1();
    int side2 = token.getSide2();

    // Utiliza generateTokenSprite para obtener el Sprite
    Sprite tokenSprite = generateTokenSprite(side1, side2);

    // Verifica si el Sprite se creó correctamente
    if (tokenSprite.isImageLoaded()) {
        // Establece el nuevo Sprite en el Token
        token.setSprite(tokenSprite);
    } else {
        // Maneja el error de carga de imagen aquí
        System.err.println("Error al cargar la imagen para el token: ");
    }
}
   
}