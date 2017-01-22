/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kkie.prog.play;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;
import kkie.prog.comp.*;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

public class LetsGo {

    int xx = 7;
    int yy = 40;
    int cnt = 0;
    Map m = new Map();
    Ship s = new Ship();
    Fight f = new Fight();
    Ending e = new Ending();
    Player pl = new Player();
    Scanner sc = new Scanner(System.in);
    Port[] port = new Port[4];
    Product[] prod = new Product[7];
    ArrayList hidden = new ArrayList();

    public void LetsGo() throws IOException, InterruptedException {

        System.out.println("케릭터명을 입력하세요.");

        String input;
        boolean check = false;
        do {
            input = sc.nextLine();

            if (input.length() == 0) {
                check = false;
            } else {
                for (int i = 0; i < input.length(); i++) {
                    if (input.charAt(i) != ' ') {
                        check = true;
                    }
                }
            }
            if (check == false) {
                System.out.println("다시 입력하세요.");
            }
        } while (check != true);
        
        
        File clap = new File("sea.wav");
        InputStream in = new FileInputStream(clap);
        AudioStream audioStream = new AudioStream(in);
        AudioPlayer.player.start(audioStream); // 음악재생
        
        Thread.sleep(2000);
        System.out.println("생전에 모든것을 얻었던 사나이, 해적왕 박관희는");
        Thread.sleep(3000);
        System.out.println("자신의 최고의 보물 4개를 어딘가에 두었다고 말한 후 처형을 당한다.");
        Thread.sleep(3500);
        System.out.println("박관희 : 나의 보물? 원한다면 주도록 하지.... 무역을 통해 돈을 벌면서 잘 찾아봐.");
        Thread.sleep(4000);
        System.out.println("이 세상의 모든 보물을 그곳에 두고 왔으니까. 크하하");
        Thread.sleep(4000);
        System.out.println("그의 마지막 발언은 신해적시대를 열게 되는 방아쇠역할을 하게 되는데...");
        Thread.sleep(4000);

        pl.setPlayer(input, 1000, 500, 5, 400, 100, 100, 0, 0, 0, 0);
        //이름 돈 전투력 선원 무게 물 음식 특산물4개

        port[0] = new Port();
        port[0].setName("금빛항");
        port[0].setNpcName("아리");
        port[0].setLove(0);
        port[0].setPxPy(10, 27);

        port[1] = new Port();
        port[1].setName("누에항");
        port[1].setNpcName("리타");
        port[1].setLove(0);
        port[1].setPxPy(10, 70);

        port[2] = new Port();
        port[2].setName("포도항");
        port[2].setNpcName("이자벨");
        port[2].setLove(0);
        port[2].setPxPy(32, 62);

        port[3] = new Port();
        port[3].setName("인어항");
        port[3].setNpcName("곽선희");
        port[3].setLove(0);
        port[3].setPxPy(21, 51);

        prod[0] = new Product();
        prod[0].setName("물");
        prod[0].setWeight(1);
        prod[0].setPrice(10);

        prod[1] = new Product();
        prod[1].setName("빵");
        prod[1].setWeight(1);
        prod[1].setPrice(10);

        prod[2] = new Product();
        prod[2].setName("금");
        prod[2].setWeight(30);
        prod[2].setPrice(400);

        prod[3] = new Product();
        prod[3].setName("실크");
        prod[3].setWeight(4);
        prod[3].setPrice(100);

        prod[4] = new Product();
        prod[4].setName("열대과일");
        prod[4].setWeight(20);
        prod[4].setPrice(300);

        prod[5] = new Product();
        prod[5].setName("물고기");
        prod[5].setWeight(15);
        prod[5].setPrice(280);

        prod[6] = new Product();
        prod[6].setName("선원");
        prod[6].setWeight(30);
        prod[6].setPrice(400);

        while (true) {
            System.out.println("　　　　　　　　　　　　　   　▶▶▶▶▶▶▶▶▶▶" + "  Name: " + pl.getName() + "  Money: " + pl.money + "  Power: " + pl.power + "  Crews: " + pl.crews + "  Food: " + pl.foodN + "  Water: " + pl.waterN + "  Weight: " + pl.weight + " / " + s.topWeight + " ◀◀◀◀◀◀◀◀◀");
            m.printMap(xx, yy);
            moveShip();
        }
    }

