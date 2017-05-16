//Các xử lý cho Login

function checkLogin(fn){
	//Lấy giá trị
	var username = fn.txtUserName.value;
	var userpass = fn.txtUserPass.value;
	
	//Xác định sự hợp lệ
	var validUserName = true;
	var validUserPass = true;
	
	//Biến thông báo
	var message = "";
	
	//Kiểm tra sự hợp lệ
	if(username==""){
		validUserName = false;
		message += "Thiếu tên đăng nhập hệ thống.";
	}
	
	if(userpass==""){
		validUserPass = false;
		message += "\nThiếu mật khẩu.";
	}else{
		if(userpass.length<6){
			validUserPass = false;
			message += "\nMật khẩu không hợp lệ, quá ngắn.";
		}
	}
	
	//Xuất thông báo
	if(message!=""){
		window.alert(message);
		if(!validUserName){
			fn.txtUserName.focus();
		}else if(!validUserPass){
			fn.txtUserPass.focus();
			fn.txtUserPass.select();
		}
	}
	
	
	return validUserName && validUserPass;
}

function login(fn){
	if(this.checkLogin(fn)){
		fn.method= "POST"; //goi vao doPOST
		fn.action = "/adv/user/login"; //duong dan servlet
		fn.submit(); //gui du lieu de xu ly
	}
}