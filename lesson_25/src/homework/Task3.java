package homework;

public class Task3 {
    final int x;
    final int y;

    public Task3(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    /* выдаст ошибку - переменные с модификатором final нельзя инициализировать повторно
    public int setX(int x) {
        this.x = x;
    }

    public int setY(int y) {
        this.y = y;
    }
    */

}