    public void moveShip() throws IOException, InterruptedException {

        cnt++;
        if ((cnt / 100) % 2 == 0) {
            prod[4].setPrice(400); // 과일값 변동 300->400
            prod[2].setPrice(350); // 금값 변동 400->350
        } else {
            prod[4].setPrice(200); // 과일값
            prod[2].setPrice(450); // 금값
        } // 계절에 따라 과일값, 금값 변경

        if ((int) (Math.random() * 100) >= 99) {
            System.out.println("♨♨♨♨♨♨♨♨  인어가 선원 한명을 홀려 데려갔습니다. ♨♨♨♨♨♨♨♨");
            pl.crews--;
            if (hidden.contains("믿음의 조각")) {
                pl.crews++;
                System.out.println("선원은 " + pl.name + "을(를) 향한 믿음의 힘으로 다시 돌아왔습니다.");
                Thread.sleep(2000);
            }
        }

        if (pl.foodN < 0 || pl.waterN < 0) {
            gameOver();
        }

        try {
            int move = Integer.parseInt(sc.nextLine());

            pl.foodN--; //이동할때마다 음식 1씩 감소
            pl.waterN--;
            pl.weight-=2;

            if (xx >= 20 && pl.weight >= 1500) {

                if (move == 4) {
                    yy -= 3;
                } else if (move == 6) {
                    yy += 1;
                } else if (move == 5) {
                    xx += 2;
                } else if (move == 8) {
                    xx -= 2;
                }
                if (m.region[xx][yy] == '▒') {
                    if (move == 4) {
                        yy += 3;
                    } else if (move == 6) {
                        yy -= 1;
                    } else if (move == 5) {
                        xx -= 2;
                    } else if (move == 8) {
                        xx += 2;
                    }
                    System.out.println("                                                                   ▶▶▶▶▶▶▶ 이동 할 수 없습니다 ◀◀◀◀◀◀ ");
                }
                if (m.region[xx][yy] == '■') {
                    Port1();
                }
                if (m.region[xx][yy] == '★') {
                    Port2();
                }
                if (m.region[xx][yy] == '♨') {
                    Port3();
                }
                if (m.region[xx][yy] == '♥') {
                    Port4();
                }
                if (m.region[xx][yy] == '♪') {
                    music();
                    yy -=2 ;
                }
                if (m.region[xx][yy] == '◆') {
                    int a = f.DragonFight(pl.power);
                    if (a == 1) {
                        if (hidden.size() == 4) {
                            e.Ending1(pl.name);
                        }
                        if (hidden.size() != 4) {
                            e.Ending2(pl.name);
                        }
                    }
                    if (a == 0) {
                        pl.crews = pl.crews / 2;
                        xx = 30;
                        yy = 24;
                        m.printMap(xx, yy);
                        moveShip();
                    }
                    if (a == 36) {
                        xx = 30;
                        yy = 24;
                        m.printMap(xx, yy);
                        moveShip();
                    }
                }
                if ((int) (Math.random() * 100) <= 3) {
                    System.out.println("                   ★★★★ 해적출현 ★★★★");
                    System.out.println("                   ◆◆◆◆ 해적출현 ◆◆◆◆");
                    System.out.println("                   ★★★★ 해적출현 ★★★★");
                    System.out.println("                   ◆◆◆◆ 해적출현 ◆◆◆◆");
                    System.out.println("                   ★★★★ 해적출현 ★★★★");
                    System.out.println("                   ◆◆◆◆ 해적출현 ◆◆◆◆");
                    System.out.println("                   ★★★★ 해적출현 ★★★★");
                    Thread.sleep(1000);
                    System.out.println("해적 출현! 싸움을 시작합니다.");
                    Thread.sleep(1000);
                    int a = f.PirateFight(pl.power);
                    if (a == 1) {
                        pl.money += 300;
                        Thread.sleep(3000);
                    }
                    if (a == 0) {
                        pl.money = (int) ((double) pl.money * 0.9);
                        pl.crews = (int) ((double) pl.crews * 0.9);
                        Thread.sleep(3000);
                    }
                }
            } else if (xx < 20 && pl.weight >= 1500) {
                if (move == 4) {
                    yy -= 1;
                } else if (move == 6) {
                    yy += 3;
                } else if (move == 5) {
                    xx += 2;
                } else if (move == 8) {
                    xx -= 2;
                }
                if (m.region[xx][yy] == '▒') {
                    if (move == 4) {
                        yy += 1;
                    } else if (move == 6) {
                        yy -= 3;
                    } else if (move == 5) {
                        xx -= 2;
                    } else if (move == 8) {
                        xx += 2;
                    }
                    System.out.println("                                                                   ▶▶▶▶▶▶▶ 이동 할 수 없습니다 ◀◀◀◀◀◀ ");
                }
                if (m.region[xx][yy] == '■') {
                    Port1();
                }
                if (m.region[xx][yy] == '★') {
                    Port2();
                }
                if (m.region[xx][yy] == '♨') {
                    Port3();
                }
                if (m.region[xx][yy] == '♥') {
                    Port4();
                }
                if ((int) (Math.random() * 100) <= 5) {
                    System.out.println("                   ★★★★ 해적출현 ★★★★");
                    System.out.println("                   ◆◆◆◆ 해적출현 ◆◆◆◆");
                    System.out.println("                   ★★★★ 해적출현 ★★★★");
                    System.out.println("                   ◆◆◆◆ 해적출현 ◆◆◆◆");
                    System.out.println("                   ★★★★ 해적출현 ★★★★");
                    System.out.println("                   ◆◆◆◆ 해적출현 ◆◆◆◆");
                    System.out.println("                   ★★★★ 해적출현 ★★★★");
                    Thread.sleep(1000);
                    System.out.println("해적 출현! 싸움을 시작합니다.");
                    Thread.sleep(1000);
                    int a = f.PirateFight(pl.power);
                    if (a == 1) {
                        pl.money += 300;
                        Thread.sleep(3000);
                    }
                    if (a == 0) {
                        pl.money = (int) ((double) pl.money * 0.9);
                        pl.crews = (int) ((double) pl.crews * 0.9);
                        Thread.sleep(3000);
                    }
                }
            } else if (xx >= 20 && pl.weight < 1500) {
                if (move == 4) {
                    yy -= 4;
                } else if (move == 6) {
                    yy += 2;
                } else if (move == 5) {
                    xx += 3;
                } else if (move == 8) {
                    xx -= 3;
                }
                if (m.region[xx][yy] == '▒') {
                    if (move == 4) {
                        yy += 4;
                    } else if (move == 6) {
                        yy -= 2;
                    } else if (move == 5) {
                        xx -= 3;
                    } else if (move == 8) {
                        xx += 3;
                    }
                    System.out.println("                                                                   ▶▶▶▶▶▶▶ 이동 할 수 없습니다 ◀◀◀◀◀◀ ");
                }
                if (m.region[xx][yy] == '■') {
                    Port1();
                }
                if (m.region[xx][yy] == '★') {
                    Port2();
                }
                if (m.region[xx][yy] == '♨') {
                    Port3();
                }
                if (m.region[xx][yy] == '♥') {
                    Port4();
                }
                if (m.region[xx][yy] == '♪') {
                    music();
                    yy -=2 ;
                }
                if (m.region[xx][yy] == '◆') {
                    int a = f.DragonFight(pl.power);
                    if (a == 1) {
                        if (hidden.size() == 4) {
                            e.Ending2(pl.name);
                        }
                        if (hidden.size() != 4) {
                            e.Ending1(pl.name);
                        }
                    }
                    if (a == 0) {
                        pl.crews = pl.crews / 2;
                        xx = 30;
                        yy = 24;
                        m.printMap(xx, yy);
                        moveShip();
                    }
                    if (a == 36) {
                        xx = 30;
                        yy = 24;
                        m.printMap(xx, yy);
                        moveShip();
                    }
                }
                if ((int) (Math.random() * 100) <= 3) {
                    System.out.println("                   ★★★★ 해적출현 ★★★★");
                    System.out.println("                   ◆◆◆◆ 해적출현 ◆◆◆◆");
                    System.out.println("                   ★★★★ 해적출현 ★★★★");
                    System.out.println("                   ◆◆◆◆ 해적출현 ◆◆◆◆");
                    System.out.println("                   ★★★★ 해적출현 ★★★★");
                    System.out.println("                   ◆◆◆◆ 해적출현 ◆◆◆◆");
                    System.out.println("                   ★★★★ 해적출현 ★★★★");
                    Thread.sleep(1000);
                    System.out.println("해적 출현! 싸움을 시작합니다.");
                    Thread.sleep(1000);
                    int a = f.PirateFight(pl.power);
                    if (a == 1) {
                        pl.money += 300;
                        Thread.sleep(3000);
                    }
                    if (a == 0) {
                        pl.money = (int) ((double) pl.money * 0.9);
                        pl.crews = (int) ((double) pl.crews * 0.9);
                        Thread.sleep(3000);
                    }
                }
            } else if (xx < 20 && pl.weight < 1500) {
                if (move == 4) {
                    yy -= 2;
                } else if (move == 6) {
                    yy += 4;
                } else if (move == 5) {//아래로` 
                    xx += 3;
                } else if (move == 8) {//위로
                    xx -= 3;
                }
                if (m.region[xx][yy] == '▒') {

                    if (move == 4) { //좌측
                        yy += 2;
                    } else if (move == 6) {//우측
                        yy -= 4;
                    } else if (move == 5) {//아래로
                        xx -= 3;
                    } else if (move == 8) {//위로
                        xx += 3;
                    }
                    System.out.println("                                                                   ▶▶▶▶▶▶▶ 이동 할 수 없습니다 ◀◀◀◀◀◀ ");
                }
                if (m.region[xx][yy] == '■') {
                    Port1();
                }
                if (m.region[xx][yy] == '★') {
                    Port2();
                }
                if (m.region[xx][yy] == '♨') {
                    Port3();
                }
                if (m.region[xx][yy] == '♥') {
                    Port4();
                }
                if ((int) (Math.random() * 100) <= 5) {
                    System.out.println("                   ★★★★ 해적출현 ★★★★");
                    System.out.println("                   ◆◆◆◆ 해적출현 ◆◆◆◆");
                    System.out.println("                   ★★★★ 해적출현 ★★★★");
                    System.out.println("                   ◆◆◆◆ 해적출현 ◆◆◆◆");
                    System.out.println("                   ★★★★ 해적출현 ★★★★");
                    System.out.println("                   ◆◆◆◆ 해적출현 ◆◆◆◆");
                    System.out.println("                   ★★★★ 해적출현 ★★★★");
                    Thread.sleep(1000);
                    System.out.println("해적 출현! 싸움을 시작합니다.");
                    Thread.sleep(1000);
                    int a = f.PirateFight(pl.power);
                    if (a == 1) {
                        pl.money += 300;
                        Thread.sleep(3000);
                    }
                    if (a == 0) {
                        pl.money = (int) ((double) pl.money * 0.9);
                        pl.crews = (int) ((double) pl.crews * 0.9);
                        Thread.sleep(3000);
                    }
                }
            }
        } catch (NumberFormatException e) {
        }
    }

    public void Port1() throws IOException, InterruptedException {
        Scanner ss = new Scanner(System.in);
        System.out.print("항구에 입장하시겠습니까? 입장하시려면 y를 입력하세요.");

        char Enter = (char) System.in.read();

        if (Enter == 'y') {
            m.printMap(xx, yy);
            System.out.println("어서오십시오. " + port[0].getName() + "입니다.");
            Shop1();
        } else {
            goOut1();
        }
    }

    public void Port2() throws IOException, InterruptedException {
        Scanner ss = new Scanner(System.in);
        System.out.print("항구에 입장하시겠습니까? 입장하시려면 y를 입력하세요.");

        char Enter = (char) System.in.read();

        if (Enter == 'y') {
            m.printMap(xx, yy);
            System.out.println("어서오십시오. " + port[1].getName() + "입니다.");
            Shop2();
        } else {
            goOut2();
        }
    }

    public void Port3() throws IOException, InterruptedException {
        Scanner ss = new Scanner(System.in);
        System.out.print("항구에 입장하시겠습니까? 입장하시려면 y를 입력하세요.");

        char Enter = (char) System.in.read();

        if (Enter == 'y') {
            m.printMap(xx, yy);
            System.out.println("어서오십시오. " + port[2].getName() + "입니다.");
            Shop3();
        } else {
            goOut3();
        }
    }

    public void Port4() throws IOException, InterruptedException {
        Scanner ss = new Scanner(System.in);
        System.out.print("항구에 입장하시겠습니까? 입장하시려면 y를 입력하세요.");

        char Enter = (char) System.in.read();

        if (Enter == 'y') {
            m.printMap(xx, yy);
            System.out.println("어서오십시오. " + port[3].getName() + "입니다.");
            Shop4();
        } else {
            goOut4();
        }
    }

    public void Shop1() throws IOException, InterruptedException {
        System.out.println("잔액 : " + pl.money + " 무게 : " + pl.weight);
        System.out.println("소유목록 // 물: " + pl.waterN + " 빵: " + pl.foodN + " 금: " + pl.goldN + " 실크: " + pl.silkN + " 열대과일: " + pl.fruitN + " 물고기: " + pl.fishN);
        System.out.println("1.구매 2.판매 3.고용 4.대화 5.나가기");
        int enter = sc.nextInt();
        switch (enter) {
            case 1:
                buy1();
                break;
            case 2:
                sell1();
                break;
            case 3:
                hire1();
                break;
            case 4:
                sayHi1();
                break;
            case 5:
                goOut1();
                break;
            case 777:
                pl.money += 100000;
                System.out.println("잭팟 당첨!!!");
                Thread.sleep(1000);
                Shop1();
                break;
        }
    }

    public void Shop2() throws IOException, InterruptedException {
        System.out.println("잔액 : " + pl.money + " 무게 : " + pl.weight);
        System.out.println("소유목록 // 물: " + pl.waterN + " 빵: " + pl.foodN + " 금: " + pl.goldN + " 실크: " + pl.silkN + " 열대과일: " + pl.fruitN + " 물고기: " + pl.fishN);
        System.out.println("1.구매 2.판매 3.고용 4.대화 5.나가기");
        int enter = sc.nextInt();
        switch (enter) {
            case 1:
                buy2();
                break;
            case 2:
                sell2();
                break;
            case 3:
                hire2();
                break;
            case 4:
                sayHi2();
                break;
            case 5:
                goOut2();
                break;
        }
    }

