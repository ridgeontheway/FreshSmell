package org.wasps.service.smells.concretes;

import org.wasps.model.ClassModel;
import org.wasps.model.MethodModel;
import org.wasps.model.SmellReportModel;
import org.wasps.service.smells.abstracts.ISmeller;

import java.util.ArrayList;
import java.util.List;

public class TooManyParamsSmell extends SmellerBase implements ISmeller {

    public  TooManyParamsSmell(int id){
        super(id);
    }


    @Override
    public SmellReportModel smell(ClassModel file) {

        List<MethodModel> methodModels = file.getMethods();
        SmellReportModel reportModel;
        ArrayList<Boolean> results = new ArrayList<>();
        for (MethodModel currentMethod: methodModels) {
             results.add(ManyParams(currentMethod));
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

    public boolean ManyParams(MethodModel currentMethod ){

        boolean notBloat =true;

        if(currentMethod.getParameters().size()>5){

            notBloat = false;
        }

        return notBloat;
    }


    private SmellReportModel setReportModel(boolean pass, ClassModel file){
        SmellReportModel tempReportModel = new SmellReportModel();
        tempReportModel.setSmellName("Too Many Parameters");

        if (pass){
            tempReportModel.setScore(100);
            tempReportModel.setDetails("Class: " + file.getName() + " passed the Too Many Parameters Smell Test");
        }
        else {
            tempReportModel.setScore(0);
            tempReportModel.setDetails("Class: " + file.getName() + " failed the Too Many Parameters Smell Test");
        }
        return tempReportModel;
    }
}
