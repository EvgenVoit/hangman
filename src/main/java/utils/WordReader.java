package utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Random;

public class WordReader {
    private static final String russianWordPath = "src/main/resources/RussianWord.txt";
    private static final String englishWordPath = "src/main/resources/EnglishWord.txt";

    public static String getWord(Enum<Language> languageEnum) throws IOException {
        switch (languageEnum.name()) {

            case "RUSSIAN" -> {
                List<String> wordList = Files.readAllLines(Path.of(russianWordPath));
                return wordList.get(new Random().nextInt(wordList.size()));
            }

            case "ENGLISH" -> {
                List<String> wordList = Files.readAllLines(Path.of(englishWordPath));
                return wordList.get(new Random().nextInt(wordList.size()));
            }

            default -> {
                return "INPUT ERROR!";
            }
        }
    }
}