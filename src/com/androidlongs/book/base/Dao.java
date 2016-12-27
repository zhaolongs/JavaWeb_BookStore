package com.androidlongs.book.base;

public interface Dao {
	BaseModel addModel(BaseModel model);
	void deleteMocel(BaseModel deleteModel);
	void updateModel(BaseModel updateModel);
	BaseModel queryModel(String id);
}
