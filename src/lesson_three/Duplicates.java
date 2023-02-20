package lesson_three;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Duplicates {
  public static void main(String[] args) {
    String[] words = {
      "Один", "Три", "Три", "Семь",
      "Семь", "Один", "Два", "Пять",
      "Шесть", "Семь", "Четыре"
    };
    Set<String> uniqueWord = new HashSet<>(Arrays.asList(words));
    System.out.println(uniqueWord);
    HashMap<String, Integer> search = new HashMap<>();
    for (var word : words) {
      search.put(word, search.getOrDefault(word, 0) + 1);
    }
    System.out.println(search);
  }
}
