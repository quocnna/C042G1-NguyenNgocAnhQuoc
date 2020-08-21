package model;

public class NoteDTO {
    private int id;
    private String title;
    private String content;
    private int note_type_id;
    private String note_type_name;

    public NoteDTO(int id, String title, String content, int note_type_id, String note_type_name) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.note_type_id = note_type_id;
        this.note_type_name = note_type_name;
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

    public String getNote_type_name() {
        return note_type_name;
    }

    public void setNote_type_name(String note_type_name) {
        this.note_type_name = note_type_name;
    }
}
