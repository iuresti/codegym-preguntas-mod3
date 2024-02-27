package codegym.module3.repository;

import codegym.module3.models.Question;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class QuestionsQuestRepository {

    private Map<String, Question> questionMap;

    public QuestionsQuestRepository() {
        this.questionMap = new HashMap<>();

        Map<String, String> responses = new LinkedHashMap<>();

        responses.put("Si", "InTheBridge");
        responses.put("No", "RejectNegociations");

        this.questionMap.put("ChallengeAccepted", Question.builder()
                .label("Aceptaste el reto")
                .question("Vas a ir al puente del capitán")
                .answers(responses)
                .build());

        responses = new LinkedHashMap<>();

        responses.put("Un Soldado", "Next");
        responses.put("Un Extraterrestre", "Lying");


        this.questionMap.put("InTheBridge", Question.builder()
                .label("Has ido al puente")
                .question("Quién eres tú?")
                .answers(responses)
                .build());

        responses = new LinkedHashMap<>();

        responses.put("Un Soldado", "Next");
        responses.put("Un Extraterrestre", "Lying");


        this.questionMap.put("RejectNegociations", Question.builder()
                .label("No atendiste las negociaciones")
                .build());

        responses = new LinkedHashMap<>();

        responses.put("Si", "ChallengeAccepted");
        responses.put("No", "RejectNegociations");

        this.questionMap.put("AcceptChallenge", Question.builder()
                .label("Has perdido la memoria")
                .question("¿Aceptas continuar el juego?")
                .answers(responses)
                .build());

        this.questionMap.put("Lying", Question.builder()
                .label("Estás mintiendo, has perdido")
                .build());



    }

    public Question getQuestion(String questionId) {
        return questionMap.get(questionId);
    }
}
