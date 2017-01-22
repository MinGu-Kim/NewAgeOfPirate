/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kkie.prog.comp;

public class Port {
    private String name;
    private String npcName;
    public int love;
    public int px;
    public int py;

    public void setName(String name) {
        this.name = name;
    }
    public void setNpcName(String npcName) {
        this.npcName = npcName;
    }
    public void setLove(int love){
        this.love = love;
    }
    public void setPxPy(int px, int py) {
        this.px = px;
        this.py = py;
    }

    public String getName() {
        return name;
    }
    public String getNpcName() {
        return npcName;
    }
    public int getLove() {
        return love;
    }
    public int getPx() {
        return px;
    }
    public int getPy() {
        return py;
    }
    
    public Port(){
    }
}
