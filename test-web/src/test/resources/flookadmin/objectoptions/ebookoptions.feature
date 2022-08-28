#Các chức năng trên mỗi dòng dữ liệu Truyện.
Feature: Functions per ebook line

    #Xác minh rằng thông tin của Truyện được hiển thị đầy đủ trong bảng cập nhật truyện.
    @AdminWeb
    Scenario Outline: Verify that ebook information is fully displayed in the update panel
        #Bước 1: Mở website.
        Given I open the user website
        #Bước 2: Đăng nhập với tài khoản "huyhdang" và mật khẩu "Admin1@113355".
        When I login with the username "huyhdang" and the password "Admin1@113355"
        #Bước 3: Điều hướng sang trang quản lý sách.
        And I navigate to ebooks management page
        #Bước 4: Nhấn nút cập nhật truyện với tên truyện là "<ebookTitle>".
        And I click on the update button of the ebook "<ebookTitle>"
        #Bước 5: Xác minh rằng tên sách "<ebookTitle>", trạng thái "<status>", mô tả "<description>" được hiển thị trong khung cập nhật.
        Then I will see ebook tilte "<ebookTitle>", status "<status>" and description "<description>"
        #Bước 6: Nhấn nút tiếp tục.
        And I click on continue button
        #Bước 7: Xác minh rằng danh sách tác giả "<authors>" và danh sách thể loại "<genres>" được hiển thị trong khung cập nhật.
        Then I will see the authors "<authors>" and the genres "<genres>"
        #Bước 6: Nhấn nút tiếp tục.
        And I click on continue button
        #Bước 9: Xác minh rằng bìa sách được hiển thị với link ảnh là "<bookCoverLink>".
        Then I will see the book cover with the link "<bookCoverLink>"
        #Bước 10: Nhấn nút trở về.
        And I click on back button
        #Bước 11: Xác minh rằng danh sách tác giả "<authors>" và danh sách thể loại "<genres>" được hiển thị trong khung cập nhật.
        Then I will see the authors "<authors>" and the genres "<genres>"
        #Bước 10: Nhấn nút trở về.
        And I click on back button
        #Bước 5: Xác minh rằng tên sách "<ebookTitle>", trạng thái "<status>", mô tả "<description>" được hiển thị trong khung cập nhật.
        Then I will see ebook tilte "<ebookTitle>", status "<status>" and description "<description>"

        #Danh sách dữ liệu.
        Examples:
            |ebookTitle        |status       |description                     |authors         |genres                                        |bookCoverLink                   |
            |Anh Hùng, Hồi Quy |Đang cập nhật|Anh hùng mạnh nhất của nhân loại|Oda Eiichiro    |Action, Chuyển Sinh, Fantasy, Military        |anh-hung-hoi-quy-bg_pvswvl.jpg  |
            |Bắt Đầu Từ Độ Kiếp|Đang cập nhật|Truyện tranh bắt đầu từ độ kiếp |Takahashi Rumiko|Action, Huyền Huyễn, Chuyển Sinh, Ecchi, Harem|bat-dau-tu-do-kiep-bg_yquwgs.jpg|