package com.spotify;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

import com.spotify.controllers.userControllers.CreateUserUseCase;
import com.spotify.models.UserModel;



public class RegisterController implements Initializable {
    ArrayList<String> genres = new ArrayList<String>();

    private ObservableList<String> obsGenres;

    @FXML
    private DatePicker birth_date;

    @FXML
    private TextField email;

    @FXML
    private ChoiceBox<String> favorit_genre;

    @FXML
    private Button loginButton;

    @FXML
    private TextField name;

    @FXML
    private PasswordField password;

    @FXML
    private Button registerButton;
    

    @FXML
    void loginButton(ActionEvent event) {
        try{
            App.setRoot("login");
        }   catch(Exception e){
            System.out.println("Error changing page");
        }
    }

    @FXML
    void register(ActionEvent event) {
        UserModel user = new UserModel();
        user.setEmail(email.getText());
        user.setPassword(password.getText());
        user.setBirth_date(birth_date.getValue().toString());
        user.setName(name.getText());
        user.setFavorite_genres(new String[]{favorit_genre.getValue()});
        var result = CreateUserUseCase.handle(user);
        

        if(result != null){
            System.out.println("User created");
            try{
                App.setRoot("login");
            }   catch(Exception e){
                System.out.println("Error changing page");
            }
        }else{
            System.out.println("Error creating user");
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        addGenresToCombobox();
    }

    public void addGenresToCombobox() {
        genres.add("Rock");
        genres.add("Pop");
        genres.add("Jazz");
        genres.add("Rap");
        genres.add("Classica");
        genres.add("Funk");
        genres.add("Sertanejo");
        genres.add("Samba");
        genres.add("Pagode");
        genres.add("Eletronica");
        genres.add("Forro");
        genres.add("Reggae");
        genres.add("MPB");
        genres.add("Axé");
        genres.add("Gospel");
        genres.add("Blues");
        genres.add("Indie");
        genres.add("Folk");
        genres.add("Metal");

        obsGenres = FXCollections.observableArrayList(genres);
        System.out.println(obsGenres);

        favorit_genre.setItems(obsGenres);
    }

}