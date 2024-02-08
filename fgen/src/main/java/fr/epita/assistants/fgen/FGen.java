package fr.epita.assistants.fgen;

import org.codehaus.plexus.util.FileUtils;

import java.io.*;
import java.nio.file.FileSystem;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.stream.Stream;

public class FGen {

    Path curr_path;

    public FGen(final String inputPath) {
        curr_path = Paths.get("").toAbsolutePath();
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(inputPath).getFile());
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine()) != null) {
                String arg_file = line.substring(2, line.length());
                switch (line.charAt(0)) {
                    case '+':
                        create(arg_file);
                        break;
                    case '>':
                        change(arg_file);
                        break;
                    case '-':
                        delete(arg_file);
                        break;
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void create(String file) {
        try {
            Path tmp_path = this.curr_path.resolve(file);
            if (Files.exists(tmp_path)) {
                System.out.println("Cheeef");
                return;
            }
            if (file.endsWith("/")) {
                System.out.println("Directory created");
                Files.createDirectories(tmp_path);
            }
            else
            {
                System.out.println("File created");
                Files.createDirectories(tmp_path.getParent());
                Files.createFile(tmp_path);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void change(String file) {
        curr_path  = this.curr_path.resolve(file);
        if (!Files.exists(curr_path))
        {
            throw new java.lang.RuntimeException(curr_path + ": directroy does not exist");
        }
    }

    public void delete(String file) {
        Path tmp_path = this.curr_path.resolve(file);
        if (!Files.exists(tmp_path))
            return;
        /*
        if (Files.isRegularFile(tmp_path)) {
            try {
                Files.delete(tmp_path);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }*/
        try {
            Files.walk(tmp_path).sorted(Comparator.reverseOrder()).forEach(path -> {try {Files.delete(path);} catch (
                    IOException e) {
                throw new RuntimeException(e);
            }
      });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
