color purple, green, blue; //engram colors
float x, y; //mouse-click coordinates
int green1, blue1, purple1; //engram score counts
color currentColor; //random color selected of three possible colors (green, blue, purple)

void setup() //setup, define colors
{
  size(600, 600); //size of entire image
  purple = color(255, 0, 255); //Purple Color
  green = color(0, 255, 0); //Green Color  
  blue = color(0, 146, 180); //Blue Color
  
}

color GetRandomColor() //Function that decides color choice (70% Green, 20% Blue, 10% Purple)
{
  float randomNumber = random(0, 10); //Choose any number at random between 0 and 10
  if (randomNumber >= 0 && randomNumber <= 7) //IF statement defining when green (0 to 7, 70%)
  {
    green1 += 1; //Add one to green score count
    return green;
  }
  else if (randomNumber > 7 && randomNumber <= 9) //IF statement defining when blue (7 to 9, 20%)
  {
    blue1 += 1; //Add one to blue score count
    return blue;
  }
  else if (randomNumber > 9 && randomNumber <= 10) //IF statement defining when purple (9 to 10, 10%)
  {
    purple1 += 1; //Add one to purple score count
    return purple;
  }
    
    return color(0); //demads the function return a color
}

void draw()
{
  background(0);//background black
  fill(100);//fill color gray
  noStroke();//no stroke
  ellipse(300, 300, 500, 350);//beginning of cave shape
  triangle(400, 180, 400, 500, 580, 500);
  rect(350, 150, 170, 250);
  rect(380, 200, 170, 250);
  rect(550, 350, 10, 10);
  rect(550, 400, 10, 10);
  rect(550, 270, 30, 30);
  rect(100, 500, 400, -100);
  triangle(200, 180, 200, 500, 20, 500);
  rect(50, 450, 100, -250);
  ellipse(100, 200, 100, 50);//end of cave shape
  fill(0);//fill black
  ellipse(300, 380, 300, 350);//cave opening
  fill(94, 98, 43);//fill brown
  rect(0, 500, 600, 600);//ground
  
  fill(currentColor); //fill whatever color decided by GetRandomColor Function
  ellipse(x, y, 50, 50); //draws an ellipse at x, y mouse-coordinates
  if (y < 480) 
  y += 6; //if y < 480 (higher than the ground) it drops at a rate of 6
  
  textSize(13);//scores (up until the =)
  fill(green);
  text("Uncommon Engrams = ", 5, 15);
  text(green1, 155, 15);
  fill(blue);
  text(blue1, 155, 30);
  text("Rare Engrams = ", 49, 30);
  fill(purple);
  text(purple1, 155, 45);
  text("Legendary Engrams = ", 12 , 45);
  
  
  
  if (currentColor == green) //IF statement, stating that if the color is green the generated ellipse has "Good!" displayed above it
  {
    fill(255);
    text("Good!", x-19, y-38);
  }
  
   if (currentColor == blue) //IF statement, stating that if the color is blue the generated ellipse has "Great!" displayed above it
  {
    fill(255);
    text("Great!", x-20, y-38);
  }
  
   if (currentColor == purple) //IF statement, stating that if the color is purple the generated ellipse has "LEGENDARY!" displayed above it
  {
    fill(255);
    text("LEGENDARY!", x-38, y-38);
  }
}

void mousePressed()
{ 
  if (mouseX >= 160 && mouseX <= 440 && mouseY >= 210 && mouseY <= 500)
  {
    x = mouseX;
    y = mouseY;
    currentColor = GetRandomColor();
  }
}  