    public void Shop3() throws IOException, InterruptedException {
        System.out.println("잔액 : " + pl.money + " 무게 : " + pl.weight);
        System.out.println("소유목록 // 물: " + pl.waterN + " 빵: " + pl.foodN + " 금: " + pl.goldN + " 실크: " + pl.silkN + " 열대과일: " + pl.fruitN + " 물고기: " + pl.fishN);
        System.out.println("1.구매 2.판매 3.고용 4.대화 5.나가기 6.배 업그레이드");
        int enter = sc.nextInt();
        switch (enter) {
            case 1:
                buy3();
                break;
            case 2:
                sell3();
                break;
            case 3:
                hire3();
                break;
            case 4:
                sayHi3();
                break;
            case 5:
                goOut3();
                break;
            case 6:
                System.out.println("500원을 내시고 배를 업그레이드 시키시겠습니까? y 입력시 업그레이드.");
                char Enter = (char) System.in.read();
                if (Enter == 'y') {
                    s.shipLvup();
                    pl.power += 200;
                    pl.money -= 500;
                    if (pl.money < 0) {
                        System.out.println("잔액이 부족합니다.");
                        pl.power -= 200;
                        pl.money += 500;
                        Thread.sleep(3000);
                    } else {
                        System.out.println("적재량 + 500, 전투력 + 200");
                        Thread.sleep(3000);
                        Shop3();
                    }
                } else {
                    Shop3();
                }
                break;
        }
    }

    public void Shop4() throws IOException, InterruptedException {
        System.out.println("잔액 : " + pl.money + " 무게 : " + pl.weight);
        System.out.println("소유목록 // 물: " + pl.waterN + " 빵: " + pl.foodN + " 금: " + pl.goldN + " 실크: " + pl.silkN + " 열대과일: " + pl.fruitN + " 물고기: " + pl.fishN);
        System.out.println("1.구매 2.판매 3.고용 4.대화 5.나가기");
        int enter = sc.nextInt();
        switch (enter) {
            case 1:
                buy4();
                break;
            case 2:
                sell4();
                break;
            case 3:
                hire4();
                break;
            case 4:
                sayHi4();
                break;
            case 5:
                goOut4();
                break;
        }
    }

    public void buy1() throws IOException, InterruptedException {
        System.out.println("1.물  2.빵  3.금");
        int enter2 = sc.nextInt();
        if (enter2 == 1) {
            System.out.println("잔액: " + pl.money + " 무게: " + pl.weight + " / " + s.topWeight + " 소유한 물: " + pl.waterN + " 물의 가격: " + prod[0].getPrice());
            System.out.println("물을 몇 개 구입하시겠습니까?");
            int enter3 = sc.nextInt();
            pl.waterN += enter3;
            pl.money -= enter3 * prod[0].getPrice();
            pl.weight += enter3 * prod[0].getWeight();
            if (enter3 > 0 && pl.weight <= s.topWeight && pl.money >= 0) {
                Shop1();
            } else {
                pl.waterN -= enter3;
                pl.money += enter3 * prod[0].getPrice();
                pl.weight -= enter3 * prod[0].getWeight();
                System.out.println("무게 및 돈이 적절하지 않습니다.");
                Shop1();
            }
        }
        if (enter2 == 2) {
            System.out.println("잔액: " + pl.money + " 무게: " + pl.weight + " / " + s.topWeight + " 소유한 빵: " + pl.foodN + " 빵의 가격: " + prod[1].getPrice());
            System.out.println("빵을 몇 개 구입하시겠습니까?");
            int enter3 = sc.nextInt();
            pl.foodN += enter3;
            pl.money -= enter3 * prod[1].getPrice();
            pl.weight += enter3 * prod[1].getWeight();
            if (enter3 > 0 && pl.weight <= s.topWeight && pl.money >= 0) {
                Shop1();
            } else {
                pl.foodN -= enter3;
                pl.money += enter3 * prod[1].getPrice();
                pl.weight -= enter3 * prod[1].getWeight();
                System.out.println("무게 및 돈이 적절하지 않습니다.");
                Shop1();
            }
        }
        if (enter2 == 3) {
            System.out.println("잔액: " + pl.money + " 무게: " + pl.weight + " / " + s.topWeight + " 소유한 금: " + pl.goldN + " 금의 가격: " + prod[2].getPrice());
            System.out.println("금을 몇 개 구입하시겠습니까?");
            int enter3 = sc.nextInt();
            pl.goldN += enter3;
            pl.money -= enter3 * prod[2].getPrice();
            pl.weight += enter3 * prod[2].getWeight();
            if (enter3 > 0 && pl.weight <= s.topWeight && pl.money >= 0) {
                Shop1();
            } else {
                pl.goldN -= enter3;
                pl.money += enter3 * prod[2].getPrice();
                pl.weight -= enter3 * prod[2].getWeight();
                System.out.println("무게 및 돈이 적절하지 않습니다.");
                Shop1();
            }
        }
    }

    public void buy2() throws IOException, InterruptedException {
        System.out.println("1.물  2.빵  3.실크");
        int enter2 = sc.nextInt();
        if (enter2 == 1) {
            System.out.println("잔액: " + pl.money + " 무게: " + pl.weight + " / " + s.topWeight + " 소유한 물: " + pl.waterN + " 물의 가격: " + prod[0].getPrice());
            System.out.println("물을 몇 개 구입하시겠습니까?");
            int enter3 = sc.nextInt();
            pl.waterN += enter3;
            pl.money -= enter3 * prod[0].getPrice();
            pl.weight += enter3 * prod[0].getWeight();
            if (enter3 > 0 && pl.weight <= s.topWeight && pl.money >= 0) {
                Shop2();
            } else {
                pl.waterN -= enter3;
                pl.money += enter3 * prod[0].getPrice();
                pl.weight -= enter3 * prod[0].getWeight();
                System.out.println("무게 및 돈이 적절하지 않습니다.");
                Shop2();
            }
        }
        if (enter2 == 2) {
            System.out.println("잔액: " + pl.money + " 무게: " + pl.weight + " / " + s.topWeight + " 소유한 빵: " + pl.foodN + " 빵의 가격: " + prod[1].getPrice());
            System.out.println("빵을 몇 개 구입하시겠습니까?");
            int enter3 = sc.nextInt();
            pl.foodN += enter3;
            pl.money -= enter3 * prod[1].getPrice();
            pl.weight += enter3 * prod[1].getWeight();
            if (enter3 > 0 && pl.weight <= s.topWeight && pl.money >= 0) {
                Shop2();
            } else {
                pl.foodN -= enter3;
                pl.money += enter3 * prod[1].getPrice();
                pl.weight -= enter3 * prod[1].getWeight();
                System.out.println("무게 및 돈이 적절하지 않습니다.");
                Shop2();
            }
        }
        if (enter2 == 3) {
            System.out.println("잔액: " + pl.money + " 무게: " + pl.weight + " / " + s.topWeight + " 소유한 실크: " + pl.silkN + " 실크의 가격: " + prod[3].getPrice());
            System.out.println("실크를 몇 개 구입하시겠습니까?");
            int enter3 = sc.nextInt();
            pl.silkN += enter3;
            pl.money -= enter3 * prod[3].getPrice();
            pl.weight += enter3 * prod[3].getWeight();
            if (enter3 > 0 && pl.weight <= s.topWeight && pl.money >= 0) {
                Shop2();
            } else {
                pl.silkN -= enter3;
                pl.money += enter3 * prod[3].getPrice();
                pl.weight -= enter3 * prod[3].getWeight();
                System.out.println("무게 및 돈이 적절하지 않습니다.");
                Shop2();
            }
        }
    }

    public void buy3() throws IOException, InterruptedException {
        System.out.println("1.물  2.빵  3.열대과일");
        int enter2 = sc.nextInt();
        if (enter2 == 1) {
            System.out.println("잔액: " + pl.money + " 무게: " + pl.weight + " / " + s.topWeight + " 소유한 물: " + pl.waterN + " 물의 가격: " + prod[0].getPrice());
            System.out.println("물을 몇 개 구입하시겠습니까?");
            int enter3 = sc.nextInt();
            pl.waterN += enter3;
            pl.money -= enter3 * prod[0].getPrice();
            pl.weight += enter3 * prod[0].getWeight();
            if (enter3 > 0 && pl.weight <= s.topWeight && pl.money >= 0) {
                Shop3();
            } else {
                pl.waterN -= enter3;
                pl.money += enter3 * prod[0].getPrice();
                pl.weight -= enter3 * prod[0].getWeight();
                System.out.println("무게 및 돈이 적절하지 않습니다.");
                Shop3();
            }
        }
        if (enter2 == 2) {
            System.out.println("잔액: " + pl.money + " 무게: " + pl.weight + " / " + s.topWeight + " 소유한 빵: " + pl.foodN + " 빵의 가격: " + prod[1].getPrice());
            System.out.println("빵을 몇 개 구입하시겠습니까?");
            int enter3 = sc.nextInt();
            pl.foodN += enter3;
            pl.money -= enter3 * prod[1].getPrice();
            pl.weight += enter3 * prod[1].getWeight();
            if (enter3 > 0 && pl.weight <= s.topWeight && pl.money >= 0) {
                Shop3();
            } else {
                pl.foodN -= enter3;
                pl.money += enter3 * prod[1].getPrice();
                pl.weight -= enter3 * prod[1].getWeight();
                System.out.println("무게 및 돈이 적절하지 않습니다.");
                Shop3();
            }
        }
        if (enter2 == 3) {
            System.out.println("잔액: " + pl.money + " 무게: " + pl.weight + " / " + s.topWeight + " 소유한 열대과일: " + pl.fruitN + " 열대과일의 가격: " + prod[4].getPrice());
            System.out.println("열대과일을 몇 개 구입하시겠습니까?");
            int enter3 = sc.nextInt();
            pl.fruitN += enter3;
            pl.money -= enter3 * prod[4].getPrice();
            pl.weight += enter3 * prod[4].getWeight();
            if (enter3 > 0 && pl.weight <= s.topWeight && pl.money >= 0) {
                Shop3();
            } else {
                pl.fruitN -= enter3;
                pl.money += enter3 * prod[4].getPrice();
                pl.weight -= enter3 * prod[4].getWeight();
                System.out.println("무게 및 돈이 적절하지 않습니다.");
                Shop3();
            }
        }
    }

