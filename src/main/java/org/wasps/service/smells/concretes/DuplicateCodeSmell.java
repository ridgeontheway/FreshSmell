package org.wasps.service.smells.concretes;

import org.apache.commons.lang3.StringUtils;
import org.wasps.model.ClassModel;
import org.wasps.model.MethodModel;
import org.wasps.model.SmellReportModel;
import org.wasps.service.smells.abstracts.ISmeller;

import java.util.ArrayList;
import java.util.List;

public class DuplicateCodeSmell extends SmellerBase implements ISmeller {

    public DuplicateCodeSmell(int id){
        super(id);
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
        String sourceLine = filterSourceCode(sourceCode);
        List<Integer> indexes = new ArrayList<>();

        for (int i=0;i<methodModels.size();i++){


            if(filterSourceCode(methodModels.get(i).getSourceCode())=="" || sourceLine==""){
                //any empty methods
            }
            else if(i!=index) {

              if(sourceLine.compareTo(filterSourceCode(methodModels.get(i).getSourceCode()))==0 ||
                      filterSourceCode(methodModels.get(i).getSourceCode()).indexOf(sourceLine)>=0){
                  indexes.add(i);
              }
            }

        }


        return indexes;
    }

    private String filterSourceCode(List<String> sourceCode){

        String sourceLine = StringUtils.join(sourceCode,""); //makes list<string> just one string
        sourceLine= sourceLine.replaceAll("\\s", "");//removes all white spaces
        sourceLine = sourceLine.replaceAll("//.*|(\"(?:\\\\[^\"]|\\\\\"|.)*?\")|(?s)/\\*.*?\\*/", "");//removes all comments

        //Filtering the list further, at this point we only have the assignments
        return sourceLine;
    }
    private SmellReportModel setReportModel(boolean pass, ClassModel file) {
        SmellReportModel tempReportModel = new SmellReportModel();
        tempReportModel.setSmellName("Duplicate Code");

        if (pass) {
            tempReportModel.setScore(100);
            tempReportModel.setDetails("Class: " + file.getName() + " passed the Duplicate Code Smell Test");
        } else {
            tempReportModel.setScore(0);
            tempReportModel.setDetails("Class: " + file.getName() + " failed the Duplicate Code Smell Test");
        }
        return tempReportModel;
    }


}
