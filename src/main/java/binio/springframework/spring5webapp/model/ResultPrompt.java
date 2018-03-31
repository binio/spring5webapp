package binio.springframework.spring5webapp.model;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@IdClass(value = ResultPromptKey.class)
public class ResultPrompt {

    @Id
    private UUID id;
    @Id
    private UUID result_definition_id;
    @Id
    private ZonedDateTime result_definition_version;

    private String label;

    @Column(name = "result_prompt")
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumns({
            @JoinColumn(name = "result_prompt_id", referencedColumnName = "id"),
            @JoinColumn(name = "result_definition_version", referencedColumnName = "result_definition_version"),
            @JoinColumn(name = "result_definition_id", referencedColumnName = "result_definition_id")
    })
    private List<ResultPromptWordGroup> resultPromptWordGroup;

    public ResultPrompt() {
    }

    public ResultPrompt(UUID id, UUID result_definition_id, ZonedDateTime result_definition_version, String label, List<ResultPromptWordGroup> resultPromptWordGroup) {
        this.id = id;
        this.result_definition_id = result_definition_id;
        this.result_definition_version = result_definition_version;
        this.label = label;
        this.resultPromptWordGroup = resultPromptWordGroup;
    }
}
