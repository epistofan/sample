package sample.Logic;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import sample.B_Logic.AddPerson;
import sample.Person;


import java.sql.Connection;


public class MainWindowController {


    double width;
    double testx;
    double testy;
    double X;
    double Y;
    double xOff;
    double yOff;
    double xOffset = 0.0;
    double yOffset = 0.0;
    boolean w;

    AddPerson addPerson = new AddPerson();
    @FXML
    private Button max_button;
    @FXML
    private Button addPersonButton;
    @FXML
    private Button button_min;
    @FXML
    private Button step1;
    @FXML
    private Button button_b;
    @FXML
    public Button button_m;
    @FXML
    private Button but_close;
    @FXML
    public Button print_view_button;
    @FXML
    public TableView<Person> tableOfPersons;
    @FXML
    public Label test1;
    @FXML
    public Button statm;
    @FXML
    private Button refresh;

    public Connection connection;
    @FXML
    public Circle windowResizeCircle;
    @FXML
    public Rectangle move;
    @FXML
    public Label moveLabel;
    @FXML
    public Button about;
    @FXML
    private TextField firstNameField;
    @FXML
    private TextField phoneField;
    @FXML
    private TextField lastNameField;
    @FXML
    private Label lastNameLabel;
    @FXML
    private Label phoneLabel;
    @FXML
    private Label firstNameLabel;
    @FXML
    private Button removePersonButton;

    ObservableList<Person> list = FXCollections.observableArrayList();

    @FXML
    void addPerson() {
        String returned =(
        addPerson.addPerson(lastNameField.getText(),
                            firstNameField.getText(),
                            phoneField.getText()));

        moveLabel.setText(returned);
        lastNameField.clear();


    }

    @FXML
    void removePerson(ActionEvent event) {

    }

