package com.radar.knowledgegraph.entity;

import org.neo4j.ogm.annotation.*;

import java.util.ArrayList;
import java.util.List;

@NodeEntity("OntologyKeywordNode") //该注释被用于声明一个POJO类是一个实体支持由图形数据库的节点
public class KeywordNode {

    @Id
    @GeneratedValue //这两个注释主要作用是随机产生实体的id值，取代了之前使用的@GraphId
    private Long id;

    private @Property(name = "name") //@Property：属性字段的可选注释
            String name;

    @Relationship(type = "about")
    private List<AboutEdge> literatures;


    @Relationship(type = "contain")
    private List<ContainEdge> keywords;

//    @Relationship(type = "contain")
//    private List<KeywordNode> keywords;

    public KeywordNode(String name) {
        this.name = name;
        literatures = new ArrayList<>();
        keywords = new ArrayList<>();
    }

    public void addAbout(LiteratureNode node){
        AboutEdge aboutEdge = new AboutEdge(this,node);
        this.literatures.add(aboutEdge);
    }

    public void addAbout(StandardNode node){
        AboutEdge aboutEdge = new AboutEdge(this,node);
        this.literatures.add(aboutEdge);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addContain(KeywordNode node){
        ContainEdge containEdge = new ContainEdge(this,node);
        this.keywords.add(containEdge);
    }

    public Long getId(){
        return id;
    }


}

