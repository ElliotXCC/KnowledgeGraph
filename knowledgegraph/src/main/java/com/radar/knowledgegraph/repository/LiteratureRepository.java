package com.radar.knowledgegraph.repository;

import com.radar.knowledgegraph.entity.LiteratureNode;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface LiteratureRepository extends Neo4jRepository<LiteratureNode, Long> {

}
