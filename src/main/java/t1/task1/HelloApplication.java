package t1.task1;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.Locale;

public class HelloApplication extends Application {
    Stage mma ;
    ImageView tank1;
    ImageView tank2;
    Pane mp;
    Timeline tm ;
    boolean [] tanks1 = new boolean[] {false,false,false,false};
    boolean [] tanks2 = new boolean[] {false,false,false,false};
    int t1=15;
    int t2=15;

    int coolDown1=0;
    int coolDown2=0;

    String player1="Tank1";
    String player2="Tank2";

    @Override
    public void start(Stage stage) {
        mma = stage;
        VBox main = new VBox(15);
        HBox nameStartName=new HBox(50);
        nameStartName.setAlignment(Pos.CENTER);

        ImageView beg = new ImageView(new Image("C:/Users/Acer/Desktop/GameRelated/week7/task1/src/main/resources/t1/task1/Begin.jpg", 500 ,300 , false ,false ));
        StackPane begg = new StackPane(beg);
        begg.setStyle("-fx-padding : 50px");
        main.getChildren().add(begg);


        Button bt1 = new Button("Start");
        bt1.setStyle("-fx-pref-width: 500px;-fx-pref-height: 60px ;-fx-border-width: 15px ;-fx-border-color: GRAY ;-fx-font:40;-fx-base: LightGray;");
        bt1.setOnAction(e->letItBegin());

        TextField name1 = new TextField("Enter Your Name Player 1");
        name1.setStyle("-fx-font-size : 30px");
        name1.setOnAction(e->{
            player1=name1.getText().toUpperCase(Locale.ROOT);
        });

        TextField name2 = new TextField("Enter Your Name Player 2");
        name2.setStyle("-fx-font-size : 30px");
        name2.setOnAction(e->{
            player2=name2.getText().toUpperCase();
        });

        nameStartName.getChildren().addAll(name1,bt1,name2);

        Button bt2 = new Button("Exit");
        bt2.setStyle("-fx-pref-width: 500px;-fx-pref-height: 60px ;-fx-border-width: 15px ;-fx-border-color: GRAY ;-fx-base: LightGray;");
        bt2.setOnAction(e->Platform.exit());

        main.getChildren().addAll( nameStartName ,new StackPane (bt2) );


        main.setStyle("-fx-background-color: Black ;");
        mma.setFullScreen(true);
        mma.setTitle("NoOneCaresDeadInsideLMAO");
        mma.setScene(new Scene(main, 800 , 500));
        mma.show();
    }
    public void letItBegin(){
        mp = new Pane();
        Line border1 = new Line(10,10,10,850);
        border1.setStrokeWidth(10);
        Line border2 = new Line(10,10,1520,10);
        border2.setStrokeWidth(10);
        Line border3 = new Line(10,850,1520,850);
        border3.setStrokeWidth(10);
        Line border4 = new Line(1520,10,1520,850);
        border4.setStrokeWidth(10);
        mp.getChildren().addAll(border1,border2,border3,border4);
        tank1=tankMaker("C:\\Users\\Acer\\Desktop\\GameRelated\\week7\\task1\\src\\main\\resources\\t1\\task1\\tata1.jpg");
        tank1.setRotate(180);
        tank2=tankMaker("C:\\Users\\Acer\\Desktop\\GameRelated\\week7\\task1\\src\\main\\resources\\t1\\task1\\tata2.jpg");
        tm = new Timeline();
        tm.setCycleCount(Animation.INDEFINITE);
        tm.getKeyFrames().add(new KeyFrame(Duration.millis(50),e->{
            if(coolDown1!=0) {
                coolDown1--;
            }
            if(coolDown2!=0) {
                coolDown2--;
            }
            if(tanks1[0]) {
                int codinateX = (int) (tank1.getX() - 4 * Math.cos(Math.toRadians(tank1.getRotate())));
                int codinateY = (int)(tank1.getY() - 4 * Math.sin(Math.toRadians(tank1.getRotate())));
                if(codinateX>10&&codinateY>10){
                    tank1.setX(Math.min(codinateX, 1485));
                    tank1.setY(Math.min(codinateY, 830));
                }else if(codinateX>10){
                    tank1.setX(Math.min(codinateX, 1485));
                    tank1.setY(10);
                }else if(codinateY>10){
                    tank1.setX(10);
                    tank1.setY(Math.min(codinateY, 850));
                }else{
                    tank1.setX(10);
                    tank1.setY(10);
                }
            }
            if(tanks1[1]){
                int codinateX = (int) (tank1.getX() + 4 * Math.cos(Math.toRadians(tank1.getRotate())));
                int codinateY = (int)(tank1.getY() + 4 * Math.sin(Math.toRadians(tank1.getRotate())));
                if(codinateX>10&&codinateY>10){
                    tank1.setX(Math.min(codinateX, 1485));
                    tank1.setY(Math.min(codinateY, 815));
                }else if(codinateX>10){
                    tank1.setX(Math.min(codinateX, 1485));
                    tank1.setY(10);
                }else if(codinateY>10){
                    tank1.setX(10);
                    tank1.setY(Math.min(codinateY, 815));
                }else{
                    tank1.setX(10);
                    tank1.setY(10);
                }
            }
            if(tanks1[2]){
                tank1.setRotate(tank1.getRotate()+10);
            }
            if(tanks1[3]){
                tank1.setRotate(tank1.getRotate()-10);
            }
            if(tanks2[0]) {
                int codinateX = (int) (tank2.getX() - 4 * Math.cos(Math.toRadians(tank2.getRotate())));
                int codinateY = (int)(tank2.getY() - 4 * Math.sin(Math.toRadians(tank2.getRotate())));
                if(codinateX>10&&codinateY>10){
                    tank2.setX(Math.min(codinateX, 1485));
                    tank2.setY(Math.min(codinateY, 815));
                }else if(codinateX>10){
                    tank2.setX(Math.min(codinateX, 1485));
                    tank2.setY(10);
                }else if(codinateY>10){
                    tank2.setX(10);
                    tank2.setY(Math.min(codinateY, 815));
                }else{
                    tank2.setX(10);
                    tank2.setY(10);
                }
            }
            if(tanks2[1]){
                int codinateX = (int) (tank2.getX() + 4 * Math.cos(Math.toRadians(tank2.getRotate())));
                int codinateY = (int)(tank2.getY() + 4 * Math.sin(Math.toRadians(tank2.getRotate())));
                if(codinateX>10&&codinateY>10){
                    tank2.setX(Math.min(codinateX, 1485));
                    tank2.setY(Math.min(codinateY, 815));
                }else if(codinateX>10){
                    tank2.setX(Math.min(codinateX, 1485));
                    tank2.setY(10);
                }else if(codinateY>10){
                    tank2.setX(10);
                    tank2.setY(Math.min(codinateY, 815));
                }else{
                    tank2.setX(10);
                    tank2.setY(10);
                }
            }
            if(tanks2[2]){
                tank2.setRotate(tank2.getRotate()+10);
            }
            if(tanks2[3]){
                tank2.setRotate(tank2.getRotate()-10);
            }
        }));
        tm.play();

        mp.setOnKeyPressed(e->{
            if(e.getCode()==KeyCode.UP){ tanks1[0]=true;}
            if(e.getCode()==KeyCode.DOWN){tanks1[1]=true;}
            if(e.getCode()==KeyCode.RIGHT){tanks1[2]=true;}
            if(e.getCode()==KeyCode.LEFT){tanks1[3]=true;}
            if(e.getCode()==KeyCode.W){tanks2[0]=true;}
            if(e.getCode()==KeyCode.S){tanks2[1]=true;}
            if(e.getCode()==KeyCode.D){tanks2[2]=true;}
            if(e.getCode()==KeyCode.A){tanks2[3]=true;}
            if(coolDown1==0&&e.getCode()==KeyCode.ENTER){
                coolDown1=25;
                bullet(e.getCode());
            }
            if(coolDown2==0&&e.getCode()==KeyCode.SPACE){
                coolDown2=25;
                bullet(e.getCode());
            }
        });
        mp.setOnKeyReleased(e->{
            if(e.getCode()==KeyCode.UP){ tanks1[0]=false;}
            if(e.getCode()==KeyCode.DOWN){tanks1[1]=false;}
            if(e.getCode()==KeyCode.RIGHT){tanks1[2]=false;}
            if(e.getCode()==KeyCode.LEFT){tanks1[3]=false;}

            if(e.getCode()==KeyCode.W){tanks2[0]=false;}
            if(e.getCode()==KeyCode.S){tanks2[1]=false;}
            if(e.getCode()==KeyCode.D){tanks2[2]=false;}
            if(e.getCode()==KeyCode.A){tanks2[3]=false;}
        });
        mp.getChildren().add(tank1);
        mp.getChildren().add(tank2);

        tank1.setX(50);
        tank1.setY(50);
        tank2.setX(mma.getWidth()-100);
        tank2.setY(mma.getHeight()-100);
        mma.setScene(new Scene(mp));
        mma.setFullScreen(true);
        mp.requestFocus();
    }
    public ImageView tankMaker(String a ){
        return new ImageView(new Image(a,40,40,false,false));
    }
    public void bullet(KeyCode e){
        int xAdder ;
        int yAdder ;
        Circle a;
        final boolean stp ;
        if(e==KeyCode.SPACE){
            a = new Circle( tank2.getX()+20,tank2.getY()+20,5);
            xAdder = (int)(-4*Math.cos(Math.toRadians(tank2.getRotate())) );
            yAdder = (int)(- 4 * Math.sin(Math.toRadians(tank2.getRotate())));
            stp=true;
        }else {
            a = new Circle(tank1.getX()+20,tank1.getY()+20,5);
            xAdder = (int)( -4 * Math.cos(Math.toRadians(tank1.getRotate())) );
            yAdder = (int)(- 4 * Math.sin(Math.toRadians(tank1.getRotate())));
            stp=false;
        }
        mp.getChildren().add(a);
        Timeline ch = new Timeline();
        ch.setCycleCount(600);
        ch.getKeyFrames().add(new KeyFrame(Duration.millis(50),g->{
            a.setCenterX(a.getCenterX()+xAdder*3);
            a.setCenterY(a.getCenterY()+yAdder*3);
            if(stp&&tank1.getX()<a.getCenterX()&&tank1.getX()+40>a.getCenterX()&&tank1.getY()<a.getCenterY()&&tank1.getY()+40>a.getCenterY()){
                ch.stop();
                t1--;
                Timeline boom = new Timeline();
                boom.setCycleCount(7);
                Node bulletCount=new Node(7);
                a.setFill(Color.RED);
                boom.getKeyFrames().add(new KeyFrame(Duration.millis(50),t->{
                    a.setRadius(a.getRadius()+15);
                    bulletCount.decrement();
                    if(bulletCount.a==0){
                        mp.getChildren().remove(a);
                    }
                }));
                boom.play();
                if(t1==0){
                    Label l= new Label("CONGRATULATIONSLOL !!!!!!!!!\n"+player2+" IS THE WINNER");
                    l.setStyle("-fx-background-color:black;-fx-text-fill:WHITE; -fx-font-size: 80;-fx-font-weight: bold;");
                    StackPane hah = new StackPane(l);
                    mma.setScene(new Scene(hah));
                    mma.getScene().setFill(Color.VIOLET);
                    mma.setFullScreen(true);
                }
            }
            if(!stp&&tank2.getX()<a.getCenterX()&&tank2.getX()+40>a.getCenterX()&&tank2.getY()<a.getCenterY()&&tank2.getY()+40>a.getCenterY()){
                t2--;
                ch.stop();
                Timeline boom = new Timeline();
                boom.setCycleCount(7);
                Node bulletCount=new Node(7);
                a.setFill(Color.RED);
                boom.getKeyFrames().add(new KeyFrame(Duration.millis(50),t->{
                    a.setRadius(a.getRadius()+15);
                    bulletCount.decrement();
                    if(bulletCount.a==0){
                        mp.getChildren().remove(a);
                    }
                }));
                boom.play();
                if(t2==0){
                    Label l= new Label("CONGRATULATIONSLOL !!!!!!!!!\n"+player1+" IS THE WINNER");
                    l.setStyle("-fx-background-color:black;-fx-text-fill:WHITE; -fx-font-size: 80;-fx-font-weight: bold;");
                    StackPane hah = new StackPane(l);
                    mma.setScene(new Scene(hah));
                    mma.getScene().setFill(Color.VIOLET);
                    mma.setFullScreen(true);
                }
            }
        }));
        ch.play();
    }
    public static void main(String[] args) {
        launch();
    }
}
class Node {
    int a ;
    public Node(int a){
        this.a=a;
    }
    public void decrement(){
        this.a=this.a-1;
    }
}