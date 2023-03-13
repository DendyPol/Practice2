package lesson_five;

import java.util.Arrays;
import java.util.logging.Logger;

public class ThreadHomeWork {
  private static final Logger logger = Logger.getLogger(ThreadHomeWork.class.getName());
  static final int size = 10000000;
  static final int h = size / 2;

  public static void main(String[] args) {
    firstMethod();
    secondMethod();
  }

  private static void formula(float[] arr, int i) {
    for (int j = 0; j < arr.length; j++, i++) {
      arr[j] = (float) (arr[j] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
    }
  }

  public static void firstMethod() {
    long startTime = System.currentTimeMillis();
    var arr = new float[size];
    Arrays.fill(arr, 1);
    formula(arr, 0);
    System.out.printf("Время выполнения однопоточности: %d\n", System.currentTimeMillis() - startTime);
  }

  public static void secondMethod() {
    long startTime = System.currentTimeMillis();
    var initialArray = new float[size];
    Arrays.fill(initialArray, 1);
    var leftHalf = new float[h];
    var rightHalf = new float[h];
    System.arraycopy(initialArray, 0, leftHalf, 0, h);
    System.arraycopy(initialArray, h, rightHalf, 0, h);
    var firstThread = new Thread(() -> {
      formula(leftHalf, 0);
    });
    var secondThread = new Thread(() -> {
      formula(rightHalf, h);
    });
    var mergedArray = new float[size];
    System.arraycopy(leftHalf, 0, mergedArray, 0, h);
    System.arraycopy(rightHalf, 0, mergedArray, h, h);
    firstThread.start();
    secondThread.start();
    try {
      firstThread.join();
      secondThread.join();
    } catch (InterruptedException e) {
      logger.severe("Возникла ошибка чтения потока:" + e.getMessage());
    }
    System.out.printf("Время выполения многопоточности: %d\n", System.currentTimeMillis() - startTime);
  }
}
