package com.training.bloggingsite.exceptions;

public class SubCategoryAlreadyExistsException  extends RuntimeException{
    private long parentId;
    public SubCategoryAlreadyExistsException(String category,long parentId){
        super(String.format("%s category already exists",category));
        this.parentId = parentId;
    }

    public long getParentId() {
        return parentId;
    }
}
