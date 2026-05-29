import java.nio.file.Path;
import java.nio.file.Files;

public class UploadAudio {

    public static void main(String[] args) throws Exception{

        Path audioPath = Path.of("audios/AudioApiTest.ogg");
        String uploadUrl = uploadAudio(audioPath);

        
    }
}
