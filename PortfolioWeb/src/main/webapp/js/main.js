// Portfolio Navigation functionality
const menuItems = document.querySelectorAll('.menu-item');
const contentSections = document.querySelectorAll('.content-section');

// Password authentication
const ADMIN_PASSWORD = 'admin123'; // Thay đổi mật khẩu theo ý muốn
let isAuthenticated = false;

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
    const uploadButton = document.querySelector('.upload-button');
    const modal = document.getElementById('passwordModal');
    const passwordInput = document.getElementById('passwordInput');
    const submitBtn = document.getElementById('submitPassword');
    const cancelBtn = document.getElementById('cancelPassword');
    const errorMessage = document.querySelector('.error-message');

    if (uploadButton) {
        uploadButton.addEventListener('click', function(e) {
            if (!isAuthenticated) {
                e.preventDefault();
                e.stopPropagation();
                showPasswordModal();
            } else {
                // Allow file selection if authenticated
                document.getElementById('assignmentFile').click();
            }
        });
    }

    if (submitBtn) {
        submitBtn.addEventListener('click', function() {
            const enteredPassword = passwordInput.value;
            if (enteredPassword === ADMIN_PASSWORD) {
                isAuthenticated = true;
                hidePasswordModal();
                updateAuthStatus();
                // Show success message
                showNotification('✅ Xác thực thành công! Bạn có thể nộp bài tập.', 'success');
            } else {
                showError('Mật khẩu không đúng!');
                passwordInput.value = '';
                passwordInput.focus();
            }
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
function updateAuthStatus() {
    const uploadSection = document.querySelector('.assignment-upload');
    const authStatus = document.querySelector('.auth-status');
    
    if (uploadSection) {
        if (isAuthenticated) {
            uploadSection.classList.remove('disabled');
        } else {
            uploadSection.classList.add('disabled');
        }
    }
    
    if (authStatus) {
        if (isAuthenticated) {
            authStatus.className = 'auth-status authenticated';
            authStatus.innerHTML = '🔓 Đã xác thực - Có thể nộp bài tập';
        } else {
            authStatus.className = 'auth-status unauthenticated';
            authStatus.innerHTML = '🔒 Chưa xác thực - Cần nhập mật khẩu để nộp bài tập';
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
        background: ${type === 'success' ? 'var(--green)' : 'var(--primary)'};
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
    
    // Add slide in animation
    const style = document.createElement('style');
    style.textContent = `
        @keyframes slideIn {
            from { transform: translateX(100%); opacity: 0; }
            to { transform: translateX(0); opacity: 1; }
        }
    `;
    document.head.appendChild(style);
    
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

// File upload handler
function handleFileUpload() {
    const fileInput = document.getElementById('assignmentFile');
    
    if (fileInput && isAuthenticated) {
        fileInput.addEventListener('change', function(e) {
            const files = e.target.files;
            if (files.length > 0) {
                let fileNames = Array.from(files).map(file => file.name).join(', ');
                showNotification(`📁 Đã chọn file: ${fileNames}`, 'success');
                
                // Here you would typically upload the files to server
                // For demo purposes, we'll just show a success message
                setTimeout(() => {
                    showNotification('✅ Upload thành công!', 'success');
                }, 1000);
            }
        });
    }
}

// Initialize file upload when DOM is loaded
document.addEventListener('DOMContentLoaded', handleFileUpload);

// Admin functions (for development/testing)
window.portfolioAdmin = {
    login: function(password) {
        if (password === ADMIN_PASSWORD) {
            isAuthenticated = true;
            updateAuthStatus();
            showNotification('✅ Admin login thành công!', 'success');
            return true;
        } else {
            showNotification('❌ Sai mật khẩu admin!', 'error');
            return false;
        }
    },
    
    logout: function() {
        isAuthenticated = false;
        updateAuthStatus();
        showNotification('🔒 Đã đăng xuất!', 'info');
    },
    
    changePassword: function(newPassword) {
        if (newPassword && newPassword.length >= 6) {
            // Trong thực tế, bạn sẽ cần lưu vào database
            console.log('Password changed to:', newPassword);
            showNotification('✅ Đã đổi mật khẩu!', 'success');
            return true;
        } else {
            showNotification('❌ Mật khẩu phải có ít nhất 6 ký tự!', 'error');
            return false;
        }
    }
};

// Console help
console.log(`
Portfolio Admin Commands:
- portfolioAdmin.login('password') - Đăng nhập admin
- portfolioAdmin.logout() - Đăng xuất
- portfolioAdmin.changePassword('newpass') - Đổi mật khẩu

Current password: ${ADMIN_PASSWORD}
`);