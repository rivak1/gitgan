class Validation {   
    validateName(name) {
        var filterName = new RegExp('\\d');
		if(name.length <= 2) {
			document.getElementById("input-filled").className = "form-control border border-danger";
		} else if(filterName.test(name)) {
			document.getElementById("input-filled").className = "form-control border border-danger";
		} else{
            document.getElementById("input-filled").className = "form-control border border-success";
            document.getElementById("label-filled").innerText = "Hello "+name+" Now tell me Your Email";
            document.getElementById("input-filled").value="";
		} 
    } 

    validateEmail(email) {
        var filterEmail = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
  		if (!filterEmail.test(email)) {
			document.getElementById("input-filled").className = "form-control border border-danger";
		} else {
            document.getElementById("input-filled").className = "form-control border border-success";
            document.getElementById("label-filled").innerText = "Very Nice.., Now share Your Contact Number";
            document.getElementById("input-filled").value="";
		}
    }
    
    validateContact(contact) {

        var filterContact = new RegExp('\\d');
		if(!(contact.length <= 10 && contact.length >= 8)) {
            document.getElementById("input-filled").className = "form-control border border-danger";
            alert(1)
		}else if(!filterContact.test(contact)) {
            document.getElementById("input-filled").className = "form-control border border-danger";
            alert(2)
		} else {
            document.getElementById("input-filled").className = "form-control border border-success";
            document.getElementById("label-filled").innerText = "good!.., for security choose good password which contain number alphabate";
            document.getElementById("input-filled").value="";
		}
    }

}

var count = 0;
function validateData() { 
    var formValue = document.getElementById("input-filled").value;
    var validationObj  = new Validation();
    if(count == 0) {
        validationObj.validateName(formValue);
        count=1;
        console.log("Name");
    } 

    else if(count == 1) {
        validationObj.validateEmail(formValue);
        count=2;
        console.log("Email");
    } 
    else if(count == 2) {
        validationObj.validateContact(formValue);
        count=4;
        console.log("Contact");
    } 
    else if(count == 4) {
        validationObj.validatePassword(formValue);
        count=5;
        console.log("password");
    }
 


}