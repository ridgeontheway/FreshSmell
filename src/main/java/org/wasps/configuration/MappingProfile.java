package org.wasps.configuration;

import org.wasps.model.MethodModel;
import org.wasps.model.SourceFile;
import org.wasps.service.abstracts.IParsingService;

import java.lang.reflect.Method;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MappingProfile {
    private IParsingService _parser;


    public MappingProfile(IParsingService parser) {
        _parser = parser;

    }

    public MethodModel mapMethod(Method methodIn) {
        MethodModel methodOut = new MethodModel();
        methodOut.setName(methodIn.getName());
        methodOut.setParameterCount(methodIn.getParameterCount());

        return methodOut;
    }

    public SourceFile map(URL path) {
        SourceFile classOut = new SourceFile();
        _parser.setInputSource(path);

        // TODO: Add the mappings
        /*
            Anything we get from source code most go through ISourceCodeParserService
         */
        classOut.setName(_parser.getName());

        return classOut;
    }

    public List<MethodModel> mapMethods(Method[] methodsIn) {
        ArrayList<MethodModel> methodsOut = new ArrayList<>();
        for (Method m : methodsIn) {
            methodsOut.add(mapMethod(m));
        }
        return methodsOut;
    }
}
