/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.token;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.itson.player.Player;

/**
 *
 * @author oscar
 */
public class TokenManager {
    private static TokenManager instance;
    private List<TokenComponent> tokensComponents;
    
    private TokenManager() {
        
    }
    
    public static TokenManager get() {
        if (TokenManager.instance == null) {
            TokenManager.instance = new TokenManager();
        }
        
        return TokenManager.instance;
    }
    
    public List<TokenComponent> generateTokens() throws IOException {
        List<TokenComponent> tokens = new ArrayList<>();

        for (int i = 0; i <= 6; i++) {
            for (int j = i; j <= 6; j++) {
                tokens.add(new TokenComponent(i, j));
            }
        }

        if (tokens.size() == 28) {
            System.out.println("Tokens was create.");
        } else {
            System.out.println("We can't create the tokens");
        }

        return tokens;
    }
    
    public MuleToken getBiggestMuleToken(List<MuleToken> muleTokens) {
        MuleToken biggestToken = null;
        MuleToken prevToken = null;
        
        for (MuleToken muleToken : muleTokens) {
            MuleToken nextToken = muleToken;
            biggestToken = this.compareTwoMuleTokens(prevToken, nextToken);
            prevToken = nextToken;
        }
        
        return biggestToken;
    }
    
    public MuleToken getBiggestMuleTokenPerPlayer(Player player) {
        MuleToken biggestToken = null;
        MuleToken prevToken = null;

        for (Token token : player.getTokens()) {
            if (token instanceof MuleToken nextToken) {
                biggestToken = this.compareTwoMuleTokens(prevToken, nextToken);
                prevToken = nextToken;
            }
        }

        return biggestToken;
    }

    private MuleToken compareTwoMuleTokens(MuleToken prevToken, MuleToken nextToken) {
        if (prevToken == null) return nextToken;
        if (nextToken == null) return prevToken;
        if (prevToken.getValue() >= nextToken.getValue()) return prevToken;
        return nextToken;
    }
    
    public Token removeTokenPerThePlayer(List<Player> players, Token token) {
        for (Player player : players) {
            if (player.getTokens().remove(token)) {
                return token;
            }
        }
        
        return null;
    }
}