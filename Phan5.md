## RadioButton
- Cần sử dụng đối tượng `RadioGroup` để lưu trữ các đối tượng cùng một nhóm.  
- Ta có hàm isChecked() để kiểm tra `RadioButton` có được chọn hay không.  
```java
<RadioButton>.isChecked();
```  

## CheckBox
- Các sử dụng tương tự `RadioButton` nhưng không cần sử dụng bất kỳ đối tượng nào để gộp nhóm.  
```java
<CheckBox>.isChecked();  
```  

## Alert Dialog
- Để khai báo một đối tượng Alert Dialog ta dùng câu lệnh:  
```java
AlertDialog.Builder variable_name = new AlertDialog.Builder(MainActivity.this)
			.setTitle("Title")
			.setMessage("Message")
			.setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener(){
				@Override
				public void onClick(DialogInterface dialog, int which) {
					//Do something when choose yes
				}
			})
			.setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener(){
				@Override
				public void onClick(DialogInterface dialog, int which) {
					//Do something when choose no
				}
			})
			.setCancelable(false);
variable_name.create().show();
```  
- Để thay đổi lựa chọn hiển thị trên Dialog ta làm như sau:  
	- Mở file `string.xml` trong thư mục `res > values`.  
	- Bổ sung những lựa chọn muốn Dialog có thể hiển thị lên.  
```xml
<string name = "id">ID</string>
```  
- Khi gọi Dialog ở phần .setPositiveButton và .setNegativeButton ta sẽ sử dụng:  
```java
android.R.string.id
```  

## Dialog Layout
- Tạo một Layout mới.  
- Lấy đường dẫn đến Layout đó.  
- Gắn vào Dialog.  

Ví dụ: Ta có layout mới tên là new_layout, ta sẽ gán nó vào dialog như sau:  
```java
LayoutInflater inflater = MainActivity.this.getLayoutInflater();
View new_view = inflater.inflate(R.layout.new_layout, null);

AlertDialog.Builder variable_name = new AlertDialog.Builder(MainActivity.this)
			.setView(new_view);
```  

