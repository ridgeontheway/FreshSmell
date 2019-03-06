package org.wasps.model.fromSourceCode;

import org.wasps.model.fromSourceCode.abstracts.SourceCodeBase;

public class ParsedInterface extends SourceCodeBase {
    @Override
    public String sayHelloSpecific() {
        return "Interface";
    }
}
