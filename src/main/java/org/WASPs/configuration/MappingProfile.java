package org.wasps.configuration;

import org.wasps.model.MethodModel;
import org.wasps.model.SourceFile;

import java.lang.reflect.Method;
import java.util.ArrayList;

public class MappingProfile {
    public MethodModel mapMethod(Method methodIn) {
        MethodModel methodOut = new MethodModel();
        methodOut.setName(methodIn.getName());
        methodOut.setParameterCount(methodIn.getParameterCount());

        return methodOut;
    }

    public Iterable<MethodModel> mapMethods(Method[] methodsIn) {
        ArrayList<MethodModel> methodsOut = new ArrayList<>();
        for (Method m : methodsIn) {
            methodsOut.add(mapMethod(m));
        }
        return methodsOut;
    }

    public SourceFile map(Class classIn) {
        SourceFile classOut = new SourceFile();
        classOut.setName(classIn.getName());
        // TODO: Add the rest of the mappings
T        return classOut;
    }
}
