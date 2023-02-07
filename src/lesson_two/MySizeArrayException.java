package lesson_two;

public class MySizeArrayException extends MasterException {
  MySizeArrayException(int length) {
    System.out.println("Размер массива не соответствует размеру 4х4");
  }
}
