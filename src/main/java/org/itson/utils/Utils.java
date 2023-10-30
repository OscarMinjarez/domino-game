/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.utils;

import java.util.Random;

/**
 *
 * @author oscar
 */
public class Utils {
    public static int generateRandomNumber(int min, int max) {
        if (min > max) {
            throw new IllegalArgumentException("The min value can't be greater than the max value.");
        }

        Random random = new Random();
        return (int) Math.floor(random.nextDouble() * (max - min) + min);
    }
}
