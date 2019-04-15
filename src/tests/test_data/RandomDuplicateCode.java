package test_data;

import java.util.ArrayList;
import java.util.List;

public class RandomDuplicateCode {
    @SuppressWarnings("unchecked")
    public List<Integer> WordOccurence(String textString, String word) {
        List<Integer> indexes = new ArrayList<>();

        int wordLength = 0;

        int index = 0;
        while(index != -1){
            index = textString.indexOf(word, index + wordLength);  // Slight improvement
            if (index != -1) {

                if(word=="for("){
                    int toIndex=textString.indexOf(')',index);
                    String subStr= textString.substring(index,toIndex);
                    if(subStr.indexOf(':',index)==-1){
                        indexes.add(index);
                    }else{

                    }
                }
                if(word=="else"){
                    int toIndex=textString.indexOf('f',index);
                    String subStr= textString.substring(index,toIndex);
                    if(subStr=="elseif"){

                    }else{indexes.add(index);}

                }else{
                    indexes.add(index);
                }
            }
            wordLength = word.length();
        }


        return indexes;
    }
    @SuppressWarnings("unchecked")
    public void complexMethod(String textString, String word){
        List<Integer> indexes = new ArrayList<>();
        int i =1;
        int j=2;
        if(i==1 && j==2)
            if(j==2)
                if(j==2)
                    if(j==2)
                        if(j==2)
                            if(i==1 || j==2){

                            }
                            else{

                            }
        if(i==0){}

        for(int k =0;k<j;k++) {

        }
        if(j==2)
            if(i==1 || j==2){

            }
            else if(j==2){

            }
        for (int currentMethod: indexes) {

        }char grade = 'C';

        switch(grade) {
            case 'A' :
                System.out.println("Excellent!");
                break;

            default :
                System.out.println("Invalid grade");
        }
    }



}
