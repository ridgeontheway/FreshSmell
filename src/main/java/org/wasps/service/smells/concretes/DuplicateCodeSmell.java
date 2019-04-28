package org.wasps.service.smells.concretes;

import org.apache.commons.lang3.StringUtils;
import org.wasps.model.ClassModel;
import org.wasps.model.MethodModel;
import org.wasps.model.SmellReportModel;
import org.wasps.service.smells.abstracts.ISmeller;

import java.util.ArrayList;
import java.util.List;

public class DuplicateCodeSmell extends SmellerBase implements ISmeller {

    public DuplicateCodeSmell(int id, String name){
        super(id, name);
    }
    @Override
    public SmellReportModel smell(ClassModel file) {
        List<MethodModel> methodModels = file.getMethods();
        ArrayList<Boolean> results = new ArrayList<>();
        SmellReportModel reportModel;
        for(int i=0;i<methodModels.size();i++){
            List<Integer> indexes = DuplicateCheck(i,methodModels);
            if(indexes.size()>0){
                results.add(false);
            }else{
                results.add(true);
            }
            indexes.clear();
        }

        int numFailures = results.parallelStream().filter(value -> !value).toArray().length;

        if (numFailures > 0) {
            reportModel = setReportModel(false, file);
        } else {
            reportModel = setReportModel(true, file);
        }
        return reportModel;
    }

    private List<Integer> DuplicateCheck(int index,List<MethodModel> methodModels){
        MethodModel currentMethod = methodModels.get(index);
        List<String> sourceCode = currentMethod.getSourceCode();
        String sourceLine = filter(sourceCode);
        List<Integer> indexes = new ArrayList<>();

        for (int i=0;i<methodModels.size();i++){


            if(filter(methodModels.get(i).getSourceCode())=="" || sourceLine==""){
                //any empty methods
            }
            else if(i!=index) {

              if(sourceLine.compareTo(filter(methodModels.get(i).getSourceCode()))==0){
                  indexes.add(i);
              }
            }

        }


        return indexes;
    }

    private String filter(List<String> sourceCode){

        List<String> Filter = new ArrayList<>();

        for (String sourceLine: sourceCode) {
            sourceLine=sourceLine.replaceAll("\\s", "");
            sourceLine = sourceLine.replaceAll("//.*|(\"(?:\\\\[^\"]|\\\\\"|.)*?\")|(?s)/\\*.*?\\*/","");
            Filter.add(sourceLine);
        }
        String Line =StringUtils.join(Filter,""); //makes list<string> just one string
        Line = Line.replaceAll("//.*|(\"(?:\\\\[^\"]|\\\\\"|.)*?\")|(?s)/\\*.*?\\*/","");//filters multi line comments
        int indexOfLast =Line.lastIndexOf("return");
        if(indexOfLast!=-1){
        Line = Line.substring(0, indexOfLast);
        }
        //Filtering the list further, at this point we only have the assignments
        return Line;


    }
}
