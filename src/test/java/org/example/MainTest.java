package org.example;

import org.junit.jupiter.api.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


class MainTest {
    @Nested
    @DisplayName("Input data validation")
    class InputTest{
        @Test
        void holst(){
            try(Scanner in = new Scanner(new File("src/test/java/org/example/test/testholst.txt"))){
                int w = in.nextInt(), h = in.nextInt();
                int n = in.nextInt();
                Assertions.assertTrue(((1 <= w)&&(w <= 100))&&((1 <= h)&&(h <= 100)));
            } catch (FileNotFoundException e){
                e.printStackTrace();
            }
        }
        @Test
        void num(){
            try(Scanner in = new Scanner(new File("src/test/java/org/example/test/numtest.txt"))){
                int w = in.nextInt(), h = in.nextInt();
                int n = in.nextInt();
                Assertions.assertTrue((n>=0)&&(n<=5000));
            } catch (FileNotFoundException e){
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
                Assertions.assertNotEquals(-5, Main.painter(holst, coords, n));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
    @Nested
    @DisplayName("Tests")
    class ProgramTest{
        @Test
        void test1(){
            try(Scanner in = new Scanner(new File("src/test/java/org/example/test/test1.txt"))){
                int w = in.nextInt(), h = in.nextInt();
                int n = in.nextInt();
                boolean[][] holst = new boolean[w][h];
                for(int i = 0; i < w; i++){
                    for(int j = 0; j < h; j++) holst[i][j] = true;
                }
                int[][] coords = new int[n][4];
                for(int i = 0; i < n; i++){
                    for(int j = 0; j < 4; j++){
                        coords[i][j] = in.nextInt();
                    }
                }
                Assertions.assertEquals(18,Main.painter(holst, coords, n));
            } catch (FileNotFoundException e){
                e.printStackTrace();
            }
        }
        @Test
        void test2(){
            try(Scanner in = new Scanner(new File("src/test/java/org/example/test/test2.txt"))){
                int w = in.nextInt(), h = in.nextInt();
                int n = in.nextInt();
                boolean[][] holst = new boolean[w][h];
                for(int i = 0; i < w; i++){
                    for(int j = 0; j < h; j++) holst[i][j] = true;
                }
                int[][] coords = new int[n][4];
                for(int i = 0; i < n; i++){
                    for(int j = 0; j < 4; j++){
                        coords[i][j] = in.nextInt();
                    }
                }
                Assertions.assertEquals(17,Main.painter(holst, coords, n));
            } catch (FileNotFoundException e){
                e.printStackTrace();
            }
        }
        @Test
        void test3(){
            try(Scanner in = new Scanner(new File("src/test/java/org/example/test/test3.txt"))){
                int w = in.nextInt(), h = in.nextInt();
                int n = in.nextInt();
                boolean[][] holst = new boolean[w][h];
                for(int i = 0; i < w; i++){
                    for(int j = 0; j < h; j++) holst[i][j] = true;
                }
                int[][] coords = new int[n][4];
                for(int i = 0; i < n; i++){
                    for(int j = 0; j < 4; j++){
                        coords[i][j] = in.nextInt();
                    }
                }
                Assertions.assertEquals(1,Main.painter(holst, coords, n));
            } catch (FileNotFoundException e){
                e.printStackTrace();
            }
        }
    }

}