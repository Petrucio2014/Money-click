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

/**
 *
 * @author Petrucio & Godofga
 */
public class Propaganda {

    private final Color cor;
    private final Color idk;
    private final Color cinza;
    private final Color branco;
    private final Color fechar;
    private final Color fecharA;
    private final Color fecharAC;
    private final Color amarelo;
    private final Color able;
    private final Color cinzinha;
    private final Color cobrinha;
    private final Robot robot;
    private final Alternador alt;
    private final int margem;
    boolean dolar = true;

    public Propaganda() throws AWTException {

        margem = 2;
        idk = new Color(241, 82, 73);
        cinza = new Color(44, 44, 44);
        cinzinha = new Color(44, 44, 44);
        able = new Color(175, 197, 143);
        cor = new Color(171, 163, 95);
        branco = new Color(255, 255, 255);
        fechar = new Color(124, 124, 124);
        fecharA = new Color(234, 234, 234);
        fecharAC = new Color(235, 235, 235);
        amarelo = new Color(206, 201, 199);
        cobrinha = new Color(246, 244, 245);
        robot = new Robot();
        alt = new Alternador(3); // Quantidade de processos ativos
    }

    public void checar() throws AWTException {

        gelo();

    }

    private boolean compararCor(int x, int y, Color cor) {
        boolean found = false;
        if (robot.getPixelColor(y, y).equals(cor)) {
            found = true;
        } else {
            for (int i = -margem; i <= margem; i++) {

                for (int j = -margem; j <= margem && x + i >= 0 && x + i < 1600; j++) {
                    System.out.println("como estamos" + robot.getPixelColor(x + i, y + j));
                    if (y + j >= 0 && y + j < 900 && robot.getPixelColor(x + i, y + j).equals(cor)) {
                        System.out.println("deu certo?");
                        found = true;
                        break;
                    }
                }
                if (found) {
                    break;
                }
            }
        }
        return found;
    }

    private void clicar(int x, int y) {

        robot.mouseMove(x, y);
        clicar();

    }

    private void clicar() {

        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.delay(100);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

    }

    private void clicar(int x, int y, int t) {

        robot.mouseMove(x, y);
        for (int i = 0; i < t; i++) {
            clicar();
        }

    }

    private void gelo() {
        System.out.println("Agora" + robot.getPixelColor(778, 447));
        if (compararCor(809, 464, able)) {

            clicar(809, 464, 51);
            robot.delay(100);
            for (;;) {
                if (compararCor(921, 467, cinzinha)) {
                    System.out.println("aonde estamos indo?");
                    clicar(921, 467);
                    break;
                } else if (compararCor(927, 470, cinzinha)) {
                    clicar(927, 470);
                    break;
                } else if (compararCor(809, 464, able)) {
                    break;
                }
            }

        } else if (compararCor(778, 447, cinza)) {
            clicar(778, 447);
            robot.delay(500);
            if (compararCor(604, 715, idk) && dolar == true) {
                clicar(604, 715);
                alt.alternador();
                dolar = false;
            } else if (compararCor(819, 676, idk) && dolar == false) {
                clicar(819, 676);
                alt.alternador();
                dolar = true;
            }

        } else if (compararCor(604, 715, idk)) {
            clicar(778, 447);
            robot.delay(500);
        } else {
            fechar();
        }

    }

    private void fechar() {

        if (compararCor(1417, 106, branco)) {
            clicar(1417, 106);
            robot.delay(500);
        } else if (compararCor(1417, 106, fechar)) {
            clicar(1417, 106);
            robot.delay(500);
        } else if (compararCor(1003, 57, fecharA)) {
            clicar(1003, 57);
            robot.delay(500);
        } else if (compararCor(1003, 57, fecharAC)) {
            clicar(1003, 57);
            robot.delay(500);
        } else if (compararCor(1002, 59, amarelo)) {
            clicar(1002, 59);
            robot.delay(500);
        } else if (compararCor(1000, 61, cobrinha)) {
            clicar(10000, 61);
            robot.delay(500);
        } else {
            alt.alternador();
        }

    }

}
