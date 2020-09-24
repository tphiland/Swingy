package root.model;

public class Coordinates {

    private int x;
    private int y;
    private Monster monster;

    public Coordinates(int x, int y, Monster monster) {
        this.x = x;
        this.y = y;
        this.monster = monster;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Monster getMonster() {
        return monster;
    }

    public void setMonster(Monster monster) {
        this.monster = monster;
    }

    @Override
    public String toString() {
        return "Coordinates{" +
                "x=" + x +
                ", y=" + y +
                ", monster=" + monster +
                '}';
    }

}
