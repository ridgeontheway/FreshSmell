package org.wasps.data.repository;

import flexjson.JSONSerializer;
import org.wasps.configuration.MappingProfile;
import org.wasps.configuration.ParsingProfile;
import org.wasps.data.repository.abstracts.IFileUtility;
import org.wasps.data.repository.abstracts.IJsonUtility;
import org.wasps.data.repository.concretes.FileUtility;
import org.wasps.data.repository.concretes.JsonUtility;
import org.wasps.data.repository.concretes.ModelRepository;
import org.wasps.data.repository.concretes.ParsedRepository;
import org.wasps.service.abstracts.IFileService;
import org.wasps.service.abstracts.IMappingService;
import org.wasps.service.abstracts.IParsingService;
import org.wasps.service.abstracts.IWorker;
import org.wasps.service.concretes.FileService;
import org.wasps.service.concretes.MappingService;
import org.wasps.service.concretes.ParsingService;
import org.wasps.service.concretes.Worker;
import org.wasps.service.smells.abstracts.ISmeller;
import org.wasps.service.smells.concretes.Smeller;

public abstract class SingletonUtility {
    private static MappingProfile mappingProfile = null;
    private static ParsingProfile parsingProfile = null;
    private static IWorker worker = null;

    // Repositories
    private static ParsedRepository parsedRepository = null;
    private static ModelRepository modelRepository = null;

    // Services
    private static IMappingService mappingService = null;
    private static IParsingService parser = null;
    private static IFileService fileService = null;
    private static ISmeller smeller = null;


    // Utilities
    private static IFileUtility fileUtility = null;
    private static JSONSerializer jsonSerializer = null;
    private static IJsonUtility jsonUtility = null;

    private static final String UPLOAD_DIRECTORY = "/uploads";

    public static synchronized  ParsedRepository getParsedRepository() {
        if (parsedRepository == null) {
            parsedRepository = new ParsedRepository();
        }
        return parsedRepository;
    }

    public static synchronized  ModelRepository getModelRepository() {
        if (modelRepository == null) {
            modelRepository = new ModelRepository();
        }
        return modelRepository;
    }

    public static synchronized MappingProfile getMappingProfile() {
        if (mappingProfile == null) {
            mappingProfile = new MappingProfile();
        }
        return mappingProfile;
    }

    public static synchronized ParsingProfile getParsingProfile() {
        if (parsingProfile == null) {
            parsingProfile = new ParsingProfile();
        }
        return parsingProfile;
    }

    public static synchronized IMappingService getMappingService() {
        if (mappingService == null) {
            mappingService = new MappingService();
        }
        return mappingService;
    }

    public static synchronized ISmeller getSmeller() {
        if (smeller == null) {
            smeller = new Smeller();
        }
        return smeller;
    }

    public static synchronized IParsingService getParser() {
        if (parser == null) {
            parser = new ParsingService();
        }
        return parser;
    }

    public static synchronized IFileUtility getFileUtility() {
        if (fileUtility == null) {
            fileUtility = new FileUtility(UPLOAD_DIRECTORY);
        }
        return fileUtility;
    }

    public static synchronized JSONSerializer getJsonSerializer() {
        if (jsonSerializer == null) {
            jsonSerializer = new JSONSerializer();
        }
        return jsonSerializer;
    }

    public static synchronized IJsonUtility getJson() {
        if (jsonUtility == null) {
            jsonUtility = new JsonUtility();
        }
        return jsonUtility;
    }

    public static synchronized IFileService getFileService() {
        if (fileService == null) {
            fileService = new FileService();
        }
        return fileService;
    }

    public static synchronized IWorker getWorker() {
        if (worker == null) {
            worker = new Worker();
        }
        return worker;
    }
}
