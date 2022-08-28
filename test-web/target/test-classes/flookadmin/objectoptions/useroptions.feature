#Các chức năng trên mỗi dòng dữ liệu Người dùng.
Feature: Functions per user line

    #Xác minh rằng tài khoản không được kích hoạt thì khồn thể sử dụng.
    @AdminWeb
    Scenario Outline: Verify that the account is not activated it cannot be used
        #Bước 1: Mở website.
        Given I open the user website
        #Bước 2: Đăng nhập với tài khoản "huyhdang" và mật khẩu "Admin1@113355".
        When I login with the username "huyhdang" and the password "Admin1@113355"
        #Bước 3: Điều hướng sang trang quản lý người dùng.
        And I navigate to user management page
        #Bước 4: Nhấn nút kích hoạt người dùng với email là "<email>".
        And I click on the active button of the user that have the email "<email>"
        #Bước 5: Đăng xuất khỏi tài khoản.
        And I log out of my account
        #Bước 6: Đăng nhập với tài khoản "<userName>" và mật khẩu "<passWord>".
        And I login with the username "<userName>" and the password "<passWord>"
        #Bước 7: Xác minh rằng hệ thống hiển thị thông báo "<message>".
        Then I will see the message "<message>"

        #Danh sách dữ liệu.
        Examples:
            |email                     |userName      |passWord     |message              |
            |thanhlehuu223346@gmail.com|thanhlehuu223 |Abc*123456789|Account not activated|
            |trunghoang1145@gmail.com  |trunghoang1145|Abc*123456789|Account not activated|
            |vule33406@gmail.com       |vule33406     |Abc*123456789|Account not activated|

    #Xác minh rằng thông tin của Người dùng được hiển thị đầy đủ trong bảng cập nhật người dùng.
    @AdminWeb
    Scenario Outline: Verify that user information is fully displayed in the update panel
        #Bước 1: Mở website.
        Given I open the user website
        #Bước 2: Đăng nhập với tài khoản "huyhdang" và mật khẩu "Admin1@113355".
        When I login with the username "huyhdang" and the password "Admin1@113355"
        #Bước 3: Điều hướng sang trang quản lý người dùng.
        And I navigate to user management page
        #Bước 4: Nhấn nút cập nhật người dùng với email là "<email>".
        And I click on the update button of the user "<email>"
        #Bước 5: Xác minh rằng tên hiển thị "<displayName>", số điện thoại "<phoneNumber>", tên đăng nhập "<username>"
        #và email "<email>" được hiển thị trong khung cập nhật.
        Then I will see display name "<displayName>", phone number "<phoneNumber>", username "<username>" and email "<email>"
        #Bước 6: Nhấn nút tiếp tục.
        And I click on continue button
        #Bước 7: Xác minh rằng trạng thái active "<activeStatus>" được chọn đúng.
        Then I will see the activation status "<activeStatus>"
        #Bước 8: Nhấn nút tiếp tục.
        And I click on continue button
        #Bước 9: Xác minh rằng danh sách vai trò "<roles>" được hiển thị trong khung cập nhật.
        Then I will see the roles "<roles>"
        #Bước 10: Nhấn nút tiếp tục.
        And I click on continue button
        #Bước 11: Xác minh rằng avatar được hiển thị với link ảnh là "<avatarLink>".
        Then I will see the avatar with the link "<avatarLink>"
        #Bước 12: Nhấn nút trở về.
        And I click on back button
        #Bước 13: Xác minh rằng danh sách vai trò "<roles>" được hiển thị trong khung cập nhật.
        Then I will see the roles "<roles>"
        #Bước 14: Nhấn nút trở về.
        And I click on back button
        #Bước 15: Xác minh rằng danh sách vai trò "<roles>" được hiển thị trong khung cập nhật.
        Then I will see the activation status "<activeStatus>"
        #Bước 16: Nhấn nút trở về.
        And I click on back button
        #Bước 5: Xác minh rằng tên hiển thị "<displayName>", số điện thoại "<phoneNumber>", tên đăng nhập "<username>"
        #và email "<email>" được hiển thị trong khung cập nhật.
        Then I will see display name "<displayName>", phone number "<phoneNumber>", username "<username>" and email "<email>"

        #Danh sách dữ liệu.
        Examples:
            |email                     |displayName     |phoneNumber|username      |activeStatus|roles       |avatarLink        |
            |thanhlehuu223346@gmail.com|Lê Hữu Thành    |0365896574 |thanhlehuu223 |Active      |User, Author|avatar3_xfgktr.jpg|
            |trunghoang1145@gmail.com  |Hoàng Linh Trung|0986854785 |trunghoang1145|Active      |User, Author|avatar2_qlfcln.jpg|
            |vule33406@gmail.com       |Lê Minh Vũ      |0963254156 |vule33406     |Active      |User, Author|avatar6_scignc.jpg|