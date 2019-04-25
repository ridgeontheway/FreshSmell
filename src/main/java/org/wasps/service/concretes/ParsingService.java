package org.wasps.service.concretes;

import com.thoughtworks.qdox.JavaProjectBuilder;
import com.thoughtworks.qdox.model.JavaClass;
import com.thoughtworks.qdox.model.JavaSource;
import org.wasps.configuration.ParsingProfile;
import org.wasps.data.SingletonUtility;
import org.wasps.model.ParsedClass;
import org.wasps.service.abstracts.IParsingService;

import java.io.File;
import java.util.Collection;
import java.util.List;

public class ParsingService extends ServiceBase implements IParsingService {
    private ParsingProfile _parser;

    public ParsingService(){
        _parser = SingletonUtility.getParsingProfile();
    }

    @Override
    public List<ParsedClass> get() {
        return _dataStore.parsed().get();
    }

    @Override
    public List<ParsedClass> parse(String pathName) {
        JavaProjectBuilder directory = loadInDirectory(pathName);
        parseDirectory(directory);
        return _dataStore.parsed().get();
    }

    public JavaProjectBuilder loadInDirectory(String pathName) {
        JavaProjectBuilder direcoryBuilder = new JavaProjectBuilder();
        direcoryBuilder.addSourceTree(new File(pathName));
        return direcoryBuilder;
    }

    private void parseDirectory(JavaProjectBuilder builder){
        Collection<JavaSource> javaSources = builder.getSources();

        for (JavaSource currentJavaSource: javaSources){
            for (JavaClass currentJavaClass : currentJavaSource.getClasses()){
                _dataStore.parsed().insert(_parser.parse(currentJavaClass));
            }
        }
    }

    @Override
    public void delete() { _dataStore.parsed().delete(); }
}
