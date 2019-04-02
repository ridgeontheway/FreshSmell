package org.wasps;

import org.wasps.configuration.MappingProfile;
import org.wasps.data.repository.abstracts.IDataStore;
import org.wasps.data.repository.concretes.DataStore;
import org.wasps.model.ClassModel;
import org.wasps.model.ParsedClass;
import org.wasps.model.SmellReportModel;
import org.wasps.service.abstracts.IFileService;
import org.wasps.service.abstracts.IParsingService;
import org.wasps.service.concretes.FileService;
import org.wasps.service.concretes.ParsingService;
import org.wasps.service.smells.abstracts.ISmellerService;
import org.wasps.service.smells.concretes.SmellerService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

// This class is to test any functionality locally
// This should be run as a separate, regular Application run configuration
// Before running, exclude testfiles directory from build
//      Right click on data/testfiles/ | Mark Directory As | Excluded
public class LocalApplicationTest {
    private static String _path = String.format("%s/src/main/java/org/wasps/data", System.getProperty("user.dir"));
    private static IParsingService _parser = new ParsingService();
    private static IFileService _fileService = new FileService();
    private static IDataStore _data = new DataStore();
    private static List<ClassModel> _files = new ArrayList<>();
    private static ISmellerService smellerService;

    public static void main(String[] args) {
        setup();
        runSmells();
        print();
    }

    public static void setup() {
        smellerService = new SmellerService();

        MappingProfile _profile = new MappingProfile();
        try {
            List<ParsedClass> _parsedClasses = _parser.parse(_path);
            _files.addAll(_profile.map(_parsedClasses));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void runSmells() {
        _files.forEach(file ->
                file.addSmellReports(smellerService.performSmells(file)));
    }

    public static void print() {
        _files.forEach(file -> {
            System.out.println("------------------------------------------------------------\n" + file.getName());
            for(Map.Entry<String, SmellReportModel> entry : file.getSmellReports().entrySet()) {
                System.out.printf("%s\n\t%-25s%-10s%s\n\t%s\n" +
                                    "\t%-25s%-10s%s\n",
                        "------------------------------------------------------------",
                        "Smell Name", "Score", "Details",
                        "-------------------------------------------",
                        entry.getValue().getSmellName(),
                        entry.getValue().getScore(),
                        entry.getValue().getDetails());
            }
        });
    }
}
