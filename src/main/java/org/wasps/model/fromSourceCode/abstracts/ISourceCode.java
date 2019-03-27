package org.wasps.model.fromSourceCode.abstracts;


import java.io.File;
import java.util.ArrayList;

public interface ISourceCode {
    // defines all the outward facing functions that ParsedClass and ParsedInerface, note that this should also include everything in SourceCodeBase
    //todo need to include method/obj get/set

    void setName(String name);
    void setInner();
    void setEnclosing(ISourceCode parsedISourceCode);
    void addImplementingOrExtendingInterfaceName(String interfaceName);
    void addImplementingOrExtenignInterfaceReference(ISourceCode prasedInterface);

    String getName();
    Boolean isInner();
    ISourceCode getEnclosing();
    ArrayList<String> getImplemtnedOrExtendingInterfaceNames();
    int getLineNumberDefined();
    File getFileDefined();
}
