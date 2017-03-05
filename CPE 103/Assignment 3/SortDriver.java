///-----------------------------------------------------------------
///   Class:          <SortDriver>
///   Description:    <Visually Sorts an Array In Various Ways>
///   Author:         <Michael Elliott>
///   Instructor:     <Dr. Buckalew>
///   Course:         <CPE 103-11>
///   Date:           <11/10/16>
///-----------------------------------------------------------------

import java.awt.*;
import java.applet.Applet;
import javax.swing.*;
import java.awt.event.*;

public class SortDriver extends Applet {
   
   private int array[];  // array to be sorted
   private int limit = 1000;  // size of array to be sorted - you may have to make
                              // this bigger for faster sorts
   private int largestNum; // need to know for color scaling purposes in paint()
   private static int CUTOFF = 0;
   
   private boolean bubble = true;
   private boolean merge = false;
   private boolean insertion = false;
   private boolean quick = false;
   
   private int[] temp; //Temp Array for Merge Sort

  // flag to tell paint() whether to paint a single location or the whole array
   private enum PaintType {ALL, RANGE, SINGLE};
   private PaintType doPaint = PaintType.ALL;

   private int index = -1;  // index of single array location to be painted
   private int leftRange = -1;  // left end of range to be drawn
   private int rightRange = -1;  // right end of range to be drawn
   
   //this listener object responds to button events
   private ButtonActionListener buttonListener;
   
   //button to start the sort
   private JButton startSort;
   //private JButton reverseOrder;
   
   // the picture of the sort will appear on this canvas
   private SortCanvas picture;
   private final int pictureWidth = 1000;  // size of the sort bar
   private final int pictureHeight = 50;

   // put buttons and canvas on this panel
   private JPanel sortPanel;


   // put radio buttons on this panel
   private JPanel radioPanel;
   private JPanel radioPanelSorts;

   // declarations for some more GUI elements
   private JLabel label; // a non-interactive text field
   private JRadioButton r1, r2, r3; // radio buttons
   private JRadioButton s1, s2, s3, s4; // radio buttons
   private ButtonGroup rButtons;
   private ButtonGroup sButtons;
   private JTextField rText; // you can type text into this field
     
   public void init() {

      buttonListener = new ButtonActionListener();

      array = new int[limit];
      // load the array
      largestNum = array[0] = (int) (Math.random()*1000000.0);
      for (int i=1; i<limit; i++) {
          array[i] = (int) (Math.random()*1000000.0);
          // also keep track of the largest so that we can scale by it in paint()
          if (array[i] > largestNum) largestNum = array[i]; 
      }

      // set up the window
      sortPanel = new JPanel();
      sortPanel.setLayout(new BoxLayout(sortPanel, BoxLayout.Y_AXIS));
      
      // first place the sort bar on top
      picture = new SortCanvas();
      sortPanel.add(picture);
      
      // now place a button
      startSort = new JButton("Start");
      //reverseOrder = new JButton("Reverse");
      
      // the listener is triggered when the button is clicked
      startSort.addActionListener(buttonListener);
      sortPanel.add(startSort);

      // here's some more code that you may find useful
      // they're all wide because of the BoxLayout:Y-AXIS
      label = new JLabel("Input Array Size");
      sortPanel.add(label);

      // text field with room for 20 characters
      rText = new JTextField("Input Array Size Here:", 20); 
      rText.addActionListener(buttonListener); 
      sortPanel.add(rText);

      // put these buttons in their own panel
      radioPanel = new JPanel();
      radioPanel.setLayout(new BoxLayout(radioPanel, BoxLayout.X_AXIS));
      
      // radio buttons
      r1 = new JRadioButton("Random", true); // true sets this button by default
      r1.addActionListener(buttonListener);
      radioPanel.add(r1);

      r2 = new JRadioButton("In-Order", false); 
      r2.addActionListener(buttonListener);
      radioPanel.add(r2);

      r3 = new JRadioButton("Reverse-Order", false); 
      r3.addActionListener(buttonListener);
      radioPanel.add(r3);
   
      // radio buttons have to be added to a ButtonGroup to work
      rButtons = new ButtonGroup(); 
      rButtons.add(r1);
      rButtons.add(r2);
      rButtons.add(r3);

      // now add the radio panel to the sort panel
      sortPanel.add(radioPanel);

      // add the panel to the window
      add(sortPanel);
      
      // put these buttons in their own panel
      radioPanelSorts = new JPanel();
      radioPanelSorts.setLayout(new BoxLayout(radioPanelSorts, BoxLayout.X_AXIS));
      
      // radio buttons
      s1 = new JRadioButton("Bubble", true); // true sets this button by default
      s1.addActionListener(buttonListener);
      radioPanel.add(s1);

      s2 = new JRadioButton("Merge", false); 
      s2.addActionListener(buttonListener);
      radioPanel.add(s2);

      s3 = new JRadioButton("Insertion", false); 
      s3.addActionListener(buttonListener);
      radioPanel.add(s3);
      
      s4 = new JRadioButton("Quick", false); 
      s4.addActionListener(buttonListener);
      radioPanel.add(s4);
   
      // radio buttons have to be added to a ButtonGroup to work
      sButtons = new ButtonGroup(); 
      sButtons.add(s1);
      sButtons.add(s2);
      sButtons.add(s3);
      sButtons.add(s4);

      // now add the radio panel to the sort panel
      sortPanel.add(radioPanelSorts);

      // add the panel to the window
      add(sortPanel);
      
      picture.paint(picture.getGraphics());
   }
   
