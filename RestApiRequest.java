import java.net.URI;
import java.net.http.HttpRequest;
import java.nio.file.Path;

public class RestApiRequest {
    public static void main(String[] args) throws Exception {

        HttpRequest postResquest = HttpRequest.newBuilder()
        .uri(new URI("https://api.assemblyai.com/v2/transcript"))
        .header("Authorization", Constantes.API_KEY)
        .POST(HttpRequest.BodyPublishers.ofString("{ \"audio_url\": \"" + UploadAudio.uploadAudio(Path.of("audios/AudioApiTest.ogg")) + "\" }"))
        .build();

    }
}