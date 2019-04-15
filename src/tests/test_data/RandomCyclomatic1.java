package test_data;

import java.util.ArrayList;
import java.util.List;

public class RandomCyclomatic1 {

    @SuppressWarnings("unchecked")
    public void complexMethod(){
        int i =1;
        int j=2;
        if(i==1 && j==2)
            if(j==2){}
        char grade = 'C';
        switch(grade) {
            case 'A' :
                System.out.println("Excellent!");
                break;

            default :
                System.out.println("Invalid grade");
        }

        if(i==1 || j==2){

        }
        else{

        }
/*if
 for : : : : : : : : : : : : these comments are filtered out during run time
 */
    }



}

