/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.board;

import java.util.List;
import org.itson.token.Token;

/**
 *
 * @author icedo
 */
public class BoardController {

    private static BoardController instance;
    private Board board;

    private BoardController() {

    }

    public static BoardController get() {
        if (BoardController.instance == null) {
            BoardController.instance = new BoardController();
        }

        return BoardController.instance;
    }

    public void createBoard() {
        this.board = new Board();
        System.out.println("Board initialized in BoardController.");
    }

    public Board getBoard() {
        return this.board;
    }
    
    public void addTokenOnBoard(Token token) {
        if (this.board != null) {
            this.board.addToken(token);
        } else {
            throw new IllegalStateException("The board has not been created yet.");
        }
    }
    
    public List<Token> getTokens() {
        return this.board.getTokens();
    }
}
