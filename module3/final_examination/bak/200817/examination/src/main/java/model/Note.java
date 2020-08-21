package model;

public class Note {
    private int id;
    private String title;
    private String content;
    private int note_type_id;

    public Note(int id, String title, String content, int note_type_id) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.note_type_id = note_type_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getNote_type_id() {
        return note_type_id;
    }

    public void setNote_type_id(int note_type_id) {
        this.note_type_id = note_type_id;
    }
}
