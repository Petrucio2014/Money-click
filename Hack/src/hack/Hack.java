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

/**
 *
 * @author Petrucio
 */
public class Hack {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Robot robot = new Robot();
            robot.delay(5000);
            Color cor = new Color(171, 163, 95);
            Color branco = new Color(255, 255, 255);
            Color fechar = new Color(124, 124, 124);
            Color fecharA = new Color(245, 245, 245);
            Color amarelo = new Color(244, 184, 68);                        
            for(;;){
                if(robot.getPixelColor(809, 464).equals(cor))
                {
                    robot.mouseMove(809, 464);
                    for(int x = 0; x<51 ; x++){
                        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
                        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
                    }
                    robot.mouseMove(900, 900);                   
                } else System.out.println("Cor nao achada");
                if(robot.getPixelColor(822, 460).equals(branco)){
                    robot.mouseMove(910, 487);
                    robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
                    robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
                    for(;;)
                    {
                        if(robot.getPixelColor(1362, 137).equals(branco)){
                            robot.mouseMove(1362, 137);
                            robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
                            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
                            System.out.println("dolita");
                            break;
                        } else if(robot.getPixelColor(1351, 150).equals(branco)){
                            robot.mouseMove(1351, 150);
                            robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
                            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
                            System.out.println("dolita2");
                            break;
                        } else if(robot.getPixelColor(1363, 138).equals(fechar)){
                            robot.mouseMove(1363, 138);
                            robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
                            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
                            System.out.println("dolita3");
                            break;
                        } else {
                            robot.delay(1000);
                            System.out.println("1");
                        }
                            
                    }
                } 
            }

            
        } catch (AWTException e) {
            e.printStackTrace();
        }

    }

}
/*
 java.awt.Color[r=171,g=163,b=95]
 java.awt.Color[r=64,g=211,b=254]
 java.awt.Color[r=255,g=255,b=255]
 */
