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

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class EchoReceiver {
   private static final int PACKET_LENGTH = 1024;

   public static void main(String[] args) {
      try (DatagramSocket receiverSocket = new DatagramSocket(1234)) {
         while (true) {
            DatagramPacket packet = new DatagramPacket(new byte[PACKET_LENGTH], PACKET_LENGTH);

            // Recepción del paquete
            receiverSocket.receive(packet);

            // Conversión a mayúsculas
            String mensajeMay = new String(packet.getData(), 0, packet.getLength()).toUpperCase();
            packet.setData(mensajeMay.getBytes());

            // Reenvío del paquete
            receiverSocket.send(packet);
         }
      } catch (IOException e) {
         System.err.println("Server socket could not be created");
      }
   }
}
