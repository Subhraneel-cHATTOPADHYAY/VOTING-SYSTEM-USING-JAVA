import java.util.Scanner;
class UnderAgeException extends RuntimeException{
    public UnderAgeException(){
        super("UNDERAGE:CANNOT VOTE");
    }
    public UnderAgeException(String msg){
        super(msg);
    }
}
class IncorrectAadharException extends RuntimeException{
    public IncorrectAadharException(){
        super("INCORRECT AADHAR FORMAT");
    }
    public IncorrectAadharException(String msg){
        super(msg);
    }
}
interface A{
    void show();
    default void fun(){
        System.out.println("WELCOME TO ELECTION 2024:");
    }
}
class citizen implements A{
    int aadharno;
    String name;
    public citizen(int a,String b){
        aadharno=a;
        name=b;
    }
    public void show(){
        System.out.println("THE NAME ENTERED="+name);
        if(aadharno>1000000 && aadharno<10000000){
            System.out.println("THE AADHAR CARD NUMBER ENTERED="+aadharno);
        }
        else{
            try{
                throw new IncorrectAadharException();
            }
            catch(IncorrectAadharException e){
                System.out.println(e);
            }
        }
    }
}
class vote extends citizen{
    int age;
    public vote(int a,String b,int c){
        super(a,b);
        age=c;
    }
    public void gtinfo(){
        if(age>=18){
            System.out.println("YES, ELIGIBLE TO VOTE:");
        }
        else{
            try{
                throw new UnderAgeException();
            }
            catch(UnderAgeException e){
                System.out.println(e);
            }
        }
    }
    public void show1(){
        System.out.println("THANK YOU FOR VOTING PARTY 1:");
    }
    public void show2(){
        System.out.println("THANK YOU FOR VOTING PARTY 2:");
    }
    public void show3(){
        System.out.println("THANK YOU FOR VOTING PARTY 3:");
    }
}
public class Main{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int v;
        /*int a1;
        String a2;
        System.out.println("ENTER YOUR AADHAR NUMBER:");
        a1=sc.nextInt();
        System.out.println("ENTER YOUR NAME:");
        a2=sc.next();*/
        vote v1=new vote(764352675,"VIRAT KOHLI",19);
        v1.fun();
        v1.show();
        v1.gtinfo();
        System.out.println("PRESS 1 FOR PARTY 1:");
        System.out.println("PRESS 2 FOR PARTY 2:");
        System.out.println("PRESS 3 FOR PARTY 3:");
        System.out.println("ENTER YOUR VOTE:");
        v=sc.nextInt();
        if(v==1){
            v1.show1();
        }
        else if(v==2){
            v1.show2();
        }
        else if(v==3){
            v1.show3();
        }
        else{
            System.out.println("INVALID OPTION:");
        }
    }
}