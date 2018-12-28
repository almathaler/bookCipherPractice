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
    for (int i = 0; i<toEncrypt.length; i++){
      toEncrypt[i] = toEncrypt[i].replace("\"", "");
      toEncrypt[i] = toEncrypt[i].replace(",", "");
      toEncrypt[i] = toEncrypt[i].replace(".", "");
      toEncrypt[i] = toEncrypt[i].toUpperCase();
    }
    System.out.println("Encrypted input:");
    String ciphered = Arrays.toString(twilightCipher(toEncrypt));
    System.out.println(ciphered);
    System.out.println("Decrypted input:");
    String deciphered = Arrays.toString(twilightDecipher(twilightCipher(toEncrypt)));
    System.out.println(deciphered);
    }catch(FileNotFoundException e){
      System.out.println("Sorry, file not found");
    }
  }
  private static ArrayList<String> makeCipher() throws FileNotFoundException{
    File f = new File("twilight.txt");
    Scanner in = new Scanner(f);
    ArrayList<String> cipher = new ArrayList<String>();
    while (in.hasNext()){
        String word = in.next();
        word = word.trim();
        word = word.replace("\"", "");
        word = word.replace(",", "");
        word = word.replace(".", "");
        word = word.toUpperCase();
        cipher.add(word);
    }
    return cipher;
  }
  public static int[] twilightCipher(String[] toEncrypt) throws FileNotFoundException{
    ArrayList<String> cipher = makeCipher();
    int[] encrypted = new int[toEncrypt.length];
    for (int i = 0; i<toEncrypt.length; i++){
      String word = toEncrypt[i];
      if (cipher.contains(word)){
        int index = cipher.indexOf(word);
        encrypted[i] = index;
        cipher.set(index, "-1");
      }else{
        encrypted[i] = -1;
      }
    }
    return encrypted;
  }
  public static String[] twilightDecipher(int[] toDecrypt) throws FileNotFoundException{
    ArrayList<String> cipher = makeCipher();
    String[] decrypted = new String[toDecrypt.length];
    for (int i = 0; i<toDecrypt.length; i++){
      int index = toDecrypt[i];
      if (index == -1){
        decrypted[i] = "cannotDecrypt";
      }else{
        decrypted[i] = cipher.get(index);
      }
    }
    return decrypted;
  }

}
