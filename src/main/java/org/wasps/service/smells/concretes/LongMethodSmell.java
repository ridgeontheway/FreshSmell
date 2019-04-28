package org.wasps.service.smells.concretes;

import org.wasps.model.ClassModel;
import org.wasps.model.MethodModel;
import org.wasps.model.SmellReportModel;
import org.wasps.service.smells.abstracts.ISmeller;

import java.util.ArrayList;
import java.util.List;

public class LongMethodSmell extends SmellerBase implements ISmeller {

    public  LongMethodSmell(int id, String name){
        super(id, name);
    }
    private final int MaxMethodLength = 30;
    @Override
    public SmellReportModel smell(ClassModel file) {
        List<MethodModel> methodModels = file.getMethods();
        SmellReportModel reportModel;
        ArrayList<Boolean> results = new ArrayList<>();
        for (MethodModel currentMethod: methodModels) {
            results.add(getMethodLength(currentMethod));
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

    private boolean getMethodLength(MethodModel currentMethod){
        boolean pass =true;
        List<String> sourceCode = new ArrayList<>();
        for(String line: currentMethod.getSourceCode()){
            sourceCode.add(line.replaceAll("[\\r\\n]+",""));//removes empty lines
        }
        if(sourceCode.size()>=MaxMethodLength){
            pass =false;
        }


        return pass;
    }
}
