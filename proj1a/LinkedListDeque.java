public class LinkedListDeque <T> {
    private node sentinel;
    //private node last;
    private int len;
    private class node
    {
        public T item;
        public node next;
        public node prev;
        public node(T x, node p, node n)
        {
            item = x;
            next = n;
            prev = p;
        }
    }
    public LinkedListDeque()
    {
        sentinel = new node(null,null,null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        len = 0;
    }
    /*public LinkedListDeque(LinkedListDeque other)
    {
        sentinel = new node(null,null,null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        len =0;
        node copy = other.sentinel;
        for(int i=0; i< other.len; i++)
        {
            copy = copy.next;
            this.addLast(copy.item);
        }
    }*/
    public void addFirst(T item)
    {
        node x = new node(item,sentinel,sentinel.next);
        sentinel.next.prev = x;
        sentinel.next = x;
        len++;
    }
    public void addLast(T item)
    {
        node x = new node(item,sentinel.prev,sentinel);
        sentinel.prev.next = x;
        sentinel.prev = x;
        len++;
    }
    public boolean isEmpty()
    {
        if (len == 0) return true;
        return false;
    }
    public int size()
    {
        return len;
    }

    public void printDeque()
    {
        /* len=0:不存在node */
        if(len <= 0)
        {
            System.out.println("len is 0!");
        }
        node x = sentinel.next;
        for(int i=0; i<len-1; i++)
        {
            System.out.print(x.item+" ");
            x = x.next;
        }
        System.out.print(x.item);
        System.out.println();
    }

    public T removeFirst()
    {
        /* len=0:不存在node */
        if(len == 0)
        {
            System.out.println("len is 0!");
            return null;
        }
        node x = sentinel.next;
        x.next.prev = sentinel;
        sentinel.next = x.next;
        len--;
        return x.item;
    }
    public T removeLast()
    {
        /* len=0:不存在node */
        if(len == 0)
        {
            System.out.println("len is 0!");
            return null;
        }
        node x = sentinel.prev;
        x.prev.next = sentinel;
        sentinel.prev = x.prev;
        len--;
        return x.item;
    }

    /**/
    public T get(int index)
    {
        node x = sentinel;
        /* len=0:不存在node */
        if(len == 0)
        {
            System.out.println("len is 0!");
            return null;
        }
        for(int i = 0; i<len; i++)
        {
            x = x.next;
            if(index == i)
            {
                return x.item;
            }
        }
        /* index>=len:超过了能get的长度 */
        System.out.println("index is too big!");
        return null;
    }

    /* helper function for getrecursive */
    private T getRecur(node x, int index)
    {
        if(index == 0) return x.item;
        return getRecur(x.next,index-1);
    }
    public T getRecursive(int index)
    {
        /* index>=len:超过了能get的长度 */
        if(index >= len)
        {
            System.out.println("index is too big!");
            return null;
        }
        /* len=0:不存在node */
        if(len == 0)
        {
            System.out.println("len is 0!");
            return null;
        }
        return getRecur(sentinel.next,index);
    }
}
