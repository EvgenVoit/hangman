import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Random;

public class WordReader {
    public static String getWord() throws IOException {
        List<String> wordArchive = Files.readAllLines(Path.of("src/main/resources/word.txt"));
        return wordArchive.get(new Random().nextInt(wordArchive.size()));
    }

}
