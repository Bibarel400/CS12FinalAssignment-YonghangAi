/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cs12finalassignment;

//import the necessary method for the draw of person 
import processing.core.PApplet;
import processing.core.PImage;

public class Person {
    public Body body;
    
    //create various variables for the location, name, age and speed of movement
    public int x;
    public int y;
    private String name;
    private String age;
    int speed = 0;
    //create variables for the draw of image and its size
    private PApplet app;
    PImage image;
    private int width, height;
    /**
     * the constructor for person
     * @param p used to draw
     * @param name string variable for name
     * @param age integer variable for age
     * @param speed integer variable for speed
     * @param imagePath used to show the image
     */
    public Person(PApplet p,String name, String age, int speed, Body body,  String imagePath){
        this.body = body;
        this.app = p;
        this.name = name;
        this.age = age;
        this.speed = speed;
        this.image = app.loadImage(imagePath);
        
        this.width = image.width;
        this.height = image.height;
    }
    /**
     * method used to change speed when it is necessary with the parameter of string
     * @param n string variable for speed when it is not an exception
     */
    public void setSpeed(String n){
        try {//use try - catch to determine whether the string could use for speed
                this.speed = Integer.parseInt(n);
            } catch (NumberFormatException e) {
                this.speed = 1;//make speed back to original value when it is not work
            }
    
    }
    
    public void setBody(Body body){
        this.body = body;
    
    }
    
    
    
    /**
     * the method used to let person move
     * @param dx integer variable used to determine whether it should move during x-axis
     * @param dy integer variable used to determine whether it should move during x-axis
     */
    public void move(int dx, int dy){
        this.x += dx;
        this.y += dy;
//use if statement to make the person move as the reight speed in different direction
        
    }
    /**
     * the method used to determine the location of person
     * @param x the location of person in x-axis
     * @param y the location of person in y-axis
     */
    public void location(int x, int y){
        centerx(x);
        centery(y);
        
        body.location(x, y);
    }
    /**
     * the method used to translate the x value in center to the left top corner
     * @param x the location of person in x-axis
     */
    public void centerx(int x){
        this.x = x-(image.width)/2; 
    }
    /**
     * the method used to translate the y value in center to the left top corner
     * @param y the location of person in y-axis
     */
    public void centery(int y){
        this.y = y-(image.height)/2; 
    }
    
    
    //public void moveTo(int dx, int dy){
        //this.x = dx;
        //this.y = dy;
    //}
    /**
     * the method used to draw person
     */
    public void draw(){
        body.draw();
        app.image(image, x, y);
    }
    /**
     * the method used to determine whethr person is collided with another person
     * @param other the another person
     * @return a boolean for whether the colliding is happened
     */
    public boolean isCollidingWith(Person other) {
        //int centerX = x+(image.pixelWidth/2);
        //int centerY = y+(image.pixelHeight/2);
        //int otherCenterX = other.x +(other.image.pixelWidth/2);
        //int otherCenterY = other.y +(other.image.pixelHeight/2);
        //float d = PApplet.dist(otherCenterX, otherCenterY, centerX, centerY);
        //return d<64;
        boolean isLeftOfOtherRight = x < other.x + other.width;
        boolean isRightOfOtherLeft = x + width > other.x;
        boolean isAboveOfOtherBottom = y < other.y + other.height;
        boolean isBelowOtherTop = y+height > other.y;
        
        return isLeftOfOtherRight && isRightOfOtherLeft 
                && isAboveOfOtherBottom && isBelowOtherTop;
    }
    /**
     * the method used to determine whether the mouse is collided the person
     * @param mouseX integer variable for the location of mouse in x-axis
     * @param mouseY integer variable for the location of mouse in x-axis
     * @return the boolean for whether colliding happens or not
     */
    public boolean isClicked(int mouseX, int mouseY){
        int centerX = x +(image.pixelWidth/2);
        int centerY = y +(image.pixelHeight/2);
        float d = PApplet.dist(mouseX, mouseY, centerX, centerY);
        
        System.out.println("image height"+ image.pixelHeight);
        System.out.println("image height"+ image.pixelWidth);
        
        return d < height;
    }
    /**
     * the method used to show the information of person 
     * @param p the image of person
     */
    public void displayInfo(PApplet p){
        int g = 20;
        app.fill(0);
        app.text("Name: "+name, x, y-height-g*4);
        app.text("Age: "+age, x, y-height-g*3);
        app.text("Speed: "+speed, x, y-height-g*2);
        app.text("X/Y: "+x+"/"+y, x, y-height-g*1);
    }
}