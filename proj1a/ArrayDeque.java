public class ArrayDeque <T>{
    private int len;
    private T[] arr;

    public ArrayDeque()
    {
        arr = (T[])new Object[8];
        len = 0;
    }
    public ArrayDeque(ArrayDeque other)
    {
        arr = (T[]) new Object[other.size()];
        for(int i= 0; i< other.size();i++)
        {
            arr[i] =(T)other.arr[i];
        }
        len = other.size();
    }
    public void addFirst(T item)
    {
        T[] arr_new = (T[])new Object[len+1];
        arr_new[0] = item;
        for(int i = 0; i < len; i++)
        {
            arr_new[i+1] = arr[i];
        }
        arr = arr_new;
        len += 1;
    }
    public void addLast(T item)
    {
        T[] arr_new = (T[])new Object[len+1];
        arr_new[len] = item;
        for(int i = 0; i < len; i++)
        {
            arr_new[i] = arr[i];
        }
        arr = arr_new;
        len+=1;
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
        for(int i = 0; i < len-1; i++)
        {
            System.out.print(arr[i]+" ");
        }
        System.out.print(arr[len-1]);
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

        T x = arr[0];
        T[] arr_new = (T[])new Object[len-1];
        for(int i = 0; i < (len-1); i++)
        {
            arr_new[i] = arr[i+1];
        }
        arr = arr_new;
        len -= 1;
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

        T x = arr[len-1];
        T[] arr_new = (T[])new Object[len-1];
        for(int i = 0; i < (len-1); i++)
        {
            arr_new[i] = arr[i];
        }
        arr = arr_new;
        len -= 1;
        return x;
    }
    public T get(int index)
    {
        return arr[index];
    }
}
