package com.ohgiraffers.fileupload;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
public class FileUploadController {

    @Value("${spring.servlet.multipart.location}")
    private String filePath;

    @PostMapping("/single-file")
    public String singleFileUpload(
            @RequestParam String singleFileDescription,
            @RequestParam MultipartFile singleFile,
            Model model
    ){
        System.out.println("singleFileDescription = " + singleFileDescription);
        System.out.println("singleFile = " + singleFile);

        File dir = new File(filePath);
        if(!dir.exists()){// exists()는 폴더가 있는지 물어봄
            dir.mkdirs();
        }
        System.out.println("singleFile.getOriginalFilename() = " + singleFile.getOriginalFilename());
        String savedName = generateSavedFileName(singleFile);
        System.out.println("savedName = " + savedName);

        // 파일을 저장 한다.

        try {
            singleFile.transferTo(new File(filePath + "/" + savedName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return "result";
    }

    @PostMapping("/multi-file")
    public String multiFileUpload(
            @RequestParam String multiFileDescription,
            @RequestParam List<MultipartFile> multiFiles,
            Model model
    ){
        // DB에 저장할 File 관련 데이터 목록
        List<FileDTO> files = new ArrayList<>();

        try {
            for(MultipartFile multiFile : multiFiles){
                // 디렉토리 중복 저장 되지 않도록 고유한 파일명으로 변경
                String savedName = generateSavedFileName(multiFile);
                // 정해진 서버의 경로로 파일 저장
                multiFile.transferTo(new File(filePath + "/" + savedName));
                String originalFilename = multiFile.getOriginalFilename();

                // DB에서 관리할 파일 정보 추가
                files.add(new FileDTO(originalFilename, savedName, filePath, multiFileDescription));
            }

            files.stream().forEach(System.out::println);

            model.addAttribute("message", "다중 파일 업로드 완료");
        } catch (Exception e) {
            // 파일 저장이 중간에 실패한 경우 이전에 저장된 파일 삭제
            for(FileDTO file : files){
                new File(filePath + "/" + file.getSavedFileName()).delete();
            }
            model.addAttribute("message", "다중 파일 업로드 실패");
        }

        return "result";
    }



    private String generateSavedFileName(MultipartFile file){
        String originFileName = file.getOriginalFilename();  // spring.svg
        String ext = originFileName.substring(originFileName.lastIndexOf("."));
        return UUID.randomUUID().toString().replace("-","") + ext;
    }
}