// Base particle code for CSC 123 Lab 9

// TODO_1: add a new particle constructor that will take in a starting color for a particle
// TODO_2: add code to the Particle System to call the new Particle constructor
// TODO_3: add code so that the fire work explodes where the mouse clicks (use the existing firework, just restart a new system where the moust clicks)
// TODO_4: add code to start another firework when the old one dies
// TODO_5: add code in order to have the shading/transparency and or shape of the particle change over time
//         or depending on velocity
// TODO_6: add more then one firework

// define a particle
class Particle 
{
   PVector loc;
   PVector vel;
   PVector accel;
   float r;
   float life;
   color pcolor;
  
   // constructor
   Particle(PVector start) 
   {
      accel = new PVector(0, 0.05); //gravity
      vel = PVector.random2D();
      pcolor = color(random(255), random(255), random(255));
      loc = start.get();  // make a COPY of the start location vector
      r = 8.0;
      life = 100;
   }
    
   // TODO_1 define another constructor that allows a particle to start with a given color
    Particle(PVector start, color c) 
   {
      accel = new PVector(0, 0.05); //gravity
      vel = PVector.random2D();
      vel.mult(random(0,3));
      pcolor = c;
      loc = start.get();  // make a COPY of the start location vector
      r = 8.0;
      life = 200;
   }
    
   // what to do each frame
   void run() 
   {
      updateP();
      renderP(); // render is a fancy word for draw.  :)
   }
    
   // a function to update the particle each frame
   void updateP() 
   {
      vel.add(accel); 
      loc.add(vel);
      life -= 1.0;
      accel.y -= 0.002;
   }
    
   // how to draw a particle
   void renderP() 
   {
      pushMatrix();
       fill(pcolor, (100/(100/life)));
       translate(loc.x, loc.y);
       ellipse(0, 0, r, r);
      popMatrix();
   }
    
    // a function to test if a particle is alive
   boolean alive() 
   {
      if (life <= 0.0) 
      {
         return false;
      } 
      else 
      {
         return true;
      }
   }
} //end of particle object definition

// now define a group of particles as a particleSys
class PSys
{
  
   ArrayList particles; // all the particles
   PVector source; // where all the particles emit from
   color shade; // their main color
  
   // constructor
   PSys(int num, PVector init_loc) 
   {
      particles = new ArrayList();
      source = init_loc.get();  // you have to do this to set a vector equal to another vector
      shade = color(random(255), random(255), random(255));  // TODO_2 use this!
      for (int i=0; i < num; i++) 
      {
         particles.add(new Particle(source, shade));//COLOR AND SOURCE
      }
   }
    
   // what to do each frame
   void run() 
   {
      // go through backwards for deletes
      for (int i=particles.size()-1; i >=0; i--) 
      {
         Particle p = (Particle)particles.get(i);
          
         // update each particle per frame
         p.run();
         if (!p.alive()) // what is that '!' thingy??
         {
            particles.remove(i);
         }
      }
   }
    
   // Is particle system still populated?
   // Maybe use this method to determine when
   // a system is dead and then start a new one. HINT HINT
   boolean dead() 
   {
      if (particles.isEmpty()) 
      {
         return true;
      } 
      else 
      {
         return false;
      }
   }
}

// declare a particle system
ArrayList<PSys> particleSystem = new ArrayList<PSys>();
float nextFW;
PImage lightpole, kid;
PSys fireW1;

void setup() 
{
   size(500, 500);
   
   lightpole = loadImage("lightpole.png");
   kid = loadImage("kid.png");
   
   // range for the alpha is 0-100
   colorMode(RGB, 255, 255, 255, 100);
   
   // start a new particle system
   fireW1 = new PSys(100, new PVector(random(20,width-20), random(height/2)));

   frameRate(40);
}

void draw() 
{
   background(0);
   
   pushMatrix();
   scale(0.1);
   image(lightpole,3000, 2450);
   popMatrix();
   
   pushMatrix();
     scale(0.5);
     image(kid, 560, 330);
   popMatrix();
   
   // run the particle system
   fireW1.run(); 
   
   if( millis() > nextFW)
   {
     particleSystem.add (new PSys(100,new PVector(random(0, width),random(0, height))));
     nextFW = millis() + random(0,2000);
   }
   
   for(int i=0; i < particleSystem.size(); i++)
   {
     particleSystem.get(i).run();
   }
 
   
   if (fireW1.dead())
   {
    fireW1 = new PSys(100, new PVector(random(20,width-20), random(height/2)));
   }
   
   
   // TODO_4 add code to start a new particle system once the old one dies
     
}

// TODO_3 add a mouse click function
void mousePressed()
{
  particleSystem.add (new PSys(100,new PVector(mouseX, mouseY)));
}
