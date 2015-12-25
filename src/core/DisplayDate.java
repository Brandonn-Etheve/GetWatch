/*
 * Copyright (C) 2015 brandonn-Etheve
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package core;

import static get.watch.FXMLDocumentController.control;
import static get.watch.FXMLDocumentController.isDisplay;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author brandonn-Etheve
 */
public class DisplayDate implements Runnable {

    @Override
    public void run() 
    {
        Date d= new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        control.setDisplaySize(20);
        control.setDisplay(sdf.format(d)); 
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            Logger.getLogger(DisplayTime.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        isDisplay=true;
    }
    
}
