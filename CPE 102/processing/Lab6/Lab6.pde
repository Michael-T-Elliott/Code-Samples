boolean inCircle;
PVector v1;
float speed, pupilX1, pupilY1, pupilX2, pupilY2;

void setup()
{
  size(400,400);
  v1 = new PVector();
  pupilX1 = 150;
  pupilX2 = 250;
  pupilY1 = pupilY2 = 155;
}

void drawSmile()
{
  for (int i=0; i<2000; i++)
  {
  fill(0);
  float angle = i*(2*PI)/4000;
  ellipse(cos(angle)*30, sin(angle)*25, 3, 3);
  }
}

void drawFace()
{
  fill(#F8FF34);
  triangle(190, 110, 90, 130, 5, 5);
  
  fill(#F8FF34);
  triangle(210, 110, 310, 130, 395, 5);
  
  strokeWeight(1);
  fill(#F8FF34);
  ellipse(200,200,300,310);
  
  fill(0);//EYES
  ellipse(150, 155, 55, 55);
  ellipse(250, 155, 55, 55);
  
  fill(150,0,0);
  ellipse(110, 225, 60, 60);
  ellipse(290, 225, 60, 60);
  
  fill(0);
  triangle(195, 200, 205, 200, 200, 205);
  
  strokeWeight(1);
  pushMatrix();
    translate(200,220);
    drawSmile();
  popMatrix();
  
  fill(255);//EYEBALLS
  ellipse(pupilX1, pupilY1, 30, 30);
  ellipse(pupilX2, pupilY2, 30, 30);
}
  

void draw()
{
  background(150);
  drawFace();
}

void mouseDragged()
{
 v1.x = mouseX - 150;
 v1.y = mouseY - 155;
 v1.normalize();
 
 pupilX1 = 150 + v1.x * 13;
 pupilY1 = 155 + v1.y * 13;
 
 v1.x = mouseX - 250;
 v1.y = mouseY - 155;
 v1.normalize();
 
 pupilX2 = 250 + v1.x * 13;
 pupilY2 = 155 + v1.y * 13;
}
