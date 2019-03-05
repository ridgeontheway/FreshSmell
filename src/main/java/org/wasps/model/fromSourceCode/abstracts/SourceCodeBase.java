package org.wasps.model.fromSourceCode.abstracts;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

public abstract class SourceCodeBase implements ISourceCode {
    // defined here is evey method that is going to function the same way amoungst parsedInterface and parsedClass
    // ex getName() will function the same way
    //todo add methods for methods/instance variable stuff +

    protected String name;
    protected File fileReference;
    protected int lineNumberDefined;
    protected boolean isInner;
    protected ISourceCode parsedEnclosing;
    protected ArrayList<String> implementingOrExtendingInterfaceName;
    protected HashMap<String, ISourceCode> implementingOrExtenignInterfaceReference;

    public SourceCodeBase(File fileReference, int lineNumberDefined){
        this.fileReference = fileReference;
        this.lineNumberDefined = lineNumberDefined;
    }

    public SourceCodeBase(File fileReference){
        this.fileReference = fileReference;
    }

    public String getName(){
        if (name == null){
            throw new NullPointerException("name not set");
        }
        return name;
    }

    public File getFileReference(){
        return fileReference;
    }

    public int getLineNumberDefined(){
        return lineNumberDefined;
    }

    public Boolean isInner(){
        return isInner;
    }

    public ISourceCode getImplementingOrExtenignInterfaceReference(String name){
        if (implementingOrExtenignInterfaceReference == null){
            throw new NullPointerException("implementingOrExtenignInterfaceReference not set");
        }
        if (!implementingOrExtenignInterfaceReference.containsKey(name)){
            return null;
        }
        return implementingOrExtenignInterfaceReference.get(name);
    }

    public void setName(String name){
        this.name = name;
    }

    public void setInner(){
        isInner = true;
    }

    public void setParsedEnclosing(ISourceCode parsedEnclosing) {
        this.parsedEnclosing = parsedEnclosing;
    }

    public void setImplementingOrExtenignInterfaceReferenceName(String name){
        if (implementingOrExtendingInterfaceName == null){
            implementingOrExtendingInterfaceName = new ArrayList<>();
        }
        implementingOrExtendingInterfaceName.add(name);
    }

    public void setImplementingOrExtenignInterfaceReference(ISourceCode parsedInterface){
        if (implementingOrExtenignInterfaceReference == null){
            implementingOrExtenignInterfaceReference = new HashMap<>();
        }
        implementingOrExtenignInterfaceReference.put(parsedInterface.getName(), parsedInterface);
    }
}
