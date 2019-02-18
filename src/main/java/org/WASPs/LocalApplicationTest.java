package org.wasps;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.wasps.configuration.MappingProfile;
import org.wasps.model.SourceFile;
import org.wasps.service.concretes.LocalClassLoader;

// This class is to test any functionality locally
// This should be run as a separate, regular Application run configuration
public class LocalApplicationTest {
    public static void main(String[] args) {
        LocalClassLoader loader = new LocalClassLoader(new MappingProfile(), new ObjectMapper());

        SourceFile source = loader.loadClass();
        loader.writeToJson(source);
    }
}
