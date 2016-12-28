package com.androidlongs.book.mobel.froum.test;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.junit.Test;

import com.androidlongs.book.common.model.friend.FroumModel;
import com.androidlongs.book.mobel.froum.service.FroumService;
import com.androidlongs.book.mobel.froum.service.FroumServiceImple;

public class FroumTest {

	private FroumService mFroumService = new FroumServiceImple();
	@Test
	public void add() {

		for (int i = 0; i < 10; i++) {
			FroumModel model = new FroumModel();
			model.setfDesc(i+" 这是一个测试内容 一 "+new Date().getTime());
			model.setuFromTime(""+new Date().getTime());
			model.setUserUuid("f0b5efb4-9641-4959-a390-3285e626a09f");

			mFroumService.addFroumModel(model);
		}

	}

	@Test
	public void queryUserList(){
		List<FroumModel> froumListFroumUserId = mFroumService.getFroumListFroumUserId("f0b5efb4-9641-4959-a390-3285e626a03f");
		if (froumListFroumUserId!=null) {
			for (int i = 0; i < froumListFroumUserId.size(); i++) {
				FroumModel froumModel = froumListFroumUserId.get(i);
				System.out.println(froumModel.toString());
			}
		}else {
			System.out.println("list is null");
		}

	}

	@Test
	public void queryAllFroum(){
		List<FroumModel> allFroumList = mFroumService.getAllFroumList();
		if (allFroumList!=null) {
			for (int i = 0; i < allFroumList.size(); i++) {
				FroumModel froumModel = allFroumList.get(i);
				System.out.println(froumModel.toString());
			}
		} else {
			System.out.println("list is null");
		}
	}
	
	@Test
	public void queryFroumModel(){
		FroumModel froumModel = mFroumService.getFroumFroumId("19ac18e1-b8ae-451a-81b9-ad9adcf15988");
		if (froumModel!=null) {
			System.out.println(froumModel);
		} else {
			System.out.println("froumModel is null");
		}
	}
	
	@Test
	public void deleteFroumModel(){
		mFroumService.deleteFroumModel("19ac18e1-b8ae-451a-81b9-ad9adcf15988");
	}
	
}
