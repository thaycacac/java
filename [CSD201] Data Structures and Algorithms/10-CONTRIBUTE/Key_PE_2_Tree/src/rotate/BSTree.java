package rotate;

import java.util.*;

public class BSTree {

    Node root;

    BSTree() {
        root = null;
    }

    void clear() {
        root = null;
    }

    boolean isEmpty() {
        return (root == null);
    }

    Node search(Node p, int x) {
        if (p == null) {
            return (null);
        }
        if (p.info == x) {
            return (p);
        }
        if (x < p.info) {
            return (search(p.left, x));
        } else {
            return (search(p.right, x));
        }
    }

    void insert(int x) {
        if (isEmpty()) {
            root = new Node(x);
            return;
        }
        Node f, p;
        f = null;
        p = root;
        while (p != null) {
            if (p.info == x) {
                System.out.println("The key " + x + " already exists, no insertion");
                return;
            }
            f = p;
            if (x < p.info) {
                p = p.left;
            } else {
                p = p.right;
            }
        }
        if (x < f.info) {
            f.left = new Node(x);
        } else {
            f.right = new Node(x);
        }
    }

    void insertMany(int[] a) {
        for (int i = 0; i < a.length; i++) {
            insert(a[i]);
        }
    }

    void visit(Node p) {
        System.out.print(p.info + "  ");
    }

    void breadth(Node p) {
        if (p == null) {
            return;
        }
        MyQueue q = new MyQueue();
        q.enqueue(p);
        Node r;
        while (!q.isEmpty()) {
            r = q.dequeue();
            visit(r);
            if (r.left != null) {
                q.enqueue(r.left);
            }
            if (r.right != null) {
                q.enqueue(r.right);
            }
        }
    }

    void preOrder(Node p) {
        if (p == null) {
            return;
        }
        visit(p);
        preOrder(p.left);
        preOrder(p.right);
    }

    void inOrder(Node p) {
        if (p == null) {
            return;
        }
        inOrder(p.left);
        visit(p);
        inOrder(p.right);
    }

    void postOrder(Node p) {
        if (p == null) {
            return;
        }
        postOrder(p.left);
        postOrder(p.right);
        visit(p);
    }

    void inOrder(ArrayList<Integer> t, Node p) {
        if (p == null) {
            return;
        }
        inOrder(t, p.left);
        t.add(p.info);
        inOrder(t, p.right);
    }

    void balance(ArrayList<Integer> t, int i, int j) {
        if (i > j) {
            return;
        }
        int k = (i + j) / 2;
        int x = t.get(k);
        insert(x);
        balance(t, i, k - 1);
        balance(t, k + 1, j);
    }

    void bal() {
        ArrayList<Integer> t = new ArrayList<Integer>();
        inOrder(t, root);
        clear();
        int n = t.size();
        balance(t, 0, n - 1);
    }

    Node rotateRight(Node p) {
        if (p == null || p.left == null) {
            return (p);
        }
        Node q = p.left;
        p.left = q.right;
        q.right = p;
        return (q);
    }

    Node rotateLeft(Node p) {
        if (p == null || p.right == null) {
            return (p);
        }
        Node q = p.right;
        p.right = q.left;
        q.left = p;
        return (q);
    }

}
