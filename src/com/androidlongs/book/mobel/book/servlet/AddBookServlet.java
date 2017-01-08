package com.androidlongs.book.mobel.book.servlet;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.annotation.WebServlet;
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
import com.androidlongs.book.common.model.selfs.BookClassModel;
import com.androidlongs.book.mobel.common.HomeServlet;

@WebServlet("/manager/addbook")
public class AddBookServlet extends HomeServlet{

	@Override
	public void doRequest(HttpServletRequest request,
			HttpServletResponse response) {
		System.err.println("获取书籍列表 ");
		System.out.println("添加书籍");
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		if(!isMultipart){
			throw new RuntimeException("表单的enctype难道你忘记了吗");
		}

		BookModel book = new BookModel();
		//借助commons-fileupload实现文件的上传，把普通字段封装到Book中
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload sfu = new ServletFileUpload(factory);
		List<FileItem> items = new ArrayList<FileItem>();
		try {
			items = sfu.parseRequest(request);
		} catch (FileUploadException e) {
			throw new RuntimeException("解析请求内容失败");
		}

		for(FileItem item:items){
			if(item.isFormField()){
				//普通字段：name,author,price,description(和Book属性保持一致),categoryId(单独处理).封装数据到Book中
				String fieldName = item.getFieldName();//name,author,price,description
				String fieldValue = null;
				try {
					fieldValue = item.getString("UTF-8");
					System.out.println("vlaue is -"+fieldValue);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}//值


				try {
					BeanUtils.setProperty(book, fieldName, fieldValue);
				} catch (Exception e) {
					e.printStackTrace();
				}
				//单独处理categoryId
				if("add_book_bookclass_select".equals(fieldName)){
					System.out.println("add_book_bookclass_select is " + fieldValue);
					if (fieldName.equals("无")) {
					}else {
					BookClassModel queryBookClass = (BookClassModel) mBookClassServiceInterface.queryBookClassFromName(fieldValue);
					queryBookClass.addBookModel(book);
					mBookClassServiceInterface.addBookClass(queryBookClass);
					book.addBookClassModel(queryBookClass);
					}

				}
			}else{
				String file_file_nameString = item.getFieldName();
				if (file_file_nameString!=null) {
					//上传字段：image。上传
					String filename = item.getName();
					//获取扩展名: jpg
					String extensionName = FilenameUtils.getExtension(filename);
					//创建唯一文件名称
					filename = UUID.randomUUID()+"."+extensionName;
					//路径

					String rootDirectory = getServletContext().getRealPath("/images");;

					String childPath =getStoreDirecotry(rootDirectory);
					if (file_file_nameString.equals("book_image_file")) {
						//图片路径 

						//图片名称
						book.setBpname(filename);
						book.setBppath(rootDirectory+File.separator+childPath+File.separator+filename);

						System.out.println("上传图片 "+rootDirectory+File.separator+childPath+File.separator+filename);

					}else if (file_file_nameString.equals("book_file")) {
						//thml 资源路径

						rootDirectory = getServletContext().getRealPath("/html");;
						childPath =getStoreDirecotry(rootDirectory);

						book.setBpath(rootDirectory+File.separator+childPath+File.separator+filename);
						System.out.println("上传文件  "+rootDirectory+File.separator+childPath+File.separator+filename);

					}

					//文件上传
					try {
						item.write(new File(rootDirectory+File.separator+childPath+File.separator+filename));
					} catch (Exception e) {
						e.printStackTrace();
					}
				}

			}
		}

		mBookServicenterface.addBook(book);


	}

	//返回存放的目录：用
	private String getStoreDirecotry(String rootDirectory) {
		Date now = new Date();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String path = df.format(now);
		File file = new File(rootDirectory,path);
		if(!file.exists()){
			file.mkdirs();
		}
		return path;
	}
}