    public void buy4() throws IOException, InterruptedException {
        System.out.println("1.물  2.빵  3.물고기");
        int enter2 = sc.nextInt();
        if (enter2 == 1) {
            System.out.println("잔액: " + pl.money + " 무게: " + pl.weight + " / " + s.topWeight + " 소유한 물: " + pl.waterN + " 물의 가격: " + prod[0].getPrice());
            System.out.println("물을 몇 개 구입하시겠습니까?");
            int enter3 = sc.nextInt();
            pl.waterN += enter3;
            pl.money -= enter3 * prod[0].getPrice();
            pl.weight += enter3 * prod[0].getWeight();
            if (enter3 > 0 && pl.weight <= s.topWeight && pl.money >= 0) {
                Shop4();
            } else {
                pl.waterN -= enter3;
                pl.money += enter3 * prod[0].getPrice();
                pl.weight -= enter3 * prod[0].getWeight();
                System.out.println("무게 및 돈이 적절하지 않습니다.");
                Shop4();
            }
        }
        if (enter2 == 2) {
            System.out.println("잔액: " + pl.money + " 무게: " + pl.weight + " / " + s.topWeight + " 소유한 빵: " + pl.foodN + " 빵의 가격: " + prod[1].getPrice());
            System.out.println("빵을 몇 개 구입하시겠습니까?");
            int enter3 = sc.nextInt();
            pl.foodN += enter3;
            pl.money -= enter3 * prod[1].getPrice();
            pl.weight += enter3 * prod[1].getWeight();
            if (enter3 > 0 && pl.weight <= s.topWeight && pl.money >= 0) {
                Shop4();
            } else {
                pl.foodN -= enter3;
                pl.money += enter3 * prod[1].getPrice();
                pl.weight -= enter3 * prod[1].getWeight();
                System.out.println("무게 및 돈이 적절하지 않습니다.");
                Shop4();
            }
        }
        if (enter2 == 3) {
            System.out.println("잔액: " + pl.money + " 무게: " + pl.weight + " / " + s.topWeight + " 소유한 물고기: " + pl.fishN + " 물고기의 가격: " + prod[5].getPrice());
            System.out.println("물고기를 몇 개 구입하시겠습니까?");
            int enter3 = sc.nextInt();
            pl.fishN += enter3;
            pl.money -= enter3 * prod[5].getPrice();
            pl.weight += enter3 * prod[5].getWeight();
            if (enter3 > 0 && pl.weight <= s.topWeight && pl.money >= 0) {
                Shop4();
            } else {
                pl.fishN -= enter3;
                pl.money += enter3 * prod[5].getPrice();
                pl.weight -= enter3 * prod[5].getWeight();
                System.out.println("무게 및 돈이 적절하지 않습니다.");
                Shop4();
            }
        }
    }

    public void sell1() throws IOException, InterruptedException {
        System.out.println("소유목록 // 1.물: " + pl.waterN + " 2.빵: " + pl.foodN + " 3.금: " + pl.goldN + " 4.실크: " + pl.silkN + " 5.열대과일: " + pl.fruitN + " 6.물고기: " + pl.fishN);
        System.out.println("무엇을 파시겠습니까?");
        int enter2 = sc.nextInt();
        if (enter2 == 1) {
            System.out.println("잔액: " + pl.money + " 무게: " + pl.weight + " / " + s.topWeight + " 소유한 물: " + pl.waterN);
            System.out.println("몇 개 파시겠습니까? ");
            int enter3 = sc.nextInt();
            pl.waterN -= enter3;
            pl.money += enter3 * prod[0].getPrice();
            pl.weight -= enter3 * prod[0].getWeight();
            if (enter3 > 0 && pl.waterN >= 0) {
                Shop1();
            } else {
                pl.waterN += enter3;
                pl.money -= enter3 * prod[0].getPrice();
                pl.weight += enter3 * prod[0].getWeight();
                System.out.println("무게 및 돈이 적절하지 않습니다.");
                Shop1();
            }
        } else if (enter2 == 2) {
            System.out.println("잔액: " + pl.money + " 무게: " + pl.weight + " / " + s.topWeight + " 소유한 빵: " + pl.foodN);
            System.out.println("몇 개 파시겠습니까?");
            int enter3 = sc.nextInt();
            pl.foodN -= enter3;
            pl.money += enter3 * prod[1].getPrice();
            pl.weight -= enter3 * prod[1].getWeight();
            if (enter3 > 0 && pl.foodN >= 0) {
                Shop1();
            } else {
                pl.foodN += enter3;
                pl.money -= enter3 * prod[1].getPrice();
                pl.weight += enter3 * prod[1].getWeight();
                System.out.println("무게 및 돈이 적절하지 않습니다.");
                Shop1();
            }
        } else if (enter2 == 3) {
            System.out.println("잔액: " + pl.money + " 무게: " + pl.weight + " / " + s.topWeight + " 소유한 금: " + pl.goldN);
            System.out.println("몇 개 파시겠습니까?");
            int enter3 = sc.nextInt();
            pl.goldN -= enter3;
            pl.money += enter3 * prod[2].getPrice() * 0.7;
            pl.weight -= enter3 * prod[2].getWeight();
            if (enter3 > 0 && pl.goldN >= 0) {
                Shop1();
            } else {
                pl.foodN += enter3;
                pl.money -= enter3 * prod[2].getPrice() * 0.7;
                pl.weight += enter3 * prod[2].getWeight();
                System.out.println("무게 및 돈이 적절하지 않습니다.");
                Shop1();
            }
        } else if (enter2 == 4) {
            System.out.println("잔액: " + pl.money + " 무게: " + pl.weight + " / " + s.topWeight + " 소유한 실크: " + pl.silkN);
            System.out.println("몇 개 파시겠습니까?");
            int enter3 = sc.nextInt();
            pl.silkN -= enter3;
            pl.money += enter3 * prod[3].getPrice() * (1.0 + (getDistance(port[0].px, port[0].py, port[1].px, port[1].py) * 0.08));
            pl.weight -= enter3 * prod[3].getWeight();
            if (enter3 > 0 && pl.silkN >= 0) {
                Shop1();
            } else {
                pl.silkN += enter3;
                pl.money -= enter3 * prod[3].getPrice() * (1.0 + (getDistance(port[0].px, port[0].py, port[1].px, port[1].py) * 0.08));
                pl.weight += enter3 * prod[3].getWeight();
                System.out.println("무게 및 돈이 적절하지 않습니다.");
                Shop1();
            }
        } else if (enter2 == 5) {
            System.out.println("잔액: " + pl.money + " 무게: " + pl.weight + " / " + s.topWeight + " 소유한 열대과일: " + pl.fruitN);
            System.out.println("몇 개 파시겠습니까?");
            int enter3 = sc.nextInt();
            pl.fruitN -= enter3;
            pl.money += enter3 * prod[4].getPrice() * (1.0 + (getDistance(port[0].px, port[0].py, port[2].px, port[2].py) * 0.08));
            pl.weight -= enter3 * prod[4].getWeight();
            if (enter3 > 0 && pl.fruitN >= 0) {
                Shop1();
            } else {
                pl.fruitN += enter3;
                pl.money -= enter3 * prod[4].getPrice() * (1.0 + (getDistance(port[0].px, port[0].py, port[2].px, port[2].py) * 0.08));
                pl.weight += enter3 * prod[4].getWeight();
                System.out.println("무게 및 돈이 적절하지 않습니다.");
                Shop1();
            }
        } else if (enter2 == 6) {
            System.out.println("잔액: " + pl.money + " 무게: " + pl.weight + " / " + s.topWeight + " 소유한 물고기: " + pl.fishN);
            System.out.println("몇 개 파시겠습니까?");
            int enter3 = sc.nextInt();
            pl.fishN -= enter3;
            pl.money += enter3 * prod[5].getPrice() * (1.0 + (getDistance(port[0].px, port[0].py, port[3].px, port[3].py) * 0.08));
            pl.weight -= enter3 * prod[5].getWeight();
            if (enter3 > 0 && pl.fishN >= 0) {
                Shop1();
            } else {
                pl.fishN += enter3;
                pl.money -= enter3 * prod[5].getPrice() * (1.0 + (getDistance(port[0].px, port[0].py, port[3].px, port[3].py) * 0.08));
                pl.weight += enter3 * prod[5].getWeight();
                System.out.println("무게 및 돈이 적절하지 않습니다.");
                Shop1();
            }
        }
    }

