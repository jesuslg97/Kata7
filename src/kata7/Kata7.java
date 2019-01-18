package kata7;

import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JFrame;

public class Kata7 extends JFrame{

    public static void main(String[] args) {
        new Kata7().launch();
    }

    private Kata7() {
        Calendar gregorianCalendar = new GregorianCalendar();
        int sec = gregorianCalendar.get(Calendar.SECOND);
        int min = gregorianCalendar.get(Calendar.MINUTE);
        int hour = gregorianCalendar.get(Calendar.HOUR_OF_DAY);

        Watch watch = new Watch(sec, min, hour);
        WatchDisplay watchDisplay = new WatchDisplay();
        new WatchPresenter(watch, watchDisplay);
        this.setTitle("Watch");
        this.setSize(400,424);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.add(watchDisplay);
    }

    private void launch() {
        this.setVisible(true);
    }
}