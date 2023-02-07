package lesson_two;

public class Deletion {
  public static int testMass(String[][] array) throws MySizeArrayException, MyArrayDataException {
    var count = 0;
    for (int i = 0; i < array.length; i++) {
      if (array.length != 4) {
        throw new MySizeArrayException(array.length);
      }
      for (int j = 0; j < array[i].length; j++) {
        if (array[i].length != 4) {
          throw new MySizeArrayException(array.length);
        }
        try {
          count += Integer.parseInt(array[i][j]);
        } catch (NumberFormatException ex) {
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
      testMass(massCorrect);
    } catch (MasterException ex) {
      ex.printStackTrace();
    }
    try {
      testMass(massSizeIncorrect);
    } catch (MasterException ex) {
      ex.printStackTrace();
    }
    try {
      testMass(massSymbolIncorrect);
    } catch (MasterException ex) {
      ex.printStackTrace();
    }
  }
}
