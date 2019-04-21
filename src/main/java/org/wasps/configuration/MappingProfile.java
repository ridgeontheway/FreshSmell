package org.wasps.configuration;

import com.thoughtworks.qdox.model.JavaParameter;
import org.wasps.model.*;
import org.wasps.viewmodel.ClassViewModel;
import org.wasps.viewmodel.MethodViewModel;
import org.wasps.viewmodel.ProjectSmellReportViewModel;
import org.wasps.viewmodel.SmellReportViewModel;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MappingProfile {

    // ParsedClass --> ClassModel
    public List<ClassModel> map(List<ParsedClass> filesIn) {
        List<ClassModel> files = new ArrayList<>();
        filesIn.forEach(parsedClass -> files.add(map(parsedClass)));

        return files;
    }

    public ClassModel map(ParsedClass parsedClass) {
        ClassModel file = new ClassModel();
        file.setName(parsedClass.getName());
        file.setPackageName(parsedClass.getPackageName());
        file.setConstructors(parsedClass.getConstructors());
        file.setFields(parsedClass.getFields());
        file.setMethods(mapMethods(parsedClass.getMethods()));
        file.setImports(parsedClass.getParsedJavaClass().getSource().getImports());
        file.setIsInterface(parsedClass.isInterface());
        file.setRawConstructors(parsedClass.getRawConstructors());
        file.setSourceCode(parsedClass.getSourceCode());
        file.setFinal(parsedClass.isFinal());
        file.setAbstract(parsedClass.isAbstract());
        file.setOverallScore(-1.0);

//        System.out.println("Mapped file: " + parsedClass.getName());

        return file;
    }

    private List<MethodModel> mapMethods(List<ParsedMethod> parsedMethods) {
        List<MethodModel> methods = new ArrayList<>();
        parsedMethods.forEach(parsedMethod -> {
            MethodModel method = new MethodModel();
            method.setName(parsedMethod.getName());
            method.setLineLength(parsedMethod.getLineLength());
            method.setParameters(getParametersAsStrings(parsedMethod.getParameters()));
            method.setSourceCode(parsedMethod.getSourceCode());
            method.setReturnType(parsedMethod.getReturnType().getValue());
            method.setProtected(parsedMethod.isProtected());
            method.setAbstract(parsedMethod.isAbstract());
            methods.add(method);
        });
        return methods;
    }

    private List<String> getParametersAsStrings(List<JavaParameter> parametersIn) {
        List<String> parametersOut = new ArrayList<>();
        parametersIn.forEach(parameter -> parametersOut.add(
                String.format("%s %s", parameter.getType().getValue(),
                                        parameter.getName())));
        return parametersOut;
    }

    // Model --> ViewModel
    public ProjectSmellReportViewModel map(ProjectSmellReport report) {
        ProjectSmellReportViewModel viewModel = new ProjectSmellReportViewModel();

        viewModel.setClasses(mapClassViewModel(report.getClasses()));
        viewModel.setFinalScore(String.valueOf(report.getFinalScore()));
        viewModel.setReportMessages(report.getReportMessages());

        return viewModel;
    }

    public SmellReportViewModel mapSmellReportViewModel(SmellReportModel report) {
        SmellReportViewModel viewModel = new SmellReportViewModel();
        viewModel.setSmellName(report.getSmellName());
        viewModel.setDetails(report.getDetails());
        viewModel.setScore(String.valueOf(report.getScore()));

        return viewModel;
    }

    public List<SmellReportViewModel> mapSmellReportViewModel(Collection<SmellReportModel> reports) {
        List<SmellReportViewModel> viewModels = new ArrayList<>();
        for (SmellReportModel report : reports) {
            viewModels.add(mapSmellReportViewModel(report));
        }
        return viewModels;
    }

    public ClassViewModel mapClassViewModel(ClassModel model) {
        ClassViewModel viewModel = new ClassViewModel();
        viewModel.setConstructors(model.getConstructors());
        viewModel.setFailureMessages(model.getFailureMessages());
        viewModel.setFields(model.getFields());
        viewModel.setImports(model.getImports());
        viewModel.setIsAbstract(String.valueOf(model.isAbstract()));
        viewModel.setIsFinal(String.valueOf(model.isFinal()));
        viewModel.setIsInterface(String.valueOf(model.isInterface()));
        viewModel.setMethods(mapMethodViewModel(model.getMethods()));
        viewModel.setName(model.getName());
        viewModel.setOverallScore(String.valueOf(model.getOverallScore()));
        viewModel.setPackageName(model.getPackageName());
        viewModel.setSmellReports(mapSmellReportViewModel(model.getSmellReports().values()));

        return viewModel;
    }

    public List<ClassViewModel> mapClassViewModel(List<ClassModel> models) {
        List<ClassViewModel> viewModels = new ArrayList<>();
        for (ClassModel model : models) {
            viewModels.add(mapClassViewModel(model));
        }
        return viewModels;
    }

    public MethodViewModel mapMethodViewModel(MethodModel model) {
        MethodViewModel viewModel = new MethodViewModel();
        viewModel.setIsAbstract(String.valueOf(model.isAbstract()));
        viewModel.setIsProtected(String.valueOf(model.isProtected()));
        viewModel.setLineLength(String.valueOf(model.getLineLength()));
        viewModel.setName(model.getName());
        viewModel.setParameters(model.getParameters());
        viewModel.setReturnType(model.getReturnType());

        return viewModel;
    }

    public List<MethodViewModel> mapMethodViewModel(List<MethodModel> models) {
        List<MethodViewModel> viewModels = new ArrayList<>();
        for (MethodModel model : models) {
            viewModels.add(mapMethodViewModel(model));
        }
        return viewModels;
    }
}
