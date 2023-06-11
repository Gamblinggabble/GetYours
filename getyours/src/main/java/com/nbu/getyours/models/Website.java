package com.nbu.getyours.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Website {
    @Id
    private String name;
    private String logoUrl;
    private String baseUrl;

    public Website() {
    }

    public Website(String name, String logoUrl, String baseUrl) {
        this.name = name;
        this.logoUrl = logoUrl;
        this.baseUrl = baseUrl;
    }

    public String getName() {
        return name;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }
}
