package org.example.AssignmentMod1;

//import java.util.Random;
import java.util.Scanner;

public class Assi2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int winningScore = 50;
        int pla1scr = 0;
        int pla2scr = 0;


        int currPly = 1;
        boolean won = false;

        while (!won) {

            int dice = sc.nextInt(7) ;
            if (currPly == 1) {
                pla1scr += dice;
                System.out.println("Player 1 dice a " + dice + " and their total score is now " + pla1scr);

                if (wonGame(pla1scr,winningScore)) {
                    won = true;
                    System.out.println("Player 1 wins with a score of " + pla1scr + "!");
                } else {
                    currPly = 2;
                }
            } else {
                pla2scr += dice;
                System.out.println("Player 2 dice a " + dice + " and their total score is now " + pla2scr);
                if (wonGame(pla2scr,winningScore)) {
                    won = true;
                    System.out.println("Player 2 wins with a score of " + pla2scr + "!");
                } else {
                    currPly = 1; // Switch to player 1
                }
            }
        }
    }
    public static boolean wonGame(int pla,int win){
        if (pla>=win){
            return true;
        }
        return false;
    }
}
