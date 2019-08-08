package service;
import entity.Page;

import java.util.List;

public interface PageService {
    public List<Object[]> dopage(Page page ,String mysql_table);
}
