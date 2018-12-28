import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;
public class bookCipher{
  public static void main(String[] args){
    System.out.println("Welcome to the twilight book cipher.");
    System.out.println("This program allows you to encrypt text by subsituting words with the order");
    System.out.println("in which they appear in the first chapter of twilight and the preface.");
    System.out.println("quotations are ignored, so \"\"hey\", she said\" will be registered as \"hey, she said\"");
    System.out.println("Also, \"-\"s are considered words in themselves when used as em dashes");
    try{
    String[] toEncrypt = args;
    System.out.println(Arrays.toString(twilightCipher(toEncrypt)));
    }catch(FileNotFoundException e){
      System.out.println("Sorry, file not found");
    }
  }
  public static int[] twilightCipher(String[] toEncrypt) throws FileNotFoundException{
    File f = new File("twilight.txt");
    Scanner in = new Scanner(f);
    ArrayList<String> cipher = new ArrayList<String>();
    while (in.hasNext()){
        String word = in.next();
        word = word.trim();
        word = word.replace("\"", "");
        word = word.replace(",", "");
        word = word.replace(".", "");
        cipher.add(word);
    }
    int[] encrypted = new int[toEncrypt.length];
    for (int i = 0; i<toEncrypt.length; i++){
      String word = toEncrypt[i];
      if (cipher.contains(word)){
        encrypted[i] = cipher.indexOf(word);
        cipher.remove(word);
      }else{
        encrypted[i] = -1;
      }
    }
    return encrypted;
    //return cipher;
    /**
    String[] encryptedWords = new String[wordsToEncrypt.length];
    for (int i = 0; i < wordsToEncrypt.length; i++){

    }
    **/
  }

}
