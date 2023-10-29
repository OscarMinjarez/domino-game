/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.pit;



public class PitController {
    

   private static PitController instance;
    
    private PitController() {
        
    }
    
    public static PitController get() {
        if (PitController.instance == null) {
            PitController.instance = new PitController();
        }
        
        return PitController.instance;
    }
    
    public Pit createPit() {
        return new Pit();
    }

    
}
