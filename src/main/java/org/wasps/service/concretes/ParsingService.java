package org.wasps.service.concretes;

import com.thoughtworks.qdox.JavaProjectBuilder;
import com.thoughtworks.qdox.model.JavaClass;
import com.thoughtworks.qdox.model.JavaSource;
import org.wasps.model.fromSourceCode.ParsedClass;
import org.wasps.service.abstracts.IParsingService;

import java.io.File;
import java.util.Collection;
import java.util.List;

public class ParsingService extends ServiceBase implements IParsingService {

    private boolean alreadyExecuted;

    public ParsingService(){
        alreadyExecuted = false;
    }

    private JavaProjectBuilder loadInDirectory(String pathName) throws Exception{
        JavaProjectBuilder direcoryBuilder = new JavaProjectBuilder();
        direcoryBuilder.addSourceTree(new File(pathName));
        return direcoryBuilder;
    }

    private void parseDirectory(JavaProjectBuilder builder){
        Collection<JavaSource> javaSources = builder.getSources();

        for (JavaSource currentJavaSource: javaSources){
            for (JavaClass currentJavaClass : currentJavaSource.getClasses()){
                _dataStore.parsed().insert(new ParsedClass(currentJavaClass));
            }
        }
    }

    private synchronized void singleUseCheck() throws Exception {
        if (alreadyExecuted){
            throw new Exception("parseDirectory may only be called once!");
        }
        alreadyExecuted = true;
    }

    @Override
    public List<ParsedClass> get() {
        return _dataStore.parsed().getAll();
    }

    @Override
    public List<ParsedClass> parse(String pathName) throws Exception {
        singleUseCheck();
        JavaProjectBuilder directory = loadInDirectory(pathName);
        parseDirectory(directory);
        return _dataStore.parsed().getAll();
    }
}
