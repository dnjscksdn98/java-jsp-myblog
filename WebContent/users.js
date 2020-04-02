function infoConfirm() {
	if(document.signupForm.id.value.length === 0){
		alert("Enter user ID.");
		signupForm.id.focus();
		return;
	}
	
	if(document.signupForm.id.value.length < 4){
		alert("Your ID must have at least 4 characters.");
		signupForm.id.focus();
		return;
	}
	
	if(document.signupForm.password.value.length === 0){
		alert("Enter password.");
		signupForm.password.focus();
		return;
	}
	
	if(document.signupForm.password.value !== document.signupForm.confirmPassword.value){
		alert("Passwords didn't match.");
		signupForm.password.focus();
		return;
	}
	
	if(document.signupForm.name.value.length === 0){
		alert("Enter your name.");
		signupForm.name.focus();
		return;
	}
	
	if(document.signupForm.email.value.length === 0){
		alert("Enter your email address.");
		signupForm.email.focus();
		return;
	}
	
	document.signupForm.submit();
}

function updateInfoConfirm() {
	if(document.updateForm.password.value.length === 0) {
		alert("Enter your password.");
		document.updateForm.password.focus();
		return;
	}
	
	if(document.updateForm.password.value !== document.updateForm.confirmPassword.value) {
		alert("Passwords doesn't match.");
		document.updateForm.password.focus();
		return;
	}
	
	if(document.updateForm.email.value.length === 0) {
		alert("Enter your email.");
		document.updateForm.email.focus();
		return;
	}
	
	document.updateForm.submit();	
}