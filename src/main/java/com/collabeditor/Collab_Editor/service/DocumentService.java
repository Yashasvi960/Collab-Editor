package com.collabeditor.Collab_Editor.service;

import com.collabeditor.Collab_Editor.model.Document;
import com.collabeditor.Collab_Editor.model.EditOperation;

public interface DocumentService {

     Document createDocument(String id);

     Document loadDocument(String id);

     void saveDocument(Document doc);
     void applyEdit(String id, EditOperation operation);
}
