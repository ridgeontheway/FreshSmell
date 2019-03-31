package org.wasps.model.fromSourceCode.abstracts;

import com.thoughtworks.qdox.model.JavaMethod;

public interface IParsedMethod {
    int getLineLength();
    JavaMethod getParsedMethod();
}
