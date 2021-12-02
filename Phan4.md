## SeekBar

```java
<SeekBar>.setMax(); // Đặt giá trị tối đa của SeekBar
```  
Ta có thuộc tính `progress` được định nghĩa trong SeekBar dùng để lưu giá trị hiện tại của SeekBar  
```java
<SeekBar>.getProgress();
```  

```java
<SeekBar>.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){
	@Override
	public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
		//Khi thay đổi giá trị SeekBar có gì xảy ra
	}
	public void onStartTrackingTouch(SeekBar seekBar) {
		//Khi bắt đầu thao tác với SeekBar
	}
	public void onStopTrackingTouch(SeekBar seekBar) {
		//Khi kết thúc thao tác với SeekBar
	}
});
```  

## Lấy hình bằng Identifier

```java
int ID = getResources().getIdentifier(String name, String defType, String defPackage);
```  
Ví dụ:  
Lấy một hình có tên là *abc* trong thư mục *drawable*:  
```java
int ID = getResources().getIdentifier("abc", "drawable", getPackageName());
```  

## Hệ màu RGBA
```java
Color.argb(alpha, red, green, blue);
```  

