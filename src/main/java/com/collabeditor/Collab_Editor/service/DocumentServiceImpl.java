package com.collabeditor.Collab_Editor.service;

import com.collabeditor.Collab_Editor.DocumentRepository;
import com.collabeditor.Collab_Editor.model.Document;
import org.springframework.stereotype.Service;

@Service
public class DocumentServiceImpl implements DocumentService {

    private DocumentRepository documentRepository;

    public DocumentServiceImpl(DocumentRepository documentRepository) {
        this.documentRepository = documentRepository;
    }

    @Override
    public Document createDocument(String id) {
        Document doc = new Document();
        doc.setId(id);
        doc.setVersion(0);
        doc.setContentJson("{}");
        return documentRepository.save(doc);
    }

    @Override
    public Document loadDocument(String id) {
        return documentRepository.findById(id).orElse(null);
    }


}
