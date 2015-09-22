package cn.facecore.facecoredemo;

import java.io.IOException;

import com.alibaba.fastjson.JSON;

import cn.facecore.facecoredemo.comm.BitmapUtil;
import cn.facecore.facecoredemo.comm.Const;
import cn.facecore.facecoredemo.entity.FaceDetectRequest;
import cn.facecore.facecoredemo.entity.FaceDetectResult;
import cn.facecore.facecoredemo.restfulclient.Client;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.provider.MediaStore;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class DetectActivity extends BasicActivity implements OnClickListener {
	private ImageView myPhoto;
	private Button selectBT;
	private Button compareBT;
	private Bitmap resbitmap;
	private TextView valueTV;
	private MyHandler myHandler;
	private String value;
	private String s;

	class MyHandler extends Handler {
		@Override
		public void handleMessage(Message msg) {
			// TODO Auto-generated method stub
			super.handleMessage(msg);
			FaceDetectResult parseObject = JSON.parseObject(value,
					FaceDetectResult.class);
			System.out.println(parseObject.toString());
			valueTV.setText(parseObject.toString());
		}
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_detect);
		init();
	}

	private void init() {
		// TODO Auto-generated method stub
		myHandler = new MyHandler();
		myPhoto = (ImageView) findViewById(R.id.my_photo);
		selectBT = (Button) findViewById(R.id.button_select);
		compareBT = (Button) findViewById(R.id.button_compare);
		valueTV = (TextView) findViewById(R.id.textView_value);
		compareBT.setOnClickListener(this);
		selectBT.setOnClickListener(this);
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch (arg0.getId()) {
		case R.id.button_compare:
			valueTV.setText("");
			new Thread() {
				public void run() {
					// 实例化RESTFul客户端
					Client client = new Client();
					// 请求数据
					try {
						value = client.PostMethod(Const.FaceDeteiveUrl, s);
						myHandler.sendEmptyMessage(1);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}
			}.start();

			break;
		case R.id.button_select:
			show();
			break;
		default:
			break;
		}
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		if (requestCode == 0) {
			if (resultCode == -1) {
				resbitmap = BitmapUtil.saveBitmap(photo_path, photoFile);
			}
		} else if (requestCode == 1) {
			try {
				Uri selectedImage = data.getData();
				String[] filePathColumn = { MediaStore.Images.Media.DATA };
				Cursor cursor = getContentResolver().query(selectedImage,
						filePathColumn, null, null, null);
				cursor.moveToFirst();
				int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
				String picturePath = cursor.getString(columnIndex);
				cursor.close();
				resbitmap = BitmapUtil.getSmallBitmap(picturePath);
			} catch (Exception e) {
			}
		}
		if (resbitmap != null) {
			myPhoto.setImageBitmap(resbitmap);
			// 图片Base64编码
			String faceImageBase64Str = BitmapUtil.bitmaptoString(resbitmap);
			// 创建人脸检测对象
			FaceDetectRequest faceDetectRequest = new FaceDetectRequest();
			faceDetectRequest.setFaceImage(faceImageBase64Str);
			// 序列化人脸检测对象
			s = JSON.toJSONString(faceDetectRequest);
		}
	}
}
