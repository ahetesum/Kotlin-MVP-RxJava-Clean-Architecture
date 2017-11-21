/**
 * Copyright (C) 2015 Fernando Cejas Open Source Project
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package map.shiveh.ir.mapsdk.features.network;


import java.io.File;
import java.net.MalformedURLException;

import map.shiveh.ir.mapsdk.features.network.base.HttpDeleteRequest;
import map.shiveh.ir.mapsdk.features.network.base.HttpGetRequest;
import map.shiveh.ir.mapsdk.features.network.base.HttpPostRequest;
import map.shiveh.ir.mapsdk.features.network.base.HttpRequest;


/**
 * Api Connection class used to retrieve data from the cloud.
 * Implements {@link java.util.concurrent.Callable} so when executed asynchronously can
 * return a value.
 */
public class ApiConnection {

    public static HttpRequest createGET(String url) {
        return new HttpGetRequest(url);

    }

    public static HttpRequest createGET(String url, String token) {
        return new HttpGetRequest(url, token);

    }

    public static HttpRequest createPOST(String url, String body) throws MalformedURLException {
        return new HttpPostRequest(url, body);
    }
    public static HttpRequest createPOST(String url) throws MalformedURLException {
        return new HttpPostRequest(url);
    }
    public static HttpRequest createPOST(String url, String body, String token) throws MalformedURLException {
        return new HttpPostRequest(url, body, token);
    }

    public static HttpRequest createDelete(String url, String token) throws MalformedURLException {
        return new HttpDeleteRequest(url,token);
    }

    public static HttpRequest createPOST(String url, File file, String token) throws MalformedURLException {
        return new HttpPostRequest(url, file, token);
    }

}
