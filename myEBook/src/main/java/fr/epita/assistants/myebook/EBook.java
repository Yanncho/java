package fr.epita.assistants.myebook;

import java.util.ArrayList;
import java.util.List;

public class EBook implements IPaginated, IEditable{
    private String name;
    protected List<String> pages = new ArrayList<>();
    protected int curr_page = 0;

    public EBook(String name){
        this.name = name;
        pages.add("");
    }
    public String getName(){
        return this.name;
    }
    public void openToPage(int page) {
        if (page >= 0 && page < pages.size())
           this.curr_page = page;
    }
    public int getCurrentPage() {
        if ((this.curr_page >= 0 && this.curr_page < pages.size()) || pages.size() == 0)
            return this.curr_page;
        else
            return -1;
    }
    public int getPageCount() {
            return this.pages.size();
    }

    public void writeCurrentPage(String pageText) {
        if (pages.size() == 0)
            pages.add(pageText);
        else
            pages.set(getCurrentPage(), pageText);
    }

    public void addPage() {
        if (getCurrentPage() == -1)
            return;
        pages.add(getCurrentPage() + 1, "");
    }

    public void deletePage() {
        pages.remove(getCurrentPage());
        if (getPageCount() == 0)
            pages.add("");
    }
    public Book print(){
        List<String> copy_pages = List.copyOf(this.pages);
        Book book = new Book(this.name, copy_pages);
        return book;
    }
}
