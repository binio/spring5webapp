package binio.springframework.spring5webapp.model;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.UUID;

public class ResultDefinitionKey implements Serializable{

    private UUID id;
    private ZonedDateTime version;
}
