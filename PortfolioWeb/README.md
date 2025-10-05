# Portfolio Web Application

## Mô tả
Website portfolio cá nhân của **Đinh Hoàng Phương** - sinh viên Kỹ thuật Dữ liệu với chuyên môn Web Development và Big Data Analytics. 

Showcase các kỹ năng: Java, JSP/Servlet, Spring Boot, Big Data (Hadoop, Spark, Hive), Database Management, và DevOps.

## Cấu trúc thư mục

```
src/main/webapp/
├── index.html          # Trang chính
├── css/
│   └── styles.css      # Stylesheet chính
├── js/
│   └── main.js         # JavaScript logic
├── images/             # Thư mục chứa hình ảnh
└── WEB-INF/
    └── web.xml         # Web application descriptor
```

## Tính năng chính

### 1. Portfolio Sections
- **About Me**: Giới thiệu cá nhân
- **Skills**: Kỹ năng lập trình và công nghệ
- **Certificates**: Bằng cấp và chứng chỉ
- **Projects**: Dự án đã thực hiện
- **Assignments**: Quản lý bài tập (có xác thực)

### 2. Xác thực mật khẩu
- **Mật khẩu mặc định**: `admin123`
- **Tính năng**: Bảo vệ việc upload bài tập
- **Giao diện**: Modal popup đẹp mắt

### 3. Responsive Design
- **Mobile-first**: Tương thích mọi thiết bị
- **Modern UI**: GitHub-style design
- **Smooth animations**: Hiệu ứng mượt mà

## Cách sử dụng

### 1. Chạy trên web server
```bash
# Sao chép thư mục webapp vào web server
# Hoặc mở trực tiếp file index.html trong trình duyệt
```

### 2. Xác thực để nộp bài tập
1. Click vào tab "Bài tập"
2. Click nút "Nộp bài tập"
3. Nhập mật khẩu: `admin123`
4. Upload file sau khi xác thực thành công

### 3. Admin commands (Console)
```javascript
// Đăng nhập admin
portfolioAdmin.login('admin123')

// Đăng xuất
portfolioAdmin.logout()

// Đổi mật khẩu
portfolioAdmin.changePassword('newpassword')
```

## Công nghệ sử dụng

### Frontend
- **HTML5**: Semantic markup
- **CSS3**: Variables, Grid, Flexbox, Animations
- **JavaScript**: ES6+, DOM manipulation, Local storage
- **Font**: Inter từ Google Fonts

### Styling Features
- **Dark theme**: GitHub-inspired
- **CSS Variables**: Easy theme customization
- **Responsive Grid**: Auto-fit columns
- **Custom scrollbar**: Styled cho các trình duyệt Webkit

## Cấu hình

### Đổi mật khẩu
Sửa trong file `js/main.js`:
```javascript
const ADMIN_PASSWORD = 'your_new_password';
```

### Thay đổi thông tin cá nhân
Sửa trong file `index.html`:
```html
<div class="profile-name">Tên của bạn</div>
<div class="profile-title">Chức danh của bạn</div>
```

### Thêm dự án mới
Thêm vào section `#projects` trong `index.html`:
```html
<div class="project-item">
  <div class="project-header">
    <div>
      <div class="project-title">Tên dự án</div>
      <div class="project-description">Mô tả dự án</div>
    </div>
  </div>
  <div class="project-tags">
    <span class="tag">Technology</span>
  </div>
</div>
```

## Browser Support
- ✅ Chrome (78+)
- ✅ Firefox (70+)
- ✅ Safari (12+)
- ✅ Edge (79+)

## Performance
- **CSS**: Minified và optimized
- **Images**: Compressed và lazy loading ready
- **JavaScript**: Vanilla JS, no dependencies
- **Fonts**: Google Fonts với font-display: swap

## Security
- **Password protection**: Client-side basic auth
- **Input validation**: File type restrictions
- **XSS protection**: Proper input sanitization
- **WEB-INF**: Protected từ direct access

## Deployment

### Local Development
```bash
# Mở trực tiếp trong trình duyệt
open src/main/webapp/index.html
```

### Production
1. Upload thư mục `webapp` lên web server
2. Đảm bảo server hỗ trợ static files
3. Cấu hình HTTPS cho security
4. Enable gzip compression cho performance

## Customization

### Colors (CSS Variables)
```css
:root {
  --primary: #58a6ff;      /* Màu chính */
  --secondary: #f78166;    /* Màu phụ */
  --dark: #0d1117;         /* Background */
  --text-primary: #f0f6fc; /* Text chính */
}
```

### Layout
- Sidebar width: `300px` (có thể thay đổi trong CSS)
- Max content width: Responsive với container
- Grid columns: Auto-fit từ `320px`

## 🚀 Deploy lên Render

### Bước 1: Chuẩn bị
```bash
# Build project
mvn clean package

# Commit và push lên GitHub
git add .
git commit -m "Ready for deploy"
git push origin PortfolioWeb
```

### Bước 2: Deploy trên Render
1. Truy cập [render.com](https://render.com)
2. Tạo **Web Service** mới
3. Connect GitHub repository: `hoangphuonglxag/webSubjects`
4. Chọn branch: `PortfolioWeb`
5. Cấu hình:
   - **Build Command**: `mvn clean package`
   - **Start Command**: Để trống (sử dụng Dockerfile)
   - **Environment**: Docker
   - **Port**: 8080

### Bước 3: Environment Variables
Render sẽ tự động:
- Detect Dockerfile
- Build Docker image
- Deploy trên port 8080

### Bước 4: Custom Domain (Optional)
- Render sẽ cung cấp URL: `https://your-app-name.onrender.com`
- Có thể config custom domain sau

## 🔧 Troubleshooting Deploy

### CSS không load
- Đảm bảo `${pageContext.request.contextPath}` được sử dụng đúng
- Kiểm tra static resources mapping trong servlet

### 404 Error
- Servlet pattern đã được config: `"/"` và `"/portfolio"`
- Default ROOT.war deployment

## License
MIT License - Free for personal and commercial use.

## Contact
- **Email**: phuongdinhhoang18@gmail.com
- **GitHub**: https://github.com/hoangphuonglxag
- **Facebook**: https://www.facebook.com/hoang.phuong.081025

---
*Cập nhật lần cuối: October 2025*