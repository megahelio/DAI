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

import java.io.Serializable;

public class Message implements Serializable {
   private static final long serialVersionUID = 1L;

   private final String subject;
   private final String message;

   public Message(String subject, String message) {
      super();
      this.subject = subject;
      this.message = message;
   }

   public String getSubject() {
      return subject;
   }

   public String getMessage() {
      return message;
   }
}
