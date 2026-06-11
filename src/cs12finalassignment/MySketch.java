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
    private Background Back;
    private PImage bg;
    private PImage kuafupixel;
    int stage = 0;
    int stageE = 0;
    
    String [] Words = new String [3];
    
    
    public void settings(){
        size (800,600);
    }
    
    public void setup(){
        bg = loadImage("images/background1.png");
        background(100, 100, 100);
        textSize(20);
        person = new Person(this,"Kuafu", "2200", 2, "images/face1.png");
        Back = new Background(this, "background1", "images/background2.png");
        
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
            person.location(400, 300);
            fill(255);
            textSize(30);
            if(stageE == 0){
                text(Words[stageE], 50, 500);
            }else if (stageE == 1){
                text(Words[stageE], 50, 500);
            }else if (stageE == 2){
                text(Words[stageE], 50, 500);
            }
                    
                    
               
            
            
            
        }else if (stage ==2 ){
            person.draw();
           
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
            //if(person.isCollidingWith(person1)){
                //fill(255,0,0);
                //this.text("Yeath!!!", person.x, person.y);
                //image(kuafupixel, 0, 400);
            //}
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
            if (stageE >= 3){
                stage = 2;
            }
            while (keyCode == ENTER){
                stageE +=1;
            }
            
            
            
            
        }
    }
}
