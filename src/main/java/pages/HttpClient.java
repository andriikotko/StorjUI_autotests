package pages;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class HttpClient {
    private OkHttpClient client = new OkHttpClient();

    /**
     * HTTP post request.
     *
     * @param url  path
     * @param json payload
     * @return response
     * @throws IOException error
     */
    public Response post(final String url, final String json) throws IOException {
        final RequestBody body = RequestBody.create(null, json.getBytes(StandardCharsets.UTF_8));

        final Request request = new Request.Builder()
                .url(url)
                .post(body)
                .addHeader("Content-Type", "application/json")
                .addHeader("Accept", "application/json")
                .build();

        return client.newCall(request).execute();
    }
    public Response post(final String url, final String json, final String token) throws IOException {
        final RequestBody body = RequestBody.create(null, json.getBytes(StandardCharsets.UTF_8));

        final Request request = new Request.Builder()
                .url(url)
                .post(body)
                .addHeader("Content-Type", "application/json")
                .addHeader("Authorization",  token)
                .build();

        return client.newCall(request).execute();
    }

    /**
     * Http authorized get request.
     *
     * @param url       path
     * @param authToken authorization token
     * @return response
     * @throws IOException error
     */
    public Response get(final String url, final String authToken) throws IOException {
        final Request request = new Request.Builder()
                .url(url)
                .addHeader("Content-Type", "application/json")
                .addHeader("Authorization", "Bearer " + authToken)
                .build();

        return client.newCall(request).execute();
    }

    /**
     * Http authorized delete request.
     *
     * @param url       path
     * @param json payload
     * @param authToken authorization token
     * @return response
     * @throws IOException error
     */
    public Response delete(final String url, final String json, final String authToken) throws IOException {
        final RequestBody body = RequestBody.create(null, json.getBytes(StandardCharsets.UTF_8));

        final Request request = new Request.Builder()
                .url(url)
                .delete(body)
                .addHeader("Content-Type", "application/json")
                .addHeader("Authorization", "Bearer " + authToken)
                .build();

        return client.newCall(request).execute();
    }
}

