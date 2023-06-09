package com.daeyeo.command;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RentalListCmd {
    private String mainCate = "";
    private String subCate = "";
    private String sido = "";
    private String sigungu = "";
    private String searchWord = "";
    private int sort = 0;
    private int type = 0;
    private int page = 0;
}
