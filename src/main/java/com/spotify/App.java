package com.spotify;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import com.spotify.controllers.userControllers.SelectAllUsersUseCase;
import com.spotify.models.UserModel;
import java.util.ArrayList;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("login"));
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }


    public static void main(String[] args) {
        ArrayList<UserModel> userModel = SelectAllUsersUseCase.handle();
        for(int i = 0; i < userModel.size(); i++){
            System.out.println(userModel.get(i).getName());
        }
        launch();
    }

    public static void changeScreen (String screen, Object userData, Object aditionalData) {
        try {
            setRoot(screen);
        } catch (IOException e) {
            e.printStackTrace();
        }
        notifyAllListeners(screen, userData, aditionalData);
    }

    public static void changeScreen (String screen, Object userData) {
        try {
            setRoot(screen);
        } catch (IOException e) {
            e.printStackTrace();
        }
        notifyAllListeners(screen, userData, null);
    }


    public static void changeScreen (String screen) {
        try {
            setRoot(screen);
        } catch (IOException e) {
            e.printStackTrace();
        }
        notifyAllListeners(screen, null, null);
    }

    //--

    private static ArrayList<OnChangeScreen> listeners = new ArrayList<>();

    public static interface OnChangeScreen {
        public void onScreenChanged(String newScreen, Object userData, Object aditionalData);
    }

    public static  void addOnChangeScreenListener(OnChangeScreen newListener) {
        listeners.add(newListener);
    }

    private static void notifyAllListeners(String newScreen, Object userData, Object aditionalData) {
        for(OnChangeScreen l : listeners) {
            l.onScreenChanged(newScreen, userData, aditionalData);
        }
    }

}