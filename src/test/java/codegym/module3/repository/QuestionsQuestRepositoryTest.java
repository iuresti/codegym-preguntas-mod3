package codegym.module3.repository;

import codegym.module3.models.Question;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class QuestionsQuestRepositoryTest {

    @Test
    public void getValidQuestion(){
        // Inicialización
        QuestionsQuestRepository questionsQuestRepository = new QuestionsQuestRepository();

        // Ejecución
        Question question = questionsQuestRepository.getQuestion("AcceptChallengeTest");

        // Validación
        Assertions.assertEquals("Has perdido la memoria", question.getLabel());
        Assertions.assertEquals("¿Aceptas continuar el juego?", question.getQuestion());
        Assertions.assertEquals(2, question.getAnswers().size());
        Assertions.assertEquals("ChallengeAccepted", question.getAnswers().get("Si"));
        Assertions.assertEquals("RejectNegociations", question.getAnswers().get("No"));
    }

}
