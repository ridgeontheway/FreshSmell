package org.wasps.service.smells.concretes;

import org.wasps.model.ClassModel;
import org.wasps.model.MethodModel;
import org.wasps.model.SmellReportModel;
import org.wasps.service.smells.abstracts.ISmeller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

//Class which relies too much on functionality of another class (in this case it is checking for classes in another package)
public class FeatureEnvySmell extends SmellerBase implements ISmeller {

    private final double ENVYVALUE = 0.5;

    public FeatureEnvySmell(int id, String name) {
        super(id, name);
    }

    @Override
    public SmellReportModel smell(ClassModel file) {
        List<MethodModel> methodModels = file.getMethods();
        List<CharSequence> uniqueImports = filterImportStatements(file.getImports());
        SmellReportModel reportModel;

        ArrayList<Boolean> results = new ArrayList<>();
        for (MethodModel currentMethod: methodModels) {
            results.add(checkMethod(currentMethod, uniqueImports));
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

    //todo only works with classes that are outside the package it's currently in, may need to change this for later
    private boolean checkMethod(MethodModel currentMethod, List<CharSequence> externalClassReferences){
        List<String> sourceCode = filterSourceCode(currentMethod.getSourceCode());
        HashMap<CharSequence, String> externalClassLoopUp = new HashMap<>();
        HashMap<CharSequence, Integer> numExernalStaticClassesDefined = new HashMap<>();
        HashMap<CharSequence, Integer> numExternalClassActions = new HashMap<>();

        for (String line: sourceCode) {
            List<String> splitLine = Arrays.asList(line.trim().split("\\s+"));
            boolean initialized = false;

            // check to see if we are looking in the
            for (CharSequence currentImport: externalClassReferences) {
                if (line.contains(currentImport)){

                    if (externalClassLoopUp.containsKey(currentImport)){
                        int numInstances = numExernalStaticClassesDefined.get(currentImport) + 1;
                        numExernalStaticClassesDefined.replace(currentImport, numInstances);
                    }
                    else{
                        String tempObjectName = splitLine.get(splitLine.indexOf(currentImport.toString())+1);
                        externalClassLoopUp.put(currentImport, tempObjectName);
                        numExternalClassActions.put(tempObjectName, 1);
                        numExernalStaticClassesDefined.put(currentImport, 0);
                        initialized = true;
                    }
                    break;
                }
            }

            if (!initialized){
                for(CharSequence currentExternalObjectReference: numExternalClassActions.keySet()){
                    if (line.contains(currentExternalObjectReference)){
                        int newValue = numExternalClassActions.get(currentExternalObjectReference)+1;
                        numExternalClassActions.replace(currentExternalObjectReference, newValue);
                        break;
                    }
                }
            }
        }
        return hashMapsPercentages(numExernalStaticClassesDefined, numExternalClassActions, sourceCode.size());

    }

    private boolean hashMapsPercentages(HashMap<CharSequence, Integer> numExternalClassesDefined,
                                        HashMap<CharSequence, Integer> numberExternalClassActions, int lineLength){
        boolean testResult = true;
        //in the case of a static class, we will have one more value then we should have
        for (CharSequence objectOrClassName: numberExternalClassActions.keySet()) {
            if(numExternalClassesDefined.containsKey(objectOrClassName) &&
                    numExternalClassesDefined.get(objectOrClassName) > 0){
                int numberExternalClassActionsValue = numberExternalClassActions.get(objectOrClassName) - 1;
                numberExternalClassActions.replace(objectOrClassName, numberExternalClassActionsValue);
            }
        }

        int numberExternalClassedDefinedValues = numExternalClassesDefined.values().stream().mapToInt(i -> i).sum();
        int numberExternalClassActionsValues = numberExternalClassActions.values().stream().mapToInt(i -> i).sum();
        int totalNumberOfExternalReferences = numberExternalClassActionsValues + numberExternalClassedDefinedValues;

        if (lineLength > 0 && totalNumberOfExternalReferences/lineLength > ENVYVALUE){
            testResult = false;
        }
        return testResult;
    }

    private List<CharSequence> filterImportStatements(List<String> importStatements){
        CharSequence javaLangImports = "java.";
        CharSequence jUnitImports = "junit";

        List<String> javaLibrarysRemoved =  importStatements.parallelStream()
                .filter(value -> !value.contains(javaLangImports) && !value.contains(jUnitImports))
                .collect(Collectors.toList());


        ArrayList<CharSequence> filteredList = new ArrayList<>();
        for (String currentFilteredImport: javaLibrarysRemoved) {
            String[] currentUniqueImportLine = currentFilteredImport.split("\\.");
            if (currentUniqueImportLine.length > 1){
                String steralizedCurrentUniqueImport = currentUniqueImportLine[currentUniqueImportLine.length-1];
                filteredList.add(steralizedCurrentUniqueImport);
            }
        }
        return filteredList;
    }

    private List<String> filterSourceCode(List<String> source){
        CharSequence openCurly = "{";
        CharSequence closeCurly = "}";
        //Filtering the list further, at this point we only have the assignments
        return source.parallelStream()
                .filter(value -> !value.contains(openCurly) && !value.contains(closeCurly))
                .collect(Collectors.toList());
    }
}
