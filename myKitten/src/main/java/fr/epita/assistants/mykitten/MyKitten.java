package fr.epita.assistants.mykitten;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;
import java.io.FileReader;

public class MyKitten {
    /**
     * Initializer.
     *
     * @param srcPath Source file path.
     */
    public MyKitten(String srcPath) {
        Path file = Paths.get(srcPath);
        try {
            streamContent = Files.lines(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Use the streamContent to replace `wordToReplace` with "miaou". Don't forget
     * to add the line number beforehand for each line. Store the new
     * result directly in the streamContent field.
     *
     * @param wordToReplace The word to replace
     */
    public void replaceByMiaou(String wordToReplace) {
        AtomicInteger i = new AtomicInteger(1);
        streamContent = streamContent.map(str-> Integer.toString(i.getAndIncrement()) + " " + str.replaceAll(wordToReplace, "miaou"));
    }

    /**
     * Use the streamContent to write the content into the destination file.
     *
     * @param destPath Destination file path.
     */
    public void toFile(String destPath) {
        Path file = Paths.get(destPath);
        try{
            Files.write(file,streamContent.toList());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Creates an instance of MyKitten and calls the above methods to do it
     * straightforwardly.
     *
     * @param srcPath       Source file path
     * @param destPath      Destination file path
     * @param wordToReplace Word to replace
     */
    public static void miaou(String srcPath, String destPath,
                             String wordToReplace) {
        MyKitten res = new MyKitten(srcPath);
        res.replaceByMiaou(wordToReplace);
        res.toFile(destPath);
    }

    public Stream<String> streamContent;
    /*
    public static void main(String[] args){
        miaou("./output.txt", "./input.txt", "test");
    }*/
}
