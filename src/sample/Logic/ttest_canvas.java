package sample.Logic;



import javafx.animation.*;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.shape.Box;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Sphere;


public class ttest_canvas {

    @FXML
    private Box cube;

    @FXML
    private Circle circle2;

    @FXML
    private Polygon hz3;

    @FXML
    private Rectangle rect2;

    @FXML
    private Sphere sphere;
    @FXML
    private Button b;
    @FXML
    private Canvas canvas;


    @FXML
    void print_view(ActionEvent event) throws Exception{

try {
    Sprite sprite = new Sprite();

    GraphicsContext gc = canvas.getGraphicsContext2D();


canvas.setOnMouseClicked(e->{
    Image image = new Image( "file:C:\\Users\\Andrejs\\My Documents\\db connection\\src\\sample\\t.jpg");
new AnimationTimer() {

    double x=e.getX();
    double y=e.getY();

    @Override
    public void handle(long currentNanoTime) {
        System.out.println("tttttt");




    gc.clearRect(0,0,600,600);

        gc.drawImage(image, 0, 0, 256, 256, 30,30, 256, 256);
        System.out.println("tttttt222222000");
//gc.drawImage(image, 256, 0, 256, 256, 30,30, 256, 256);


        System.out.println("tttttt222222");
    }
}.start();
});



}catch(Exception e){e.printStackTrace();}
    }



    }