package Kontroler;

import Punkt.Point;

public class PointController {




    public void addX(Point point){
        int x = point.getX();
        x=x+1;
        point.setX(x);
    }

    public void minusX(Point point){
        int x = point.getX();
        x=x-1;
        point.setX(x);
    }

    public void addY(Point point){
        int y = point.getY();
        y=y+1;
        point.setY(y);
    }

    public void minusY(Point point){
        int y = point.getY();
        y=y-1;
        point.setY(y);
    }

    public void dzialanie(Point point, int x){

        switch(x) {
            case 1:
                addX(point);
                break;
            case 2:
                addY(point);
                break;
            case 3:
                minusX(point);
                break;
            case 4:
                minusY(point);
                break;
        }

    }

    public void dzialanie2(Point point, int x){
        if(x==1){
            addX(point);
        }
        else if(x==2){
            addY(point);
        }
        else if(x==3){
            minusX(point);
        }
        else if(x==4){
            minusY(point);
        }
    }


}
