package source.kevtimov.starwarsapp.models.questions;

import java.util.ArrayList;
import java.util.List;

public class QueastionDatabase {

    private List<Question> questions;

    public QueastionDatabase(List<Question> questions){
        this.questions = new ArrayList<>();
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void loadDatabase(){
        Question question1 = new Question("Q: Which of the following Star Wars films did George Lucas NOT direct?", new ArrayList<>());
        question1.getAnswers().add("A: Episode IV- New Hope");
        question1.getAnswers().add("B: Episode VI- Return of the Jedi");   //correct
        question1.getAnswers().add("C: Episode I- The Phantom Menace");

        questions.add(question1);

        Question question2 = new Question("Q: Who was Princess Leia's only hope?", new ArrayList<>());
        question2.getAnswers().add("A: Obi-Wan Kenobi");  //correct
        question2.getAnswers().add("B: Yoda");
        question2.getAnswers().add("C: Emperor Palpatine");

        questions.add(question2);

        Question question3 = new Question("Q: What other name did Queen Amidala go by?", new ArrayList<>());
        question3.getAnswers().add("A: Leia");
        question3.getAnswers().add("B: Padme");  //correct
        question3.getAnswers().add("C: Gloria");

        questions.add(question3);

        Question question4 = new Question("Q: R2-D2 is classified as what type of droid?", new ArrayList<>());
        question4.getAnswers().add("A: Protocol droid");
        question4.getAnswers().add("B: Battle droid");
        question4.getAnswers().add("C: Astromech droid");  //correct

        questions.add(question4);

        Question question5 = new Question("Q: For what reasons does Yoda not want to train Anakin?", new ArrayList<>());
        question5.getAnswers().add("A: Hes too tall and he whines too much");
        question5.getAnswers().add("B: Hes too old and too rebellious");
        question5.getAnswers().add("C: Hes too old and Yoda senses fear in him");  //correct

        questions.add(question5);

        Question question6 = new Question("Q: Who owned Anakin Skywalker as a slave until he was freed by Qui-Gon?", new ArrayList<>());
        question6.getAnswers().add("A: Sebulba");
        question6.getAnswers().add("B: Watto");   //correct
        question6.getAnswers().add("C: Jabba the hutt");

        questions.add(question6);

        Question question7 = new Question("Q: What was the exact order Chancellor Palpatine gave to the clone troopers before they turned on the Jedi?", new ArrayList<>());
        question7.getAnswers().add("A: Kill the jedi");
        question7.getAnswers().add("B: Order-66");   //correct
        question7.getAnswers().add("C: Death star order");

        questions.add(question7);

        Question question8 = new Question("Q: Who is Obi-Wan's master in The Phantom Menace?", new ArrayList<>());
        question8.getAnswers().add("A: QuiGon Jinn");  //correct
        question8.getAnswers().add("B: Yoda");
        question8.getAnswers().add("C: Darth Vader");

        questions.add(question8);

        Question question9 = new Question("Q: What is the traditional weapon of the Jedi Order?", new ArrayList<>());
        question9.getAnswers().add("A: Laser gun");
        question9.getAnswers().add("B: Yoda");
        question9.getAnswers().add("C: Lightsaber");  //correct

        questions.add(question9);

        Question question10 = new Question("Q: Who provided the DNA sample for the Republic's clones?", new ArrayList<>());
        question10.getAnswers().add("A: Jango Fett");   //correct
        question10.getAnswers().add("B: Senator Palpatine");
        question10.getAnswers().add("C: Organa");

        questions.add(question10);


    }
}
