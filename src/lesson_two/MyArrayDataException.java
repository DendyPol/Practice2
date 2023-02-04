package lesson_two;

public class MyArrayDataException extends Exception {
  MyArrayDataException(int col, int row) {
    System.out.printf("В массиве находятся текст или символ, в ячейке [%d,%d]", col, row);
  }
}
