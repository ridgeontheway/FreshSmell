package Main.abstracts;

import java.lang.reflect.Method;

public interface IInspector {
    int getNumPrimitiveMethods(Class host);

    int getNumPrimitiveFields(Class host);

    int getNumPrimitiveParameters(Method host);

    int getNumPrivateMethods(Class host);

    int getNumPublicMethods(Class host);
}
