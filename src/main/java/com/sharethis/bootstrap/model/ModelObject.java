package com.sharethis.bootstrap.model;

import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@JsonAutoDetect
@JsonSerialize(include= JsonSerialize.Inclusion.NON_NULL)
public class ModelObject {

    private String originalString;
    private String sugaredString;

    public String getOriginalString() {
        return originalString;
    }

    public void setOriginalString(String originalString) {
        this.originalString = originalString;
    }

    public String getSugaredString() {
        return sugaredString;
    }

    public void setSugaredString(String sugaredString) {
        this.sugaredString = sugaredString;
    }
}
