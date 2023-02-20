package lesson_three;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class PhoneBook {
  private final HashMap<String, HashSet<String>> pb = new HashMap<>();

  private void add(String surname, String phone) {
    HashSet<String> number;
    if (pb.containsKey(surname)) {
      number = pb.get(surname);
    } else {
      number = new HashSet<>();
    }
    number.add(phone);
    pb.put(surname, number);
  }

  Set<String> get(String surname) {
    return pb.get(surname);
  }

  public static void main(String[] args) {
    PhoneBook pb = new PhoneBook();
    pb.add("Кадони", "89303454545");
    pb.add("Собчак", "89303454546");
    pb.add("Собчак", "89303454547");
    pb.add("Бузова", "89303454548");
    pb.add("Должанский", "89303454549");
    System.out.println(pb.get("Собчак"));
  }
}
