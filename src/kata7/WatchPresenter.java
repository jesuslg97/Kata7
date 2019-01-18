package kata7;

import java.awt.Point;
import java.util.Observable;
import java.util.Observer;

public class WatchPresenter implements Observer {
    private final Watch watch;
    private final WatchDisplay watchDisplay;

    WatchPresenter(Watch watch, WatchDisplay watchDisplay) {
        this.watch = watch;
        this.watch.add(this);
        this.watchDisplay = watchDisplay;
        this.watchDisplay.paint(pointsOf(watch));
    }

    private Point[] pointsOf(Watch watch) {
        Point[] points = new Point[3];
        points[0] = pointOf(watch.getSeconds(), 150);
        points[1] = pointOf(watch.getMinutes(), 100);
        points[2] = pointOf(watch.getHours(), 50);
        return points;
    }

    @Override
    public void update(Observable o, Object o1) {
        refresh();
    }

    private void refresh() {
        watchDisplay.paint(pointsOf(watch));
    }

    private Point pointOf(double angle, int length) {
        return new Point(toInt(Math.cos(angle)*length), toInt(Math.sin(angle)*length));
    }

    private int toInt(double value) {
        return (int) value;
    }
}