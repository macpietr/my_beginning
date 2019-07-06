import Punkt.Point;
import Kontroler.PointController;


public class PointApplication {

    public static void main(String[] args) {

        PointController pc = new PointController();

        Point pkt1 = new Point();
        Point pkt2 = new Point(4,6);


        pkt1.getPoint();
        pkt2.getPoint();

        pkt1.setX(4);
        pkt1.setY(6);

        pkt1.getPoint();
        pkt2.getPoint();

        pc.addX(pkt1);
        pc.minusY(pkt1);

        pc.minusX(pkt2);
        pc.addY(pkt2);

        pkt1.getPoint();
        pkt2.getPoint();

        pc.dzialanie(pkt1,1);
        pc.dzialanie(pkt2,4);

        pkt1.getPoint();
        pkt2.getPoint();

        pc.dzialanie2(pkt1,3);
        pc.dzialanie2(pkt2,2);

        pkt1.getPoint();
        pkt2.getPoint();
    }
}
