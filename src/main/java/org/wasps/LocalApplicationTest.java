package org.wasps;

import org.wasps.configuration.MappingProfile;
import org.wasps.data.repository.abstracts.IDataStore;
import org.wasps.data.repository.concretes.DataStore;
import org.wasps.model.FileModel;
import org.wasps.model.ParsedClass;
import org.wasps.service.abstracts.IFileService;
import org.wasps.service.abstracts.IParsingService;
import org.wasps.service.concretes.FileService;
import org.wasps.service.concretes.ParsingService;

import java.util.ArrayList;
import java.util.List;

// This class is to test any functionality locally
// This should be run as a separate, regular Application run configuration
// Before running, exclude testfiles directory from build
//      Right click on data/testfiles/ | Mark Directory As | Excluded
public class LocalApplicationTest {
    private static String _path = String.format("%s/src/main/java/org/wasps/data", System.getProperty("user.dir"));
    private static IParsingService _parser = new ParsingService();
    private static IFileService _fileService = new FileService();
    private static IDataStore _data = new DataStore();
    private static List<FileModel> _files = new ArrayList<>();

    public static void main(String[] args) {
        setup();
        _files.forEach(file -> System.out.println(file.getName()));

    }

    public static void setup() {
        MappingProfile _profile = new MappingProfile();
        try {
            List<ParsedClass> _parsedClasses = _parser.parse(_path);
            _files.addAll(_profile.map(_parsedClasses));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
