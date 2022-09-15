package dojo0;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class d0 {
    public static void main(String[] args) {
        Timestamp before = Timestamp.valueOf(LocalDateTime.now());

        try (FileReader fileReader = new FileReader(new File("Biblia.txt"));
                FileWriter fileWriter = new FileWriter("salida.txt")) {
            int input = fileReader.read();
            while (input != -1) {
                fileWriter.write(input);
                input = fileReader.read();

            }
        } catch (FileNotFoundException e) {
            System.err.println("No Enconrado archivo");
        } catch (IOException e) {

        }

        Timestamp after = Timestamp.valueOf(LocalDateTime.now());
        System.out.println("Duracion: " + (after.compareTo(before)));
    }
}
