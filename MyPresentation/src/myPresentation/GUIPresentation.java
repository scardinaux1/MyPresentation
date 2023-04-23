package myPresentation;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.*;

public class GUIPresentation extends JFrame {
    //atributos
    private JButton myPhoto, myHobbi, myExpectations;
    private Title title;
    private JPanel containerButtons, containerImage;
    private Listener listener;
    private JLabel imageLabel;
    private JTextArea expectativeText;



    public GUIPresentation(){
        initGUI();
        this.setTitle("My Presentation");
        this.setSize(600,600);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void initGUI() {
        title = new Title("Presentation about me", new Color(205, 156, 224));
        myPhoto = new JButton("Mi foto");
        myHobbi = new JButton("Mi hobby");
        myExpectations = new JButton("Mis expectativas para el curso son");
        containerButtons = new JPanel();
        containerImage = new JPanel();
        listener = new Listener();
        imageLabel = new JLabel();
        expectativeText = new JTextArea(10,12);

        containerImage.setBorder(BorderFactory.createTitledBorder(null,"About me",
                TitledBorder.TOP, TitledBorder.DEFAULT_JUSTIFICATION,
                new Font(Font.MONOSPACED,Font.PLAIN,20), Color.BLACK));
        containerImage.add(imageLabel);

        containerButtons.add(myExpectations);
        containerButtons.add(myHobbi);
        containerButtons.add(myPhoto);

        myPhoto.addMouseListener(listener);
        myHobbi.addMouseListener(listener);
        myExpectations.addKeyListener(listener);

        this.add(title,BorderLayout.NORTH);
        this.add(containerButtons,BorderLayout.SOUTH);
        this.add(containerImage,BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run(){GUIPresentation myGUI = new GUIPresentation();}
        });
    }

    private class Listener implements ActionListener, MouseListener, KeyListener {
        private ImageIcon image;
        private int clickCounnt;

        @Override
        public void actionPerformed(ActionEvent e) {
            //JOptionPane.showMessageDialog(null,"Pressed Button");
            imageLabel.setIcon(null);
            containerImage.remove(expectativeText);
            revalidate();
            repaint();
        }

        @Override
        public void keyTyped(KeyEvent e) {
            if(e.getKeyChar()== 'M'|| e.getKeyChar() == 'm'){
                myExpectations.doClick(); // hace clic en el botón
                System.out.println("La letra M ha sido presionada");

                imageLabel.setIcon(null);
                expectativeText.setText("""
                         Mis expectativas para el curso es poder recibir informacion clara y una ensenanza de calidad 
                         que sera vital para poder desarrollarme como una profesional en un futuro, espero sacar el
                         mayor provecho a este curso.""");
                expectativeText.setBackground(null);
                expectativeText.setForeground(Color.BLACK);
                containerImage.add(expectativeText);
            }

        }

        @Override
        public void keyPressed(KeyEvent e) {

        }

        @Override
        public void keyReleased(KeyEvent e) {

        }

        @Override
        public void mouseClicked(MouseEvent e) {
            if (e.getButton() == MouseEvent.BUTTON1) { // detecta solo el clic izquierdo del mouse
                clickCounnt++;
                if (clickCounnt == 1) {
                    System.out.println("Un click");
                    this.image = new ImageIcon(getClass().getResource("../recourses/hobby.jpeg"));
                    imageLabel.setIcon(image);
                } else if (clickCounnt == 2) {
                    System.out.println("Doble Click");
                    this.image = new ImageIcon(getClass().getResource("../recourses/yo.jpeg"));
                    imageLabel.setIcon(image);
                    clickCounnt = 0;

                }
            }

        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }
}
