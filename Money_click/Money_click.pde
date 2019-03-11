import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.awt.Color;
import java.awt.event.InputEvent;

boolean on;
Propaganda prop;

void setup(){
  on=false;
  
  size(400,400);
  textAlign(CENTER);
  fill(255);
  
  try {  prop = new Propaganda(); } catch (Exception e) {}
}

void draw(){ 
  try{
    
    if(on){
      
      background(0,255,0);
      text("Desligar",200,200);
      
      prop.checar();
      
      
      
    } else {
      
      background(255,0,0);
      text("Ligar",200,200);
      
    }
    
  } catch(Exception e) {} 
  
}

void mousePressed(){
  
  on=!on;
        
}
