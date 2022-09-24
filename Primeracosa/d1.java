
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDateTime;



public class d1 {
    public static void main(String[] args) throws IOException {
        Timestamp before = Timestamp.valueOf(LocalDateTime.now());
        FileInputStream in = null;
        FileOutputStream out = null;

        try {
            in = new FileInputStream("Biblia.txt");
            out = new FileOutputStream("outagain.txt");
            int c;

            while ((c = in.read()) != -1) {
                out.write(c);
            }
        } finally {
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
        }

        Timestamp after = Timestamp.valueOf(LocalDateTime.now());
        System.out.println("Duracion: " + (after.getTime() - before.getTime()));
    }
}