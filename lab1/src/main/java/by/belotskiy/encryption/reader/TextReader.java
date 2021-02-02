package by.belotskiy.encryption.reader;

import by.belotskiy.encryption.reader.exception.ReaderException;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TextReader {
    private static final String DEFAULT_PATH = "src/main/resources/data/default.txt";

    public String read(String path) throws ReaderException {
        if (path == null) {
            path = DEFAULT_PATH;
        }
        Path filePath = Paths.get(path);
        try {
            if (!(Files.exists(filePath) && Files.size(filePath) > 0)) {
                filePath = Paths.get(DEFAULT_PATH);
            }
        } catch (Exception e) {
            System.out.println("wrong");
        }
        List<String> lines;
        try (Stream<String> lineStream = Files.lines(filePath)) {
            lines = lineStream.collect(Collectors.toList());
        } catch (Exception e) {
            throw new ReaderException(e.getMessage());
        }
        StringBuilder text = new StringBuilder();
        for (String line : lines) {
            text.append(line);
        }
        return text.toString();
    }
}
