
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.io.IOException;

public class d2 {
    public static void main(String[] args) throws IOException {
        Timestamp before = Timestamp.valueOf(LocalDateTime.now());
        BufferedReader inputStream = null;
        PrintWriter outputStream = null;

        try {
            inputStream = new BufferedReader(new FileReader("Biblia.txt"));
            outputStream = new PrintWriter(new FileWriter("characteroutput.txt"));

            String l;
            while ((l = inputStream.readLine()) != null) {
                outputStream.println(l);
            }
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
            if (outputStream != null) {
                outputStream.close();
            }
        }
        Timestamp after = Timestamp.valueOf(LocalDateTime.now());
        System.out.println("Duracion: " + (after.getTime() - before.getTime()));
    }
}