/*
Copyright 2025 Stefan Mrkela

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
*/

package me.mrepiko.okhttpwrapper;

import com.google.gson.JsonObject;
import lombok.Getter;
import lombok.NonNull;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.Map;

@Getter
public final class HttpRequestBuilder {

    private final String url;
    private final HttpMethod method;

    @Nullable private String body;
    @Nullable private MediaType bodyMediaType;
    @Nullable private Map<String, String> headers;
    @Nullable private Map<String, String> params;
    @Nullable private OkHttpClient client;

    private HttpRequestBuilder(@NonNull String url, @NonNull HttpMethod method) {
        this.url = url;
        this.method = method;
    }

    public static HttpRequestBuilder create(@NonNull String url, @NonNull HttpMethod method) {
        return new HttpRequestBuilder(url, method);
    }

    public HttpRequestBuilder setBody(@NonNull String body) {
        this.body = body;
        return this;
    }

    public HttpRequestBuilder setBody(@NonNull JsonObject body) {
        this.body = body.toString();
        return this;
    }

    public HttpRequestBuilder setBodyMediaType(@NonNull String mediaType) {
        this.bodyMediaType = MediaType.parse(mediaType);
        if (this.bodyMediaType == null) throw new IllegalArgumentException("Invalid media type: " + mediaType);
        return this;
    }

    public HttpRequestBuilder addHeader(@NonNull String key, @NonNull String value) {
        if (headers == null) headers = new HashMap<>();
        headers.put(key, value);
        return this;
    }

    public HttpRequestBuilder addParam(@NonNull String key, @NonNull String value) {
        if (params == null) params = new HashMap<>();
        params.put(key, value);
        return this;
    }

    public HttpRequestBuilder setClient(@NonNull OkHttpClient client) {
        this.client = client;
        return this;
    }

    public HttpRequest build() {
        return new HttpRequestImpl(this);
    }

}
