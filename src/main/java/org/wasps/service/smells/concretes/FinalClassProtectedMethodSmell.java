package org.wasps.service.smells.concretes;

import org.wasps.model.ClassModel;
import org.wasps.model.MethodModel;
import org.wasps.model.SmellReportModel;
import org.wasps.service.smells.abstracts.ISmeller;

import java.util.List;

//Final class should not contain protected methods
public class FinalClassProtectedMethodSmell extends SmellerBase implements ISmeller {

    public FinalClassProtectedMethodSmell(int id, String name) {
        super(id, name);
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
}
