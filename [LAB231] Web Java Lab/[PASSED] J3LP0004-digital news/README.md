# Requirement TuanVM

### Frontend
- Zoom ra vào không bị vỡ
- Để ý bố cục từ ngoài vào trong, từ trên xuống dưới, từ trái sang phải
- Background phải cùng màu với viền ngoài cùng
- Các trang có css khác nhau thì phải tách ra các file css khác nhau
- Các hình ảnh hiển thị không liên quan đến data thì phải để trong css không được để trong thẻ `img`
- Khi hiện ra list search phải để cho người dùng biết đang ở trang nào (in đậm hoặc thay màu khác)
- Không được load lại trang hiện tại khi ở trang list search

### Backend
- Khi search, lỗi,... phải có side bar
- Khi không nhập gì thì không được search
- Khi nào thì throws Exception, phải bắt exception
- Lỗi ở trong DAO thì phải throw ra Exception cụ thể để controller biết
- Không được nối chuỗi trong câu lệnh sql
- Ảnh sẽ được get bằng địa chỉ (lấy từ environment) + tên file ảnh (lấy từ database)
- Filter không cho người dùng vào trang jsp,  vào trang jsp nào thì cho phép vào Controller tương ứng

### Hỏi

- Tại sao phải check null trong hàm closeConnection?
```java
public void closeConnection(Connection con, PreparedStatement ps, ResultSet rs) throws SQLException {
        if (rs != null && !rs.isClosed()) {
            rs.close();
        }
        if (ps != null && !ps.isClosed()) {
            ps.close();
        }
        if (con != null && !con.isClosed()) {
            con.close();
        }
    }
```
- Ý nghĩa của box-shadow, rem,...
- Tại sao lại phải sử dụng `keyword = "%" + keyword + "%";` trong PrepareStatement
- Cách hoạt động của phân trang.

`Chú ý phải xóa những css thừa :'(`