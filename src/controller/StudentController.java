package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.util.Callback;
import user.Name;
import user.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Create a tab containing a TableView of all car
 */
public class StudentController extends javafx.scene.control.Tab {

    TableView table;

    HBox hb;
    VBox vb;
    Button addButton;
    Button deleteButton;

    TextField store;
    TextField model;
    TextField registration;
    TextField millage;
    TextField yearOfManufacture;

    Label storeLabel;
    Label modelLabel;
    Label registrationLabel;
    Label millageLabel;
    Label yearOfManufactureLabel;

    TableColumn nameTable;
    TableColumn emailTable;
    TableColumn phoneTable;
    TableColumn dobTable;



    GridPane gp;

    // TODO CREATE A DATABASE WITH ALL THE CLASSES
    private static ObservableList<Student> studentList = FXCollections.observableArrayList(
            new Student(new Name("Jean","Patrick"),"jeanPatrick@gmail.com","+353 8521 1258 21","21/03/1997"),
            new Student(new Name("Jean","Patrick"),"jeanPatrick@gmail.com","+353 8521 1258 21","21/03/1997"),
            new Student(new Name("Jean","Patrick"),"jeanPatrick@gmail.com","+353 8521 1258 21","21/03/1997"),
            new Student(new Name("Jean","Patrick"),"jeanPatrick@gmail.com","+353 8521 1258 21","21/03/1997"),
            new Student(new Name("Jean","Patrick"),"jeanPatrick@gmail.com","+353 8521 1258 21","21/03/1997")
    );

    private ObservableList<TableColumn> listTables = FXCollections.observableArrayList(
            nameTable = new TableColumn("Name"),
            emailTable = new TableColumn("email"),
            phoneTable = new TableColumn("phone"),
            dobTable = new TableColumn("Date of Birth")
    );

    public StudentController() {
        this.setText("Car Panel");
        table = new TableView();
        vb = new VBox();
        table.setEditable(true);
        table.getColumns().addAll(listTables);
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);


        vb.setSpacing(5);
        vb.setPadding(new Insets(10, 0, 0, 10));


        hb  = new HBox();
        addButton = new Button("Add\n");
        deleteButton = new Button("Delete\n");

        store = new TextField();
        model = new TextField();
        registration = new TextField();
        millage = new TextField();
        yearOfManufacture = new TextField();

        storeLabel = new Label("Store");
        modelLabel = new Label("Model");
        registrationLabel = new Label("Registration");
        millageLabel = new Label("Milleage");
        yearOfManufactureLabel = new Label("Year");

        gp = new GridPane();
        gp.add(storeLabel,0,0);
        gp.add(modelLabel,1,0);
        gp.add(registrationLabel,2,0);
        gp.add(millageLabel,3,0);
        gp.add(yearOfManufactureLabel,4,0);
        gp.add(deleteButton,5,0);

        gp.add(store,0,1);
        gp.add(model,1,1);
        gp.add(registration,2,1);
        gp.add(millage,3,1);
        gp.add(yearOfManufacture,4,1);
        gp.add(addButton,5,1);

        hb.getChildren().add(gp);
        hb.setSpacing(3);

        ArrayList<PropertyValueFactory> propertyValueFactoryArrayList = new ArrayList<>(
                Arrays.asList(
                new PropertyValueFactory<Student, String>("name"),
                new PropertyValueFactory<Student, String>("email"),
                new PropertyValueFactory<Student, String>("phone"),
                new PropertyValueFactory<Student, String>("dob"))
        );


        nameTable.setCellValueFactory(new PropertyValueFactory<Student, String>("name"));
        emailTable.setCellValueFactory(new PropertyValueFactory<Student, String>("email"));
        phoneTable.setCellValueFactory(new PropertyValueFactory<Student, String>("phone"));
        dobTable.setCellValueFactory(new PropertyValueFactory<Student, String>("dob"));

        table.setItems(studentList);

        addButton.setOnAction(event -> addCar(studentList,getUserInput()));
        deleteButton.setOnAction(event -> deleteCar(studentList,table.getSelectionModel().getSelectedIndex()));

        vb.getChildren().addAll(table,hb);
        this.setContent(vb);

    }

    private void setUpValueInTables(ArrayList<PropertyValueFactory> propertyValueFactoryArrayList) {
        for(int i=0;i<propertyValueFactoryArrayList.size();i++){
            listTables.get(i).setCellFactory(propertyValueFactoryArrayList.get(i));
        }
        table.setItems(studentList);
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
     * @param studentList The car list
     * @param carIndex The car index
     * delete the car at the list index
     */
    private void deleteCar(ObservableList<Student> studentList,int carIndex) {
        studentList.remove(carIndex);
    }

    private void addCar(ObservableList<Student> studentList, Map<String, String> userInput){
        studentList.add( new Student(new Name("Jean","Patrick"),"jeanPatrick@gmail.com","+353 8521 1258 21","21/03/1997"));
    }

    /**
     * @return Retrieve User input in a <String,String>Map
     */
    private Map<String, String> getUserInput(){

        Map<String, String> userInput = new HashMap<String, String>() {{
            put("store",store.getText());
            put("model",model.getText());
            put("registration",registration.getText());
            put("millage",millage.getText());
            put("yearOfManufacture",yearOfManufacture.getText());
        }};

        return userInput;
    }



}

