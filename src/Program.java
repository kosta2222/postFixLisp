import java.util.Stack;
import java.util.StringTokenizer;
class Lisp{
public Stack<String> opStack = new Stack<>();
public Stack<String> stack = new Stack<>();
public int sum(int a,int b){
return a+b;
}
private  boolean isOp(String c) {
        switch (c) {
            case "-":
            case "+":
            case "*":
            case "/":
            case "^":
            case  "u":
            
                return true;
        }
        return false;
    }


//String s="+5 8";
private final String OPERATORS = "+-*/^%u";

public int calculate(String sIn){
int a,b;
a=0;
b=0;

StringTokenizer stringTokenizer = new StringTokenizer(sIn,
                 OPERATORS+" ()", true);
while (stringTokenizer.hasMoreTokens()) {
            String token = stringTokenizer.nextToken();
//System.out.println(token);
if(isOp(token)){
opStack.push(token); 
}else if(!token.equals(" ") && (!token.equals("(") && !token.equals(")"))){
stack.push(token);
}

}
String sTmp=opStack.pop();
if(sTmp.equals("+")){
 a=Integer.parseInt(stack.pop());
 b=Integer.parseInt(stack.pop());

}
return sum(a,b);
}
}
class Program  {
public static void main(String args[]){
Lisp l=new Lisp();
//l.parse();
System.out.println(l.calculate("(+5 8)"));
}
}