package fr.epita.assistants.embedfiles;

import org.junit.jupiter.api.Test;

import static junit.framework.Assert.assertTrue;

public class Main {
    @Test
    public void testWithExistingFile() {
        final var embedFile = new DisplayEmbedFile("sample.txt");
        final var result = embedFile.display().orElseThrow();
        assertTrue(result.contains("This is a sample"));
    }
}
