package lv.myProject.java2.fxmlViewControllers;


import com.mysql.cj.x.protobuf.MysqlxSession;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import lv.myProject.java2.Domain.Person;
import lv.myProject.java2.Domain.Person1;
import org.springframework.stereotype.Component;
import java.sql.SQLException;

@Component
public class MainWindowController {

    double currentX=0;
    double currentY=0;
    double cursorX=0;
    double cursorY=0;
    double xOff;
    double yOff;
    double xOffset = 0.0;
    double yOffset = 0.0;
    boolean isWindowMaximized;

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
    private Button closeButton;
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
    @FXML
    public Circle windowResizeCircle;
    @FXML
    public Rectangle move;
    @FXML
    public Label moveLabel;
    @FXML
    public Button aboutButton;
    @FXML
    private TextField firstNameField;
    @FXML
    private TextField phoneNumberField;
    @FXML
    private TextField lastNameField;
    @FXML
    private TextField personCodeField;
    @FXML
    private TextField emailField;
    @FXML
    private Button removePersonButton;

    @FXML
    DbConnectionController dbConnectionController;

    ObservableList<Person> list = FXCollections.observableArrayList();

    @FXML
    void addPerson() throws SQLException {

        Person1 person = new Person1();
        person.setFirstName(firstNameField.getText());
        person.setLastName(lastNameField.getText());
        person.setPersonCode(personCodeField.getText());
        person.setEmail(emailField.getText());
        person.setPhoneNumber(phoneNumberField.getText());

        dbConnectionController.personDatabase.addPerson(person);

        lastNameField.clear();
    }

    @FXML
    void removePerson() {
    }

    @FXML
    void windowResize(){

        try {
            System.out.println("resizing...");
            windowResizeCircle.setOnMousePressed(e -> {
                cursorX = e.getScreenX();
                cursorY = e.getScreenY();

                currentX = ((Circle) e.getSource()).getScene().getWindow().getX();
                currentY = ((Circle) e.getSource()).getScene().getWindow().getY();

            });
            windowResizeCircle.setOnMouseDragged(e -> {
                cursorX = e.getScreenX();
                cursorY = e.getScreenY();
                xOff = cursorX - currentX;
                yOff = cursorY - currentY;

                ((Circle) e.getSource()).getScene().getWindow().setWidth(xOff);
                ((Circle) e.getSource()).getScene().getWindow().setHeight(yOff);
                if (xOff < 400) {
                    System.out.println("stop");
                    ((Circle) e.getSource()).getScene().getWindow().setWidth(400);
                    ((Circle) e.getSource()).getScene().getWindow().setHeight(400);
                } else if (yOff < 400) {
                    ((Circle) e.getSource()).getScene().getWindow().setHeight(400);
                }

                move.setWidth((xOff - 350));
            });
        }catch (Exception e){e.printStackTrace();
        }
    }

    @FXML
    void windowMove(){
        move.setOnMousePressed(e->{
            xOff=(e.getScreenX()-((Rectangle) e.getSource()).getScene().getWindow().getX());
            yOff=(e.getScreenY()-((Rectangle) e.getSource()).getScene().getWindow().getY());
        });
        move.setOnMouseDragged(e->{
            ((Rectangle) e.getSource()).getScene().getWindow().setX(e.getScreenX()-xOff);
            ((Rectangle) e.getSource()).getScene().getWindow().setY(e.getScreenY()-yOff);
        });
    }

    @FXML
    void exitFromSystem() {
        System.exit(1);
    }

    @FXML
    void printViewWindow() throws Exception {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxml_views/Print.fxml"));
            Parent root1 = fxmlLoader.load();
            Stage stage = new Stage();
            stage.initStyle(StageStyle.UNDECORATED);
            stage.initStyle(StageStyle.TRANSPARENT);
            Scene scene = new Scene(root1, 600, 400);
            stage.setScene(scene);
            stage.show();

            root1.setOnMousePressed(e -> {
                        stage.getX();
                        stage.getY();
                        e.getScreenX();
                        e.getScreenY();
                        xOffset=e.getScreenX()-stage.getX();
                        yOffset=e.getScreenY()- stage.getY();
                    }
            );
            root1.setOnMouseDragged(ev -> {
                stage.setX(ev.getScreenX()- xOffset);
                stage.setY(ev.getScreenY()- yOffset);
                System.out.println(xOffset);
            });
            } catch (Exception e) {
            e.printStackTrace();
            }
    }

    @FXML
    void minimizeWindow(ActionEvent event) {
            System.out.println("minimize...");
            ((Stage) ((Button) event.getSource()).getScene().getWindow()).setIconified(true);
    }

    @FXML
    void maximizeWindow(ActionEvent event) {
            isWindowMaximized =((Stage) ((Button) event.getSource()).getScene().getWindow()).isMaximized();
            if (isWindowMaximized) {
            ((Stage) ((Button) event.getSource()).getScene().getWindow()).setMaximized(false);
            move.setWidth((( ((Button) event.getSource()).getScene().getWindow()).getWidth())-350);
            }else{((Stage) ((Button) event.getSource()).getScene().getWindow()).setMaximized(true);
            move.setWidth((( ((Button) event.getSource()).getScene().getWindow()).getWidth())-350);
        }
    }

    @FXML
    void aboutWindow() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxmlViews/AboutWindow.fxml"));
            Parent root1 = fxmlLoader.load();
            Stage stage = new Stage();
            stage.initStyle(StageStyle.UNDECORATED);
            stage.initStyle(StageStyle.TRANSPARENT);
            Scene scene = new Scene(root1, 300, 200);
            stage.setScene(scene);
            stage.show();
            //MAKE WINDOW DRAG
            root1.setOnMousePressed(e -> {
                        stage.getX();
                        stage.getY();
                        e.getScreenX();
                        e.getScreenY();
                        xOffset=e.getScreenX()-stage.getX();
                        yOffset=e.getScreenY()- stage.getY();
                    }
            );
            root1.setOnMouseDragged(ev -> {
                stage.setX(ev.getScreenX()- xOffset);
                stage.setY(ev.getScreenY()- yOffset);
                System.out.println(xOffset);
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void statement() throws Exception {
        list.add(new Person("andrew", "coooll", "75454545454545454545443"));
        System.out.println("statement....");
       // System.out.println(connection);


        try {

            } catch (Exception e) {
            e.printStackTrace();
            }
          }
}