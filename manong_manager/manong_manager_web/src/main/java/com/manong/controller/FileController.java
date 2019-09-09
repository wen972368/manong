package com.manong.controller;

import com.manong.fastdfs.FastDFSClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
public class FileController {
    @RequestMapping(value = "uploadFile",method = RequestMethod.POST)
    @ResponseBody
    public String uploadFile(@RequestParam MultipartFile uploadFile) throws IOException {
        String fileId = FastDFSClient.uploadFile(uploadFile.getInputStream(), uploadFile.getOriginalFilename());
        if(null!=fileId){
            System.out.println("success");
        }
        return fileId;
    }
}
