package com.radar.knowledgegraph.entity;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;

@NodeEntity("StandardNode") //该注释被用于声明一个POJO类是一个实体支持由图形数据库的节点
public class StandardNode {

    @Id
    @GeneratedValue //这两个注释主要作用是随机产生实体的id值，取代了之前使用的@GraphId
    private Long id;

    private @Property(name = "name") //@Property：属性字段的可选注释
            String name;


    public StandardNode(String name) {
        this.name = name;
    }


}

