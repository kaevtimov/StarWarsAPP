package source.kevtimov.starwarsapp.models.questions;

import java.util.ArrayList;
import java.util.List;

public class Question {

    private String question;
    private List<String> answers;

    public Question(String question, List<String> answers){
        this.question = question;
        this.answers = new ArrayList<>();
    }

    public String getQuestion() {
        return question;
    }

    public List<String> getAnswers() {
        return answers;
    }
}
