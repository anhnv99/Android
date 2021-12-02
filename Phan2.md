## **Vòng đời của chương trình Android**

![Life Circles](https://static.javatpoint.com/images/androidimages/Android-Activity-Lifecycle.png)  
  
Sơ đồ được chạy khi *Activity Launch* được kích hoạt.  
Sau đó lần lượt các callback **onCreate()**, **onStart()**, **onResume()** được hệ thống gọi đến.  
Sau khi gọi hết các callback trên, thì *Activity* mới chính thức là đang chạy.  
Lúc này:
- Nếu một *Activity* khác chiếm quyền hiển thị, thì *Activity* hiện tại sẽ rơi vào trạng thái **onPause()**.  
- Nếu sự hiển thị của *Activity* khác làm cho *Activity* của chúng ta không còn nhìn thấy được, nó sẽ rơi vào trạng thái **onStop()**.  
- Nếu *Activity* đã **onPause()**, tức là đang bị *Activity* khác đè lên, và người dùng quay về *Activity* cũ, thì **onResume()** sẽ được gọi.  
- Nếu *Activity* đã vào **onStop()**, mà người dùng quay về *Activity* cũ, **onRestart()** được gọi.  
- Trong cả hai trường hợp **onPause()** hoặc **onStop()**, nó sẽ rất dễ bị hệ thống thu hồi (*bị hủy*) để giải phóng tài nguyên, khi này nếu quay lại *Activity* cũ, **onCreate()** sẽ được gọi chứ không **onResume()** hay **onRestart()**.  
- Và cuối cùng nếu *Activity* bị hủy có chủ đích, **onDestroy()** sẽ được kích hoạt và *Activity* sẽ kết thúc vòng đời của nó.  

Có thể đọc đầy đủ ý nghĩa của từng hàm tại [đây](https://blog.boxyzvn.com/activity-lifecycle).  

## **Thiết kế và thay đổi Icon của ứng dụng**

- Chỉnh sửa trong **mipmap** (*New -> Mipmap Assets*).  

## **Các kiểu layout thường gặp**

- RelativeLayout: Các đối tượng có sự phụ thuộc vào nhau về mặt vị trí hiển thị.  
- FrameLayout: Gồm các *Viewport*, với mỗi đối tượng nằm chung *Viewport*, thì đối tượng mới sẽ nằm đè nên đối tượng cũ.  
- LinearLayout (Vertical): Các đối tượng sẽ nằm theo chiều dọc.  
- LinearLayout (Horizontal): Các đối tượng sẽ nằm theo chiều ngang.  

## **Các bước xây dựng một ứng dụng Android**

### **Bước 1: Kéo thả**

Kéo thả các đối tượng để tạo thành giao diện của ứng dụng.

### **Bước 2: Gắn ID**

Gắn ID cho các đối tượng nằm trong giao diện (đối tượng vừa được kéo vào). Để có thể thực hiện gọi đến đối tượng trong lúc viết code.  

### **Bước 3: Khởi tạo**

Khởi tạo các biến trong class java cần sử dụng đến.  

### **Bước 4: Kết nối**

Tiến hành kết nối đến biến vừa được tạo ra đến một đối tượng trong ứng dụng bằng ID của đối tượng đó.  

`
<variable in ObjectType> = (<ObjectType>)findViewById(R.id.<ID of Oject>);
`

- **R** là một file tự động dùng để lưu thông tin về các Object.  

### **Bước 5: Viết code**

Bắt đầu code ứng dụng.  

## **Kiến thức lập trình**

### **Làm việc với đối tượng Text**
```java
String variables = <EditTextObject>.getText().toString();
<TextObject>.setText(variable);
```

### **Bắt sự kiện với đối tượng Button**
```java
<ButtonObject>.setOnClickListener (new View.OnClickListener() {
	@Override
	public void onClick(View v) {
		//Code here
	}
});
```

### ***Log và Toast**

```java
Log.d(string tag, string msg);
Toast.makeText(Context context, CharSequence text, int duration).show();

Toast toast = maketext(Context context, CharSequence text, int duration);
toast.show();
```
- Context context: là activity muốn show() Toast lên.  
- CharSequence: là thông báo muốn hiển thị trên Toast.  
- int duration: là thời gian muốn hiển thị Toast (**Toast.LENGTH_LONG** hoặc **Toast.LENGTH_SHORT**).  

### **Snackbar**
Bổ sung thư viện (*dependency*) trong *build.gradle*:  
`
compile 'com.android.support:design:22.2.0'
`  
Cú pháp:
```java
Snackbar snackbar = Snackbar.make(View view, CharSequence text, int duration);
snackbar.show();
```
```java
Snackbar snackbar = Snackbar.make(View view, CharSequence text, int duration);
snackbar.setAction(CharSequence, new View.OnClickListener() {
	@Override
	public void onClick (View v) {
		// Code here
	}
})
snackbar.show();
```

