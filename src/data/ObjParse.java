package data;

import com.company.elements.Triangle;
import com.company.elements.invisible.Normal;
import com.company.elements.invisible.Point;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ObjParse {

    public static String getData(String fullPath) throws IOException {

        Path path = Paths.get(fullPath);

        Stream<String> lines = Files.lines(path);
        String data = lines.collect(Collectors.joining("\n"));
        lines.close();
        return data;
    }

    public ArrayList<Triangle> parseData(String data){
        ArrayList<Point> allPoints  = new ArrayList<Point>();
        ArrayList<Normal> allNormals  = new ArrayList<Normal>();
        ArrayList<Triangle> allTriangles = new ArrayList<Triangle>();

        Scanner scanner = new Scanner(data);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String type = line.substring(0,2);

            switch (type){
                case "v ": {
                    String points = line.substring(line.indexOf(" ") + 1, line.length());
                    String[] output = points.split(" ");

                    allPoints.add(new Point(Double.parseDouble(output[0]),Double.parseDouble(output[1]),
                            Double.parseDouble(output[2])));
                    break;
                }
                case "vn": {
                    String points = line.substring(line.indexOf(" ") + 1, line.length());

                    String[] output = points.split(" ");
                    allNormals.add(new Normal(Double.parseDouble(output[0]),Double.parseDouble(output[1]),
                            Double.parseDouble(output[2])));
                    break;

                }
                    case "f ":
                        String points = line.substring(line.indexOf(" ") + 1, line.length());
                        String[] output = points.split(" ");
                        Point angle1 =
                                allPoints.get(Integer.parseInt(output[0].substring(0,output[0].indexOf('/'))) - 1);
                        Normal norm1 =
                                allNormals.get(Integer.parseInt(output[0].substring(output[0].indexOf('/') + 2,output[0].length())) - 1);
                        Point angle2 =
                                allPoints.get(Integer.parseInt(output[1].substring(0,output[1].indexOf('/'))) - 1);
                        Integer one = Integer.parseInt(output[1].substring(output[1].indexOf('/') + 2,output[1].length())) - 1;
                        Normal norm2 =
                                allNormals.get(one);
                        Point angle3 =
                                allPoints.get(Integer.parseInt(output[2].substring(0,output[2].indexOf('/'))) - 1);
                        Normal norm3 =
                                allNormals.get(Integer.parseInt(output[2].substring(output[2].indexOf('/') + 2,output[2].length())) - 1);
                        allTriangles.add(new Triangle(angle1,angle2,angle3,norm1,norm2,norm3));
                       break;
            }
            // process the line
        }

        scanner.close();
        return allTriangles;
    }



}
