package data;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ObjParse {

    private void mainPart(String path) throws IOException {
        System.out.print(this.getData(path));

    }

    public static String getData(String fullPath) throws IOException {

        Path path = Paths.get(fullPath);

        Stream<String> lines = Files.lines(path);
        String data = lines.collect(Collectors.joining("\n"));
        lines.close();
        return data;
    }




}
