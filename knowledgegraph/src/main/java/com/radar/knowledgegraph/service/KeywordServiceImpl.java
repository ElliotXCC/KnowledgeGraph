package com.radar.knowledgegraph.service;

import com.radar.knowledgegraph.entity.KeywordNode;
import com.radar.knowledgegraph.entity.LiteratureNode;
import com.radar.knowledgegraph.entity.StandardNode;
import com.radar.knowledgegraph.repository.KeywordRepository;
import com.radar.knowledgegraph.repository.LiteratureRepository;
import com.radar.knowledgegraph.repository.StandardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KeywordServiceImpl implements KeywordService{

    @Autowired
    LiteratureRepository literatureRepository;

    @Autowired
    StandardRepository standardRepository;

    @Autowired
    KeywordRepository keywordRepository;

    @Override
    public void setKeywordNode(LiteratureNode literatureNode, String[] keyword) {
        literatureRepository.save(literatureNode);
        Iterable<KeywordNode> keywords = keywordRepository.findAll();

        boolean flag = false;
        for (String s : keyword) {
            for (KeywordNode keywordNode : keywords) {
                if (s.equals(keywordNode.getName())) {
                    keywordNode.addAbout(literatureNode);
                    keywordRepository.save(keywordNode);
                    flag = true;
                }
            }
            if (!flag){
                KeywordNode newKeywordNode = new KeywordNode(s);
                newKeywordNode.addAbout(literatureNode);
                keywordRepository.save(newKeywordNode);
            }
            flag = false;
        }
    }

    @Override
    public void setOntologyKeywordNode(StandardNode standardNode, String[] keyword) {
        standardRepository.save(standardNode);
        Iterable<KeywordNode> keywords = keywordRepository.findAll();

        boolean flag = false;
        for (String s : keyword) {
            for (KeywordNode keywordNode : keywords) {
                if (s.equals(keywordNode.getName())) {
                    keywordNode.addAbout(standardNode);
                    keywordRepository.save(keywordNode);
                    flag = true;
                }
            }
            if (!flag){
                KeywordNode newKeywordNode = new KeywordNode(s);
                newKeywordNode.addAbout(standardNode);
                keywordRepository.save(newKeywordNode);
            }
            flag = false;
        }
    }

    @Override
    public void initKeywordNode(String startKeyword,String endKeyword){
        Iterable<KeywordNode> keywords = keywordRepository.findAll();

        KeywordNode start = keywordRepository.findKeywordNodeByName(startKeyword);
        KeywordNode end = keywordRepository.findKeywordNodeByName(endKeyword);

        if (start != null){
            if (end == null) {
                end = new KeywordNode(endKeyword);
            }
            start.addContain(end);
            keywordRepository.save(start);
        }
        else {
            start = new KeywordNode(startKeyword);
            if (end == null) {
                end = new KeywordNode(endKeyword);
            }
            start.addContain(end);
            keywordRepository.save(start);
        }
    }


    @Override
    public Iterable<KeywordNode> getOntologyKeywordNode(){
        Iterable<KeywordNode> keywordNodes = keywordRepository.findAll();

        return keywordNodes;

    }
}
