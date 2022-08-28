#Các chức năng trong nút filter của trang Tác giả.
Feature: Features in the filters button of the authors page

    #Xác minh rằng khi nhấn vào nút lọc trong trang Tác giả thì tất cả phần tử được hiển thị đầy đủ.
    @AdminWeb
    Scenario: Verify that when the filters button in the authors page is clicked it will display the full component
        #Bước 1: Mở website.
        Given I open the user website
        #Bước 2: Đăng nhập với tài khoản "huyhdang" và mật khẩu "Admin1@113355".
        When I login with the username "huyhdang" and the password "Admin1@113355"
        #Bước 3: Điều hướng sang trang quản lý tác giả.
        And I navigate to authors management page
        #Bước 4: Nhấn nút Column trên thanh header của bảng dữ liệu.
        And I click on the column button in table header
        #Bước 5: Nhấn nút hiện tất cả các cột.
        And I click show all button
        #Bước 6: Nhấn nút lọc trên thanh header của bảng dữ liệu.
        And I click on the filter button in table header
        #Bước 7: Xác minh rằng khung lọc được hiển thị và có nút close.
        Then I will see the filters box appear with close icon
        #Bước 8: Xác minh rằng dropdown list danh sách cột có đầy đủ tên các cột.
        And I will see column dropdown list with full options
        #Bước 9: Xác minh rằng dropdown list danh sách kiểu tìm kiếm hiển thị đầy đủ các option.
        And I will see operator dropdown list with full options
        #Bước 10: Xác minh rằng khung nhập từ khóa được hiển thị.
        And I will see filter value edit text

    #Xác minh rằng chế độ lọc contains trả về kết quả chính xác.
    @AdminWeb
    Scenario Outline: Verify that contains filter mode returns correct results
        #Bước 1: Mở website.
        Given I open the user website
        #Bước 2: Đăng nhập với tài khoản "huyhdang" và mật khẩu "Admin1@113355".
        When I login with the username "huyhdang" and the password "Admin1@113355"
        #Bước 3: Điều hướng sang trang quản lý tác giả.
        And I navigate to authors management page
        #Bước 4: Nhấn nút Column trên thanh header của bảng dữ liệu.
        And I click on the column button in table header
        #Bước 5: Nhấn nút ẩn tất cả.
        And I click hide all button
        #Bước 6: Nhấn chọn checkbox của cột "<columnTitle>".
        And I click on "<columnTitle>" checkbox button
        #Bước 7: Nhấn nút Filter trên thanh header của bảng dữ liệu.
        And I click on the filter button in table header
        #Bước 8: Chọn cột "<columnTitle>" trong dropdown list đầu tiên.
        And I select the column "<columnTitle>" in column dropdown list
        #Bước 9: Chọn option "contains" trong dropdown list thứ 2.
        And I select the option "contains" in operator dropdown list
        #Bước 10: Nhập từ khóa "<keyWord>" vào khung từ khóa.
        And I enter the key word "<keyWord>" in value edit text
        #Bước 11: Xác minh rằng danh sách tác giả trả về khớp với từ khóa "<keyWord>".
        Then I will see a list of authors that contain the key word "<keyWord>"

        #Danh sách dữ liệu.
        Examples:
            |columnTitle  |keyWord|
            |Stt          |1      |
            |Tên          |Ao     |
            |License      |Mo     |

    #Xác minh rằng chế độ lọc equals trả về kết quả chính xác.
    @AdminWeb
    Scenario Outline: Verify that equals filter mode returns correct results
        #Bước 1: Mở website.
        Given I open the user website
        #Bước 2: Đăng nhập với tài khoản "huyhdang" và mật khẩu "Admin1@113355".
        When I login with the username "huyhdang" and the password "Admin1@113355"
        #Bước 3: Điều hướng sang trang quản lý tác giả.
        And I navigate to authors management page
        #Bước 4: Nhấn nút Column trên thanh header của bảng dữ liệu.
        And I click on the column button in table header
        #Bước 5: Nhấn nút ẩn tất cả.
        And I click hide all button
        #Bước 6: Chọn checkbox của cột "<columnTitle>".
        And I click on "<columnTitle>" checkbox button
        #Bước 7: Nhấn nút Filter trên thanh header của bảng dữ liệu.
        And I click on the filter button in table header
        #Bước 8: Chọn cột "<columnTitle>" trong dropdown list danh sách cột.
        And I select the column "<columnTitle>" in column dropdown list
        #Bước 9: Chọn kiểu tìm kiếm "equals" trong dropdown list danh sách kiểu tìm kiếm.
        And I select the option "equals" in operator dropdown list
        #Bước 10: Nhập từ khóa "<keyWord>" vào khung từ khóa.
        And I enter the key word "<keyWord>" in value edit text
        #Bước 11: Xác minh rằng danh sách Tác giả trả về khớp với từ khóa "<keyWord>".
        Then I will see a list of authors that equal the key word "<keyWord>"

        #Danh sách dữ liệu.
        Examples:
            |columnTitle|keyWord     |
            |Stt        |11          |
            |Tên        |Oda Eiichiro|
            |License    |Moderator   |

    #Xác minh rằng chế độ lọc starts with trả về kết quả chính xác.
    @AdminWeb
    Scenario Outline: Verify that starts with filter mode returns correct results
        #Bước 1: Mở website.
        Given I open the user website
        #Bước 2: Đăng nhập với tài khoản "huyhdang" và mật khẩu "Admin1@113355".
        When I login with the username "huyhdang" and the password "Admin1@113355"
        #Bước 3: Điều hướng sang trang quản lý tác giả.
        And I navigate to authors management page
        #Bước 4: Nhấn nút Column trên thanh header của bảng dữ liệu.
        And I click on the column button in table header
        #Bước 5: Nhấn nút ẩn tất cả.
        And I click hide all button
        #Bước 6: Chọn checkbox của cột "<columnTitle>".
        And I click on "<columnTitle>" checkbox button
        #Bước 7: Nhấn nút Filter trên thanh header của bảng dữ liệu.
        And I click on the filter button in table header
        #Bước 8: Chọn cột "<columnTitle>" trong dropdown list danh sách cột.
        And I select the column "<columnTitle>" in column dropdown list
        #Bước 9: Chọn kiểu tìm kiếm "starts with" trong dropdown list danh sách kiểu tìm kiếm.
        And I select the option "starts with" in operator dropdown list
        #Bước 10: Nhập từ khóa "<keyWord>" vào khung từ khóa.
        And I enter the key word "<keyWord>" in value edit text
        #Bước 11: Xác minh rằng danh sách Tác giả trả về khớp với từ khóa "<keyWord>".
        Then I will see a list of authors that star with the key word "<keyWord>"

        #Danh sách dữ liệu.
        Examples:
            |columnTitle|keyWord  |
            |Stt        |1        |
            |Tên        |Oda      |
            |License    |Moder    |

    #Xác minh rằng chế độ lọc ends with trả về kết quả chính xác.
    @AdminWeb
    Scenario Outline: Verify that ends with filter mode returns correct results
        #Bước 1: Mở website.
        Given I open the user website
        #Bước 2: Đăng nhập với tài khoản "huyhdang" và mật khẩu "Admin1@113355".
        When I login with the username "huyhdang" and the password "Admin1@113355"
        #Bước 3: Điều hướng sang trang quản lý tác giả.
        And I navigate to authors management page
        #Bước 4: Nhấn nút Column trên thanh header của bảng dữ liệu.
        And I click on the column button in table header
        #Bước 5: Nhấn nút ẩn tất cả.
        And I click hide all button
        #Bước 6: Chọn checkbox của cột "<columnTitle>".
        And I click on "<columnTitle>" checkbox button
        #Bước 7: Nhấn nút Filter trên thanh header của bảng dữ liệu.
        And I click on the filter button in table header
        #Bước 8: Chọn cột "<columnTitle>" trong dropdown list danh sách cột.
        And I select the column "<columnTitle>" in column dropdown list
        #Bước 9: Chọn kiểu tìm kiếm "ends with" trong dropdown list danh sách kiểu tìm kiếm.
        And I select the option "ends with" in operator dropdown list
        #Bước 10: Nhập từ khóa "<keyWord>" vào khung từ khóa.
        And I enter the key word "<keyWord>" in value edit text
        #Bước 11: Xác minh rằng danh sách Tác giả trả về khớp với từ khóa "<keyWord>".
        Then I will see a list of authors that end with the key word "<keyWord>"

        #Danh sách dữ liệu.
        Examples:
            |columnTitle|keyWord|
            |Stt        |1      |
            |Tên        |ra     |
            |License    |or     |

    #Xác minh rằng chọn chế độ lọc is empty thì khung nhập từ khóa sẽ bị ẩn đi.
    @AdminWeb
    Scenario: Verify that is empty filter mode hides the value input box
        #Bước 1: Mở website.
        Given I open the user website
        #Bước 2: Đăng nhập với tài khoản "huyhdang" và mật khẩu "Admin1@113355".
        When I login with the username "huyhdang" and the password "Admin1@113355"
        #Bước 3: Điều hướng sang trang quản lý tác giả.
        And I navigate to authors management page
        #Bước 4: Nhấn nút Column trên thanh header của bảng dữ liệu.
        And I click on the filter button in table header
        #Bước 5: Chọn kiểu tìm kiếm "is empty" trong dropdown list danh sách kiểu tìm kiếm.
        And I select the option "is empty" in operator dropdown list
        #Bước 6: Xác minh rằng khung nhập từ khóa bị ẩn đi.
        Then I will see value input box is hidden

    #Xác minh rằng chế độ lọc is empty sẽ trả về kết quả chính xác.
    @AdminWeb
    Scenario Outline: Verify that is empty filter mode returns correct results\
        #Bước 1: Mở website.
        Given I open the user website
        #Bước 2: Đăng nhập với tài khoản "huyhdang" và mật khẩu "Admin1@113355".
        When I login with the username "huyhdang" and the password "Admin1@113355"
        #Bước 3: Điều hướng sang trang quản lý tác giả.
        And I navigate to authors management page
        #Bước 4: Nhấn nút Column trên thanh header của bảng dữ liệu.
        And I click on the column button in table header
        #Bước 5: Nhấn nút ẩn tất cả.
        And I click hide all button
        #Bước 6: Chọn checkbox của cột "<columnTitle>".
        And I click on "<columnTitle>" checkbox button
        #Bước 7: Nhấn nút Filter trên thanh header của bảng dữ liệu.
        And I click on the filter button in table header
        #Bước 8: Chọn cột "<columnTitle>" trong dropdown list danh sách cột.
        And I select the column "<columnTitle>" in column dropdown list
        #Bước 9: Chọn kiểu tìm kiếm "is empty" trong dropdown list danh sách kiểu tìm kiếm.
        And I select the option "is empty" in operator dropdown list
        #Bước 10: Xác minh rằng danh sách Tác giả trả về khớp với từ khóa "<keyWord>".
        Then I will see a list of authors that is empty

        #Danh sách dữ liệu.
        Examples:
            |columnTitle|
            |License    |

    #Xác minh rằng chế độ lọc is not empty sẽ ẩn khung nhập từ khóa.
    @AdminWeb
    Scenario: Verify that is not empty filter mode hides the value input box
        #Bước 1: Mở website.
        Given I open the user website
        #Bước 2: Đăng nhập với tài khoản "huyhdang" và mật khẩu "Admin1@113355".
        When I login with the username "huyhdang" and the password "Admin1@113355"
        #Bước 3: Điều hướng sang trang quản lý tác giả.
        And I navigate to authors management page
        #Bước 4: Nhấn nút Filter trên thanh header của bảng dữ liệu.
        And I click on the filter button in table header
        #Bước 5: Chọn kiểu tìm kiếm "is not empty" trong dropdown list danh sách kiểu tìm kiếm.
        And I select the option "is not empty" in operator dropdown list
        #Bước 6: Xác minh rằng khung nhập từ khóa bị ẩn đi.
        Then I will see value input box is hidden

    #Xác minh rằng chế độ lọc is not empty trả về kết quả chính xác.
    @AdminWeb
    Scenario Outline: Verify that is not empty filter mode returns correct results
        #Bước 1: Mở website.
        Given I open the user website
        #Bước 2: Đăng nhập với tài khoản "huyhdang" và mật khẩu "Admin1@113355".
        When I login with the username "huyhdang" and the password "Admin1@113355"
        #Bước 3: Điều hướng sang trang quản lý tác giả.
        And I navigate to authors management page
        #Bước 4: Nhấn nút Column trên thanh header của bảng dữ liệu.
        And I click on the column button in table header
        #Bước 5: Nhấn nút ẩn tất cả.
        And I click hide all button
        #Bước 6: Chọn checkbox của cột "<columnTitle>".
        And I click on "<columnTitle>" checkbox button
        #Bước 7: Nhấn nút Filter trên thanh header của bảng dữ liệu.
        And I click on the filter button in table header
        #Bước 8: Chọn cột "<columnTitle>" trong dropdown list danh sách cột.
        And I select the column "<columnTitle>" in column dropdown list
        #Bước 9: Chọn kiểu tìm kiếm "is not empty" trong dropdown list danh sách kiểu tìm kiếm.
        And I select the option "is not empty" in operator dropdown list
        #Bước 10: Xác minh rằng danh sách tác giả trả về không có kết quả nào là rỗng.
        Then I will see a list of authors that is not empty
        Examples:
            |columnTitle|
            |License    |

    #Xác minh rằng nút đóng trong bảng lọc hoạt động chính xác.
    @AdminWeb
    Scenario: Verify that the close button in the filters box works correctly
        #Bước 1: Mở website.
        Given I open the user website
        #Bước 2: Đăng nhập với tài khoản "huyhdang" và mật khẩu "Admin1@113355".
        When I login with the username "huyhdang" and the password "Admin1@113355"
        #Bước 3: Điều hướng sang trang quản lý tác giả.
        And I navigate to authors management page
        #Bước 4: Nhấn nút Column trên thanh header của bảng dữ liệu.
        And I click on the filter button in table header
        #Bước 5: Chọn cột "Tên" trong dropdown list danh sách cột.
        And I select the column "Tên" in column dropdown list
        #Bước 6: Chọn kiểu tìm kiếm "equals" trong dropdown list danh sách kiểu tìm kiếm.
        And I select the option "equals" in operator dropdown list
        #Bước 7: Nhập từ khóa "abc" vào khung từ khóa.
        And I enter the key word "abc" in value edit text
        #Bước 8: Nhấn nút close trong bảng Filter.
        And I click close button in filters box
        #Bước 9: Xác minh rằng giá trị trong khung nhập từ khóa được xóa trắng.
        Then I will see value edit text is empty
        #Bước 10: Nhấn nút close trong bảng Filter.
        When I click close button in filters box
        #Bước 11: Mở lại bảng Filter.
        And I click on the filter button in table header
        #Bước 12: Xác minh rằng cột được chọn trong dropdown list cột là "Stt".
        Then I will see the value of the column dropdown list as "Stt"
        #Bước 13: Xác minh rằng chế độ tìm kiếm đang được chọn là "contains".
        And I will see the value of the operator dropdown list as "contains"