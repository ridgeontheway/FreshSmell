package org.wasps.service.abstracts;

import java.net.URL;

public interface IParsingService {
    void setInputSource(URL path);
    String getName();
    void parse();
}
