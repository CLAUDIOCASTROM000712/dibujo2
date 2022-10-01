import javax.swing.*;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Polygon;


class Swing01 {
    public static void main (String args[]){
        JFrame window = new JFrame("Swing");
        MyCanvas canvas = new MyCanvas();   //Draw ton canvas

        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setSize(400, 300);
        window.add(canvas);
        window.pack();  // set the "size of frame to preferred sizes"
        window.setResizable(false); // Do not change the size frame whit mouse
        window.setLocationRelativeTo(null); // center of window
        window.setVisible(true);
       
        

    }
}

class MyCanvas extends JPanel{
    public MyCanvas(){
        setPreferredSize(new Dimension(400,300));
        setBackground(Color.GRAY);
    }
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        Paintbrush paintBrush=new Paintbrush(g);
        paintBrush.drawSky();
        paintBrush.drawMountains();
        paintBrush.drawTree();
    }
}

class Paintbrush{
    private Graphics g;
    private static final Color COLOR_BROWN=new Color(34,27,21);
    public Paintbrush(Graphics g){
        this.g=g;
    }
    public void drawSky(){
        //make Sky
        g.setColor(new Color(127,233,245));
        g.fillRect(0,0,400,100);
       
        //make Sun
        g.setColor(Color.YELLOW);
        g.fillOval(40,40,20,20);
    }

    public void drawMountains(){
        Polygon triangle=new Polygon();
        
        triangle.addPoint(15,120);
        triangle.addPoint(100,40);
        triangle.addPoint(180,130);
        g.setColor(COLOR_BROWN);
        g.fillPolygon(triangle);
    }

    public void drawTree(){
        int start=200;
        int top=50;

        //draw trunk
        g.setColor(COLOR_BROWN);
        g.fillRect(start-10,top+110,26,40);
        g.setColor(Color.GREEN);
        for(int i=0;i<5;i++){
            Polygon triangle=new Polygon();
            int height=50;
            int width=70;
            int spacing=15;

            triangle.addPoint(start,top+(spacing*i));
            triangle.addPoint(start-(width/2),top+height+(spacing*i));
            triangle.addPoint(start+(width/2),top+height+(spacing*i));

            g.fillPolygon(triangle);
        }

    }

}
