/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kkie.prog.comp;

import java.io.IOException;
import java.util.Scanner;

public class Map {
    
    Player pl = new Player();
    
    public char[][] region = new char[42][100];
    
    public void printMap(int xx, int yy){
        for (int i=0; i<region.length; i++) {
            for (int j = 0; j < region[i].length; j++) {
                region[i][j] = '▒';
                for (int a = 0; a < 100; a++) {
                    region[0][a] = '　';
                }
                for (int a = 37; a < 46; a++) {
                    region[3][a] = '　';
                }
                for (int a = 52; a < 69; a++) {
                    region[3][a] = '　';
                }
                for (int a = 34; a < 48; a++) {
                    region[4][a] = '　';
                }
                for (int a = 51; a < 72; a++) {
                    region[4][a] = '　';
                }
                for (int a = 31; a < 48; a++) {
                    region[5][a] = '　';
                }
                for (int a = 49; a < 76; a++) {
                    region[5][a] = '　';
                }
                for (int a = 86; a < 92; a++) {
                    region[5][a] = '‰';
                }
                for (int a = 86; a < 87; a++) {
                    region[6][a] = '‰';
                }
                for (int a = 91; a < 92; a++) {
                    region[6][a] = '‰';
                }
                for (int a = 25; a < 73; a++) {
                    region[6][a] = '　';
                }
                for (int a = 87; a < 88; a++) {
                    region[6][a] = '누';
                }
                for (int a = 88; a < 89; a++) {
                    region[6][a] = '에';
                }
                for (int a = 89; a < 90; a++) {
                    region[6][a] = '고';
                }
                for (int a = 90; a < 91; a++) {
                    region[6][a] = '치';
                }
                for (int a = 88; a < 89; a++) {
                    region[7][a] = '농';
                }
                for (int a = 89; a < 90; a++) {
                    region[7][a] = '장';
                }
                for (int a = 86; a < 88; a++) {
                    region[7][a] = '‰';
                }
                for (int a = 90; a < 92; a++) {
                    region[7][a] = '‰';
                }
                for (int a = 26; a < 69; a++) {
                    region[7][a] = '　';
                }
                for (int a = 86; a < 92; a++) {
                    region[8][a] = '‰';
                }
                for (int a = 28; a < 71; a++) {
                    region[8][a] = '　';
                }
                for (int a = 7; a < 11; a++) {
                    region[8][a] = '△';
                }
                for (int a = 8; a < 9; a++) {
                    region[9][a] = '광';
                }
                for (int a = 9; a < 10; a++) {
                    region[9][a] = '산';
                }
                for (int a = 7; a < 8; a++) {
                    region[9][a] = '△';
                }
                for (int a = 10; a < 11; a++) {
                    region[9][a] = '△';
                }
                for (int a = 26; a < 74; a++) {
                    region[9][a] = '　';
                }
                for (int a = 26; a < 29; a++) {
                    region[9][a] = '■';
                }
                for (int a = 71; a < 74; a++) {
                    region[9][a] = '★';
                }
                for (int a = 26; a < 74; a++) {
                    region[10][a] = '　';
                }
                for (int a = 7; a < 11; a++) {
                    region[10][a] = '△';
                }
                for (int a = 26; a < 29; a++) {
                    region[10][a] = '■';
                }
                for (int a = 71; a < 74; a++) {
                    region[10][a] = '★';
                }
                for (int a = 26; a < 74; a++) {
                    region[11][a] = '　';
                }
                for (int a = 26; a < 29; a++) {
                    region[11][a] = '■';
                }
                for (int a = 71; a < 74; a++) {
                    region[11][a] = '★';
                }
                for (int a = 23; a < 78; a++) {
                    region[12][a] = '　';
                }
                for (int a = 20; a < 84; a++) {
                    region[13][a] = '　';
                }
                for (int a = 22; a < 87; a++) {
                    region[14][a] = '　';
                }
                for (int a = 27; a < 92; a++) {
                    region[15][a] = '　';
                }
                for (int a = 25; a < 96; a++) {
                    region[16][a] = '　';
                }
                for (int a = 22; a < 60; a++) {
                    region[17][a] = '　';
                }
                for (int a = 62; a < 96; a++) {
                    region[17][a] = '　';
                }
                for (int a = 23; a < 59; a++) {
                    region[18][a] = '　';
                }
                for (int a = 63; a < 96; a++) {
                    region[18][a] = '　';
                }
                for (int a = 21; a < 55; a++) {
                    region[19][a] = '　';
                }
                for (int a = 63; a < 96; a++) {
                    region[19][a] = '　';
                }
                for (int a = 19; a < 52; a++) {
                    region[20][a] = '　';
                }
                for (int a = 61; a < 96; a++) {
                    region[20][a] = '　';
                }
                for (int a = 50; a < 53; a++) {
                    region[20][a] = '♥';
                }
                for (int a = 55; a < 59; a++) {
                    region[20][a] = '◇';
                }
                for (int a = 18; a < 52; a++) {
                    region[21][a] = '　';
                }
                for (int a = 65; a < 96; a++) {
                    region[21][a] = '　';
                }
                for (int a = 50; a < 53; a++) {
                    region[21][a] = '♥';
                }
                for (int a = 56; a < 57; a++) {
                    region[21][a] = '어';
                }
                for (int a = 57; a < 58; a++) {
                    region[21][a] = '촌';
                }
                for (int a = 55; a < 56; a++) {
                    region[21][a] = '◇';
                }
                for (int a = 58; a < 59; a++) {
                    region[21][a] = '◇';
                }
                for (int a = 19; a < 52; a++) {
                    region[22][a] = '　';
                }
                for (int a = 64; a < 96; a++) {
                    region[22][a] = '　';
                }
                for (int a = 50; a < 53; a++) {
                    region[22][a] = '♥';
                }
                for (int a = 55; a < 59; a++) {
                    region[22][a] = '◇';
                }
                for (int a = 20; a < 54; a++) {
                    region[23][a] = '　';
                }
                for (int a = 62; a < 96; a++) {
                    region[23][a] = '　';
                }
                for (int a = 17; a < 96; a++) {
                    region[24][a] = '　';
                }
                for (int a = 16; a < 96; a++) {
                    region[25][a] = '　';
                }
                for (int a = 12; a < 96; a++) {
                    region[26][a] = '　';
                }
                for (int a = 14; a < 96; a++) {
                    region[27][a] = '　';
                }
                for (int a = 13; a < 96; a++) {
                    region[28][a] = '　';
                }
                for (int a = 96; a < 100; a++) {
                    region[28][a] = '♪';
                }
                for (int a = 10; a < 90; a++) {
                    region[29][a] = '　';
                }
                for (int a = 10; a < 87; a++) {
                    region[30][a] = '　';
                }
                for (int a = 11; a < 12; a++) {
                    region[30][a] = '◆';
                }
                for (int a = 8; a < 81; a++) {
                    region[31][a] = '　';
                }
                for (int a = 10; a < 13; a++) {
                    region[31][a] = '◆';
                }
                for (int a = 18; a < 19; a++) {
                    region[31][a] = '◆';
                }
                for (int a = 61; a < 64; a++) {
                    region[31][a] = '♨';
                }
                for (int a = 7; a < 78; a++) {
                    region[32][a] = '　';
                }
                for (int a = 9; a < 10; a++) {
                    region[32][a] = '◆';
                }
                for (int a = 11; a < 12; a++) {
                    region[32][a] = '◆';
                }
                for (int a = 13; a < 14; a++) {
                    region[32][a] = '◆';
                }
                for (int a = 18; a < 19; a++) {
                    region[32][a] = '◆';
                }
                for (int a = 19; a < 20; a++) {
                    region[32][a] = '⊙';
                }
                for (int a = 61; a < 64; a++) {
                    region[32][a] = '♨';
                }
                for (int a = 5; a < 80; a++) {
                    region[33][a] = '　';
                }
                for (int a = 8; a < 9; a++) {
                    region[33][a] = '◆';
                }
                for (int a = 11; a < 12; a++) {
                    region[33][a] = '◆';
                }
                for (int a = 13; a < 15; a++) {
                    region[33][a] = '◆';
                }
                for (int a = 18; a < 22; a++) {
                    region[33][a] = '◆';
                }
                for (int a = 61; a < 64; a++) {
                    region[33][a] = '♨';
                }
                for (int a = 4; a < 59; a++) {
                    region[34][a] = '　';
                }
                for (int a = 64; a < 75; a++) {
                    region[34][a] = '　';
                }
                for (int a = 13; a < 19; a++) {
                    region[34][a] = '◆';
                }
                for (int a = 3; a < 56; a++) {
                    region[35][a] = '　';
                }
                for (int a = 14; a < 22; a++) {
                    region[35][a] = '◆';
                }
                for (int a = 66; a < 72; a++) {
                    region[35][a] = '　';
                }
                for (int a = 4; a < 50; a++) {
                    region[36][a] = '　';
                }
                for (int a = 11; a < 19; a++) {
                    region[36][a] = '◆';
                }
                for (int a = 4; a < 5; a++) {
                    region[36][a] = '◆';
                }
                for (int a = 3; a < 47; a++) {
                    region[37][a] = '　';
                }
                for (int a = 16; a < 19; a++) {
                    region[37][a] = '◆';
                }
                for (int a = 5; a < 8; a++) {
                    region[37][a] = '◆';
                }
                for (int a = 9; a < 12; a++) {
                    region[37][a] = '◆';
                }
                region[37][48] = '♪';
                for (int a = 60; a < 74; a++) {
                    region[37][a] = '┼';
                }
                for (int a = 3; a < 41; a++) {
                    region[38][a] = '　';
                }
                for (int a = 7; a < 9; a++) {
                    region[38][a] = '◆';
                }
                for (int a = 15; a < 21; a++) {
                    region[38][a] = '◆';
                }
                for (int a = 65; a < 66; a++) {
                    region[38][a] = '열';
                }
                for (int a = 66; a < 67; a++) {
                    region[38][a] = '대';
                }
                for (int a = 67; a < 68; a++) {
                    region[38][a] = '우';
                }
                for (int a = 68; a < 69; a++) {
                    region[38][a] = '림';
                }
                for (int a = 60; a < 65; a++) {
                    region[38][a] = '┼';
                }
                for (int a = 69; a < 74; a++) {
                    region[38][a] = '┼';
                }
                for (int a = 60; a < 74; a++) {
                    region[39][a] = '┼';
                }
            }
        }
        region[xx][yy] = 'ㅗ';

        for (int i = 0; i < region.length; i++) {
            for (int j = 0; j < region[i].length; j++) {
                System.out.print(region[i][j]);
            }
            System.out.println();
        }
    System.out.println("[ 좌[4] 우[6] 위[8] 아래[5] ]");
    }
}
