import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Arrays;
public class bookCipher{
  public static void main(String[] args){
    try{
    String[] toEncrypt = args;
    System.out.println(Arrays.toString(twilightCipher(toEncrypt)));
    }catch(FileNotFoundException e){
      System.out.println("Sorry, file not found");
    }
  }
  public static String[] twilightCipher(String[] toEncrypt) throws FileNotFoundException{
    File f = new File("twilight.txt");
    Scanner in = new Scanner(f);
    String[] toReturn = toEncrypt;
    return toReturn;
    /**
    String[] encryptedWords = new String[wordsToEncrypt.length];
    for (int i = 0; i < wordsToEncrypt.length; i++){

    }
    **/
  }

}
