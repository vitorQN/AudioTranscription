import java.nio.file.Path;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;

public class UploadAudio {

    public static String uploadAudio(Path audioPath) throws IOException, InterruptedException {

        HttpClient client = HttpClient.newHttpClient();

        byte[] audioBytes = Files.readAllBytes(audioPath);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.assemblyai.com/v2/upload"))
                .header("authorization", Constantes.API_KEY)
                .POST(HttpRequest.BodyPublishers.ofByteArray(audioBytes))
                .build();

        HttpResponse<String> response = client.send(
                request,
                HttpResponse.BodyHandlers.ofString()
        );


        String body = response.body();

        String uploadUrl = body.split("\"upload_url\":\"")[1].split("\"")[0];

        System.out.println(uploadUrl);
        return uploadUrl;
    }    
}
