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
import user.Teacher;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Create a tab containing a TableView of all teachers
 */
public class TeacherController extends Tab {

    private Button addButton;
    private Button deleteButton;
    private Button editButton;

    private TextField name;
    private TextField lastName;
    private TextField email;
    private TextField phone;
    private TextField degree;


    /**
     * @param connection
     */
    public TeacherController(Connection connection) {
        this.setText("Teacher Panel");
        TableView table = new TableView();
        setUpTables(table);
        VBox vb = new VBox();
        setUpPanel(vb,table);

        DatabaseController databaseController = new DatabaseController(connection);
        ArrayList<Teacher> teacherArrayList = databaseController.getTeachersInDatabase();
        ObservableList<Teacher> observableTeacherList = FXCollections.observableArrayList(teacherArrayList);
        table.setItems(observableTeacherList);
        table.setOnMousePressed(event -> editTeacher(observableTeacherList,table.getSelectionModel().getSelectedIndex()));
        addButton.setOnAction(event -> addTeacher(observableTeacherList,getUserInput(),databaseController));
        deleteButton.setOnAction(event -> deleteTeacher(observableTeacherList,table.getSelectionModel().getSelectedIndex(),databaseController));
        editButton.setOnAction(event -> updateTeacher(observableTeacherList,table.getSelectionModel().getSelectedIndex(),getUserInput(),databaseController));
        this.setContent(vb);

    }
    /**
     * @param teacherList The teacher list
     * @param teacherIndex The teacher index
     * delete the teacher at the list index
     */
    private void editTeacher(ObservableList<Teacher> teacherList, int teacherIndex){
        Teacher teacherToBeEdited = teacherList.get(teacherIndex);
        name.setText(teacherToBeEdited.getName().getFirstName());
        lastName.setText(teacherToBeEdited.getName().getLastName());
        email.setText(teacherToBeEdited.getEmail());
        phone.setText(teacherToBeEdited.getPhone());
        degree.setText(teacherToBeEdited.getDegree());

    }

    /**
     * @param teacherList
     * @param teacherIndex
     * @param userInput
     * @param databaseController
     */
    private void updateTeacher(ObservableList<Teacher> teacherList, int teacherIndex, Map<String, String> userInput, DatabaseController databaseController){
        if (teacherIndex!=-1){
            Teacher teacherToBeEdited = teacherList.get(teacherIndex);
            Teacher teacherUpdated = new Teacher(teacherToBeEdited.getId(),new Name(userInput.get("name"), userInput.get("lastName")),
                    userInput.get("email"),
                    userInput.get("phone"),
                    userInput.get("degree"));
            teacherList.set(teacherIndex,teacherUpdated);
            databaseController.updateTeacher(teacherUpdated.getId(),teacherUpdated);
        }

    }


    /**
     * @param teacherList
     * @param teacherIndex
     * @param databaseController
     */
    private void deleteTeacher(ObservableList<Teacher> teacherList,int teacherIndex,DatabaseController databaseController) {
        Teacher teacherToBeRemoved = teacherList.get(teacherIndex);
        teacherList.remove(teacherToBeRemoved);
        databaseController.deleteTeacher(teacherToBeRemoved.getId());
    }

    /**
     * @param teacherList
     * @param userInput
     * @param databaseController
     */
    private void addTeacher(ObservableList<Teacher> teacherList, Map<String, String> userInput,DatabaseController databaseController){
        Teacher teacherToBeAddedToDB = new Teacher(0,new Name(userInput.get("name"), userInput.get("lastName")),
                userInput.get("email"),
                userInput.get("phone"),
                userInput.get("degree"));
        teacherList.add(teacherToBeAddedToDB);
        databaseController.addTeacher(teacherToBeAddedToDB);
    }

    /**
     * @return Retrieve User input in a <String,String>Map
     */
    private Map<String, String> getUserInput(){

        Map<String, String> userInput = new HashMap<String, String>() {{
            put("name",name.getText());
            put("lastName",lastName.getText());
            put("email",email.getText());
            put("phone",phone.getText());
            put("degree",degree.getText());
        }};

        return userInput;
    }

    /**
     * @param table
     */
    private void setUpTables(TableView table){

        TableColumn nameTable = new TableColumn("Name");
        TableColumn emailTable = new TableColumn("email");
        TableColumn phoneTable = new TableColumn("phone");
        TableColumn degreeTable = new TableColumn("Degree");
        ObservableList<TableColumn> tableColumns = FXCollections.observableArrayList(
                nameTable ,
                emailTable,
                phoneTable,
                degreeTable
        );

        table.setEditable(true);
        table.getColumns().addAll(tableColumns);
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        nameTable.setCellValueFactory(new PropertyValueFactory<Teacher, String>("name"));
        emailTable.setCellValueFactory(new PropertyValueFactory<Teacher, String>("email"));
        phoneTable.setCellValueFactory(new PropertyValueFactory<Teacher, String>("phone"));
        degreeTable.setCellValueFactory(new PropertyValueFactory<Teacher, String>("degree"));

    }

    /**
     * @param vb
     * @param table
     */
    private void setUpPanel(VBox vb,TableView table){

        vb.setSpacing(5);
        vb.setPadding(new Insets(10, 0, 0, 10));
        HBox hb  = new HBox();
        addButton = new Button("Add\n");
        deleteButton = new Button("Delete\n");
        editButton= new Button("Edit\n");

        name =            new TextField();
        lastName =        new TextField();
        email =           new TextField();
        phone=            new TextField();
        degree=           new TextField();


        Label nameLabel = new Label("Name");
        Label lastNameLabel = new Label("LastName");
        Label emailLabel = new Label("Email");
        Label phoneLabel = new Label("Phone");
        Label degreeLabel = new Label("Degree");

        GridPane gp = new GridPane();
        gp.add(nameLabel,0,0);
        gp.add(lastNameLabel,1,0);
        gp.add(emailLabel,2,0);
        gp.add(phoneLabel,3,0);
        gp.add(degreeLabel,4,0);
        gp.add(deleteButton,5,0);
        gp.add(editButton,6,0);

        gp.add(name,0,1);
        gp.add(lastName,1,1);
        gp.add(email,2,1);
        gp.add(phone,3,1);
        gp.add(degree,4,1);
        gp.add(addButton,5,1);

        hb.getChildren().add(gp);
        hb.setSpacing(3);
        vb.getChildren().addAll(table,hb);
    }



}

