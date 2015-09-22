package cn.facecore.facecoredemo.entity;

//ÈËÁ³Ä£ÐÍ
public class FaceModel {
	private int facerectanglex;
	private int facerectangley;
	private int facerectanglewidth;
	private int facerectangleheight;
	private String base64feature;
	private JsonResult lefteye;
	private JsonResult righteye;
	private JsonResult mouth;

	public void setFaceRectangleX(int faceRectangleX) {
		facerectanglex = faceRectangleX;
	}

	public int getFaceRectangleX() {
		return facerectanglex;
	}

	public void setFaceRectangleY(int faceRectangleY) {
		facerectangley = faceRectangleY;
	}

	public int getFaceRectangleY() {
		return facerectangley;
	}

	public void setFaceRectangleWidth(int faceRectangleWidth) {
		facerectanglewidth = faceRectangleWidth;
	}

	public int getFaceRectangleWidth() {
		return facerectanglewidth;
	}

	public void setFaceRectangleHeight(int faceRectangleHeight) {
		facerectangleheight = faceRectangleHeight;
	}

	public int getFaceRectangleHeight() {
		return facerectangleheight;
	}

	public String getFeature() {
		return base64feature;
	}

	public void setFeature(String feature) {
		base64feature = feature;
	}

	public int getFacerectanglex() {
		return facerectanglex;
	}

	public void setFacerectanglex(int facerectanglex) {
		this.facerectanglex = facerectanglex;
	}

	public int getFacerectangley() {
		return facerectangley;
	}

	public void setFacerectangley(int facerectangley) {
		this.facerectangley = facerectangley;
	}

	public int getFacerectanglewidth() {
		return facerectanglewidth;
	}

	public void setFacerectanglewidth(int facerectanglewidth) {
		this.facerectanglewidth = facerectanglewidth;
	}

	public int getFacerectangleheight() {
		return facerectangleheight;
	}

	public void setFacerectangleheight(int facerectangleheight) {
		this.facerectangleheight = facerectangleheight;
	}

	public String getBase64feature() {
		return base64feature;
	}

	public void setBase64feature(String base64feature) {
		this.base64feature = base64feature;
	}

	public JsonResult getLefteye() {
		return lefteye;
	}

	public void setLefteye(JsonResult lefteye) {
		this.lefteye = lefteye;
	}

	public JsonResult getRighteye() {
		return righteye;
	}

	public void setRighteye(JsonResult righteye) {
		this.righteye = righteye;
	}

	public JsonResult getMouth() {
		return mouth;
	}

	public void setMouth(JsonResult mouth) {
		this.mouth = mouth;
	}

	@Override
	public String toString() {
		return "FaceModel [facerectanglex=" + facerectanglex
				+ ", facerectangley=" + facerectangley
				+ ", facerectanglewidth=" + facerectanglewidth
				+ ", facerectangleheight=" + facerectangleheight
				+ ", base64feature=" + base64feature + ", lefteye=" + lefteye
				+ ", righteye=" + righteye + ", mouth=" + mouth + "]";
	}

}
