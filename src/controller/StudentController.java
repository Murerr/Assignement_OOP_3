package controller;

import database.DatabaseController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import user.Name;
import user.Student;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Create a tab containing a TableView of all car
 */
public class StudentController extends javafx.scene.control.Tab {

    private Button addButton;
    private Button deleteButton;

    private TextField name;
    private TextField lastName;
    private TextField email;
    private TextField phone;
    private TextField dob;



    public StudentController(Connection connection) {
        this.setText("Student Panel");
        TableView table = new TableView();
        setUpTables(table);
        VBox vb = new VBox();
        setUpPanel(vb,table);

        DatabaseController databaseController = new DatabaseController(connection);
        ArrayList<Student> studentArrayList = databaseController.getStudentsInDatabase();
        ObservableList<Student> observableStudentList = FXCollections.observableArrayList(studentArrayList);
        table.setItems(observableStudentList);

        //addButton.setOnAction(event -> addCar(studentList,getUserInput()));
        deleteButton.setOnAction(event -> deleteStudent(observableStudentList,table.getSelectionModel().getSelectedIndex(),databaseController));

        this.setContent(vb);

    }

    /**
     * @param studentList The car list to be clone
     * Clone the first element of the list 1000 times
     * If the list is empty nothing happend
     */
    private void cloneMyCars(ObservableList<Student> studentList) {
        if (!studentList.isEmpty()){
            Student carToBeCloned = studentList.get(0);
            ArrayList<Student> tempList = new ArrayList<Student>();
            for (int i=0;i<1000;i++){
                try {
                    Student car = carToBeCloned.clone();
                    tempList.add(car);
                } catch (CloneNotSupportedException e) {
                    e.printStackTrace();
                }
            }
            studentList.addAll(tempList);
        }
    }

    /**
     * @param studentList The student list
     * @param studentIndex The student index
     * delete the student at the list index
     */
    private void deleteStudent(ObservableList<Student> studentList,int studentIndex,DatabaseController databaseController) {
        Student studentToBeRemoved = studentList.get(studentIndex);
        studentList.remove(studentToBeRemoved);
        databaseController.deleteStudent(studentToBeRemoved.getId());
    }

    /*private void addCar(ObservableList<Student> studentList, Map<String, String> userInput){
        studentList.add( new Student(new Name("Jean","Patrick"),"jeanPatrick@gmail.com","+353 8521 1258 21","21/03/1997","TEST"));
    }*/

    /**
     * @return Retrieve User input in a <String,String>Map
     */
    /*private Map<String, String> getUserInput(){

        Map<String, String> userInput = new HashMap<String, String>() {{
            put("store",store.getText());
            put("model",model.getText());
            put("registration",registration.getText());
            put("millage",millage.getText());
            put("yearOfManufacture",yearOfManufacture.getText());
        }};

        return userInput;
    }*/

    private void setUpTables(TableView table){

        TableColumn nameTable = new TableColumn("Name");
        TableColumn emailTable = new TableColumn("email");
        TableColumn phoneTable = new TableColumn("phone");
        TableColumn dobTable = new TableColumn("Date of Birth");
        TableColumn classTable = new TableColumn("Class Name");
        ObservableList<TableColumn> tableColumns = FXCollections.observableArrayList(
                nameTable ,
                emailTable,
                phoneTable,
                dobTable,
                classTable
        );

        table.setEditable(true);
        table.getColumns().addAll(tableColumns);
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        nameTable.setCellValueFactory(new PropertyValueFactory<Student, String>("name"));
        emailTable.setCellValueFactory(new PropertyValueFactory<Student, String>("email"));
        phoneTable.setCellValueFactory(new PropertyValueFactory<Student, String>("phone"));
        dobTable.setCellValueFactory(new PropertyValueFactory<Student, String>("dob"));
        classTable.setCellValueFactory(new PropertyValueFactory<Student, String>("className"));

    }

    private void setUpPanel(VBox vb,TableView table){

        vb.setSpacing(5);
        vb.setPadding(new Insets(10, 0, 0, 10));
        HBox hb  = new HBox();
        addButton = new Button("Add\n");
        deleteButton = new Button("Delete\n");

        name =            new TextField();
        lastName =        new TextField();
        email =           new TextField();
        phone=            new TextField();
        dob =             new TextField();

        Label nameLabel = new Label("Name");
        Label lastNameLabel = new Label("LastName");
        Label emailLabel = new Label("Email");
        Label phoneLabel = new Label("Phone");
        Label dobLabel = new Label("Date of Birth");

        GridPane gp = new GridPane();
        gp.add(nameLabel,0,0);
        gp.add(lastNameLabel,1,0);
        gp.add(emailLabel,2,0);
        gp.add(phoneLabel,3,0);
        gp.add(dobLabel,4,0);
        gp.add(deleteButton,5,0);

        gp.add(name,0,1);
        gp.add(lastName,1,1);
        gp.add(email,2,1);
        gp.add(phone,3,1);
        gp.add(dob,4,1);
        gp.add(addButton,5,1);

        hb.getChildren().add(gp);
        hb.setSpacing(3);
        vb.getChildren().addAll(table,hb);
    }



}

