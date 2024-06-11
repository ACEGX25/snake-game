import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

public class gamepanel extends JPanel implements ActionListener {

    static final int screenwidth=600;
    static final int screenhright=600;
    static final int unitsize=25;
    static final int gameunits=(screenwidth*screenhright)/unitsize;

    static final int delay = 50;
    final int x[]= new int[gameunits];
    final int y[]= new int[gameunits];
    int bodyparts=5;
    int appleseaten=0;
    int applex;
    int appley;
    char direction='R';
    boolean running=false;
    JButton Resetb;
    Timer timer;
    Random random;
    gamepanel(){
        random= new Random();
        this.setPreferredSize(new Dimension(screenwidth,screenhright));
        this.setBackground(Color.black);
        this.setFocusable(true);
        this.addKeyListener(new MyKeyAdapter());
        startgame();
        Resetb = new JButton("Try Again Nigga");
        Resetb.setBackground(Color.magenta);
        Resetb.setFont(new Font("Monospaced", Font.BOLD, 20));
        Resetb.setFocusable(false);
        Resetb.setVisible(false);
        Resetb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                restartGame();
            }
        });
        this.setLayout(null); // Use absolute positioning
        Resetb.setBounds(150,400,300,70);
        this.add(Resetb);
    }

    public void startgame(){
        newapple();
        running=true;
        timer= new Timer(delay,this);
        timer.start();
    }
    public void restartGame() {
        Resetb.setVisible(false);
        running = true;
        x[0] = 0;
        y[0] = 0;
        direction = 'R';
        bodyparts = 5;
        appleseaten = 0;
        newapple();
        timer.restart();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        draw (g);
    }

    public void draw(Graphics g){
        if (running) {
//            for (int i = 0; i < screenhright / unitsize; i++) {
//                g.drawLine(i * unitsize, 0, i * unitsize, screenhright);
//                g.drawLine(0, i * unitsize, screenwidth, i * unitsize);
//            }
            g.setColor(Color.green);
            g.fillOval(applex, appley, unitsize, unitsize);

            for (int i = 0; i < bodyparts; i++) {
                if (i == 0) {
                    g.setColor(Color.red);
                    g.fillRect(x[i], y[i], unitsize, unitsize);
                } else {
                    g.setColor(new Color(136, 8, 8));
                    g.fillRect(x[i], y[i], unitsize, unitsize);
                }
            }
            g.setColor(Color.red);
            g.setFont(new Font("MONOSPACED",Font.BOLD,75));
            FontMetrics metrics = getFontMetrics(g.getFont());
            g.drawString("Score"+appleseaten,(screenwidth-metrics.stringWidth("Score"+appleseaten))/2,g.getFont().getSize());
        }
        else {
            gameover(g);
        }
    }
    public void move (){
        for(int i=bodyparts; i>0;i--){
            x[i] = x[i-1];
            y[i] = y[i-1];
        }
        switch (direction){
            case 'U':
                y[0]=y[0]-unitsize;
                break;
            case 'D':
                y[0]=y[0]+unitsize;
                break;
            case 'L':
                x[0]=x[0]-unitsize;
                break;
            case 'R':
                x[0]=x[0]+unitsize;
                break;
        }

    }
    public void newapple(){
        applex=random.nextInt((int) (screenwidth/unitsize))*unitsize;
        appley=random.nextInt((int) (screenhright/unitsize))*unitsize;
    }

    public void checkapple(){
        if((x[0]==applex) && (y[0]==appley)){
            bodyparts++;
            appleseaten++;
            newapple();
        }
    }

    public void checkacci(){
        //this checks if head collided with body
        for(int i=bodyparts; i>0; i--){
            if((x[0]==x[i]) && (y[0]==y[i])){
                running=false;
            }
        }
        //for other cases like left and right boundary
        if(x[0]<0){
            running=false;
        }
        if(x[0]>screenwidth){
          running = false;
        }
        //remaining cases for collsion with top and bottom
        if (y[0]<0){
            running = false;
        }
        if(y[0]>screenhright){
            running = false;
        }
        if(!running){
            timer.stop();
            Resetb.setVisible(true);
        }

    }

    public void refresh(){
        running=true;
    }

    public void gameover (Graphics g){
        // Disply score
        g.setColor(Color.red);
        g.setFont(new Font("MONOSPACED",Font.BOLD,75));
        FontMetrics metrics1 = getFontMetrics(g.getFont());
        g.drawString("Score"+appleseaten,(screenwidth-metrics1.stringWidth("Score"+appleseaten))/2,g.getFont().getSize());
        //game over text
        g.setColor(Color.red);
        g.setFont(new Font("MONOSPACED",Font.BOLD,75));
        FontMetrics metrics = getFontMetrics(g.getFont());
        g.drawString("Game Over",(screenwidth-metrics.stringWidth("Game Over"))/2,screenhright/2);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(running){
            move();
            checkapple();
            checkacci();
        }
        repaint();
    }

    public class MyKeyAdapter extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_LEFT:
                    if (direction!= 'R') {
                        direction= 'L';
                    }
                    break;
                case KeyEvent.VK_RIGHT:
                    if (direction!= 'L') {
                        direction= 'R';
                    }
                    break;
                case KeyEvent.VK_UP:
                    if (direction!= 'D') {
                        direction= 'U';
                    }
                    break;
                case KeyEvent.VK_DOWN:
                    if (direction!= 'U') {
                        direction= 'D';
                    }
                    break;
            }
        }
    }
}
