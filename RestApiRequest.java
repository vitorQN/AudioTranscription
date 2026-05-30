import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.nio.file.Path;
import com.google.gson.Gson;

public class RestApiRequest {
    public static void main(String[] args) throws Exception {

        TranscriptAudio transcriptAudio = new TranscriptAudio();
        transcriptAudio.setAudio_url(UploadAudio.uploadAudio(Path.of("audios/AudioApiTest.ogg")));
        String jsonRequest = String.format(
                "{\n"
                        + "  \"audio_url\": \"%s\",\n"
                        + "  \"speech_models\": [\"universal-3-pro\"]\n"
                        + "}", transcriptAudio.getAudio_url());

        System.out.println("JSON Body: " + jsonRequest);

        HttpRequest postResquest = HttpRequest.newBuilder()
                .uri(new URI("https://api.assemblyai.com/v2/transcript"))
                .header("Authorization", Constantes.API_KEY)
                .POST(HttpRequest.BodyPublishers.ofString(jsonRequest))
                .build();

        HttpClient client = HttpClient.newHttpClient();

        HttpResponse<String> postResponse = client.send(postResquest, BodyHandlers.ofString());

        System.out.println("POST Response: " + postResponse.body());

        
        transcriptAudio = gson.fromJson(postResponse.body(), TranscriptAudio.class);

        transcriptAudio.getId();
    }

}