package com.dongnao.alvin.ls23_itemtouchhelperdemo;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.support.v7.widget.helper.ItemTouchHelper.Callback;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends Activity implements StartDragListener{

	private RecyclerView recyclerview;
	private ItemTouchHelper itemTouchHelper;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		recyclerview = (RecyclerView)findViewById(R.id.recyclerview);
		
		List<QQMessage> list = DataUtils.init();
			
		
		MessageAdapter adapter = new MessageAdapter(list,this);
		recyclerview.setLayoutManager(new LinearLayoutManager(this));
//		recyclerview.addItemDecoration(new DividerItemDecoration(this));
		recyclerview.setAdapter(adapter);



		Callback callback = new MessageItemTouchCallback(adapter);
		itemTouchHelper = new ItemTouchHelper(callback);
		itemTouchHelper.attachToRecyclerView(recyclerview);

		
		
	}

	@Override
	public void onStartDrag(ViewHolder viewHolder) {
		itemTouchHelper.startDrag(viewHolder);
	}
	
	

}
