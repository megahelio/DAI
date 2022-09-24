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

public class HelloWorldReceiver {
   public static void main(String[] args) {
      try (DatagramSocket socket = new DatagramSocket(1234)) {
         byte[] buffer = new byte[128];

         DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

         socket.receive(packet);

         final String message = new String(packet.getData(), 0, packet.getLength());
         
         System.out.println("Mensaje recibido: " + message);
      } catch (IOException ioe) {
         System.out.print("Connection error: ");
         System.out.println(ioe.getMessage());
      }
   }
}
