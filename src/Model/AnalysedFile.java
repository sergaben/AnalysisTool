package Model;

import java.io.File;

public class AnalysedFile {

    private String name;
    private int lines;
    private int comments;
    private int methods;
    private int halstead_comp;
    private int cyclomatic_comp;
    private int code_quality;

    /* Test comment */
    public AnalysedFile() {

    }

    public AnalysedFile(int lines, int comments, int methods, int halstead_comp, int cyclomatic_comp, int code_quality) {
        this.lines = lines;
        this.comments = comments;
        this.methods = methods;
        this.halstead_comp = halstead_comp;
        this. cyclomatic_comp = cyclomatic_comp;
        this.code_quality = code_quality;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public int getLines() {
        return lines;
    }

    public void setLines(int lines) {
        this.lines = lines;
    }

    public int getComments() {
        return comments;
    }

    public void setComments(int comments) {
        this.comments = comments;
    }

    public int getMethods() {
        return methods;
    }

    public void setMethods(int methods) {
        this.methods = methods;
    }

    public int getHalstead_comp() {
        return halstead_comp;
    }

    public void setHalstead_comp(int halstead_comp) {
        this.halstead_comp = halstead_comp;
    }

    public int getCyclomatic_comp() {
        return cyclomatic_comp;
    }

    public void setCyclomatic_comp(int cyclomatic_comp) {
        this.cyclomatic_comp = cyclomatic_comp;
    }

    public int getCode_quality() {
        return code_quality;
    }

    public void setCode_quality(int code_quality) {
        this.code_quality = code_quality;
    }

    /*
    {
      "name" : "mkyong",
      "lines" : 0,
      "comments" : null,
      "methods" : "null",
      "halstead_comp" : "null",
      "cyclomatic_comp": "null",
      "code_quality": "null"
    }
     */

    public String exportToJSON(File file) {
        String json = "{\n";

        return json;
    }

    public static AnalysedFile getFromJSON(File file) {



        return new AnalysedFile();
    }
}