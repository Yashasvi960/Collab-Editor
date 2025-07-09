package com.collabeditor.Collab_Editor.crdt;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CrdtUtil {

    public static ObjectMapper mapper = new ObjectMapper();

    public static String serialize(CRDTDocument doc) {
        try {
            return mapper.writeValueAsString(doc);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public static CRDTDocument deserialize(String json) {
        try {
            return mapper.readValue(json, CRDTDocument.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
