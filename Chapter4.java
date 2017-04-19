package chapter4;

/**
 *
 * @author huanj
 * CHAPTER 3: Core Java APIs 
 *
 * SUMMARY: 
 * 
 *(1)method signature analysis
 *      1.1* access modifiers
 *      1.2* 
 *(2)static import
 *      -syntax 
 *(3)method overloading
 *(4)Constructors
 *(5)Order of initialization 
 *(6)Encapsulation
 *(7) Lambdas
 */
public class Chapter4 {
    public static void main(String[] args) throws Exception { //throws clause is required because a.A() requires it
        // TODO code application logic here
        Chapter4 a = new Chapter4();
        a.A(); //nonstatic method members require an instance of the class to execute
        System.out.println(a.B());
        C();
        D();
        E();
        //anything
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
    -unintuitive: void is considered a return type
    */
    long B(){return 6;}    
    /*
    1.2*
    
    */
    static void C(){}    
    static void D(){}
    static void E(){}    
}

class OtherClass{
    
}