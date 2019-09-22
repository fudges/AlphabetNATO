package com.alphabetNATO;

import java.time.Duration;
import java.time.Instant;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        /*
        Part I: the basic game
        When you start a game, the program shows you a random letter from the alphabet
        There is a textbox for you to type in the correct phonetic word for that letter, and press enter.
        if you get it right it goes hooray!and takes you to a new letter
        if you get it wrong it quickly shows you the correct answer before moving to a new letter
        when a round is complete it shows your score (you can decide the length of a round).

        Part II: test for speed
        You're not truly trained in the phonetic alphabet until you have instantaneous recall.
        So don't count an answer correct unless the user types in the correct answer quickly enough.
        I think I set mine to something like 2-3 seconds or something like that.

        Part III: close counts in horseshoes, hand grenades, and this game
        The point is to know the phonetic word that matches the letter, not to be an excellent typist.
        If the user makes a spelling mistake, but it's obvious what word they were going for, that should count right?
        So, implement the Levenshtein distance algorithm so that if the user gets one or two letters wrong, their answer will still count.
        Improve it further by also implementing Soundex

        Part IIII: add multithreading so you can do different stuff at the same time
        Now sure how this would work, but maybe while waiting for you to type an answer it shows different animations or plays noises

        */

        //Opening graphics
        try {
            System.out.println("#############################################");
            System.out.println("####   LEARN THE NATO PHONETIC ALPHABET  ####");
            System.out.println("#############################################");
            Thread.sleep(250);
            System.out.println();
            Thread.sleep(500);
            System.out.println("Are you ready?");
            Thread.sleep(500);
            System.out.println();
            Thread.sleep(1000);
            System.out.println("Starting in 3...");
            Thread.sleep(1000);
            System.out.println("Starting in 2...");
            Thread.sleep(1000);
            System.out.println("Starting in 1...");
            Thread.sleep(1000);
            System.out.println("Let's go!!");
            Thread.sleep(1000);
            System.out.println();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //Variables - change settings here
        NatoAlphabetList list = new NatoAlphabetList();
        Scanner scanner = new Scanner(System.in);
        int total = list.getNatoalphabet().size();
        int score = 0;
        double timer = 5.0;


        //Main game logic here
        while (list.getNatoalphabet().size() > 0){
            Object quizItem = list.getRandom();
            Instant start = Instant.now();
            System.out.println();
            System.out.println("Next item:  " + quizItem);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            String answer = scanner.nextLine().toUpperCase();
            Instant finish = Instant.now();
            double timeElapsed = (Duration.between(start, finish).toMillis()) * 1.0 / 1000;
            System.out.println(timeElapsed);

            if (answer.equalsIgnoreCase(list.getNatoalphabet().get(quizItem))){
                if (timeElapsed < timer) {
                    System.out.println(C.ANSI_BRIGHT_GREEN + "Hooray! That was correct!!!" + C.ANSI_RESET);
                    System.out.println("You took " + C.ANSI_BLUE + timeElapsed + C.ANSI_RESET + " seconds");
                    score++;
                } else {
                    System.out.println("Correct but you were TOOOOOOO SLOW!!!!");
                    System.out.println("You took " + C.ANSI_RED + timeElapsed + C.ANSI_RESET + " seconds");
                }
            } else {
                System.out.println(C.ANSI_RED + "****-----BZZZZZZZZZZZZT-------*****" + C.ANSI_RESET);
                System.out.println("WRONG!");
                System.out.println("Correct answer was:  " + C.ANSI_BRIGHT_GREEN + list.getNatoalphabet().get(quizItem) + C.ANSI_RESET);
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            list.getNatoalphabet().remove(quizItem);
            System.out.println("You have " + C.ANSI_BLUE + list.getNatoalphabet().size()+ C.ANSI_RESET + " to go!!");
        }


        System.out.println();
        System.out.println("The game is over!!!");
        System.out.println("Your score:");
        System.out.println("You got " + C.ANSI_BLUE + score + C.ANSI_RESET + " correct out of a possible " + C.ANSI_BLUE + total + C.ANSI_RESET);

    }
}
