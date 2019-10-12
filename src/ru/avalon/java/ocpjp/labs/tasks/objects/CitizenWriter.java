/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.avalon.java.ocpjp.labs.tasks.objects;

import java.io.IOException;
import java.io.PrintStream;
import ru.avalon.java.ocpjp.labs.common.ObjectWriter;


public class CitizenWriter implements ObjectWriter<Citizen>{

    private PrintStream stream = System.out; 

    public CitizenWriter() {
    }
    
    private String ToString(Citizen citizen) {
        StringBuilder sb = new StringBuilder();
        return sb.append(citizen.getCountry().getName()).append(", ").
                  append(citizen.getName()).append(" ").append(citizen.getLastName()).toString();   
    }

    @Override
    public void write(Citizen citizen) throws IOException {
        stream.println(ToString(citizen));
    }

    @Override
    public void close() throws IOException {
        stream = null;
    }
    
}
