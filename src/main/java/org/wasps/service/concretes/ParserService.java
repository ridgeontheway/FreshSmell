package org.wasps.service.concretes;

import com.thoughtworks.qdox.JavaProjectBuilder;
import com.thoughtworks.qdox.model.JavaClass;
import com.thoughtworks.qdox.model.JavaSource;
import org.wasps.model.ParsedDirectory;
import org.wasps.model.fromSourceCode.ParsedClass;
import org.wasps.service.abstracts.ISourceCodeParserService;

import java.io.File;
import java.util.Collection;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ParserService implements ISourceCodeParserService {

    private ParsedDirectory parsedDirectory;
    private boolean alreadyExecuted;

    public ParserService(){
        alreadyExecuted = false;
        parsedDirectory = new ParsedDirectory();
    }

    @Override
    public void loadInDirectory(String pathName) throws Exception{
        singleUseCheck();
        JavaProjectBuilder direcoryBuilder = new JavaProjectBuilder();
        direcoryBuilder.addSourceTree(new File(pathName));
        parseDirectory(direcoryBuilder);
    }

    private void parseDirectory(JavaProjectBuilder builder){
        Collection<JavaSource> javaSources = builder.getSources();

        for (JavaSource currentJavaSource: javaSources){
            for (JavaClass currentJavaClass : currentJavaSource.getClasses()){
                parsedDirectory.insertParsedClass(new ParsedClass(currentJavaClass));
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
    public ParsedDirectory getParsedDirectory() {
        return parsedDirectory;
    }
}
