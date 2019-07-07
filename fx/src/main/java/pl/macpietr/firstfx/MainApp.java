package pl.macpietr.firstfx;


import javafx.application.Application;
import javafx.stage.Stage;



public class MainApp extends Application {
    public void MainApp(){
        System.out.println("Constructor");
    }

    @Override
    public void start(Stage stage){
        System.out.println("Start");
        stage.setTitle("Hello FX!");
        stage.show();
    }

    public static void main(String[] args) {
        System.out.println("Main");
        launch(args);
    }

    public void init(){
        System.out.println("Init");
    }

    public void stop(){
        System.out.println("Stop");
    }
}
