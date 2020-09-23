package com.radar.knowledgegraph.entity;


import org.neo4j.ogm.annotation.*;

@RelationshipEntity(type = "ContainEdge")
public class ContainEdge {
    ContainEdge(){
        this.name = "contain";
    }
    public ContainEdge(KeywordNode start, KeywordNode end){
        this();
        this.startNode = start;
        this.endNode = end;

    }

    @Id
    @GeneratedValue
    private Long id;

    private String name;

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

    /**
     * 定义关系的起始节点 == StartNode
     */

    @StartNode
    private KeywordNode startNode;

    /**
     * 定义关系的终止节点 == EndNode
     */

    @EndNode
    private KeywordNode endNode;


    /**
     * 定义关系的属性
     */

    public KeywordNode getStartNode() {
        return startNode;
    }

    public void setStartNode(KeywordNode startNode) {
        this.startNode = startNode;
    }

    public KeywordNode getEndNode() {
        return endNode;
    }

    public void setEndNode(KeywordNode endNode) {
        this.endNode = endNode;
    }

}
