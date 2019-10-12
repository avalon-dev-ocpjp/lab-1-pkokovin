/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.avalon.java.ocpjp.labs.tasks.objects;

import java.util.Comparator;


public class CitizenComparator implements Comparator<Citizen>{

    @Override
    public int compare(Citizen o1, Citizen o2) {
        Country cnt1 = o1.getCountry();
        Country cnt2 = o2.getCountry();
        int compare = cnt1.getName().compareTo(cnt2.getName());
        if (compare == 0) {
            compare = o1.getName().compareTo(o2.getName());
            if (compare == 0) {
                return o1.getLastName().compareTo(o2.getLastName());
            } return compare;
        } return compare;
    }
    
}
