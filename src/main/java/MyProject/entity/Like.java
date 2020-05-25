package MyProject.entity;

public class Like {
    private int id;
    private int userfrom;
    private int userto;

    public Like(int id, int userfrom, int userto) {
        this.id = id;
        this.userfrom = userfrom;
        this.userto = userto;
    }

    public Like(int userfrom, int userto) {
        this.userfrom = userfrom;
        this.userto = userto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserfrom() {
        return userfrom;
    }

    public void setUserfrom(int userfrom) {
        this.userfrom = userfrom;
    }

    public int getUserto() {
        return userto;
    }

    public void setUserto(int userto) {
        this.userto = userto;
    }

    @Override
    public String toString() {
        return "Like{" +
                "id=" + id +
                ", userfrom=" + userfrom +
                ", userto=" + userto +
                '}';
    }
}
