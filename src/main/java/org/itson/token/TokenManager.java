/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.token;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.itson.player.Player;
import org.itson.utils.Utils;

/**
 *
 * @author oscar
 */
public class TokenManager {

    private static TokenManager instance;
    private List<TokenComponent> tokensComponents;

    public TokenManager() {
        this.tokensComponents = new ArrayList<>();
    }

    public static TokenManager get() {
        if (TokenManager.instance == null) {
            TokenManager.instance = new TokenManager();
        }

        return TokenManager.instance;
    }

    public void generateTokens() throws IOException {
        for (int i = 0; i <= 6; i++) {
            for (int j = i; j <= 6; j++) {
                this.tokensComponents.add(new TokenComponent(i, j));
            }
        }

        if (this.tokensComponents.size() == 28) {
            System.out.println("Tokens was create.");
        } else {
            System.out.println("We can't create the tokens");
        }
    }

    public TokenView getRandomTokenView() {
        int index = Utils.generateRandomNumber(0, this.tokensComponents.size());

        return this.tokensComponents.get(index).getTokenView();
    }

    public List<TokenComponent> getTokensComponents() {
        return this.tokensComponents;
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

        for (TokenComponent token : player.getTokens()) {
            if (token.getToken() instanceof MuleToken nextToken) {
                biggestToken = this.compareTwoMuleTokens(prevToken, nextToken);
                prevToken = nextToken;
            }
        }

        return biggestToken;
    }

    private MuleToken compareTwoMuleTokens(MuleToken prevToken, MuleToken nextToken) {
        if (prevToken == null) {
            return nextToken;
        }
        if (nextToken == null) {
            return prevToken;
        }
        if (prevToken.getValue() >= nextToken.getValue()) {
            return prevToken;
        }
        return nextToken;
    }

    //Cambiar metodo a playerComponent
    public Token removeTokenPerThePlayer(List<Player> players, Token token) {
        for (Player player : players) {
            if (player.getTokens().remove(token)) {
                return token;
            }
        }

        return null;
    }
}
