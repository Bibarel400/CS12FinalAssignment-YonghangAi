/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cs12finalassignment;

import processing.core.PApplet;
/**
 *
 * @author 350265507
 */
public class MySketch extends PApplet {
    private Person person;
    int stage = 0;
    
    public void settings(){
        size (800,600);
    }
    
    public void setup(){
        background(100, 100, 100);
        textSize(20);
        person = new Person(this, 200, 300, "Kuafu", 1, 2, "images/kuafu2.png");
    }
    
    public void draw(){
        background(255);
        if (stage == 0){
            fill(0);
            textSize(40);
            text("My Cultural Story", 260, 100);
            textSize(30);
            text("\"Kuafu Chasing the Sun\"", 250, 150);
            textSize(20);
            text("Press enter to continue", 305, 200);
          
        }else if (stage ==1 ){
            person.draw();
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
