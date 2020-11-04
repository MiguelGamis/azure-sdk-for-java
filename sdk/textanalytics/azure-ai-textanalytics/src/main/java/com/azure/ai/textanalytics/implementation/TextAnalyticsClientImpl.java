// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.ai.textanalytics.implementation;

import com.azure.ai.textanalytics.implementation.models.AnalyzeBatchInput;
import com.azure.ai.textanalytics.implementation.models.AnalyzeJobState;
import com.azure.ai.textanalytics.implementation.models.AnalyzeResponse;
import com.azure.ai.textanalytics.implementation.models.CancelHealthJobResponse;
import com.azure.ai.textanalytics.implementation.models.EntitiesResult;
import com.azure.ai.textanalytics.implementation.models.EntityLinkingResult;
import com.azure.ai.textanalytics.implementation.models.ErrorResponseException;
import com.azure.ai.textanalytics.implementation.models.HealthcareJobState;
import com.azure.ai.textanalytics.implementation.models.HealthResponse;
import com.azure.ai.textanalytics.implementation.models.KeyPhraseResult;
import com.azure.ai.textanalytics.implementation.models.LanguageBatchInput;
import com.azure.ai.textanalytics.implementation.models.LanguageResult;
import com.azure.ai.textanalytics.implementation.models.MultiLanguageBatchInput;
import com.azure.ai.textanalytics.implementation.models.PiiResult;
import com.azure.ai.textanalytics.implementation.models.SentimentResponse;
import com.azure.ai.textanalytics.implementation.models.StringIndexType;
import com.azure.core.annotation.BodyParam;
import com.azure.core.annotation.Delete;
import com.azure.core.annotation.ExpectedResponses;
import com.azure.core.annotation.Get;
import com.azure.core.annotation.Host;
import com.azure.core.annotation.HostParam;
import com.azure.core.annotation.PathParam;
import com.azure.core.annotation.Post;
import com.azure.core.annotation.QueryParam;
import com.azure.core.annotation.ReturnType;
import com.azure.core.annotation.ServiceInterface;
import com.azure.core.annotation.ServiceMethod;
import com.azure.core.annotation.UnexpectedResponseExceptionType;
import com.azure.core.http.HttpPipeline;
import com.azure.core.http.HttpPipelineBuilder;
import com.azure.core.http.policy.CookiePolicy;
import com.azure.core.http.policy.RetryPolicy;
import com.azure.core.http.policy.UserAgentPolicy;
import com.azure.core.http.rest.RestProxy;
import com.azure.core.http.rest.SimpleResponse;
import com.azure.core.util.Context;
import com.azure.core.util.FluxUtil;
import java.util.UUID;
import reactor.core.publisher.Mono;

/**
 * Initializes a new instance of the TextAnalyticsClient type.
 */
public final class TextAnalyticsClientImpl {
    /**
     * The proxy service used to perform REST calls.
     */
    private final TextAnalyticsClientService service;

    /**
     * Supported Cognitive Services endpoints (protocol and hostname, for example: https://westus.api.cognitive.microsoft.com).
     */
    private String endpoint;

    /**
     * Gets Supported Cognitive Services endpoints (protocol and hostname, for example: https://westus.api.cognitive.microsoft.com).
     * 
     * @return the endpoint value.
     */
    public String getEndpoint() {
        return this.endpoint;
    }

    /**
     * Sets Supported Cognitive Services endpoints (protocol and hostname, for example: https://westus.api.cognitive.microsoft.com).
     * 
     * @param endpoint the endpoint value.
     * @return the service client itself.
     */
    public TextAnalyticsClientImpl setEndpoint(String endpoint) {
        this.endpoint = endpoint;
        return this;
    }

    /**
     * The HTTP pipeline to send requests through.
     */
    private final HttpPipeline httpPipeline;

    /**
     * Gets The HTTP pipeline to send requests through.
     * 
     * @return the httpPipeline value.
     */
    public HttpPipeline getHttpPipeline() {
        return this.httpPipeline;
    }

    /**
     * Initializes an instance of TextAnalyticsClient client.
     */
    public TextAnalyticsClientImpl() {
        this(new HttpPipelineBuilder().policies(new UserAgentPolicy(), new RetryPolicy(), new CookiePolicy()).build());
    }

