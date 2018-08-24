package java3.lesson_4;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReadFile {
    public boolean readFile(String fileName, int index) throws IOException {
        boolean stop=false;
        Stream<String> stream = Files.lines(Paths.get(fileName));
        List<String> line = stream.collect(Collectors.toList());
        if (line.size() == index) {
            stop = true;
        } else {
            System.out.println(line.get(index));
        }
        return stop;
    }
}

