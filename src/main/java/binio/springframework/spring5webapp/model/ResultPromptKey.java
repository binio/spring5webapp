package binio.springframework.spring5webapp.model;

import javax.persistence.Id;
import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.UUID;

public class ResultPromptKey implements Serializable{

    private UUID id;
    private UUID result_definition_id;
    private ZonedDateTime result_definition_version;
}
