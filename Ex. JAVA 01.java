import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Resultado {

  public static List<Integer> subsetA(List<Integer> arr) {
    int totalSum = 0;
    for (int num : arr) {
      totalSum += num;
    }

    Collections.sort(arr);

    int sumA = 0;
    List<Integer> subsetA = new ArrayList<>();

    for (int i = 0; i < arr.size(); i++) {
      int num = arr.get(i);
      if (sumA + num > totalSum / 2 && Collections.disjoint(subsetA, arr.subList(i + 1, arr.size()))) {
        subsetA.add(num);
        sumA += num;
      }
    }

    return subsetA;
  }

  public static void main(String[] args) {
    List<Integer> arr = new ArrayList<>();
    arr.add(5);
    arr.add(3);
    arr.add(2);
    arr.add(4);
    arr.add(1);
    arr.add(2);

    List<Integer> subset = subsetA(arr);
    for (int num : subset) {
      System.out.println(num);
    }
  }
}
