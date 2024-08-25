package sample;

import com.sun.media.jfxmedia.control.MediaPlayerOverlay;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.util.Duration;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javax.sound.midi.Soundbank;
import java.io.File;
import java.util.Random;


public class Controller {
    public int rand;
    public int turn=1;


    public boolean gamestart=false;
    translation t= new translation();


    @FXML
    private Button start;

    @FXML
    private Label dice_result;

    @FXML
    private Button player1;

    @FXML
    private Button player2;


    @FXML
    private Circle p2;


    @FXML
    private ImageView img;

    @FXML
    private ImageView img2;

    @FXML
    private Label locvar;

    @FXML
    private Circle p1;


    Random random = new Random();

    player p1obj = new player(1);

    player p2obj = new player(2);

    Snakesnladders s= new Snakesnladders();


    @FXML
    private ImageView diceImage;

    @FXML
    private Button rollButton;

    @FXML
    private ImageView player1Roll;

    @FXML
    private ImageView player2Roll;

    @FXML
    private Text startText;


    @FXML
    private Rectangle won;


    @FXML
    private Text player1won;

    @FXML
    private Text player2won;

    @FXML
    void dice( ){

//        dice_result.setText(String.valueOf(rand));

    }

    @FXML
    void gamebutton(MouseEvent event) {
//        start.setText("Restart");                          //start button becomes restart button
        startText.setText("RESTART");

        rollButton.setDisable(false);
        player1.setDisable(true);
        player2.setDisable(true);

        p1obj.x= 0;
        p1obj.y= 0;
        p1.setLayoutX(20);
        p1.setLayoutY(380);
        p1.setTranslateX(0);
        p1.setTranslateY(0);
        p1.setVisible(false);
        player1Roll.setVisible(false);

        p2obj.x= 0;
        p2obj.y= 0;
        p2.setLayoutX(20);
        p2.setLayoutY(380);
        p2.setTranslateX(0);
        p2.setTranslateY(0);
        p2.setVisible(false);
        player2Roll.setVisible(false);

        rand=0;
        dice_result.setText("Dice");
        gamestart=true;
        turn=1;
        p1obj.p1b=0;
        p2obj.p1b=0;

        player1won.setVisible(false);
        player2won.setVisible(false);
        won.setVisible(false);


    }

