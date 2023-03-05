package lesson_three;

import java.util.*;

public class PhoneBook {
  private static final HashMap<String, HashSet<String>> pb = new HashMap<>();
  private static final HashMap<String, HashSet<String>> newPb = new HashMap<>();

  private void add(String surname, String phone) {
    HashSet<String> number;
    HashSet<String> secondNumber;
    if (pb.containsKey(surname) && newPb.containsKey(surname)) {
      number = pb.get(surname);
      secondNumber = newPb.get(surname);
    } else {
      number = new HashSet<>();
      secondNumber = new HashSet<>();
    }
    number.add(phone);
    secondNumber.add(phone);
    pb.put(surname, number);
    newPb.put(surname, number);
  }

  void addAll(PhoneBook newContacts) {
    pb.putAll(newPb);
  }

  Set<String> get(String surname) {
    return pb.get(surname);
  }

  public static void main(String[] args) {
    var pb = new PhoneBook();
    pb.add("Кадони", "89303454545");
    pb.add("Собчак", "89303454546");
    pb.add("Собчак", "89303454580");
    var newPb = new PhoneBook();
    newPb.add("Собчак", "89303454547");
    newPb.add("Бузова", "89303454548");
    newPb.add("Должанский", "89303454549");
    pb.addAll(newPb);
    System.out.println(pb.get("Собчак"));
  }
}
