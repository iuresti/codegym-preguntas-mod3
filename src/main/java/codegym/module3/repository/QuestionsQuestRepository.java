package codegym.module3.repository;

import codegym.module3.models.Question;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.yaml.snakeyaml.Yaml;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class QuestionsQuestRepository {

    private Map<String, Question> questionMap;

    public QuestionsQuestRepository() {
        this.questionMap = new HashMap<>();

        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        try (InputStream is = getClass().getResourceAsStream("/questions.yml")){
            TypeReference<Map<String, Question>> typeRef = new TypeReference<Map<String, Question>>() {};
            questionMap = mapper.readValue(is, typeRef);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    public Question getQuestion(String questionId) {
        return questionMap.get(questionId);
    }
}
