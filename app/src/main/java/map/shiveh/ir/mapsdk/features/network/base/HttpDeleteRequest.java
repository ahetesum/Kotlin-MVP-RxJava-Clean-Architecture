package map.shiveh.ir.mapsdk.features.network.base;

/**
 * Created by A.Biswas on 9/23/2017.
 */

public class HttpDeleteRequest extends HttpRequest
{
    private String url= null;

    public HttpDeleteRequest(String url, String token)
    {
        super(url);
        setAuthenticationHeader(token);
        setBody();
    }

    public void setBody(){
        requestBuilder.delete(null);
    }
    public void setAuthenticationHeader(String token) {
        requestBuilder.addHeader("token", token);
    }

}