   // this object is triggered whenever a button is clicked
   private class ButtonActionListener implements ActionListener {
      public void actionPerformed(ActionEvent event) {
          
         // find out which button was clicked 
         Object source = event.getSource();
         
         // start sort button was clicked
         if (source == startSort) {
            // call the sort
        	if(bubble) doBubblesort();
        	if(merge){
        		doMergeSort(0, limit-1);
        		doMergeSort(0, limit-1);
        	}
        	if(insertion) doInsertionSort(array, 1, limit-1);
        	if(quick) doQuickSort(array, 0, limit-1);
         }
         
         //called when user hits return in text field
         if (source == rText) {
            int size = Integer.parseInt(rText.getText());
            limit = size;
            array = new int[limit];
            // load the array
            largestNum = array[0] = (int) (Math.random()*1000000.0);
            for (int i=1; i<limit; i++) {
                array[i] = (int) (Math.random()*1000000.0);
                // also keep track of the largest so that we can scale by it in paint()
                if (array[i] > largestNum) largestNum = array[i]; 
            }
            picture.paint(picture.getGraphics());
         }
         
       //RandomOrder Radio Button Clicked
         if(source == r1){
        	 largestNum = array[0] = (int) (Math.random()*1000000.0);
             for (int i=1; i<limit; i++) {
                 array[i] = (int) (Math.random()*1000000.0);
                 // also keep track of the largest so that we can scale by it in paint()
                 if (array[i] > largestNum) largestNum = array[i]; 
             }
        	 picture.paint(picture.getGraphics());
         }
         
         //InOrder Radio Button Clicked
         if (source == r2){
        	 largestNum = array[0] = 1;
        	 for (int i = 0; i < limit; i++) {
                 array[i] = i+1;
                 // also keep track of the largest so that we can scale by it in paint()
                 if (array[i] > largestNum) largestNum = array[i]; 
             }
        	 picture.paint(picture.getGraphics());
         }
         
         //ReverseOrder Radio Button Clicked
         if(source == r3){
        	 largestNum = array[0] = limit;
        	 for (int i = 0; i < limit; i++) {
                 array[i] = limit-i;
                 // also keep track of the largest so that we can scale by it in paint()
                 if (array[i] > largestNum) largestNum = array[i]; 
             }
        	 picture.paint(picture.getGraphics());
         }
         
       //BubbleSort Radio Button Clicked
         if(source == s1){
        	 bubble = true;
        	 merge = false;
        	 insertion = false;
        	 quick = false;
         }
         
       //MergeSort Radio Button Clicked
         if(source == s2){
        	 bubble = false;
        	 merge = true;
        	 insertion = false;
        	 quick = false;
         }
         
       //InsertionSort Radio Button Clicked
         if(source == s3){
        	 bubble = false;
        	 merge = false;
        	 insertion = true;
        	 quick = false;
         }
         
         //QuickSort Radio Button Clicked
         if(source == s4){
        	 bubble = false;
        	 merge = false;
        	 insertion = false;
        	 quick = true;
         }
      }    
   }

   private void doBubblesort() {
      int temp;

      // this is just bubblesort
      for (int i=0; i<limit-1; i++) {
         for (int j=0; j<limit-1-i; j++) {
            if (array[j]>array[j+1]) {
               temp = array[j]; array[j] = array[j+1]; array[j+1] = temp;
              
               // draws the bars between j and j+1
               doPaint = PaintType.RANGE;
               leftRange = j;
               rightRange = j+1;
               picture.paint(picture.getGraphics());
            }
         }
      }
   }   
   
   private void doMergeSort(int first, int last) {
	   temp = new int[limit];
       
       if (first < last) {
           int mid = first + (last - first) / 2;
           
           //Sorts Left
           doMergeSort(first, mid);
           doPaint = PaintType.RANGE;
           leftRange = first;
           rightRange = mid;
           picture.paint(picture.getGraphics());
           
           //Sorts Right
           doMergeSort(mid + 1, last);
           doPaint = PaintType.RANGE;
           leftRange = mid+1;
           rightRange = last;
           picture.paint(picture.getGraphics());
           
           //Merges Left & Right
           mergeParts(first, mid, last);
           picture.paint(picture.getGraphics());
       }
   }

   private void mergeParts(int first, int mid, int last) {
	   //code for the merging of the two halves of the array
       for (int i = first; i <= last; i++){
           temp[i] = array[i];
       }
       int i = first;
       int j = mid + 1;
       int k = first;
       while (i <= mid && j <= last){
           if (temp[i] <= temp[j]){
               array[k] = temp[i];
               i++;
           }
           else {
               array[k] = temp[j];
               j++;
           }
           k++;
       }
       while (i <= mid){
           array[k] = temp[i];
           k++;
           i++;
       }
   }
   
