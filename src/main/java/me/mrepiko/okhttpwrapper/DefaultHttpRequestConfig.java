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

import lombok.Getter;
import lombok.Setter;
import okhttp3.ConnectionPool;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;

import java.util.concurrent.TimeUnit;

public final class DefaultHttpRequestConfig {
    private DefaultHttpRequestConfig() {}

    @Setter
    @Getter
    private static volatile OkHttpClient defaultClient = new OkHttpClient.Builder()
            .connectionPool(new ConnectionPool(35, 5, TimeUnit.MINUTES))
            .build();

    @Setter
    @Getter
    private static volatile MediaType defaultMediaType = MediaType.parse("application/json; charset=utf-8");
}
