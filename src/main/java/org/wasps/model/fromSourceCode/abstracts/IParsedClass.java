package org.wasps.model.fromSourceCode.abstracts;

import com.thoughtworks.qdox.model.JavaClass;
import com.thoughtworks.qdox.model.JavaMethod;
import org.wasps.model.fromSourceCode.ParsedMethod;

import java.util.List;

public interface IParsedClass {
    List<ParsedMethod> getParsedMethodList();
    JavaClass getParsedJavaClass();
}
