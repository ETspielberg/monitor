package unidue.ub.monitor;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import unidue.ub.settings.fachref.FachrefProcess;

@RepositoryRestResource(collectionResourceRel = "process", path = "process")
public interface ProcessRepository extends PagingAndSortingRepository<FachrefProcess, Long> {

	List<FachrefProcess> findByProcess(@Param("process") String process);

	List<FachrefProcess> findByProcessAndIdentifier(@Param("process") String process, @Param("identifier") String identifier);

}
