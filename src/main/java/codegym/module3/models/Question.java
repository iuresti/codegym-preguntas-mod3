package codegym.module3.models;

import lombok.Builder;
import lombok.Data;

import java.util.Map;

@Data
@Builder
public class Question {
    private String label;
    private String question;
    private Map<String, String> answers;
}