    @FXML
    //window resize
    void windowResize(){
        try {
            System.out.println("resizing...");
            windowResizeCircle.setOnMousePressed(e -> {
                X = e.getScreenX();
                Y = e.getScreenY();
                System.out.println(X + Y + "test gov");

                testx = ((Circle) e.getSource()).getScene().getWindow().getX();
                testy = ((Circle) e.getSource()).getScene().getWindow().getY();
                width = ((Circle) e.getSource()).getScene().getWindow().getWidth();

            });
            windowResizeCircle.setOnMouseDragged(e -> {
                X = e.getScreenX();
                Y = e.getScreenY();
                xOff = X - testx;
                yOff = Y - testy;
                System.out.println(xOff + "eto raznica");
                width = ((Circle) e.getSource()).getScene().getWindow().getWidth();
                ((Circle) e.getSource()).getScene().getWindow().setWidth(xOff);
                ((Circle) e.getSource()).getScene().getWindow().setHeight(yOff);
                if (xOff < 400) {
                    System.out.println("stop");
                    ((Circle) e.getSource()).getScene().getWindow().setWidth(400);

                } else if (yOff < 400) {
                    ((Circle) e.getSource()).getScene().getWindow().setHeight(400);
                }
                System.out.println(testx + "drag");

                move.setWidth((xOff - 350));
            });
        }catch (Exception e){e.printStackTrace();
        }

    }
    @FXML
        //window move
    void but_move(){
        move.setOnMousePressed(e->{
            xOff=(e.getScreenX()-((Rectangle) e.getSource()).getScene().getWindow().getX());
            yOff=(e.getScreenY()-((Rectangle) e.getSource()).getScene().getWindow().getY());

        });


        move.setOnMouseDragged(e->{
            System.out.println("drrr");
            System.out.println(((Rectangle) e.getSource()).getScene().getWindow().getX());
            System.out.println(e.getScreenX());


            ((Rectangle) e.getSource()).getScene().getWindow().setX(e.getScreenX()-xOff);
            ((Rectangle) e.getSource()).getScene().getWindow().setY(e.getScreenY()-yOff);

        });

    }
    @FXML
    void but_close(ActionEvent event) {
        System.exit(1);
    }
    @FXML
    void print_view(ActionEvent event) throws Exception {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxml_views/MainWindow.fxml"));
            Parent root1 = fxmlLoader.load();

            Stage stage = new Stage();
            stage.initStyle(StageStyle.UNDECORATED);
            stage.initStyle(StageStyle.TRANSPARENT);
            Scene scene = new Scene(root1, 600, 400);

            stage.setScene(scene);

            stage.show();
//MAKE WINDOW DRAG

            root1.setOnMousePressed(e -> {
                        System.out.println("test");



                        stage.getX();
                        stage.getY();
                        e.getScreenX();
                        e.getScreenY();
                        xOffset=e.getScreenX()-stage.getX();
                        System.out.println(xOffset);
                        yOffset=e.getScreenY()- stage.getY();

                    }


            );

            root1.setOnMouseDragged(ev -> {

                System.out.println(stage.getY());
                System.out.println(stage.getX());


                stage.setX(ev.getScreenX()- xOffset);
                stage.setY(ev.getScreenY()- yOffset);
                System.out.println(xOffset);

            });


        } catch (Exception e) {
            e.printStackTrace();


        }


    }
    @FXML
    void minimize(ActionEvent event) {

        System.out.println("min");
//vlijanije na primaryStage
        ((Stage) ((Button) event.getSource()).getScene().getWindow()).setIconified(true);

    }

    @FXML
    void maximize(ActionEvent event) {


//vlijanije na primaryStage
        //check if window is maximized or minimized
        w =((Stage) ((Button) event.getSource()).getScene().getWindow()).isMaximized();

if (w ==true) {


    ((Stage) ((Button) event.getSource()).getScene().getWindow()).setMaximized(false);
    move.setWidth((((Stage) ((Button) event.getSource()).getScene().getWindow()).getWidth())-350);
    }else{((Stage) ((Button) event.getSource()).getScene().getWindow()).setMaximized(true);
    System.out.println("bljan"+(((Stage) ((Button) event.getSource()).getScene().getWindow()).getWidth()));
    move.setWidth((((Stage) ((Button) event.getSource()).getScene().getWindow()).getWidth())-350);
}
    }

    @FXML
    void about(ActionEvent event) {
      //  Main_window_controller main = new Main_window_controller();
       // db_conn_control dbc = new db_conn_control(main);
       // test1.setText(dbc.govneco());

                    list.add(new Person("gavno", "zhopin", "2328634354824"));
                    list.add(new Person("gavno2", "sukin", "2542543"));
                    list.add(new Person("pidr", "lohan", "784451212543"));
                    list.add(new Person("gunr", "alektrik", "75454545454545454545443"));


        TableColumn<Person, String> column1 = new TableColumn<>("firstname");
        TableColumn<Person, String> column2 = new TableColumn<>("lastname");
        TableColumn<Person, String> column3 = new TableColumn<>("phone");
        PropertyValueFactory<Person, String> firstNameProperty =
            new PropertyValueFactory<>("firstName");

        PropertyValueFactory<Person, String> lastNameProperty =
            new PropertyValueFactory<>("lastName");

        PropertyValueFactory<Person, String> phoneProperty =
            new PropertyValueFactory<>("phone");


        column1.setCellValueFactory(firstNameProperty);
        column2.setCellValueFactory(lastNameProperty);
        column3.setCellValueFactory(phoneProperty);
        tableOfPersons.setEditable(true);


        tableOfPersons.setItems(list);



            System.out.println("esasss");


        tableOfPersons.getColumns().setAll(column1, column2, column3);
    }
    @FXML
    void statement() throws Exception {
        list.add(new Person("andrew", "coooll", "75454545454545454545443"));
        System.out.println("statement....");
       // System.out.println(connection);


        try {
            //db_conn_control dbc = new db_conn_control();
            //dbc.statement(connection);
            } catch (Exception e) {
            e.printStackTrace();
            }
        //dialogController.statement();




    }


}