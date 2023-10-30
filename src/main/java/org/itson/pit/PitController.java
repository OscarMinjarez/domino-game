/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.pit;

import org.itson.token.Token;



public class PitController {
    

   private static PitController instance;
   private Pit pit;
   
    private PitController() {
        
    }
    
    public static PitController get() {
        if (PitController.instance == null) {
            PitController.instance = new PitController();
        }
        
        return PitController.instance;
    }
    
    public void saveTokensOnPits(Token[] tokens) {
        // Crear un pozo con los tokens proporcionados
        pit = new Pit(tokens);
        
       
    }

    public Pit getPit() {
        return pit;
    }
    
    
}
