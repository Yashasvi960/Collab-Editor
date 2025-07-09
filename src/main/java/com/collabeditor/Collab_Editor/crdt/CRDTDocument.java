package com.collabeditor.Collab_Editor.crdt;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;

public class CRDTDocument {

    public static class CRDTCharacter {
        public String id;
        public char value;
        public boolean visible = true;

        public CRDTCharacter() {}

        public CRDTCharacter(String id, char value) {
            this.id = id;
            this.value = value;
        }
    }

        public List<CRDTCharacter> characters = new ArrayList<>();

        public void insert(int index, String id, char value) {
            CRDTCharacter newChar = new CRDTCharacter(id, value);
            characters.add(index, newChar);
        }

        public void delete(String id) {
            for(CRDTCharacter character: characters) {
                if(character.id.equals(id)) {
                    character.visible = false;
                    break;
                }
            }
        }

        @JsonIgnore
        public String getAllVisibleContent() {
           StringBuilder sb = new StringBuilder();
           for(CRDTCharacter character: characters) {
               if(character.visible) sb.append(character.value);
           }

           return sb.toString();
        }
}
