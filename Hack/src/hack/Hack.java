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
        if (cont+1 == (q-2) && ativar == true) {
            cont = 0;
            ativar = false;
            System.out.println("depois");
        } else if(cont+1==(q-2)) {
            ativar = true;
            System.out.println("antes");
        }
        
        else cont++;
    }


    public static void main(String[] args) throws AWTException {
        Hack comando = new Hack();
        Boolean ativo = true;
        Boolean ativo2 = false;
        Robot robot = new Robot();
        robot.delay(10000);
        for (int q = 0;; ) {
            System.out.println(robot.getPixelColor(809, 464));
            if (robot.getPixelColor(809, 464).equals(new Color(243, 240, 204)) && ativo == true) {
                robot.mouseMove(809, 464);
                comando.click(50);
                for (;;) {
                    if (robot.getPixelColor(975, 136).equals(new Color(255, 255, 255))) {
                        robot.mouseMove(975, 136);
                        comando.click(1);
                    } else if (robot.getPixelColor(639, 138).equals(new Color(255, 255, 255))) {
                        robot.mouseMove(975, 136);
                        comando.click(1);
                        break;
                    } else if (robot.getPixelColor(819, 464).equals(new Color(255, 255, 255))){
                        ativo2 = true;
                        break;
                    }else {
                        robot.delay(50);
                    }
                }
                robot.mouseMove(697, 76);
                robot.delay(500);
                comando.click(1);
                for (;;) {
                    if (robot.getPixelColor(504, 246).equals(new Color(255, 255, 255))) {
                        robot.mouseMove(504,246);
                        comando.click(3);
                        if(ativo2){
                            ativo = true;
                            ativo2 = false;
                        } else
                        ativo = false;
                        break;
                    } else {
                        robot.delay(100);
                    }
                }
            } else if (robot.getPixelColor(809, 464).equals(new Color(243, 240, 204)) && ativo == false) {
                robot.mouseMove(809, 464);
                comando.click(1);

                robot.mouseMove(697, 76);
                robot.delay(500);
                comando.click(1);            
            System.out.println("Como?");
            for (;;) {
                if (robot.getPixelColor(504,246).equals(new Color(255,255,255))) {
                    robot.mouseMove(504,246);
                    comando.click(3);
                    ativo = true;
                    break;
                } else {
                    System.out.println("Erro?");
                    robot.delay(100);
                }
            }

        }else if (robot.getPixelColor(787,454).equals(new Color(44, 44, 44))) {
                robot.keyPress(KeyEvent.VK_ALT);
                robot.keyPress(KeyEvent.VK_TAB);
                robot.keyRelease(KeyEvent.VK_TAB);
                for(int y = 0;y<(q+1);y++){
                    robot.keyPress(KeyEvent.VK_TAB);
                    robot.keyRelease(KeyEvent.VK_TAB);
                    robot.delay(100);
                }
                robot.keyRelease(KeyEvent.VK_TAB);
                if(q == 0) q = 0;
            } else {
                System.out.println("Cor nao achada");
                robot.delay(1000);
            }

    }

}

}

/*
 java.awt.Color[r=171,g=163,b=95]
 java.awt.Color[r=64,g=211,b=254]
 java.awt.Color[r=255,g=255,b=255]
 */
