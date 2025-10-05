// Portfolio JavaScript for JSP version

// Portfolio Navigation functionality
const menuItems = document.querySelectorAll('.menu-item');
const contentSections = document.querySelectorAll('.content-section');

// Get global variables from JSP
const contextPath = window.contextPath || '';
const isAuthenticated = window.isAuthenticated || false;

// Initialize application
document.addEventListener('DOMContentLoaded', function() {
    initNavigation();
    initPasswordProtection();
    initSocialLinks();
    updateAuthStatus();
});

// Navigation functionality
function initNavigation() {
    menuItems.forEach(item => {
        item.addEventListener('click', () => {
            // Remove active class from all menu items
            menuItems.forEach(mi => mi.classList.remove('active'));
            // Add active class to clicked item
            item.classList.add('active');

            // Hide all content sections
            contentSections.forEach(section => section.classList.remove('active'));
            // Show target section
            const targetSection = document.getElementById(item.getAttribute('data-section'));
            if (targetSection) {
                targetSection.classList.add('active');
            }
        });
    });
}

// Password protection for assignment submission
function initPasswordProtection() {
    const modal = document.getElementById('passwordModal');
    const passwordInput = document.getElementById('passwordInput');
    const submitBtn = document.getElementById('submitPassword');
    const cancelBtn = document.getElementById('cancelPassword');
    const errorMessage = document.querySelector('.error-message');

    if (submitBtn) {
        submitBtn.addEventListener('click', function() {
            const enteredPassword = passwordInput.value;
            
            // Send authentication request to server
            fetch(contextPath + '/api/authenticate', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/x-www-form-urlencoded',
                },
                body: 'password=' + encodeURIComponent(enteredPassword)
            })
            .then(response => response.json())
            .then(data => {
                if (data.success) {
                    hidePasswordModal();
                    updateAuthStatus(true);
                    showNotification('✅ ' + data.message, 'success');
                    // Reload page để cập nhật authentication status
                    setTimeout(() => {
                        window.location.reload();
                    }, 1000);
                } else {
                    showError(data.message || 'Mật khẩu không đúng!');
                    passwordInput.value = '';
                    passwordInput.focus();
                }
            })
            .catch(error => {
                console.error('Authentication error:', error);
                showError('Lỗi kết nối server!');
            });
        });
    }

    if (cancelBtn) {
        cancelBtn.addEventListener('click', hidePasswordModal);
    }

    // Close modal when clicking outside
    if (modal) {
        modal.addEventListener('click', function(e) {
            if (e.target === modal) {
                hidePasswordModal();
            }
        });
    }

    // Enter key submission
    if (passwordInput) {
        passwordInput.addEventListener('keypress', function(e) {
            if (e.key === 'Enter') {
                submitBtn.click();
            }
        });
    }
}

// Social links with confirmation
function initSocialLinks() {
    document.querySelectorAll('.external-link').forEach(link => {
        link.addEventListener('click', function(e) {
            e.preventDefault();
            const url = this.href;
            const linkName = this.title || 'liên kết này';
            
            const confirmNewTab = confirm(`Bạn muốn mở ${linkName} ở tab mới? (OK: Tab mới, Cancel: Tab hiện tại)`);
            
            if (confirmNewTab) {
                window.open(url, '_blank', 'noopener,noreferrer');
            } else {
                window.location.href = url;
            }
        });
    });
}

// Handle file upload
function handleUpload() {
    // Kiểm tra authentication status từ server
    if (!isAuthenticated) {
        showPasswordModal();
        return;
    }
    
    const fileInput = document.getElementById('assignmentFile');
    fileInput.click();
    
    fileInput.onchange = function(e) {
        const files = e.target.files;
        if (files.length > 0) {
            uploadFiles(files);
        }
    };
}

// Upload files to server
function uploadFiles(files) {
    const formData = new FormData();
    
    // Add files to form data
    for (let i = 0; i < files.length; i++) {
        formData.append('file', files[i]);
    }
    
    // Add assignment name
    const assignmentName = prompt('Nhập tên bài tập:', 'Bài tập mới') || 'Bài tập mới';
    formData.append('assignmentName', assignmentName);
    
    // Show loading
    showNotification('📤 Đang upload...', 'info');
    
    // Send to server
    fetch(contextPath + '/api/upload', {
        method: 'POST',
        body: formData
    })
    .then(response => response.json())
    .then(data => {
        if (data.success) {
            showNotification('✅ ' + data.message, 'success');
        } else {
            showNotification('❌ ' + data.message, 'error');
        }
    })
    .catch(error => {
        console.error('Upload error:', error);
        showNotification('❌ Lỗi khi upload file!', 'error');
    });
}

// Modal functions
function showPasswordModal() {
    const modal = document.getElementById('passwordModal');
    const passwordInput = document.getElementById('passwordInput');
    
    if (modal) {
        modal.style.display = 'block';
        if (passwordInput) {
            passwordInput.focus();
        }
    }
}

function hidePasswordModal() {
    const modal = document.getElementById('passwordModal');
    const passwordInput = document.getElementById('passwordInput');
    const errorMessage = document.querySelector('.error-message');
    
    if (modal) {
        modal.style.display = 'none';
    }
    if (passwordInput) {
        passwordInput.value = '';
    }
    if (errorMessage) {
        errorMessage.style.display = 'none';
    }
}

function showError(message) {
    const errorMessage = document.querySelector('.error-message');
    if (errorMessage) {
        errorMessage.textContent = message;
        errorMessage.style.display = 'block';
    }
}

// Auth status update
function updateAuthStatus(authenticated) {
    const currentAuth = authenticated !== undefined ? authenticated : isAuthenticated;
    const uploadSection = document.querySelector('.assignment-upload');
    const authStatus = document.querySelector('.auth-status');
    
    if (uploadSection) {
        if (currentAuth) {
            uploadSection.classList.remove('disabled');
        } else {
            uploadSection.classList.add('disabled');
        }
    }
}

// Notification system
function showNotification(message, type = 'info') {
    const notification = document.createElement('div');
    notification.className = `notification ${type}`;
    notification.style.cssText = `
        position: fixed;
        top: 20px;
        right: 20px;
        background: ${type === 'success' ? 'var(--green)' : type === 'error' ? 'var(--red)' : 'var(--primary)'};
        color: white;
        padding: 1rem 1.5rem;
        border-radius: 8px;
        z-index: 1001;
        max-width: 300px;
        box-shadow: 0 4px 12px rgba(0,0,0,0.3);
        animation: slideIn 0.3s ease;
    `;
    
    notification.textContent = message;
    document.body.appendChild(notification);
    
    // Auto remove after 3 seconds
    setTimeout(() => {
        notification.style.animation = 'slideIn 0.3s ease reverse';
        setTimeout(() => {
            if (notification.parentNode) {
                notification.parentNode.removeChild(notification);
            }
        }, 300);
    }, 3000);
}

// Console help
console.log(`
Portfolio Web App - JSP Version
Context Path: ${contextPath}
Authenticated: ${isAuthenticated}
API Endpoints:
- ${contextPath}/api/user
- ${contextPath}/api/skills  
- ${contextPath}/api/projects
- ${contextPath}/api/certificates
- ${contextPath}/api/assignments
`);