/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.pit;

import java.util.ArrayList;
import java.util.List;
import org.itson.token.TokenComponent;
import org.itson.utils.Utils;

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

    public void saveTokensOnPits(List<TokenComponent> tokens) {
        this.pit.setTokens(tokens);
    }

    public void createPit() {
        this.pit = new Pit();
    }

    public Pit getPit() {
        return this.pit;
    }

    public void setTokens(List<TokenComponent> tokens) {
        this.pit.setTokens(tokens);
    }

    public List<TokenComponent> getTokens() {
        return this.pit.getTokens();
    }

    public TokenComponent getRandomToken() {
        return this.pit.getTokens().remove(Utils.generateRandomNumber(0, this.pit.getTokensQuantity()));
    }

    public List<TokenComponent> getTokens(int quantity) {
        List<TokenComponent> tokens = new ArrayList<>();

        for (int j = 0; j < quantity; j++) {
            int randomIndex = Utils.generateRandomNumber(0, this.pit.getTokensQuantity());
            tokens.add(this.pit.removeToken(randomIndex));
        }

        return tokens;
    }
}
