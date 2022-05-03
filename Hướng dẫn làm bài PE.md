*Những file cần quan tâm trong 1 bài:* 
- File đề yêu cầu edit. 
- File Node.java để xem Node cần truyền vào cái gì
- File Đối tượng.java (E.g: Bee.java, Car.java) xem các đối tượng này lấy tham số theo thứ tự thế nào. 
**Q1** 
*Edit file MyList.java*. 
Bài này thường có 4 hàm f1, f2, f3, f4

Không cần quan tâm đến việc nó viết ra file.txt như thế nào. Chỉ cần viết hàm để xử lý List là được. 
- F1 không cần edit nhưng cần viết hàm gì đó trước f1. E.g: addLast, addFirst...
	- Các hàm này nên được viết thành 2 hàm như 
		- addLast(Person x): để sau này lỡ cần thì có thể dễ gọi lại. 
		- addLast(String xName, int Xage): Check điều kiện đầu đề (như Age > 5 ...) và gọi lại hàm trên để add.  
- F2, F3, F4 có thể là delete, add, sort, ... có điều kiện. Add cuối, đầu, giữa, add sau cái gì đó, sort theo khoảng, ...
	- Với mỗi F, viết các hàm con đầy đủ rồi chỉ việc gọi 1, 2 dòng trong hàm F. (Hạn chế việc viết code trực tiếp trong các hàm f2(), f3(), f4() để tránh xoá nhầm gì đó.)	


**Q2**
*Edit file BSTree.java*

**Q3** 
*Edit file Graph.java*