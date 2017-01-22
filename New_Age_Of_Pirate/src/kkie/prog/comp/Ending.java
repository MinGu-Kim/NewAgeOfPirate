/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kkie.prog.comp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import kkie.prog.play.PlayingGame;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

/**
 *
 * @author Kyunggeun
 */
public class Ending extends PlayingGame{

    public void Ending1(String p) throws FileNotFoundException, IOException, InterruptedException {
        File clap = new File("ending1.wav");
        InputStream in = new FileInputStream(clap);
        AudioStream audioStream = new AudioStream(in);
        AudioPlayer.player.start(audioStream);
        
        System.out.println("이로써 용과의 전투에서 승리한 "+p+". 그는 용이 가지고 있던 엄청난 양의 보물을 가지게 되었다.");
        Thread.sleep(4000);
        System.out.println("보물들을 가지고 항해하던 중 신대륙을 발견한 "+p+"은(는) 그곳에 자신의 나라를 세우게 된다. ");
        Thread.sleep(4000);
        System.out.println(p+"은(는) 자신의 나라를 클라디스라 이름짓게 되고 클라디스는 넘치는 자원과 훌륭한 인품을 가진 "+p+"의 통치 아래 장성하게 된다.");
        Thread.sleep(4000);
        System.out.println("그리고 먼 훗날 용을 처치하고 신대륙에 나라를 세운 "+p+"의 이야기는 전설로 남아");
        Thread.sleep(4000);
        System.out.println("드래곤 슬레이어 "+p+"라고 불리는 전설이 되었다. ");
        Thread.sleep(8000);
        
        theEnd();
        
    }

    public void Ending2(String p) throws FileNotFoundException, IOException, InterruptedException {
        File clap = new File("ending2.wav");
        InputStream in = new FileInputStream(clap);
        AudioStream audioStream = new AudioStream(in);
        AudioPlayer.player.start(audioStream);

        System.out.println("4개의 보물을 얻게 된 대상인 "+p+"은(는) 대륙을 너머 존재한다는 미지의 유토피아에 더 큰 보물을 발견하였고");
        Thread.sleep(4000);
        System.out.println("4개의 보물을 그곳에 함께 두어 원피스의 존재를 알리고 홀연히 사라졌다. "+p+"의 이름은 그렇게 전설이 되었다.");
        Thread.sleep(4000);
        System.out.println("그 후로 "+p+"의 모습을 그 누구도 보지 못하였고 원피스의 존재가 무엇인지 모르지만 모두 바다를 항해하여 유토피아를 찾는 꿈을 꾸게 되었고.");
        Thread.sleep(4000);
        System.out.println("그렇게 대해적시대의 서막이 시작되었다.");
        Thread.sleep(4000);
        System.out.println("전설이 되어보시겠습니까? RePlay - y/n");
        Thread.sleep(8000);
        
        theEnd();
    }
}