    public void sell2() throws IOException, InterruptedException {
        System.out.println("소유목록 // 1.물: " + pl.waterN + " 2.빵: " + pl.foodN + " 3.금: " + pl.goldN + " 4.실크: " + pl.silkN + " 5.열대과일: " + pl.fruitN + " 6.물고기: " + pl.fishN);
        System.out.println("무엇을 파시겠습니까?");
        int enter2 = sc.nextInt();
        if (enter2 == 1) {
            System.out.println("잔액: " + pl.money + " 무게: " + pl.weight + " / " + s.topWeight + " 소유한 물: " + pl.waterN);
            System.out.println("몇 개 파시겠습니까?");
            int enter3 = sc.nextInt();
            pl.waterN -= enter3;
            pl.money += enter3 * prod[0].getPrice();
            pl.weight -= enter3 * prod[0].getWeight();
            if (enter3 > 0 && pl.waterN >= 0) {
                Shop2();
            } else {
                pl.waterN += enter3;
                pl.money -= enter3 * prod[0].getPrice();
                pl.weight += enter3 * prod[0].getWeight();
                System.out.println("무게 및 돈이 적절하지 않습니다.");
                Shop2();
            }
        } else if (enter2 == 2) {
            System.out.println("잔액: " + pl.money + " 무게: " + pl.weight + " / " + s.topWeight + " 소유한 빵: " + pl.foodN);
            System.out.println("몇 개 파시겠습니까?");
            int enter3 = sc.nextInt();
            pl.foodN -= enter3;
            pl.money += enter3 * prod[1].getPrice();
            pl.weight -= enter3 * prod[1].getWeight();
            if (enter3 > 0 && pl.foodN >= 0) {
                Shop2();
            } else {
                pl.foodN += enter3;
                pl.money -= enter3 * prod[1].getPrice();
                pl.weight += enter3 * prod[1].getWeight();
                System.out.println("무게 및 돈이 적절하지 않습니다.");
                Shop2();
            }
        } else if (enter2 == 3) {
            System.out.println("잔액: " + pl.money + " 무게: " + pl.weight + " / " + s.topWeight + " 소유한 금: " + pl.goldN);
            System.out.println("몇 개 파시겠습니까?");
            int enter3 = sc.nextInt();
            pl.goldN -= enter3;
            pl.money += enter3 * prod[2].getPrice() * (1.0 + (getDistance(port[0].px, port[0].py, port[1].px, port[1].py) * 0.08));
            pl.weight -= enter3 * prod[2].getWeight();
            if (enter3 > 0 && pl.goldN >= 0) {
                Shop2();
            } else {
                pl.foodN += enter3;
                pl.money -= enter3 * prod[2].getPrice() * (1.0 + (getDistance(port[0].px, port[0].py, port[1].px, port[1].py) * 0.08));
                pl.weight += enter3 * prod[2].getWeight();
                System.out.println("무게 및 돈이 적절하지 않습니다.");
                Shop2();
            }
        } else if (enter2 == 4) {
            System.out.println("잔액: " + pl.money + " 무게: " + pl.weight + " / " + s.topWeight + " 소유한 실크: " + pl.silkN);
            System.out.println("몇 개 파시겠습니까?");
            int enter3 = sc.nextInt();
            pl.silkN -= enter3;
            pl.money += enter3 * prod[3].getPrice() * 0.7;
            pl.weight -= enter3 * prod[3].getWeight();
            if (enter3 > 0 && pl.silkN >= 0) {
                Shop2();
            } else {
                pl.silkN += enter3;
                pl.money -= enter3 * prod[3].getPrice() * 0.7;
                pl.weight += enter3 * prod[3].getWeight();
                System.out.println("무게 및 돈이 적절하지 않습니다.");
                Shop2();
            }
        } else if (enter2 == 5) {
            System.out.println("잔액: " + pl.money + " 무게: " + pl.weight + " / " + s.topWeight + " 소유한 열대과일: " + pl.fruitN);
            System.out.println("몇 개 파시겠습니까?");
            int enter3 = sc.nextInt();
            pl.fruitN -= enter3;
            pl.money += enter3 * prod[4].getPrice() * (1.0 + (getDistance(port[1].px, port[1].py, port[2].px, port[2].py) * 0.08));
            pl.weight -= enter3 * prod[4].getWeight();
            if (enter3 > 0 && pl.fruitN >= 0) {
                Shop2();
            } else {
                pl.fruitN += enter3;
                pl.money -= enter3 * prod[4].getPrice() * (1.0 + (getDistance(port[1].px, port[1].py, port[2].px, port[2].py) * 0.08));
                pl.weight += enter3 * prod[4].getWeight();
                System.out.println("무게 및 돈이 적절하지 않습니다.");
                Shop2();
            }
        } else if (enter2 == 6) {
            System.out.println("잔액: " + pl.money + " 무게: " + pl.weight + " / " + s.topWeight + " 소유한 물고기: " + pl.fishN);
            System.out.println("몇 개 파시겠습니까?");
            int enter3 = sc.nextInt();
            pl.fishN -= enter3;
            pl.money += enter3 * prod[5].getPrice() * (1.0 + (getDistance(port[1].px, port[1].py, port[3].px, port[3].py) * 0.08));
            pl.weight -= enter3 * prod[5].getWeight();
            if (enter3 > 0 && pl.fishN >= 0) {
                Shop2();
            } else {
                pl.fishN += enter3;
                pl.money -= enter3 * prod[5].getPrice() * (1.0 + (getDistance(port[1].px, port[1].py, port[3].px, port[3].py) * 0.08));
                pl.weight += enter3 * prod[5].getWeight();
                System.out.println("무게 및 돈이 적절하지 않습니다.");
                Shop2();
            }
        }
    }

    public void sell3() throws IOException, InterruptedException {
        System.out.println("소유목록 // 1.물: " + pl.waterN + " 2.빵: " + pl.foodN + " 3.금: " + pl.goldN + " 4.실크: " + pl.silkN + " 5.열대과일: " + pl.fruitN + " 6.물고기: " + pl.fishN);
        System.out.println("무엇을 파시겠습니까?");
        int enter2 = sc.nextInt();
        if (enter2 == 1) {
            System.out.println("잔액: " + pl.money + " 무게: " + pl.weight + " / " + s.topWeight + " 소유한 물: " + pl.waterN);
            System.out.println("몇 개 파시겠습니까?");
            int enter3 = sc.nextInt();
            pl.waterN -= enter3;
            pl.money += enter3 * prod[0].getPrice();
            pl.weight -= enter3 * prod[0].getWeight();
            if (enter3 > 0 && pl.waterN >= 0) {
                Shop3();
            } else {
                pl.waterN += enter3;
                pl.money -= enter3 * prod[0].getPrice();
                pl.weight += enter3 * prod[0].getWeight();
                System.out.println("무게 및 돈이 적절하지 않습니다.");
                Shop3();
            }
        } else if (enter2 == 2) {
            System.out.println("잔액: " + pl.money + " 무게: " + pl.weight + " / " + s.topWeight + " 소유한 빵: " + pl.foodN);
            System.out.println("몇 개 파시겠습니까?");
            int enter3 = sc.nextInt();
            pl.foodN -= enter3;
            pl.money += enter3 * prod[1].getPrice();
            pl.weight -= enter3 * prod[1].getWeight();
            if (enter3 > 0 && pl.foodN >= 0) {
                Shop3();
            } else {
                pl.foodN += enter3;
                pl.money -= enter3 * prod[1].getPrice();
                pl.weight += enter3 * prod[1].getWeight();
                System.out.println("무게 및 돈이 적절하지 않습니다.");
                Shop3();
            }
        } else if (enter2 == 3) {
            System.out.println("잔액: " + pl.money + " 무게: " + pl.weight + " / " + s.topWeight + " 소유한 금: " + pl.goldN);
            System.out.println("몇 개 파시겠습니까?");
            int enter3 = sc.nextInt();
            pl.goldN -= enter3;
            pl.money += enter3 * prod[2].getPrice() * (1.0 + (getDistance(port[0].px, port[0].py, port[2].px, port[2].py) * 0.08));
            pl.weight -= enter3 * prod[2].getWeight();
            if (enter3 > 0 && pl.goldN >= 0) {
                Shop3();
            } else {
                pl.foodN += enter3;
                pl.money -= enter3 * prod[2].getPrice() * (1.0 + (getDistance(port[0].px, port[0].py, port[2].px, port[2].py) * 0.08));
                pl.weight += enter3 * prod[2].getWeight();
                System.out.println("무게 및 돈이 적절하지 않습니다.");
                Shop3();
            }
        } else if (enter2 == 4) {
            System.out.println("잔액: " + pl.money + " 무게: " + pl.weight + " / " + s.topWeight + " 소유한 실크: " + pl.silkN);
            System.out.println("몇 개 파시겠습니까?");
            int enter3 = sc.nextInt();
            pl.silkN -= enter3;
            pl.money += enter3 * prod[3].getPrice() * (1.0 + (getDistance(port[1].px, port[1].py, port[2].px, port[2].py) * 0.08));
            pl.weight -= enter3 * prod[3].getWeight();
            if (enter3 > 0 && pl.silkN >= 0) {
                Shop3();
            } else {
                pl.silkN += enter3;
                pl.money -= enter3 * prod[3].getPrice() * (1.0 + (getDistance(port[1].px, port[1].py, port[2].px, port[2].py) * 0.08));
                pl.weight += enter3 * prod[3].getWeight();
                System.out.println("무게 및 돈이 적절하지 않습니다.");
                Shop3();
            }
        } else if (enter2 == 5) {
            System.out.println("잔액: " + pl.money + " 무게: " + pl.weight + " / " + s.topWeight + " 소유한 열대과일: " + pl.fruitN);
            System.out.println("몇 개 파시겠습니까?");
            int enter3 = sc.nextInt();
            pl.fruitN -= enter3;
            pl.money += enter3 * prod[4].getPrice() * 0.7;
            pl.weight -= enter3 * prod[4].getWeight();
            if (enter3 > 0 && pl.fruitN >= 0) {
                Shop3();
            } else {
                pl.fruitN += enter3;
                pl.money -= enter3 * prod[4].getPrice() * 0.7;
                pl.weight += enter3 * prod[4].getWeight();
                System.out.println("무게 및 돈이 적절하지 않습니다.");
                Shop3();
            }
        } else if (enter2 == 6) {
            System.out.println("잔액: " + pl.money + " 무게: " + pl.weight + " / " + s.topWeight + " 소유한 물고기: " + pl.fishN);
            System.out.println("몇 개 파시겠습니까?");
            int enter3 = sc.nextInt();
            pl.fishN -= enter3;
            pl.money += enter3 * prod[5].getPrice() * (1.0 + (getDistance(port[2].px, port[2].py, port[3].px, port[3].py) * 0.08));
            pl.weight -= enter3 * prod[5].getWeight();
            if (enter3 > 0 && pl.fishN >= 0) {
                Shop3();
            } else {
                pl.fishN += enter3;
                pl.money -= enter3 * prod[5].getPrice() * (1.0 + (getDistance(port[2].px, port[2].py, port[3].px, port[3].py) * 0.08));
                pl.weight += enter3 * prod[5].getWeight();
                System.out.println("무게 및 돈이 적절하지 않습니다.");
                Shop3();
            }
        }
    }

