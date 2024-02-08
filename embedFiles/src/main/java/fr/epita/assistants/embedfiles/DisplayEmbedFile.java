package fr.epita.assistants.embedfiles;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.stream.Collectors;

import static junit.framework.Assert.assertTrue;

public class DisplayEmbedFile {
    private final String filename;

    public DisplayEmbedFile(String filename) {
        this.filename = filename;
    }

    public Optional<String> display() {

        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(filename).getFile());
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
                return Optional.ofNullable(br.lines().collect(Collectors.joining(System.lineSeparator())));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}
