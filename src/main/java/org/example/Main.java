package org.example;

import java.lang.reflect.Array;
import java.util.*;

public class Main {
    public static int[] findDiagonalOrder(List<List<Integer>> nums) {
        List<Integer> out = new ArrayList<>();
        if (nums.size() == 1) {
            out.addAll(nums.get(0));
        } else {
            int max = 0;
            int x, y = 0;
            for (x = 0; x < nums.size(); x++) {
                int a = x, b = y;
                if (max < nums.get(a).size()) max = nums.get(a).size();
                while (a >= 0) {
                    if (nums.get(a).size() - 1 >= b)
                        out.add(nums.get(a).get(b));
                    a--;
                    b++;
                }
            }
            x--;
            for (y = 1; y < max; y++) {
                int a = x, b = y;
                while ((b < max)&&(a>=0)) {
                    if (nums.get(a).size() - 1 >= b)
                        out.add(nums.get(a).get(b));
                    a--;
                    b++;
                }
            }
        }
        int[] output = new int[out.size()];
        for (int i = 0; i < out.size(); i++) output[i] = out.get(i);
        return output;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        List<List<Integer>> list = new ArrayList<>();
        int[] a = new int[] {14,12,19,16,9};
        list.add(Arrays.stream(a).boxed().toList());
        a = new int[] {13,14,15,8,11};
        list.add(Arrays.stream(a).boxed().toList());
        a = new int[] {11,13,1};
        list.add(Arrays.stream(a).boxed().toList());
        a = findDiagonalOrder(list);
        for (int n: a) System.out.print(n + " ");
    }
}