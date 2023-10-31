/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.engine;

import org.itson.board.BoardView;
import org.itson.token.TokenView;

/**
 *
 * @author luis-
 */
public class ViewController {
    
    public ViewController(){
        
    }
    
    public static BoardView getBoardView(){
        //return BoardView
        return new BoardView();
    }
    
    public static TokenView getTokenView(){
        //return TokenView();
        return new TokenView();
    }
    
}
