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
package es.uvigo.esei.dai.sockets.example1;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class HelloWorldClient {
   public static void main(String[] args) {
      try (Socket socket = new Socket("localhost", 12345)) {
         System.out.println("Local port: " + socket.getLocalPort());
         InputStream input = socket.getInputStream();

         int read;
         while ((read = input.read()) != -1) {
            System.out.print((char) read);
         }
         System.out.println();

         // El InputStream se cerrará cuando se cierre el Socket
      } catch (UnknownHostException e) {
         System.out.println("Unknown host: localhost");
      } catch (IOException e) {
         System.out.print("Connection error: ");
         System.out.println(e.getMessage());
      }
   }
}
