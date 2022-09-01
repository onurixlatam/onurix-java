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

public class WhatsAppGeneralSend {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		
		String clientId = "AQUI_SU_CLIENT";
		String key = "AQUI_SU_KEY";
		String template = "AQUI_EL_NOMBRE_DE_LA_PLANTILLA";

		var httpClient = HttpClient.newHttpClient();
		var request = HttpRequest.newBuilder()
				.POST(HttpRequest.BodyPublishers.ofString("AQUI_EL_JSON_CON_LOS_VALORES_PARA_LA_PLANTILLA"))
				.uri(URI.create("https://www.onurix.com/api/v1/whatsapp/send?client=" + clientId + "&key=" + key + "&template=" + template))
				.header("Content-Type", "application/json")
				.build();
		
		var response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
		System.out.println(response.body());
	}
}
