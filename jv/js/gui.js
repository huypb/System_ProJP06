//Các xử lý cho GUI
var def ="-----từ khóa-----";
var emp ="";
function setKeyword(fn,isClick){
	// lấy giá trị trong ô nhập
	var value=fn.txtKeyword.value;
	
	//kiểm tra
	if(isClick){
		if(value==def){
			fn.txtKeyword.value=emp; //click vào thì mất chữ mặc định
		}
	}else{
		if(value==emp){
			fn.txtKeyword.value=def; // click ra ngoài thì hiện lại chữ mặc định
		}
	}
}
 
 // đặt chữ mặc định khi chưa click vào button
function setFirstTime(fn){
	fn.txtKeyword.value =def;
}

// bắt lỗi khi chưa nhập thông tin tìm kiếm mà ấn vào button
function checkKeyword(fn){
	var keyword=fn.txtKeyword.value;
	if(keyword==def || keyword==emp){
		window.alert('nhập vào từ khóa tìm kiếm');
		fn.txtKeyword.focus();
		fn.txtKeyword.value=emp;
	}

}