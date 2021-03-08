
# `FPL@utoLMS - 10 Quiz 10 Point Easy!`

## `Cài đặt môi trường`
- Tổ hợp phím `Window`+`R`, nhập `cmd` nhấn `ENTER`.
- Trong cửa sổ `Command Prompt` nhập `java -version`.
- Hiện `java version XXX...` nghĩa là đã cài đặt môi trường thành công (bỏ qua bước cài đặt tiếp theo....)
- Nếu xuất hiện lỗi các bạn hãy cài đặt JDK ([Download JDK 1.8 64b](https://drive.google.com/file/d/1tlgwgwbLNqszE6DUCILPIRqrAaCrPvbe/view))
- Thực hiện lại bước 2, nếu không có lỗi là đã thành công!

## `Cách sử dụng`
- Xem clip hướng dẫn chi tiết: ([Xem hướng dẫn](https://www.youtube.com/watch?v=TYhdLhFD3j8&t=15s))

## `Lịch sử cập nhật`

### `v1.0.5`
- Update JHttp phiên bản mới nhất (v1.0.3)
- Thêm checkbox tự động bắt đầu quiz (Chỉ auto quiz).
- Thời gian submiting giảm xuống còn 1000milis

### `v1.0.4`
- Fix lỗi không qua được câu hỏi (prompt không hiện lại câu hỏi).

### `v1.0.3`
- Cập nhật lại full source (package `lms`, `lms.selenium`, `model`, etc...).
- Hiện thông báo những quiz hỗ trợ auto (`Quiz X (NOT SUPPORT)` là không hỗ trợ).
- fix vỡ layout khi chèn link thay vì dùng id (input quiz).
- fix vỡ layout khi có câu hỏi dài trong class `main.FormShow.java` (90%)

### `v1.0.2`
- Form main luôn đè lên tab khác
- Form đáp án luôn luôn đè lên tab khác.
- Cảnh báo khi chưa bắt đầu làm quiz
- Cảnh báo quiz đã làm rồi và không có quyền làm lại
- Cảnh báo quiz làm rồi nhưng có thể làm bài test mới
- Tự động làm quiz (Test) sử dụng selenium

### `v1.0.1`
- Tăng tốc độ quét answer base value nhanh gấp 10 lần v1.0.0 .
- Không load lại answer base value khi view lại quiz.
- fix lại validate input form.

### `v1.0.0`
- Phát hành thử nghiệm lần đầu tiên.