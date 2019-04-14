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
import school.Module;
import user.Name;
import user.Student;
import user.Teacher;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Create a tab containing a TableView of all car
 */
public class ModuleController extends Tab {

    private Button addButton;
    private Button deleteButton;
    private Button editButton;

    private TextField moduleName;
    private TextField moduleCode;
    private TextField teacherName;
    private TextField averageGrade;


    public ModuleController(Connection connection) {
        this.setText("Module Panel");
        TableView table = new TableView();
        setUpTables(table);
        VBox vb = new VBox();
        setUpPanel(vb,table);

        DatabaseController databaseController = new DatabaseController(connection);
        ArrayList<Module> moduleArrayList = databaseController.getModuleInDatabase();
        ObservableList<Module> observableModuleList = FXCollections.observableArrayList(moduleArrayList);
        table.setItems(observableModuleList);

        table.setOnMousePressed(event -> editModule(observableModuleList,table.getSelectionModel().getSelectedIndex()));
        addButton.setOnAction(event -> addModule(observableModuleList,getUserInput(),databaseController));
        deleteButton.setOnAction(event -> deleteModule(observableModuleList,table.getSelectionModel().getSelectedIndex(),databaseController));
        editButton.setOnAction(event -> updateModule(observableModuleList,table.getSelectionModel().getSelectedIndex(),getUserInput(),databaseController,table.getSelectionModel().getSelectedItem()));
        this.setContent(vb);
    }

    private void editModule(ObservableList<Module> moduleList, int moduleIndex){
        Module moduleToBeEdited = moduleList.get(moduleIndex);
        moduleName.setText(moduleToBeEdited.getName());
        moduleCode.setText(moduleToBeEdited.getCode());
        teacherName.setText(moduleToBeEdited.getTeacher().toString());
        averageGrade.setText(String.valueOf(moduleToBeEdited.getAverageGrade()));
    }
    private void updateModule(ObservableList<Module> moduleList, int moduleIndex, Map<String, String> userInput, DatabaseController databaseController, Object selectedItem){
        if (moduleIndex!=-1){
            Module moduleUpdated = new Module(0,
                    userInput.get("name"),
                    userInput.get("code"),
                    new Name(userInput.get("teacher"),userInput.get("teacher")),
                    Integer.valueOf(userInput.get("average")));
            moduleList.set(moduleIndex,moduleUpdated);
            Module mymodule = (Module) selectedItem;
            databaseController.updateModule(mymodule.getId(),moduleUpdated);
        }

    }

    /**
     * @param moduleList The student list
     * @param moduleIndex The student index
     * delete the student at the list index
     */
    private void deleteModule(ObservableList<Module> moduleList,int moduleIndex,DatabaseController databaseController) {
        Module moduleToBeRemoved = moduleList.get(moduleIndex);
        moduleList.remove(moduleToBeRemoved);
        databaseController.deleteModule(moduleToBeRemoved.getId());
    }

    private void addModule(ObservableList<Module> moduleList, Map<String, String> userInput,DatabaseController databaseController){
        Module moduleToBeAddedToDB = new Module(
                0,
                userInput.get("name"),
                userInput.get("code"),
                new Name(userInput.get("teacher"),userInput.get("teacher")),
                Integer.valueOf(userInput.get("average")));
        moduleList.add(moduleToBeAddedToDB);
        databaseController.addModule(moduleToBeAddedToDB);
    }

    /**
     * @return Retrieve User input in a <String,String>Map
     */
    private Map<String, String> getUserInput(){

        Map<String, String> userInput = new HashMap<String, String>() {{
            put("name",moduleName.getText());
            put("code",moduleCode.getText());
            put("teacher",teacherName.getText());
            put("average",averageGrade.getText());
        }};

        return userInput;
    }

    private void setUpTables(TableView table){

        TableColumn moduleName = new TableColumn("Name");
        TableColumn moduleCode = new TableColumn("Code");
        TableColumn moduleTeacher = new TableColumn("Teacher");
        TableColumn moduleAverage = new TableColumn("Average Grade");
        ObservableList<TableColumn> tableColumns = FXCollections.observableArrayList(
                moduleName,
                moduleCode,
                moduleTeacher,
                moduleAverage
        );

        table.setEditable(true);
        table.getColumns().addAll(tableColumns);
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        moduleName.setCellValueFactory(new PropertyValueFactory<Student, String>("name"));
        moduleCode.setCellValueFactory(new PropertyValueFactory<Student, String>("code"));
        moduleTeacher.setCellValueFactory(new PropertyValueFactory<Student, String>("teacher"));
        moduleAverage.setCellValueFactory(new PropertyValueFactory<Student, String>("averageGrade"));

    }

    private void setUpPanel(VBox vb,TableView table){

        vb.setSpacing(5);
        vb.setPadding(new Insets(10, 0, 0, 10));
        HBox hb  = new HBox();
        addButton = new Button("Add\n");
        deleteButton = new Button("Delete\n");
        editButton = new Button("Edit\n");

        moduleName =      new TextField();
        moduleCode =      new TextField();
        teacherName =     new TextField();
        averageGrade =    new TextField();

        Label nameLabel = new Label("Module Name");
        Label codeLabel = new Label("Module Code");
        Label teacherLabel = new Label("Teacher");
        Label averageLabel = new Label("Average Grade");

        GridPane gp = new GridPane();
        gp.add(nameLabel,0,0);
        gp.add(codeLabel,1,0);
        gp.add(teacherLabel,2,0);
        gp.add(averageLabel,3,0);
        gp.add(deleteButton,4,0);
        gp.add(editButton,5,0);

        gp.add(moduleName,0,1);
        gp.add(moduleCode,1,1);
        gp.add(teacherName,2,1);
        gp.add(averageGrade,3,1);
        gp.add(addButton,4,1);

        hb.getChildren().add(gp);
        hb.setSpacing(3);
        vb.getChildren().addAll(table,hb);
    }



}