    /**
     * Initializes an instance of TextAnalyticsClient client.
     * 
     * @param httpPipeline The HTTP pipeline to send requests through.
     */
    public TextAnalyticsClientImpl(HttpPipeline httpPipeline) {
        this.httpPipeline = httpPipeline;
        this.service = RestProxy.create(TextAnalyticsClientService.class, this.httpPipeline);
    }

    /**
     * The interface defining all the services for TextAnalyticsClient to be
     * used by the proxy service to perform REST calls.
     */
    @Host("{Endpoint}/text/analytics/v3.1-preview.3")
    @ServiceInterface(name = "TextAnalyticsClient")
    private interface TextAnalyticsClientService {
        @Post("/analyze")
        @ExpectedResponses({202})
        @UnexpectedResponseExceptionType(ErrorResponseException.class)
        Mono<AnalyzeResponse> analyze(@HostParam("Endpoint") String endpoint, @BodyParam("application/json") AnalyzeBatchInput body, Context context);

        @Get("/analyze/jobs/{jobId}")
        @ExpectedResponses({200})
        @UnexpectedResponseExceptionType(ErrorResponseException.class)
        Mono<SimpleResponse<AnalyzeJobState>> analyzeStatus(@HostParam("Endpoint") String endpoint, @PathParam("jobId") UUID jobId, @QueryParam("showStats") Boolean showStats, @QueryParam("$top") Integer top, @QueryParam("$skip") Integer skip, Context context);

        @Get("/entities/health/jobs/{jobId}")
        @ExpectedResponses({200})
        @UnexpectedResponseExceptionType(ErrorResponseException.class)
        Mono<SimpleResponse<HealthcareJobState>> healthStatus(@HostParam("Endpoint") String endpoint, @PathParam("jobId") UUID jobId, @QueryParam("$top") Integer top, @QueryParam("$skip") Integer skip, @QueryParam("showStats") Boolean showStats, Context context);

        @Delete("/entities/health/jobs/{jobId}")
        @ExpectedResponses({202})
        @UnexpectedResponseExceptionType(ErrorResponseException.class)
        Mono<CancelHealthJobResponse> cancelHealthJob(@HostParam("Endpoint") String endpoint, @PathParam("jobId") UUID jobId, Context context);

        @Post("/entities/health/jobs")
        @ExpectedResponses({202})
        @UnexpectedResponseExceptionType(ErrorResponseException.class)
        Mono<HealthResponse> health(@HostParam("Endpoint") String endpoint, @QueryParam("model-version") String modelVersion, @QueryParam("stringIndexType") StringIndexType stringIndexType, @BodyParam("application/json") MultiLanguageBatchInput input, Context context);

        @Post("/entities/recognition/general")
        @ExpectedResponses({200})
        @UnexpectedResponseExceptionType(ErrorResponseException.class)
        Mono<SimpleResponse<EntitiesResult>> entitiesRecognitionGeneral(@HostParam("Endpoint") String endpoint, @QueryParam("model-version") String modelVersion, @QueryParam("showStats") Boolean showStats, @QueryParam("stringIndexType") StringIndexType stringIndexType, @BodyParam("application/json") MultiLanguageBatchInput input, Context context);

        @Post("/entities/recognition/pii")
        @ExpectedResponses({200})
        @UnexpectedResponseExceptionType(ErrorResponseException.class)
        Mono<SimpleResponse<PiiResult>> entitiesRecognitionPii(@HostParam("Endpoint") String endpoint, @QueryParam("model-version") String modelVersion, @QueryParam("showStats") Boolean showStats, @QueryParam("domain") String domain, @QueryParam("stringIndexType") StringIndexType stringIndexType, @BodyParam("application/json") MultiLanguageBatchInput input, Context context);

        @Post("/entities/linking")
        @ExpectedResponses({200})
        @UnexpectedResponseExceptionType(ErrorResponseException.class)
        Mono<SimpleResponse<EntityLinkingResult>> entitiesLinking(@HostParam("Endpoint") String endpoint, @QueryParam("model-version") String modelVersion, @QueryParam("showStats") Boolean showStats, @QueryParam("stringIndexType") StringIndexType stringIndexType, @BodyParam("application/json") MultiLanguageBatchInput input, Context context);

