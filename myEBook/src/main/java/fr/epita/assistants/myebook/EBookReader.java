package fr.epita.assistants.myebook;

public class EBookReader implements IPaginated, IReadable, IUpdatable{
    EBook eBook;
    double version;
    public EBookReader(){
        this.version = 1.0;
    }

    public void openEbook(EBook ebook){
        this.eBook = ebook;
    }
    @Override
    public void openToPage(int page) {
        if (eBook.curr_page >= 0 && eBook.curr_page < eBook.pages.size())
           eBook.curr_page = page;
    }

    @Override
    public int getCurrentPage() {
        if (eBook == null)
            return -1;
        if ((eBook.curr_page >= 0 && eBook.curr_page < eBook.pages.size()) || eBook.pages.size() == 0 )
            return eBook.curr_page;
        else
            return -1;
    }

    @Override
    public int getPageCount() {
        if (eBook == null)
            return -1;
        if ((eBook.curr_page >= 0 && eBook.curr_page < eBook.pages.size()) || eBook.pages.size() == 0)
            return eBook.pages.size();
        else
            return -1;
    }

    @Override
    public String readCurrentPage() {
        if (eBook == null || getCurrentPage() == -1 || eBook.pages.size() == 0)
            return null;
        return eBook.pages.get(getCurrentPage());
    }

    @Override
    public double getVersion() {
        return this.version;
    }

    @Override
    public void update(double version) {
        if (version > this.version)
            this.version = version;
    }
}
