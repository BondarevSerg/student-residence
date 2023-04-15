package ru.bondarev.student.residence.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public enum Gender {
    MALE("MALE"), FEMALE("FEMALE");
    private String type;
    Gender(String type) {
        this.type = type;
    }

   public String type() {
        return type;
    }

}
