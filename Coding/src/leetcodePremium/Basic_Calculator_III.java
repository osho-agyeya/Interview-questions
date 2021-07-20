/*completedd
 * 
 * Implement a basic calculator to evaluate a simple expression string.

The expression string may contain open(and closing parentheses), the plus+or minus sign-, non-negative integers and empty spaces.

The expression string contains only non-negative integers,+,-,*,/operators , open(and closing parentheses)and empty spaces. The integer division should truncate toward zero.

You may assume that the given expression is always valid. All intermediate results will be in the range of[-2147483648, 2147483647].

Some examples:

"1 + 1" = 2
" 6-4 / 2 " = 4
"2*(5+5*2)/3+(6/2+8)" = 21
"(2+6* 3+5- (3*14/7+2)*5)+3"=-12
 * 
 */

package leetcodePremium;

public class Basic_Calculator_III {

    public int calculate(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        Stack<Integer> nums = new Stack();
        Stack<Character> operators = new Stack();

        int i = 0;
        int num = 0;
        int n = s.length();

        while (i < n) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                num = c - '0';

                while ((i + 1) < n && Character.isDigit(s.charAt(i + 1))) {
                    num = 10 * num + s.charAt(i + 1) - '0';
                    ++i;
                }
                nums.push(num);
            }
            else if (isOperator(c)) {
                while (!operators.isEmpty() && hasPrecedence(c, operators.peek())) {
                    nums.push(calculate(operators.pop(), nums.pop(), nums.pop()));
                }
                operators.push(c);
            }
            else if (c == '(') {
                operators.push(c);
            }
            else if (c == ')') {
                while (!operators.isEmpty() && operators.peek() != '(') {
                    nums.push(calculate(operators.pop(), nums.pop(), nums.pop()));
                }
                operators.pop();
            }
            ++i;
        }

        while (!operators.isEmpty()) {
            nums.push(calculate(operators.pop(), nums.pop(), nums.pop()));
        }
        return nums.isEmpty() ? 0 : nums.pop();
    }

    public boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    public int calculate(char operator, int num1, int num2) {
        int res = 0;

        switch(operator) {
            case '+':
                res = num1 + num2;
                break;
            case '-':
                res = num2 - num1;
                break;
            case '*':
                res = num1 * num2;
                break;
            case '/':
                res = num2 / num1;
                break;
        }
        return res;
    }

    // check if op2 has higher precendence than op1
    public boolean hasPrecedence(char op1, char op2) {
        if (op2 == ')' || op2 == '(') {
            return false;
        }

        if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-')) {
            return false;
        }
        return true;
    }
	
}
