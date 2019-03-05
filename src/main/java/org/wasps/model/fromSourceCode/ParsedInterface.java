package org.wasps.model.fromSourceCode;

import org.wasps.model.fromSourceCode.abstracts.ISourceCode;
import org.wasps.model.fromSourceCode.abstracts.SourceCodeBase;

import java.io.File;
import java.util.ArrayList;

public class ParsedInterface extends SourceCodeBase {

    public ParsedInterface(File fileRef){
        super(fileRef);
    }

    public ParsedInterface(File fileRef, int lineNumberDefined){
        super(fileRef,lineNumberDefined);
    }

    @Override
    public void setEnclosing(ISourceCode parsedISourceCode) {
        parsedEnclosing = parsedISourceCode;
        setInner();
    }

    @Override
    public void addImplementingOrExtendingInterfaceName(String interfaceName) {
        setImplementingOrExtenignInterfaceReferenceName(interfaceName);
    }

    @Override
    public void addImplementingOrExtenignInterfaceReference(ISourceCode prasedInterface) {
        setImplementingOrExtenignInterfaceReference(prasedInterface);
    }

    @Override
    public ISourceCode getEnclosing() {
        if (parsedEnclosing == null){
            throw new NullPointerException("parsedEnclosing not set");
        }
        return parsedEnclosing;    }

    @Override
    public ArrayList<String> getImplemtnedOrExtendingInterfaceNames() {
        if (implementingOrExtendingInterfaceName == null){
            throw new NullPointerException("implementingOrExtendingInterfaceName not set");
        }
        return implementingOrExtendingInterfaceName;
    }

    @Override
    public File getFileDefined() {
        return fileReference;
    }
}
