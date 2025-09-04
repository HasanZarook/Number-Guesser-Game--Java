/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Work;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author hinakhalid
 * @Edit by Hasan zarook (2021 CE 58)
 */
public class NumberGuesser {

    private int guesses = 10;
    private int warning = 4;
    private int guessedNo;
    private int[] alreadyTold = new int[10];
    private int position ;

    public void setAlreadyTold(int number) {
        // if the number is not in the array already add it
        alreadyTold[position] = number;
    }

    public Boolean isAlreadyTold(int number) {
        // if the number is already in told or not
        for(int i=0 ; i < position +1 ; i++){
            if(alreadyTold[i]==number){
                return true ;
            }
        }

        return false;
    }

    //****** complete the game using the unfinished functions ******//
    public void play() {

        /* few things to do here
        1. pick secret number and set guessed accordingly
        2. tell user the range of number guessed and total guesses and warnings
        3. ask user for guess check if guess is invalid or repeated user loses a warning and if no warning is left user loses a guess
        5. in case of valid guess check if the guess is equal or not to the guessed number and show appropiate message
        4. continue the game unless user wins or have consumed all guesses
         */
        position = 0;
        Random r = new Random();  //we need to choose between 0 to 1000 so it must not take 0 and 1000
        int Computer_num = r.nextInt(1000) + 1;  // 0 has left
        //i need to make condition to leave 1000
        if (Computer_num == 1000) {
            Computer_num = Computer_num + 1;
        }

        System.out.println("Welcome to the number guessing Game");
        System.out.println("I am thinking the number between 0-1000");
     //   System.out.printf("You have %d warnings left\n", warning);
      //  System.out.println("-------------");
     //   System.out.printf("You have %d guesses left\n", guesses);

        while (guesses != 0) {

            System.out.printf("You have %d warnings left\n", warning);
            System.out.printf("You have %d guesses left\n", guesses);
            System.out.println("Guessed numbers : ");
            for (int j = 0; j < position + 1; j++) {
                System.out.println(alreadyTold[j]);
            }
            Scanner input = new Scanner(System.in);
            System.out.println("Good luck!, Enter your guess : ");
            if (input.hasNextInt()) {
                guessedNo = input.nextInt();
                if (guessedNo == Computer_num) {
                    System.out.println("Hurray, you have guessed the number #CORRECTLY");
                } else if (guessedNo != Computer_num) {
                    boolean result = isAlreadyTold(guessedNo);
                    if (result == true) {
                        System.out.println("Warning!! You have already told this number or wrong character choose");
                        if (warning != 0) {
                            warning--;
                            //System.out.printf("You have %d warnings left\n", warning);
                           // System.out.printf("You have %d guesses left\n", guesses);
                            System.out.println("Choose valid number");
                        } else if (warning < 0) {
                            System.out.println("You don't have any warning\n You are going to lose the guess");

                            System.out.printf("You have %d guesses left", guesses);
                            guesses--;
                            if (guesses == 0) {
                                System.out.println("GAME OVER, you are unable to guess the number");
                            }


                        }
                    } else if (result == false) {



                            setAlreadyTold(guessedNo);
                            position++;
                            if (guessedNo > Computer_num) {

                                System.out.println("Number is greater");
                                if (guesses != 0){
                                    guesses --;
                                } else if (guesses == 0) {
                                    System.out.println("GAME OVER, you are unable to guess the number");

                                }

                            } else if (guessedNo < Computer_num) {
                                System.out.println("Number is smaller");
                                if (guesses != 0){
                                    guesses --;
                                } else if (guesses == 0) {
                                    System.out.println("GAME OVER, you are unable to guess the number");

                                }
                            }



                    }

                }
         /*   else {
                warning--;
                if (warning==0)
                {
                    System.out.println("GAME OVER!!! ");
                    System.out.println("you don't have warning");
                    System.out.println("The number which has choosed by computer is" + Computer_num);
                    break;
                }
                System.out.println("Invalid Input Enter between 0 to 1000");
            }

        }
        if (guesses == 0){
            System.out.println("You don't have enough guesses ,#YOU LOSE ");
            System.out.println("Secret number is"+Computer_num);
        } */


            }


        }
    }
    public static void main(String args[]) {
        NumberGuesser n = new NumberGuesser();
        n.play();
    }
}