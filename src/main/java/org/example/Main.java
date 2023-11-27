package org.example;


import java.util.*;

public class Main {
    //Функкция на вход идёт массив из чётного количества целых чисел
    //Функция возвращает минимизированную максимальную сумму пар после оптимального объединения элементов в пары
    public static int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int output = 0;
        for(int i = 0; i < nums.length; i++){
            output = Math.max(output, nums[i]+nums[nums.length-1-i]);
        }
        return output;
    }
    //Функция на вход принимает двумерный массив чисел
    //На выход идёт массив чисел, пройденных по диагонали
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
        System.out.println("Choose your task \n1. Min Pair Sum. \n2. Find Diagonal Order");
        int a = in.nextInt();
        in.nextLine();
        int n = in.nextInt();
        in.nextLine();
        switch (a){
            case 1 ->{
                int[] arr = new int[n];
                for(int i = 0; i < n; i++) arr[i] = in.nextInt();
                System.out.println(minPairSum(arr));
            }
            case 2 ->{
                List<List<Integer>> list = new ArrayList<>();
                String str;
                for (int j = 0; j < n; j++) {
                    str = in.nextLine();
                    String[] s = str.split(" ");
                    int[] arr = new int[s.length];
                    for (int i = 0; i < s.length; i++) arr[i] = Integer.parseInt(s[i]);
                    list.add(Arrays.stream(arr).boxed().toList());
                }
                int[] out = findDiagonalOrder(list);
                for (int j : out) System.out.print(j + " ");
            }
        }
    }
}