package lesson_one;

import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class Human implements Challenge {
  private String name;
  private int maxRun;
  private int maxJump;

  @Override
  public int run() {
    System.out.println("Бежит: " + name);
    return maxRun;
  }

  @Override
  public int jump() {
    System.out.println("Прыгает: " + name);
    return maxJump;
  }
}
