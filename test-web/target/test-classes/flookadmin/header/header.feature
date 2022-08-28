#Các tính năng trên thanh header.
Feature: The features on header

    #Xác minh rằng đường dẫn của logo là chính xác
    @AdminWeb
    Scenario: Verify logo path is correct
        #Bước 1: Mở website.
        Given I open the user website
        #Bước 2: Đăng nhập với tài khoản "huyhdang" và mật khẩu "Admin1@113355".
        When I login with the username "huyhdang" and the password "Admin1@113355"
        #Bước 3: Điều hướng sang trang admin.
        And I navigate to admin page
        #Bước 4: Nhấn logo trên thanh header.
        And I click on the logo in the admin page
        #Bước 5: Xác nhận rằng hệ thống điều hướng về trang người dùng.
        Then I will see the system take me back to the user page

    #Xác minh rằng khung menu trái thay đổi trạng thái ẩn hiện khi click vào nút menu trên thanh header.
    @AdminWeb
    Scenario: Verify that the menu changes display state when the menu button is pressed
        #Bước 1: Mở website.
        Given I open the user website
        #Bước 2: Đăng nhập với tài khoản "huyhdang" và mật khẩu "Admin1@113355".
        When I login with the username "huyhdang" and the password "Admin1@113355"
        #Bước 3: Điều hướng sang trang admin.
        And I navigate to admin page
        #Bước 4: Nhấn nút menu trên thang header.
        And I click on the menu button
        #Bước 5: Xác minh rằng thanh menu bị ẩn đi.
        Then I will see the display status of the menu as "false"
        #Bước 6: Nhấn nút menu trên thang header lần nữa.
        When I click on the menu button
        #Bước 7: Xác minh rằng thanh menu được hiển thị trở lại.
        Then I will see the display status of the menu as "true"

    #Xác minh rằng khung search trả về kết quả khớp với từ khóa.
    #Chức năng đang cập nhật!
    @AdminWeb
    Scenario: Verify that the search engine returns results that match the keyword
        #Bước 1: Mở website.
        Given I open the user website
        #Bước 2: Đăng nhập với tài khoản "huyhdang" và mật khẩu "Admin1@113355".
        When I login with the username "huyhdang" and the password "Admin1@113355"
        #Bước 3: Điều hướng sang trang admin.
        And I navigate to admin page
        #Bước 4: Nhập từ khóa "Đặng Hoàng Huy" vào khung tìm kiếm.
        And I enter the key word "Đặng Hoàng Huy" in the search box
        #Bước 5: Xác minh rằng kết quả trả về khớp với từ khóa "Đặng Hoàng Huy".
        #Hoặc hiển thị thông báo "Chức năng đang cập nhật".
        Then I will see results that match the key word "Đặng Hoàng Huy"
        #Bước 6: Nhập từ khóa "Anh Hùng, Hồi Quy" vào khung tìm kiếm.
        When I enter the key word "Anh Hùng, Hồi Quy" in the search box
        #Bước 7: Xác minh rằng kết quả trả về khớp với từ khóa "Anh Hùng, Hồi Quy".
        #Hoặc hiển thị thông báo "Chức năng đang cập nhật".
        Then I will see results that match the key word "Anh Hùng, Hồi Quy"
        #Bước 8: Nhập từ khóa "Admin" vào khung tìm kiếm.
        When I enter the key word "Admin" in the search box
        #Bước 9: Xác minh rằng kết quả trả về khớp với từ khóa "Admin".
        #Hoặc hiển thị thông báo "Chức năng đang cập nhật".
        Then I will see results that match the key word "Admin"

    #Xác minh rằng nút thông báo sẽ hiển thị danh sách thông báo khi bấm vào.
    #Chức năng đang cập nhật!
    @AdminWeb
    Scenario: Verify that the notification button shows a list of notifications when pressed
        #Bước 1: Mở website.
        Given I open the user website
        #Bước 2: Đăng nhập với tài khoản "huyhdang" và mật khẩu "Admin1@113355".
        When I login with the username "huyhdang" and the password "Admin1@113355"
        #Bước 3: Điều hướng sang trang admin.
        And I navigate to admin page
        #Bước 4: Nhấn nút thông báo trên thanh header.
        And I click on the notification button in the admin page
        #Bước 5: Xác minh rằng hệ thống hiển thị thông báo "Chức năng đang cập nhật!".
        Then I will see the message "Chức năng đang cập nhật!"

    #Xác minh rằng nhấn nút cài đặt trên thanh header sẽ hiển thị đầy đủ lựa chọn.
    @AdminWeb
    Scenario: Verify account settings button shows full options when clicked
        #Bước 1: Mở website.
        Given I open the user website
        #Bước 2: Đăng nhập với tài khoản "huyhdang" và mật khẩu "Admin1@113355".
        When I login with the username "huyhdang" and the password "Admin1@113355"
        #Bước 3: Điều hướng sang trang admin.
        And I navigate to admin page
        #Bước 4: Nhấn nút cài đặt trên thanh header.
        And I click on the account setting button in the admin page
        #Bước 5: Xác minh rằng toàn bộ option được hiển thị đầy đủ: Cài đặt tài khoản, Đăng xuất.
        Then I will see all elements in user setting box are display

    #Xác minh rằng nhấn vào option cài đặt tài khoản trong danh sách cài đặt sẽ chuyển người dùng đến trang cài đặt tài khoản.
    #Chức năng đang cập nhật!
    @AdminWeb
    Scenario: Verify that pressing the account settings button in the account settings box will navigate to the account page
        #Bước 1: Mở website.
        Given I open the user website
        #Bước 2: Đăng nhập với tài khoản "huyhdang" và mật khẩu "Admin1@113355".
        When I login with the username "huyhdang" and the password "Admin1@113355"
        #Bước 3: Điều hướng sang trang admin.
        And I navigate to admin page
        #Bước 4: Nhấn nút cài đặt trên thanh header.
        And I click on the account setting button in the admin page
        #Bước 5: Nhấn option cài đặt tài khoản trên khung cài đặt.
        And I click on the account setting button in account box
        #Bước 6: Xác minh rằng hệ thống điều hướng sang trang cài đặt tài khoản.
        #Hoặc hiển thị thông báo "Chức năng đang cập nhật!".
        Then I will see the message "Chức năng đang cập nhật!"

    #Xác minh rằng nhấn vào option đăng xuất, hệ thống sẽ đăng xuất tài khoản và điều hướng sang trang người dùng.
    @AdminWeb
    Scenario: Verify that pressing the log out button, the system will log out and navigate to the user page
        #Bước 1: Mở website.
        Given I open the user website
        #Bước 2: Đăng nhập với tài khoản "huyhdang" và mật khẩu "Admin1@113355".
        When I login with the username "huyhdang" and the password "Admin1@113355"
        #Bước 3: Điều hướng sang trang admin.
        And I navigate to admin page
        #Bước 4: Nhấn nút cài đặt trên thanh header.
        And I click on the account setting button in the admin page
        #Bước 5: Nhấn option đăng xuất trong khung cài đặt.
        And I click on the log out button in account box
        #Bước 6: Xác minh rằng hệ thống điều hướng về trang người dùng.
        Then I will see the system take me back to the user page
        #Bước 7: Xác minh rằng hệ thống đã đăng xuất tài khoản.
        And I will see the system log out