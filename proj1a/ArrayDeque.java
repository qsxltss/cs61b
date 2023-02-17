public class ArrayDeque <T>{
    private int len;
    private T[] arr;
    private int first;//指向头,代表下一个addfirst的位置
    private int last;//指向尾,代表下一个addlast的位置
    public ArrayDeque()
    {
        arr = (T[])new Object[8];
        len = 0;
        first = 0;
        last = 1;
    }
    /*public ArrayDeque(ArrayDeque other)
    {
        arr = (T[]) new Object[other.size()];
        for(int i = 0; i < other.size(); i++)
        {
            arr[i] =(T)other.arr[i];
        }
        len = other.size();
    }*/
    private void enlarge(T[] arr)
    {
        T[] arr_new = (T[])new Object[arr.length+8];
        int num = 0;
        int x = (first+1)% arr.length;
        while(num < len)
        {
            arr_new[num] = arr[x];
            num++;
            x = (x+1) % arr.length;
        }
        first = arr_new.length-1;
        last = num;
        this.arr = arr_new;
    }
    private void shrink(T[] arr)
    {
        T[] arr_new = (T[])new Object[arr.length/2];
        int num = 0;
        int x = (first+1)% arr.length;
        while(num < len)
        {
            arr_new[num] = arr[x];
            num++;
            x = (x+1) % arr.length;
        }
        first = arr_new.length-1;
        last = num;
        this.arr = arr_new;
        System.out.println("arr.len :"+this.arr.length);
    }
    public void addFirst(T item)
    {
       arr[first] = item;
       first = (first + arr.length -1) % arr.length;
       len++;
       if(len >= arr.length)
       {
           enlarge(arr);
       }
    }
    public void addLast(T item)
    {
        arr[last] = item;
        last = (last+1) % arr.length;
        len++;
        if(len >= arr.length)
        {
            enlarge(arr);
        }
    }
    public boolean isEmpty()
    {
        if(len == 0 ) return true;
        return false;
    }
    public int size()
    {
        return len;
    }
    public void printDeque()
    {
        /* 没有内容*/
        if(len == 0)
        {
            System.out.println("len = 0!");
            return;
        }
        int num = 1;
        while(num < len)
        {
            System.out.print(arr[(first+num)% arr.length]+" ");
            num++;
        }
        System.out.print(arr[(first+num)% arr.length]);
        System.out.println();
    }
    public T removeFirst()
    {
        /* 没有内容*/
        if(len == 0)
        {
            System.out.println("len = 0!");
            return null;
        }

        T x = arr[(first+1) % arr.length];
        first = (first+1) % arr.length;
        len --;
        if(len < (arr.length/4))
        {
            shrink(arr);
        }
        return x;
    }
    public T removeLast()
    {
        /* 没有内容*/
        if(len == 0)
        {
            System.out.println("len = 0!");
            return null;
        }

        T x = arr[(last-1+ arr.length) % arr.length];
        last = (last-1+ arr.length) % arr.length;
        len --;
        if(len < (arr.length/4))
        {
            shrink(arr);
        }
        return x;
    }
    public T get(int index)
    {
        if(index >= len)
        {
            System.out.println("index is too big!");
            return null;
        }
        return arr[(first+1+index)% arr.length];
    }
}
