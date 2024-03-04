package codegym.module3.services;

import codegym.module3.models.Question;
import codegym.module3.repository.QuestionsQuestRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class QuestionsQuestServiceTest {

    @Test
    void processPlayerResponseSuccess() throws NoSuchFieldException, IllegalAccessException {
        // Inicialización
        QuestionsQuestRepository questionsQuestRepository = Mockito.mock(QuestionsQuestRepository.class);
        QuestionsQuestService questionsQuestService = new QuestionsQuestService();
        String questionId = "Prueba1";
        String response = "X";
        Question question = new Question();

        question.setLabel("Label de prueba");
        Map<String, String> answers = new HashMap<>();

        answers.put("X", "AAAA");
        answers.put("Y", "BBBB");

        question.setAnswers(answers);

        Field field = QuestionsQuestService.class.getDeclaredField("questionsQuestRepository");
        field.setAccessible(true);
        field.set(questionsQuestService, questionsQuestRepository);

        when(questionsQuestRepository.getQuestion(questionId)).thenReturn(question);

        // Ejecución
        Optional<String> nextQuestion = questionsQuestService.processPlayerResponse(questionId, response);

        // Pruebas
        Assertions.assertTrue(nextQuestion.isPresent());
        Assertions.assertEquals("AAAA", nextQuestion.get());
        verify(questionsQuestRepository).getQuestion(questionId);
        verifyNoMoreInteractions(questionsQuestRepository);
    }

    @Test
    void processPlayerInvalidResponse() throws NoSuchFieldException, IllegalAccessException {
        // Inicialización
        QuestionsQuestRepository questionsQuestRepository = Mockito.mock(QuestionsQuestRepository.class);
        QuestionsQuestService questionsQuestService = new QuestionsQuestService();
        String questionId = "Prueba1";
        String response = "T";
        Question question = new Question();

        question.setLabel("Label de prueba");
        Map<String, String> answers = new HashMap<>();

        answers.put("X", "AAAA");
        answers.put("Y", "BBBB");

        question.setAnswers(answers);

        Field field = QuestionsQuestService.class.getDeclaredField("questionsQuestRepository");
        field.setAccessible(true);
        field.set(questionsQuestService, questionsQuestRepository);

        when(questionsQuestRepository.getQuestion(questionId)).thenReturn(question);

        // Ejecución
        Optional<String> nextQuestion = questionsQuestService.processPlayerResponse(questionId, response);

        // Pruebas
        Assertions.assertTrue(nextQuestion.isEmpty());
    }

    @Test
    void getValidQuestionById() throws NoSuchFieldException, IllegalAccessException {
        // Inicialización
        QuestionsQuestRepository questionsQuestRepository = Mockito.mock(QuestionsQuestRepository.class);
        QuestionsQuestService questionsQuestService = new QuestionsQuestService();
        String questionId = "Prueba1";
        Question question = new Question();

        question.setLabel("Label de prueba");
        Map<String, String> answers = new HashMap<>();

        answers.put("X", "AAAA");
        answers.put("Y", "BBBB");

        question.setAnswers(answers);

        Field field = QuestionsQuestService.class.getDeclaredField("questionsQuestRepository");
        field.setAccessible(true);
        field.set(questionsQuestService, questionsQuestRepository);

        when(questionsQuestRepository.getQuestion(questionId)).thenReturn(question);

        // Ejecución
        Question actualQuestion = questionsQuestService.getQuestionById(questionId);

        // Pruebas
        Assertions.assertSame(question, actualQuestion);
    }
}
