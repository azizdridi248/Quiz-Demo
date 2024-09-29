package quiz;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXMLLoader;

import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class te implements Initializable {
    
    static int counter = 0;
    static int correct = 0;
    static int wrong = 0;
    
    @FXML
    private Label question;
    
    @FXML
    private Button opt1;
    
    @FXML
    private Button opt2;
    
    @FXML
    private Button opt3;
    
    @FXML
    private Button opt4;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loadQuestions(counter);  // Load the first question
    }

 public void loadQuestions(int counter) {
    switch (counter) {
        case 0:
            question.setText("1. How many consonants are there in the English alphabet?");
            opt1.setText("19");
            opt2.setText("20");
            opt3.setText("21");
            opt4.setText("22");
            break;
        case 1:
            question.setText("2. Who invented the Light bulb?");
            opt1.setText("Thomas Alva Edison");
            opt2.setText("Alexander Fleming");
            opt3.setText("Charles Babbage");
            opt4.setText("Albert Einstein");
            break;
        case 2:
            question.setText("3. In the Solar System, farthest planet from the Sun is");
            opt1.setText("Jupiter");
            opt2.setText("Saturn");
            opt3.setText("Uranus");
            opt4.setText("Neptune");
            break;
        case 3:
            question.setText("4. Largest moon in the Solar System?");
            opt1.setText("Titan");
            opt2.setText("Ganymede");
            opt3.setText("Moon");
            opt4.setText("Europa");
            break;
        // Add more cases as per your questions
        default:
            // End of questions, load result scene
            try {
                Parent root = FXMLLoader.load(getClass().getResource("/quiz/Result.fxml"));
                // Get current stage from any component on the scene
                Stage stage = (Stage) question.getScene().getWindow();  // Assuming 'question' is a Node in the current scene
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();  // Handle the IOException
            }
            break;
    }
}


    boolean checkAnswer(String answer) {
        // Logic to check the answer based on the counter
        return switch (counter) {
            case 0 -> answer.equals("21");
            case 1 -> answer.equals("Thomas Alva Edison");
            case 2 -> answer.equals("Neptune");
            case 3 -> answer.equals("Ganymede");
            default -> false;
        };
    }

    @FXML
    public void handle1() {
        if (checkAnswer(opt1.getText())){ correct++;}
        else wrong++;
         nextQuestion();
    }

    @FXML
    public void handle2() {
        if (checkAnswer(opt2.getText())){ correct++ ;}
        else wrong++;
         nextQuestion();
    }

    @FXML
    public void handle3() {
        if (checkAnswer(opt3.getText())){ correct++;}
        else wrong++;
         nextQuestion();
    }

    @FXML
    public void handle4(ActionEvent event) {
        if (checkAnswer(opt4.getText())){ correct++ ;}
        else wrong++;
         nextQuestion();
    }
        // Move to the next question
    private void nextQuestion() {
        counter++;  // Increment the counter
        loadQuestions(counter);  // Load the next question
    }
}
