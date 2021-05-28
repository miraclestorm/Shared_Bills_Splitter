package splitter;

public class Pair {
    int ID;
    String person1;
    String person2;

    public Pair(int ID, String person1, String person2) {
        this.ID = ID;
        this.person1 = person1;
        this.person2 = person2;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "ID=" + ID +
                ", person1='" + person1 + '\'' +
                ", person2='" + person2 + '\'' +
                '}';
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getPerson1() {
        return person1;
    }

    public void setPerson1(String person1) {
        this.person1 = person1;
    }

    public String getPerson2() {
        return person2;
    }

    public void setPerson2(String person2) {
        this.person2 = person2;
    }
}