        @Post("/keyPhrases")
        @ExpectedResponses({200})
        @UnexpectedResponseExceptionType(ErrorResponseException.class)
        Mono<SimpleResponse<KeyPhraseResult>> keyPhrases(@HostParam("Endpoint") String endpoint, @QueryParam("model-version") String modelVersion, @QueryParam("showStats") Boolean showStats, @BodyParam("application/json") MultiLanguageBatchInput input, Context context);

        @Post("/languages")
        @ExpectedResponses({200})
        @UnexpectedResponseExceptionType(ErrorResponseException.class)
        Mono<SimpleResponse<LanguageResult>> languages(@HostParam("Endpoint") String endpoint, @QueryParam("model-version") String modelVersion, @QueryParam("showStats") Boolean showStats, @BodyParam("application/json") LanguageBatchInput input, Context context);

        @Post("/sentiment")
        @ExpectedResponses({200})
        @UnexpectedResponseExceptionType(ErrorResponseException.class)
        Mono<SimpleResponse<SentimentResponse>> sentiment(@HostParam("Endpoint") String endpoint, @QueryParam("model-version") String modelVersion, @QueryParam("showStats") Boolean showStats, @QueryParam("opinionMining") Boolean opinionMining, @QueryParam("stringIndexType") StringIndexType stringIndexType, @BodyParam("application/json") MultiLanguageBatchInput input, Context context);
    }

