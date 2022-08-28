#Các chức năng trên mỗi dòng dữ liệu Thể loại.
Feature: Functions per genre line

    #Xác minh rằng thông tin của Thể loại được hiển thị đầy đủ trong bảng cập nhật thể loại.
    @AdminWeb
    Scenario Outline: Verify that genre information is fully displayed in the update panel
        #Bước 1: Mở website.
        Given I open the user website
        #Bước 2: Đăng nhập với tài khoản "huyhdang" và mật khẩu "Admin1@113355".
        When I login with the username "huyhdang" and the password "Admin1@113355"
        #Bước 3: Điều hướng sang trang quản lý thể loại.
        And I navigate to genres management page
        #Bước 4: Nhấn nút ẩn hiện dòng trên thanh header của bảng dữ liệu.
        And I click on the column button in table header
        #Bước 5: Nhấn nút show all.
        And I click show all button
        #Bước 6: Nhấn nút cập nhật thể loại với tên thể loại là "<genreName>".
        And I click on the update button of the genre "<genreName>"
        #Bước 7: Xác minh rằng tên thể loại "<genreName>" được hiển thị trong khung cập nhật.
        Then I will see genre name "<genreName>"

        #Danh sách dữ liệu.
        Examples:
            |genreName|
            |Action   |
            |Comic    |
            |Drama    |