/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kkie.prog.comp;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

public class Fight {

    Player pl = new Player();

    public int DragonFight(int FightPower) throws IOException, InterruptedException {
        System.out.println("전설의 용(최종보스)과 전투 하시겠습니까? 전투를 원할시 y를 눌러주세요!");
        char Enter = (char) System.in.read();
        if (Enter == 'y') {
            File clap = new File("dragon.wav");
            InputStream in = new FileInputStream(clap);
            AudioStream audioStream = new AudioStream(in);
            AudioPlayer.player.start(audioStream);

            System.out.println("★☆★☆ 전투중 ☆★☆★");
            Thread.sleep(1000);
            System.out.println("☆★☆★ 전투중 ★☆★☆");
            Thread.sleep(1000);
            System.out.println("☆★☆★ 전투중 ★☆★☆");
            Thread.sleep(1000);
            System.out.println("★☆★☆ 전투중 ☆★☆★");
            Thread.sleep(1000);
            System.out.println("☆★☆★ 전투중 ★☆★☆");
            Thread.sleep(1000);
            System.out.println("★☆★☆ 전투중 ☆★☆★");
            Thread.sleep(1000);
            System.out.println("☆★☆★ 전투중 ★☆★☆");
            Thread.sleep(1000);
            System.out.println("★☆★☆ 전투중 ☆★☆★");
            Thread.sleep(1000);

            if ((int) (Math.random() * 100) <= (FightPower / 200) - 20) {
                System.out.println("!!!!! 승리 !!!!!");
                System.out.println("★ Game Clear ★");
                return 1;
            } else {
                System.out.println(" 패배 !!!!! ");
                System.out.println(" 선원의 절반이 몰살 당했습니다 ");
                Thread.sleep(3000);
                return 0;
            }
        } else {
            System.out.println("성공적으로 도망쳤습니다.");
            Thread.sleep(3000);
            return 36;
        }
    }

    public int PirateFight(int FightPower) throws IOException, InterruptedException {

        File clap = new File("combat.wav");
        InputStream in = new FileInputStream(clap);
        AudioStream audioStream = new AudioStream(in);
        AudioPlayer.player.start(audioStream);

        System.out.println("★☆★☆ 전투중 ☆★☆★");
        Thread.sleep(1000);
        System.out.println("☆★☆★ 전투중 ★☆★☆");
        Thread.sleep(1000);
        System.out.println("☆★☆★ 전투중 ★☆★☆");
        Thread.sleep(1000);

        if ((int) (Math.random() * 100) <= 30 + FightPower / 100) {
            System.out.println("승리 !!");
            System.out.println("돈을 얻었습니다 !! (300)");
            return 1;
        } else {
            System.out.println("패배 !!");
            System.out.println("선원과 돈을 잃었습니다 !! (-10%)");
            return 0;
        }
    }
}
