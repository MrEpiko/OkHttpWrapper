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
import lombok.NonNull;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import org.jetbrains.annotations.Nullable;

import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public interface HttpRequest {
    @NonNull
    HttpMethod getMethod();
    @NonNull
    String getUrl();
    @Nullable
    String getBody();
    @Nullable
    MediaType getBodyMediaType();
    @Nullable
    JsonObject getBodyAsJsonObject();
    @Nullable
    Map<String, String> getHeaders();
    @Nullable
    Map<String, String> getParams();
    @NonNull
    OkHttpClient getClient();
    @Nullable
    Response getRawResponse();
    @NonNull
    HttpResponse execute() throws Exception;
    @NonNull
    CompletableFuture<HttpResponse> executeAsync() throws Exception;
    void executeAsync(@NonNull Consumer<HttpResponse> consumer);
}
