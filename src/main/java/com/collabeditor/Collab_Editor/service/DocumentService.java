package com.collabeditor.Collab_Editor.service;

import com.collabeditor.Collab_Editor.model.Document;

public interface DocumentService {

     Document createDocument(String id);

     Document loadDocument(String id);
}
