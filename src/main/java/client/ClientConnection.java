/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.itson.game.GameController;


/**
 *
 * @author icedo
 */
public class ClientConnection extends Thread {
    private Socket socket;
    private ObjectOutputStream output;
    private ObjectInputStream input;

    public ClientConnection(Socket socket) {
        this.socket = socket;
        
        try {
            output=new ObjectOutputStream(this.socket.getOutputStream());
            input= new ObjectInputStream(this.socket.getInputStream());
        } catch (IOException ex) {
            Logger.getLogger(ClientConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    public void sendServer(Object object){
        try {
            output.writeObject(object);
            output.flush();

        } catch (IOException ex) {
            Logger.getLogger(ClientConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void run() {
        
            try {
                while(true){
                Object object = input.readObject();
                if(object instanceof GameController){
                    GameController gameController = (GameController) object;
                    //Aqui tengo que actualizar el gameController que tengo por el que acabo de recibir
                    //Actualizar vista
                }
                }
            } catch (IOException ex) {
                Logger.getLogger(ClientConnection.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ClientConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        
    }
    
}
