package com.collabeditor.Collab_Editor;

import com.collabeditor.Collab_Editor.model.Document;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentRepository extends JpaRepository<Document, String> {
}
