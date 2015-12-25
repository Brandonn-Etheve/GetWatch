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
package get.watch;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.text.Font;

/**
 *
 * @author brandonn-Etheve
 */
public class Control {
    @FXML
    private Label displayLabel;
 
    public Control(Label displayLabel)
    {
        this.displayLabel=displayLabel;
    }
    
    public void setDisplay(String text)
    {
        Platform.runLater(() -> {
            displayLabel.setText(text);
            displayLabel.setVisible(true);
        });
    }
    
    public void setDisplaySize(int size)
    {
       
        Platform.runLater(() -> {displayLabel.setStyle("-fx-font: "+size+" LCD5x8H;");});
    }
}
