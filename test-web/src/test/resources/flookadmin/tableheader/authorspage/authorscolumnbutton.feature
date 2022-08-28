#Các tính năng ẩn hiện cột trên thanh header của bảng dữ liệu tác giả.
Feature: Features in the column button of the authors page

    #Xác minh rằng nhấn vào nút ẩn hiện cột trong trang Tác giả thì các thành phần sẽ được hiển thị đầy đủ.
    @AdminWeb
    Scenario: Verify that when the column button in the authors page is clicked it will display the full component
        #Bước 1: Mở website.
        Given I open the user website
        #Bước 2: Đăng nhập với tài khoản "huyhdang" và mật khẩu "Admin1@113355".
        When I login with the username "huyhdang" and the password "Admin1@113355"
        #Bước 3: Điều hướng sang trang quản lý tác giả.
        And I navigate to authors management page
        #Bước 4: Nhấn nút Column trên thanh header của bảng dữ liệu.
        And I click on the column button in table header
        #Bước 5: Xác minh rằng bảng ẩn hiện cột xuất hiện và có một khung tìm kiếm.
        Then I will see the column box appear with search edit text
        #Bước 6: Xác minh rằng toàn bộ checkbox của cột được hiển thị đầy đủ.
        And I will see all author column checkboxes are displayed
        #Bước 7: Xác minh rằng nút hiện tất cả và ẩn tất cả được hiển thị.
        And I will see hide all and show all button are displayed

    #Xác minh rằng khi nhập từ khóa vào khung search trong bảng ẩn hiện cột, danh sách các cột khớp với từ khóa sẽ được hiển thị.
    @AdminWeb
    Scenario Outline: Verify that when entering a keyword in authors page column box search box, a list of checkboxes matching the keyword will be returned
        #Bước 1: Mở website.
        Given I open the user website
        #Bước 2: Đăng nhập với tài khoản "huyhdang" và mật khẩu "Admin1@113355".
        When I login with the username "huyhdang" and the password "Admin1@113355"
        #Bước 3: Điều hướng sang trang quản lý tác giả.
        And I navigate to authors management page
        #Bước 4: Nhấn nút Column trên thanh header của bảng dữ liệu.
        And I click on the column button in table header
        #Bước 5: Nhập từ khóa "<keyWord>" vào khung search trong bảng ẩn hiện cột.
        And I enter keyword "<keyWord>" in the column box search box
        #Bước 6: Xác minh rằng các checkbox được hiển thị khớp với từ khóa "<keyWord>".
        Then I will see all column checkboxes that match the keyword "<keyWord>"

        #Danh sách dữ liệu.
        Examples:
            |keyWord |
            |St      |
            |Tên     |
            |Li      |

    #Xác minh rằng khi nhấn nút ẩn tất cả trong bảng ẩn hiện cột, thì toàn bộ cột sẽ bị ẩn đi.
    @AdminWeb
    Scenario: Verify that clicking authors page hide all button will deselect all checkboxes and hide all columns
        #Bước 1: Mở website.
        Given I open the user website
        #Bước 2: Đăng nhập với tài khoản "huyhdang" và mật khẩu "Admin1@113355".
        When I login with the username "huyhdang" and the password "Admin1@113355"
        #Bước 3: Điều hướng sang trang quản lý tác giả.
        And I navigate to authors management page
        #Bước 4: Nhấn nút Column trên thanh header của bảng dữ liệu.
        And I click on the column button in table header
        #Bước 5: Nhấn nút Hide all trong bảng ẩn hiện cột.
        And I click hide all button
        #Bước 6: Xác minh rằng toàn bộ các checkbox cột bị bỏ chọn.
        Then I will see all checkboxes unchecked
        #Bước 7: Xác minh rằng tất cả các cột bị ẩn đi.
        And I will see all columns hidden

    #Xác minh rằng khi nhấn nút hiện tất cả trong bảng ẩn hiện cột, thì toàn bộ cột sẽ hiển thị.
    @AdminWeb
    Scenario: Verify that clicking authors page show all button will select all checkboxes and show all columns
        #Bước 1: Mở website.
        Given I open the user website
        #Bước 2: Đăng nhập với tài khoản "huyhdang" và mật khẩu "Admin1@113355".
        When I login with the username "huyhdang" and the password "Admin1@113355"
        #Bước 3: Điều hướng sang trang quản lý tác giả.
        And I navigate to authors management page
        #Bước 4: Nhấn nút Column trên thanh header của bảng dữ liệu.
        And I click on the column button in table header
        #Bước 5: Nhấn nút Show all trong bảng ẩn hiện cột.
        And I click show all button
        #Bước 6: Xác minh rằng toàn bộ các checkbox cột đều được chọn.
        Then I will see all checkboxes checked
        #Bước 7: Xác minh rằng tất cả các cột được hiển thị.
        And I will see all author columns displayed

    #Xác minh rằng chức năng ẩn hiện cột trong trang Tác giả ẩn và hiện đúng cột.
    @AdminWeb
    Scenario Outline: Verify that authors page column box hides and shows the correct column
        #Bước 1: Mở website.
        Given I open the user website
        #Bước 2: Đăng nhập với tài khoản "huyhdang" và mật khẩu "Admin1@113355".
        When I login with the username "huyhdang" and the password "Admin1@113355"
        #Bước 3: Điều hướng sang trang quản lý tác giả.
        And I navigate to authors management page
        #Bước 4: Nhấn nút Column trên thanh header của bảng dữ liệu.
        And I click on the column button in table header
        #Bước 5: Nhấn nút Show all trong bảng ẩn hiện cột.
        And I click show all button
        #Bước 6: Nhấn checkbox của cột "<columnTitle>".
        And I click on "<columnTitle>" checkbox button
        #Bước 7: Xác minh rằng cột "<columnTitle>" bị ẩn đi.
        Then I will see column "<columnTitle>" hidden
        #Bước 8: Nhấn checkbox của cột "<columnTitle>".
        When I click on "<columnTitle>" checkbox button
        #Bước 7: Xác minh rằng cột "<columnTitle>" được hiển thị.
        Then I will see column "<columnTitle>" show

        #Danh sách dữ liệu.
        Examples:
            |columnTitle  |
            |Stt          |
            |Avatar       |
            |License      |
