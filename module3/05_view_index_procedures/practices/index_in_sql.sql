use classicmodels;

SELECT * FROM customers WHERE customerNumber = 175; 
/* 
MySQL biết rằng phải tìm ở bảng customres nhưng nó sẽ không biết bắt đầu từ đâu. Thậm chí nó cũng không biết trước rằng có bao nhiêu kết quả . Do đó nó sẽ duyệt qua tất cả danh sách (ví dụ hơn 500.000 khách hàng) để tìm thông tin về Julie King.

Index là 1 file riêng biệt được lưu trữ ở máy chủ và chỉ chứa những Fields mà bạn muốn nó chứa. Nếu bạn tạo 1 Index cho Field customerNumber (mã số khách hàng), MySQL sẽ dễ dàng tìm ra được mã số 1 cách nhanh chóng.
 Ví dụ như quyển sách, khi cần tìm 1 thông tin, ta thường lật ngay tới phần “Mục Lục” và tìm từ đó để tăng tốc độ tìm. Và việc tạo ra Index này sẽ làm bạn thấy Database của bạn chạy nhanh 1 cách khác thường.
 */
 
EXPLAIN SELECT * FROM customers WHERE customerNumber = 175;
 
ALTER TABLE customers ADD INDEX idx_customerNumber(customerNumber);

EXPLAIN SELECT * FROM customers WHERE customerNumber = 175;
 /*
table : Bảng nào đang liên quan đến output data
type : Đây là thông tin quan trọng, nó cho chúng ta biết kiểu query nào nó đang sử dụng. Mức độ từ tốt nhất đến chậm nhất như sau: system, const, eq_ref, ref, range, index, all
neu ko co primarykey: Nhìn lại câu query của chúng ta mới thật khủng khiếp. Không có Possible_keys nào được sử dụng, MySQL phải duyệt qua 17123 bản ghi mới tìm ra cái ta cần (Hãy tưởng tượng 1 Forum sẽ có đến hơn 500.000 bản ghi).

possible_keys : Đưa ra những Index có thể sử dụng để query
key : và Index nào đang được sử dụng
key_len : Chiều dài của từng mục trong Index
ref : Cột nào đang sử dụng
rows : Số hàng (rows) mà MySQL dự đoán phải tìm
extra : Thông tin phụ, thật tệ nếu tại cột này là “using temporary” hay “using filesort”

Tốt hơn nhiều rồi, kiểu TYPE = ref có nghĩa rằng MYSQL hiểu ra chỉ có 1 hàng đúng với ý ta, và thể hiện qua cột Rows = 1, kiểu key= idx_customerNumber được sử dụng và chiều dài key_len là 4.Chỉ tìm 1 hàng tất nhiên rằng tốt hơn nhiều so với tìm 17123 hàng.
 */
 
 EXPLAIN SELECT * FROM customers WHERE contactFirstName = 'Jean' or contactFirstName = 'King';
 /*
 type:all;possible_keys:null,key_len:null;ref:null;row:122;filtered"19.00;extra:using where
 */
 
 ALTER TABLE customers ADD INDEX idx_full_name(contactFirstName, contactLastName);
 EXPLAIN SELECT * FROM customers WHERE contactFirstName = 'Jean' or contactFirstName = 'King';
 /*
 Vậy câu hỏi đặt ra là, nếu tôi muốn thêm Index cho những cột mà có thể có nhiều hơn 1 kết quả khi query thì sao?
Bạn có thể Add index theo cặp như bạn add index cho cặp contactFirstName và contactLastName.
 */