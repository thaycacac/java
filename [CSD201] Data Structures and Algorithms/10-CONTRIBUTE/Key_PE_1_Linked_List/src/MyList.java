
public class MyList {

    Node head, tail;

    MyList() {
        head = tail = null;
    }

    boolean isEmpty() {
        return (head == null);
    }

    void clear() {
        head = tail = null;
    }

    // (1) 
    void addLast(Person x) {
        Node q = new Node(x);

        if (isEmpty()) {
            head = tail = q;
            return;
        }

        tail.next = q;
        tail = q;
    }

    void visit(Node p) {
        if (p != null) {
            System.out.print(p.info);
        }
    }

    void traverse() {
        Node p = head;

        while (p != null) {
            visit(p);
            p = p.next;
        }

        System.out.println();
    }

    void addMany(String[] a, int[] b) {
        int n, i;
        n = a.length;
        for (i = 0; i < n; i++) {
            addLast(new Person(a[i], b[i]));
        }
    }

    void insertPos(int k, Person x) {
        Node p = head;
        int count = 0;
        while (p != null) {
            if (count == k - 1) {
                insertAfter(p, x);
                break;
            }
            count++;
            p = p.next;
        }
    }

    // (2)
    Node searchByName(String xName) {
        Node p = head;

        while (p != null) {
            if (p.info.name.equals(xName)) {
                return (p);
            }
            p = p.next;
        }

        return (null);
    }

    Node searchByAge(int xAge) {
        Node p = head;
        while (p != null) {
            if (p.info.age == xAge) {
                return (p);
            }

            p = p.next;
        }
        return (null);
    }

    // (3)
    void addFirst(Person x) {
        head = new Node(x, head);
        if (tail == null) {
            tail = head;
        }
    }

    // (4)
    void insertAfter(Node q, Person x) {
        if (isEmpty() || q == null) {
            return;
        }

        Node q1 = q.next;
        Node p = new Node(x, q1);
        q.next = p;

        if (tail == q) {
            tail = p;
        }
    }

    // (5)
    void insertBefore(Node q, Person x) {
        if (isEmpty() || q == null) {
            return;
        }
        if (q == head) {
            addFirst(x);
            return;
        }

        Node f = head;

        while (f != null && f.next != q) {
            f = f.next;
        }

        if (f == null) {
            return; // q is not in the list
        }
        insertAfter(f, x);
    }

    // (6)
    void removeFirst() {
        if (isEmpty()) {
            return;
        }

        head = head.next;

        if (head == null) {
            tail = null;
        }
    }

    void remove(Node q) {
        if (isEmpty() || q == null) {
            return;
        }

        if (q == head) {
            removeFirst();
            return;
        }

        Node f = head;

        while (f != null && f.next != q) {
            f = f.next;
        }

        if (f == null) {
            return; // q is not in the list
        }
        Node q1 = q.next;
        f.next = q1;
        if (f.next == null) {
            tail = f;
        }
    }

    // (7)
    void remove(String xName) {
        Node q = searchByName(xName);
        remove(q);
    }

    // (8)
    void remove(int xAge) {
        Node q = searchByAge(xAge);
        remove(q);
    }

    // (9)
    void removeAll(int xAge) {
        Node q;
        while (true) {
            q = searchByAge(xAge);
            if (q == null) {
                break;
            }
            remove(q);
        }
    }

    // (10)
    Node pos(int k) {
        int i = 0;
        Node p = head;
        while (p != null) {
            if (i == k) {
                return (p);
            }
            i++;
            p = p.next;
        }
        return (null);
    }

    // (11)
    void removePos(int k) {
        Node q = pos(k);
        remove(q);
    }

    // (12)
    void sortByName() {
        Node pi, pj;
        Person x;
        for (pi = head; pi != null; pi = pi.next) {
            for (pj = pi.next; pj != null; pj = pj.next) {
                if (pj.info.name.compareTo(pi.info.name) < 0) {
                    x = pi.info;
                    pi.info = pj.info;
                    pj.info = x;
                }
            }
        }
    }

    // (13)
    void sortByAge() {
        Node pi, pj;
        Person x;
        for (pi = head; pi != null; pi = pi.next) {
            for (pj = pi.next; pj != null; pj = pj.next) {
                if (pj.info.age < pi.info.age) {
                    x = pi.info;
                    pi.info = pj.info;
                    pj.info = x;
                }
            }
        }
    }

    // (14)
    int size() {
        int i = 0;
        Node p = head;
        while (p != null) {
            i++;
            p = p.next;
        }
        return (i);
    }

    // (15)
    Person[] toArray() {
        int i, n;
        n = size();
        Person[] a = new Person[n];
        Node p = head;
        i = 0;
        while (p != null) {
            a[i++] = new Person(p.info.name, p.info.age);
            p = p.next;
        }
        return (a);
    }

    // (16)
    void reverse() {
        MyList t = new MyList();
        Node p = head;
        while (p != null) {
            t.addFirst(p.info);
            p = p.next;
        }
        head = t.head;
        tail = t.tail;
    }

    // (17) 
    Node findMaxAge() {
        if (isEmpty()) {
            return (null);
        }
        int x;
        Node p, q;
        p = q = head;
        x = head.info.age;
        p = p.next;
        while (p != null) {
            if (p.info.age > x) {
                x = p.info.age;
                q = p;
            }
            p = p.next;
        }
        return (q);
    }

    // (18) 
    Node findMinAge() {
        if (isEmpty()) {
            return (null);
        }
        int x;
        Node p, q;
        p = q = head;
        x = head.info.age;
        p = p.next;
        while (p != null) {
            if (p.info.age < x) {
                x = p.info.age;
                q = p;
            }
            p = p.next;
        }
        return (q);
    }

    // (19) 
    void setData(Node p, Person x) {
        if (p != null) {
            p.info = x;
        }
    }

    // (20) 
    void sortByAge(int k, int h) {
        if (k > h) {
            return;
        }
        if (k < 0) {
            k = 0;
        }
        int n = size();
        if (h > n - 1) {
            h = n - 1;
        }
        Node u = pos(k);
        Node v = pos(h + 1);
        Node pi, pj;
        Person x;
        for (pi = u; pi != v; pi = pi.next) {
            for (pj = pi.next; pj != v; pj = pj.next) {
                if (pj.info.age < pi.info.age) {
                    x = pi.info;
                    pi.info = pj.info;
                    pj.info = x;
                }
            }
        }

    }

    // (21) 
    void reverse(int k, int h) // reverse from k to h 
    {
        if (k > h) {
            return;
        }
        int n = size();
        int i, j;
        if (k < 0 || h > n - 1) {
            return;
        }
        Person[] a = toArray();
        i = k;
        j = h;
        Person x;
        while (i < j) {
            x = a[i];
            a[i] = a[j];
            a[j] = x;
            i++;
            j--;
        }
        clear();
        for (i = 0; i < n; i++) {
            addLast(a[i]);
        }
    }
}
