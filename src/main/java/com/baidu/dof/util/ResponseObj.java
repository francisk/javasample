package com.baidu.dof.util;

import com.baidu.dof.entity.*;
import java.util.List;

public class ResponseObj {
    private List<AbstractEntity> entities;
    private int size;


    public ResponseObj() {

    }

    public ResponseObj(List<AbstractEntity> entityList) {
        this.entities = entityList;
    }


    public List<AbstractEntity> getEntities() {
        return this.entities;
    }

    public void setEntities(List<AbstractEntity> entity) {
        this.entities = entity;
    }

    public int getSize() {
        if(null != entities){
            this.size = entities.size();
            return this.size;
        }
        else{
            return 0;
        }
        
    }
}