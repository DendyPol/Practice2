package lesson_one;

public class Crossfit {
  public static void main(String[] args) {
    var human = new Human("Иван", 200, 4);
    var cat = new Cat("Барсик", 100, 2);
    var robot = new Robot("Дроид", 500, 500);
    var wall = new Wall(4);
    var track = new Track(100);
    Challenge[] challenge = {human, cat, robot};
    for (var info : challenge) {
      System.out.println(wall.isJump(info) ? track.isRun(info) : "Выбывает: " + info);
    }
  }
}
