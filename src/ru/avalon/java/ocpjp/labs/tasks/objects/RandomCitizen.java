/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.avalon.java.ocpjp.labs.tasks.objects;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import ru.avalon.java.ocpjp.labs.Lab;
import ru.avalon.java.ocpjp.labs.common.Factory;

/**
 *
 * @author Constantine
 */
public class RandomCitizen implements Factory<Citizen>, Citizen {

    private List<String> countries;
    private List<String> names;
    private List<String> lastNames;
    private String pathCountry = "C:\\Users\\pashak\\Documents\\NetBeansProjects\\labs\\ocpjp\\lab-1-pkokovin\\src\\ru\\avalon\\java\\ocpjp\\labs\\resources\\countries.txt";
    private String pathName = "C:\\Users\\pashak\\Documents\\NetBeansProjects\\labs\\ocpjp\\lab-1-pkokovin\\src\\ru\\avalon\\java\\ocpjp\\labs\\resources\\first-names.txt";
    private String pathLastName = "C:\\Users\\pashak\\Documents\\NetBeansProjects\\labs\\ocpjp\\lab-1-pkokovin\\src\\ru\\avalon\\java\\ocpjp\\labs\\resources\\last-names.txt";
    private String code;
    private String countryName;
    private Country country;
    private String name;
    private String lastName;

    public RandomCitizen() throws IOException {
        countries = readFile(pathCountry);
        names = readFile(pathName);
        lastNames = readFile(pathLastName);
    }

    public List<String> readFile(String path) throws IOException {
        File file = new File(path);
        List<String> list = new ArrayList();
        System.out.println(path);
        try (Scanner sc = new Scanner(file)) {
            while (sc.hasNextLine()) {
                list.add(sc.nextLine());
            }
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
        return list;
//        try (InputStream in = getClass().getResourceAsStream(path)) {
//            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
//            String line;
//            while ((line = reader.readLine()) != null) {
//            list.add(line);
//        }
        }
        

    @Override
    public Citizen create() {
        Random random = new Random();
        try {
            code = countries.get(random.nextInt(countries.size())).split(":")[0];
            countryName = countries.get(random.nextInt(countries.size())).split(":")[1];
            country = new CountryFactory(code, countryName);
            name = names.get(random.nextInt(names.size()));
            lastName = lastNames.get(random.nextInt(lastNames.size()));

            return new CitizenFactory(country, name, lastName);
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    @Override
    public Country getCountry() {
        return country;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

}
