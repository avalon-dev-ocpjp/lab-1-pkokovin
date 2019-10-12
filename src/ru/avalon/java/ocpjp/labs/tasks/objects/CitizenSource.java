/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.avalon.java.ocpjp.labs.tasks.objects;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;


public class CitizenSource implements Iterable<Citizen>{

    private List<Citizen> citizen;

    public CitizenSource() throws IOException  {
    Random random = new Random();
    citizen = new ArrayList();
    int count = random.nextInt(10)+20;
    for(int i=0; i < count; i++) {
        citizen.add(new RandomCitizen().create());
	        }        
    }

    @Override
    public Iterator<Citizen> iterator() {
        return citizen.iterator();
    }
    
}
