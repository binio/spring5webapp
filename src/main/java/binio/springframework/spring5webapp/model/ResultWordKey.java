package binio.springframework.spring5webapp.model;

import javax.persistence.Id;
import java.io.Serializable;
import java.util.UUID;

public class ResultWordKey implements Serializable{


    private UUID id;

    private UUID result_definition_id;

    private String result_definition_version;
}
