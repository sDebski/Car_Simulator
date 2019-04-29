package sample;

import javafx.animation.RotateTransition;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.event.ActionEvent;
import javafx.util.Duration;

public class Controller {
    @FXML
    private Text gearValue;
    //@FXML
    //private Text engineSpeedValue;
    @FXML
    private Line line;
    @FXML
    private Text engineStatus;
    @FXML
    private Text speedValue;
    @FXML
    private Text messageToUser;


    @FXML
    private Button engineOn;
    @FXML
    private Button engineOff;
    @FXML
    private Button accekerate;
    @FXML
    private Button brake;
    @FXML
    private Button gearUp;
    @FXML
    private Button gearOff;


    Car car;

    public void Init() {
        car = new Car();
    }




    @FXML
    public void accelarateEventClicked(){
    if(car.isLaunchedEngine()){
        car.accelarate();
        this.refreshTextBoxs();
    }
    else{
        this.messageToUser.setText("Launch car");
    }
    }
    @FXML
    public void brakeEventClicked(){
        if(car.isLaunchedEngine()){
            car.brake();
            this.refreshTextBoxs();
            this.refreshTextBoxs();
        }
        else{
            this.messageToUser.setText("Launch car");
        }
    }
    @FXML
    public void gearUpEventClicked(){
        if(car.isLaunchedEngine()){

            if(car.getGear()==6) {
                this.messageToUser.setText("Gear is 6, higher hear is not available");
            }
            else {
                car.gearUp();
                this.refreshTextBoxs();
            }
        }
        else{
            this.messageToUser.setText("Launch car");
        }
    }
    @FXML
    public void gearDownEventClicked(){
        if(car.isLaunchedEngine()){
            if(car.getGear()==0) {
                this.messageToUser.setText("Gear is 0, lower gear is not available");
            }
            else{
            car.gearDown();
            this.refreshTextBoxs();
            }
        }
        else{
            this.messageToUser.setText("Launch car");
        }
    }
    @FXML
    public void engineOnEventClicked(){
        if(car.isLaunchedEngine()){
            this.messageToUser.setText("this car is on");
        }
        else{
        car.launchCar();
        this.engineStatus.setText("ON");
        this.refreshTextBoxs();
        }
    }
    @FXML
    public void engineOffEventClicked(){
        if(car.isLaunchedEngine()){
        car.turnOff();
        this.engineStatus.setText("Off");
        this.refreshTextBoxs();
        }
        else{
            this.messageToUser.setText("Launch car");
        }
    }
    private void refreshTextBoxs(){
        this.gearValue.setText(Integer.toString(car.getGear()));
        this.speedValue.setText(Integer.toString(car.getSpeed()));
        setEngineSpeedValue(car.getEngineSpeed());

    }
    private void setEngineSpeedValue(float engineSpeed){
        if(engineSpeed>=0&&engineSpeed<1){
            this.line.setRotate(0);
        }
        else if(engineSpeed>=1&&engineSpeed<2){
            this.line.setRotate(10);
        }
        else if(engineSpeed>=2&&engineSpeed<3){
            this.line.setRotate(25);
        }
        else if(engineSpeed>=3&&engineSpeed<4){
            this.line.setRotate(50);
        }
        else if(engineSpeed>=4&&engineSpeed<5){
            this.line.setRotate(75);
        }
        else if(engineSpeed>=5&&engineSpeed<6){
            this.line.setRotate(90);
        }
        else if(engineSpeed>=6&&engineSpeed<7){
            this.line.setRotate(105);
        }
        else if(engineSpeed>=7&&engineSpeed<8) {
            this.line.setRotate(120);
        }
        else{
            this.line.setRotate(130);
        }
    }
}
