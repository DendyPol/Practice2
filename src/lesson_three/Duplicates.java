package lesson_three;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Duplicates {
  public static void main(String[] args) {
    String[] words = {
      "Один", "Три", "Три", "Семь",
      "Семь", "Один", "Два", "Пять",
      "Шесть", "Семь", "Четыре"
    };
    var uniqueWord = new HashSet<>(Arrays.asList(words));
    System.out.println(uniqueWord);
    var search = new HashMap<String, Integer>();
    for (var word : words) {
      search.put(word, search.getOrDefault(word, 0) + 1);
    }
    System.out.println(search);
  }
}
