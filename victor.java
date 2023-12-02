/*
Author: Jonathan David Lee
Sacramento State CS Professors: Gita Faroughi, Devin Cook, Iraj Sabzevary, Mark Ainsley
Date: Sep 26 2023

The VIC cipher decoder program researching
*/

import java.util.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class victor extends JFrame
{
   private JTextField jftphrase = new JTextField(8);
   private JTextField jftdate = new JTextField(8);
   private JTextField jftkeygroup = new JTextField(8);
   private JTextField jftpreagreeded = new JTextField(8);
   private JTextField jftmessage = new JTextField(8);
   private JTextField jftpersonalnum = new JTextField(8);
   private JButton jbtCenter = new JButton("Cipher");
   private JButton jbtCentered = new JButton("De-Cipher");
   public victor()
   {
      JPanel p1 = new JPanel (new FlowLayout(FlowLayout.RIGHT, 1, 1));
      setLayout(new GridLayout(7,7,7,7));
      add(new JLabel("Enter ddmmyyyy:"));
      add(jftdate);
      add(new JLabel("Short Pharse 20 letters no spaces:"));
      add(jftphrase);
      add(new JLabel("Key Group:"));
      add(jftkeygroup);
      add(new JLabel("Message to cipher/de-cipher:"));
      add(jftmessage);
      add(new JLabel("Personal Num:"));
      add(jftpersonalnum);
      add(new JLabel("Pre Agreed:"));
      add(jftpreagreeded);
      add(p1);
      jbtCenter.addActionListener(new ButtonListener());
      p1.add(jbtCenter);
      jbtCentered.addActionListener(new Button_De_cipher());
      p1.add(jbtCentered);
   }
   
   /*This method is for cipher button */
   private class ButtonListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         /* /BUTTOIN ACTIVATE AREA */
         /*
         int personal_num = Integer.parseInt(jftpersonalnum.getText());
         String date = (jftdate.getText());
         String phrase = (jftphrase.getText());
         String keygroup = (jftkeygroup.getText());
         String pre_agreed = (jftpreagreeded.getText());
         String Message = (jftmessage.getText());
         message(personal_num, date, phrase, keygroup, pre_agreed, Message);
         */ 
        
        
        
         /* NON BUTTON MANUAL TEST MODE AREA 1 */
         /*  
         int personal_num = 6;
         String date = "139195";
         String phrase = "twasthenightbeforechristmas";
         String keygroup = "72401";
         String pre_agreed = "AT ONE SIR";
         String Message = "Attack at dawn. By dawn I mean";       
         message(personal_num, date, phrase, keygroup, pre_agreed, Message);
         */
      
        /* NON BUTTON MANUAL TEST MODE AREA 2 padding 9 used */
         /*
         int personal_num = 8;
         String date = "741776";
         String phrase = "idreamofjeanniewitht";
         String keygroup = "77651";
         String pre_agreed = "AT ONE SIR";
         String Message = "We are pleased to hear of your success in establishing your false identity You will be sent some money to cover expenses within a month";
         //String Message = "SACRAMENTO STATE UNIVERSITY COMPUTER SCIENCE STUDENT";
         /*
         
         /* NON BUTTON MANUAL TEST AREA NUMERICAL 3 padding 5 used */
         ///*
         int personal_num = 6;
         String date = "13919";
         String keygroup = "72401";
         String pre_agreed = "AT ONE SIR";
         String phrase = "twasthenightbeforech";
         String Message = "Attack at dawn. By dawn I mean 0500. Not 0915 like you did last time."; 
         //*/
         
         message(personal_num, date, phrase, keygroup, pre_agreed, Message); 
      }
   }
   
   /* This method is for the De cipher button */
   private class Button_De_cipher implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
      
         /* /BUTTOIN ACTIVATE AREA */
         /*
         int personal_num = Integer.parseInt(jftpersonalnum.getText());
         String date = (jftdate.getText());
         String phrase = (jftphrase.getText());
         String pre_agreed = (jftpreagreeded.getText());
         String cipher = (jftmessage.getText());
         String keygroup = get_keygroup(date, cipher);
         */
         
         /* NON BUTTON MANUAL TEST MODE AREA padding 9 used */
         /*
         //String cipher = ("90478 05632 84252 48466 62071 52900 90694 77651 20202 17031 43290 48230 28881"); //SACRAMENTO STATE MESSAGE
         String cipher = ("36178 05428 99592 53507 01440 00113 42004 74684 58426 75048 42503 10084 69181 77284 83603 47503 50076 68483 88242 42838 90960 35071 37586 89914 05000 77651 80429 00873 78601 44725 44860");
         int personal_num = 8;
         String date = "741776";
         String phrase = "idreamofjeanniewitht";
         String pre_agreed = "AT ONE SIR";
         String keygroup = get_keygroup(date, cipher);
         System.out.println("\nKeygroup in use: " +keygroup);
         */
         
         /* NON BUTTON MANUAL TEST AREA NUMERICAL USE padding 5 used */
         ///*
         String cipher = "96658 86791 06602 58887 06408 39604 09151 05508 05865 69555 04957 78785 72401 60078 36796 95036 03789 61329 36865 65780 02001";
         int personal_num = 6;
         String date = "13919";
         String keygroup = get_keygroup(date, cipher);
         String pre_agreed = "AT ONE SIR";
         String phrase = "twasthenightbeforech";
         //*/
            //runs de-ciphering
         de_cipher(personal_num, date, keygroup, phrase, cipher, pre_agreed);
      }
   }
  
   /* Main method calls run*/
   public static void main (String args[])
   {
      run();
   }
   
   /* This method sets GUI visabile */
   private static void run()
   {
      victor frame = new victor();
      frame.pack();
      frame.setTitle("JONATHAN LEE'S VICTOR PROGRAM");
      frame.setSize(560, 280);
      frame.setLocationRelativeTo(null);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);   
      System.out.println("VIC CIPHER JAVA PROGRAM");
   }
         
   /* This method is for the cipher button calls all sub methods used to create ciper text */  
   private static void message(int personal_num, String date, String Line_D, String keygroup, String pre_agreed, String Message)
   {
      Line_D = Line_D.toUpperCase(); // must be in uppercase
      String Line_e1 = (Line_D.substring(0,10)); //split the 20 letter keyphrase into two parts with 10 length each
      String Line_e2 = (Line_D.substring(10,20)); //second part of keypharse
      String Line_c  = LineC(keygroup, date); //calls LineC method to find lineC
      System.out.println("LINE C:  "+Line_c);
      String Line_E1 = Sequence(Line_e1);
      String Line_E2 = Sequence(Line_e2);
      System.out.println("LINE E1: "+Line_E1+" LINE E2: "+Line_E2);
      String Line_F1 = LineC(Line_c);
      String Line_F2 = ("1234567890");
      System.out.println("LINE F1: "+Line_F1+" LINE F2: "+Line_F2);
      String Line_G = LineG(Line_E1, Line_F1);
      System.out.println("LINE G:  "+Line_G);
      String Line_H = LineH(Line_E2, Line_F2, Line_G);
      System.out.println("LINE H:  "+Line_H);
      String Line_J = LineJ(Line_H); 
      System.out.println("LINE J:  "+Line_J);
      String Line_K = ChainBlock(Line_H);
      System.out.println("LINE K:  "+Line_K);
      String Line_L = ChainBlock(Line_K);
      System.out.println("LINE L:  "+Line_L);
      String Line_M = ChainBlock(Line_L);
      System.out.println("LINE M:  "+Line_M);
      String Line_N = ChainBlock(Line_M);
      System.out.println("LINE N:  "+Line_N);
      String Line_P = ChainBlock(Line_N);
      System.out.println("LINE P:  "+Line_P);
      String Line_Q_Full = LineQ(Line_J, Line_K, Line_L, Line_M, Line_N, Line_P);
      String Line_Q = Line_Q_Permutation(Line_Q_Full, Line_P,  personal_num);
      System.out.println("LINE Q:  "+Line_Q);
      String Line_R = Line_R_Permutation(Line_Q_Full, Line_P, personal_num);
      System.out.println("LINE R:  "+Line_R);
      String Line_S = LineJ(Line_P);
      System.out.println("LINE S:  "+Line_S);
      Map <String, String> Mapper = CheckerBoard(Line_S, pre_agreed);
      System.out.println("MAPPED KEY:  \n\t"+Mapper);
      String rawencoded = convert_to_num(Mapper, Message);
      System.out.println("\nMESSAGE:   \n\t"+Message+"\n\nRAW ENCODED:   \n\t"+rawencoded+"\n");
      int transposition_A = transpositionA(Line_P, personal_num);
      int transposition_B = transpositionB(Line_P, personal_num);
      System.out.println("TRANSPOSITION A LENGTH: "+transposition_A);
      System.out.println("TRANSPOSITION B LENGTH: "+transposition_B);
      Map cipher = columnar_transposition(Line_Q, Line_R, rawencoded, transposition_A, transposition_B);
      System.out.println("TRANSPOSITION 1: \n\t"+cipher);
      String IntCipher = intermediate_cipher(cipher, Line_Q);
      System.out.println("\nINTERMEDIATE FORM OF MESSAGE: \n\t"+IntCipher);
      System.out.println();
      Map pre_second_transposition =  SecondTransposition(IntCipher, Line_R, transposition_A, transposition_B);
      System.out.println("\nCompleted Appended Step-like disruption: \n\t"+pre_second_transposition);
      String ciphered = intermediate_cipher(pre_second_transposition, Line_R);
      System.out.println("\nTRANSPOSITION 2: \n\t"+ciphered);
      Map transmit = final_transmitted_message(ciphered, date, keygroup);
      final_grid(transmit);
   }
   
   /* This method is used for the letter based sequencing of Line E1 and E2  0 = 10 */
   private static String Sequence(String Line)
   {
      int s = 1;
      int count = 0;
      for(int i=65; i<=90; i++)
      {
         for (char j: Line.toCharArray())
         {
            if(j==(char)i)
            {
               try
               {
                  String partA = (Line.substring(0, count));
                  partA+=(""+s);
                  String partB = (Line.substring(count+1));
                  Line =(partA+""+partB);
                  s++;
                  if(s==10)
                     s=0;
               }
               catch(Exception e)
               {
                  System.out.println(e);   
               }
            }
            count++;
         }
         count = 0;
      }
      return Line;
   }
   
   /* This method is used for numerical based sequenceing */
   private static String LineC(String Chain)
   {
      String returnstring = Chain;
      for(int i = 0; i<Chain.length(); i++)
      {
         try
         {
            int StartPos = Chain.charAt(i) - '0';
            int NextPos = Chain.charAt(i+1) - '0';
            int chainadder = StartPos + NextPos;
            if(chainadder>10)
               chainadder-=10;
            if(chainadder==10)
               chainadder = 0;
            returnstring += chainadder;
         }
         catch (Exception e)
         {
            int StartPos = Chain.charAt(i) - '0';
            int NextPos = returnstring.charAt(i+1) - '0';
            int chainadder = StartPos + NextPos;
            if(chainadder>10)
               chainadder-=10;
            if(chainadder==10)
               chainadder = 0;
            returnstring += chainadder;
            return returnstring;
         }
      }
      return returnstring;
   }
   
   /* This method will date-keygroup = lineC without carries overloaded method same name used */
   private static String LineC(String keygroup, String date)
   {
      String LineC = "";
      for(int i = 0; i<keygroup.length(); i++)
      {
         int StartPos = keygroup.charAt(i) - '0';
         int SubPos =  date.charAt(i) - '0';
         if(StartPos>SubPos)
            LineC += (""+(StartPos-SubPos));
         else if (StartPos<SubPos)
            LineC += (""+((StartPos+10)-SubPos));
         else if (StartPos==SubPos)
            LineC += ("0");
      }
      return LineC;
   }
   
   /* This method will add Line E1 to Line F1 mod-10 arithmetic no carries over 10 to next line */
   private static String LineG(String Line_E1, String Line_F1)
   {
      String LineG = "";
      for(int i = 0; i<Line_E1.length(); i++)
      {
         int StartPos = Line_E1.charAt(i) - '0'; //creates int from char
         int AddPos =  Line_F1.charAt(i) - '0';
         int result = StartPos + AddPos;
         if(result>10)
            LineG += (result-10); //no carries
         else if (result==10)   
            LineG += (0);
         else
            LineG += result;
      }
      return LineG;
   }
   
   /* This encodes the digits in Line G under line E2 as the key */
   private static String LineH(String Line_E2, String Line_F2, String Line_G)
   {
      String Line_H = Line_G;
      int count = 0;
      for (char j: Line_F2.toCharArray())
      {
         for(char k: Line_G.toCharArray())
         {
            if(j == k)
            {
               String partA = (Line_H.substring(0, count));
               if (j == '0')
               {
                  partA+=(""+Line_E2.charAt(9));
                  String partB = (Line_H.substring(count+1));
                  Line_H =(partA+""+partB);
                  count++;
                  continue;
               }
               partA+=(""+Line_E2.charAt((j -'0')-1));
               String partB = (Line_H.substring(count+1));
               Line_H =(partA+""+partB);
            }
            count++;
         }
         count = 0;
      }
      return Line_H;
   }
   
   /* This method is the sequencing of line H */
   private static String LineJ(String LineH)
   {
      char min = '1';
      char marker = '1';
      int count = 0;
      String LineJ = LineH;
      for(int i = 0; i<10; i++)
      {
         for (char j: LineH.toCharArray())
         {
            if (min == ':')
               min = '0';
            if(min == j)
            {
               if (marker==':')
                  marker = '0';
               String partA = (LineJ.substring(0, count));
               partA+=(marker);
               String partB = (LineJ.substring(count+1));
               LineJ = (partA+""+partB);
               marker++;  
            }
            count++;
         }
         min++;
         count = 0;
      }       
      return LineJ;
   }
   
   /* This method is the chain addtion of Line H for 50 digits used for Lines K L M N O and P area created here */
   private static String ChainBlock(String Chain)
   {
      String returnstring = "";
      for(int i = 0; i<Chain.length(); i++)
      {
         try
         {
            int StartPos = Chain.charAt(i) - '0';
            int NextPos = Chain.charAt(i+1) - '0';
            int chainadder = StartPos + NextPos;
            if(chainadder>10)
               chainadder-=10;
            if(chainadder==10)
               chainadder = 0;
            returnstring += chainadder;
         }
         catch (Exception e)
         {
            int StartPos = Chain.charAt(i) - '0';
            int NextPos = returnstring.charAt(0) - '0';
            int chainadder = StartPos + NextPos;
            if(chainadder>10)
               chainadder-=10;
            if(chainadder==10)
               chainadder = 0;
            returnstring += chainadder;
            return returnstring;
         }
      }
      return returnstring;
   }
  
   /* This method creates full line Q block string from strings Line K L M N O P */
   private static String LineQ(String LineJ, String LineK, String LineL, String LineM, String LineN, String LineP)
   {
      String Line_Q = "";
      String Marker = "";
      int counter = 1;
      for (int i=1; i<=10; i++)
      {
         for (char j: LineJ.toCharArray())
         {
            if(i == 10)
               i=0;
            if(j - '0' == i)
            {
               if (counter == 10)
               {
                  Marker += 0;
                  continue;
               }
               Marker += counter ; 
            }
            counter ++;
         }
         counter = 1;
         if (i == 0)
            break;
      }
      for (char j: Marker.toCharArray())
      {
         int q = 1;
         try
         {
            if((j-'0'-q) == -1)
               q=-9;
            Line_Q += LineK.charAt(j-'0'-q);
            Line_Q += LineL.charAt(j-'0'-q);
            Line_Q += LineM.charAt(j-'0'-q);
            Line_Q += LineN.charAt(j-'0'-q);
            Line_Q += LineP.charAt(j-'0'-q);
         }
         catch (Exception e)
         {
            System.out.println(e);
            break;
         }
      }
      return Line_Q;
   }
   
   /* This method get only Line q */
   private static String Line_Q_Permutation(String Line_Q, String LineP, int personal_num)
   {
      char lasttwo = LineP.charAt(8); //9,10
      int end = (lasttwo -'0') + (personal_num);
      char lastone = LineP.charAt(9); //10 zero based index
      return Line_Q.substring(0, end); //return only Line Q from block
   }
   
   /* This method finds transpositionA = uses second to last digit in linep + personal num */
   private static int transpositionA(String LineP, int personal_num)
   {
      char lasttwo = LineP.charAt(8); //zero indexing size 10 0-9
      return (lasttwo - '0') + (personal_num);
   }
   
   /* This method finds transpositionA = last digit in linep + personal num */
   private static int transpositionB(String LineP, int personal_num)
   {
      char lastone = LineP.charAt(9); //zero indexing size 10 0-9
      return (lastone - '0') + (personal_num);
   }
   
  /* This method finds lineR first 13 from the block R is next 6 */     
   private static String Line_R_Permutation(String Line_Q, String LineP, int personal_num)
   {
      char lasttwo = LineP.charAt(8);
      int end = (lasttwo -'0') + (personal_num);
      char lastone = LineP.charAt(9);
      return Line_Q.substring(end, ((lastone -'0')+personal_num)+end);
   }
   
   /* This method creates the map for the straddling checkerboard use map used because it needs duplicate "Space" and needs keys to it*/
   private static Map<String, String> CheckerBoard(String LineS, String pre_agreed)
   {
      Map<String, String> Mapper = new HashMap<>();
      Set<String> SetA = new HashSet<>();
      Set<String> SetB = new HashSet<>();
      
      String SeqA = "";
      String SeqB = "";
      int locate = 0;
      char hold = ' ';
      
      for (char j: pre_agreed.toCharArray())
      {
         SetA.add(""+j);
      }
      
      for(int i=65; i<=90; i++)
      {
         SetB.add(""+(char)i);
      }
      Set<String> Difference = new HashSet<>(SetB); //difference in set Java relationships to CSC28
      Difference.removeAll(SetA);
      //System.out.println(Difference); //Test Point for Straddling checkerboard
      int i = 0;
      for(String s: Difference)
      {
         if(i<10)
         {
            SeqA += s;
            i++;
            continue;
         }
         else
            SeqB += s;   
      }
      SeqB += ""+'.';
      SeqB += ""+'/'; 
      i=0;
      for(char j: LineS.toCharArray())
      {
         Mapper.put(""+(j),""+(pre_agreed.charAt(i)));
         i++;
      }
      //System.out.println(Mapper); //test point for Mapper Key value agree phrase to LineS
      String GridSide = "";
      Iterator<Map.Entry<String, String>> it = Mapper.entrySet().iterator();
      while(it.hasNext())
      {
         Map.Entry<String, String> entry = it.next();
         String j = (entry.getValue());
         //System.out.println(j); //test point for values 
         if (j.equals(" "))
         {
            //System.out.println(entry.getKey());// test point for column label digits
            GridSide+=entry.getKey();
         }
      }
      Boolean flag = true;
      for(char j: GridSide.toCharArray())
      {
         if(flag)
         {
            for (int q = 0; q<10; q++)
            {
               Mapper.put(""+(j)+""+(LineS.charAt(q)),""+(SeqA.charAt(q)));
               if (q==9)
                  flag = false;
            }
         }
         else if(!flag)
            for (int q = 0; q<10; q++)
            {
               Mapper.put(""+(j)+""+(LineS.charAt(q)),""+(SeqB.charAt(q)));
            }
      }
      return Mapper;
   }
      
    /* This method converts the message into a raw cipher with use of the straddling checkerboard */  
   private static String convert_to_num(Map<String, String> Mapper, String Message)
   {
      Message = Message.toUpperCase();
      String cipher = "";
      boolean flag = false;
      Iterator<Map.Entry<String, String>> ctl = Mapper.entrySet().iterator();
      String slash = "";
      while(ctl.hasNext()) // used to find key for '/' for use if numerical entry is used
      {
         Map.Entry<String, String> loca = ctl.next();
         String j_two = (loca.getValue());
         if(j_two.charAt(0) == '/') //used to seperate numbers
         {
            slash = loca.getKey();
            break;
         }
      } 
      for(char q: Message.toCharArray()) //for each char in string message
      {
         Iterator<Map.Entry<String, String>> it = Mapper.entrySet().iterator(); //instantiate an iterator for map
         while(it.hasNext())
         {
            Map.Entry<String, String> entry = it.next();
            String j = (entry.getValue());
            if(q==' ') //if space is used skip message does not send spaces
               break; //break get next char in string message
            else if(j.charAt(0) == q) //when iterator matches a char we must get the corresponding key value 
            {
               cipher+=entry.getKey(); //add the num version of number by way of key
               break; //break get next char in string message
            }
            else if(q < 58 && q > 47) //if q is numerical
            {
               if(!flag) //activate flag for slash add condition numbers must have / before them to change to nums
                  cipher += slash;
               cipher+=(q); //numbers are repeated 3 times to help with comprehension
               cipher+=(q);
               cipher+=(q);
               flag = true; //set flag to true incase next item is also a number
               break; //break and get next char                                     
            }
            else if(flag) //if flag is on that means the next char q is no longer a number as it hit the next if statement here
            {
               cipher += slash; //add the splice to separate numbers from alphabetical entry items
               flag = false; // change back to false for future use with numbers if found again
               continue; //must continue not break to check for next alphabetical item as it was not found yet
            }
         }
      }
      return cipher; //return the raw cipher
   }
   
   /* This method converts the raw encoded into a simple columnar transpotion with direction of TranpositionA and B values to set sizes up*/
   private static Map columnar_transposition(String LineQ, String LineR, String Raw_Encoded, int transposition_A, int transposition_B)
   {
      int padding = 0;
      while(Raw_Encoded.length()%5!=0)//message only transmits in sets of 5 each we must padd message when needed agreeded upon padding
      {
         Scanner kb = new Scanner(System.in);
         System.out.print("\n ************** !!!!! WARNING !!!!! **************      \n ----->>>> THIS MESSAGE REQUIRES PADDING <<<<-----\n *************************************************\n\n --->> PLEASE ENTER THE AGREEDED UPON PADDING TO BE USED (0-9): ");
         while(!kb.hasNextInt())
         {
            System.out.println("NUMBER ENTRY ONLY:");
            kb.nextLine();
         }
         padding = kb.nextInt();
         Raw_Encoded += ""+padding;
      }
      String columar_transpositionA = "";
      int linenum = 0;
      Map<String, String> Grid = new HashMap<>();
      int a = 0;
      int b = transposition_A;
      while(Raw_Encoded.length()>0)
      {
         try
         {
            Grid.put(""+linenum, Raw_Encoded.substring(a, b));
            Raw_Encoded = Raw_Encoded.substring(transposition_A);
            linenum++;
         }
         catch (Exception e)
         {
            Grid.put(""+linenum, Raw_Encoded);
            break;
         }
      }
      return Grid;
   }
    
   /* This method creates the intermediate from of the message before step like disruptions LineQ is used as col guide for placements of columnar transposition */
   private static String intermediate_cipher(Map<String, String> cipher, String LineQ)
   {
      String IntCipher = "";
      String j ="";
      int marker = 0;
      for(int i = 1; i<=10; i++)
      {
         for(char s: LineQ.toCharArray())
         {
            if(i==10)
               i = 0;
            if(i == s - '0')
            {
               for (int q = 0; q<=cipher.size(); q++)
               {
                  //System.out.print(marker+" "); //test point sequence
                  try
                  {
                     j = (cipher.get(q+""));
                     IntCipher += j.charAt(marker);
                  }
                  catch(Exception e) //WARNING must not break for offsets that iterate to next line
                  {
                  }
               }
               //IntCipher += "\n";
            }
            marker += 1;
         }
         marker = 0; 
         if(i==0)
            break;
      }
      return IntCipher;
   }
   
   /* This method creates step like distruptions pre and secondary and adds them for use with fully encrypted message string */
   private static Map<String, String> SecondTransposition (String IntCipher, String LineR, int A, int B)//fixme
   {
      //LineR = "30274304287712"; //test point from known scholary source CIA doc "Number-One-From-Moscow" CIA HISTORICAL REVIEW PROGRAM 22 SEPT 93
      int limiter = (int) Math.ceil((double)IntCipher.length()/B);
      Map<String, String> cipher = new HashMap<>();
      Map<String, String> SecondStep = new HashMap<>();
      int linecounter = 0;
      int c = 49;
      char marker = (char)(c);
      int i = LineR.indexOf(marker);
      while(limiter > 0)
      {
         while(i<=B && limiter > 0)
         {
            try
            {
               cipher.put(""+linecounter, IntCipher.substring(0, i));
               IntCipher = IntCipher.substring(i);
               limiter -=1;
               i++;
               linecounter +=1;
            }
            catch(Exception e)
            {
               //System.out.println(e); //test point error locate
               break;
            }
         }
         c += 1;
         if (c == 58)
            c = 49;
         marker = (char)(c);
         i = LineR.indexOf((char)(marker));
      }
      linecounter = 0;
      cipher.put("Future Use", IntCipher);
      System.out.println("Pre Step-like disruption: \n\t"+cipher); //test point pre shift
      for(int q = 0; q<cipher.size()-1; q++)
      {
         String value = (cipher.get(q+""));
         if(q == cipher.size())
         {
            cipher.remove("Future Use");
            SecondStep.remove("Future Use");
            System.out.println("\nSecond Part of Step-like disruption: \n\t"+SecondStep);
            return cipher;
         }
         String finish = cipher.get("Future Use");
         String second_disruption = ""; 
         while(value.length()<B && finish.length()>0)
         {
            try
            {
               finish = cipher.get("Future Use"); 
               value+= finish.substring(0,1);
               second_disruption += finish.substring(0,1);
               finish = finish.substring(1);
               cipher.put("Future Use", finish);
            }
            catch(Exception e)
            {
               System.out.println(e+"\n"+cipher);
               break;
            }
         }
         cipher.put(q+"", value);
         SecondStep.put(q+"", second_disruption);
      }
      cipher.remove("Future Use");
      SecondStep.remove("Future Use");
      System.out.println("Second Part of Step-like disruption: \n"+SecondStep);
      return cipher;
   }
   
   /* This method must add the keygroup into the cipher as the required location marker in date is used last digit of date is used for placement */
   private static Map<String, String> final_transmitted_message(String ciphered, String date, String keygroup)
   {
      int length = ciphered.length();
      Map<String, String> transmit_message = new HashMap<>();
      int locater = ((ciphered.length()/5)+1)-(date.charAt(date.length()-1) - '0');
      int i = 5;
      int linenum = 0;
      while(ciphered.length()>0)
      {
         String five_group = ciphered.substring(0,i);
         ciphered = ciphered.substring(i);
         if(linenum == locater)
         {
            transmit_message.put(""+linenum, keygroup);
            linenum++;
         }
         transmit_message.put(""+linenum, five_group);
         linenum++;
      }
      return transmit_message;
   }
   
   /* This method iterates over the string and creates sets of 5 for transmit */
   private static void final_grid(Map<String, String> transmit_message)
   {
      System.out.println("\n\n\t\t\t\t\t    !!!! CIPHER TEXT !!!!");
      int i = 0;
      int s = 1;
      do{
         if(s%10!=0)
         {
            System.out.print(transmit_message.get(""+i)+" ");
            i++;
            s++;
         }
         else if (s%10==0)
         {
            System.out.println(transmit_message.get(""+i)+" ");
            i++;
            s++;
         }
      }while(transmit_message.get(""+i) != null);
      System.out.println();
   }
         
   /* This method is for the de-cipher button calls all sub methods used to create ciper text */        
   private static void de_cipher(int personal_num, String date, String keygroup, String Line_D, String cipher, String pre_agreed)
   {
      Line_D = Line_D.toUpperCase();
      String Line_e1 = (Line_D.substring(0,10));
      String Line_e2 = (Line_D.substring(10,20));
      String Line_c  = LineC(keygroup, date);
      System.out.println("LINE C:  "+Line_c);
      String Line_E1 = Sequence(Line_e1);
      String Line_E2 = Sequence(Line_e2);
      System.out.println("LINE E1: "+Line_E1+" LINE E2: "+Line_E2);
      String Line_F1 = LineC(Line_c);
      String Line_F2 = ("1234567890");
      System.out.println("LINE F1: "+Line_F1+" LINE F2: "+Line_F2);
      String Line_G = LineG(Line_E1, Line_F1);
      System.out.println("LINE G:  "+Line_G);
      String Line_H = LineH(Line_E2, Line_F2, Line_G);
      System.out.println("LINE H:  "+Line_H);
      String Line_J = LineJ(Line_H); 
      System.out.println("LINE J:  "+Line_J);
      String Line_K = ChainBlock(Line_H);
      System.out.println("LINE K:  "+Line_K);
      String Line_L = ChainBlock(Line_K);
      System.out.println("LINE L:  "+Line_L);
      String Line_M = ChainBlock(Line_L);
      System.out.println("LINE M:  "+Line_M);
      String Line_N = ChainBlock(Line_M);
      System.out.println("LINE N:  "+Line_N);
      String Line_P = ChainBlock(Line_N);
      System.out.println("LINE P:  "+Line_P);
      String Line_Q_Full = LineQ(Line_J, Line_K, Line_L, Line_M, Line_N, Line_P);
      String Line_Q = Line_Q_Permutation(Line_Q_Full, Line_P,  personal_num);
      System.out.println("LINE Q:  "+Line_Q);
      String Line_R = Line_R_Permutation(Line_Q_Full, Line_P, personal_num);
      System.out.println("LINE R:  "+Line_R);
      String Line_S = LineJ(Line_P);
      System.out.println("LINE S:  "+Line_S);
      Map <String, String> Mapper = CheckerBoard(Line_S, pre_agreed);
      System.out.println("MAPPED KEY:  \n\t"+Mapper);
      int transposition_A = transpositionA(Line_P, personal_num);
      int transposition_B = transpositionB(Line_P, personal_num);
      System.out.println("TRANSPOSITION A LENGTH: "+transposition_A);
      System.out.println("TRANSPOSITION B LENGTH: "+transposition_B);
      String TranspositionTwo = establish_Transposition_two_string(cipher, keygroup);
      System.out.println("\nTRANSPOSITION 2: \n\t"+TranspositionTwo);
      ArrayList<String>Appened = Appened_Checkerboard(TranspositionTwo, transposition_B, transposition_A, Line_R);
      System.out.println("\nCompleted Appended Step-like disruption:\n"+Appened);
      Map<String, String>Steps = attain_step(Appened, Line_R);
      System.out.println("\nPre Step-like disruption:\n"+Steps);
      String intermediatemessage = intermediate_message_formation(Steps);
      System.out.println("\nINTERMEDIATE FORM OF MESSAGE: \n"+intermediatemessage);
      ArrayList<String> establish_Transposition_one_string = Appened_Checkerboard(intermediatemessage, transposition_A, Line_Q);
      System.out.println("\nTRANSPOSITION 1: \n\t"+establish_Transposition_one_string);
      String raw_encoded = intermediate_message_formation(establish_Transposition_one_string);
      System.out.println("\n\nRAW ENCODED:   \n\t"+raw_encoded+"\n");
      System.out.println("Decrypted Message:\n\t"+decrypt(Mapper, raw_encoded));
   }
    
   /* This method locates and returns the keygroup used by way of the dates last digit */ 
   private static String get_keygroup(String date, String cipher)
   {
      Map<String, String> message = new HashMap<>();
      String[] token = cipher.split(" ");
      String current = "";
      for(int x=0; x<token.length; x++)
      {
         message.put(""+x,token[x]);
      }  
      String keygroup = message.get(""+(message.size()-Integer.parseInt(""+date.charAt(date.length()-1))));
      return keygroup;
   }          
 
   /* This method returns the full transposition two string */
   private static String establish_Transposition_two_string(String cipher, String keygroup)
   {
      String Transpositiontwo = "";
      String[] token = cipher.split(" ");
      String current = "";
      for(int x=0; x<token.length; x++)
      {
         if (token[x].equals(keygroup))
            continue; //orginal transposition does not include hidden keygroup this is added after must be removed for decryption
         Transpositiontwo+=(token[x]);
      }  
      return Transpositiontwo;
   }

   /* This method returns the Appened_Checkerboard to it's orginal state */
   private static ArrayList<String> Appened_Checkerboard(String cipher, int cols, int rows, String Line_R) //LineR as the mapper each must have a length to remove from cipher string in consecutive order with bottom row
   {
      ArrayList<String>Mapper_to_row_size = new ArrayList<>();
      ArrayList<String>Mapper_rows = new ArrayList<>();
      int num_of_rows = cipher.length()/cols;
      int digits_remainder = cipher.length()-(num_of_rows*cols);
      int s = 0;
      String hold = "";
      int check = 0;
      if(digits_remainder!=0)
      {
         for(int i = 0; i<Line_R.length()-(Line_R.length()-digits_remainder); i++)
         {
            Mapper_to_row_size.add(""+Line_R.charAt(i)+" "+(num_of_rows+1));
            s = i;
         }
         s++;
      }
      while(Mapper_to_row_size.size()<Line_R.length())
      {
         Mapper_to_row_size.add(""+Line_R.charAt(s)+" "+(num_of_rows));
         s++;
      }
      Mapper_rows = new ArrayList<String>(Mapper_to_row_size);
      for(int i = 1; i<=10; i++)
      {
         for(int j = 0; j<Mapper_to_row_size.size(); j++)
         {
            hold = Mapper_to_row_size.get(j);
            if(i == 10)
               i = 0;
            if(i == Integer.parseInt(""+hold.charAt(0)))
            {
               try
               {
                  if(hold.length() == 3)
                  {
                     Mapper_rows.set(j, cipher.substring(0, Integer.parseInt(""+hold.charAt(2))));  //test point for Line_R replacement order
                     cipher =  cipher.substring(Integer.parseInt(""+hold.charAt(2)));
                  }
                  else if (hold.length() == 4)
                  {
                     check = Integer.parseInt(""+hold.charAt(2)+""+hold.charAt(3));
                     Mapper_rows.set(j, cipher.substring(0, Integer.parseInt(""+hold.charAt(2)+""+hold.charAt(3))));  //test point for Line_R replacement order
                     cipher =  cipher.substring(Integer.parseInt(""+hold.charAt(2)+""+hold.charAt(3)));
                  }
               }
               catch (Exception e)
               {
                  Mapper_rows.set(j, cipher.substring(0));
                  cipher =  "";
                  break;
               }
            }
         }
         if(i==0)
            break;
      }
      ArrayList<String>Appeneded = new ArrayList<>();
      for(String k: Mapper_rows)
      {
         for (int i = 0; i<k.length(); i++)
         {
            try
            {
               String setter = Appeneded.get(i);
               setter += k.charAt(i);
               Appeneded.set(i, setter);
            }
            catch(Exception e)
            {
               Appeneded.add(""+k.charAt(i));
            }
         } 
      }
      return Appeneded;
   }

   /* This method returns the transposition one string by way of finding the orginal coloums */
   private static ArrayList<String> Appened_Checkerboard(String message, int rows, String Line_Q) //LineR as the mapper each must have a length to remove from cipher string in consecutive order with bottom row
   {
      ArrayList<String>Mapper_to_row_size = new ArrayList<>();
      int num_of_rows = message.length()/rows;
      int digits_remainder = message.length()-(num_of_rows*rows);
      int s = 0;
      String hold = "";
      if(digits_remainder!=0)
      {
         for(int i = 0; i<Line_Q.length()-(Line_Q.length()-digits_remainder); i++)
         {
            Mapper_to_row_size.add(""+Line_Q.charAt(i)+" "+(num_of_rows+1));
            s = i;
         }
         s++;
      }
      while(Mapper_to_row_size.size()<Line_Q.length())
      {
         Mapper_to_row_size.add(""+Line_Q.charAt(s)+" "+(num_of_rows));
         s++;
      }
      for(int i = 1; i<=10; i++)
      {
         for(int j = 0; j<Mapper_to_row_size.size(); j++)
         {
            hold = Mapper_to_row_size.get(j);
            if ((hold.length() == num_of_rows+1 || hold.length() == num_of_rows))
               continue;
            if(i == 10)
               i = 0;
            if(i == Integer.parseInt(""+hold.charAt(0)))
            {
               if(hold.length() == 3)
               {
                  Mapper_to_row_size.set(j, message.substring(0, Integer.parseInt(""+hold.charAt(2))));  //test point for Line_R replacement order
                  message =  message.substring(Integer.parseInt(""+hold.charAt(2)));
               }
               else if (hold.length() == 4)
               {
                  Mapper_to_row_size.set(j, message.substring(0, Integer.parseInt(""+hold.charAt(2)+""+hold.charAt(3))));  //test point for Line_R replacement order
                  message =  message.substring(Integer.parseInt(""+hold.charAt(2)+""+hold.charAt(3)));
               }
            }
         }
         if(i==0)
            break;
      }
      ArrayList<String>Appeneded = new ArrayList<>();
      for(String k: Mapper_to_row_size)
      {
         for (int i = 0; i<k.length(); i++)
         {
            try
            {
               String setter = Appeneded.get(i);
               setter += k.charAt(i);
               Appeneded.set(i, setter);
            }
            catch(Exception e)
            {
               Appeneded.add(""+k.charAt(i));
            }
         } 
      }
      return Appeneded;
   }
   
   /* This method returns the steps that were used in the checkerboard */
   private static Map<String, String> attain_step(ArrayList<String> Appened, String Line_R)
   {
      Map<String, String> step_rem = new HashMap<>();
      String partA = "";
      String partB = "";
      int len = 0;
      int counter = 0;
      int u = 0;
      for(int i = 1; i<10; i++)
      {
         for(int q = 0; q<Line_R.length(); q++)
         {
            if(Line_R.charAt(q) - '0' == i)
            {
               partA = Appened.get(u).substring(0, q);
               len = partA.length();
               partB += Appened.get(u).substring(q);
               step_rem.put(""+counter, partA);
               counter++;
               u++;
               int y = q+1;
               while(len<Line_R.length())
               {
                  try
                  {
                     if(Appened.get(u).length()<y)
                     
                        break;
                     partA = Appened.get(u).substring(0, y);
                     partB += Appened.get(u).substring(y);
                     step_rem.put(""+counter, partA);
                     counter++;
                     u++;
                     y++;
                     len++;
                  }
                  catch(Exception IndexOutOfBoundsException)
                  {
                     step_rem.put("Future Use", partB);
                     return step_rem;
                  } 
               }
            }
         }    
      }       
      return step_rem;
   }

   /* This method will return the string value of the intermediate message */
   private static String intermediate_message_formation (Map<String, String> Steps)
   {
      String message = "";
      for(int i=0; i<Steps.size()-1; i++) //must be for loop because of elements over 10 are not in order gets by key use
      {
         message += Steps.get(""+i);
      }
      message += Steps.get("Future Use");
      return message;
   }
   
   /* This method will return the transpoition 2 of the message */
   private static String intermediate_message_formation (ArrayList<String> Steps)
   {
      String message = "";
      for (String value: Steps)
      {
         message += value;
      }
      return message;
   }

   /* This method now that all parts have been found will return the cipher back to text form with no spaces however */
   private static String decrypt(Map <String, String> Mapper, String raw_encoded) //fix me must use numerical formation also and slash locater 
   {
      String decrypted_message = "";
      String two_digit = "";
      String slash = "";
      for (var value: Mapper.entrySet()) //locate two digits used for right part of checkerboard 
      {
         if(two_digit.length() == 2)
            break;
         else if(value.getValue().equals(" ")) //space value means row finder key
            two_digit+=value.getKey(); //continue until both spacer items are found
      }
      for(var value: Mapper.entrySet()) // used to find key for '/' for use if numerical entry is used
      {
         if(value.getValue().equals("/")) //used to seperate numbers
         {
            slash = value.getKey();
            break;
         }
      } 
   
      String num_two = "";
      boolean flag = false;
      for(int i = 0; i<raw_encoded.length(); i++)
      {
         String j = raw_encoded.charAt(i)+"";
         if(j.equals(two_digit.charAt(0)+"") || j.equals(two_digit.charAt(1)+"")) //condition for dual digits use
         {
            j+= raw_encoded.charAt(i+1);
            i++;
            if(j.equals(slash) || flag) //condition for numerical rules repeated numbers after slashes
            {
               flag = true; //flag for repeated digits in sets
               i++;
               while(flag)
               {
                  decrypted_message += raw_encoded.charAt(i);
                  i+=3;
                  String q = raw_encoded.charAt(i)+""+raw_encoded.charAt(i+1); //check for slash after last entry
                  if(q.equals(slash)) //if slash found exit num mode
                  {
                     flag = false;
                     i+=1;
                     break;
                  }
               }
            }
            else if(!j.equals(slash) || flag) //else if so slashes do not show on screen
            {
               decrypted_message += Mapper.get(j);
            }
            continue; // now continue
         }
         decrypted_message += Mapper.get(j); //single entry item outside of 2 digit grid
      }
      return decrypted_message;
   }
}