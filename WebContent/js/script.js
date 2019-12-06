// Include truYum form validation functions here

	function validate() {
		var nam = document.forms["form1"]["txtName"].value;
		var prc = document.forms["form1"]["number"].value;
		var dol= document.forms["form1"]["txtDate"].value;
		
		if(nam.trim()=="") {
			alert(" Name is required.");
			
		} else if( prc.trim()=="") {
			alert(" Price is required.");
			
		}else if(dol.trim()=="") {
			alert(" Date of Launch is required");
			return false;
		}else {
		 true;
		}
		
		if(/[^0-9\-\\/\/]/.test(dol)) {
			alert("Date is to be a number");
			return false;
		} else {
			true;
		}
		
		if(/[^0-9]/.test(prc)) {
			alert("Price is to be a number");
			return false;
		} else {
			true;
		}
		
		

		if(nam.length <2 || nam.length >65) {
			alert("Title should have 2-65 characters");
			return false; 
		} else {
			true;
		}
	}