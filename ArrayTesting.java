/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package array.testing;

/**
 *
 * @author Aiden
 */
import java.util.Scanner;
public class ArrayTesting {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner check = new Scanner(System.in);
        System.out.println("What would you like to check alphabetize?");
        String alphabetize = check.nextLine();
        char [] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        char [] alphabetized = alphabetize.toCharArray();
        alphabetized[0]=alphabetize.toCharArray()[0];
        int a = 0;
        int b = 0;
        int [] translated = new int [alphabetized.length];
        while (a < alphabetized.length) {
            while (b < alphabet.length) {
               if (alphabetized[a] == alphabet[b]) {
                   translated[a] = b;
               }
                b++;
            }
            b = 0;
            a++;
        }
        /*System.out.println(alphabetized[0]);
        System.out.println(alphabetize.toCharArray()[0]);
        */
        a = 0;
        while (a < alphabetized.length){
            System.out.println(translated[a]);
            a++;
        }
    }
    
}
