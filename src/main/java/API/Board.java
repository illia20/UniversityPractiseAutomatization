package API;

public class Board extends ApiObj{
    private String name;

    public Board(String id){
        this.id = id;
    }

    public Board(){
        super();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
