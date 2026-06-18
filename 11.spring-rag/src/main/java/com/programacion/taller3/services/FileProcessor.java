package com.programacion.taller3.services;

import org.springframework.ai.document.Document;
import org.springframework.ai.reader.tika.TikaDocumentReader;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.List;

@Component
public class FileProcessor {

    public List<Document> procesar(File file) {
        Resource resource = new FileSystemResource(file);
        TikaDocumentReader reader = new TikaDocumentReader(resource);
        //PagePdfDocumentReader reader = new PagePdfDocumentReader(resource);

        List<Document> documents = reader.get();

        System.out.println("FileProcessor: Documents creados: " + documents.size());
        //System.out.println("Pagina 0");
        //System.out.println(documents.get(15));

        return documents;
    }
}

