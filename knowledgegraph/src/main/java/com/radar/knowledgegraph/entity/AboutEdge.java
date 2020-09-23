package com.radar.knowledgegraph.entity;


import org.neo4j.ogm.annotation.*;

@RelationshipEntity(type = "AboutEdge")
public class AboutEdge {
    AboutEdge(){
        this.name = "about";
    }
    public AboutEdge(KeywordNode start, LiteratureNode end){
        this();
        this.startNode = start;
        this.endNode = end;

    }

    public AboutEdge(KeywordNode start, StandardNode end){
        this();
        this.startNode = start;
        this.standardNode = end;

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
    private LiteratureNode endNode;

    @EndNode
    private StandardNode standardNode;


    /**
     * 定义关系的属性
     */

    public KeywordNode getStartNode() {
        return startNode;
    }

    public void setStartNode(KeywordNode startNode) {
        this.startNode = startNode;
    }

    public LiteratureNode getEndNode() {
        return endNode;
    }

    public void setEndNode(LiteratureNode endNode) {
        this.endNode = endNode;
    }

}
