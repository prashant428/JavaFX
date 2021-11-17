package exercise1;
//importing libraries
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Student extends Application {
    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) {
        // Create a pane and set its properties
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
        pane.setHgap(5.5);
        pane.setVgap(5.5);
        //Declare Fields
        TextField txtName=new TextField();
        TextField txtAddress=new TextField();
        TextField txtProvince=new TextField();
        TextField txtCity=new TextField();
        TextField txtPostal=new TextField();
        TextField txtPhone=new TextField();
        TextField txtEmail=new TextField();

        CheckBox chkStudent=new CheckBox("Student Council");
        CheckBox chkVolunteer=new CheckBox("Volunteer Work");

        RadioButton rbComputer=new RadioButton("Computer Science");
        RadioButton rbBusiness=new RadioButton("Business");
        //creating toggle group for radio buttons
        ToggleGroup group = new ToggleGroup();
        rbComputer.setToggleGroup(group);
        rbBusiness.setToggleGroup(group);
        //declaring computer courses
         String[] compCourses = {"Python", "CSharp", "Java",
                "JavaScript", "Web Design", "System Design", "English", "Linux",
                "Database Concepts"};
         String[] businessCourses={"Business Administration", "Business Analytics", "Entrepreneurship",
                "English", "Mathematics", "History"};

         //declaring combobox and listview
        ComboBox<String> cbo= new ComboBox<>();
        ListView<String> lv = new ListView<>();
        //event handler that displays computer and business courses depending on the button chosen
        cbo.setValue("English");
        rbComputer.setOnAction((e)->{  if(rbComputer.isSelected()) {
            cbo.getItems().clear();
            lv.getItems().clear();
            ObservableList<String> items =
                    FXCollections.observableArrayList(compCourses);
            cbo.getItems().addAll(items);
        }
        });

        rbBusiness.setOnAction((e)->{ if(rbBusiness.isSelected()) {
            cbo.getItems().clear();
            lv.getItems().clear();
            ObservableList<String> items =
                    FXCollections.observableArrayList(businessCourses);
            cbo.getItems().addAll(items);
        }
        });
        //event handler that displays courses on listbox depending the one chosen on combobox
        lv.setPrefHeight(100);
        lv.setPrefWidth(30);

        cbo.setOnAction((e)->{
            if(!lv.getItems().contains(cbo.getSelectionModel().getSelectedItem())) {
                lv.getItems().add(cbo.getSelectionModel().getSelectedItem());
            }
        });
        //defining text area
        TextArea textarea=new TextArea();
        textarea.setPrefRowCount(5);
        textarea.setPrefColumnCount(20);

        // Place nodes in the pane
        pane.add(new Label(" Name:"), 0, 0);
        pane.add(txtName, 1, 0);
        pane.add(new Label("Address:"), 0, 1);
        pane.add(txtAddress, 1, 1);
        pane.add(new Label("Province:"), 0, 2);
        pane.add(txtProvince, 1, 2);
        pane.add(new Label("City"), 0, 3);
        pane.add(txtCity, 1, 3);
        pane.add(new Label("Postal Code"), 0, 4);
        pane.add(txtPostal, 1, 4);
        pane.add(new Label("Phone Number"), 0, 5);
        pane.add(txtPhone, 1, 5);
        pane.add(new Label("Email"), 0, 6);
        pane.add(txtEmail, 1, 6);
        pane.add(chkStudent, 3, 2);
        pane.add(chkVolunteer, 3, 5);
        pane.add(rbComputer, 6, 0);
        pane.add(rbBusiness, 7, 0);
        pane.add(cbo, 7, 1);
        pane.add(lv, 7, 2);
        pane.add(textarea, 1, 8);

        //event handler that displays student info on the textarea once button is clicked
        Button btDisplay = new Button("Display");
        pane.add(btDisplay, 1, 7);
        GridPane.setHalignment(btDisplay, HPos.RIGHT);

        btDisplay.setOnAction((e)->{
            String extra="";
            if(chkStudent.isSelected())
                extra+=" "+chkStudent.getText()+ ";";
            if(chkVolunteer.isSelected())
                extra+=" "+chkVolunteer.getText()+ ";";

            RadioButton chk=(RadioButton) group.getSelectedToggle();

            textarea.setText("Name: "+ txtName.getText()+
                    "\nAddress: "+txtAddress.getText()+
                    ", "+txtCity.getText()+
                    ", "+txtProvince.getText()+
                    ", "+txtPostal.getText()+
                    "\nPhone: "+txtPhone.getText()+
                    "\nEmail: "+txtEmail.getText()+
                    "\nProgram: "+ chk.getText()+
                    "\nCourses: "+ lv.getItems()+
                    "\nExtracurriculars: "+ extra
            );
        });

        // Create a scene and place it in the stage
        Scene scene = new Scene(pane);
        primaryStage.setTitle("Student Information"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
    }

    /**
     * The main method is only needed for the IDE with limited
     * JavaFX support. Not needed for running from the command line.
     */
    public static void main(String[] args) {
        launch(args);
    }
}