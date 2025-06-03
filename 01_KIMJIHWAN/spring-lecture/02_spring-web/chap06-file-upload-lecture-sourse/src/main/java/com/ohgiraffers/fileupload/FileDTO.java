package com.ohgiraffers.fileupload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class FileDTO {

    private String originFileName;
    private String savedFileName;
    private String filePath;
    private String fileDescription;
}
