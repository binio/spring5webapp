package binio.springframework.spring5webapp.repositories;

import binio.springframework.spring5webapp.model.ResultDefinition;
import binio.springframework.spring5webapp.model.ResultDefinitionKey;
import org.springframework.data.repository.CrudRepository;

public interface ResultDefinitionRepository  extends CrudRepository<ResultDefinition, ResultDefinitionKey> {
}
