/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package quiz;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;

/**
 * FXML Controller class
 *
 * @author CLUB ACRICAIN
 */
public class ResultController implements Initializable {

    @FXML
    private Label remark;
    @FXML
    private Label marks;
    @FXML
    private ProgressIndicator correct_progress;
    @FXML
    private ProgressIndicator wrong_progress;
    @FXML
    private Label correcttext;
    @FXML
    private Label wrongtext;
    @FXML
    private Label markstext;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
       
    // Assuming 'te' is properly initialized somewhere before
    int correct = te.correct;
    int wrong = te.wrong;

    correcttext.setText("Correct Answers: " + correct);
    wrongtext.setText("Incorrect Answers: " + wrong);

    marks.setText(correct + "/4");

    float correctf = (float) correct / 4;
    correct_progress.setProgress(correctf);

    float wrongf = (float) wrong / 4;
    wrong_progress.setProgress(wrongf);

    markstext.setText(correct + " Marks Scored");

    // Set remark based on score
    if (correct < 2) {
        remark.setText("Oh no..! You have failed the quiz. Practice daily to improve!");
    } else if (correct >= 2 && correct < 4) {
        remark.setText("Oops..! You scored less marks. Keep improving your knowledge!");
    } else if (correct == 4) {
        remark.setText("Congrats! You aced the quiz!");
    }
}

   
    
}

