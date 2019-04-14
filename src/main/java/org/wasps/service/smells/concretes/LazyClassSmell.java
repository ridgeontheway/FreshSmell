package org.wasps.service.smells.concretes;

import com.thoughtworks.qdox.model.JavaConstructor;
import org.apache.commons.lang3.StringUtils;
import org.wasps.model.ClassModel;
import org.wasps.model.MethodModel;
import org.wasps.model.SmellReportModel;
import org.wasps.service.smells.abstracts.ISmeller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//Class which does not actually do anything (ie functionality is too small to be a class)_
public class LazyClassSmell extends SmellerBase implements ISmeller {

    private final int LINENUMBER_THRESHOLD = 15;

    public LazyClassSmell(int id) {
        super(id);
    }

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
        List<String> filteredReturnTypeList = methodModelList.stream().map(MethodModel::getReturnType).collect(Collectors.toList());
        int numPublicFields = filteredReturnTypeList.stream().filter(v -> v.equalsIgnoreCase("public")).toArray().length;

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
                int numMatches = model.getParameters().stream().filter(javaParameter -> javaParameter.contains(finalFilter[1])).toArray().length;

                if(!model.getName().contains(finalFilter[1]) && (numMatches == 0 || !model.getReturnType().contains(finalFilter[0]))){
                    allFieldsHaveGetterOrSetter = false;
                    break;
                }
            }
        }
        return allFieldsHaveGetterOrSetter;
    }

    private boolean isSmallClass(ClassModel file){
        boolean isSmallClass = false;
        int roughLineNumber = Arrays.asList(file.getSourceCode().split("\n")).stream().filter(value ->
                !StringUtils.isBlank(value) && value.length() > 0).toArray().length;

        if (roughLineNumber < LINENUMBER_THRESHOLD){
            isSmallClass = true;
        }
        return isSmallClass;
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
}
