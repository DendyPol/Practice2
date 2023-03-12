package lesson_five;

import java.util.Arrays;

public class ThreadHomeWork {
  static final int size = 10000000;
  static final int h = size / 2;

  public static void main(String[] args) {
    firstMethod();
    secondMethod();
  }

  public static void firstMethod() {
    long startTime = System.currentTimeMillis();
    var arr = new float[size];
    Arrays.fill(arr, 1);
    for (int i = 0; i < arr.length; i++) {
      arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
    }
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
      for (int i = 0; i < leftHalf.length; i++) {
        leftHalf[i] = (float) (leftHalf[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
      }
    });
    var secondThread = new Thread(() -> {
      for (int i = 0; i < leftHalf.length; i++) {
        rightHalf[i] = (float) (rightHalf[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
      }
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
      e.printStackTrace();
    }
    System.out.printf("Время выполения многопоточности: %d\n", System.currentTimeMillis() - startTime);
  }
}