    public void sell4() throws IOException, InterruptedException {
        System.out.println("소유목록 // 1.물: " + pl.waterN + " 2.빵: " + pl.foodN + " 3.금: " + pl.goldN + " 4.실크: " + pl.silkN + " 5.열대과일: " + pl.fruitN + " 6.물고기: " + pl.fishN + " 7. 선원: " + pl.crews);
        System.out.println("무엇을 파시겠습니까?");
        int enter2 = sc.nextInt();
        if (enter2 == 1) {
            System.out.println("잔액: " + pl.money + " 무게: " + pl.weight + " / " + s.topWeight + " 소유한 물: " + pl.waterN);
            System.out.println("몇 개 파시겠습니까?");
            int enter3 = sc.nextInt();
            pl.waterN -= enter3;
            pl.money += enter3 * prod[0].getPrice();
            pl.weight -= enter3 * prod[0].getWeight();
            if (enter3 > 0 && pl.waterN >= 0) {
                Shop4();
            } else {
                pl.waterN += enter3;
                pl.money -= enter3 * prod[0].getPrice();
                pl.weight += enter3 * prod[0].getWeight();
                System.out.println("무게 및 돈이 적절하지 않습니다.");
                Shop4();
            }
        } else if (enter2 == 2) {
            System.out.println("잔액: " + pl.money + " 무게: " + pl.weight + " / " + s.topWeight + " 소유한 빵: " + pl.foodN);
            System.out.println("몇 개 파시겠습니까?");
            int enter3 = sc.nextInt();
            pl.foodN -= enter3;
            pl.money += enter3 * prod[1].getPrice();
            pl.weight -= enter3 * prod[1].getWeight();
            if (enter3 > 0 && pl.foodN >= 0) {
                Shop4();
            } else {
                pl.foodN += enter3;
                pl.money -= enter3 * prod[1].getPrice();
                pl.weight += enter3 * prod[1].getWeight();
                System.out.println("무게 및 돈이 적절하지 않습니다.");
                Shop4();
            }
        } else if (enter2 == 3) {
            System.out.println("잔액: " + pl.money + " 무게: " + pl.weight + " / " + s.topWeight + " 소유한 금: " + pl.goldN);
            System.out.println("몇 개 파시겠습니까?");
            int enter3 = sc.nextInt();
            pl.goldN -= enter3;
            pl.money += enter3 * prod[2].getPrice() * (1.0 + (getDistance(port[0].px, port[0].py, port[3].px, port[3].py) * 0.08));
            pl.weight -= enter3 * prod[2].getWeight();
            if (enter3 > 0 && pl.goldN >= 0) {
                Shop4();
            } else {
                pl.foodN += enter3;
                pl.money -= enter3 * prod[2].getPrice() * (1.0 + (getDistance(port[0].px, port[0].py, port[3].px, port[3].py) * 0.08));
                pl.weight += enter3 * prod[2].getWeight();
                System.out.println("무게 및 돈이 적절하지 않습니다.");
                Shop4();
            }
        } else if (enter2 == 4) {
            System.out.println("잔액: " + pl.money + " 무게: " + pl.weight + " / " + s.topWeight + " 소유한 실크: " + pl.silkN);
            System.out.println("몇 개 파시겠습니까?");
            int enter3 = sc.nextInt();
            pl.silkN -= enter3;
            pl.money += enter3 * prod[3].getPrice() * (1.0 + (getDistance(port[1].px, port[1].py, port[3].px, port[3].py) * 0.08));
            pl.weight -= enter3 * prod[0].getWeight();
            if (enter3 > 0 && pl.silkN >= 0) {
                Shop4();
            } else {
                pl.silkN += enter3;
                pl.money -= enter3 * prod[3].getPrice() * (1.0 + (getDistance(port[1].px, port[1].py, port[3].px, port[3].py) * 0.08));
                pl.weight += enter3 * prod[0].getWeight();
                System.out.println("무게 및 돈이 적절하지 않습니다.");
                Shop4();
            }
        } else if (enter2 == 5) {
            System.out.println("잔액: " + pl.money + " 무게: " + pl.weight + " / " + s.topWeight + " 소유한 열대과일: " + pl.fruitN);
            System.out.println("몇 개 파시겠습니까?");
            int enter3 = sc.nextInt();
            pl.fruitN -= enter3;
            pl.money += enter3 * prod[4].getPrice() * (1.0 + (getDistance(port[2].px, port[2].py, port[3].px, port[3].py) * 0.08));
            pl.weight -= enter3 * prod[4].getWeight();
            if (enter3 > 0 && pl.fruitN >= 0) {
                Shop4();
            } else {
                pl.fruitN += enter3;
                pl.money -= enter3 * prod[4].getPrice() * (1.0 + (getDistance(port[2].px, port[2].py, port[3].px, port[3].py) * 0.08));
                pl.weight += enter3 * prod[4].getWeight();
                System.out.println("무게 및 돈이 적절하지 않습니다.");
                Shop4();
            }
        } else if (enter2 == 6) {
            System.out.println("잔액: " + pl.money + " 무게: " + pl.weight + " / " + s.topWeight + " 소유한 물고기: " + pl.fishN);
            System.out.println("몇 개 파시겠습니까?");
            int enter3 = sc.nextInt();
            pl.fishN -= enter3;
            pl.money += enter3 * prod[5].getPrice() * 0.7;
            pl.weight -= enter3 * prod[5].getWeight();
            if (enter3 > 0 && pl.fishN >= 0) {
                Shop4();
            } else {
                pl.fishN += enter3;
                pl.money -= enter3 * prod[5].getPrice() * 0.7;
                pl.weight += enter3 * prod[5].getWeight();
                System.out.println("무게 및 돈이 적절하지 않습니다.");
                Shop4();
            }
        } else if (enter2 == 7) {
            System.out.println("잔액: " + pl.money + " 무게: " + pl.weight + " / " + s.topWeight + " 소유한 선원: " + pl.crews);
            System.out.println("몇 명 파시겠습니까? (살 때의 90%의 가격)");
            int enter3 = sc.nextInt();
            pl.crews -= enter3;
            pl.money += enter3 * prod[6].getPrice() * 0.9;
            pl.weight -= enter3 * prod[6].getWeight();
            if (enter3 > 0 && pl.fishN >= 0) {
                Shop4();
            } else {
                pl.fishN += enter3;
                pl.money -= enter3 * prod[6].getPrice() * 0.9;
                pl.weight += enter3 * prod[6].getWeight();
                System.out.println("무게 및 돈이 적절하지 않습니다.");
                Shop4();
            }
        }
    }

    public void hire1() throws IOException, InterruptedException {
        System.out.println("선원을 몇 명 고용하시겠습니까?  현재 선원수: " + pl.crews + "  선원 가격: " + prod[6].getPrice() + "  선원 무게: " + prod[6].getWeight() + "  무게: " + (pl.weight) + " / " + s.topWeight);
        int enter2 = sc.nextInt();
        pl.crews += enter2;
        pl.money -= enter2 * prod[6].getPrice();
        pl.power += 100 * enter2;
        pl.weight += prod[6].getWeight() * enter2;
        if (enter2 > 0 && pl.weight <= s.topWeight && pl.money >= 0) {
            Shop1();
        } else {
            pl.crews -= enter2;
            pl.money += enter2 * prod[6].getPrice();
            pl.power -= 100 * enter2;
            pl.weight -= prod[6].getWeight() * enter2;
            System.out.println("무게 및 돈이 적절하지 않습니다.");
            Shop1();
        }
    }

