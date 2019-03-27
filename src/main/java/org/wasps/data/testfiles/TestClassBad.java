package org.wasps.data;

import java.util.ArrayList;
import java.util.List;

public class TestClassBad {
    public String testString = "test bad";
    public int testInt = 14;

    // Methods
    public String badMethod() {
        int five = 2 + 3;
        for(int i=0; i<10; i++)
            five += i;

        List<Integer> list = new ArrayList<>();
        for (int i=0; i<10; i++)
            list.add(i*2);

        for(int item : list)
            System.out.println(item);

        return "This method is bad";
    }
}
