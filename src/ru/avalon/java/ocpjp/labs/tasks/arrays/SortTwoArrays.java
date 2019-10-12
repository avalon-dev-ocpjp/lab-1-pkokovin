/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.avalon.java.ocpjp.labs.tasks.arrays;

import java.util.Arrays;
import java.util.Comparator;


public class SortTwoArrays implements Sort<int[][]>{

    @Override
    public void run(int[][] dataSet) {
        int[] oneDimArray = new int[dataSet[0].length * dataSet.length];
        int k = 0;
        for (int i = 0; i < dataSet.length; i++) {
            for (int j = 0; j < dataSet[0].length; j++) {
                oneDimArray[k++] = dataSet[i][j];
            }
        }
        Arrays.sort(oneDimArray);
        k = 0;
        for (int i = 0; i < dataSet.length; i++) {
            for (int j = 0; j < dataSet[0].length; j++) {
                dataSet[i][j] = oneDimArray[k++];
            }
        }
    }
    
}
