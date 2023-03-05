package lesson_three;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Duplicates {
  public static void main(String[] args) {
    List<String> words = List.of("Orange", "Banana", "Orange", "Cherry", "Pineapple", "watermelon");
    var uniqueWord = new HashSet<>(List.of("Banana", "Banana", "Cherry", "Watermelon"));
    System.out.println(uniqueWord);
    var search = new HashMap<String, Integer>();
    for (var word : words) {
      search.put(word, search.getOrDefault(word, 0) + 1);
    }
    System.out.println(search);
  }
}
