//Para este codigo se uso jdk 11
import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class URLShortener {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		Map<String,String> parameters = new HashMap<>();
		parameters.put("client", "AQUI_SU_CLIENT");
		parameters.put("key", "AQUI_SU_KEY");
		parameters.put("name", "AQUI_NOMBE_DE_URL");
		parameters.put("url-long", "AQUI_URL_LARGA");
		parameters.put("alias", "OPCIONAL_AQUI_ALIAS");
		parameters.put("is-premium", "OPCIONAL_AQUI_TRUE_OR_FALSE_DEFAULT_FALSE");
		parameters.put("group-name", "OPCIONAL_AQUI_NOMBRE_DE_GRUPO");
		parameters.put("expiration-time-statistics", "OPCIONAL_AQUI_TIEMPO_ALMACENAMIENTO-ESTADITICAS");		




		var httpClient = HttpClient.newHttpClient();
		var request = HttpRequest.newBuilder()
				.version(HttpClient.Version.HTTP_2)
				.POST(ofFormData(parameters))
				.uri(URI.create("https://www.onurix.com/api/v1/url/short"))
				.header("Content-Type", "application/x-www-form-urlencoded")
				.build();
		
		var response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        //System.out.println(response.body());

	}

    public static HttpRequest.BodyPublisher ofFormData(Map<String, String> parameters) {
        var builder = new StringBuilder();
        for (Entry<String, String> entry : parameters.entrySet()) {
            if (builder.length() > 0) {
                builder.append("&");
            }
            builder.append(URLEncoder.encode(entry.getKey().toString(), StandardCharsets.UTF_8));
            builder.append("=");
            builder.append(URLEncoder.encode(entry.getValue().toString(), StandardCharsets.UTF_8));
        }
        return HttpRequest.BodyPublishers.ofString(builder.toString());
    }
}
