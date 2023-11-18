/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package client;

import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author icedo
 */
public class Client {

    private static Client instance;
    private ClientConnection clientconnection;
    public static Client get() {
        if (instance == null) {
            instance = new Client();
        }

        return instance;
    }

    public Client() {
        Socket socket;
        try {
            socket = new Socket("localhost", 1001);
            this.clientconnection= new ClientConnection(socket);
            clientconnection.start();
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void sendServer(Object object) {
        this.clientconnection.sendServer(object);
    }

}
