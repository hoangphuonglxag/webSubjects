# 🚀 Hướng dẫn chạy Portfolio Java Web App

## 📋 Yêu cầu hệ thống
- **Java**: JDK 11 hoặc cao hơn
- **Maven**: 3.6.0+
- **Tomcat**: 9.0+ (hoặc sử dụng Jetty embedded)

## 🛠️ Cách chạy ứng dụng

### **Cách 1: Sử dụng Maven + Jetty (Khuyên dùng)**
```bash
# 1. Compile và package
mvn clean compile

# 2. Chạy với Jetty embedded server
mvn jetty:run

# 3. Mở trình duyệt
# URL: http://localhost:8080/portfolio
```

### **Cách 2: Build WAR file và deploy lên Tomcat**
```bash
# 1. Build WAR file
mvn clean package

# 2. Copy WAR file vào Tomcat
copy target\portfolio.war %CATALINA_HOME%\webapps\

# 3. Start Tomcat
%CATALINA_HOME%\bin\startup.bat

# 4. Mở trình duyệt  
# URL: http://localhost:8080/portfolio
```

### **Cách 3: Chạy trực tiếp với Maven Tomcat Plugin**
```bash
# Chạy với embedded Tomcat
mvn tomcat7:run

# Mở: http://localhost:8080/portfolio
```

## 🌐 API Endpoints

### **Main Portfolio**
- **GET** `/portfolio` - Trang chính (JSP)

### **JSON APIs**
- **GET** `/api/user` - Thông tin user
- **GET** `/api/skills` - Danh sách kỹ năng  
- **GET** `/api/projects` - Danh sách dự án
- **GET** `/api/certificates` - Chứng chỉ/bằng cấp
- **GET** `/api/assignments` - Danh sách bài tập

### **Authentication & Upload**
- **POST** `/api/authenticate` - Xác thực mật khẩu
  - Body: `password=admin123`
- **POST** `/api/upload` - Upload bài tập (cần xác thực)
  - Body: `multipart/form-data`

## 🔐 Xác thực
- **Mật khẩu mặc định**: `admin123`
- **Session timeout**: 30 phút
- **Chức năng**: Bảo vệ upload bài tập

## 📁 Cấu trúc project

```
src/
├── main/
│   ├── java/com/portfolio/
│   │   ├── model/          # User, Skill, Project, Assignment, Certificate
│   │   ├── service/        # PortfolioService (business logic)
│   │   └── controller/     # PortfolioController (Servlet)
│   └── webapp/
│       ├── css/            # styles.css
│       ├── js/             # portfolio.js
│       ├── images/         # Hình ảnh
│       └── WEB-INF/
│           ├── views/      # portfolio.jsp
│           └── web.xml     # Web config
├── pom.xml                 # Maven dependencies
└── README.md
```

## 🎯 Tính năng chính

### **✅ MVC Architecture**
- **Model**: Java classes (User, Skill, Project...)
- **View**: JSP với JSTL
- **Controller**: Servlet xử lý HTTP requests

### **✅ Dynamic Data**
- Dữ liệu được load từ Java Service class
- Có thể dễ dàng kết nối database
- API endpoints trả về JSON

### **✅ Authentication**
- Session-based authentication
- Password protection cho upload
- AJAX authentication

### **✅ File Upload**
- Multipart file upload
- File type validation
- Authentication required

### **✅ Responsive Design**
- GitHub-inspired UI
- Mobile-friendly
- CSS Grid/Flexbox

## 🔄 Development Workflow

### **1. Chỉnh sửa dữ liệu**
```java
// File: src/main/java/com/portfolio/service/PortfolioService.java
// Sửa phương thức getUserInfo(), getSkills(), getProjects()...
```

### **2. Thay đổi giao diện**
```jsp
<!-- File: src/main/webapp/WEB-INF/views/portfolio.jsp -->
<!-- Sử dụng JSTL để hiển thị dữ liệu từ Java -->
```

### **3. Cập nhật styles**
```css
/* File: src/main/webapp/css/styles.css */
```

### **4. Test changes**
```bash
# Hot reload với Jetty
mvn jetty:run

# Hoặc rebuild WAR
mvn clean package
```

## 🐛 Troubleshooting

### **❌ Port 8080 đã được sử dụng**
```bash
# Đổi port trong pom.xml hoặc
mvn jetty:run -Djetty.port=8081
```

### **❌ Java version không đúng**  
```bash
# Kiểm tra Java version
java -version
javac -version

# Đảm bảo JAVA_HOME đúng
echo %JAVA_HOME%
```

### **❌ Maven không tìm thấy**
```bash
# Kiểm tra Maven
mvn -version

# Cài đặt Maven nếu chưa có
```

### **❌ JSP không load**
- Đảm bảo đường dẫn đúng: `/portfolio`
- Kiểm tra web.xml servlet mapping
- Xem logs trong console

## 📊 Database Integration (Tương lai)

Để kết nối database thật, sửa trong `PortfolioService.java`:

```java
// Thay vì hardcode data, query từ database
public List<Skill> getSkills() {
    // return skillDAO.findAll();
}
```

## 🔧 Customization

### **Đổi mật khẩu**
```java
// File: PortfolioService.java, line ~15
private static final String ADMIN_PASSWORD = "your_new_password";
```

### **Thêm skill mới**
```java
// File: PortfolioService.java, method getSkills()
skills.add(new Skill("Spring Boot", "Advanced", "🚀", "Java framework"));
```

### **Thay đổi thông tin cá nhân**
```java
// File: User.java constructor hoặc PortfolioService.getUserInfo()
```

---

## 🎉 **Kết quả**

✅ **Website chạy trên**: http://localhost:8080/portfolio  
✅ **Dữ liệu từ Java**: Không còn hardcode trong HTML  
✅ **API endpoints**: Có thể dùng cho mobile app  
✅ **Authentication**: Session-based với password protection  
✅ **File upload**: Multipart support với validation  
✅ **Professional**: Cấu trúc MVC chuẩn enterprise  

**Mật khẩu để nộp bài tập**: `admin123`