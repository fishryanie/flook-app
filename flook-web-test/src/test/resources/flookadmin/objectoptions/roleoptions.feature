#Các chức năng trên mỗi dòng dữ liệu Vai trò.
Feature: Functions per role line

    #Xác minh rằng thông tin của Vai trò được hiển thị đầy đủ trong bảng cập nhật vai trò.
    @AdminWeb
    Scenario Outline: Verify that role information is fully displayed in the update panel
        #Bước 1: Mở website.
        Given I open the user website
        #Bước 2: Đăng nhập với tài khoản "huyhdang" và mật khẩu "Admin1@113355".
        When I login with the username "huyhdang" and the password "Admin1@113355"
        #Bước 3: Điều hướng sang trang quản lý vai trò.
        And I navigate to roles management page
        #Bước 4: Nhấn nút cập nhật vai trò với tên vai trò là "<roleName>".
        And I click on the update button of the role "<roleName>"
        #Bước 5: Xác minh rằng tên vai trò "<roleName>" được hiển thị trong khung cập nhật.
        Then I will see the role name "<roleName>" and the description "<description>"

        #Danh sách dữ liệu.
        Examples:
            |roleName |description                                                             |
            |Admin    |Admin cấp 2, người quản lý hệ thống nhưng chịu sự quản lý của moderator.|
            |User     |Người dùng đã đăng ký tài khoản và đăng nhập để sử dụng ứng dụng.       |