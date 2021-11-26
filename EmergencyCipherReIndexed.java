/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package emergency.cipher.reindexed;

/**
 *
 * @author Aiden
 */
import java.util.*;
import java.lang.Math;

public class EmergencyCipherReIndexed {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String systemPasskey = "encode";
        int a = 0; 
        Scanner password = new Scanner(System.in);
        System.out.println("Enter password:\n");
        while (a <= 5) {
            String key = password.nextLine();
            if (key.equals(systemPasskey)) {
                //start of cipher
                while (a < 100) {
                    a = 0;
                    System.out.println("");
                    System.out.println("Would you like to encode or decode?");
                    String choice = password.next();
                    if (choice.equalsIgnoreCase("encode"))
                    {
                        System.out.println("This system is not able to encode punctuation nor literal numbers. For numbers, type them out.");
                        //alphabet encoding program here
                        Scanner type = new Scanner(System.in);
                        System.out.println("encoding");
                        int cipherNumber =(int) Math.round(Math.random()*10);
                        int messageCipher = (int) Math.round(Math.random()*10);
                        if (messageCipher == 0) {
                            messageCipher = 1;
                        }
                        System.out.println("Input text");
                        String message = type.nextLine();
                        char [] messageArray = message.toCharArray();
                        int messageLegnth = messageArray.length;
                        char [] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
                        char [] newAlphabet = "abcdefghijklmnopqrstuvwxyz ".toCharArray();
                        while (a < 25 - cipherNumber) {
                           newAlphabet[a] = alphabet[a + cipherNumber];
                           a++;
                        }
                        a = 0;
                        while (a < cipherNumber) {
                            newAlphabet[25 - cipherNumber + a] = alphabet[a];
                            a++;
                        }
                        //Well this creates a rather weird alphabet
                        //now encode the message
                       /*
                        a  = 0;
                        while (a < 27) {
                            System.out.println(newAlphabet[a]);
                            a++;
                        }
                       */
                       //New indexing algorithim 
                       a = 0;
                       int b = 0;
                       int [] translated = new int [messageLegnth];
                        while (a < messageLegnth) {
                            while (b < newAlphabet.length) {
                                if (messageArray[a] == newAlphabet[b]) {
                                    translated[a] = b;
                                }
                                b++;
                            }
                            b = 0;
                            a++;
                        }
                        a = 0;
                        /*while (a < messageLegnth) {
                            System.out.println(translated[a]);
                            a++;
                        }
                        */
                        int [] codeTranslated = new int [translated.length];
                        while (a < translated.length) {
                            if (translated[a] + messageCipher > newAlphabet.length - 1) {
                                codeTranslated[a] = -1*(newAlphabet.length - (translated[a] + messageCipher));
                            }
                            else {
                                codeTranslated[a] = translated[a] + messageCipher;
                            }
                            a++;
                        }
                        //The if statement might put out of bounds numbers off by +1 ???
                        /*
                        a = 0;
                        while (a < translated.length) {
                        System.out.println(codeTranslated[a]);
                        System.out.println(translated[a]);
                        a++;
                        }
                        */
                        char [] finalString = new char [messageLegnth];
                        a = 0;
                        while (a < messageLegnth) {
                            finalString[a] = newAlphabet[codeTranslated[a]];
                            a++;
                        }
                        a = 0;
                        while (a < messageLegnth) {
                            System.out.print(finalString[a]);
                            a++;
                        }
                        System.out.println("");
                        //Lastly, have the system print out the new message alongside the cipher number and the message cipher
                        System.out.println("Here is the cipher number: " + cipherNumber);
                        System.out.println("Here is the message cipher: " + messageCipher);
                        a = 0;   
                        /*while (a < newAlphabet.length) {
                            System.out.println(newAlphabet[a]);
                            a++;
                        }*/
                    }
                    else if (choice.equalsIgnoreCase("decode")) {
                        //write decoding algorithim here
                        int cipherNumber = 0;
                        int messageCipher = 0;
                        a = 0;
                        Scanner cipher = new Scanner(System.in);
                        Scanner input = new Scanner(System.in);
                        while (a < 1) {
                            System.out.println("What is the Cipher Number?");
                            cipherNumber = Math.abs(cipher.nextInt());
                            System.out.println("What is the message cipher?");
                            messageCipher = Math.abs(cipher.nextInt());
                            if (cipherNumber<=10 && messageCipher<=10 && cipherNumber != 0) {
                                break;
                            }
                            else {
                                System.out.println("Error: Invalid input. Please enter values less than  or equal to 10 and greater than 0.");
                            }
                        }
                        System.out.println("What would you like to decode?");
                        String message = input.nextLine();
                        char [] messageArray = message.toCharArray();
                        int messageLegnth = messageArray.length;
                        a = 0;
                        //System.out.println("MC = " + messageCipher + " CN = " + cipherNumber);
                        System.out.println("decoding");
                        //Readjust the alphabet and move the letters by the caesar cipher algorithm
                        char [] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
                        char [] newAlphabet = "abcdefghijklmnopqrstuvwxyz ".toCharArray();
                        while (a < 25 - cipherNumber) {
                           newAlphabet[a] = alphabet[a + cipherNumber];
                           a++;
                        }
                        a = 0;
                        while (a < cipherNumber) {
                            newAlphabet[25 - cipherNumber + a] = alphabet[a];
                            a++;
                        }
                        /*
                        a = 0;
                        while (a < newAlphabet.length) {
                            System.out.print(newAlphabet[a]);
                            a++;
                        }
                        */
                        a = 0;
                       int b = 0;
                       int [] translated = new int [messageLegnth];
                        while (a < messageLegnth) {
                            while (b < newAlphabet.length) {
                                if (messageArray[a] == newAlphabet[b]) {
                                    translated[a] = b;
                                }
                                b++;
                            }
                            b = 0;
                            a++;
                        }
                        //everything below should work
                        a = 0;
                        /*
                        while (a < translated.length) {
                            System.out.println(translated[a]);
                            a++;
                        }
                        */
                        a = 0;
                        int [] codeTranslated = new int [translated.length];
                        //Consider the -1 here
                        while (a < translated.length) {
                            if (translated[a] - messageCipher < 0) {
                                int i = translated[a] - messageCipher;
                                int j = newAlphabet.length + i;
                                codeTranslated[a] = j;
                            }
                            else {
                                codeTranslated[a] = translated[a] - messageCipher;
                            }
                            a++;
                        }
                        /*
                        a = 0;
                        while (a < codeTranslated.length) {
                            System.out.println(codeTranslated[a]);
                            a++;
                        }
                        */
                        //The part beneath works //nevermind                        
                        char [] finalString = new char [messageLegnth];
                        a = 0;
                        while (a < messageLegnth) {
                            finalString[a] = newAlphabet[codeTranslated[a]];
                            a++;
                        }
                        
                        a = 0;
                        System.out.println("");
                        while (a < messageLegnth) {
                            System.out.print(finalString[a]);
                            a++;
                        }
                        
                    }
                    else {
                        System.out.println("Error: invalid input. Would you like to continue (Y/N)?");
                        choice = password.next();
                        if (choice.equalsIgnoreCase("Y"))
                        {
                            //leave blank and let the system continue
                        }
                        else {
                            int b = 0;
                            while (b < 1000) {
                                System.out.println("");
                                b++;
                            }
                            break;
                        }
                    }
                }
            }
            else {
                System.out.println("Please enter a valid password. You have " + (5-a) + " attempts remaining");
                a++;
            }
        }
    }
    
}
