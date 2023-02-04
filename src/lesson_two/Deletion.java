package lesson_two;

public class Deletion {
  public static int testMass(String[][] array) throws MySizeArrayException, MyArrayDataException {
    var count = 0;
    for (int i = 0; i < array.length; i++) {
      if (4 != array.length) {
        throw new MySizeArrayException(array.length);
      }
      for (int j = 0; j < array[i].length; j++) {
        if (4 != array[i].length) {
          throw new MySizeArrayException(array.length);
        }
        try {
          count += Integer.parseInt(array[i][j]);
        } catch (RuntimeException ex) {
          throw new MyArrayDataException(i, j);
        }
      }
    }
    return count;
  }

  public static void main(String[] args) {
    String[][] massCorrect = {
      {"1", "2", "3", "4"},
      {"1", "2", "3", "4"},
      {"1", "2", "3", "4"},
      {"1", "2", "3", "4"}
    };
    String[][] massSizeIncorrect = {
      {"1", "2", "3", "4"},
      {"1", "2", "3"},
      {"1", "2", "3", "4"},
      {"1", "2", "3", "4"}
    };
    String[][] massSymbolIncorrect = {
      {"1", "2", "3", "4"},
      {"1", "2", "•", "4"},
      {"1", "2", "3", "4"},
      {"1", "2", "3", "4"}
    };
    try {
      System.out.println("Элементы массива равны " + testMass(massCorrect));
    } catch (MyArrayDataException | MySizeArrayException ex) {
      System.out.println(ex.getMessage());
    }
    try {
      System.out.println(testMass(massSizeIncorrect));
    } catch (MyArrayDataException | MySizeArrayException ex) {
      System.out.println(ex.getMessage());
    }
    try {
      System.out.println(testMass(massSymbolIncorrect));
    } catch (MyArrayDataException | MySizeArrayException ex) {
      System.out.println(ex.getMessage());
    }
  }
}
