package org.wasps.service.smells.concretes;

import org.apache.commons.lang3.StringUtils;
import org.wasps.model.ClassModel;
import org.wasps.model.MethodModel;
import org.wasps.model.SmellReportModel;
import org.wasps.service.smells.abstracts.ISmeller;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class CyclomaticComplexitySmell extends SmellerBase implements ISmeller {

    public CyclomaticComplexitySmell(int id, String name){
        super(id, name);
    }

    private final int CyclomaticComplexityThreshold = 20;
    @Override
    public SmellReportModel smell(ClassModel file) {

        List<MethodModel> methodModels = file.getMethods();
        SmellReportModel reportModel;
        ArrayList<Boolean> results = new ArrayList<>();
        for (MethodModel currentMethod: methodModels) {
            results.add(CyclomaticComplexityCount(currentMethod));
        }
        int numFailures = results.parallelStream().filter(value -> !value).toArray().length;

        if (numFailures > 0){
            reportModel = setReportModel(false, file);
        }
        else{
            reportModel = setReportModel(true, file);
        }


        return reportModel;
    }

    private boolean CyclomaticComplexityCount(MethodModel currentMethod){
        List<Integer> indexes = new ArrayList<>();
        List<String> sourceCode = currentMethod.getSourceCode();
        List<String> SearchingFor= Arrays.asList("if(","while(","for(","else",":","&&","||");//what we search the source code for
        boolean pass = true;
       String FilteredString=filterSourceCode(sourceCode);
        int complexitySize=1;//starts at one cause the method itself
        for(String line: SearchingFor){

            complexitySize+=  WordOccurence(FilteredString,line).size();
        }


        if(complexitySize>CyclomaticComplexityThreshold){
            pass =false;
        }
       return pass;
    }

    private String filterSourceCode(List<String> sourceCode){
        List<String> Filtering = new ArrayList<>();

        for (String line: sourceCode) {
            line=line.replaceAll("\\s", ""); //removes all whitespace
            line = line.replaceAll("//.*|(\"(?:\\\\[^\"]|\\\\\"|.)*?\")|(?s)/\\*.*?\\*/","");//filters single comments
            Filtering.add(line);
        }
        String sourceLine =StringUtils.join(Filtering,""); //makes list<string> just one string
        sourceLine = sourceLine.replaceAll("//.*|(\"(?:\\\\[^\"]|\\\\\"|.)*?\")|(?s)/\\*.*?\\*/","");//filters multi line comments

        //Filtering the list further, at this point we only have the assignments
        return sourceLine;
    }


    //duplicate code to be added to a helper class
    public List<Integer> WordOccurence(String textString, String word) {
        List<Integer> indexes = new ArrayList<>();

        int wordLength = 0;

        int index = 0;
        while(index != -1){
            index = textString.indexOf(word, index + wordLength);  // Slight improvement
            if (index != -1) {

                if(word.equals("for(")){ //this is to identify edge cases for each loop
                    int toIndex=textString.indexOf(')',index);
                    String subStr = textString.substring(index, toIndex);

                    if (subStr.indexOf(':')==-1) {
                        indexes.add(index);
                    }
                } else if(word.equals("else")) {//this is to identify edge case if else

                    int toIndex=textString.indexOf('f',index);
                    if(toIndex!=-1){
                        String subStr = textString.substring(index, toIndex);
                        if (!(subStr.equals("elsei"))) {
                            indexes.add(index);
                        }
                    }

                } else {
                    indexes.add(index);
                }
            }
            wordLength = word.length();
        }


        return indexes;
    }
}
