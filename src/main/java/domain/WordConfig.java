package domain;

import lombok.Data;

import java.util.List;

@Data
public class WordConfig {

    private List<WordClassification> configList;
}
