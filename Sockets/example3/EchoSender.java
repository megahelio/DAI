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
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;

public class EchoSender {
   public static void main(String[] args) {
      // final Console console = System.console();
      final BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

      try (DatagramSocket socket = new DatagramSocket(new InetSocketAddress(InetAddress.getLocalHost(), 4444))) {
         String line;
         while ((line = console.readLine()) != null) {
            System.out.println("INPUT: " + line);

            byte[] lineData = line.getBytes();
            DatagramPacket packet = new DatagramPacket(lineData, lineData.length, InetAddress.getLocalHost(), 1234);

            // El paquete se envía
            socket.send(packet);

            // Se recibe sobre el mismo paquete. Los datos se sobreescriben
            socket.receive(packet);

            // Fallará cuando se envíe un "quit"
            System.out.println("ECHO: " + new String(packet.getData()));
         }
      } catch (UnknownHostException e) {
         System.out.println("Unknown host: localhost");
      } catch (IOException e) {
         System.out.println("Connection error: " + e.getMessage());
      }
   }
}
