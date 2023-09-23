package org.itson.model.domain;

/**
 *
 * @author arace
 */
public class Game {

    private Board board;
    private Token tokens[];

    public Game() {
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public Token[] getTokens() {
        return tokens;
    }

    public void setTokens(Token[] tokens) {
        this.tokens = tokens;
    }

    public Game(Board board, Token[] tokens) {
        this.board = board;
        this.tokens = tokens;
    }

}
