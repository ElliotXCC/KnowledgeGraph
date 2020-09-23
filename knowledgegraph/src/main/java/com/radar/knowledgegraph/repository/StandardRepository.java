package com.radar.knowledgegraph.repository;

import com.radar.knowledgegraph.entity.StandardNode;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface StandardRepository extends Neo4jRepository<StandardNode, Long> {

}
