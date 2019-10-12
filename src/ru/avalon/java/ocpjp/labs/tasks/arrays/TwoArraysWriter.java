/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.avalon.java.ocpjp.labs.tasks.arrays;

import java.io.IOException;
import java.util.Arrays;
import ru.avalon.java.ocpjp.labs.common.ObjectWriter;


public class TwoArraysWriter implements ObjectWriter<int[][]>{

    @Override
    public void write(int[][] object) throws IOException {
        for (int i = 0; i < object.length; i++){
        System.out.println(Arrays.toString(object[i]));            
        }
    }

    @Override
    public void close() throws IOException {
        
    }
    
}
