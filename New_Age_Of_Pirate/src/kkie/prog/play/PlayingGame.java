/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kkie.prog.play;

import java.io.IOException;
import kkie.prog.comp.Product;
import kkie.prog.comp.*;

public class PlayingGame {

    public static void main(String[] argv) throws IOException, InterruptedException {

        LetsGo fantasyWorld = new LetsGo();
        fantasyWorld.LetsGo();

    }

    public void theEnd() throws InterruptedException, IOException {

        System.out.print("....");
        Thread.sleep(500);
        System.out.print(" ....");
        Thread.sleep(500);
        System.out.print(" .....");
        Thread.sleep(500);
        System.out.println(".... ... 철수야 학교가야지! 어서 일어나렴~");
        System.out.print(".");
        Thread.sleep(1000);
        System.out.print(".");
        Thread.sleep(1000);
        System.out.print(".");
        Thread.sleep(1000);
        System.out.println("FIN ★");

        System.out.println("학교에 가시겠습니까? y/n");
        Thread.sleep(60000);
        char Enter = (char) System.in.read();
        if (Enter == 'y') {
            System.exit(1);
        } else {
            System.exit(1);
        }
    }
}
