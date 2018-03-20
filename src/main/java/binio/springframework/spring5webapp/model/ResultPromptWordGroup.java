package binio.springframework.spring5webapp.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;
import java.time.ZonedDateTime;
import java.util.UUID;

@Entity
@IdClass(value = ResultPromptWordGroupKey.class)
public class ResultPromptWordGroup {

    @Id
    private String result_word;
    @Id
    private  String group_number;
    @Id
    private UUID result_prompt_id;
    @Id
    private ZonedDateTime result_definition_version;
    //@Id
    private  UUID result_definition_id;

//    @ManyToOne
//    private ResultPrompt p;

    public ResultPromptWordGroup() {
    }

    public ResultPromptWordGroup(String result_word, String group_number, UUID result_prompt_id, ZonedDateTime result_definition_version, UUID result_definition_id) {
        this.result_word = result_word;
        this.group_number = group_number;
        this.result_prompt_id = result_prompt_id;
        this.result_definition_version = result_definition_version;
        this.result_definition_id = result_definition_id;
    }
}
