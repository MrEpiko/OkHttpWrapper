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

import lombok.NonNull;

public enum HttpMethod {
    GET,
    POST,
    PUT,
    DELETE,
    PATCH,
    HEAD,
    OPTIONS;

    public static HttpMethod fromString(@NonNull String method) {
        for (HttpMethod httpMethod : HttpMethod.values()) {
            if (httpMethod.name().equalsIgnoreCase(method)) {
                return httpMethod;
            }
        }
        throw new IllegalArgumentException("Unknown HTTP method: " + method);
    }
}
