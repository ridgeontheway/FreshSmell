package org.wasps.service.abstracts;

import org.wasps.model.SourceFile;

public interface IClassLoader {
    SourceFile loadClass(Class objectClass);
}
