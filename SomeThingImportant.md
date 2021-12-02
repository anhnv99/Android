## Text
```xml
android:inputType = ""; // Cài đặt giá trị đầu vào của 1 TextBox
```

## Permission
```xml
<uses-permission android:name = "android.permission.INTERNET" />
<uses-permission android:name = "android.permission.ACCESS_NETWORK_STATE" />
```  

## Switch and ToggleButton
```java
<Switch>.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
	@Override
	public onCheckedChanged(CompoundButton buttonView, bollean isChecked) {
		if (<Switch>.isChecked() == true) { //Do something }
		else { //Do something }
	}
});
```  

```java
<toggleButton>.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
	@Override
	public onCheckedChanged(CompoundButton buttonView, bollean isChecked) {
		if (<toggleButton>.isChecked() == true) { //Do something }
		else { //Do something }
	}
});
```  