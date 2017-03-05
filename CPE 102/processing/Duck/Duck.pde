/* CSC 123 base code for hierarchical duck lab
 * by ZJ Wood - Fall 2011
 * updates by J Workman - Fall 2013
 *
 * TODO: read through the code to make sure you understand what it is doing
 * TODO: add code in order to make the duck have feet that also walk as it animates
 */

PVector Dloc;
PVector dir;
float neckR, wingR, legLR, legRR, satanArm, speed, y;

boolean neckDown = true;
boolean wingDown = false;
boolean animateOn = false;
boolean legLDown = false;
boolean legRDown = true;
boolean armDown = false;
  
// normal set up
void setup() 
{
  size(400, 400);
  smooth();
  neckR = 0;
  wingR =-.2;
  legLR = 0;
  legRR = 0;
  y = 0;
  satanArm = -1.6;
  Dloc = new PVector(width*.9, height/2);
  dir = new PVector(-1, 0);
  speed = 0.5;
}

// normal draw
void draw() 
{
  background(60, 0, 40);
  
  // foreground
  fill(98, 20, 36);
  rect(0, height/2, width, height/2);
  
  drawDuck();
  
  if (animateOn) 
  {
     animate();
  }
  
}

// method to control starting the duck over again and control animation on and off
void mousePressed() 
{
  Dloc.x = width*.9;
  animateOn = !animateOn;
}

// code to draw the duck with animation parameters neckR and wingR - other transforms align
// the peices to the correct pivot points
void drawDuck() 
{
    noStroke();
    
    pushMatrix();
      translate(Dloc.x, Dloc.y); // move the entire duck
      scale(2); // scale the entire duck
 
      fill(255);
      pushMatrix();
        translate(-4, 10);
        rotate(legLR);
        translate(-4, 10);
        ellipse(0,0,6, 25);
      popMatrix();
      
      fill(255);
      pushMatrix();
        translate(4, 10);
        rotate(legRR);
        translate(4, 10);
        ellipse(0,0,6, 25);
      popMatrix();
      
      fill(70);
      ellipse(0, 0, 40, 30); // body
      
      //draw neck and head with possible animation transforms
      pushMatrix();
        translate(-16, 0); // move back into draw position - structural constant
        rotate(neckR);  // rotate by neckR parameter - control knob
        translate(0, -10); // move neck and head to pivot point - structural constant
        ellipse(0, 0, 10, 18); // neck
        ellipse(0, -7, 14, 14); // head
        fill(200, 5, 5);
        ellipse(0, -9, 4, 4);  // eye
        fill(155, 111, 16);
        triangle(-10, -8, -4, -11, -4, -5); // beak
      popMatrix();
     
     
      fill(255, 0, 0);
      pushMatrix();
        translate(5, -14);
        ellipse(0, 0, 15, 30);
        ellipse(0, -20, 15, 15);
      popMatrix();
      
      fill(255, 0, 0);
      pushMatrix();
        translate(7, -12);
        rotate(satanArm);
        translate(7, -12);
        ellipse(0, 0, 2, 10);
      popMatrix();
        
      
      // draw wing with possible animation transforms
      fill(50);
      pushMatrix();
         translate(-8, -5); // move into draw position - structural constant
         rotate(wingR); // animtion parameter to control wing flap - control knob
         translate(14, 0); // move to the pivot point - structural constant
         ellipse(0, 0, 34, 20); // wing
      popMatrix();
      
    popMatrix();          
}
 
//function to update all animation parameters 
void animate() 
{
  // update the duck's global location
  Dloc.x = Dloc.x + dir.x*speed;
  Dloc.y = Dloc.y + dir.y*speed;
  
  // find out how much the neck is rotated to decide which way to rotate
  // these constrain how much the neck moves up and down
  if (neckR < -1) 
  {
     neckDown = false;
  } 
  else if (neckR > 0.3) 
  {
     neckDown = true;
  }
 
  // depending on which way we need to rotate, do so
  if (neckDown) 
  {
     neckR -= .03; 
  } 
  else 
  {
    neckR += .03;
  }
  
  //left leg rotation
  if (legLR < -1) 
  {
     legLDown = false;
  } 
  else if (legLR > 0.3) 
  {
     legLDown = true;
  }
  
  if (legLDown) 
  {
     legLR -= .03; 
  } 
  else 
  {
    legLR += .03;
  }
  
  //right leg rotation
  if (legRR < -1) 
  {
     legRDown = false;
  } 
  else if (legRR > 0.3) 
  {
     legRDown = true;
  }
  
  if (legRDown) 
  {
     legRR -= .03; 
  } 
  else 
  {
    legRR += .03;
  }
  
  //satan's arm rotation
  if (satanArm < -2) 
  {
     armDown = false;
  } 
  else if (satanArm > -1) 
  {
     armDown = true;
  }
  
  if (armDown) 
  {
     satanArm -= .03; 
  } 
  else 
  {
    satanArm += .03;
  }
  
  // find out how much the wing is rotated to decide which way to rotate
  // these constrain how much the wing moves up and down
  if (wingR < -1.1) 
  {
     wingDown = true;
  } 
  else if (wingR > 0.3) 
  {
     wingDown = false;
  }
 
  if (wingDown) 
  {
     wingR += .03; 
  } 
  else 
  {
     wingR -= .03;
  }
}
