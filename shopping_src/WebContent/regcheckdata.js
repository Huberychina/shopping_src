/**
 * 
 */
function checkdata(){

	var ssn = form.username.value.toLowerCase();
	if(!checkUserName(ssn)) return false; //用户名检查
	if(strlen(form.password.value)<6 || strlen(form.password.value)>16){
		alert("\正确的登录长度为6-16位");
		form.password.focus();
		return false;
	}
	
	return true;
}

function checkUserName(ssn){
	if(ssn.length<3||ssn.length>18){
		alert("\please input the right username,length between 3-18");
		form.username.focus();
		return false;
	}
	
	return true;
	
} 

