package cn.facecore.facecoredemo.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.json.JSONObject;

import android.R.integer;

//人脸检测请求结果
public class FaceDetectResult {
	private List<FaceModel> facemodels;

	public List<FaceModel> getFacemodels() {
		return facemodels;
	}

	public void setFacemodels(List<FaceModel> facemodels) {
		this.facemodels = facemodels;
	}

	@Override
	public String toString() {
		return "FaceDetectResult [facemodels=" + facemodels + "]";
	}

}
