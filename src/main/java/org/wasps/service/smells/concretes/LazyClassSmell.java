package org.wasps.service.smells.concretes;

import com.thoughtworks.qdox.model.JavaConstructor;
import com.thoughtworks.qdox.model.JavaType;
import org.wasps.model.ClassModel;
import org.wasps.model.MethodModel;
import org.wasps.model.SmellReportModel;
import org.wasps.service.smells.abstracts.ISmeller;

import java.util.List;
import java.util.stream.Collectors;

public class LazyClassSmell implements ISmeller {

    private final int LINENUMBER_THRESHOLD = 15;

    @Override
    public SmellReportModel smell(ClassModel file) {
        if (file.isInterface()){
            return setReportModel(true, file);
        }

        SmellReportModel reportModel;
        boolean allPublicMethods = allPublicMethods(file.getMethods());
        boolean hasEmptyOrNoConstructor = hasEmptyOrNoConstructor(file);
        boolean allFieldsHaveGetterOrSetter = allFieldsHaveGetterOrSetter(file, file.getMethods());

        if ((allPublicMethods && hasEmptyOrNoConstructor && allFieldsHaveGetterOrSetter) || isSmallClass(file)){
            reportModel = setReportModel(false, file);
        }
        else {
            reportModel = setReportModel(true, file);
        }
        return reportModel;
    }

    private boolean allPublicMethods(List<MethodModel> methodModelList){
        boolean allPublicMethods = false;
        List<JavaType> filteredReturnTypeList = methodModelList.stream().map(value -> value.getReturnType()).collect(Collectors.toList());
        int numPublicFields = filteredReturnTypeList.stream().filter(v -> v.getValue().equals("public")).toArray().length;

        if (methodModelList.size() > 0 && numPublicFields/methodModelList.size()  == methodModelList.size()){
            allPublicMethods = true;
        }
        return allPublicMethods;
    }

    private boolean hasEmptyOrNoConstructor(ClassModel file){
        boolean hasEmptyOrNoConstructor = false;
        List<JavaConstructor> classConstructors = file.getRawConstructors();

        if (classConstructors.size() == 0){
            hasEmptyOrNoConstructor = true;
        }
        else if (classConstructors.size() == 1 && classConstructors.get(0).getParameters().size() == 0){
            hasEmptyOrNoConstructor = true;
        }

        return hasEmptyOrNoConstructor;
    }

    private boolean allFieldsHaveGetterOrSetter(ClassModel file, List<MethodModel> methodModelList){
        boolean allFieldsHaveGetterOrSetter = true;
        List<String> fields = file.getFields();

        for (String currentField: fields) {
            if (!allFieldsHaveGetterOrSetter){
                break;
            }

            String[] whiteSpaceRemoval= currentField.trim().split("\\s+");
            CharSequence[] finalFilter = {whiteSpaceRemoval[0], whiteSpaceRemoval[whiteSpaceRemoval.length-1]};

            for (MethodModel model: methodModelList) {
                int numMatches = model.getParameters().stream().filter(javaParameter -> javaParameter.getName().contains(finalFilter[1])).toArray().length;

                if(!model.getName().contains(finalFilter[1]) && (numMatches == 0 || !model.getReturnType().getValue().contains(finalFilter[0]))){
                    allFieldsHaveGetterOrSetter = false;
                    break;
                }
            }
        }
        return allFieldsHaveGetterOrSetter;
    }

    private SmellReportModel setReportModel(boolean pass, ClassModel file){
        SmellReportModel tempReportModel = new SmellReportModel();
        tempReportModel.setSmellName("Lazy Class");

        if (pass){
            tempReportModel.setScore(100);
            tempReportModel.setDetails("Class: " + file.getName() + " passed Lazy Class");
        }
        else {
            tempReportModel.setScore(0);
            tempReportModel.setDetails("Class: " + file.getName() + " failed Lazy Class");
        }
        return tempReportModel;
    }

    private boolean isSmallClass(ClassModel file){
        boolean isSmallClass = false;
        int roughLineNumber = file.getSourceCode().split("\n").length;

        if (roughLineNumber < LINENUMBER_THRESHOLD){
            isSmallClass = true;
        }
        return isSmallClass;
    }

}
