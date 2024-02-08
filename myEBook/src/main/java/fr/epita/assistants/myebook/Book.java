package fr.epita.assistants.myebook;

import java.util.ArrayList;
import java.util.List;

public class Book implements IPaginated, IReadable{
    public String name;
    private List<String> pages;
    private int curr_page = 0;
    protected Book(String name, List<String> pages){
        this.name = name;
        this.pages = pages;
    }
    public void openToPage(int page){
        if (page >= 0 && page < pages.size())
           this.curr_page = page;
    }

    public int getCurrentPage(){
        if ((this.curr_page >= 0 && this.curr_page < pages.size()) || pages.size() == 0)
            return this.curr_page;
        else
            return -1;
    }
    public int getPageCount(){
            return this.pages.size();
    }
    public String readCurrentPage(){
        if (getCurrentPage() == -1)
            return null;
        return this.pages.get(getCurrentPage());
    }

    public String getName(){
        return this.name;
    }
    public EBook scan(){
        EBook ebook = new EBook(this.name);
        ebook.pages = List.copyOf(pages);
        return ebook;
    }
}
