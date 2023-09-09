package Java.Project_1;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    System.out.println("Please enter your Full Legal Name...");
    Scanner objScanner = new Scanner(System.in);
    String[] fullName = objScanner.nextLine().toUpperCase().split(" ");
    System.out.println("Please enter your birthday...mm/dd/yy");
    String birthDate = objScanner.nextLine();

    System.out.println("Generating ID" + "\n");
    ID_Generator object = new ID_Generator(fullName[0], fullName[1], birthDate);
    if (!object.checkDateOfBirth(birthDate)) {
      boolean errorFixed = false;
      while (errorFixed == false) {
        System.out.print("ERROR. INVALID BIRTH DATE.\n");
        System.out.println("Please enter your birthday...mm/dd/yy");
        birthDate = objScanner.nextLine();
        object.setBirthDate(birthDate);
        if (object.checkDateOfBirth(birthDate) == true) {
          errorFixed = true;
        }
      }
    }
    System.out.println("NEW IDENTIFICATION CARD PRINTED\n");
    object.printID();
    objScanner.close();
  }
}
