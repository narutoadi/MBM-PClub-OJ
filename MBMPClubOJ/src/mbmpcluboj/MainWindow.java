/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mbmpcluboj;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import javax.swing.JFrame;
import javax.swing.*;
/**
 *
 * @author aditi
 */
public class MainWindow extends JFrame implements ActionListener{

    String[] Questions,Inputs,Outputs;
    int QuestionOnDisplay,OutputOnDisplay,totalSubmissions;
    JTextArea tareaQuestion,tareaCode,tareaOutput,tareaDashBoard;
    JComboBox cmbLang;
    JLabel lblTodo,lblOutputNo;
    JButton btnDashBoard,btnPrev,btnNext,btnSubmitCode,btnSubmitC,btnSubmitOut,btnAdmin,btnStudent,btnBack,btnOutNext,btnCorrOut;
    JScrollPane jspTareaCode,jspTareaOutput;
    CorrectOut[] coutColl;
    MainWindow()
    {
        this.totalSubmissions=0;
        this.coutColl= new CorrectOut[6];
        this.OutputOnDisplay=1;
        this.QuestionOnDisplay=1;
        this.btnAdmin= new JButton("Admin");
        this.btnStudent= new JButton("Student");
        this.setLayout(null);
        Toolkit tool=Toolkit.getDefaultToolkit();;
        Dimension size=tool.getScreenSize();
        this.setBounds(0, 0,size.width-5,size.height);
        this.setResizable(false);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.add(this.btnAdmin);
        this.add(this.btnStudent);
        this.btnAdmin.setBounds(this.getWidth()/2-50, this.getHeight()/2-30, 100, 20);
        this.btnStudent.setBounds(this.getWidth()/2-50, this.getHeight()/2+30, 100, 20);
        this.btnAdmin.setVisible(true);
        this.btnStudent.setVisible(true);
        this.btnDashBoard=new JButton("DashBoard");
        this.add(this.btnDashBoard);
        this.btnDashBoard.setBounds(this.getWidth()/2-50, this.getHeight()/2+90, 100, 20);
        this.btnDashBoard.setVisible(true);
        this.tareaDashBoard=new JTextArea();
        this.add(this.tareaDashBoard);
        this.tareaDashBoard.setBounds(10, 10, this.getWidth()-100, this.getHeight()-100);
       // this.tareaDashBoard.setEnabled(false);
        this.tareaDashBoard.setVisible(false);
        this.setVisible(true);
        this.btnAdmin.addActionListener(this);
        this.btnStudent.addActionListener(this);
        String[] Langs={"C","C++"};
        this.cmbLang = new JComboBox(Langs);
        this.add(this.cmbLang);
        this.cmbLang.setBounds(10,10,100,30);
        this.cmbLang.setVisible(false);
        this.lblTodo = new JLabel("");
        this.add(this.lblTodo);
        this.lblTodo.setBounds(10,40,this.getWidth(),30);
        this.lblTodo.setVisible(false);
        this.tareaCode = new JTextArea();
        this.btnSubmitC = new JButton("Submit Code");
        this.add(this.btnSubmitC);
        this.btnSubmitC.setBounds(this.getWidth()/2-80, this.getHeight()-100,160,30);
        this.btnSubmitC.setVisible(false);
        this.btnBack=new JButton("Back");
        this.add(this.btnBack);
        this.btnBack.setBounds(this.getWidth()-160,this.getHeight()-100,100,30);
        this.btnBack.setVisible(false);
        this.jspTareaCode=new JScrollPane(this.tareaCode,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        this.add(this.jspTareaCode);
        this.jspTareaCode.setBounds(10, 70, this.getWidth()-100, this.getHeight()-180);
        this.jspTareaCode.setVisible(false);
        this.btnSubmitOut=new JButton("Submit Output");
        this.add(this.btnSubmitOut);
        this.btnSubmitOut.setBounds(this.getWidth()/2-80, this.getHeight()-100,160,30);
        this.btnSubmitOut.setVisible(false);
        String[] Question={"Question: 1\n \n "
                + "Ram_Peyare is a good mathematician but he now want to extend his field and want to learn cryptography as well . So , in order to test him Sita_Piyare give him a question in which she\n " +
"will give two strings and ask minimum number of charcters to be removed in order to make both the string anagram. Anagram is a string formed by rearranging the characters of the string (without any insertion or deletion of character).\n " +
"\n " +
"Input Format:-\n " +
"Given an integer T as number of test cases . In each test case you are given two strings (can be of different length) .\n " +
"Both the strings contains lowercase letters only.\n " +
"\n " +
"Output Format:-  \n " +
"For each test case print the minimum number of characters to be removed.\n " +
"\n " +
"Input:-\n " +
"1\n " +
"cde\n " +
"abc\n " +
"\n " +
"Output:-\n " +
"4\n " +
"\n " +
"Constraint:-\n " +
"1<=T<=100\n " +
"Length of the Strings<=1000\n " +
"\n " +
"Explanation:-\n " +
"\n " +
"We need to delete 4 characters to make both strings anagram i.e. 'd' and 'e' from first string and 'b' and 'a' from second string. ","Question: 2\n \n "
                + "This question is quiet simple . You are given four points you have to check if the line segment formed by joining first two points intersect other line segment formed by last two point.\n " +
"\n " +
"Input format:-\n " +
"Given T as the number of test cases. And for each test case you are given four points. \n " +
"\n " +
"Output format:-\n " +
"'Yes' if they intersect else 'No' if they don't.\n " +
"\n " +
"constraint:-\n " +
"1<=T<=1000\n " +
"1<=X,Y<=1000\n " +
"\n " +
"Input:-\n " +
"1\n " +
"4 5\n " +
"6 7\n " +
"1 1\n " +
"2 2\n " +
"\n " +
"Output:-\n " +
"No\n " +
"\n " +
"Explaination:-\n " +
"Simplly the segment formed by first two points don't intersect the segment formed by the last two.\n " +
"\n " +
"  \n " +
"","Question: 3\n \n "
                + "A H.R guy from a jodhpur based startup  is here in MBM looking for smart students.But everyone seems to be eligible since all of you passed the technical rounds. \n " +
"So to test their intelligence, he plays a game.The students have to stand in a line. They are given the numbers in the order in which they stand, starting from 1. \n " +
"The HR guy then removes all the students that are standing at an odd position.\n " +
"Initially, standing people have numbers - 1,2,3,4,5...\n " +
"After first pass, people left are - 2,4,...\n " +
"After second pass - 4,....\n " +
"And so on.\n " +
"You want to join this amazing startup.Given the total number of applicants for a position, find the best place to stand in the line so that you are selected.\n " +
"Input\n " +
"First line contains the number of test cases t (t<=10^5). The next t lines contain integer n, the number of applicants for that case. (n<=10^9)\n " +
"\n " +
"Output\n " +
"\n " +
"Display t lines, each containg a single integer, the place where you would stand to get the dream job.\n " +
"Example\n " +
"\n " +
"Input:\n " +
"2\n " +
"5\n " +
"12\n " +
"\n " +
"Output:\n " +
"4\n " +
"8","Question: 4\n \n "
                + "There are K langoors near Tirupati Balaji Temple and You have N bananas. You have to give away all your bananas to langoors. \n " +
"Langoors are happy if all of them get the same number of bananas (even if they don't get any). \n " +
"In one minute You can do one of the following:\n " +
"    * Find one banana.\n " +
"    * Discard one banana (eat).\n " +
"    * Increase a population of langoors by one. (langoor  will come if you whistle).\n " +
"    * If there are at least two langoors remove one of them from temple premises.\n " +
"\n " +
"Help yourself and find the minimum number of minutes you needs to satisfy all the langoors.\n " +
"\n " +
"STDIN Instruction:\n " +
"First line will be no. of test cases T.\n " +
"For each next T lines , there will two number N and K respectively.\n " +
"\n " +
"Constraints:\n " +
" T=15\n " +
" 0<=N,K <=10^5\n " +
" \n " +
" \n " +
" Sample Input:\n " +
"2\n " +
"35 15\n " +
"1 10\n " +
"Sample Output:\n " +
" 3\n " +
" 1\n " +
" Explaination:\n " +
" For N=35  and K=15, You  can eat a banana and increase langoors by 2 such that N=34 and K=17 and now you can distribute all banans amongs langoors uniformly.\n " +
" ","Question: 5\n \n "
                + "After you had helped George and Alex to move in the dorm, they went to help their friend Fedor play a new computer game «Call of Soldiers 3».\n " +
"The game has (m + 1) players and n types of soldiers in total. Players «Call of Soldiers 3» are numbered form 1 to (m + 1). Types of soldiers are numbered from 0 to n - 1. Each player has an army. Army of the i-th player can be described by non-negative integer xi. Consider binary representation of xi: if the j-th bit of number xi equal to one, then the army of the i-th player has soldiers of the j-th type.\n " +
"Fedor is the (m + 1)-th player of the game. He assume that two players can become friends if their armies differ in at most k types of soldiers (in other words, binary representations of the corresponding numbers differ in at most k bits). Help Fedor and count how many players can become his friends.\n " +
"Input\n " +
"The first line contains three integers n, m, k (1 ≤ k ≤ n ≤ 20; 1 ≤ m ≤ 1000).\n " +
"The i-th of the next (m + 1) lines contains a single integer xi (1 ≤ xi ≤ 2n - 1), that describes the i-th player's army. We remind you that Fedor is the (m + 1)-th player.\n " +
"Output\n " +
"Print a single integer — the number of Fedor's potential friends.\n " +
"Examples\n " +
"input\n " +
"7 3 1\n " +
"8\n " +
"5\n " +
"111\n " +
"17\n " +
"output\n " +
"0\n " +
"input\n " +
"3 3 3\n " +
"1\n " +
"2\n " +
"3\n " +
"4\n " +
"output\n " +
"3","Question: 6\n \n "
                + "Jack decides to invite Emma out for a dinner. Jack is a modest student, he doesn't want to go to an expensive restaurant. Emma is a girl with high taste, she prefers elite places.\n " +
"Munhattan consists of n streets and m avenues. There is exactly one restaurant on the intersection of each street and avenue. The streets are numbered with integers from 1 to n and the avenues are numbered with integers from 1 to m. The cost of dinner in the restaurant at the intersection of the i-th street and the j-th avenue is cij.\n " +
"Jack and Emma decide to choose the restaurant in the following way. Firstly Emma chooses the street to dinner and then Jack chooses the avenue. Emma and Jack makes their choice optimally: Emma wants to maximize the cost of the dinner, Jack wants to minimize it. Emma takes into account that Jack wants to minimize the cost of the dinner. Find the cost of the dinner for the couple in love.\n " +
"Input\n " +
"The first line contains two integers n, m (1 ≤ n, m ≤ 100) — the number of streets and avenues in Munhattan.\n " +
"Each of the next n lines contains m integers cij (1 ≤ cij ≤ 109) — the cost of the dinner in the restaurant on the intersection of the i-th street and the j-th avenue.\n " +
"Output\n " +
"Print the only integer a — the cost of the dinner for Jack and Emma.\n " +
"Examples\n " +
"input\n " +
"3 4\n " +
"4 1 3 5\n " +
"2 2 2 2\n " +
"5 4 5 1\n " +
"output\n " +
"2\n " +
"input\n " +
"3 3\n " +
"1 2 3\n " +
"2 3 1\n " +
"3 1 2\n " +
"output\n " +
"1\n " +
"Note\n " +
"In the first example if Emma chooses the first or the third streets Jack can choose an avenue with the cost of the dinner 1. So she chooses the second street and Jack chooses any avenue. The cost of the dinner is 2.\n " +
"In the second example regardless of Emma's choice Jack can choose a restaurant with the cost of the dinner 1."};
     this.Questions=Question;
     String[] Input={"","","","","",""};
     this.Inputs=Input;
     
     
     
     this.tareaQuestion=new JTextArea(Questions[0]);
     
     
     this.btnNext = new JButton(" Next       >> ");
     this.btnPrev = new JButton(" <<   Previous ");
     this.btnSubmitCode = new JButton("Submit");
     this.add(this.tareaQuestion);
     this.tareaQuestion.setBounds(0, 0, this.getWidth()-0, this.getHeight()-120);
     this.tareaQuestion.setEditable(false);
     this.tareaQuestion.setWrapStyleWord(true);
        this.tareaQuestion.setLineWrap(true);
     this.add(this.btnNext);
     this.add(this.btnPrev);
     this.add(this.btnSubmitCode);     
     this.btnPrev.setBounds(0, this.getHeight()-110, 200, 50);
     this.btnPrev.setVisible(false);
     this.btnNext.setBounds(this.getWidth()-200,this.getHeight()-110,200,50);
     this.btnNext.setVisible(false);
     this.btnSubmitCode.setBounds(this.getWidth()/2-100, this.getHeight()-110, 200, 50);
     this.btnSubmitCode.setVisible(false);
     this.btnPrev.setEnabled(false);
     this.tareaQuestion.setVisible(false);
     this.lblOutputNo=new JLabel(this.OutputOnDisplay+"");
     this.add(this.lblOutputNo);
     this.lblOutputNo.setBounds(10,10,100,30);
     this.lblOutputNo.setVisible(false);
     this.tareaOutput = new JTextArea();
     this.jspTareaOutput=new JScrollPane(this.tareaOutput,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
     this.add(this.jspTareaOutput);
     this.jspTareaOutput.setBounds(10, 70, this.getWidth()-100, this.getHeight()-180);
     this.jspTareaOutput.setVisible(false);
     this.btnOutNext = new JButton("Next");
     this.add(this.btnOutNext);
     this.btnOutNext.setBounds(10,this.getHeight()-100,100,30);
     this.btnOutNext.setVisible(false);
     this.btnCorrOut = new JButton("Update");
     this.add(this.btnCorrOut);
     this.btnCorrOut.setBounds(this.getWidth()/2-50, this.getHeight()-100, 100,30);
     this.btnCorrOut.setVisible(false);
     this.btnNext.addActionListener(this);
     this.btnPrev.addActionListener(this);
     this.btnSubmitCode.addActionListener(this);
     this.btnBack.addActionListener(this);
     this.btnSubmitC.addActionListener(this);
     this.btnCorrOut.addActionListener(this);
     this.btnOutNext.addActionListener(this);
     this.btnSubmitOut.addActionListener(this);
     this.btnDashBoard.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()==this.btnDashBoard)
        {
            this.btnBack.setVisible(true);
            this.btnAdmin.setVisible(false);
            this.btnStudent.setVisible(false);
            this.btnDashBoard.setVisible(false);
            File file=new File("submissions.stk");
            if(!file.exists()){
                this.tareaDashBoard.setText("No Submission by you !");
            }
            else
            {
                try{
                    FileInputStream fin=new FileInputStream("submissions.stk");
                ObjectInputStream in=new ObjectInputStream(fin);
                Submissions sub;
                String s=new String("");
                int i=0,j;
           //     System.out.print(this.totalSubmissions);
               
                while(in.available()>=0)
                {
                    sub=(Submissions)in.readObject();
                    System.out.println("dmfad");
                    
                    s=sub.Ques+"\t"+sub.Status+"\n";
                    System.out.println(s);
                    this.tareaDashBoard.append(s);
                    
                }
         //       this.tareaDashBoard.setText(s);
                in.close();
                fin.close();
                }catch(Exception ex)
                {
                    System.out.print(ex);
                }
            }
            this.tareaDashBoard.setVisible(true);
        }
        
        if(e.getSource()== this.btnAdmin)
        {
            
            this.btnDashBoard.setVisible(false);
            JLabel jPassword = new JLabel("Password");
                JTextField password = new JPasswordField();
                Object[] ob = { jPassword, password};
                int result = JOptionPane.showConfirmDialog(null, ob, "Please Enter The Admin Password ", JOptionPane.OK_CANCEL_OPTION);
                String passwordValue = password.getText();
                
             if(!passwordValue.equals(CommRes.Passwd))  
             {
              
                 JOptionPane.showMessageDialog(this, "Wrong Password !!!");
                 
             }
             else if(result == JOptionPane.OK_OPTION)
             {
                 
                 this.btnAdmin.setVisible(false);
                 this.btnStudent.setVisible(false);
                 this.btnBack.setVisible(true);
                 this.lblOutputNo.setVisible(true);
                 this.jspTareaOutput.setVisible(true);
                 this.btnCorrOut.setVisible(true);
                 this.btnOutNext.setVisible(true);
             }
        }
        if(e.getSource()== this.btnStudent)
        {
                 this.btnDashBoard.setVisible(false);
                 this.btnAdmin.setVisible(false);
                 this.btnStudent.setVisible(false);
                 this.tareaQuestion.setVisible(true);
                 this.btnPrev.setVisible(true);
                 this.btnSubmitCode.setVisible(true);
                 this.btnNext.setVisible(true);
                 
        }
        if(e.getSource()== this.btnPrev)
        {
            this.QuestionOnDisplay--;
            this.tareaQuestion.setText(this.Questions[this.QuestionOnDisplay-1].toString());
            if(this.QuestionOnDisplay==6)
                this.btnNext.setEnabled(false);
            else
                this.btnNext.setEnabled(true);
            if(this.QuestionOnDisplay==1)
                this.btnPrev.setEnabled(false);
            else
                this.btnPrev.setEnabled(true);
        }
        if(e.getSource()== this.btnNext)
        {
            this.QuestionOnDisplay++;
            this.tareaQuestion.setText(this.Questions[this.QuestionOnDisplay-1].toString());
            if(this.QuestionOnDisplay==6)
                this.btnNext.setEnabled(false);
            else
                this.btnNext.setEnabled(true);
            if(this.QuestionOnDisplay==1)
                this.btnPrev.setEnabled(false);
            else
                this.btnPrev.setEnabled(true);
            
        }
        if(e.getSource()==this.btnSubmitCode)
        {
            this.tareaQuestion.setVisible(false);
            this.btnNext.setVisible(false);
            this.btnPrev.setVisible(false);
            this.btnSubmitCode.setVisible(false);
            this.cmbLang.setVisible(true);
            this.lblTodo.setText("Paste Your Code Here. ");
            this.lblTodo.setVisible(true);
            this.jspTareaCode.setVisible(true);
            this.btnSubmitC.setVisible(true);
            this.btnBack.setVisible(true);
        }
        if(e.getSource()==this.btnBack)
        {
            this.tareaDashBoard.setVisible(false);
            this.btnDashBoard.setVisible(false);
            this.cmbLang.setVisible(false);
            this.btnSubmitOut.setVisible(false);
            this.lblTodo.setVisible(false);
            this.jspTareaCode.setVisible(false);
            this.btnSubmitC.setVisible(false);
            this.btnBack.setVisible(false);
            this.tareaQuestion.setVisible(true);
            this.btnNext.setVisible(true);
            this.btnPrev.setVisible(true);
            this.btnSubmitCode.setVisible(true);
            this.btnOutNext.setVisible(false);
            
        }
        if(e.getSource()==this.btnSubmitC)
        {
            this.cmbLang.setVisible(false);
            try{
                    String file = "Code"+this.cmbLang.getSelectedItem().toString()+this.QuestionOnDisplay+".txt";
                    PrintWriter writer = new PrintWriter(file, "UTF-8");
                    writer.print(this.tareaCode.getText());
                    writer.close();
            }catch(Exception ex){
                JOptionPane.showMessageDialog(null, "Problem while Saving","Submission",JOptionPane.ERROR_MESSAGE);
            }
            this.lblTodo.setText("Paste the output for Input"+this.QuestionOnDisplay+" Below :");
            this.tareaCode.setText(this.Inputs[this.QuestionOnDisplay-1]);
            this.btnSubmitC.setVisible(false);
            this.btnSubmitOut.setVisible(true);
            this.tareaCode.setText("");
        }
        if(e.getSource()==this.btnOutNext)
        {
            this.OutputOnDisplay=(this.OutputOnDisplay)%6+1;
            this.lblOutputNo.setText(this.OutputOnDisplay+"");
        }
        if(e.getSource()==this.btnCorrOut)
        {
            CorrectOut cout = new CorrectOut();
            cout.Ques=this.OutputOnDisplay;
            cout.Out=this.tareaOutput.getText();
            this.coutColl[this.OutputOnDisplay-1]=cout;
            
        try{
            FileOutputStream fout=new FileOutputStream("cout.stk",false);
            ObjectOutputStream out=new ObjectOutputStream(fout);
            out.writeObject(this.coutColl);
            out.close();
            fout.close();
        }catch(Exception ex){
            System.out.print(ex);
            JOptionPane.showMessageDialog(null, "Problem while Saving output files!!!","Admin Panel",JOptionPane.ERROR_MESSAGE);
        }
    
        this.tareaOutput.setText("");

        }
        if(e.getSource()==this.btnSubmitOut)
        {
            this.totalSubmissions++;
            String x=this.tareaCode.getText();
            try
            {
                FileInputStream fin=new FileInputStream("cout.stk");
                ObjectInputStream in=new ObjectInputStream(fin);
                FileOutputStream fout=new FileOutputStream("submissions.stk",true);
                ObjectOutputStream out=new ObjectOutputStream(fout);
                Submissions sub = new Submissions();
                sub.Ques=this.QuestionOnDisplay;
                CorrectOut cout;
                this.coutColl=(CorrectOut[]) in.readObject();
                cout=this.coutColl[this.QuestionOnDisplay-1];
                String y=cout.Out;
                if(x.equals(y))
                {
                    JOptionPane.showMessageDialog(null, "Correct Answer :) :) :) ","Result",JOptionPane.PLAIN_MESSAGE);
                    sub.Status="AC";
                    out.writeObject(sub);
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Wrong Answer!!!","Result",JOptionPane.PLAIN_MESSAGE);
                    sub.Status="WA";
                    out.writeObject(sub);
                }
                in.close();
                fin.close();
                out.close();
                fout.close();
            }catch(Exception ex)
            {
                System.out.print(ex);
            }
        }
                
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
