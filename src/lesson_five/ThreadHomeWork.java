package lesson_five;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ThreadHomeWork {
  private static final Logger logger = Logger.getLogger(ThreadHomeWork.class.getName());
  static final int size = 10000000;
  static final int h = size / 2;

  public static void main(String[] args) {
    firstMethod();
    secondMethod();
  }

  private static Double formula(Float i) {
    return i * (i * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
  }

  public static void firstMethod() {
    long startTime = System.currentTimeMillis();
    var arr = new Float[size];
    Arrays.fill(arr, 1.0f);
    for (int i = 0; i < arr.length; i++) {
      formula(Float.valueOf(i));
    }
    System.out.printf("Время выполнения однопоточности: %d\n", System.currentTimeMillis() - startTime);
  }

  public static void secondMethod() {
    long startTime = System.currentTimeMillis();
    var initialArray = new Float[size];
    Arrays.fill(initialArray, 1.0f);
    var leftHalf = new Float[h];
    var rightHalf = new Float[h];
    System.arraycopy(initialArray, 0, leftHalf, 0, h);
    System.arraycopy(initialArray, h, rightHalf, 0, h);
    var firstThread = new Thread(() -> {
      for (int i = 0; i < leftHalf.length; i++) {
        formula(Float.valueOf(i));
      }
    });
    var secondThread = new Thread(() -> {
      for (int i = 0; i < rightHalf.length; i++) {
        formula(Float.valueOf(i));
      }
    });
    var mergedArray = new Float[size];
    System.arraycopy(leftHalf, 0, mergedArray, 0, h);
    System.arraycopy(rightHalf, 0, mergedArray, h, h);
    firstThread.start();
    secondThread.start();
    try {
      firstThread.join();
      secondThread.join();
    } catch (InterruptedException e) {
      logger.log(Level.WARNING, "Возникла ошибка чтения потока:" + e.getMessage() + Arrays.toString(e.getStackTrace()));
    }
    System.out.printf("Время выполения многопоточности: %d\n", System.currentTimeMillis() - startTime);
  }
}