    /**
     * Submit a collection of text documents for analysis. Specify one or more unique tasks to be executed.
     * 
     * @param body Collection of documents to analyze and tasks to execute.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the completion.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<AnalyzeResponse> analyzeWithResponseAsync(AnalyzeBatchInput body) {
        return FluxUtil.withContext(context -> service.analyze(this.getEndpoint(), body, context));
    }

    /**
     * Submit a collection of text documents for analysis. Specify one or more unique tasks to be executed.
     * 
     * @param context The context to associate with this operation.
     * @param body Collection of documents to analyze and tasks to execute.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the completion.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<AnalyzeResponse> analyzeWithResponseAsync(Context context, AnalyzeBatchInput body) {
        return service.analyze(this.getEndpoint(), body, context);
    }

    /**
     * Get the status of an analysis job.  A job may consist of one or more tasks.  Once all tasks are completed, the job will transition to the completed state and results will be available for each task.
     * 
     * @param jobId Job ID.
     * @param showStats (Optional) if set to true, response will contain request and document level statistics.
     * @param top (Optional) Set the maximum number of results per task. When both $top and $skip are specified, $skip is applied first.
     * @param skip (Optional) Set the number of elements to offset in the response. When both $top and $skip are specified, $skip is applied first.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the status of an analysis job.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<SimpleResponse<AnalyzeJobState>> analyzeStatusWithResponseAsync(UUID jobId, Boolean showStats, Integer top, Integer skip) {
        return FluxUtil.withContext(context -> service.analyzeStatus(this.getEndpoint(), jobId, showStats, top, skip, context));
    }

    /**
     * Get the status of an analysis job.  A job may consist of one or more tasks.  Once all tasks are completed, the job will transition to the completed state and results will be available for each task.
     * 
     * @param jobId Job ID.
     * @param context The context to associate with this operation.
     * @param showStats (Optional) if set to true, response will contain request and document level statistics.
     * @param top (Optional) Set the maximum number of results per task. When both $top and $skip are specified, $skip is applied first.
     * @param skip (Optional) Set the number of elements to offset in the response. When both $top and $skip are specified, $skip is applied first.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the status of an analysis job.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<SimpleResponse<AnalyzeJobState>> analyzeStatusWithResponseAsync(UUID jobId, Context context, Boolean showStats, Integer top, Integer skip) {
        return service.analyzeStatus(this.getEndpoint(), jobId, showStats, top, skip, context);
    }

    /**
     * Get details of the healthcare prediction job specified by the jobId.
     * 
     * @param jobId Job ID.
     * @param top (Optional) Set the maximum number of results per task. When both $top and $skip are specified, $skip is applied first.
     * @param skip (Optional) Set the number of elements to offset in the response. When both $top and $skip are specified, $skip is applied first.
     * @param showStats (Optional) if set to true, response will contain request and document level statistics.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return details of the healthcare prediction job specified by the jobId.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<SimpleResponse<HealthcareJobState>> healthStatusWithResponseAsync(UUID jobId, Integer top, Integer skip, Boolean showStats) {
        return FluxUtil.withContext(context -> service.healthStatus(this.getEndpoint(), jobId, top, skip, showStats, context));
    }

    /**
     * Get details of the healthcare prediction job specified by the jobId.
     * 
     * @param jobId Job ID.
     * @param context The context to associate with this operation.
     * @param top (Optional) Set the maximum number of results per task. When both $top and $skip are specified, $skip is applied first.
     * @param skip (Optional) Set the number of elements to offset in the response. When both $top and $skip are specified, $skip is applied first.
     * @param showStats (Optional) if set to true, response will contain request and document level statistics.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return details of the healthcare prediction job specified by the jobId.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<SimpleResponse<HealthcareJobState>> healthStatusWithResponseAsync(UUID jobId, Context context, Integer top, Integer skip, Boolean showStats) {
        return service.healthStatus(this.getEndpoint(), jobId, top, skip, showStats, context);
    }

    /**
     * Cancel healthcare prediction job.
     * 
     * @param jobId Job ID.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the completion.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<CancelHealthJobResponse> cancelHealthJobWithResponseAsync(UUID jobId) {
        return FluxUtil.withContext(context -> service.cancelHealthJob(this.getEndpoint(), jobId, context));
    }

    /**
     * Cancel healthcare prediction job.
     * 
     * @param jobId Job ID.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the completion.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<CancelHealthJobResponse> cancelHealthJobWithResponseAsync(UUID jobId, Context context) {
        return service.cancelHealthJob(this.getEndpoint(), jobId, context);
    }

    /**
     * Start a healthcare analysis job to recognize healthcare related entities (drugs, conditions, symptoms, etc) and their relations.
     * 
     * @param input Contains a set of input documents to be analyzed by the service.
     * @param modelVersion (Optional) This value indicates which model will be used for scoring. If a model-version is not specified, the API should default to the latest, non-preview version.
     * @param stringIndexType (Optional) Specifies the method used to interpret string offsets.  Defaults to Text Elements (Graphemes) according to Unicode v8.0.0. For additional information see https://aka.ms/text-analytics-offsets.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the completion.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<HealthResponse> healthWithResponseAsync(MultiLanguageBatchInput input, String modelVersion, StringIndexType stringIndexType) {
        return FluxUtil.withContext(context -> service.health(this.getEndpoint(), modelVersion, stringIndexType, input, context));
    }

    /**
     * Start a healthcare analysis job to recognize healthcare related entities (drugs, conditions, symptoms, etc) and their relations.
     * 
     * @param input Contains a set of input documents to be analyzed by the service.
     * @param context The context to associate with this operation.
     * @param modelVersion (Optional) This value indicates which model will be used for scoring. If a model-version is not specified, the API should default to the latest, non-preview version.
     * @param stringIndexType (Optional) Specifies the method used to interpret string offsets.  Defaults to Text Elements (Graphemes) according to Unicode v8.0.0. For additional information see https://aka.ms/text-analytics-offsets.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the completion.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<HealthResponse> healthWithResponseAsync(MultiLanguageBatchInput input, Context context, String modelVersion, StringIndexType stringIndexType) {
        return service.health(this.getEndpoint(), modelVersion, stringIndexType, input, context);
    }

    /**
     * The API returns a list of general named entities in a given document. For the list of supported entity types, check &lt;a href="https://aka.ms/taner"&gt;Supported Entity Types in Text Analytics API&lt;/a&gt;. See the &lt;a href="https://aka.ms/talangs"&gt;Supported languages in Text Analytics API&lt;/a&gt; for the list of enabled languages.
     * 
     * @param input Contains a set of input documents to be analyzed by the service.
     * @param modelVersion (Optional) This value indicates which model will be used for scoring. If a model-version is not specified, the API should default to the latest, non-preview version.
     * @param showStats (Optional) if set to true, response will contain request and document level statistics.
     * @param stringIndexType (Optional) Specifies the method used to interpret string offsets.  Defaults to Text Elements (Graphemes) according to Unicode v8.0.0. For additional information see https://aka.ms/text-analytics-offsets.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<SimpleResponse<EntitiesResult>> entitiesRecognitionGeneralWithResponseAsync(MultiLanguageBatchInput input, String modelVersion, Boolean showStats, StringIndexType stringIndexType) {
        return FluxUtil.withContext(context -> service.entitiesRecognitionGeneral(this.getEndpoint(), modelVersion, showStats, stringIndexType, input, context));
    }

    /**
     * The API returns a list of general named entities in a given document. For the list of supported entity types, check &lt;a href="https://aka.ms/taner"&gt;Supported Entity Types in Text Analytics API&lt;/a&gt;. See the &lt;a href="https://aka.ms/talangs"&gt;Supported languages in Text Analytics API&lt;/a&gt; for the list of enabled languages.
     * 
     * @param input Contains a set of input documents to be analyzed by the service.
     * @param context The context to associate with this operation.
     * @param modelVersion (Optional) This value indicates which model will be used for scoring. If a model-version is not specified, the API should default to the latest, non-preview version.
     * @param showStats (Optional) if set to true, response will contain request and document level statistics.
     * @param stringIndexType (Optional) Specifies the method used to interpret string offsets.  Defaults to Text Elements (Graphemes) according to Unicode v8.0.0. For additional information see https://aka.ms/text-analytics-offsets.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<SimpleResponse<EntitiesResult>> entitiesRecognitionGeneralWithResponseAsync(MultiLanguageBatchInput input, Context context, String modelVersion, Boolean showStats, StringIndexType stringIndexType) {
        return service.entitiesRecognitionGeneral(this.getEndpoint(), modelVersion, showStats, stringIndexType, input, context);
    }

    /**
     * The API returns a list of entities with personal information (\"SSN\", \"Bank Account\" etc) in the document. For the list of supported entity types, check &lt;a href="https://aka.ms/tanerpii"&gt;Supported Entity Types in Text Analytics API&lt;/a&gt;. See the &lt;a href="https://aka.ms/talangs"&gt;Supported languages in Text Analytics API&lt;/a&gt; for the list of enabled languages.
     * 
     * @param input Contains a set of input documents to be analyzed by the service.
     * @param modelVersion (Optional) This value indicates which model will be used for scoring. If a model-version is not specified, the API should default to the latest, non-preview version.
     * @param showStats (Optional) if set to true, response will contain request and document level statistics.
     * @param domain (Optional) if specified, will set the PII domain to include only a subset of the entity categories. Possible values include: 'PHI', 'none'.
     * @param stringIndexType (Optional) Specifies the method used to interpret string offsets.  Defaults to Text Elements (Graphemes) according to Unicode v8.0.0. For additional information see https://aka.ms/text-analytics-offsets.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<SimpleResponse<PiiResult>> entitiesRecognitionPiiWithResponseAsync(MultiLanguageBatchInput input, String modelVersion, Boolean showStats, String domain, StringIndexType stringIndexType) {
        return FluxUtil.withContext(context -> service.entitiesRecognitionPii(this.getEndpoint(), modelVersion, showStats, domain, stringIndexType, input, context));
    }

    /**
     * The API returns a list of entities with personal information (\"SSN\", \"Bank Account\" etc) in the document. For the list of supported entity types, check &lt;a href="https://aka.ms/tanerpii"&gt;Supported Entity Types in Text Analytics API&lt;/a&gt;. See the &lt;a href="https://aka.ms/talangs"&gt;Supported languages in Text Analytics API&lt;/a&gt; for the list of enabled languages.
     * 
     * @param input Contains a set of input documents to be analyzed by the service.
     * @param context The context to associate with this operation.
     * @param modelVersion (Optional) This value indicates which model will be used for scoring. If a model-version is not specified, the API should default to the latest, non-preview version.
     * @param showStats (Optional) if set to true, response will contain request and document level statistics.
     * @param domain (Optional) if specified, will set the PII domain to include only a subset of the entity categories. Possible values include: 'PHI', 'none'.
     * @param stringIndexType (Optional) Specifies the method used to interpret string offsets.  Defaults to Text Elements (Graphemes) according to Unicode v8.0.0. For additional information see https://aka.ms/text-analytics-offsets.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<SimpleResponse<PiiResult>> entitiesRecognitionPiiWithResponseAsync(MultiLanguageBatchInput input, Context context, String modelVersion, Boolean showStats, String domain, StringIndexType stringIndexType) {
        return service.entitiesRecognitionPii(this.getEndpoint(), modelVersion, showStats, domain, stringIndexType, input, context);
    }

    /**
     * The API returns a list of recognized entities with links to a well-known knowledge base. See the &lt;a href="https://aka.ms/talangs"&gt;Supported languages in Text Analytics API&lt;/a&gt; for the list of enabled languages.
     * 
     * @param input Contains a set of input documents to be analyzed by the service.
     * @param modelVersion (Optional) This value indicates which model will be used for scoring. If a model-version is not specified, the API should default to the latest, non-preview version.
     * @param showStats (Optional) if set to true, response will contain request and document level statistics.
     * @param stringIndexType (Optional) Specifies the method used to interpret string offsets.  Defaults to Text Elements (Graphemes) according to Unicode v8.0.0. For additional information see https://aka.ms/text-analytics-offsets.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<SimpleResponse<EntityLinkingResult>> entitiesLinkingWithResponseAsync(MultiLanguageBatchInput input, String modelVersion, Boolean showStats, StringIndexType stringIndexType) {
        return FluxUtil.withContext(context -> service.entitiesLinking(this.getEndpoint(), modelVersion, showStats, stringIndexType, input, context));
    }

    /**
     * The API returns a list of recognized entities with links to a well-known knowledge base. See the &lt;a href="https://aka.ms/talangs"&gt;Supported languages in Text Analytics API&lt;/a&gt; for the list of enabled languages.
     * 
     * @param input Contains a set of input documents to be analyzed by the service.
     * @param context The context to associate with this operation.
     * @param modelVersion (Optional) This value indicates which model will be used for scoring. If a model-version is not specified, the API should default to the latest, non-preview version.
     * @param showStats (Optional) if set to true, response will contain request and document level statistics.
     * @param stringIndexType (Optional) Specifies the method used to interpret string offsets.  Defaults to Text Elements (Graphemes) according to Unicode v8.0.0. For additional information see https://aka.ms/text-analytics-offsets.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<SimpleResponse<EntityLinkingResult>> entitiesLinkingWithResponseAsync(MultiLanguageBatchInput input, Context context, String modelVersion, Boolean showStats, StringIndexType stringIndexType) {
        return service.entitiesLinking(this.getEndpoint(), modelVersion, showStats, stringIndexType, input, context);
    }

    /**
     * The API returns a list of strings denoting the key phrases in the input text. See the &lt;a href="https://aka.ms/talangs"&gt;Supported languages in Text Analytics API&lt;/a&gt; for the list of enabled languages.
     * 
     * @param input Contains a set of input documents to be analyzed by the service.
     * @param modelVersion (Optional) This value indicates which model will be used for scoring. If a model-version is not specified, the API should default to the latest, non-preview version.
     * @param showStats (Optional) if set to true, response will contain request and document level statistics.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<SimpleResponse<KeyPhraseResult>> keyPhrasesWithResponseAsync(MultiLanguageBatchInput input, String modelVersion, Boolean showStats) {
        return FluxUtil.withContext(context -> service.keyPhrases(this.getEndpoint(), modelVersion, showStats, input, context));
    }

    /**
     * The API returns a list of strings denoting the key phrases in the input text. See the &lt;a href="https://aka.ms/talangs"&gt;Supported languages in Text Analytics API&lt;/a&gt; for the list of enabled languages.
     * 
     * @param input Contains a set of input documents to be analyzed by the service.
     * @param context The context to associate with this operation.
     * @param modelVersion (Optional) This value indicates which model will be used for scoring. If a model-version is not specified, the API should default to the latest, non-preview version.
     * @param showStats (Optional) if set to true, response will contain request and document level statistics.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<SimpleResponse<KeyPhraseResult>> keyPhrasesWithResponseAsync(MultiLanguageBatchInput input, Context context, String modelVersion, Boolean showStats) {
        return service.keyPhrases(this.getEndpoint(), modelVersion, showStats, input, context);
    }

    /**
     * The API returns the detected language and a numeric score between 0 and 1. Scores close to 1 indicate 100% certainty that the identified language is true. See the &lt;a href="https://aka.ms/talangs"&gt;Supported languages in Text Analytics API&lt;/a&gt; for the list of enabled languages.
     * 
     * @param input Collection of documents to analyze for language endpoint.
     * @param modelVersion (Optional) This value indicates which model will be used for scoring. If a model-version is not specified, the API should default to the latest, non-preview version.
     * @param showStats (Optional) if set to true, response will contain request and document level statistics.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<SimpleResponse<LanguageResult>> languagesWithResponseAsync(LanguageBatchInput input, String modelVersion, Boolean showStats) {
        return FluxUtil.withContext(context -> service.languages(this.getEndpoint(), modelVersion, showStats, input, context));
    }

    /**
     * The API returns the detected language and a numeric score between 0 and 1. Scores close to 1 indicate 100% certainty that the identified language is true. See the &lt;a href="https://aka.ms/talangs"&gt;Supported languages in Text Analytics API&lt;/a&gt; for the list of enabled languages.
     * 
     * @param input Collection of documents to analyze for language endpoint.
     * @param context The context to associate with this operation.
     * @param modelVersion (Optional) This value indicates which model will be used for scoring. If a model-version is not specified, the API should default to the latest, non-preview version.
     * @param showStats (Optional) if set to true, response will contain request and document level statistics.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<SimpleResponse<LanguageResult>> languagesWithResponseAsync(LanguageBatchInput input, Context context, String modelVersion, Boolean showStats) {
        return service.languages(this.getEndpoint(), modelVersion, showStats, input, context);
    }

    /**
     * The API returns a detailed sentiment analysis for the input text. The analysis is done in multiple levels of granularity, start from the a document level, down to sentence and key terms (aspects) and opinions.
     * 
     * @param input Contains a set of input documents to be analyzed by the service.
     * @param modelVersion (Optional) This value indicates which model will be used for scoring. If a model-version is not specified, the API should default to the latest, non-preview version.
     * @param showStats (Optional) if set to true, response will contain request and document level statistics.
     * @param opinionMining (Optional) if set to true, response will contain input and document level statistics including aspect-based sentiment analysis results.
     * @param stringIndexType (Optional) Specifies the method used to interpret string offsets.  Defaults to Text Elements (Graphemes) according to Unicode v8.0.0. For additional information see https://aka.ms/text-analytics-offsets.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<SimpleResponse<SentimentResponse>> sentimentWithResponseAsync(MultiLanguageBatchInput input, String modelVersion, Boolean showStats, Boolean opinionMining, StringIndexType stringIndexType) {
        return FluxUtil.withContext(context -> service.sentiment(this.getEndpoint(), modelVersion, showStats, opinionMining, stringIndexType, input, context));
    }

    /**
     * The API returns a detailed sentiment analysis for the input text. The analysis is done in multiple levels of granularity, start from the a document level, down to sentence and key terms (aspects) and opinions.
     * 
     * @param input Contains a set of input documents to be analyzed by the service.
     * @param context The context to associate with this operation.
     * @param modelVersion (Optional) This value indicates which model will be used for scoring. If a model-version is not specified, the API should default to the latest, non-preview version.
     * @param showStats (Optional) if set to true, response will contain request and document level statistics.
     * @param opinionMining (Optional) if set to true, response will contain input and document level statistics including aspect-based sentiment analysis results.
     * @param stringIndexType (Optional) Specifies the method used to interpret string offsets.  Defaults to Text Elements (Graphemes) according to Unicode v8.0.0. For additional information see https://aka.ms/text-analytics-offsets.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<SimpleResponse<SentimentResponse>> sentimentWithResponseAsync(MultiLanguageBatchInput input, Context context, String modelVersion, Boolean showStats, Boolean opinionMining, StringIndexType stringIndexType) {
        return service.sentiment(this.getEndpoint(), modelVersion, showStats, opinionMining, stringIndexType, input, context);
    }
}
