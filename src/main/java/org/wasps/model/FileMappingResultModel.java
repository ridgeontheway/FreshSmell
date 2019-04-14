package org.wasps.model;

import java.util.List;

public class FileMappingResultModel {
    private String resultMessage;
    private List<ClassModel> uploads;

    public String getResultMessage() {
        return resultMessage;
    }

    public void setResultMessage(String resultMessage) {
        this.resultMessage = resultMessage;
    }

    public List<ClassModel> getUploads() {
        return uploads;
    }

    public void setUploads(List<ClassModel> uploads) {
        this.uploads = uploads;
    }
}
