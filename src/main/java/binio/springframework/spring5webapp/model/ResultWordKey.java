package binio.springframework.spring5webapp.model;

import javax.persistence.Id;
import java.io.Serializable;

public class ResultWordKey implements Serializable{

    @Id
    private Long idNumber;
    @Id
    private Long month;
    @Id
    private String hashCode;
}
