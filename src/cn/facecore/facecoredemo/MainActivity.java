package cn.facecore.facecoredemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import cn.facecore.facecoredemo.R;

public class MainActivity extends Activity implements OnClickListener {

	private Button detectButton;
	private Button compareButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initView();
	}

	private void initView() {
		// TODO Auto-generated method stub
		detectButton = (Button) findViewById(R.id.button_detect);
		compareButton = (Button) findViewById(R.id.button_compare);
		compareButton.setOnClickListener(this);
		detectButton.setOnClickListener(this);
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch (arg0.getId()) {
		case R.id.button_compare:
			startActivity(new Intent(this, CompareActivity.class));
			break;
		case R.id.button_detect:
			startActivity(new Intent(this, DetectActivity.class));
			break;
		default:
			break;
		}
	}

}
