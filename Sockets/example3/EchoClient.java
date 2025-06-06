/**
 *  Temario DAI
 *  Copyright (C) 2014 Miguel Reboiro-Jato
 *  
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *  
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *  
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package es.uvigo.esei.dai.sockets.example3;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class EchoClient {
   public static void main(String[] args) {
//      final Console console = System.console();
      final BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

      try (Socket socket = new Socket("localhost", 1234)) {
         DataInputStream input = new DataInputStream(socket.getInputStream());
         DataOutputStream output = new DataOutputStream(socket.getOutputStream());

         String line;
         while ((line = console.readLine()) != null) {
            System.out.println("INPUT: " + line);

            output.writeUTF(line);

            // Fallará cuando se envíe un "quit"
            System.out.println("ECHO: " + input.readUTF());
         }
      } catch (UnknownHostException e) {
         System.out.println("Unknown host: localhost");
      } catch (IOException e) {
         System.out.println("Connection error: " + e.getMessage());
         e.printStackTrace();
      }
   }
}
