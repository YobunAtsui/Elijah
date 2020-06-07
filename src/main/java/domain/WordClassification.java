package domain;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class WordClassification {
    private String type;
    private List<String> words = new ArrayList<>();

}
