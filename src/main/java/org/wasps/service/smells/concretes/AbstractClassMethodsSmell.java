package org.wasps.service.smells.concretes;

import org.wasps.model.ClassModel;
import org.wasps.model.MethodModel;
import org.wasps.model.SmellReportModel;
import org.wasps.service.smells.abstracts.ISmeller;

import java.util.List;

//An abstract class should have both abstract and concrete methods
public class AbstractClassMethodsSmell extends SmellerBase implements ISmeller {

    public AbstractClassMethodsSmell(int id){
        super(id);
    }
    @Override
    public SmellReportModel smell(ClassModel file) {
        if (!file.isAbstract()){
            return setReportModel(true, file);
        }

        SmellReportModel reportModel;
        if (containsAbstractMethods(file.getMethods()) && containsConcreteMethods(file.getMethods())){
            reportModel = setReportModel(true, file);
        }
        else {
            reportModel = setReportModel(false, file);
        }

        return reportModel;
    }

    private boolean containsAbstractMethods(List<MethodModel> methodModelList){
        boolean containsAbstractMethods = false;
        int numAbstractMethods = methodModelList.stream().filter(methodModel -> methodModel.isAbstract()).toArray().length;

        if (numAbstractMethods > 0){
            containsAbstractMethods = true;
        }
        return containsAbstractMethods;
    }

    private boolean containsConcreteMethods(List<MethodModel> methodModelList){
        boolean containsConcreteMethods = false;
        int numConcreteMethods = methodModelList.stream().filter(methodModel -> !methodModel.isAbstract()).toArray().length;

        if (numConcreteMethods > 0){
            containsConcreteMethods = true;
        }
        return containsConcreteMethods;
    }

    private SmellReportModel setReportModel(boolean pass, ClassModel file){
        SmellReportModel tempReportModel = new SmellReportModel();
        tempReportModel.setSmellName("AbstractClassMethod");

        if (pass){
            tempReportModel.setScore(100);
            tempReportModel.setDetails("Class: " + file.getName() + " passed the AbstractClassMethod smell");
        }
        else {
            tempReportModel.setScore(0);
            tempReportModel.setDetails("Class: " + file.getName() + " failed the AbstractClassMethod smell");
        }
        return tempReportModel;
    }
}
