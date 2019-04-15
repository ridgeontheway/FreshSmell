package test_data;

import java.util.ArrayList;
import java.util.List;

public class RandomDuplicateCode1 {
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
    public List<Integer> WordOccurence1(String textString, String word) {
        List<Integer> indexes = new ArrayList<>();

        int wordLength = 0;

        int index = 0;
        while(index != -1){
            index = textString.indexOf(word, index + wordLength);  // Slight improvement
            if (index != -1) {
                indexes.add(index);
            }
            wordLength = word.length();
        }


        return indexes;
    }

}
