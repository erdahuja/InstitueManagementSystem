package com.bmpl.ims.users.dto;

public class RightDTO {
private String rightName;
private String screenName;

private String category;


public String getCategory() {
	return category;
}
public void setCategory(String category) {
	this.category = category;
}
public String getRightName() {
	return rightName;
}
public void setRightName(String rightName) {
	this.rightName = rightName;
}
public String getScreenName() {
	return screenName;
}
public void setScreenName(String screenName) {
	this.screenName = screenName;
}
@Override
public String toString() {
	return "RightDTO [rightName=" + rightName + ", screenName=" + screenName + ", category=" + category + "]";
}


}
