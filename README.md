# EmailListMVC

## Hướng dẫn chạy dự án

### 1. Khởi động Tomcat
- Vào thư mục cài đặt Tomcat (`apache-tomcat-x.x.xx/bin`).
- Chạy file `startup.bat` (Windows) để khởi động Tomcat server.

### 2. Build file `.war`
- Mở terminal tại thư mục dự án `EmailListMVC`.
- Chạy lệnh:
  ```bash
  mvn clean package
````

* Sau khi build thành công, một thư mục `target/` sẽ xuất hiện.
* Bên trong sẽ có file `.war`, ví dụ:

  ```
  target/EmailListMVC-1.0-SNAPSHOT.war
  ```

### 3. Deploy vào Tomcat

* Copy file `.war` vừa tạo.
* Dán vào thư mục:

  ```
  <thư_mục_cài_đặt_tomcat>/webapps/
  ```
* Tomcat sẽ tự động giải nén file `.war` thành thư mục cùng tên.

### 4. Truy cập ứng dụng

* Sau khi Tomcat đã giải nén, mở trình duyệt và truy cập đường dẫn:

  ```
  http://localhost:8080/EmailListMVC-1.0-SNAPSHOT/emailList
  ```

---

## Ghi chú

* Yêu cầu: cài đặt Java JDK, Maven, và Apache Tomcat.
* Nếu thay đổi code Java/JSP, cần build lại (`mvn clean package`) và copy file `.war` mới vào thư mục `webapps/`.
