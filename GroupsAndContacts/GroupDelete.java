import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class GroupDelete {
      public static void main(String[] args) throws IOException, InterruptedException{
     
        HttpClient httpClient = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder()
                                .uri(URI.create("https://www.onurix.com/api/v1/group/delete?key=AQUI_SU_KEY&client=AQUI_SU_ID&id=AQUI_ID_GRUPO"))
                                .DELETE()
                                .header("Content-type","application/x-www-form-urlencoded")
                                .build();
        HttpResponse response =httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
    }
}
