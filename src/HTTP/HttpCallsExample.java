package HTTP;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class HttpCallsExample {

    public static void main(String[] args) throws IOException {
        Map<String, String> params = new HashMap<>();
        params.put("q", "Avinash");
        doHttpCall("http://www.google.co.in/search", params, HttpRequestMethod.GET);
    }

    public static Map<String, String> doHttpCall(String url, HttpRequestMethod httpRequestMethod) throws IOException {
        return doHttpCall(url, null, httpRequestMethod, null, 0, TimeUnit.MILLISECONDS);
    }

    public static Map<String, String> doHttpCall(String url, HttpRequestMethod httpRequestMethod, long timeout, TimeUnit timeUnit) throws IOException {
        return doHttpCall(url, null, httpRequestMethod, null, timeout, timeUnit);
    }

    public static Map<String, String> doHttpCall(String url, Map<String, String> params, HttpRequestMethod httpRequestMethod) throws IOException {
        return doHttpCall(url, params, httpRequestMethod, null, 0, TimeUnit.MILLISECONDS);
    }

    public static Map<String, String> doHttpCall(String url, Map<String, String> params, HttpRequestMethod httpRequestMethod, long timeout, TimeUnit timeUnit) throws IOException {
        return doHttpCall(url, params, httpRequestMethod, null, timeout, timeUnit);
    }

    public static Map<String, String> doHttpCall(String url, HttpRequestMethod httpRequestMethod, Map<String, String> headers) throws IOException {
        return doHttpCall(url, null, httpRequestMethod, headers, 0, TimeUnit.MILLISECONDS);
    }

    public static Map<String, String> doHttpCall(String url, HttpRequestMethod httpRequestMethod, Map<String, String> headers, long timeout, TimeUnit timeUnit) throws IOException {
        return doHttpCall(url, null, httpRequestMethod, headers, timeout, timeUnit);
    }

    public static Map<String, String> doHttpCall(String url, Map<String, String> params, HttpRequestMethod httpRequestMethod, Map<String, String> headers) throws IOException {
        return doHttpCall(url, params, httpRequestMethod, headers, 0, TimeUnit.MILLISECONDS);
    }

    public static Map<String, String> doHttpCall(String url, Map<String, String> params, HttpRequestMethod httpRequestMethod, Map<String, String> headers, long timeout, TimeUnit timeUnit) throws IOException {
        Long timeOutInMillis = TimeUnit.MILLISECONDS.convert(timeout, timeUnit);

        if (HttpRequestMethod.GET.equals(httpRequestMethod) && params != null) {
            String paramString = ParameterStringBuilder.getParamsString(params);
            url = url + "?" + paramString;
        }

        URL httpURL = new URL(url);
        HttpURLConnection connection = (HttpURLConnection) httpURL.openConnection();
        connection.setRequestMethod(httpRequestMethod.getValue());

        connection.setRequestProperty("User-Agent", "JAVA_HTTP_REQUEST");

        //set url params in case of non-get requests
        if (!HttpRequestMethod.GET.equals(httpRequestMethod) && params != null && params.size() != 0) {
            connection.setDoOutput(true); //required if params needs to be set
            DataOutputStream dataOutputStream = new DataOutputStream(connection.getOutputStream());
            dataOutputStream.writeBytes(ParameterStringBuilder.getParamsString(params));
            dataOutputStream.flush();
            dataOutputStream.close();
        }

        //set request headers
        if (headers != null) {
            for (Map.Entry<String, String> headerEntry : headers.entrySet()) {
                connection.setRequestProperty(headerEntry.getKey(), headerEntry.getValue());
            }
        }

        //set connection timeout
        if (timeOutInMillis != 0)
            connection.setConnectTimeout(timeOutInMillis.intValue());

        int statusCode = connection.getResponseCode();
        String responseMessage= connection.getResponseMessage();

        //Read the response
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuffer responseString = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            responseString.append(inputLine);
        }
        in.close();

        //Disconnect the connection
        connection.disconnect();

        Map<String, String> response= new HashMap<>();
        response.put("response", responseString.toString());
        response.put("response-code", String.valueOf(statusCode));
        response.put("response-message",responseMessage);

        return response;
    }

    enum HttpRequestMethod {
        POST("POST"),
        GET("GET"),
        PUT("PUT"),
        DELETE("DELETE");

        String val;

        HttpRequestMethod(String val) {
            this.val = val;
        }

        public String getValue() {
            return this.val;
        }
    }
}
