package test_data;

import java.util.HashMap;
import java.util.Map;

public class RandomCyclomatic {

@SuppressWarnings("unchecked")
    public void complexMethod(){
        Map<String, Integer> items = new HashMap<>();
        items.put("A", 10);
        items.put("B", 20);
        items.put("C", 30);
        items.put("D", 40);
        items.put("E", 50);
        items.put("F", 60);
        int i =1;
        int j=2;


        for (Map.Entry<String, Integer> entry : items.entrySet()) { //1
            System.out.println("Item : " + entry.getKey() + " Count : " + entry.getValue());
        }

        if(i==1 && j==2) //2


        for(int k =0;k<j;k++) {//1

        }

            if(i==1 || j==2){//2

            }
            else if(j==2){//1

            }

        if(i==1 || j==2){//2

        }
        else if(j==2){//1

        }

        if(i==1 || j==2){//2

        }
        else if(j==2){//1

        }

        if(i==1 || j==2){//2

        }
        else if(j==2){//1

        }

        if(i==1 || j==2){//2

        }
        else if(j==2){//1

        }
            char grade = 'C';

/*if
 for : : : : : : : : : : : : these comments are filtered out during run time
 */


        switch(grade) {
            case 'A' : //1
                System.out.println("Excellent!");
                break;

            default : //1
                System.out.println("Invalid grade");
        }
    }

}

