public class Test {
    public static void main(String[] Args)
    {
        ArrayDeque<Integer> x = new ArrayDeque<Integer>();
        for(int i=0; i< 7; i++)
        {
            x.addFirst(i);
        }
        x.removeLast();
        x.addFirst(8);
        x.addFirst(9);
    }
}
