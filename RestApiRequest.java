import java.net.URI;
import java.net.http.HttpRequest;

public class RestApiRequest {
    public static void main(String[] args) throws Exception {

        HttpRequest postResquest = HttpRequest.newBuilder()
        .uri(new URI("https://api.assemblyai.com/v2/transcript"))
        .header("Authorization", Constantes.API_KEY)
        .POST(HttpRequest.BodyPublishers.ofString("{ \"audio_url\": \"audios\\AudioApiTest.ogg\" }"))
        .build();

    }
}