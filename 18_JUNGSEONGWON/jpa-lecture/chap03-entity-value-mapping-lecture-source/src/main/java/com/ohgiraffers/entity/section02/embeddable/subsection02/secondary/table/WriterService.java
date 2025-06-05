package com.ohgiraffers.entity.section02.embeddable.subsection02.secondary.table;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class WriterService {

    private WriterRepository writerRepository;

    public WriterService(WriterRepository writerRepository) {
        this.writerRepository = writerRepository;
    }

    @Transactional
    public void registWriter(WriterDTO writerDTO){
        WriterInfo writerInfo = WriterInfo.builder().selfIntroduction(writerDTO.getSelfIntroduction()).build();

        Address address = Address.builder()
                                .address1(writerDTO.getAddress1())
                                .address2(writerDTO.getAddress2())
                                .zipCode(writerDTO.getZipCode())
                                .build();

        Writer writer = Writer.builder()
                .id(writerDTO.getId())
                .name(writerDTO.getName())
                .writerInfo(writerInfo)
                .address(address).build();

        writerRepository.registWriter(writer);
    }
}
