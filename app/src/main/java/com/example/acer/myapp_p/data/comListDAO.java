package com.example.acer.myapp_p.data;

/**
 * Created by yvtc on 2017/11/13.
 */

public interface comListDAO {
    void add(comList s);
    comList[] getData();
    void update(comList s);
    void delete(comList s);
    void clear();
    comList getOneStudent(int id);
    comList[] searchByName(String name);
}
