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

public class SendCall {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		Map<String,String> parameters = new HashMap<>();
		parameters.put("client", "AQUI_SU_CLIENT");
		parameters.put("key", "AQUI_SU_KEY");
		parameters.put("phone", "AQUI_EL_NUMERO_DE_CELULAR");//PARA ENVIAR MULTIPLES TELEFONOS TENDRAN QUE SER SEPARADOS POR COMAS ","
		parameters.put("message", "AQUI_EL_MENSAJE_A_ENVIAR");//EN CASO DE ENVIAR PARAMETRO AUDIO-CODE NO PASAR PARAMETROS MESSAGE Y VOICE
		parameters.put("voice", "AQUI_TIPO_DE_VOZ");
		parameters.put("retries", "AQUI_NUMERO_DE_INTENTOS");
		parameters.put("leave-voicemail", "false");
		//parameters.put("audio-code", "AQUI_ID_AUDIO");
		parameters.put("groups","AQUI_ID_GRUPOS");
	


		var httpClient = HttpClient.newHttpClient();
		var request = HttpRequest.newBuilder()
				.version(HttpClient.Version.HTTP_2)
				.POST(ofFormData(parameters))
				.uri(URI.create("https://www.onurix.com/api/v1/call/send"))
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
