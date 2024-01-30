package com.mrvs.lms.mongoModel;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "Journals")
public class Journal {
    private String author;
    private String desc;
    private int volumes;
    private String techs[];
//    @Override
//    public String toString() {
//        return "Journal{" +
//                "author='" + author + '\'' +
//                ", desc='" + desc + '\'' +
//                ", volumes=" + volumes +
//                ", techs=" + Arrays.toString(techs) +
//                '}';
//    }

}
