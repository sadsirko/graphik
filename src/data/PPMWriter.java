package data;

import com.company.Colour;
import com.company.equipment.Screen;

import java.io.FileWriter;
import java.io.IOException;
import java.text.CharacterIterator;

public class PPMWriter {

    public void write(Screen screen,String filename){
        try {
            FileWriter myWriter = new FileWriter(filename);
            myWriter.write("P3\n");
            myWriter.write(screen.getResolutionX().toString() + ' ' + screen.getResolutionY().toString() + '\n');
            myWriter.write("256\n");

            for (int i = 0; i < screen.getResolutionY(); i ++){
                for (int j = 0; j < screen.getResolutionX(); j ++){
                    Colour colour = screen.getPixelMatrix()[i][j].getColour();
                    myWriter.write(colour.getRed().toString() + ' '
                            + colour.getGreen().toString() + ' ' + colour.getBlue().toString() + '\n');
            }
            }

            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}

