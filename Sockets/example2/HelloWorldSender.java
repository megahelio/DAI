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
package es.uvigo.esei.dai.sockets.example2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class HelloWorldSender {
   public static void main(String[] args) {
      try (DatagramSocket socket = new DatagramSocket()) {
         String message = "Hello World";

         DatagramPacket packet = 
            new DatagramPacket(message.getBytes(), message.length(), InetAddress.getLocalHost(), 1234);

         socket.send(packet);
         System.out.println("Mensaje enviado");
      } catch (IOException ioe) {
         System.out.print("Connection error: ");
         System.out.println(ioe.getMessage());
      }
   }
}
