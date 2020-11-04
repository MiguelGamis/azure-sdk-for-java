// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.ai.textanalytics.implementation.models;

import com.azure.core.annotation.Fluent;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The JobDescriptor model.
 */
@Fluent
public class JobDescriptor {
    /*
     * Optional display name for the analysis job.
     */
    @JsonProperty(value = "displayName")
    private String displayName;

    /**
     * Get the displayName property: Optional display name for the analysis
     * job.
     * 
     * @return the displayName value.
     */
    public String getDisplayName() {
        return this.displayName;
    }

    /**
     * Set the displayName property: Optional display name for the analysis
     * job.
     * 
     * @param displayName the displayName value to set.
     * @return the JobDescriptor object itself.
     */
    public JobDescriptor setDisplayName(String displayName) {
        this.displayName = displayName;
        return this;
    }
}
