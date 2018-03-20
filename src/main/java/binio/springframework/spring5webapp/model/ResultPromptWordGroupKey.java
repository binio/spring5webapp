package binio.springframework.spring5webapp.model;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.UUID;

public class ResultPromptWordGroupKey implements Serializable{

    private String result_word;

    private  String group_number;

    private UUID result_prompt_id;

    private ZonedDateTime result_definition_version;

    private  UUID result_definition_id;
}
