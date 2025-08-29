//Para este codigo se uso jdk 11

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class SendWhatsAppWithoutTemplate {

    public static void main(String[] args) {
        String apiUrl = "https://www.onurix.com/api/v1/whatsapp/send/no-template";
        String apiKey = "AQUI_SU_SECRET_KEY"; // Replace with your actual API key
        String client = "AQUI_SU_CLIENT_ID"; // Replace with your actual client ID

        try {
            // Construct the URL with query parameters
            String fullUrl = apiUrl + "?key=" + apiKey + "&client=" + client;
            URL url = new URL(fullUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            // Set the request method to POST
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);

            // ✅ JSON payload usando text block (Java 15+)
            String jsonInputString = """
            {
                "from_phone_meta_id": "AQUI_EL_META_ID_DEL_TELEFONO",
                "phone": "AQUI_EL_TELEFONO_DESTINO",
                "message": {
                    "type": "text",
                    "value": "AQUI_EL_MENSAJE"
                }
            }
            """;

            // Write the JSON data to the request body
            try (OutputStream os = conn.getOutputStream()) {
                byte[] input = jsonInputString.getBytes(StandardCharsets.UTF_8);
                os.write(input, 0, input.length);
            }

            // Get the response code
            int responseCode = conn.getResponseCode();
            System.out.println("Response Code: " + responseCode);

            // Read the response
            try (BufferedReader br = new BufferedReader(
                    new InputStreamReader(conn.getInputStream(), StandardCharsets.UTF_8))) {
                StringBuilder response = new StringBuilder();
                String line;
                while ((line = br.readLine()) != null) {
                    response.append(line.trim());
                }
                System.out.println("Response Body: " + response);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}