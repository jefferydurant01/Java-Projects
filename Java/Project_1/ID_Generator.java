package Java.Project_1;

import java.util.Calendar;
import java.util.Random;

public class ID_Generator {

  private String first_name;
  private String last_name;
  private int id_number;
  private String birth_date;

  public ID_Generator() {
    this.first_name = "John";
    this.last_name = "Doe";
    this.id_number = 0;
    this.birth_date = "1/1/1900";
  }

  public ID_Generator(String firstName, String lastName, String birthDate) {
    this.first_name = firstName;
    this.last_name = lastName;
    this.id_number = randomNumberGenerator();
    this.birth_date = birthDate;
  }

  public ID_Generator(ID_Generator object) {
    this.first_name = object.first_name;
    this.last_name = object.last_name;
    this.id_number = object.getIDNumber();
    this.birth_date = object.birth_date;
  }

  public void setFirstName(String newFirstName) {
    this.first_name = newFirstName;
  }

  public void setLastName(String newLastName) {
    this.last_name = newLastName;
  }

  public void setIDNumber(int newIDNumber) {
    this.id_number = newIDNumber;
  }

  public void setBirthDate(String newBirthDate) {
    this.birth_date = newBirthDate;
  }

  public String getFirstName() {
    return first_name;
  }

  public String getLastName() {
    return last_name;
  }

  public int getIDNumber() {
    return id_number;
  }

  public String getBirthDate() {
    return birth_date;
  }

  public int randomNumberGenerator() {
    Random random = new Random();
    return random.nextInt(9999);
  }

  public void printID() {
    System.out.println("Name: " + first_name + ", " + last_name + "\n");
    System.out.println("ID Number: " + id_number + "\n");
    System.out.println("Date of Birth: " + birth_date + "\n");
  }

  public boolean checkDateOfBirth(String dateOfBirth)
    throws ArrayIndexOutOfBoundsException {
    if (dateOfBirth.length() > 10 || dateOfBirth.length() < 8) {
      return false;
    }

    try {
        String[] array = dateOfBirth.split("/");
        int dayOfBirth = Integer.parseInt(array[0]);
        int monthOfBirth = Integer.parseInt(array[1]);
        int yearOfBirth = Integer.parseInt(array[2]);
        return checkDays(dayOfBirth, monthOfBirth, yearOfBirth);

    } catch (ArrayIndexOutOfBoundsException e) {
      String DOB = dateOfBirth;
      /*
       * 09042002 = 8
       * 942002 = 6
       * 01012001 = 8
       * 112001 = 6
       *
       */
      if (DOB.length() == 8) {
        String[] array = new String[4];
        array[0] = DOB.substring(0, 1);
        array[1] = DOB.substring(2, 3);
        array[2] = DOB.substring(4, DOB.length());

        int dayOfBirth = Integer.parseInt(array[0]);
        int monthOfBirth = Integer.parseInt(array[1]);
        int yearOfBirth = Integer.parseInt(array[2]);

        return checkDays(dayOfBirth, monthOfBirth, yearOfBirth);
      }

      if (DOB.length() == 6) {
        String[] array = new String[4];
        array[0] = DOB.substring(0, 1);
        array[1] = DOB.substring(1, 2);
        array[2] = DOB.substring(2, DOB.length());

        int dayOfBirth = Integer.parseInt(array[0]);
        int monthOfBirth = Integer.parseInt(array[1]);
        int yearOfBirth = Integer.parseInt(array[2]);

        return checkDays(dayOfBirth, monthOfBirth, yearOfBirth);
      }
    }
    return true;
  }

  public boolean checkDays(int dayOfBirth, int monthOfBirth, int yearOfBirth) {
    //february
    if (dayOfBirth > 28 && monthOfBirth == 2) {
      return false;
    }

    //april, june, september, november
    if (
      dayOfBirth > 30 &&
      monthOfBirth == 4 ||
      monthOfBirth == 6 ||
      monthOfBirth == 9 ||
      monthOfBirth == 11
    ) {
      return false;
    }

    if (dayOfBirth > 31) {
      return false;
    }

    if (monthOfBirth > 12) {
      return false;
    }

    int year = Calendar.getInstance().get(Calendar.YEAR);

    if (yearOfBirth > year || yearOfBirth == 0) {
      return false;
    }

    return true;
  }
}