   // This is the usual implementation of binary insertion sort that uses a call
   // to binarySearch to determine where the current item belongs in the array.
   private void doInsertionSort(int[] data, int first, int last) {
	   for(int i = first+1; i <= last; ++i){
	        int target = binarySearch(data,data[i],first,i-1);
	        if (target != i)
	        {
	           int temp = data[i];
	           for(int j=i;j>target;--j)
	           data[j] = data[j-1];
	           data[target] = temp;
	        }
	   }
   }
   
   // Use binary search to determine the index of the data array after which x
   // should be inserted.
   private int binarySearch(int[] data,int x,int first,int last)
   {
	   doPaint = PaintType.RANGE;
       leftRange = first;
       rightRange = last;
       picture.paint(picture.getGraphics());
      int middle = 0;
      while(first<=last)
      {
         middle = (first+last)/2;
         if (x < data[middle])
            last = middle - 1;
         else if (x > data[middle])
            first = middle + 1;
         else
            return middle + 1;  
      }
      if (x > data[middle])
         return middle + 1;
      else
         return middle;
   }
   
   // This is the usual recursive implementation of quickSort using 
   // median-of-three pivot selection and no other enhancements.
   private void doQuickSort(int[] data, int first, int last) {
	   int size = last-first+1;
	      if (size <= CUTOFF)
	         doInsertionSort(data,first,last);
	      else
	      {
	         medianOfThree(data,first,last);
	         int p = partition(data,first,last);
	         doPaint = PaintType.RANGE;
	         leftRange = first;
	         rightRange = last;
	         picture.paint(picture.getGraphics());
	         doQuickSort(data,first,p-1); 
	         doQuickSort(data,p+1,last);
	      }
   }
   
   //Finds the median of three points in the array to determine the pivot point in Quick Sort
   private static void medianOfThree(int[] data,int first,int last)  
   {
      int temp,middle,median;

      if (last-first+1 < 3)
         return;
      middle = (first+last)/2;
      if (data[first] <= data[middle])
         if (data[middle] <= data[last])
            median = middle;
         else if (data[last] <= data[first])
            median = first;
         else
            median = last;
      else
         if (data[first] <= data[last])
            median = first;
         else if (data[last] <= data[middle])
            median = middle;
         else
            median = last;
      temp = data[first];
      data[first] = data[median];
      data[median] = temp;
   }
   
   // The value returned by this method must be the index of the array
   // element that contains the pivot after the partition is complete.
   private static int partition(int[] data,int first,int last)
   {
      int left = first+1;
      int right = last;
      int temp;
      while(true)
      {
         while(left<=right && data[left] <= data[first])
            ++left;
         while(right>=left && data[first] < data[right])
            --right;
         if (left > right)
            break;
         temp = data[left];
         data[left] = data[right];
         data[right] = temp;
         ++left;
         --right;
      } 
      temp = data[first];
      data[first] = data[right];
      data[right] = temp;
      return right;
   }
             
   class SortCanvas extends Canvas {
      // this class paints the sort bar 
       
      SortCanvas() {
         setSize(pictureWidth, pictureHeight);
         setBackground(Color.gray);
      }
       
      public void paint(Graphics g) {
         
         if (doPaint == PaintType.ALL) {
            // paint whole array - this takes time so it shouldn't be done too frequently
            setBackground(Color.gray);
            g.setColor(Color.gray);
            g.fillRect(0, 0, pictureWidth, pictureHeight);
            
            for (int i=0; i<limit; i++) {
               // the larger the number, the brighter green it is
               // green is between 0.0 and 1.0
               // divide by the largest number to get a value between 0 and 1
               float green = (float)(array[i]/(float)largestNum);

               // clamp if necessary - it shouldn't be
               if (green<0f) green = 0f;
               if (green>1f) green = 1f;

               g.setColor(new Color(0.0f, green, 0.0f));
               // array location 0 is painted at left; 
               // array location limit-1 is painted to right
               //this is a single vertical line in the bar
               g.drawLine((int)(i*pictureWidth/limit), 0, 
                          (int)(i*pictureWidth/limit), pictureHeight);
            }
         }
         
         else if (doPaint == PaintType.RANGE) {
            for (int i=leftRange; i<=rightRange; i++) {
               float green = (float)(array[i]/(float)largestNum);
               if (green<0f) green = 0f;
               if (green>1f) green = 1f;

               g.setColor(new Color(0.0f, green, 0.0f));
               g.drawLine((int)(i*pictureWidth/limit), 0, 
                          (int)(i*pictureWidth/limit), pictureHeight);
            }
         }
         else {   // just paint one location on the bar
            float green = (float)(array[index]/(float)largestNum);
            if (green<0f) green = 0f;
            if (green>1f) green = 1f;
            g.setColor(new Color(0.0f, green, 0.0f));
            g.drawLine((int)(index*pictureWidth/limit), 0, 
                       (int)(index*pictureWidth/limit), pictureHeight);
         }   
      }
   }
}