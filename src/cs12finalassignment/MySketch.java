/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cs12finalassignment;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import processing.core.PApplet;
import processing.core.PImage;
/**
 *
 * @author 350265507
 */
public class MySketch extends PApplet {
    private Person person;
    private Body1 body1;
    private Body body2;
    private Body body3;
    int speedofperson = 0;
    int speed = -2;
    private Background back1;
    private Background back2;
    private PImage bg;
    private PImage kuafupixel;
    int stage = 0;
    int stageE = 0;
    
    int xx = 250;
    int yy = 100;
    
    int t3 = 0;
    int ut3 = 0;
    
    String [] Words = new String [3];
    
    
    public void settings(){
        size (800,600);
    }
    
    public void setup(){
        bg = loadImage("images/background1.png");
        background(100, 100, 100);
        textSize(20);
        body1 = new Body1(this,"stand",0,80, speedofperson, "images/body1.1.png");
        body2 = new Body(this,"stand",40-body2.width/2,110-body2.height/2, speedofperson, "images/IMG_0152.png");
        body3 = new Body(this,"stand",60-body3.width/2,110-body3.height/2, speedofperson, "images/IMG_0164.png");
        person = new Person(this,"Kuafu", "2200", speedofperson, body1, "images/face1.1.png");
        back1 = new Background(this, "background1", "images/background3.png");
        back2 = new Background(this, "background1", "images/background3.png");
        back1.location(0,275);
        back2.location(1500,275);
        
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
          
            
        }else if (stage == 1){
            background(0);
            
            person.draw();
            person.location(400, 250);
            
            fill(255);
            textSize(30);
            if(stageE == 0){
                text(Words[stageE], 50, 500);
            }else if (stageE == 1){
                text(Words[stageE], 50, 500);
            }else if (stageE == 2){
                text(Words[stageE], 50, 500);
            }
        }else if (stage ==2){
            
            back1.draw();
            back2.draw();
            person.draw();
            
            //if(person.isCollidingWith(person1)){
                //fill(255,0,0);
                //this.text("Yeath!!!", person.x, person.y);
                //image(kuafupixel, 0, 400);
            //}
        }else if (stage ==3){
            ut3+=1;
            person.location(xx, yy);
            back1.draw();
            back2.draw();
            person.draw();
            
            if (back1.x == (-700)){
                back2.x = 800;
            }
            if (back2.x == (-700)){
                back1.x = 800;
            }
            back1.move(speed, 0);
            back2.move(speed, 0);
            
            if (t3 <= 30){
                t3+=1;
                person.setBody(body2);
            }else if (t3 > 30 && t3 <= 60){
                t3+=1;
                person.setBody(body3);
            }else{
                t3 = 0;
            }
            
            
            
        }
    }
    public void keyPressed(){
        if (stage == 0){
            if (keyCode == ENTER){
                
                try{//use try catch statement to operate the file input
                    Scanner Fi = new Scanner(new File( "Word.txt"));//create a scanner method to scan the content of file
                    int n = 0;//create the integer veriable for the location of date for each array
                    while(Fi.hasNext()){//use while loop to input each line of file
                        String output = Fi.nextLine();//store the date from file into the string variable
                        Words[n]= output;
                        n+=1;//change to next position
                    }
                    Fi.close();//close the method

                }catch (IOException ioException){//catch the error
                    System.err.println("Java Exception: " + ioException);//output error
                }
                stage = 1;
            }
        }else if(stage == 1){
            if (keyCode == ENTER){
                stageE += 1;
            
            }
            if (stageE == 3){
                stage = 2;
            }
            
        }else if(stage == 2){
            if (keyCode == ENTER){
                stage = 3;
            
            }
        }
    }
}
