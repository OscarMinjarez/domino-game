/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.token;

import java.io.IOException;

/**
 *
 * @author oscar
 */
public class TokenComponent {
    private TokenController tokenController;
    private TokenView tokenView;

    public TokenComponent(int value1, int value2) throws IOException {
        this.tokenController = new TokenController();
        this.tokenController.createToken(value1, value2);
    }

    public void rotateToken() {
        this.tokenController.rotateToken();
    }
    
    public Token getToken() {
        return this.tokenController.getToken();
    }

    public TokenController getTokenController() {
        return this.tokenController;
    }
    
    @Override
    public String toString() {
        return "TokenComponent{" + "tokenController=" + tokenController + ", tokenView=" + tokenView + '}';
    }
}
