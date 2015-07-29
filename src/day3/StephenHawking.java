package day3;

import java.io.IOException;

import javax.swing.JOptionPane;

public class StephenHawking {

    // 1. make a main method and put steps 2, 3 & 4 inside it
   
	public static void main(String[] args) {
	for (int i = 0; i < 10000; i++) {
		
	
		String grape=JOptionPane.showInputDialog("Write a sentence.");	
	speak(grape);}
	// 2. ask the user for a sentence
    // 3. repeat the sentence using the speak method below
    // 4. make this repeat a lot of times
	}
static void speak(String grape) {
   	 try {
   		 Runtime.getRuntime().exec("say " +grape).waitFor();
   	 } catch (Exception e) {
   		 e.printStackTrace();
   	 }
    }

}

// Copyright Wintriss Technical Schools 2014





