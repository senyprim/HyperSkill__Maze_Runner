package maze;

import java.io.Serializable;
import java.util.Objects;

public class Point implements Serializable {
        public final int x;
        public final int y;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return x == point.x &&
                y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    Point(int x, int y){
            this.x=x;
            this.y=y;
        }
}
