import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class ContactGroupList {
    	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		var httpClient = HttpClient.newHttpClient();

		var request = HttpRequest.newBuilder(URI.create("https://www.onurix.com/api/v1/group/AQUI_ID_GRUPO/contacts/list?key=AQUI_SU_KEY&client=AQUI_SU_ID"))
											.GET()
											.version(HttpClient.Version.HTTP_2)
											.build();
		HttpResponse response = httpClient.send(request, BodyHandlers.ofString());
		System.out.println(response.body());
	}
}
