package com.popo.jdbc;

import java.util.ArrayList;
import java.util.List;

import com.popo.po.Stu;

public class IntoSQL {
	public void ReadIntoSQL(List<Stu> student){
		List<Stu> list = new ArrayList<Stu>();
		list = student;
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i).getId());
			System.out.println(list.get(i).getName());
			System.out.println(list.get(i).getSex());
			System.out.println(list.get(i).getNum());
		}
	}

}
