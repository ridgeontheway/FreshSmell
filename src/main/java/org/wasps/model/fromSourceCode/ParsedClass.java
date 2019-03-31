package org.wasps.model.fromSourceCode;

import com.thoughtworks.qdox.model.JavaClass;
import com.thoughtworks.qdox.model.JavaMethod;
import org.wasps.model.fromSourceCode.abstracts.IParsedClass;

import java.util.ArrayList;
import java.util.List;

public class ParsedClass implements IParsedClass {

    private List<ParsedMethod> parsedMethodList;
    private JavaClass parsedJavaClass;

    public ParsedClass(JavaClass javaClass){
        parsedMethodList = new ArrayList<>();
        this.parsedJavaClass = javaClass;
        instantiateParsedMethods(parsedJavaClass.getMethods());
    }

    private void instantiateParsedMethods(List<JavaMethod> currentMethods){
        for (JavaMethod currentMethod: currentMethods) {
            parsedMethodList.add(new ParsedMethod(currentMethod));
        }
    }

    public List<ParsedMethod> getParsedMethodList() {
        return parsedMethodList;
    }

    public JavaClass getParsedJavaClass() {
        return parsedJavaClass;
    }
}
