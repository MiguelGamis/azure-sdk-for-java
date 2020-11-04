// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.ai.textanalytics.implementation.models;

import com.azure.core.annotation.Fluent;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/**
 * The LinkedEntity model.
 */
@Fluent
public final class LinkedEntity {
    /*
     * Entity Linking formal name.
     */
    @JsonProperty(value = "name", required = true)
    private String name;

    /*
     * List of instances this entity appears in the text.
     */
    @JsonProperty(value = "matches", required = true)
    private List<Match> matches;

    /*
     * Language used in the data source.
     */
    @JsonProperty(value = "language", required = true)
    private String language;

    /*
     * Unique identifier of the recognized entity from the data source.
     */
    @JsonProperty(value = "id")
    private String id;

    /*
     * URL for the entity's page from the data source.
     */
    @JsonProperty(value = "url", required = true)
    private String url;

    /*
     * Data source used to extract entity linking, such as Wiki/Bing etc.
     */
    @JsonProperty(value = "dataSource", required = true)
    private String dataSource;

    /*
     * Bing Entity Search API unique identifier of the recognized entity.
     */
    @JsonProperty(value = "bingId")
    private String bingId;

    /**
     * Get the name property: Entity Linking formal name.
     * 
     * @return the name value.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Set the name property: Entity Linking formal name.
     * 
     * @param name the name value to set.
     * @return the LinkedEntity object itself.
     */
    public LinkedEntity setName(String name) {
        this.name = name;
        return this;
    }

    /**
     * Get the matches property: List of instances this entity appears in the
     * text.
     * 
     * @return the matches value.
     */
    public List<Match> getMatches() {
        return this.matches;
    }

    /**
     * Set the matches property: List of instances this entity appears in the
     * text.
     * 
     * @param matches the matches value to set.
     * @return the LinkedEntity object itself.
     */
    public LinkedEntity setMatches(List<Match> matches) {
        this.matches = matches;
        return this;
    }

    /**
     * Get the language property: Language used in the data source.
     * 
     * @return the language value.
     */
    public String getLanguage() {
        return this.language;
    }

    /**
     * Set the language property: Language used in the data source.
     * 
     * @param language the language value to set.
     * @return the LinkedEntity object itself.
     */
    public LinkedEntity setLanguage(String language) {
        this.language = language;
        return this;
    }

    /**
     * Get the id property: Unique identifier of the recognized entity from the
     * data source.
     * 
     * @return the id value.
     */
    public String getId() {
        return this.id;
    }

    /**
     * Set the id property: Unique identifier of the recognized entity from the
     * data source.
     * 
     * @param id the id value to set.
     * @return the LinkedEntity object itself.
     */
    public LinkedEntity setId(String id) {
        this.id = id;
        return this;
    }

    /**
     * Get the url property: URL for the entity's page from the data source.
     * 
     * @return the url value.
     */
    public String getUrl() {
        return this.url;
    }

    /**
     * Set the url property: URL for the entity's page from the data source.
     * 
     * @param url the url value to set.
     * @return the LinkedEntity object itself.
     */
    public LinkedEntity setUrl(String url) {
        this.url = url;
        return this;
    }

    /**
     * Get the dataSource property: Data source used to extract entity linking,
     * such as Wiki/Bing etc.
     * 
     * @return the dataSource value.
     */
    public String getDataSource() {
        return this.dataSource;
    }

    /**
     * Set the dataSource property: Data source used to extract entity linking,
     * such as Wiki/Bing etc.
     * 
     * @param dataSource the dataSource value to set.
     * @return the LinkedEntity object itself.
     */
    public LinkedEntity setDataSource(String dataSource) {
        this.dataSource = dataSource;
        return this;
    }

    /**
     * Get the bingId property: Bing Entity Search API unique identifier of the
     * recognized entity.
     * 
     * @return the bingId value.
     */
    public String getBingId() {
        return this.bingId;
    }

    /**
     * Set the bingId property: Bing Entity Search API unique identifier of the
     * recognized entity.
     * 
     * @param bingId the bingId value to set.
     * @return the LinkedEntity object itself.
     */
    public LinkedEntity setBingId(String bingId) {
        this.bingId = bingId;
        return this;
    }
}
