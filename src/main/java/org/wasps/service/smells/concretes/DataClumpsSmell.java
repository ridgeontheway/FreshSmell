package org.wasps.service.smells.concretes;

import org.apache.commons.lang3.StringUtils;
import org.wasps.model.ClassModel;
import org.wasps.model.MethodModel;
import org.wasps.model.SmellReportModel;
import org.wasps.service.smells.abstracts.ISmeller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class DataClumpsSmell extends SmellerBase implements ISmeller {

    public DataClumpsSmell(int id, String name){
        super(id, name);
    }
    private final int variableThreshold = 10;

    @Override
    public SmellReportModel smell(ClassModel file) {
        List<MethodModel> methodModels = file.getMethods();
        SmellReportModel reportModel;
        ArrayList<Boolean> results = new ArrayList<>();
        for (MethodModel currentMethod : methodModels) {
            results.add(VariableCount(currentMethod));
        }
        int numFailures = results.parallelStream().filter(value -> !value).toArray().length;

        if (numFailures > 0) {
            reportModel = setReportModel(false, file);
        } else {
            reportModel = setReportModel(true, file);
        }

        return reportModel;
    }

    private boolean VariableCount(MethodModel currentMethod) {
        List<String> sourceCode = currentMethod.getSourceCode();
        List<String> SearchingFor = Arrays.asList("int ", "String ", "double ", "long ",
                "boolean ", "byte ", "char ", "short ", "float ");
        boolean pass = true;

        String FilteredString = filterSourceCode(sourceCode);
        int variableCount = 0;//starts at one cause the method itself
        for (String line : SearchingFor) {
            List<Integer> data= VariableOccurence(FilteredString, line);
            for(int fromIndex: data ){
                int toIndex = FilteredString.indexOf(";",fromIndex);
                String subStr=FilteredString.substring(fromIndex,toIndex);
                if(VariableOccurence(subStr, ",").size()>=1){
                    variableCount += VariableOccurence(subStr, ",").size() +1;
                }else{
                    variableCount += 1;
                }


            }
        }

        if (variableCount >= variableThreshold) {
            pass = false;
        }


        return pass;
    }

    private String filterSourceCode(List<String> sourceCode) {

        List<String> Filtering = new ArrayList<>();

        for (String line: sourceCode) {
            line = line.replaceAll("//.*|(\"(?:\\\\[^\"]|\\\\\"|.)*?\")|(?s)/\\*.*?\\*/","");//filters single comments
            Filtering.add(line);
        }
        String sourceLine =StringUtils.join(Filtering,"");//makes list<string> just one string
        sourceLine = sourceLine.replaceAll("//.*|(\"(?:\\\\[^\"]|\\\\\"|.)*?\")|(?s)/\\*.*?\\*/","");//filters multi line comments



        return sourceLine;
    }


//    private SmellReportModel setReportModel(boolean pass, ClassModel file) {
//        SmellReportModel tempReportModel = new SmellReportModel();
//        tempReportModel.setSmellName("Data Clump");
//
//        if (pass) {
//            tempReportModel.setScore(100);
//            tempReportModel.setDetails("Class: " + file.getName() + " passed the Data Clump Smell Test");
//        } else {
//            tempReportModel.setScore(0);
//            tempReportModel.setDetails("Class: " + file.getName() + " failed the Data Clump Smell Test");
//        }
//        return tempReportModel;
//    }

    //duplicate code to be added to a helper class
    public List<Integer> VariableOccurence(String textString, String word) {
        List<Integer> indexes = new ArrayList<>();
        int wordLength = 0;

        int index = 0;
        while (index != -1) {
            index = textString.indexOf(word, index + wordLength);  // Slight improvement
            if (index != -1) {
                indexes.add(index);
            }
            wordLength = word.length();
        }
        return indexes;
    }
}