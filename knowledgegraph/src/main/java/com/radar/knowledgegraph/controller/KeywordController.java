package com.radar.knowledgegraph.controller;


import com.radar.knowledgegraph.entity.KeywordNode;
import com.radar.knowledgegraph.service.KeywordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KeywordController {

    @Autowired
    private KeywordService keywordService;

    @RequestMapping(value = "/dealKeyword")
    @ResponseBody
    public String dealKeyword(@RequestParam("startKeyword") String startKeyword,
                              @RequestParam("endKeyword") String endKeyword){

        keywordService.initKeywordNode(startKeyword,endKeyword);

        return "Deal keyword success";
    }

    @RequestMapping(value = "/getAllOntoKeywords")
    @ResponseBody
    public String getAllOntoKeywords(){
        Iterable<KeywordNode> keywordNodes =keywordService.getOntologyKeywordNode();

        String idAndName = "";
        for (KeywordNode keywordNode:keywordNodes){
            idAndName = idAndName+keywordNode.getId().toString()+keywordNode.getName();
            idAndName = idAndName+"\n";
        }
        return idAndName;
    }

}
