package org.wasps.service.smells.concretes;

import org.wasps.model.ClassModel;
import org.wasps.model.MethodModel;
import org.wasps.model.SmellReportModel;
import org.wasps.service.smells.abstracts.ISmeller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//Class whose functionality is too "open" to other classes
public class InappropriateIntimacySmell extends SmellerBase implements ISmeller {

    private final double INTIMACY_THRESHOLD = 0.5;
    private final double PUBLIC_FIELD_THRESHOLD = 0;

    public InappropriateIntimacySmell(int id, String name) {
        super(id, name);
    }

    @Override
    public SmellReportModel smell(ClassModel file) {

        if (file.getFields().size() == 0 || isUnitTestClass(file) || file.isInterface()){
            return setReportModel(true, file);
        }

        SmellReportModel reportModel;
        boolean tooManyPublicFields = majorityPublicFields(file.getFields());
        boolean majorityPublicMethods = majorityPublicMethods(file.getMethods());

        if ((tooManyPublicFields && majorityPublicMethods) || tooManyPublicFields){
            reportModel = setReportModel(false, file);
        }
        else{
            reportModel = setReportModel(true, file);
        }
        return reportModel;
    }

    private boolean majorityPublicMethods(List<MethodModel> methodModelList){
        boolean majorityPublicMethods = false;
        List<String> filteredReturnTypeList = methodModelList.stream().map(MethodModel::getReturnType).collect(Collectors.toList());
        int numPublicFields = filteredReturnTypeList.stream().filter(v -> v.equalsIgnoreCase("public")).toArray().length;

        if (numPublicFields/methodModelList.size() > INTIMACY_THRESHOLD){
            majorityPublicMethods = true;
        }
        return majorityPublicMethods;
    }

    private boolean majorityPublicFields(List<String> fields){
        boolean majorityPublicFields = false;
        List<String[]> filteredList = filterFieldList(fields);
        int numOfPublicFields = filteredList.parallelStream().filter(v -> v[0].equals("public")).toArray().length;

        if (numOfPublicFields > PUBLIC_FIELD_THRESHOLD){
            majorityPublicFields = true;
        }
        return majorityPublicFields;
    }

    private List<String[]> filterFieldList(List<String> fields){
        ArrayList<String[]> filteredList = new ArrayList<>();
        for (String currentField: fields) {
            String[] whiteSpaceRemoval= currentField.trim().split("\\s+");
            String[] finalFilter = {whiteSpaceRemoval[0], whiteSpaceRemoval[whiteSpaceRemoval.length-1]};
            filteredList.add(finalFilter);
        }
        return filteredList;
    }

//    private SmellReportModel setReportModel(boolean pass, ClassModel file){
//        SmellReportModel tempReportModel = new SmellReportModel();
//        tempReportModel.setSmellName("Inappropriate Intimacy");
//
//        if (pass){
//            tempReportModel.setScore(100);
//            tempReportModel.setDetails("Class: " + file.getName() + " passed the Inappropriate Intimacy");
//        }
//        else {
//            tempReportModel.setScore(0);
//            tempReportModel.setDetails("Class: " + file.getName() + " failed the Inappropriate Intimacy");
//        }
//        return tempReportModel;
//    }

    private boolean isUnitTestClass(ClassModel file){
        boolean isUnitTestClass = false;
        CharSequence jUnitImports = "junit";
        CharSequence testClassName = "test";
        CharSequence testClassNameCap = "Test";

        int numJUnutImports = file.getImports().parallelStream()
                .filter(value -> value.contains(jUnitImports)).toArray().length;

        if (numJUnutImports > 1 || file.getName().contains(testClassName) || file.getName().contains(testClassNameCap)){
            isUnitTestClass = true;
        }
        return isUnitTestClass;
    }
}
