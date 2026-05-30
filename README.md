# API Audio Transcript

This project is a simple Java application that sends an audio file to the
AssemblyAI API and creates a transcription request for it.

The application does two main things:

1. Uploads a local audio file to AssemblyAI.
2. Sends the uploaded audio URL to AssemblyAI's transcript endpoint.

## Project Structure

| File | Description |
| --- | --- |
| `RestApiRequest.java` | Main class. Uploads the audio file, builds the JSON request, and sends the transcription request. |
| `UploadAudio.java` | Reads the local audio file and uploads it to AssemblyAI. Returns the uploaded audio URL. |
| `TranscriptAudio.java` | Simple model class used to store the uploaded audio URL. |
| `Constantes.java` | Stores constants used by the project, including the API key. |
| `audios/AudioApiTest.ogg` | Example audio file used by the program. |

## Requirements

- Java 17 or newer
- An AssemblyAI API key
- An audio file inside the `audios` folder

## How It Works

`RestApiRequest.java` starts the program. It calls:

```java
UploadAudio.uploadAudio(Path.of("audios/AudioApiTest.ogg"))
```

This uploads the audio file to:

```text
https://api.assemblyai.com/v2/upload
```

After the upload is complete, AssemblyAI returns an `upload_url`. The project
then sends that URL to:

```text
https://api.assemblyai.com/v2/transcript
```

The request body looks like this:

```json
{
  "audio_url": "uploaded-audio-url",
  "speech_models": ["universal-3-pro"]
}
```

The API response is printed in the terminal.

## How to Run

Compile the Java files:

```bash
javac *.java
```

Run the main class:

```bash
java RestApiRequest
```

Make sure the audio file exists at:

```text
audios/AudioApiTest.ogg
```

If you want to use another audio file, update this line in
`RestApiRequest.java`:

```java
Path.of("audios/AudioApiTest.ogg")
```

## API Key

The API key is currently stored in `Constantes.java`:

```java
public static final String API_KEY = "YOUR_API_KEY";
```

For real projects, avoid committing your real API key to GitHub. A safer option
is to load the key from an environment variable.

## Example Output

When the program runs successfully, it prints:

- The uploaded audio URL
- The JSON request body
- The response from the transcript API

## Next Improvements

Possible improvements for this project:

- Read the API key from an environment variable.
- Allow the audio file path to be passed as a command-line argument.
- Parse the transcript response JSON instead of using `String.split`.
- Add a request to check the transcription status until it is completed.
