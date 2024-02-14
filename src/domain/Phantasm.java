package domain;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.io.Serializable;
import java.awt.event.ActionListener;
import java.awt.Graphics;
import javax.swing.*;

import ability.Ability;
import ability.Cannon;
import ability.MagicalHex;

public class Phantasm implements Serializable{
	
	private static final long serialVersionUID = 1L;
    int Speed;
    private int x;
    private int l;
    private int y;
    private int h;
    private Color phantasmColor;
    private boolean expanded = false;

    public Phantasm(int Speed,int x, int y, int l, int h) {
        super();
        this.Speed = Speed;
        this.x = x;
        this.h=h;
        this.y= y;

        this.l = l;

    }

    public void movePhantasmLeft() {
    	this.setX(x-20);

    }
    public void movePhantasmRight() {
        this.setX(x+20);

    }



    public int getSpeed() {
        return Speed;
    }

    public void setSpeed(int Speed) {
        this.Speed = Speed;
    }



    public Color getPhantasmColor() {
        return phantasmColor;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }
    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getL() {
        return l;
    }

    public void setL(int l) {
        this.l = l;
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }



    public void setPhantasmColor(Color Color) {
        this.phantasmColor = Color;
    }
    

    public boolean isExpanded() {
        return expanded;
    }
   
    public void setExpanded(boolean expanded) {
        this.expanded = expanded;
    }
    
    
}
//    @Override
//    public void keyTyped(KeyEvent e) {
//
//    }
//
//    @Override
//    public void keyPressed(KeyEvent e) {
//        if(e.getKeyCode() == KeyEvent.VK_RIGHT){
//            if (this.getX()<410) {
//                movePhantasmRight();
//            }
//
//        }
//        if(e.getKeyCode() == KeyEvent.VK_LEFT){
//            if (this.getX()>-10) {
//            movePhantasmLeft();
//            }
//
//
//        }
//    }
//
//    @Override
//    public void keyReleased(KeyEvent e) {
//
//    }
//
//}






