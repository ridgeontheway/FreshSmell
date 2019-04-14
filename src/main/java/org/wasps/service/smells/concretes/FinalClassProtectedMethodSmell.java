package org.wasps.service.smells.concretes;

import org.wasps.model.ClassModel;
import org.wasps.model.MethodModel;
import org.wasps.model.SmellReportModel;
import org.wasps.service.smells.abstracts.ISmeller;

import java.util.List;

//Final class should not contain protected methods
public class FinalClassProtectedMethodSmell extends SmellerBase implements ISmeller {

    public FinalClassProtectedMethodSmell(int id) {
        super(id);
    }

    @Override
    public SmellReportModel smell(ClassModel file) {
        SmellReportModel reportModel;

        if (file.isFinal() && containsProtectedMethods(file.getMethods())){
            reportModel = setReportModel(false, file);
        }
        else{
            reportModel = setReportModel(true, file);
        }
        return reportModel;
    }

    public boolean containsProtectedMethods(List<MethodModel> methodModelList){
        boolean containsProtectedMethods = false;
        int numProtectedMethods = methodModelList.stream()
                .filter(methodModel -> methodModel.isProtected()).toArray().length;
        if (numProtectedMethods > 0){
            containsProtectedMethods = true;
        }
        return containsProtectedMethods;
    }

    private SmellReportModel setReportModel(boolean pass, ClassModel file){
        SmellReportModel tempReportModel = new SmellReportModel();
        tempReportModel.setSmellName("FinalClassProtectedMethod");

        if (pass){
            tempReportModel.setScore(100);
            tempReportModel.setDetails("Class: " + file.getName() + " passed the FinalClassProtectedMethod smell");
        }
        else {
            tempReportModel.setScore(0);
            tempReportModel.setDetails("Class: " + file.getName() + " failed the FinalClassProtectedMethod smell");
        }
        return tempReportModel;
    }
}
