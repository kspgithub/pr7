import java.util.Stack;
public class Drunkard {
    public static String game(Integer word[]) {
        String res = "";
        int c = 0;
        Stack<Integer> f = new Stack<Integer>();
        Stack<Integer> s = new Stack<Integer>();
        for (int i = 0; i < 10; i++) {
            if (i < 5) {
                f.push(word[i]);
            } else {
                s.push(word[i]);
            }
        }
        while(!f.empty() && !s.empty() && c<106){
            if(f.peek() == 0 && s.peek() == 9){
                f.push(0);
                f.push(9);
            } else if(f.peek() == 9 && s.peek() == 0){
                s.push(9);
                s.push(0);
            } else if(s.peek() > f.peek()){
                s.push(f.peek());
                s.push(s.peek());
            } else {
                f.push(f.peek());
                f.push(s.peek());
            }
            s.pop();
            f.pop();
            c++;
        }
        if(c>105){
            System.out.print("botva");
        } else if(s.empty()){
            System.out.print("first " + c);
        } else {
            System.out.print("second " + c);
        }
        return res;
    }
    public static void main(String[] args) {
        Integer word[] =new Integer[]{1,3,5,7,9,2,4,6,8,0} ;
        System.out.println(game(word));
    }

}
