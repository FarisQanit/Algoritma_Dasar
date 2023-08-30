import java.io.*;
class Stack
{
    char u[]=new char[100];
    int top=-1;
    void push(char c)
    {
        try
        {
            u[++top]= c;
        }
        catch(StringIndexOutOfBoundsException e)
        {
            System.out.println("Stack full, no room to push, size=100");
            System.exit(0);
        }
    }
    char pop()
    {
        return u[top--];
    }
    boolean isEmpty()
    {
        return (top==-1)?true:false;
    }
    char peek()
    {
        return u[top];
    }
}
public class tugas1
{
    static Stack operasi = new Stack();
    public static void main(String argv[]) throws IOException
    {
        String infix;

        BufferedReader keyboard = new BufferedReader (new InputStreamReader(System.in));

        System.out.print("\nmasukan input infix: ");
        infix = keyboard.readLine();

        System.out.println("hasil konversi ke postfix:" + toPostfix(infix));
    }
    private static String toPostfix(String infix)

    {
        char input;
        String postfix = "";
        for(int i=0;i<infix.length();++i)

        {
            input = infix.charAt(i);

            if (Character.isDigit(input) || Character.isLetter(input))
                postfix = postfix + input;
            else if (input=='(')

            {
                operasi.push(input);
            }
            else if (input==')')

            {
                while (operasi.peek() != '(')
                {
                    postfix = postfix + operasi.pop();
                }
                operasi.pop();
            }
            else

            {
                while (!operasi.isEmpty() && !(operasi.peek()=='(') && prec(input) <= prec(operasi.peek()))
                    postfix = postfix + operasi.pop();
                operasi.push(input);
            }
        }
        while (!operasi.isEmpty())
            postfix = postfix + operasi.pop();
        return postfix;
    }
    static int prec(char y)
    {
        if (y == '+' || y == '-')
            return 1;
        if (y == '*' || y == '/' || y == '%')
            return 2;
        return 0;
    }
}
