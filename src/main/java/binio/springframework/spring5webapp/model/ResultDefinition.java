package binio.springframework.spring5webapp.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class ResultDefinition {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "result_definition_word_group")
    @OneToMany(cascade = CascadeType.ALL)
    private List<ResultWordGroup> wordGroup;

    public ResultDefinition() {
    }

    public ResultDefinition(String name, String description, List<ResultWordGroup> wordGroup) {
        this.name = name;
        this.description = description;
        this.wordGroup = wordGroup;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
