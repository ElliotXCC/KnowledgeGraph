package com.radar.knowledgegraph.repository;

import com.radar.knowledgegraph.entity.KeywordNode;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import java.util.Iterator;

@Repository
public interface KeywordRepository extends Neo4jRepository<KeywordNode,Long> {
    @Query("MATCH (n:KeywordNode) RETURN n.name")
    Iterator<String> findAllKeywords();

    KeywordNode findKeywordNodeByName(String name);
}
