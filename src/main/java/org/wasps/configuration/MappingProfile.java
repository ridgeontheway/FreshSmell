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

    public FileModel map(ParsedFile fileIn) {
        
    }

    public Iterable<MethodModel> mapMethods(Method[] methodsIn) { //todo get the line num
        ArrayList<MethodModel> methodsOut = new ArrayList<>();
        for (Method m : methodsIn) {
            methodsOut.add(mapMethod(m));
        }
        return methodsOut;
    }

}
