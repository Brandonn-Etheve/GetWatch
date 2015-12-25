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

import core.DisplayDate;
import core.DisplaySpDate;
import core.DisplayTime;
import static get.watch.GetWatch.control2;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author brandonn-Etheve
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label titreLabel= new Label();
    @FXML
    private Label displayLabel=new Label();
    @FXML
    private ImageView timeImgView;
    @FXML
    private ImageView dateImgView;
    @FXML
    private ImageView dateSpImgView;
    @FXML
    private Rectangle screenRectangle1;
     @FXML
    private Rectangle screenRectangle2;
     @FXML
    private Rectangle titleRectangle;
     @FXML
     private ColorPicker colorPicker = new ColorPicker(Color.RED);
    
     private final int ScreenArc=15;
     public static Control control;
     private Thread displayThread;
     static double XdeDepart,YdeDepart;
     public static boolean isDisplay=false;
     private boolean colorPickerVisible=false;
     
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       control=new Control(displayLabel);
        displayLabel.setVisible(false);
        screenRectangle1.setArcHeight(ScreenArc);
        screenRectangle1.setArcWidth(ScreenArc);
        screenRectangle2.setArcHeight(ScreenArc);
        screenRectangle2.setArcWidth(ScreenArc);
        colorPicker.setValue(Color.RED);
        colorPicker.setVisible(false);
         isDisplay=true;
       new Thread(new DisplayTime()).start(); 
   
      
    }    
    @FXML
     private void close_Clicked()
     { 
       System.exit(0);
     }
    @FXML
    private void mousePressed(MouseEvent evt){
     XdeDepart = evt.getSceneX();
     YdeDepart = evt.getSceneY();  
    }
      @FXML
    private void mouseDragged(MouseEvent evt){
    control2.getStage().setX(evt.getScreenX()-XdeDepart);
    control2.getStage().setY(evt.getScreenY()-YdeDepart);
     
    }
    
    
    
    
    
       @FXML
    private void dateImgView_Clicked() {
        isDisplay=false;
        
     if(displayThread==null||!displayThread.isAlive()) 
     {
         displayThread= new Thread(new DisplayDate());
         displayThread.start();
     } 
    }
    @FXML
    private void dateImgView_Entered() {
        dateImgView.setImage(new Image("/img/focused.jpg"));
    }
       @FXML
    private void dateImgView_Exited() {
         dateImgView.setImage(new Image("/img/unfocused.jpg"));
    }
       @FXML
    private void dateImgView_Pressed() {
         dateImgView.setImage(new Image("/img/cliked.jpg"));
    }
       @FXML
    private void dateImgView_Released() {
         dateImgView.setImage(new Image("/img/focused.jpg"));
    }
    
    
    
    
    
     @FXML
    private void dateSpImgView_Clicked() {
         isDisplay=false;
     if(displayThread==null||!displayThread.isAlive()) 
     {
         displayThread= new Thread(new DisplaySpDate());
         displayThread.start();
     } 
    }
    @FXML
    private void dateSpImgView_Entered() {
        dateSpImgView.setImage(new Image("/img/focused.jpg"));
    }
       @FXML
    private void dateSpImgView_Exited() {
         dateSpImgView.setImage(new Image("/img/unfocused.jpg"));
    }
       @FXML
    private void dateSpImgView_Pressed() {
         dateSpImgView.setImage(new Image("/img/cliked.jpg"));
    }
       @FXML
    private void dateSpImgView_Released() {
         dateSpImgView.setImage(new Image("/img/focused.jpg"));
    }
    
   @FXML
  private void colorChoosen()
  {
    
     
      titreLabel.setTextFill(colorPicker.getValue());
      displayLabel.setTextFill(colorPicker.getValue());
      screenRectangle2.setFill(colorPicker.getValue());
      titleRectangle.setFill(colorPicker.getValue());
  }
  @FXML
  private void displayLabel_Clicked()
  {
      if(colorPickerVisible==false)
      {
          colorPicker.setVisible(true);
          colorPickerVisible=true;
      }
      else
      {
          colorPicker.setVisible(false);
          colorPickerVisible=false;
      }
  }
    
  
}
