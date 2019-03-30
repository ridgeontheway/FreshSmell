package org.wasps.model.fromSourceCode;

import com.thoughtworks.qdox.model.JavaMethod;
import org.apache.commons.lang3.StringUtils;
import org.wasps.model.fromSourceCode.abstracts.IParsedMethod;

import java.lang.reflect.Array;
import java.util.ArrayList;
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
        String[] tempArr = parsedMethod.getSourceCode().split("\n");
        //removing whitespace
        tempArr = Arrays.stream(tempArr)
                .filter(value ->
                        !StringUtils.isBlank(value) && value.length() > 0)
                .toArray(size -> new String[size]);
        this.lineLength = tempArr.length;
    }

    public int getLineLength() {
        return lineLength;
    }

    public JavaMethod getParsedMethod() {
        return parsedMethod;
    }
}
