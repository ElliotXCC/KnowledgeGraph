package com.radar.knowledgegraph.service;

import com.radar.knowledgegraph.entity.KeywordNode;
import com.radar.knowledgegraph.entity.LiteratureNode;
import com.radar.knowledgegraph.entity.StandardNode;

public interface KeywordService {
    void setKeywordNode(LiteratureNode literatureNode, String[] keywords);

    void setOntologyKeywordNode(StandardNode standardNode, String[] keywords);

    void initKeywordNode(String startKeyword, String endKeyword);

    Iterable<KeywordNode> getOntologyKeywordNode();

}
