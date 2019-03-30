package org.wasps.model.fromSourceCode;

import com.thoughtworks.qdox.model.JavaMethod;
import org.apache.commons.lang3.StringUtils;
import org.wasps.model.fromSourceCode.abstracts.IParsedMethod;
import java.util.Arrays;
import java.util.List;

public class ParsedMethod implements IParsedMethod {

    private JavaMethod parsedMethod;
    private int lineLength;

    public ParsedMethod(JavaMethod parsedJavaMethod){
        this.parsedMethod = parsedJavaMethod;
        FindLineLength();
    }

    private void FindLineLength(){
        List<String> methodBody = Arrays.asList(parsedMethod.getSourceCode().split("\n"));
        //removing whitespace
        this.lineLength = methodBody.parallelStream()
                .filter(value ->
                        !StringUtils.isBlank(value) && value.length() > 0)
                .toArray(size -> new String[size]).length;
    }

    public int getLineLength() {
        return lineLength;
    }

    public JavaMethod getParsedMethod() {
        return parsedMethod;
    }
}
