package lesson_one;

import lombok.AllArgsConstructor;

@AllArgsConstructor

public class Track {
  private int running;

  protected boolean isRun(Challenge statistic) {
    if (running <= statistic.run()) {
      System.out.println("Бег выполнен: " + statistic);
      return true;
    } else {
      System.out.println("Бег не выполнен: " + statistic);
      return false;
    }
  }
}
