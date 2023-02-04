package lesson_two;

public class MySizeArrayException extends Exception {
  MySizeArrayException(int length) {
    System.out.print("Размер массива не соответствует размеру 4х4");
  }
}
