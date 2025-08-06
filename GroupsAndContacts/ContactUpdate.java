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

public class ContactUpdate {
  public static void main(String[] args) throws IOException, InterruptedException{
        Map<String,String> parameters = new HashMap<>();
        parameters.put("client", "AQUI_SU_CLIENT");
		parameters.put("key", "AQUI_SU_KEY");
        parameters.put("id", "AQUI_ID_CONTACTO");
        parameters.put("name","AQUI_EL_NOMBRE_DE_CONTACTO");
        parameters.put("lastname","AQUI_EL_APELLIDO_DE_CONTACTO");
        parameters.put("phone", "AQUI_TELEFONO_DE_CONTACTO");
        parameters.put("email", "AQUI_EMAIL_DE_CONTACTO");


        HttpClient httpClient = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder()
                                .uri(URI.create("https://www.onurix.com/api/v1/contacts/update"))
                                .POST(ofFormData(parameters))
                                .header("Content-type","application/x-www-form-urlencoded")
                                .build();
        HttpResponse response =httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
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
