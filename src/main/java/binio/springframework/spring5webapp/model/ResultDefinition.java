package binio.springframework.spring5webapp.model;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@IdClass(value = ResultDefinitionKey.class)
public class ResultDefinition {

    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String name;

    private String desCription;


    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumns( {
            @JoinColumn(name = "result_definition_id", referencedColumnName = "id" ),
            @JoinColumn(name = "result_definition_version", referencedColumnName = "version")
    })
    private List<ResultPrompt> prompts;

    @Id
    @Column(name = "version")
    private ZonedDateTime version;

    public ResultDefinition() {
    }

    public ResultDefinition(UUID id, String name, String description, List<ResultPrompt> prompts, ZonedDateTime version) {
        this.id = id;
        this.name = name;
        this.desCription = description;
        this.prompts = prompts;
        this.version = version;
    }
}
