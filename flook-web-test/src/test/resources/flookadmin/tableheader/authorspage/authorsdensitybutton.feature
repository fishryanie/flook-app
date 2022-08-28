#Các tính năng trong nút tỉ trọng (Độ cao của các hàng).
Feature: Features in the density button of the authors page

    #Xác minh rằng nhấn vào nút tỉ trọng trong trang Tác giả thì các option sẽ được hiển thị đầy đủ.
    @AdminWeb
    Scenario: Verify that when the density button in the authors page is clicked it will display the full component
        #Bước 1: Mở website.
        Given I open the user website
        #Bước 2: Đăng nhập với tài khoản "huyhdang" và mật khẩu "Admin1@113355".
        When I login with the username "huyhdang" and the password "Admin1@113355"
        #Bước 3: Điều hướng sang trang quản lý tác giả.
        And I navigate to authors management page
        #Bước 4: Nhấn nút Density trên thanh header của bảng dữ liệu.
        And I click on the density button in table header
        #Bước 5: Xác minh rằng các option được hiển thị đầy đủ.
        Then I will see the display options fully displayed

    #Xác minh rằng chọn mỗi chế độ tỉ trọng thì các hàng sẽ thay đổi khớp với từng chế độ đó.
    @AdminWeb
    Scenario Outline: Verify that authors display modes are working correctly
        #Bước 1: Mở website.
        Given I open the user website
        #Bước 2: Đăng nhập với tài khoản "huyhdang" và mật khẩu "Admin1@113355".
        When I login with the username "huyhdang" and the password "Admin1@113355"
        And I navigate to authors management page
        #Bước 3: Điều hướng sang trang quản lý tác giả.
        And I click on the density button in table header
        #Bước 4: Chọn chế độ "<mode>".
        And I choose "<mode>" mode
        #Bước 5: Xác minh rằng bảng data sẽ hiển thị với chiều cao mỗi dòng khớp với chế độ "<mode>".
        Then I will see the data displayed in "<mode>" mode

        #Danh sách dữ liệu.
        Examples:
            |mode       |
            |Compact    |
            |Standard   |
            |Comfortable|