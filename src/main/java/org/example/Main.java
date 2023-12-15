package org.example;


import java.io.*;
import java.util.*;

public class Main {
    static final File file = new File("src/main/java/org/example/text/input.txt");

    public static int painter(boolean[][] holst, int[][] coords,int n){
        int output = 0;
        if (((holst.length >= 1)&&(holst.length<=100))&&((holst[0].length >= 1)&&(holst[0].length<=100))) {
            if((n<0)||(n>5000)) return -2;
            int t1=0, t2=0, t3=0, t4=0;
            for (int i = 0; i < n; i++) {
                t1 = coords[i][0];
                t2 = coords[i][1];
                t3 = coords[i][2];
                t4 = coords[i][3];
                if (t1 > t3 || t1 > holst.length || t3 > holst.length || t1 < 0)
                    return -5;
                if ((t2 > t4) || (t2 > holst[0].length) || (t4 > holst[0].length) || (t2 < 0) || (t4 < 0))
                    return -5;
                for (int j = t1; j < t3; j++) {
                    for (int k = t2; k < t4; k++) {
                        holst[j][k] = false;
                    }
                }
            }
            for (boolean[] booleans : holst) {
                for (boolean aBoolean : booleans) {
                    if (aBoolean) output++;
                }
            }
        }
        else output = -1;
        return output;
    }
    public static int[] cowsAndBulls(String num1, String num2){
        int[] out = new int[2];
        int cow = 0, bull = 0;
        if ((num1.length() == 4) && (num2.length() == 4)) {
            char[] n1 = num1.toCharArray();
            char[] n2 = num2.toCharArray();
            Set<Character> setn1 = new HashSet<>();
            Set<Character> setn2 = new HashSet<>();
            boolean repeat = false;
            for(int i = 0; i < 4; i++){
                if(!setn1.contains(n1[i])){
                    setn1.add(n1[i]);
                }
                else repeat = true;
                if(!setn2.contains(n2[i])){
                    setn2.add(n2[i]);
                }
                else repeat = true;
            }
            CowsLoop:
            if (!repeat) {
                for (int i = 0; i < num1.length(); i++) {
                    for (int j = 0; j < num2.length(); j++) {
                        if (((n1[j] >= '0') && (n1[j] <= '9')) && ((n2[j] >= '0') && (n2[j] <= '9'))) {
                            if (n1[i] == n2[j]) {
                                if (i == j)
                                    bull++;
                                else
                                    cow++;
                            }
                        } else {
                            out[0] = -1;
                            out[1] = -2;
                            break CowsLoop;
                        }
                    }
                }
                out[0] = bull;
                out[1] = cow;
            } else {
                out[0] = -1;
                out[1] = -3;
            }
        } else {
            out[0] = -1;
            out[1] = -1;
        }
        return out;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        String[] s = str.split(" ");
        int[] out = cowsAndBulls(s[0],s[1]);
        System.out.println(out[0] + " " + out[1]);
//        try{
//            Scanner in = new Scanner(file);
//            int w = in.nextInt(), h = in.nextInt();
//            int n = in.nextInt();
//            boolean[][] holst = new boolean[w][h];
//            for(int i = 0; i < w; i++){
//                for(int j = 0; j < h; j++) holst[i][j] = true;
//            }
//            int[][] coords = new int[n][4];
//            for(int i = 0; i < n; i++){
//                for(int j = 0; j < 4; j++){
//                    coords[i][j] = in.nextInt();
//                }
//            }
//            in.close();
//
//            FileWriter fileOutputStream = new FileWriter(new File("src/main/java/org/example/text/output.txt"));
//            fileOutputStream.append(String.valueOf(painter(holst, coords, n)));
//            fileOutputStream.close();
//        } catch (FileNotFoundException e){
//            e.printStackTrace();
//        } catch (IOException e){
//            e.printStackTrace();
//        }
    }
}