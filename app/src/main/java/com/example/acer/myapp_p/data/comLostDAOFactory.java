package com.example.acer.myapp_p.data;

import android.content.Context;

/**
 * Created by yvtc on 2017/11/20.
 */

public class comLostDAOFactory {
    public static comListDAO getStudentDAO(DAOType type, Context context)
    {
        switch(type)
        {
            case MEMORY:
                return new comListDAOMemoryImpl();
            case FILE:
                return new comListDAOFileImpl(context);
            case DB:
                return new comListDAODBImpl(context);
            case CLOUD:
                return new comListDAOCloudImpl(context);
        }
        return null;
    }
}
