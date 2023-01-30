package lesson_one;

import lombok.AllArgsConstructor;

@AllArgsConstructor

public class Wall {
  private int height;

  protected boolean isJump(Challenge statistic) {
    if (height <= statistic.jump()) {
      System.out.println("Прыжок выполнен: " + statistic);
      return true;
    } else {
      System.out.println("Прыжок не выполнен: " + statistic);
      return false;
    }
  }
}
