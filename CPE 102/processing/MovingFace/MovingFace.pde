float cx, cy, cxx, cyy, scale;
boolean drawOn;

void setup()
{
   size(400, 400);
   
   drawOn = true;
   scale = 1;
   cx = 200;
   cy = 400;
}

void draw()
{
  background(255);
  
   if(drawOn)
   {
     pushMatrix();
       translate(cx, cy);
       scale(scale);
       //draw face
       fill(255, 255, 0); //yellow
       ellipse(0, 0, 40, 40);
       fill(0, 150, 0); // dark green
       ellipse(-10, -5, 10, 10);
       ellipse(10, -5, 10, 10);
       fill(255);
       ellipse(0, 10, 20, 5);
     popMatrix();
     
     cy--;
     cx+= random(cxx, cyy);
     scale += .008;
     
     if( cy <= 0)
     {
       cy = 400;
     }
   }
}

void mousePressed()
{
  cx = 200;
  cxx -= 1;
  cyy += 1;
  cy = 400;
  scale = 1;
  drawOn = true;
}
