package com.collabeditor.Collab_Editor.controller;

import com.collabeditor.Collab_Editor.service.DocumentService;
import com.collabeditor.Collab_Editor.model.Document;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/documents")
public class DocumentController {

    private final DocumentService documentService;

    public DocumentController(DocumentService documentService) {
        this.documentService = documentService;
    }


    @PostMapping("/{id}")
    public ResponseEntity<String> createDocument(@PathVariable String id) {
        Document doc = documentService.createDocument(id);
        return ResponseEntity.ok(doc.getContentJson());
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getDocument(@PathVariable String id) {
        Document doc = documentService.loadDocument(id);
        if(doc==null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(doc.getContentJson());
    }
}