    public void hire2() throws IOException, InterruptedException {
        System.out.println("선원을 몇 명 고용하시겠습니까?  현재 선원수: " + pl.crews + "  선원 가격: " + prod[6].getPrice() + "  선원 무게: " + prod[6].getWeight() + "  무게: " + (pl.weight) + " / " + s.topWeight);
        int enter2 = sc.nextInt();
        pl.crews += enter2;
        pl.money -= enter2 * prod[6].getPrice();
        pl.power += 100 * enter2;
        pl.weight += prod[6].getWeight() * enter2;
        if (enter2 > 0 && pl.weight <= s.topWeight && pl.money >= 0) {
            Shop2();
        } else {
            pl.crews -= enter2;
            pl.money += enter2 * prod[6].getPrice();
            pl.power -= 100 * enter2;
            pl.weight -= prod[6].getWeight() * enter2;
            System.out.println("무게 및 돈이 적절하지 않습니다.");
            Shop2();
        }
    }

    public void hire3() throws IOException, InterruptedException {
        System.out.println("선원을 몇 명 고용하시겠습니까?  현재 선원수: " + pl.crews + "  선원 가격: " + prod[6].getPrice() + "  선원 무게: " + prod[6].getWeight() + "  무게: " + (pl.weight) + " / " + s.topWeight);
        int enter2 = sc.nextInt();
        pl.crews += enter2;
        pl.money -= enter2 * prod[6].getPrice();
        pl.power += 100 * enter2;
        pl.weight += prod[6].getWeight() * enter2;
        if (enter2 > 0 && pl.weight <= s.topWeight && pl.money >= 0) {
            Shop3();
        } else {
            pl.crews -= enter2;
            pl.money += enter2 * prod[6].getPrice();
            pl.power -= 100 * enter2;
            pl.weight -= prod[6].getWeight() * enter2;
            System.out.println("무게 및 돈이 적절하지 않습니다.");
            Shop3();
        }
    }

    public void hire4() throws IOException, InterruptedException {
        System.out.println("선원을 몇 명 고용하시겠습니까?  현재 선원수: " + pl.crews + "  선원 가격: " + prod[6].getPrice() + "  선원 무게: " + prod[6].getWeight() + "  무게: " + (pl.weight) + " / " + s.topWeight);
        int enter2 = sc.nextInt();
        pl.crews += enter2;
        pl.money -= enter2 * prod[6].getPrice();
        pl.power += 100 * enter2;
        pl.weight += prod[6].getWeight() * enter2;
        if (enter2 > 0 && pl.weight <= s.topWeight && pl.money >= 0) {
            Shop4();
        } else {
            pl.crews -= enter2;
            pl.money += enter2 * prod[6].getPrice();
            pl.power -= 100 * enter2;
            pl.weight -= prod[6].getWeight() * enter2;
            System.out.println("무게 및 돈이 적절하지 않습니다.");
            Shop4();
        }
    }

    public void sayHi1() throws IOException, InterruptedException { // 애정도 증감의 정도 조정 가능
        if (port[0].love <= 30) {
            System.out.println("항구를 지나다니다 앉아있는 아리를 발견했다. 어떻게 하지?");
            System.out.println("1. 반갑게 인사한다.");
            System.out.println("2. 뒤에서 놀래킨다.");
            System.out.println("3. 옆자리에 앉는다.");
            System.out.println("4. 무시한다.");
            int ans = sc.nextInt();
            switch (ans) {
                case 1:
                    System.out.println("안녕하세요 !! 날이 참 좋죠? ");
                    port[0].love += 15;
                    break;
                case 2:
                    System.out.println("어머!! 깜짝 놀랐잖아요! 전 놀라는거 싫어해요");
                    port[0].love -= 5;
                    break;
                case 3:
                    System.out.println("어? 언제 오셨어요? ㅎㅎ");
                    port[0].love += 30;
                    break;
                case 4:
                    System.out.println("(나를 못봤나...? 하지만 멋있어..)");
                    port[0].love += 10;
                    break;
            }
            Shop1();
        } else if (port[0].love > 30 && port[0].love <= 70) {
            System.out.println("아리와 식료품 상점에 들어왔다. 뭘 사줘야 되지?");
            System.out.println("1. 아이스크림을 사준다.");
            System.out.println("2. 파인애플을 사준다.");
            System.out.println("3. 빵을 사준다.");
            System.out.println("4. 초콜릿을 사준다."); // 가격 정해서 차감  
            int ans = sc.nextInt();
            switch (ans) {
                case 1:
                    System.out.println("저 아이스크림 좋아하는거 어떻게 아셨지? 잘 먹을게요.");
                    port[0].love += 30;
                    // pl.money -= 가격;
                    break;
                case 2:
                    System.out.println("음 이거 맛있네요. 감사히 먹을게요~");
                    port[0].love += 20;
                    // pl.money -= 가격;
                    break;
                case 3:
                    System.out.println("제가 점심에 빵을 먹고 와서 빵은 별로 먹고 싶지 않아요...");
                    port[0].love -= 5;
                    // pl.money -= 가격;
                    break;
                case 4:
                    System.out.println("저 다이어트 중이라고 저번에 말하지 않았나요?");
                    port[0].love -= 10;
                    // pl.money -= 가격;
                    break;
            }
            Shop1();
        } else if (port[0].love > 70 && port[0].love < 100) {
            System.out.println("아리가 자신의 고민을 털어 놓고 있다. 어떤 말을 해줘야 할까?");
            System.out.println("1. 힘내요, 다 잘 될거에요.");
            System.out.println("2. 저런, 그런 고민이 있었는지 몰랐어요...");
            System.out.println("3. 아 배고파.");
            System.out.println("4. (말 없이 들어만준다.)");
            int ans = sc.nextInt();
            switch (ans) {
                case 1:
                    System.out.println(pl.name + " 씨가 위로를 해주니 힘이 나네요. 고마워요.");
                    port[0].love += 20;
                    break;
                case 2:
                    System.out.println("저번에도 말했던것 같은데요...");
                    port[0].love -= 10;
                    break;
                case 3:
                    System.out.println("제 얘기 듣고 있는것 맞나요?");
                    port[0].love -= 15;
                    break;
                case 4:
                    System.out.println("고마워요. " + pl.name + "씨에게 털어놓은 덕분에 마음이 한결 편해졌어요.");
                    port[0].love += 40;
                    break;
            }
            Shop1();
        } else if (port[0].love >= 100 && port[0].love < 150) {
            System.out.println("아리 : 제 작은 정성입니다. 받아주세요 ^^");
            System.out.println("'수용의 조각'을 받았습니다.");
            hidden.add("수용의 조각");
            port[0].love += 100;
            Shop1();
        } else {
            System.out.println(" 잘 지내고 계시죠? 저는 잘 지내고 있답니다.");
            Shop1();
        }
    }

    public void sayHi2() throws IOException, InterruptedException {
        if (port[1].love <= 30) {
            System.out.println("항구에서 리타를 발견했다. 뭐라고 말을 걸지?");
            System.out.println("1. 안녕하세요 저는 항해사입니다. 잠깐 시간 괜찮으세요?");
            System.out.println("2. 이름이 뭐예요?.");
            System.out.println("3. 얼굴이 제 스타일 인데 전화 번호 뭐예요?");
            System.out.println("4. 여기는 위험해요! 옆으로 비키세요.");
            int ans = sc.nextInt();
            switch (ans) {
                case 1:
                    System.out.println("네 괜찮아요^^ (나한테 호감이 있나보네) ");
                    port[1].love += 20;
                    break;
                case 2:
                    System.out.println("왜 물어봐요? (도를 믿으십니까야 뭐야;;)");
                    port[1].love -= 5;
                    break;
                case 3:
                    System.out.println("왜 알려줘야 되는데요? (자신감 쩐다;;)");
                    port[1].love -= 10;
                    break;
                case 4:
                    System.out.println("네, 감사합니다! (앗 박력..)");
                    port[1].love += 25;
                    break;
            }
            Shop2();
        } else if (port[1].love > 30 && port[1].love <= 70) {
            System.out.println("리타에게 호감을 표현하고 싶다. 어떻게 접근하지?");
            System.out.println("1. 남자답게 자신감 있는 모습으로 말을 붙인다.");
            System.out.println("2. 나의 진심을 표현하되, 최대한 조심스럽게 말을 붙인다.");
            System.out.println("3. 말을 걸기는 부끄러우니까 쪽지를 보낸다.");
            System.out.println("4. 다음을 기약한다.");
            int ans = sc.nextInt();
            switch (ans) {
                case 1:
                    System.out.println("자신감 넘치네.. 난 저런 스타일 별로...");
                    port[1].love -= 10;
                    break;
                case 2:
                    System.out.println("이 사람에겐 진심이 느껴져!");
                    port[1].love += 40;
                    break;
                case 3:
                    System.out.println("이 사람 누구지? 그래도 날 좋아한다니 기분은 좋네");
                    port[1].love += 25;
                    break;
                case 4:
                    System.out.println("...");
                    port[1].love -= 10;
                    break;
            }
            Shop2();
        } else if (port[1].love > 70 && port[1].love < 100) {
            System.out.println("리타와 첫 데이트를 준비하고 있다. 밥먹으러 어디가지?");
            System.out.println("1. 첫만남엔 술이지! 소주를 먹으러 간다.");
            System.out.println("2. 먹고 싶은거 있어요? 전 다 좋은데! ");
            System.out.println("3. 저는 피자 좋아해요! 피자 먹을래요?");
            System.out.println("4. 리타씨가뭘 좋아할 지 몰라서 A레스토랑이랑 B레스토랑 알아봤어요!");
            int ans = sc.nextInt();
            switch (ans) {
                case 1:
                    System.out.println("저 술 못하는데..");
                    port[1].love -= 5;
                    break;
                case 2:
                    System.out.println("음.. 전 순대국이 좋아요^^");
                    port[1].love += 25;
                    break;
                case 3:
                    System.out.println("아.. 네 좋아요^^ (나한테도 물어봐 주지..)");
                    port[1].love -= 10;
                    break;
                case 4:
                    System.out.println("전 A 레스토랑이 좋아요^^");
                    port[1].love += 20;
                    break;
            }
            Shop2();
        } else if (port[1].love >= 100 && port[1].love < 150) {
            System.out.println("리타 : 당신의 믿음에 대한 보답입니다.");
            System.out.println("'믿음의 조각'을 받았습니다.");
            hidden.add("믿음의 조각");
            port[1].love += 100;
            Shop2();
        } else {
            System.out.println(" 날이 덥네요! 어휴~.");
            Shop2();
        }
    }

