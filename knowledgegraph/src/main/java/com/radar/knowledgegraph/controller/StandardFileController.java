package com.radar.knowledgegraph.controller;

import com.radar.knowledgegraph.entity.StandardNode;
import com.radar.knowledgegraph.service.KeywordService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
public class StandardFileController {
    private static final Logger log = LoggerFactory.getLogger(StandardFileController.class);


    @Autowired
    private KeywordService keywordService;


    @RequestMapping(value = "/uploadStandard")
    @ResponseBody
    public String upload(@RequestParam("file") MultipartFile file, @RequestParam("ontologyKeywords") String[] ontologyKeywords) {
        try {
            if (file.isEmpty()) {
                return "文件为空";
            }
            String fileName = file.getOriginalFilename();
            String suffixName = fileName.substring(fileName.lastIndexOf("."));
            log.info("上传的文件名为：" + fileName);
            log.info("文件的后缀名为：" + suffixName);
            String filePath = "/Users/xuchengchuan/Desktop/upload/";
            String path = filePath + fileName;
            File dest = new File(path);
            // 检测是否存在目录
            if (!dest.getParentFile().exists()) {
                dest.getParentFile().mkdirs();// 新建文件夹
            }
            file.transferTo(dest);// 文件写入
            System.out.println(path);


            StandardNode standardNode = new StandardNode(fileName);

            String[] keyword = ontologyKeywords;

            keywordService.setOntologyKeywordNode(standardNode,keyword);

            return "upload success";

        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "upload failure";
    }

}
