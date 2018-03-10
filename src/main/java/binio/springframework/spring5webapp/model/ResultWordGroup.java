package binio.springframework.spring5webapp.model;

import javax.persistence.*;

@Entity
@Table(name = "result_word_group")
@IdClass(ResultWordKey.class)
public class ResultWordGroup {

    @Id
    private Long idNumber;
    @Id
    private Long month;
    @Id
    private String hashCode;

    @Column(name = "word")
    private String word;


    @ManyToOne
    private ResultDefinition resultDefinition;

    public ResultWordGroup() {
    }

    public ResultWordGroup(Long idNumber, Long month, String hashCode, String word) {
        this.idNumber = idNumber;
        this.month = month;
        this.hashCode = hashCode;
        this.word = word;
    }

    public Long getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(Long idNumber) {
        this.idNumber = idNumber;
    }

    public ResultDefinition getResultDefinition() {
        return resultDefinition;
    }

    public void setResultDefinition(ResultDefinition resultDefinition) {
        this.resultDefinition = resultDefinition;
    }
}
