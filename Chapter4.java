package chapter4;

/**
 *
 * @author huanj
 * CHAPTER 4: Methods and Encapsulation
 *
 * SUMMARY: 
 * 
 *(1)method signature analysis
 *      1.1* access modifiers
 *(2)static 
 *      2.1 calling rules
 *      2.2** import syntax  //in class Chapter4_2 of package chapter4_1
 *
 *(3)method overloading
 *      3.1* autoboxing revisited
 *(4)Constructors
 *      4.1* default constructor
 *      4.2* overloading 
 *(5)Order of initialization 
 *      //in class Chapter4_3
 *(6)Encapsulation //class Dragon follows JavaBean
 *      6.1* motivation/purpose
 *      6.2* JavaBeans naming convention
 *      6.3* Immutability
 *(7) Lambdas
 */
public class Chapter4 {
    public static int a=11;
    protected static int b=22;
    static int c=33;
    private static int d=44;
    
    public static void main1(String... args) throws Exception { //throws clause is required because a.A() requires it
        // TODO code application logic here
        Chapter4 a = new Chapter4();

        a.A(); //nonstatic method members require an instance of the class to execute

        System.out.println(a.B());

        C();
        
        D();
        D(4.0);
        D(5);
        a.D(9,0);
        //autoboxing test runs
        F(4);//no int implementation -> implicitly expands into a float
        F(4.0); //double primitive not found so autoboxed into Double object
        F('c'); //character is approximately same as int value wise-> implicitly casted to float
        F((byte)3); //explicitly casted into byte type
        F((short)3); //explicitly casted into short type--> implicitly casted into float
    
    }
    /*
    (1) Method Signature
    accessModifier, optionalSpecifier, returnType, methodName(parameters) <optional exception> {}
    1.1* accessModifer (public, protected, (default), private)
        
        public- method is accessible from any class as long as it has proper import
        protected- method is accessible from same class, same package, and children 
        (default)- method is accessible from same class and same package
        private- method is only accesible from same class
        
        ***optionalSpecifiers - will be covered in Ch5
        
        throws keyword- tell us it may throw an exception 
    */
    private final double A() throws Exception{ 
        System.out.println("sss");
        return 5.0;
    }
    /* 
    1.1* accessModifier(cont.)
    -ONLY returnType and methodName +required, other parts are optional
    -since accessModifer not specified, it is default (package private)
    
    -Classes Chapter4_1 and Chapter4_2 used to clarify child permissions
    
    -unintuitive: void is considered a return type
    */
    long B(){return 6;}    
    /*
    2.1** Calling rules (instance vs static)
        -Static methods may not call non-static members
        -static methods may call static method/variable via the className
        -Instance methods may call both static and non-static
    
    */
    static void C() throws Exception{
      //B(); //static call nonstatic (DNC)
        E(); //static call static
    };
    
    /*
    (3)method overloading 
        --different parameters, same name
    */
    static void D(){
        System.out.println("D() prints nothing");
    }
    static void D(double whatever){
        System.out.println("D(double):");
    }
    static void D(int whatever){
        System.out.println("D(int):");
    }
    //java does not recognize access modifer, or return type as part of signature 
    //(only name and parameters)    
    public int D(int a, int b){
        System.out.println("int D(int a, int b):");
        return 1;
    }
    
    //reserved for C()
    static void E(){}
    
    /*
    3.1* autoboxing revisited
    heirarchy (first to last priority): 
        exact match by type (includes explicit casting)
        larger 'wider' type via implicit casting
        autoboxed wrapper class 
        var args
    
    */
    static void F(Double p0){
        System.out.println("F(Double) called");
    }
    static void F(float p0){
        System.out.println("F(float) called");
    }
    static void F(Object p0){
        System.out.println("F(Object) called");
    }
    static void F(String p0){
        System.out.println("F(String) called");
    }
    static void F(byte p0){
        System.out.println("F(byte) called");
    }
    static void F(Byte p0){
        System.out.println("F(Byte) called");
    }
    
    
    
    static void G(){
        
    }


}
    



/* Constructor
    4.1 default constructor: 
    definition: java classes's default no-argument constructor is equivalent of the following commented constructor:
    -generated during compilation of the .java file

    note: if you uncomment it, then class Chapter4 would no longer have a default constructor
    //public Chapter4(){}    

    
    4.2* constructor overloading 
    constructors may have multiple signatures
    -"this" keyword 
        -used to call on alternative constructors on the same instance of the class
        -used to modify variables within the instance of a class
    -DO NOT- use new operator in a constructor because it creates a new object
    
*/
class Chapter4_0 extends Chapter4{
    private String var1;
    private int var2;
    private boolean var3;
    
    //constructors
    Chapter4_0(){//this is an implementation for the no-argument constructor so no default is generated
        this.var1="No parameters provided";
    }
    Chapter4_0(String p0){
        this("only String provided:"+p0,0,false);
    }
    Chapter4_0(int p0){
        this("only int provided",p0,false);
    }
    Chapter4_0(boolean p0){
        this("only boolean provided",0, p0);
    }
    //private constructor; no other class can call
    public Chapter4_0(String p0, int p1, boolean p2){
        this.var1=p0;
        this.var2=p1;
        this.var3=p2;
    } 
    public String toString(){
        return var1;
    }
    
    
}
/*
(6)Encapsulation 
    6.1* motivation/purpose: 
        -to have control of what happens within a class; prevent unintended tampering 
        -public "mutator" methods are used to change instance variable value
        -public "accessor" methods used to read an instance variable's value

        -*basically aims to create reusable software components in Java
    6.2* JavaBeans naming convention
        -properties, aka instance variables, are private
        -getter methods prefixed with 'is' for boolean return type, and 'get' for non-boolean
        -mutator methods prefixed with 'set'
        -methods with prefix "is/get/set" are immediately followed by uppercase propertyName

    6.3* Immutability
        -get rid of the mutator methods from standard Javabeans
*/
class Dragon{
    private int numHeads;
    private boolean hungry;
    private String name;
    
    //constructors
    public Dragon(){
        this.numHeads=1;
        this.hungry=false;
        this.name="Elvarg";
    }
    public Dragon(String p0){
        this.name=p0;
    }

    
    //accessor methods
    public int getNumHeads(){
        return this.numHeads;
    }
    public boolean isHungry(){
        return this.hungry;
    }
    public String toString(){
        return name;
    }
    //mutator methods
    public void setNumHeads(int p0){
        this.numHeads=p0;
    }
    public void setHungry(boolean p0){
        this.hungry=p0;
    }
    public void setName(String p0){
        this.name=p0;
    }
}