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
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class HelloWorldServer {
   public static void main(String[] args) {
      try (ServerSocket serverSocket = new ServerSocket(12345)) {
         while (true) {
            System.out.println("Antes de accept");

            try (Socket clientSocket = serverSocket.accept()) {
               System.out.println("Después de accept");

               OutputStream output = clientSocket.getOutputStream();

               output.write("Hello world".getBytes());
               output.flush();
            }
         }
      } catch (IOException e) {
         System.err.println("Server socket could not be created");
      }
   }
}
