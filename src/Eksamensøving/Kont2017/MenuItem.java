package Kont2017;

public abstract class MenuItem {
    private final String name, description;
    
    protected MenuItem(String name, String description) {
        this.name = name;
        this.description = description;
    }
 
    public String getName() {
        return name;
    }
 
    public String getDescription() {
        return description;
    }
}
