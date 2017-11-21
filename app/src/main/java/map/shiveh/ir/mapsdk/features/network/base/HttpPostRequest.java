package map.shiveh.ir.mapsdk.features.network.base;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;


/**
 * Created by Ali on 6/26/17.
 */

public class HttpPostRequest extends HttpRequest {

    public HttpPostRequest(String url, String body) {
        super(url);
        //TODO step 7
        setBody(body);

    }

    public HttpPostRequest(String url) {
        super(url);
        setBody("");
    }

    public HttpPostRequest(String url, String body, String token) {
        super(url);
        //TODO step 7
        setBody(body);
        setAuthenticationHeader(token);

    }

    public HttpPostRequest(String url, File file, String token) {
        super(url);
        setAuthenticationHeader(token);
        setMedia(file);

    }

    public void setMedia(File file) {


        RequestBody formBody = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("file", file.getName(),
                        RequestBody.create(IMAGE, file))
                .build();

        requestBuilder.post(formBody);
    }

    public void setBody(String body) {
        requestBuilder.post(RequestBody.create(JSON, body.toString()));
    }

    public void setBody(JSONObject body) {
        requestBuilder.post(RequestBody.create(JSON, body.toString()));
    }

    public void setBody(JSONArray jsonArray) {
        requestBuilder.post(RequestBody.create(JSON, jsonArray.toString()));
    }

    public void customHeaders(String corpCode, String companyCode, String contryCode) {
        requestBuilder.addHeader("corporationCode", corpCode);
    }

    public void checkHeaderData(String body, String url) {
        try {
            JSONObject jsonObject = new JSONObject(body);

            setBody(jsonObject);

        } catch (Exception e) {
        }
    }

    public void setAuthenticationHeader(String token) {
        requestBuilder.addHeader("token", token);
    }
}
