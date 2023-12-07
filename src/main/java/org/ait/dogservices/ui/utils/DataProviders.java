package org.ait.dogservices.ui.utils;

import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviders {
    @DataProvider
    public Iterator<Object[]> positiveLoginDataFormCSVFile() throws IOException {
        List<Object[]> list=new ArrayList<Object[]>();

        BufferedReader reader = new BufferedReader(new InputStreamReader(DataProviders.class
                .getResourceAsStream("/positiveLogin.csv")));
        String line = reader.readLine();
        while (line !=null) {
            list.add(line.split(","));
            line = reader.readLine();
        }
        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> negativeLoginDataFormCSVFile() throws IOException {
        List<Object[]> list=new ArrayList<Object[]>();

        BufferedReader reader = new BufferedReader(new InputStreamReader(DataProviders.class
                .getResourceAsStream("/negativeLogin.csv")));
        String line = reader.readLine();
        while (line !=null) {
            list.add(line.split(","));
            line = reader.readLine();
        }
        return list.iterator();
    }


    @DataProvider
    public Iterator<Object[]> positiveRegistrationDataFormCSVFile() throws IOException {
        List<Object[]> list=new ArrayList<Object[]>();

        BufferedReader reader = new BufferedReader(new InputStreamReader(DataProviders.class
                .getResourceAsStream("/positiveRegistration.csv")));
        String line = reader.readLine();
        while (line !=null) {
            list.add(line.split(","));
            line = reader.readLine();
        }
        return list.iterator();
    }


    @DataProvider
    public Iterator<Object[]> negativeRegistrationDataFormCSVFile() throws IOException {
        List<Object[]> list=new ArrayList<Object[]>();

        BufferedReader reader = new BufferedReader(new InputStreamReader(DataProviders.class
                .getResourceAsStream("/negativeRegistration.csv")));
        String line = reader.readLine();
        while (line !=null) {
            list.add(line.split(","));
            line = reader.readLine();
        }
        return list.iterator();
    }
}
