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
package es.uvigo.esei.dai.sockets.example4;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Date;

public class MessageSender {
   public static void main(String[] args) {
      try (DatagramSocket socket = new DatagramSocket()) {
         ByteArrayOutputStream output = new ByteArrayOutputStream(1500);
         ObjectOutputStream dataOutput = new ObjectOutputStream(output);

         Message message = new Message("Time", "Current time: " + new Date());
         System.out.println("SUBJECT: " + message.getSubject());
         System.out.println("MESSAGE: " + message.getMessage());
         dataOutput.writeObject(message);

         DatagramPacket packet = new DatagramPacket(output.toByteArray(), output.size(), InetAddress.getLocalHost(),
               1234);

         socket.send(packet);
      } catch (IOException ioe) {
         ioe.printStackTrace();
         System.out.print("Connection error: ");
         System.out.println(ioe.getMessage());
      }
   }
}
