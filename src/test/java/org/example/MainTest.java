package org.example;

import org.junit.jupiter.api.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class MainTest {
    List<List<Integer>> read(int type){
        List<List<Integer>> out = new ArrayList<>();
        String str;
        switch (type) {
            case 3 -> {
                try (Scanner in = new Scanner(new File("D:\\Programming\\Java\\unit_test1\\src\\test\\java\\org\\example\\test\\test3.txt"))) {
                    while (in.hasNextLine()) {
                        str = in.nextLine();
                        in.nextLine();
                        String[] s = str.split(" ");
                        int[] a = new int[s.length];
                        for (int i = 0; i < s.length; i++)
                            a[i] = Integer.parseInt(s[i]);
                        out.add(Arrays.stream(a).boxed().toList());
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
            case 4 -> {
                try (Scanner in = new Scanner(new File("D:\\Programming\\Java\\unit_test1\\src\\test\\java\\org\\example\\test\\test4.txt"))) {
                    while (in.hasNextLine()) {
                        str = in.nextLine();
                        String[] s = str.split(" ");
                        int[] a = new int[s.length];
                        for (int i = 0; i < s.length; i++) a[i] = Integer.parseInt(s[i]);
                        out.add(Arrays.stream(a).boxed().toList());
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
        return out;
}

    @Nested
    @DisplayName("Diagonal")
    class DiagonalTest {
        @Test
        void test1() {
            System.out.println("Test 1 in process");
            List<List<Integer>> list = new ArrayList<>();
            int[] a = new int[]{1, 2, 3};
            list.add(Arrays.stream(a).boxed().toList());
            a = new int[]{4, 5, 6};
            list.add(Arrays.stream(a).boxed().toList());
            a = new int[]{7, 8, 9};
            list.add(Arrays.stream(a).boxed().toList());
            int[] test = new int[]{1, 4, 2, 7, 5, 3, 8, 6, 9};
            Assertions.assertArrayEquals(test, Main.findDiagonalOrder(list));
        }

        @Test
        void test2() {
            System.out.println("Test 2 in process");
            List<List<Integer>> list = new ArrayList<>();
            int[] a = new int[]{1, 2, 3, 4, 5};
            list.add(Arrays.stream(a).boxed().toList());
            a = new int[]{6, 7};
            list.add(Arrays.stream(a).boxed().toList());
            a = new int[]{8};
            list.add(Arrays.stream(a).boxed().toList());
            a = new int[]{9, 10, 11};
            list.add(Arrays.stream(a).boxed().toList());
            a = new int[]{12, 13, 14, 15, 16};
            list.add(Arrays.stream(a).boxed().toList());
            int[] test = new int[]{1, 6, 2, 8, 7, 3, 9, 4, 12, 10, 5, 13, 11, 14, 15, 16};
            Assertions.assertArrayEquals(test, Main.findDiagonalOrder(list));
        }

        @Test
        void test3() {
            System.out.println("Test 3 in process");
            int[] accept = new int[]{1, 2, 3, 4, 5, 6};
            List<List<Integer>> list = read(3);
            Assertions.assertArrayEquals(accept, Main.findDiagonalOrder(list));
        }

        @Test
        void test4() {
            System.out.println("Test 4 in process");
            int[] accept = new int[]{14, 13, 12, 11, 14, 19, 13, 15, 16, 1, 8, 9, 11};
            List<List<Integer>> list = read(4);
            Assertions.assertArrayEquals(accept, Main.findDiagonalOrder(list));
        }
    }
    @Nested
    @DisplayName("Min Num")
    class PairTest {
        @Test
        void test1() {
            int[] nums = new int[]{3, 5, 2, 3};
            Assertions.assertEquals(7, Main.minPairSum(nums));
        }

        @Test
        void test2() {
            int[] nums = new int[]{3, 5, 4, 2, 4, 6};
            Assertions.assertEquals(8, Main.minPairSum(nums));
        }
    }
}