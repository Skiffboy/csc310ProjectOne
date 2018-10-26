package mikanelsonpostfix;

import java.util.Scanner;
import java.util.Stack;

public class MikaNelsonPostfix {

    public static double postFix(String expression) {
        //initialize stack to hold numbers
        Stack stack = new Stack();
        //initialize return variable
        double answer = 0;
        
        //iterate over the string 
        for (int i = 0; i < expression.length(); i++) {
            char toProcess = expression.charAt(i);
            
            //pull out the numbers
            if (toProcess >= '0' && toProcess <= '9') {
                double toProcessInt = toProcess - '0';
                stack.push(toProcessInt);
            //if it's not a number, perform the operation
            } else {
                double int1 = (double)stack.pop();
                double int2 = (double)stack.pop();
                
                switch (toProcess) {
                    case '/':
                        stack.push(int2 / int1);
                        break;
                    case '*':
                    case 'x':
                        stack.push(int2 * int1);
                        break;
                    case '-':
                        stack.push(int2 - int1);
                        break;
                    case '+':
                        stack.push(int2 + int1);
                        break;
                }               
            }
        }
        // return the last number
        answer = (double)stack.pop();
        return answer;     
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Please enter a string in postfix notation: ");
        String expression = in.nextLine();
        System.out.print(expression + " evaluated is: ");
        System.out.println(postFix(expression));
    }
    
}
