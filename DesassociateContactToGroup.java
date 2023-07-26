import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.Map.Entry;

public class DesassociateContactToGroup {
        public static void main(String[] args) throws IOException, InterruptedException{
     
        HttpClient httpClient = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder()
                                .uri(URI.create("https://www.onurix.com/api/v1/contacts/group/remove?key=AQUI_SU_KEY&client=AQUI_SU_ID&group-id=AQUI_ID_GRUPO&id=AQUI_ID_CONTACTO"))
                                .DELETE()
                                .header("Content-type","application/x-www-form-urlencoded")
                                .build();
        HttpResponse response =httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
    }
}