    @FXML
    void roll(ActionEvent event) {

        if( !gamestart) return;

        player1.setDisable(true);
        player2.setDisable(true);
        player1Roll.setVisible(false);
        player2Roll.setVisible(false);

        rollButton.setDisable(true);



        Thread thread = new Thread(){
            public void run(){
                System.out.println("Thread Running");
                try {
                    for (int i = 0; i < 15; i++) {
                        rand = random.nextInt(6)+1;

                        File file = new File("src/sample/dice/dice" + (rand)+".png");
                        diceImage.setImage(new Image(file.toURI().toString()));

                        Thread.sleep(35);


                    }
//
//                    if(turn==1) rand= 1;
//                    if(turn==2) rand= 1;
//                    if(turn==3) rand= 90;
//                    if(turn==4) rand= 90;


                    if(turn%2==1)
                    {
                        if(p1obj.p1b==0){
                            if(rand==1) {
                                p1obj.p1b +=1;
                                player1.setDisable(false);
                                player1Roll.setVisible(true);

                            }
                            else{
                                player1.setDisable(true);
                                rollButton.setDisable(false);
                                player1Roll.setVisible(false);
                            }

                        } else  {
                            player1.setDisable(false);
                            player1Roll.setVisible(true);
                            p1obj.p1b +=1;


                        }
                        if ( p1obj.x<=200 && p1obj.y==-360 && rand*40 > p1obj.x){
                            player1.setDisable(true);
                            player1Roll.setVisible(false);
                            rollButton.setDisable(false);
                        }
                    }



                    if (turn % 2 == 0)
                    {

                        if(p2obj.p1b ==0){
                            if(rand ==1) {
                                p2obj.p1b +=1;
                                player2.setDisable(false);
                                player2Roll.setVisible(true);
                            }
                            else{
                                player2.setDisable(true);
                                rollButton.setDisable(false);
                                player2Roll.setVisible(false);
                            }
                        }

                        else {
                            p2obj.p1b +=1;
                            player2.setDisable(false);
                            player2Roll.setVisible(true);

                        }
                        if ( p2obj.x <=200 && p2obj.y ==-360 && rand*40 > p2obj.x){
                            player2.setDisable(true);
                            rollButton.setDisable(false);
                            player2Roll.setVisible(false);
                        }
                    }

                    turn++;

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


            }
        };
        thread.start();
//        System.out.println("player1xpos" + player1Xpos);
//        System.out.println("player1ypos" + player1Ypos);



//        dice_result.setText(String.valueOf(rand));
    }

    @FXML
    void p1click(MouseEvent event) {                                   // clicking player1 button rolls dice and moves p1



        if(gamestart) {

            p1obj.previousX= p1obj.x;
            p1obj.previousY= p1obj.y;
            moveplayer(p1obj);

            t.translateplayer(p1obj, p1);

            int temp1 = p1obj.x;
            int temp2 = p1obj.y;


            //snakes(1, player1Xpos, player1Ypos, posCir1);
            s.ladders(p1obj);
            s.snakes(p1obj);

            if (temp1 == p1obj.x && temp2 == p1obj.y) {

            } else {
                p1obj.previousX = temp1;
                p1obj.previousY = temp2;
            }
            t.translateplayer(p1obj, p1);


            System.out.println("1 prevX  " + p1obj.previousX);
            System.out.println("1 prevY  " + p1obj.previousY);

        }

        player1.setDisable(true);
        player1Roll.setVisible(false);
        rollButton.setDisable(false);

    }



    @FXML
    void p2click(MouseEvent event) {                            // clicking player1 button rolls dice and moves p1

        if (gamestart) {

            p2obj.previousX = p2obj.x;
            p2obj.previousY = p2obj.y;

            System.out.println("2 prevX  " + p2obj.previousX);
            System.out.println("2 prevY  " + p2obj.previousY);

            moveplayer(p2obj);

            t.translateplayer(p2obj, p2);

            int temp1 = p2obj.x;
            int temp2 = p2obj.y;


            //snakes(1, player1Xpos, player1Ypos, posCir1);
            s.ladders(p2obj);
            s.snakes(p2obj);

            if (temp1 == p2obj.x && temp2 == p2obj.y) {

            }
            else {
                p2obj.previousX = temp1;
                p2obj.previousY = temp2;
            }

            t.translateplayer(p2obj, p2);


            System.out.println("1 prevX  " + p2obj.previousX);
            System.out.println("1 prevY  " + p2obj.previousY);

        }

        player2.setDisable(true);
        player2Roll.setVisible(false);
        rollButton.setDisable(false);


    }



    public void moveplayer(player p) {

        if (p.id==1 && p.p1b == 1) {
            p1.setVisible(true);
//            player1Roll.setVisible(false);
            return;
        }
        if (p.id==2 && p.p1b == 1) {
            p2.setVisible(true);
            return;
        }

        if (p.y == -360) {
            if (p.x <= 200) {


                if (rand * 40 == p.x) {
                    p.x = 0;
                    p.y = -360;
                    if (p.id == 1) {
                        p1.setTranslateX(0);
                        p1.setTranslateY(-360);
                        dice_result.setText("Player 1 won!");
                        p1.setVisible(false);                             //p1 disappers once it wins
                        startText.setText("Play Again?");
                        gamestart = false;
                        player1won.setVisible(true);
                        won.setVisible(true);

                    }
                        if (p.id  == 2) {
                            p2.setTranslateX(0);
                            p2.setTranslateY(-360);
                            dice_result.setText("Player 2 won!");
                            p2.setVisible(false);                             //p1 disappers once it wins
                            startText.setText("Play Again?");
                            gamestart = false;
                            player2won.setVisible(true);
                            won.setVisible(true);
                        }

                    return;

                }

            }

        }

        for (int i = 0; i < rand; i++) {
            //posCircle initially =1

            if (p.position % 2 == 1) {                               //here posCircle odd so player moves right
                p.x += 40;
                //p1.setLayoutX(+80);
            }
            if (p.position % 2 == 0) {                              //if posCircle even then player moves left
                p.x -= 40;
            }
            if (p.x > 360) {                            //reaching right corner of board
                p.y -= 40;
                p.x -= 40;
                p.position++;
            }
            if (p.x < 0) {                               //reaching left corner of board
                p.y -= 40;
                p.x += 40;
                p.position++;
            }




        }
    }




    @FXML
    void findloc(MouseEvent event) {
        locvar.setText(String.valueOf(event.getSceneX())+" "+String.valueOf(event.getSceneY()));
    }



}

