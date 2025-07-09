package com.collabeditor.Collab_Editor.service;

import com.collabeditor.Collab_Editor.DocumentRepository;
import com.collabeditor.Collab_Editor.crdt.CRDTDocument;
import com.collabeditor.Collab_Editor.crdt.CrdtUtil;
import com.collabeditor.Collab_Editor.model.Document;
import com.collabeditor.Collab_Editor.model.EditOperation;
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

    @Override
    public void saveDocument(Document document) {
        documentRepository.save(document);
    }

    public void applyEdit(String documentId, EditOperation operation) {
        Document doc = loadDocument(documentId);

        CRDTDocument crdtDocument = CrdtUtil.deserialize(doc.getContentJson());

        if("insert".equalsIgnoreCase(operation.type)) {
            crdtDocument.insert(operation.index, operation.id, operation.value);
        } else if("Delete".equalsIgnoreCase(operation.type)) {
            crdtDocument.delete(operation.id);
        }

        doc.setContentJson(CrdtUtil.serialize(crdtDocument));
        doc.setVersion(doc.getVersion()+1);
        saveDocument(doc);
   }


}
