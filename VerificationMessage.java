//Para este codigo se uso jdk 11
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class VerificationMessage {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		var httpClient = HttpClient.newHttpClient();
		var request = HttpRequest.newBuilder(URI.create("https://www.onurix.com/api/v1/messages-state?client=AQUI_SU_CLIENT&key=AQUI_SU_KEY&id=AQUI_SU_MENSAJE_ID"))
											.version(HttpClient.Version.HTTP_2)
											.GET()
											.build();
		var response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
		//System.out.println(response.body());
	}

}
