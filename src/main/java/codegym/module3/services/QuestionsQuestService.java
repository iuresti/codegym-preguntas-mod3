package codegym.module3.services;

import codegym.module3.models.Question;
import codegym.module3.repository.QuestionsQuestRepository;

public class QuestionsQuestService {

    private QuestionsQuestRepository questionsQuestRepository;

    public QuestionsQuestService() {
        questionsQuestRepository = new QuestionsQuestRepository();
    }

    public String processPlayerResponse(String questionId, String response) {
        Question question = questionsQuestRepository.getQuestion(questionId);

        return question.getAnswers().get(response);
    }

    public Question getQuestionById(String id){
        return questionsQuestRepository.getQuestion(id);
    }

}
