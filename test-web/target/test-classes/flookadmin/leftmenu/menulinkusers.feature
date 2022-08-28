#Xác minh các đường link menu trong trang Người dùng là chính xác
Feature: The features on left menu on users management page

    #Xác minh rằng link dẫn đến trang Thống kê trên menu của trang Người dùng là chính xác.
    @AdminWeb
    Scenario: Verify that the Dashboard page link in the User page are available
        #Bước 1: Mở website.
        Given I open the user website
        #Bước 2: Đăng nhập với tài khoản "huyhdang" và mật khẩu "Admin1@113355".
        When I login with the username "huyhdang" and the password "Admin1@113355"
        #Bước 3: Điều hướng sang trang quản lý người dùng
        And I navigate to user management page
        #Bước 4: Nhấn tab Thống kê trên khung menu trái.
        And I click dashboard tab in left menu
        #Bước 5: Xác minh rằng hệ thống điều hướng sang trang Thống kê.
        Then I will be navigated to Dashboard page

    #Xác minh rằng link dẫn đến trang Vai trò trên menu của trang Người dùng là chính xác.
    @AdminWeb
    Scenario: Verify that the Role page link in the User page are available
        #Bước 1: Mở website.
        Given I open the user website
        #Bước 2: Đăng nhập với tài khoản "huyhdang" và mật khẩu "Admin1@113355".
        When I login with the username "huyhdang" and the password "Admin1@113355"
        #Bước 3: Điều hướng sang trang quản lý người dùng
        And I navigate to user management page
        #Bước 4: Nhấn tab Vai trò trên khung menu trái.
        And I click roles tab in left menu
        #Bước 5: Xác minh rằng hệ thống điều hướng sang trang Vai trò.
        Then I will see the system navigate to "Vai Trò" page

    #Xác minh rằng link dẫn đến trang Sách trên menu của trang Người dùng là chính xác.
    @AdminWeb
    Scenario: Verify that the Ebooks page link in the User page are available
        #Bước 1: Mở website.
        Given I open the user website
        #Bước 2: Đăng nhập với tài khoản "huyhdang" và mật khẩu "Admin1@113355".
        When I login with the username "huyhdang" and the password "Admin1@113355"
        #Bước 3: Điều hướng sang trang quản lý người dùng
        And I navigate to user management page
        #Bước 4: Nhấn tab Truyện trên khung menu trái.
        And I click ebooks tab in left menu
        #Bước 5: Xác minh rằng hệ thống điều hướng sang trang Truyện.
        Then I will see the system navigate to "Truyện Tranh" page

    #Xác minh rằng link dẫn đến trang Tác giả trên menu của trang Người dùng là chính xác.
    @AdminWeb
    Scenario: Verify that the Authors page link in the User page are available
        #Bước 1: Mở website.
        Given I open the user website
        #Bước 2: Đăng nhập với tài khoản "huyhdang" và mật khẩu "Admin1@113355".
        When I login with the username "huyhdang" and the password "Admin1@113355"
        #Bước 3: Điều hướng sang trang quản lý người dùng
        And I navigate to user management page
        #Bước 4: Nhấn tab Tác giả trên khung menu trái.
        And I click authors tab in left menu
        #Bước 5: Xác minh rằng hệ thống điều hướng sang trang Tác giả.
        Then I will see the system navigate to "Tác Giả" page

    #Xác minh rằng link dẫn đến trang Thể loại trên menu của trang Người dùng là chính xác.
    @AdminWeb
    Scenario: Verify that the Genres page link in the User page are available
        #Bước 1: Mở website.
        Given I open the user website
        #Bước 2: Đăng nhập với tài khoản "huyhdang" và mật khẩu "Admin1@113355".
        When I login with the username "huyhdang" and the password "Admin1@113355"
        #Bước 3: Điều hướng sang trang quản lý người dùng
        And I navigate to user management page
        #Bước 4: Nhấn tab Thể loại trên khung menu trái.
        And I click genres tab in left menu
        #Bước 5: Xác minh rằng hệ thống điều hướng sang trang Thể loại.
        Then I will see the system navigate to "Thể Loại" page

    #Xác minh rằng link dẫn đến trang Chapters trên menu của trang Người dùng là chính xác.
    @AdminWeb
    Scenario: Verify that the Chapters page link in the User page are available
        #Bước 1: Mở website.
        Given I open the user website
        #Bước 2: Đăng nhập với tài khoản "huyhdang" và mật khẩu "Admin1@113355".
        When I login with the username "huyhdang" and the password "Admin1@113355"
        #Bước 3: Điều hướng sang trang quản lý người dùng
        And I navigate to user management page
        #Bước 4: Nhấn tab Chapters trên khung menu trái.
        And I click chapters tab in left menu
        #Bước 5: Xác minh rằng hệ thống điều hướng sang trang Chapters.
        Then I will see the system navigate to "Chapter" page

    #Xác minh rằng link dẫn đến trang Đánh giá trên menu của trang Người dùng là chính xác.
    @AdminWeb
    Scenario: Verify that the Reviews page link in the User page are available
        #Bước 1: Mở website.
        Given I open the user website
        #Bước 2: Đăng nhập với tài khoản "huyhdang" và mật khẩu "Admin1@113355".
        When I login with the username "huyhdang" and the password "Admin1@113355"
        #Bước 3: Điều hướng sang trang quản lý người dùng
        And I navigate to user management page
        #Bước 4: Nhấn tab Đánh giá trên khung menu trái.
        And I click reviews tab in left menu
        #Bước 5: Xác minh rằng hệ thống điều hướng sang trang Đánh giá.
        Then I will see the system redirect me to the "review" page

    #Xác minh rằng link dẫn đến trang Bình luận trên menu của trang Người dùng là chính xác.
    @AdminWeb
    Scenario: Verify that the Comments page link in the User page are available
        #Bước 1: Mở website.
        Given I open the user website
        #Bước 2: Đăng nhập với tài khoản "huyhdang" và mật khẩu "Admin1@113355".
        When I login with the username "huyhdang" and the password "Admin1@113355"
        #Bước 3: Điều hướng sang trang quản lý người dùng
        And I navigate to user management page
        #Bước 4: Nhấn tab Bình luận trên khung menu trái.
        And I click comments tab in left menu
        #Bước 5: Xác minh rằng hệ thống điều hướng sang trang Bình luận.
        Then I will see the system redirect me to the "comment" page