package map.shiveh.ir.mapsdk.features.network.base;

public class HttpGetRequest extends HttpRequest {

    String url;


    public HttpGetRequest(String url) {
        super(url);
        this.url = url;
    }

    public HttpGetRequest(String url, String token) {
        super(url);
        this.url = url;
        setAuthenticationHeader(token);
    }

    @Override
    protected void addHeaders() {
    }

    public void setAuthenticationHeader(String token) {
        requestBuilder.addHeader("token", token);
    }
}
