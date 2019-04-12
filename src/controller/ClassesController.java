package controller;

import database.DatabaseController;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import school.Classes;
import user.Name;
import user.Student;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Create a tab containing a TableView of all car
 */
public class ClassesController extends Tab {

    private Button addButton;
    private Button deleteButton;
    private Button editButton;

    private TextField id;
    private TextField name;

    public ClassesController(Connection connection) {
        this.setText("Classes Panel");
        TableView table = new TableView();
        setUpTables(table);
        VBox vb = new VBox();
        setUpPanel(vb,table);

        DatabaseController databaseController = new DatabaseController(connection);
        ArrayList<Classes> classesArrayList = databaseController.getClassesInDatabase();
        ObservableList<Classes> observableClassesList = FXCollections.observableArrayList(classesArrayList);
        table.setItems(observableClassesList);

        table.setOnMousePressed(event -> editClasses(observableClassesList,table.getSelectionModel().getSelectedIndex()));
        addButton.setOnAction(event -> addClasses(observableClassesList,getUserInput(),databaseController));
        deleteButton.setOnAction(event -> deleteClasses(observableClassesList,table.getSelectionModel().getSelectedIndex(),databaseController));
        editButton.setOnAction(event -> updateClasses(observableClassesList,table.getSelectionModel().getSelectedIndex(),getUserInput(),databaseController));

        this.setContent(vb);
    }

    private void editClasses(ObservableList<Classes> classesList, int classesIndex){
        Classes classesToBeEdited = classesList.get(classesIndex);
        id.setText(String.valueOf(classesToBeEdited.getId()));
        name.setText(classesToBeEdited.getName());
    }
    private void updateClasses(ObservableList<Classes> classesList, int classesIndex, Map<String, String> userInput, DatabaseController databaseController){
        if (classesIndex!=-1){
            Classes classesUpdated = new Classes(Integer.valueOf(userInput.get("id")), userInput.get("name"), new ArrayList<Student>());
            classesList.set(classesIndex,classesUpdated);
            databaseController.updateClasses(Integer.valueOf(userInput.get("id")),classesUpdated);
        }

    }

    /**
     * @param classesList The student list
     * @param classesIndex The student index
     * delete the student at the list index
     */
    private void deleteClasses(ObservableList<Classes> classesList,int classesIndex,DatabaseController databaseController) {
        Classes classesToBeRemoved = classesList.get(classesIndex);
        classesList.remove(classesToBeRemoved);
        databaseController.deleteClasses(classesToBeRemoved.getId());
    }

    private void addClasses(ObservableList<Classes> classesList, Map<String, String> userInput,DatabaseController databaseController){
        Classes classesToBeAddedToDB = new Classes(
                Integer.valueOf(userInput.get("id")),
                userInput.get("name"),
                new ArrayList<Student>());
        classesList.add(classesToBeAddedToDB);
        //TODO No ClassesId doesn't work
        databaseController.addClasses(classesToBeAddedToDB);
    }

    /**
     * @return Retrieve User input in a <String,String>Map
     */
    private Map<String, String> getUserInput(){

        Map<String, String> userInput = new HashMap<String, String>() {{
            put("id",id.getText());
            put("name",name.getText());
        }};

        return userInput;
    }

    private void setUpTables(TableView table){

        TableColumn idTable = new TableColumn("id");
        TableColumn ClassNameTable = new TableColumn("Class Name");
        ObservableList<TableColumn> tableColumns = FXCollections.observableArrayList(
                idTable ,
                ClassNameTable
        );

        table.setEditable(true);
        table.getColumns().addAll(tableColumns);
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        idTable.setCellValueFactory(new PropertyValueFactory<Student, String>("id"));
        ClassNameTable.setCellValueFactory(new PropertyValueFactory<Student, String>("name"));

    }

    private void setUpPanel(VBox vb,TableView table){

        vb.setSpacing(5);
        vb.setPadding(new Insets(10, 0, 0, 10));
        HBox hb  = new HBox();
        addButton = new Button("Add\n");
        deleteButton = new Button("Delete\n");
        editButton = new Button("Edit\n");

        id =        new TextField();
        name =      new TextField();

        Label idLabel = new Label("Class Number");
        Label nameLabel = new Label("Class Name");

        GridPane gp = new GridPane();
        gp.add(idLabel,0,0);
        gp.add(nameLabel,1,0);
        gp.add(deleteButton,2,0);
        gp.add(editButton,3,0);

        gp.add(id,0,1);
        gp.add(name,1,1);
        gp.add(addButton,2,1);

        hb.getChildren().add(gp);
        hb.setSpacing(3);
        vb.getChildren().addAll(table,hb);
    }



}

