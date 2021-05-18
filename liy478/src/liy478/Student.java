package liy478;


public class Student {

    // private String sid; 问题：1
	private String id;
    private String name;
    private String birDate;
    private String gender;

    public Student() {
    }

    //public Student(String sid, String name, String birDate, String gender) {  问题：1
    public Student(String id, String name, String birDate, String gender) {
        //this.sid = sid;  问题：1
        this.id = id;
        this.name = name;
        this.birDate = birDate;
        this.gender = gender;
    }

    //public String getSid() { 问题：1
        //return sid;  问题：1
    public String getId() {
        return id;
    }

    //public void setSid(String sid) {  问题：1
        //this.sid = sid;  问题：1
    public void setId(String id) {
            this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirDate() {
        return birDate;
    }

    public void setBirDate(String birDate) {
        this.birDate = birDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
