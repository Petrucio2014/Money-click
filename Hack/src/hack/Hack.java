/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hack;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Petrucio
 */
public class Hack {

    int cont;
    Robot robot;
    Boolean ativar = false;

    public void click(int p) throws AWTException {
        robot = new Robot();
        for (int d = 0; d < p; d++) {
            robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            robot.delay(20);
            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        }
    }

    public void alternador(int q) {
        try {
            robot = new Robot();
        } catch (AWTException ex) {
            Logger.getLogger(Hack.class.getName()).log(Level.SEVERE, null, ex);
        }
        robot.keyPress(KeyEvent.VK_ALT);
        //robot.keyPress(KeyEvent.VK_TAB);
        //robot.keyRelease(KeyEvent.VK_TAB);
        for (int y = 0; y < (cont + 2); y++) {
            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyRelease(KeyEvent.VK_TAB);
            robot.delay(100);
        }
        robot.keyRelease(KeyEvent.VK_ALT);
        robot.delay(2000);
        if (cont + 1 == (q - 2) && ativar == true) {
            cont = 0;
            ativar = false;
            System.out.println("depois");
        } else if (cont + 1 == (q - 2)) {
            ativar = true;
            System.out.println("antes");
        } else {
            cont++;
        }
    }

    public static void main(String[] args) throws AWTException {
        Hack comando = new Hack();
        Robot robot = new Robot();
        robot.mouseMove(641,679);
        robot.delay(500);
        for (int q = 0;;) {
            System.out.println(robot.getPixelColor(809, 464));
            if (robot.getPixelColor(809, 464).equals(new Color(243, 240, 204))) {
                robot.mouseMove(809, 464);
                comando.click(51);
                robot.delay(500);
                if(robot.getPixelColor(911, 470).equals(new Color(61,61,61))){
                    robot.mouseMove(911, 470);
                    comando.click(1);
                }                                
                //comando.alternador(3); // se lembrar  quantidade de janelas ativas            
            } else if(robot.getPixelColor(789, 453).equals(new Color(44, 44, 44))){
                robot.mouseMove(789, 453);
                comando.click(1);
                robot.delay(500);
                System.out.println("aqui");
                System.out.println(robot.getPixelColor(641, 679));
                System.out.println("aqui");
                if(robot.getPixelColor(641,679).equals(new Color(241, 82, 73))){
                    robot.mouseMove(641,679);
                    System.out.println("funfou?");
                    System.out.println("funfou?");
                    System.out.println("funfou?");
                    System.out.println("funfou?");
                    comando.click(1);
                } else robot.delay(500);
                //comando.alternador(3); // se lembrar  da quantidade de janelas ativas     
            } // implementar o ultimo else

        }
    }
}

/*
 java.awt.Color[r=171,g=163,b=95]
 java.awt.Color[r=64,g=211,b=254]
 java.awt.Color[r=255,g=255,b=255]
 */
