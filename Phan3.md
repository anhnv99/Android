# Ép kiểu dữ liệu
### Kiểm tra EditText rỗng
```java
if (<EditText>.getText().toString().trim().length() >= 0)
	//do Something
else
	//do Something
```

### Convert String to Int
```java
Integer.parseInt(<String>);
```

### onClick
Khi có nhiều button, không sử dụng các thông thường mà bổ sung ở phần khai báo lớp main như sau:  
```java
public class MainActivity extends AppCompatActivity implements View.OnClickListener {}
```  

Khi đó class sẽ sinh ra một hàm  
```java
public void onClick(View v){}
```  

Và ở phần kết nối các nút bấm (có thể là hàm init() tự định nghĩa hoặc onCreate()) ta cần bổ sung thêm như ví dụ sau:  
```java
<Button1> = (Button)findViewById(R.id.<Button1ID>);
<Button2> = (Button)findViewById(R.id.<Button2ID>);

<Button1>.setOnClickListener(this);
<Button2>.setOnClickListener(this);
```  

Và ở hàm onClick() vừa được sinh ra ta có thể sử dụng switch-case để phân biệt giữa các nút  
```java
public void onClick(View v) {
	switch (v.getId()) {
		case R.id.<Button1ID> :
			//do SomeThing
			break;
		case R.id<Button2ID> :
			//do SomeThing
			break;
	}
}
```  

### Thêm hình ảnh vào ứng dụng:  
Thêm đối tượng ImageView ở phần Design và đặt ID, để kết nối và hiển thị ảnh ta làm như sau:  
```java
<ImageView_Variables> = (ImageView)findViewById(R.id.<ImageViewID>);
<ImageView_Variables>.setImageResource(R.drawable.<ImageName>);
```  

### Cách để giới hạn kích cỡ của một file muốn lấy:  
```java
idea.max.intellisense.filesize = <Kích cỡ>;
```

### Lấy hình ảnh từ link:  
Đầu tiên cần bổ sung quyền, vào manifets > AndroidManifest.xml bổ sung những câu lệnh sau:  
```xml
<uses-permission android:name = "android.permission.INTERNET" />
<uses-permission android:name = "android.permission.ACCESS_NETWORK_STATE" />
```  

Thêm đối tượng ImageView ở phần Design và đặt ID, kết nối và để hiển thị ảnh ta làm như sau:  
```java
private class InternetImage extends AsyncTask<String, Integer, Bitmap> {
	@Override
	protected Bitmap doInBackground(String... params) {
		Bitmap bmp = null;
		try {
			URL u = new URL(params[0]);
			bmp = BitmapFactory.decodeStream(u.openConnection().getInputStream());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return bmp;
	}
	
	@Override
	protected void onPostExecute (Bitmap bitmap) {
		super.onPostExecute(bitmap);
		<ImageView>.setImageBitmap(bitmap); // <ImageView> là 1 biến được khai báo từ đầu
	}
}
```   
Để sử dụng ta dùng câu lệnh:  
```java
new InternetImage().excute(String Link);
```  

### Đặt background cho layout

Hình được lưu ở `res > drawable`  
```java
<Layout>.setBackgoundResource(R.drawable.<name>);
```  

### Switch

```java
<Switch>.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
	@Override
	public onCheckedChanged(CompoundButton buttonView, bollean isChecked) {
		if (<Switch>.isChecked() == true) { //Do something }
		else { //Do something }
	}
});
```  

### ToggleButton

```java
<toggleButton>.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
	@Override
	public onCheckedChanged(CompoundButton buttonView, bollean isChecked) {
		if (<toggleButton>.isChecked() == true) { //Do something }
		else { //Do something }
	}
});
```  