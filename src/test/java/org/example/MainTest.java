package org.example;

import org.junit.jupiter.api.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


class MainTest {
    @Nested
    @DisplayName("BullsAndCows")
    class BullsAndCows{
        @Nested
        @DisplayName("Input data validation")
        class InputTest{
            @Test
            void lengthTest1(){
                String s1 = "12345", s2 = "1234";
                int[] out = new int[] {-1,-1};
                Assertions.assertArrayEquals(out, Main.cowsAndBulls(s1,s2));
            }
            @Test
            void lengthTest2(){
                String s1 = "4587", s2 = "12345";
                int[] out = new int[] {-1,-1};
                Assertions.assertArrayEquals(out, Main.cowsAndBulls(s1,s2));
            }
            @Test
            void lengthTest3(){
                String s1 = "458", s2 = "1234";
                int[] out = new int[] {-1,-1};
                Assertions.assertArrayEquals(out, Main.cowsAndBulls(s1,s2));
            }
            @Test
            void contentTest1(){
                String s1 = "a234", s2 = "1234";
                int[] out = new int[] {-1,-2};
                Assertions.assertArrayEquals(out, Main.cowsAndBulls(s1,s2));
            }
            @Test
            void contentTest2(){
                String s1 = "2543", s2 = "5s23";
                int[] out = new int[] {-1,-2};
                Assertions.assertArrayEquals(out, Main.cowsAndBulls(s1,s2));
            }
            @Test
            void repeatTest1(){
                String s1 = "2215", s2 = "1234";
                int[] out = new int[] {-1,-3};
                Assertions.assertArrayEquals(out, Main.cowsAndBulls(s1,s2));
            }
            @Test
            void repeatTest2(){
                String s1 = "2543", s2 = "5541";
                int[] out = new int[] {-1,-3};
                Assertions.assertArrayEquals(out, Main.cowsAndBulls(s1,s2));
            }
        }
        @Nested
        @DisplayName("Tests")
        class ProgramTest{
            @Test
            void test1(){
                int[] out = new int[]{1, 2};
                Assertions.assertArrayEquals(out, Main.cowsAndBulls("5671","7251"));
            }
            @Test
            void test2(){
                int[] out = new int[]{4,0};
                Assertions.assertArrayEquals(out, Main.cowsAndBulls("1234","1234"));
            }
            @Test
            void test3(){
                int[] out = new int[]{2,1};
                Assertions.assertArrayEquals(out, Main.cowsAndBulls("2034","6234"));
            }
            @Test
            void test4(){
                int[] out = new int[]{0,4};
                Assertions.assertArrayEquals(out, Main.cowsAndBulls("1234","4321"));
            }
            @Test
            void test5(){
                int[] out = new int[]{0,0};
                Assertions.assertArrayEquals(out, Main.cowsAndBulls("1234","5678"));
            }
        }
    }
    @Nested
    @DisplayName("Painter")
    class Painter{
        @Nested
        @DisplayName("Input data validation")
        class InputTest {
            @Test
            void holst() {
                try (Scanner in = new Scanner(new File("src/test/java/org/example/test/testholst.txt"))) {
                    int w = in.nextInt(), h = in.nextInt();
                    int n = in.nextInt();
                    boolean[][] holst = new boolean[w][h];
                    for (int i = 0; i < w; i++) {
                        for (int j = 0; j < h; j++) holst[i][j] = true;
                    }
                    int[][] coords = new int[n][4];
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < 4; j++) {
                            coords[i][j] = in.nextInt();
                        }
                    }
                    Assertions.assertEquals(-1, Main.painter(holst, coords, n));
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }

            @Test
            void num() {
                try (Scanner in = new Scanner(new File("src/test/java/org/example/test/numtest.txt"))) {
                    int w = in.nextInt(), h = in.nextInt();
                    int n = in.nextInt();
                    boolean[][] holst = new boolean[w][h];
                    for (int i = 0; i < w; i++) {
                        for (int j = 0; j < h; j++) holst[i][j] = true;
                    }
                    int[][] coords = new int[0][0];
                    Assertions.assertEquals(-2, Main.painter(holst, coords, n));
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }

            @Test
            void coords() {
                try (Scanner in = new Scanner(new File("src/test/java/org/example/test/coordstest.txt"))) {
                    int w = in.nextInt(), h = in.nextInt();
                    int n = in.nextInt();
                    boolean[][] holst = new boolean[w][h];
                    for (int i = 0; i < w; i++) {
                        for (int j = 0; j < h; j++) holst[i][j] = true;
                    }
                    int[][] coords = new int[n][4];
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < 4; j++) {
                            coords[i][j] = in.nextInt();
                        }
                    }
                    Assertions.assertEquals(-5, Main.painter(holst, coords, n));
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }

        @Nested
        @DisplayName("Tests")
        class ProgramTest {
            @Test
            void test1() {
                try (Scanner in = new Scanner(new File("src/test/java/org/example/test/test1.txt"))) {
                    int w = in.nextInt(), h = in.nextInt();
                    int n = in.nextInt();
                    boolean[][] holst = new boolean[w][h];
                    for (int i = 0; i < w; i++) {
                        for (int j = 0; j < h; j++) holst[i][j] = true;
                    }
                    int[][] coords = new int[n][4];
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < 4; j++) {
                            coords[i][j] = in.nextInt();
                        }
                    }
                    Assertions.assertEquals(18, Main.painter(holst, coords, n));
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }

            @Test
            void test2() {
                try (Scanner in = new Scanner(new File("src/test/java/org/example/test/test2.txt"))) {
                    int w = in.nextInt(), h = in.nextInt();
                    int n = in.nextInt();
                    boolean[][] holst = new boolean[w][h];
                    for (int i = 0; i < w; i++) {
                        for (int j = 0; j < h; j++) holst[i][j] = true;
                    }
                    int[][] coords = new int[n][4];
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < 4; j++) {
                            coords[i][j] = in.nextInt();
                        }
                    }
                    Assertions.assertEquals(17, Main.painter(holst, coords, n));
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }

            @Test
            void test3() {
                try (Scanner in = new Scanner(new File("src/test/java/org/example/test/test3.txt"))) {
                    int w = in.nextInt(), h = in.nextInt();
                    int n = in.nextInt();
                    boolean[][] holst = new boolean[w][h];
                    for (int i = 0; i < w; i++) {
                        for (int j = 0; j < h; j++) holst[i][j] = true;
                    }
                    int[][] coords = new int[n][4];
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < 4; j++) {
                            coords[i][j] = in.nextInt();
                        }
                    }
                    Assertions.assertEquals(1, Main.painter(holst, coords, n));
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}