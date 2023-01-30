package lesson_one;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Human implements Challenge {
  private String name;
  private int maxRun;
  private int maxJump;

  @Override
  public String toString() {
    return "Human{" +
      "name='" + name + '\'' +
      ", maxRun=" + maxRun +
      ", maxJump=" + maxJump +
      '}';
  }

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
