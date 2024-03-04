package codegym.module3.services;

import codegym.module3.models.Question;
import codegym.module3.repository.QuestionsQuestRepository;

import java.util.Optional;

public class QuestionsQuestService {

    private QuestionsQuestRepository questionsQuestRepository;

    public QuestionsQuestService() {
        questionsQuestRepository = new QuestionsQuestRepository();

    }

    public Optional<String> processPlayerResponse(String questionId, String response) {
        Question question = questionsQuestRepository.getQuestion(questionId);

        return Optional.ofNullable(question.getAnswers().get(response));
    }

    public Question getQuestionById(String id){
        return questionsQuestRepository.getQuestion(id);
    }

}
