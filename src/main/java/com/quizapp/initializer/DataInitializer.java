package com.quizapp.initializer;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.quizapp.model.Question;
import com.quizapp.repository.QuestionRepository;

@Component
public class DataInitializer implements CommandLineRunner {
    @Autowired
    private QuestionRepository questionRepository;

    @Override
    public void run(String... args) throws Exception {
        Question q1 = new Question();
        q1.setText("Who invented Java Programming?");
        q1.setOptions(Arrays.asList("Guido van Rossum", "James Gosling", "Dennis Ritchie", "Bjarne Stroustrup"));
        q1.setCorrectAnswerIndex(1);

        Question q2 = new Question();
        q2.setText("Which component is used to compile, debug and execute the java programs?");
        q2.setOptions(Arrays.asList("JRE", "JIT", "JDK", "JVK"));
        q2.setCorrectAnswerIndex(2);

        
        Question q3 = new Question();
        q3.setText("Which one of the following is not a Java feature?");
        q3.setOptions(Arrays.asList("Object-oriented", "Use of pointers", "Portable", "Dynamic and Extensible"));
        q3.setCorrectAnswerIndex(1);

        
        Question q4 = new Question();
        q4.setText("Which of these cannot be used for a variable name in Java?");
        q4.setOptions(Arrays.asList("identifier & keyword", "identifier", "keyword", "none of the mentioned"));
        q4.setCorrectAnswerIndex(2);
        
        Question q5 = new Question();
        q5.setText("What is the extension of java code files?");
        q5.setOptions(Arrays.asList(".js", ".txt", ".class", ".java"));
        q5.setCorrectAnswerIndex(3);
        
        Question q6 = new Question();
        q6.setText("Which environment variable is used to set the java path?");
        q6.setOptions(Arrays.asList("MAVEN_Path", "JavaPATH", "JAVA", "JAVA_HOME"));
        q6.setCorrectAnswerIndex(3);
        
        Question q7 = new Question();
        q7.setText("Which of the following is not an OOPS concept in Java?");
        q7.setOptions(Arrays.asList("Polymorphism", "Inheritance", "Compilation", "Encapsulation"));
        q7.setCorrectAnswerIndex(2);
        
        Question q8 = new Question();
        q8.setText("Which exception is thrown when java is out of memory?");
        q8.setOptions(Arrays.asList("MemoryError", "OutOfMemoryError", "MemoryOutOfBoundsException", "MemoryFullException"));
        q8.setCorrectAnswerIndex(1);
        
        Question q9 = new Question();
        q9.setText("Which of these are selection statements in Java?");
        q9.setOptions(Arrays.asList("break", "continue", "for()", "if()"));
        q9.setCorrectAnswerIndex(3);
        
        Question q10 = new Question();
        q10.setText("Which of these keywords is used to define interfaces in Java?");
        q10.setOptions(Arrays.asList("intf", "Intf", "interface", "Interface"));
        q10.setCorrectAnswerIndex(2);
        
        
        questionRepository.saveAll(Arrays.asList(q1, q2, q3, q4, q5, q6, q7, q8, q9, q10));
    }
}
