package chapter4;

/**
 *
 * @author huanj
 * 
 * To change between different class executions, rename unwanted class' main method to main1 and desired to main
 * 
 */  
 //taken from page 203 of OCA book
class A {
    private String name = "Torchie";
    {System.out.println(name); }
    private static int COUNT = 0;
    static { System.out.println(COUNT); }
    static { COUNT += 10; System.out.println(COUNT); }
    
    public A() {
        System.out.println("constructor");
    }  
}


class A_1 {    
    public static void main1(String[] args) {
        A init = new A(); //this alone prints out 4 elements
    }
}

/* -Explanation-
Order of Initialization 
1) Super Class 
    //there is no super class in this case
2) static variable declarations and initializers (in order they appear)
    //statics are on line 14 15 16 with output: 0\n10\n 
    //note: static main executes AFTER all other statics blocks in same class
3) instance variable declarations and initializers (in order they appear)
    //instances are on line 12 13 with output: Torchie\n 
4) the constructor 
    //implementation for the constructor is on line 18 19 20 and outputs: constructor\n
*/

//taken from page 203 of OCA book
class B {
    private String name = "Torchie";
    { System.out.println(name); }
    private static int COUNT = 0;
    static { System.out.println(COUNT); }
    { COUNT++; System.out.println(COUNT);}
    public B() {
        System.out.println("constructor");
    }
    
    public static void main1(String[] args) {
        System.out.println("read to construct");
        new B();
    }
}

/*
1) Super Class 
    //there is no super class in this case
2) static variable declarations and initializers (in order they appear)
    //statics are on line 47 48 54
    //output: 0\nread to construct
3) instance variable declarations and initializers (in order they appear)
    //instances are on line 45 46 49
    //output: Torchie\n1
    //NOTE: this part will not run if no instance (via new operator)
4) the constructor 
    //constructor is on line 50 51 52
    //output: constructor
*/


//relatively 'hard' example taken from page 204 of OCA book
public class C{
    static { add(2); }
    static void add(int num) { System.out.print(num + " "); }
    C() { add(5); }
    static { add(4); }
    { add(6); }
    static { new C(); }
    { add(8); }
    public static void main1(String[] args){}
}

/*
1) Super Class 
    //there is no super class in this case
2) static variable declarations and initializers (in order they appear)
    statics are on line 78 81 83 85
    //output: 2 4 
3) instance variable declarations and initializers (in order they appear)
    //instances are on line 82 84 
    //output: 6 8 
    //NOTE: this part will not run if no instance (no new operator)
4) the constructor 
    //constructor is on line 80
    //output: 5

    //total output: 2 4 6 8 5
*/