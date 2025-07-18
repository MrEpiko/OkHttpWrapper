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

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;

@Getter
@AllArgsConstructor
public class HttpResponse {

    private final int statusCode;
    @Nullable private final String body;
    @Nullable private final HashMap<String, String> headers;
    private static final ObjectMapper mapper = new ObjectMapper();

    @Nullable
    public JsonNode getBodyAsJsonNode() throws JsonProcessingException {
        if (body == null) return null;
        return mapper.readTree(body);
    }

}
