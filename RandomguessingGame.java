package jouneyProjects;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class RandomguessingGame {
    public static void main(String[] args){
        randomNumberGuessingGame();
        
    }

    public static void randomNumberGuessingGame(){
        Scanner scan = new Scanner(System.in);
        Random random = new Random();
        ArrayList<Integer> guesses = new ArrayList<>();

        int userGuess;
        int target;
        target  = random.nextInt(0, 101);
        boolean won = false;
    
        while(true){
            System.out.print("Enter your guess(0 to 100) -1 to exit:");
            if (scan.hasNextInt()){
                userGuess = scan.nextInt();
                if (userGuess == -1){
                break;
                }
                if(userGuess < 0 || userGuess > 100){
                    System.out.println("Enter a number within (0-100)!");
                    continue;
                }
                    
                guesses.add(userGuess);
                if(userGuess == target){
                    System.out.println();
                    won = true;
                    break;
                }
                else if(userGuess < target){
                        System.out.println("Try a LARGER number:)");
                }
                else if (userGuess > target){
                        System.out.println("Try a SMALLER number:)");
                }

            }else{
                String junk = scan.next();
                System.out.println(junk);
                System.out.println("That's not a number! Try again.");
                continue;
            }
        }
            

        if(won){
            System.out.println();
            if(guesses.size()== 1){
                System.out.println("You got it right in 1 try");
            }else{
                System.out.printf("You got it right in %d tries\n",guesses.size());
            }
            System.out.println("YOUR GUESSES WERE:");
            for (int guess : guesses){
                System.out.print(guess + " ");
        }
        }else{
            System.out.println("You quit?🤦Why would you quit when you were so close! I guess winning isn't for everybody😭");
        }

        scan.close();
    }
    
}