    public void sayHi3() throws IOException, InterruptedException {
        if (port[2].love <= 30) {
            System.out.println("이자벨과의 어색한 기류. 어떻게 하지?");
            System.out.println("1. 인사를 한다.");
            System.out.println("2. 추파를 던진다.");
            System.out.println("3. 칭찬을 한다.");
            int ans = sc.nextInt();
            switch (ans) {
                case 1:
                    System.out.println("안녕하세요 " + pl.name + "씨,오늘 날씨 참 좋네요.");
                    port[2].love += 20;
                    break;
                case 2:
                    System.out.println("어머! 이런 저질!!!");
                    port[2].love -= 5;
                    break;
                case 3:
                    System.out.println("친절한 분이시군요. 고마워요");
                    port[2].love += 15;
                    break;
            }
            Shop3();
        } else if (port[2].love > 30 && port[2].love <= 70) {
            System.out.println("친해진 느낌이 든다. 대쉬해볼까..!");
            System.out.println("1. 이름을 알려주시겠어요 레이디?");
            System.out.println("2. 당신의 눈빛은.. 끝을 알 수 없는 심해와 같아요..");
            System.out.println("3. 먼 이국의 나라에서 구한 것인데 아가씨에게 잘 어울릴 것 같군요.(선물을 준다. 50원 차감)");
            System.out.println("4. 이렇게 종종 얘기를 나눴으면 좋겠습니다.. 레이디");
            int ans = sc.nextInt();
            switch (ans) {
                case 1:
                    System.out.println("이자벨이라고 해요.");
                    port[2].love += 20;
                    break;
                case 2:
                    System.out.println("어맛!");
                    port[2].love -= 5;
                    break;
                case 3:
                    System.out.println("이런 것까지.. 감사합니다.");
                    port[2].love += 15;
                    pl.money -= 50;
                    break;
                case 4:
                    System.out.println("(이자벨이 수줍어한다.)");
                    port[2].love += 40;
                    break;
            }
            Shop3();
        } else if (port[2].love > 70 && port[2].love < 100) {
            System.out.println("이자벨 : 어젯밤엔, 즐거웠어요..");
            System.out.println("1. 이자벨, 우리 같이 물빵을 뜯으러 갑시다.");
            System.out.println("2. 선원들끼리 주점에서 파티하는데 이자벨도 같이 와서 놀아요.");
            System.out.println("3. 오늘 저녁 항구에서 하는 등불 축제에 같이 갈래요?");
            int ans = sc.nextInt();
            switch (ans) {
                case 1:
                    System.out.println("물빵(///)... 좋아요.");
                    port[2].love += 20;
                    break;
                case 2:
                    System.out.println("좋아요");
                    port[2].love += 10;
                    break;
                case 3:
                    System.out.println("등불 축제 너무 가고 싶었는데 좋아요!");
                    port[2].love += 20;
                    break;
            }
            Shop3();
        } else if (port[2].love >= 100 && port[2].love < 150) {
            System.out.println("이자벨 : 선물이에요. 사랑해요...");
            System.out.println("'사랑의 조각'을 받았습니다.");
            hidden.add("사랑의 조각");
            port[2].love += 100;
            Shop3();
        } else {
            System.out.println("어젯밤엔.. 즐거웠어요. ><");
            Shop3();
        }
    }

    public void sayHi4() throws IOException, InterruptedException {
        if (port[3].love <= 30) {
            System.out.println("항구에서 곽선희가 혼자 춤을 추고 있다.");
            System.out.println("1. 인사를 한다.");
            System.out.println("2. 추파를 던진다.");
            System.out.println("3. 칭찬을 한다.");
            int ans = sc.nextInt();
            switch (ans) {
                case 1:
                    System.out.println("안녕 뉴페이스네. 내 춤 죽이지? ");
                    port[3].love += 30;
                    break;
                case 2:
                    System.out.println("아무리 내가 섹시하데도 그런거 모야메룽다!!!");
                    port[3].love -= 10;
                    break;
                case 3:
                    System.out.println("어머머 같이 춤 추실래요?");
                    port[3].love += 20;
                    break;
            }
            Shop4();
        } else if (port[3].love > 30 && port[3].love <= 70) {
            System.out.println("나는 곽선희가 알고 싶다.");
            System.out.println("1. 이름을 알려주시겠어요?");
            System.out.println("2. 여기 사는 분이신가요?");
            System.out.println("3. 먼 이국의 나라에서 구한 것인데 아가씨에게 잘 어울릴 것 같군요.(선물을 준다.)");
            System.out.println("4. 혹시 시간 있으면... 차라도 한잔?");
            int ans = sc.nextInt();
            switch (ans) {
                case 1:
                    System.out.println("아직도 내 이름을 모른다니.. 내가 이 구역의 마성 퀸 곽선희야!! 뼛속 깊숙히 새겨 놓으라구!!!");
                    port[3].love += 20;
                    break;
                case 2:
                    System.out.println("왜에~~?? 알아서 뭐하려구??흫흐");
                    port[3].love += 25;
                    break;
                case 3:
                    System.out.println("필요 없어!");
                    port[3].love -= 10;
                    break;
                case 4:
                    System.out.println("역시 내 마성의 매력에 또 하나의 희생자가.. 하....");
                    port[3].love += 40;
                    break;
            }
            Shop4();
        } else if (port[3].love > 70 && port[3].love < 100) {
            System.out.println("곽선희! 이제 넌 내꺼야");
            System.out.println("1. 사랑해요 !!");
            System.out.println("2. 우리 결혼해요.");
            System.out.println("3. 너 내꺼하자.");
            System.out.println("4. 이 안에 너 있다.");
            int ans = sc.nextInt();
            switch (ans) {
                case 1:
                    System.out.println("저도 사랑해요 !!");
                    port[3].love += 30;
                    break;
                case 2:
                    System.out.println("전 독신주의자에요...");
                    port[3].love -= 10;
                    break;
                case 3:
                    System.out.println("뭐래...");
                    port[3].love -= 10;
                    break;
                case 4:
                    System.out.println("어머~ 너무 로맨틱해요 >.<");
                    port[3].love += 40;
                    break;
            }
            Shop4();
        } else if (port[3].love >= 100 && port[3].love < 150) {
            System.out.println("곽선희 : 어멍어어머머머머멍 멋져요");
            System.out.println("'희망의 조각'을 받았습니다.");
            hidden.add("희망의 조각");
            port[3].love += 100;
            Shop4();
        } else {
            System.out.println(" 멋진 남자. 또와요 ㅎㅎㅎ");
            Shop4();
        }
    }

    public void goOut1() throws IOException, InterruptedException {
        System.out.println("안녕하가십시오.");
        xx = 9;
        yy = 30;
        Thread.sleep(1000);
        m.printMap(xx, yy);
        moveShip();
    }

    public void goOut2() throws IOException, InterruptedException {
        System.out.println("안녕하가십시오.");
        xx = 9;
        yy = 69;
        Thread.sleep(1000);
        m.printMap(xx, yy);
        moveShip();
    }

    public void goOut3() throws IOException, InterruptedException {
        System.out.println("안녕하가십시오.");
        xx = 28;
        yy = 62;
        Thread.sleep(1000);
        m.printMap(xx, yy);
        moveShip();
    }

    public void goOut4() throws IOException, InterruptedException {
        System.out.println("안녕하가십시오.");
        xx = 21;
        yy = 48;
        Thread.sleep(1000);
        m.printMap(xx, yy);
        moveShip();
    }

    public double getDistance(int x1, int y1, int x2, int y2) {
        return Math.sqrt(Math.pow(Math.abs(x1 - x2), 2) + Math.pow(Math.abs(y1 - y2), 2));
    }

    public void gameOver() {
        System.out.println("배고프고...목말라..... 끄윽..!");
        System.out.println("Game Over");
        System.exit(1);
    }
    
    public void music() throws IOException {
        File clap = new File("music1.wav");
        InputStream in = new FileInputStream(clap);
        AudioStream audioStream = new AudioStream(in);
        AudioPlayer.player.start(audioStream);
    }
}
