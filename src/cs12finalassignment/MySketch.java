/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cs12finalassignment;

import processing.core.PApplet;
import processing.core.PImage;
/**
 *
 * @author 350265507
 */
public class MySketch extends PApplet {
    private Person person;
    private Person person1;
    private PImage bg;
    private PImage kuafupixel;
    int stage = 0;
    
    public void settings(){
        size (800,600);
    }
    
    public void setup(){
        bg = loadImage("images/background1.png");
        background(100, 100, 100);
        textSize(20);
        person = new Person(this, 200, 300, "Kuafu", "2200", 2, "images/kuafu2.png");
        person1 = new Person(this, 200, 300, "Kuafu", "4.6 Billion", 2, "images/sun.png");
        kuafupixel = loadImage("images/kuafupixel.png");
    }
    
    
    public void draw(){
        background(255);
        if (stage == 0){
            image(bg, 0, 0, width, height);
            fill(0);
            textSize(40);
            text("My Cultural Story", 260, 100);
            textSize(30);
            text("\"Kuafu Chasing the Sun\"", 250, 150);
            textSize(20);
            text("Press enter to continue", 305, 200);
          
        }else if (stage ==1 ){
            person.draw();
            person1.draw();
            if(keyPressed){
                if(keyCode == RIGHT){
                    person.move(person.speed, 0);
                }else if(keyCode == LEFT){
                    person.move(-person.speed, 0);
                }else if(keyCode == UP){
                    person.move(0, -person.speed);
                }else if(keyCode == DOWN){
                    person.move(0, person.speed);
                }
            }
            if(person.isCollidingWith(person1)){
                //fill(255,0,0);
                //this.text("Yeath!!!", person.x, person.y);
                image(kuafupixel, 0, 400);
            }
        }
    }
    public void keyPressed(){
        if (stage == 0){
            if (keyCode == ENTER){
                stage = 1;
            }
        }
    }
}
