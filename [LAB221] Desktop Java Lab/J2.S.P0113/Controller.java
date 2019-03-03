package J2SP0113;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

/**
 *
 * @author Thaycacac
 */
public class Controller {

    Main main = new Main();
    ArrayList<Book> listBook = new ArrayList();

    public void control() {
        main.setVisible(true);
        addBookList();
        addBookJList();
        clickItem();
        clickRemove();
    }

    public void clickRemove() {
        main.getBtnRemove().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String bookSelected = main.getjList1().getSelectedValue();
                listBook.remove(getBookByName(bookSelected));
                addBookJList();
            }
        });
    }

    public Book getBookByName(String bookSelecter) {
        for (Book book : listBook) {
            if (book.getBookName().equalsIgnoreCase(bookSelecter)) {
                return book;
            }
        }
        return null;
    }

    public void clickItem() {
        main.getjList1().addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent me) {
                String bookSelected = main.getjList1().getSelectedValue();
                for (Book book : listBook) {
                    if (book.getBookName().equalsIgnoreCase(bookSelected)) {
                        displayBook(book);
                        return;
                    }
                }
            }

            @Override
            public void mousePressed(MouseEvent me) {
            }

            @Override
            public void mouseReleased(MouseEvent me) {
            }

            @Override
            public void mouseEntered(MouseEvent me) {
            }

            @Override
            public void mouseExited(MouseEvent me) {
            }
        });
    }

    public void displayBook(Book book) {
        main.getTfBookCode().setText(book.getBookCode());
        main.getTfBookName().setText(book.getBookName());
        main.getTfAuthor().setText(book.getAuthor());
        main.getTfPublisher().setText(book.getPublisher());
        main.getCbbPublishYear().setSelectedItem(book.getPublishYear());
        main.getChbForRent().setSelected(book.isForRent());
    }

    public void addBookJList() {
        ArrayList<String> nameListAccout = new ArrayList<>();
        for (int i = 0; i < listBook.size(); i++) {
            nameListAccout.add(listBook.get(i).getBookName());
        }
        String[] es = new String[nameListAccout.size()];
        es = nameListAccout.toArray(es);
        main.getjList1().setListData(es);
    }

    public void addBookList() {
        listBook.add(new Book("TJAVA001", "Java core - Part 1", "Andrei Chang", "Standford University", 2000, true));
        listBook.add(new Book("TJAVA002", "Java core - Part 2", "Andrei Chang", "Standford University", 1998, false));
        listBook.add(new Book("TJAVA002", "Java Server Pages", "Andrei Chang", "Standford University", 1997, false));
        listBook.add(new Book("TJAVA002", "JSP and MVC model", "Andrei Chang", "Standford University", 1995, true));
    }

    public static void main(String[] args) {
        Controller controler = new Controller();
        controler.control();
    }

}
