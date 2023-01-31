package lesson_one;

public class Crossfit {
  public static void main(String[] args) {
    var human = new Human("Иван", 200, 4);
    var cat = new Cat("Барсик", 100, 2);
    var robot = new Robot("Дроид", 500, 500);
    var wall = new Wall(4);
    var track = new Track(100);
    System.out.println(wall.isJump(human) ? track.isRun(human) : "Выбывает: " + human);
    System.out.println(wall.isJump(cat) ? track.isRun(cat) : "Выбывает: " + cat);
    System.out.println(wall.isJump(robot) ? track.isRun(robot) : "Выбывает: " + robot);
  }
}
