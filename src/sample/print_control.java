package sample;

/**
 * Created by Igor on 17.08.2017.
 */

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.print.PageLayout;
import javafx.print.Printer;
import javafx.print.PrinterJob;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import javafx.stage.Window;

import javax.print.*;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;


public class print_control {
    @FXML
    private TableView<String> table;
    @FXML
private ComboBox<String> printer_list;
    @FXML
    private Button exit_button;
    @FXML
    private Button print_button;

    @FXML
    private Button close_button;
    @FXML
    private Button refresh_button;

    @FXML
    void exit(ActionEvent event){


        ((Stage) ((Button) event.getSource()).getScene().getWindow()).close();
    }

//Get all Printers
@FXML
void set_printers(ActionEvent event) {




}
    @FXML
    void refresh(ActionEvent event) {
        PrintService service = PrintServiceLookup.lookupDefaultPrintService();
        System.out.println(service);


        ObservableList<String> printers = FXCollections.observableArrayList();
        printers.addAll(service.getName());
        printer_list.getItems().addAll(printers);



    }
    @FXML
    void printjob(ActionEvent event) {
        PrinterJob job = PrinterJob.createPrinterJob();

        ObservableList<String> printers2 = FXCollections.observableArrayList(
                "bbjbjbjbn",
                "mkklknknkkmk"
        );


table.getItems().addAll(printers2);
//job.showPageSetupDialog(((Stage) ((Button) event.getSource()).getScene().getWindow()));
job.showPrintDialog(((Stage) ((Button) event.getSource()).getScene().getWindow()));
      job.printPage( table);

    }
}
