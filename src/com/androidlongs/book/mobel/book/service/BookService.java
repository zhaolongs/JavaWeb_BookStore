package com.androidlongs.book.mobel.book.service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;

import com.androidlongs.book.base.BaseModel;
import com.androidlongs.book.common.model.book.BookModel;
import com.androidlongs.book.mobel.book.dao.BookDao;
import com.androidlongs.book.mobel.book.dao.BookDaoImple;

public class BookService implements BookServicenterface {

	private BookDao mBookDao = new BookDaoImple();
	@Override
	public BaseModel addBook(BookModel bookModel) {
		bookModel.setUuid(UUID.randomUUID().toString());
		return mBookDao.addModel(bookModel);
	}

	@Override
	public BaseModel updateBook(BookModel bookModel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteBookFromId(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteBookFromName(String name) {
		// TODO Auto-generated method stub
		
	}



}
