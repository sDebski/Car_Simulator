package sample;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.input.KeyCode;
import javafx.scene.Parent;
import javafx.scene.control.Button;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("simulator.fxml"));
        GridPane box = (GridPane)loader.load();
        Controller controller = (Controller)loader.getController();
        primaryStage.setTitle("Car Simulator");
        controller.Init();

        Scene scene = new Scene(box);

        primaryStage.addEventHandler(KeyEvent.KEY_PRESSED, ev -> {
            if (ev.getCode() == KeyCode.S) {
            controller.engineOnEventClicked();
            }
            else if(ev.getCode()== KeyCode.P){
                controller.engineOffEventClicked();
            }
            else if(ev.getCode()==KeyCode.U){
                controller.gearUpEventClicked();
            }
            else if(ev.getCode()==KeyCode.D){
                controller.gearDownEventClicked();
            }
            else if(ev.getCode()==KeyCode.UP){
                controller.accelarateEventClicked();
            }
            else if(ev.getCode()==KeyCode.DOWN){
                controller.brakeEventClicked();
            }

            });

                primaryStage.setScene(scene);
        primaryStage.show();



    }




    public static void main(String[] args) {
        launch(args);
    }
}
