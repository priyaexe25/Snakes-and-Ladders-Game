package sample;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;
import javafx.util.Duration;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.util.Random;

import javafx.animation.TranslateTransition;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class translation {
    public void translateplayer(player p,Circle c) {
        TranslateTransition anm = new TranslateTransition(Duration.millis(500), c);
        anm.setFromX(p.previousX);
        anm.setFromY(p.previousY);
        anm.setToX(p.x);
        anm.setToY(p.y);
        anm.setAutoReverse(false);
        anm.play();

    }



}