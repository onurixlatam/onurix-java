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

public class Security {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		Map<String,String> parameters = new HashMap<>();
		parameters.put("client", "AQUI_SU_CLIENT");
		parameters.put("key", "AQUI_SU_KEY");
		parameters.put("phone", "AQUI_EL_NUMERO_DE_CELULAR");
		parameters.put("name", "AQUI_NOMBRE_CONTACTO");

		var httpClient = HttpClient.newHttpClient();
		var request = HttpRequest.newBuilder()
				.POST(ofFormData(parameters))
				.uri(URI.create("https://www.onurix.com/api/v1/block-phone"))
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
