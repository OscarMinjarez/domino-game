/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.board;

/**
 *
 * @author icedo
 */
public class BoardController {
    private static BoardController instance;
    
    private BoardController(){
        
    }
    
    public static BoardController get() {
        if (BoardController.instance == null) {
            BoardController.instance = new BoardController();
        }
        
        return BoardController.instance;
    }
    
    public Board createBoard(){
        return new Board();
    }
}
