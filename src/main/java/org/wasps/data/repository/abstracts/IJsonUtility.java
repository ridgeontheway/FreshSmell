package org.wasps.data.repository.abstracts;

import org.wasps.model.ParsedDirectory;

import java.util.List;

public interface IJsonUtility {
    void addFileToList(ParsedDirectory parsedDirectory);
    List<ParsedDirectory> getFiles();
    void writeFilesToJson();
    List<ParsedDirectory> getFilesFromJson();
}
