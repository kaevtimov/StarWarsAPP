package source.kevtimov.starwarsapp.models.questions;


public class Question {

    private String question;
    private String answer1;
    private String answer2;
    private String answer3;

    public Question(){
        //default
    }

    public Question(String question, String answer1, String answer2,String answer3){
        this.question = question;
        this.answer1 = answer1;
        this.answer2 = answer2;
        this.answer3 = answer3;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer1() {
        return answer1;
    }

    public String getAnswer2() {
        return answer2;
    }

    public String getAnswer3() {
        return answer3;
    }
}
