//các xử lý cho User;
function generatePermission(){
	var permis = new Array();
		permis[0] = "--chọn--";
		permis[1] = "Tác Giả";
		permis[2] = "Quản Lý";
		permis[3] = "Quản Trị";
		permis[4] = "Quản Trị Cấp Cao";
	
	var row = "<select name=\"slcUserPermis\" onChange=\"refreshPermis(this.form)\" >";
	for(var i=0; i<permis.length; i++){
		row += "<option value="+i+" >";
		row += permis[i];
		row += "</option>";
	
	}
		row += "</select>";
	
		document.write(row);
}

function generateRoles(){
	var roles = new Array();
	roles[0] = "Người sử dụng";
	roles[1] = "Chuyên mục";
	roles[2] = "Thể loại";
	roles[3] = "Tin tức, bài viết";
	roles[4] = "Hệ sản phẩm";
	roles[5] = "Nhóm sản phẩm";
	roles[6] = "Loại sản phẩm";
	roles[7] = "Sản phẩm";
	roles[8] = "Hóa đơn";
	roles[9] = "Khách hàng";
	
	var role = "";
	for(var i=0; i<roles.length; i++){
		if(i%3 == 0){
			role += "<tr>";
		}
		
		role += "<td>";
		role += "<input type=\"checkbox\" id=chk"+i+" disabled name=chks />";
		role += "<label for=chk"+i+" >";
		role += " Quản lý "+roles[i] ;
		role += "</label>";
		role += "</td>";
		
		
		if(i%3 == 2 || i==roles.length-1){
			role +="</tr>";
		}
	}
	
	document.write(role);	
}

function setCheckBox(fn, dis, check){
	for( var i=0;i<fn.elements.length; i++){
		if( fn.elements[i].type == "checkbox" &&
			fn.elements[i].name == "chks" ){
		
			fn.elements[i].disabled = dis;
			fn.elements[i].checked = check;
		
		}
	}
}

function refreshPermis(fn){
	var permis = parseInt(fn.slcUserPermis.value);  //chuyển đổi thành số nguyên
	if(permis==0){
		this.setCheckBox(fn, true, false);
	}else if(permis==1){
		this.setCheckBox(fn, false, false);
	}else if(permis==2){
		this.setCheckBox(fn, false, true);
	}else if(permis==3 || permis ==4){
		this.setCheckBox(fn, true, true);
	}

}


function resetForm(fn){
	fn.reset();
	fn.slcUserPermis.value = 0;
	this.setCheckBox(fn, true, false);
}

function checkUser(fn){
	//lấy dữ liệu
	var username = fn.txtUserName.value;
	var userpass = fn.txtUserPass.value;
	var useremail = fn.txtUserEmail.value;
	var userpermis = parseInt(fn.slcUserPermis.value);
	
	//xác định sự hợp lệ
	var validUserName = true;
	var validUserPass = true;
	var validUserPermis = true;
	var validUserEmail = true;
	
	//biến thông báo
	var message = "";
	
	//kiểm tra
	if(username==""){
		validUserName = false;
		message = "Thiếu tên đăng nhập cho tài khoản";
	}
	
	if(userpass==""){
		validUserPass = false;
		message += "\nThiếu mật khẩu";
	}else{
		if(userpass.length<6){
			validUserPass = false;
			message += "Mật khẩu không hợp lệ, quá ngắn.";
		}
	}
	
	if(useremail==""){
		validUserEmail = false;
		message +="\nThiếu hộp thư cho tài khoản.";
	}else{
		var parttern = /\w+@\w+[.]\w/; //mẫu email
		if(!useremail.match(parttern)){
			validUserEmail = false;
			message +="\nHộp thư không đúng định dạng hộp thư.";
		}
	}
	
	if(userpermis == 1 || userpermis == 2){
		for(var i=0; i<fn.elements.length; i++){
			if(fn.elements[i].type == "checkbox" &&
				fn.elements[i].name == "chks"){
				
				if(fn.elements[i].checked){
					validUserPermis = true;
					break;
				}else{
					validUserPermis = false;
				}
			}
		}
	}
	
	if(!validUserPermis){
		message += "\nCần phải có ít nhất 1 vai trò cho quyền này.";
	}
	
	//Thông báo
	if(message != ""){
		window.alert(message);
		
		if(!validUserName){
			fn.txtUserName.focus();
		}else if(!validUserPass){
			fn.txtUserPass.focus();
			fn.txtUserPass.select();
		}else if(!validUserEmail){
			fn.txtUserEmail.focus();
			fn.txtUserEmail.select();
		}else if(!validUserPermis){
			fn.slcUserPermis.focus();
		}
	}
	
	return validUserName && validUserPass && validUserEmail && validUserPermis;
}

function saveUser(fn){
	if(this.checkUser(fn)){
		fn.method = "POST";
		fn.action = "/adv/user/ae";
		fn.submit();
	}
}

function confirmDel(url){
	var message = "Bạn có chắc chắn xóa Người sử dụng này?";
	if(window.confirm(message)){
		window.location.href=url;
	}else{
		return false;
	}
}