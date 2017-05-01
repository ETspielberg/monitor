package ub.unidue.monitor;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "process", path = "process")
public interface ProcessRepository extends PagingAndSortingRepository<Process, Long> {

	List<Process> findByProcess(@Param("process") String process);

	List<Process> findByProcessAndIdentifier(@Param("process") String process, @Param("identifier") String identifier);

}
