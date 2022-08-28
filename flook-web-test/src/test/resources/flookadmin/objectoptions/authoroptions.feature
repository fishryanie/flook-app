#Các chức năng trên mỗi dòng dữ liệu Tác giả.
Feature: Functions per author line

    #Xác minh rằng thông tin của Tác giả được hiển thị đầy đủ trong bảng cập nhật tác giả.
    @AdminWeb
    Scenario Outline: Verify that author information is fully displayed in the update panel
        #Bước 1: Mở website.
        Given I open the user website
        #Bước 2: Đăng nhập với tài khoản "huyhdang" và mật khẩu "Admin1@113355".
        When I login with the username "huyhdang" and the password "Admin1@113355"
        #Bước 3: Điều hướng sang trang quản lý tác giả.
        And I navigate to authors management page
        #Bước 4: Nhấn nút cập nhật tác giả với tên tác giả là "<authorName>".
        And I click on the update button of the author "<authorName>"
        #Bước 5: Xác minh rằng tên tác giả "<authorName>" được hiển thị trong khung cập nhật.
        Then I will see author name "<authorName>"
        #Bước 6: Nhấn nút tiếp tục.
        And I click on continue button
        #Bước 7: Xác minh rằng danh sách người quản lý của tác giả được hiển thị trong khung cập nhật với tên là "<licenses>".
        Then I will see the licenses "<licenses>"
        #Bước 8: Nhấn nút tiếp tục.
        And I click on continue button
        #Bước 9: Xác minh rằng avatar của tác giả được hiển thị với link ảnh là "<avatarLink>".
        Then I will see the author avatar with the link "<avatarLink>"
        #Bước 10: Nhấn nút trở về.
        And I click on back button
        #Bước 11: Xác minh rằng danh sách người quản lý của tác giả được hiển thị trong khung cập nhật với tên là "<licenses>".
        Then I will see the licenses "<licenses>"
        #Bước 12: Nhấn nút trở về.
        And I click on back button
        #Bước 13: Xác minh rằng tên tác giả được hiển thị trong khung cập nhật.
        Then I will see author name "<authorName>"

        #Danh sách dữ liệu.
        Examples:
            |authorName    |licenses |avatarLink               |
            |Jo YongSeuk   |Moderator|avatar-default_swe81x.png|
            |Miyazaki Hayao|Moderator|avatar-default_swe81x.png|