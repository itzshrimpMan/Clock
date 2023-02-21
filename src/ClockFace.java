import javax.swing.*;
import java.awt.*;
import java.time.LocalTime;

public class ClockFace extends JPanel {
    //attributes
    private int size;
    private int middle;
    final double angle= 2*Math.PI/12;
    private int cirkSize;
    private int dx;
    private int dy;

    LocalTime time;


    //Contructor
    public ClockFace(int num){
        size = num;
        middle = size/2;
        this.setBackground(Color.white);
        this.setPreferredSize(new Dimension(size,size));
    }

    //methods
    //paints the cicle
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        time = LocalTime.now();
        face(g);
        drawNum(g);
        drawHour(g);
        drawMinute(g);
        drawSecond(g);

        repaint();
    }

    public void face(Graphics g){
        int x = (int) (size*0.1);
        int y= x;
        cirkSize= size-x*2;
        g.setColor(Color.black);
        g.fillOval(x,y,cirkSize,cirkSize);
    }

    public void drawNum(Graphics g){

        int dist= (int)((cirkSize*0.85)/2);

        for(int i= 1; i <= 12; i++) {
            double v= angle*i;
            dx = (int) ((dist * Math.sin(v))-4);
            dy= (int) ((dist * Math.cos(v))-4);
            g.setColor(Color.white);
            g.drawString(String.valueOf(i),middle+dx,middle-dy);
            //g.fillOval(middle+dx,middle+dy,10,10);
        }
    }

    public void drawHour(Graphics g){
        g.setColor(Color.blue);
        int hour = time.getHour();
        double v = ((2*Math.PI)/12)*hour;
        int dist = (int) (size*0.2);
        int posX = (int) (middle+dist * Math.sin(v));
        int posY= (int) (middle-dist * Math.cos(v));
        g.drawLine(middle, middle, posX, posY);
    }
    public void drawMinute(Graphics g){
        g.setColor(Color.red);
        int minute = time.getMinute();
        double v = ((2*Math.PI)/60)*minute;
        int dist = (int) (size*0.28);
        int posX = (int) (middle+dist * Math.sin(v));
        int posY= (int) (middle-dist * Math.cos(v));
        g.drawLine(middle, middle, posX, posY);
    }
    public void drawSecond(Graphics g){
        g.setColor(Color.white);
        int minute = time.getSecond();
        double v = ((2*Math.PI)/60)*minute;
        int dist = (int) (size*0.32);
        int posX = (int) (middle+dist * Math.sin(v));
        int posY= (int) (middle-dist * Math.cos(v));
        g.drawLine(middle, middle, posX, posY);
    }





    //get/Set

}